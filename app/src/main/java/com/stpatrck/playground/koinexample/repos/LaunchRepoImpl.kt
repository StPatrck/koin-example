package com.stpatrck.playground.koinexample.repos

import com.stpatrck.playground.koinexample.exceptions.RecordNotFoundException

/**
 * Simple [LaunchRepository] that maintains a static list of launches
 */
class LaunchRepoImpl : LaunchRepository {
    override fun getLaunches(): List<String> {
        return listOf("Alpha", "Beta", "Charlie")
    }

    @Throws(RecordNotFoundException::class)
    override fun getLaunch(identifier: String): String {
        return getLaunches().find { it.equals(identifier, ignoreCase = true) }
            ?: throw RecordNotFoundException("No launch found with id = [$identifier]")
    }
}