package com.stpatrck.playground.koinexample.di.modules

import com.stpatrck.playground.koinexample.repos.LaunchRepoImpl
import com.stpatrck.playground.koinexample.repos.LaunchRepository
import com.stpatrck.playground.koinexample.ui.launches.LaunchDetailsFragment
import com.stpatrck.playground.koinexample.ui.launches.LaunchListFragment
import com.stpatrck.playground.koinexample.viewmodels.LaunchDetailViewModel
import com.stpatrck.playground.koinexample.viewmodels.LaunchListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val launchesModule = module {
    single<LaunchRepository> { LaunchRepoImpl() }

    scope(named<LaunchListFragment>()) {
        viewModel { LaunchListViewModel(get()) }
    }

    scope(named<LaunchDetailsFragment>()) {
        viewModel { LaunchDetailViewModel(get()) }
    }
}