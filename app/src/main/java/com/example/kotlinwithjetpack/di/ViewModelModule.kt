package com.example.kotlinwithjetpack.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinwithjetpack.gaadi.ui.GaadiViewModel
import com.example.kotlinwithjetpack.legoset.ui.LegoSetViewModel
import com.example.kotlinwithjetpack.legoset.ui.LegoSetsViewModel
import com.example.kotlinwithjetpack.legotheme.ui.LegoThemeViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LegoThemeViewModel::class)
    abstract fun bindThemeViewModel(viewModel: LegoThemeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(LegoSetsViewModel::class)
    abstract fun bindLegoSetsViewModel(viewModel: LegoSetsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LegoSetViewModel::class)
    abstract fun bindLegoSetViewModel(viewModel: LegoSetViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GaadiViewModel::class)
    abstract fun bindGaadiViewModel(viewModel: GaadiViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
