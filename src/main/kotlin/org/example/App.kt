package org.example

import kotlin.system.exitProcess
import com.pulumi.automation.LocalWorkspace
import com.pulumi.automation.LocalWorkspaceOptions
import com.pulumi.automation.OperationType
import com.pulumi.automation.PreviewOptions
import com.pulumi.automation.RefreshOptions
import com.pulumi.automation.UpOptions
import kotlin.collections.forEach
import kotlin.io.println
import kotlin.to
import kotlin.use


object App {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val program = PulumiProgram()

            LocalWorkspace.createOrSelectStack(
                "inline_project_java", "my_stack", program::program,
                LocalWorkspaceOptions.builder()
                    .environmentVariables(
                        mapOf(
                            "PULUMI_BACKEND_URL" to "file:./pulumi_backend",
                            "PULUMI_CONFIG_PASSPHRASE" to "we-don't-care-about-encryption-here",
                            // Change this to "true" to re-create the error:
                            "PULUMI_RUN_PROGRAM" to "false",
                        ),
                    )
                    .build(),
            ).use { stack ->
                stack.refresh(
                    RefreshOptions.builder()
                        .onStandardOutput(::println)
                        .onStandardError(::println)
                        .build(),
                )
            }
        } catch (e: RuntimeException) {
            e.printStackTrace()
            exitProcess(1)
        }
    }
}
