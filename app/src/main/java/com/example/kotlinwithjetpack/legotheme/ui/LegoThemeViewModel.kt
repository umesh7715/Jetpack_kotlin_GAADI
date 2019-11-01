

package com.example.kotlinwithjetpack.legotheme.ui

import androidx.lifecycle.ViewModel
import com.example.kotlinwithjetpack.legotheme.data.LegoThemeRepository
import javax.inject.Inject

/**
 * The ViewModel for [LegoThemeFragment].
 */
class LegoThemeViewModel @Inject constructor(repository: LegoThemeRepository) : ViewModel() {

    val legoThemes= repository.themes
}
