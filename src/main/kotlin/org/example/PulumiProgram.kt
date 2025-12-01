package org.example

import com.pulumi.Context
import com.pulumi.github.Repository
import com.pulumi.github.RepositoryArgs

class PulumiProgram {

    fun program(ctx: Context) {
        Repository(
            "test-pulumi",
            RepositoryArgs.builder()
                .name("created-with-pulumi-3")
                .visibility("internal")
                .build()
        )
    }
}
