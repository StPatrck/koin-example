package com.stpatrck.playground.koinexample.repos

import com.stpatrck.playground.koinexample.exceptions.RecordNotFoundException

interface LaunchRepository {

    fun getLaunches(): List<String>

    @Throws(RecordNotFoundException::class)
    fun getLaunch(identifier: String): String

}