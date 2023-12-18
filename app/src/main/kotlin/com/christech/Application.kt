package com.christech

import io.micronaut.context.env.Environment
import io.micronaut.runtime.Micronaut

object YourApplicationClass {
	@JvmStatic
	fun main(args: Array<String>) {
		Micronaut.build()
				.packages("com.christech") // Adjust the package name
				.environments(Environment.DEVELOPMENT)
				.start()
	}
}

