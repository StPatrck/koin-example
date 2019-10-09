package com.stpatrck.playground.koinexample.di.modules

import com.stpatrck.playground.koinexample.ui.launches.LaunchDetailsFragment
import com.stpatrck.playground.koinexample.ui.launches.LaunchListFragment
import com.stpatrck.playground.koinexample.viewmodels.LaunchDetailViewModel
import com.stpatrck.playground.koinexample.viewmodels.LaunchListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * A [module] providing dependencies for the Launches portion of the application.
 */
val launchesModule = module {

    // dependencies scoped to the LaunchListFragment
    scope(named<LaunchListFragment>()) {
        viewModel { LaunchListViewModel(get()) }
    }

    // dependencies scoped to the LaunchDetailsFragment
    scope(named<LaunchDetailsFragment>()) {
        viewModel { LaunchDetailViewModel(get()) }
    }
}