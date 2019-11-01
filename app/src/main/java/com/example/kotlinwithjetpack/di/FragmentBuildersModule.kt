package com.example.kotlinwithjetpack.di


import com.example.kotlinwithjetpack.gaadi.ui.GaadiDetailFragment
import com.example.kotlinwithjetpack.gaadi.ui.GaadiListFragment
import com.example.kotlinwithjetpack.legoset.ui.LegoSetFragment
import com.example.kotlinwithjetpack.legoset.ui.LegoSetsFragment
import com.example.kotlinwithjetpack.legotheme.ui.LegoThemeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeThemeFragment(): LegoThemeFragment

    @ContributesAndroidInjector
    abstract fun contributeLegoSetsFragment(): LegoSetsFragment

    @ContributesAndroidInjector
    abstract fun contributeLegoSetFragment(): LegoSetFragment

    @ContributesAndroidInjector
    abstract fun contributeGaadiListFragment(): GaadiListFragment

    @ContributesAndroidInjector
    abstract fun contributeGaadiDetailsFragment(): GaadiDetailFragment
}
