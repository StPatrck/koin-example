package com.stpatrck.playground.koinexample.repos

import com.stpatrck.playground.koinexample.exceptions.RecordNotFoundException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LaunchRepoImplTest {

    lateinit var launchRepo: LaunchRepoImpl

    @Before
    fun setUp() {
        launchRepo = LaunchRepoImpl()
    }

    @Test
    fun getLaunches_DoesReturnList() {
        val launches = launchRepo.getLaunches()
        assertTrue(launches.isNotEmpty())
    }

    @Test
    fun getLaunch_DoesIgnoreCase() {

        val launches = launchRepo.getLaunches()

        launches.forEach {
            assertEquals(it, launchRepo.getLaunch(it.toLowerCase()))
        }
    }

    @Test(expected = RecordNotFoundException::class)
    fun getLaunch_DoesThrowIfNotFound() {
        launchRepo.getLaunch("Invalid Identifier")
    }
}