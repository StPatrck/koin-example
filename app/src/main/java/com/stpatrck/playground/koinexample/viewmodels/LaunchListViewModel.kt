package com.stpatrck.playground.koinexample.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.stpatrck.playground.koinexample.exceptions.RecordNotFoundException
import com.stpatrck.playground.koinexample.repos.LaunchRepository

class LaunchListViewModel(private val launchRepo: LaunchRepository) : ViewModel() {

    fun getAllLaunches(): List<String> = launchRepo.getLaunches()

    fun getLaunchDetails(launchName: String): String {

        return try {
            launchRepo.getLaunch(launchName)
        } catch (e: RecordNotFoundException) {
            e.message!!
        } catch (e: Exception) {
            Log.e(
                "LaunchListViewModel",
                "Exception encountered while fetching launch details with name = [$launchName].",
                e
            )
            "Unknown error occurred. Try again."
        }
    }

}