package com.stpatrck.playground.koinexample.viewmodels

import androidx.lifecycle.ViewModel
import com.stpatrck.playground.koinexample.repos.LaunchRepository

class LaunchListViewModel(private val launchRepo: LaunchRepository) : ViewModel() {

    fun getAllLaunches(): List<String> = launchRepo.getLaunches()

}