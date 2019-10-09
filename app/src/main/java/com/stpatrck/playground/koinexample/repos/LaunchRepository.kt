package com.stpatrck.playground.koinexample.repos

import com.stpatrck.playground.koinexample.exceptions.RecordNotFoundException

/**
 * Repository interface for interacting with Launch data.
 */
interface LaunchRepository {

    /**
     * Fetches a collection of known Launches.
     */
    fun getLaunches(): List<String>

    /**
     * Queries for details of a specific Launch with the given [identifier]
     *
     * @param identifier Unique identifier for a specific Launch.
     * @throws RecordNotFoundException when a matching Launch is not found.
     */
    @Throws(RecordNotFoundException::class)
    fun getLaunch(identifier: String): String

}