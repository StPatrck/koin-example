package com.stpatrck.playground.koinexample.di.modules

import com.stpatrck.playground.koinexample.repos.LaunchRepoImpl
import com.stpatrck.playground.koinexample.repos.LaunchRepository
import org.koin.dsl.module

/**
 * A [module] providing dependencies held within application context.
 */
val appModule = module {
    single<LaunchRepository> { LaunchRepoImpl() }
}