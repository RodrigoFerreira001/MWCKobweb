package dev.catbit.sample.di

import dev.catbit.sample.data.sources.ComponentsDataSource
import dev.catbit.sample.data.sources.ComponentsDataSourceImpl
import dev.catbit.sample.pages.components.ComponentsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object SampleModules {
    val modules by lazy {
        listOf(
            dataModule,
            viewModelModule
        )
    }

    private val dataModule = module {
        single<ComponentsDataSource> {
            ComponentsDataSourceImpl()
        }
    }

    private val viewModelModule = module {
        viewModel { (path: String) ->
            ComponentsViewModel(
                path = path,
                componentsDataSource = get()
            )
        }
    }
}