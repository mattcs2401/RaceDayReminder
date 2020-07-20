package com.mcssoft.racedayreminder.common

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

/**
 * TBA . . .
 */
abstract class BaseViewModel(private val uiContext: Context) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = uiContext as CoroutineContext // TODO("Not yet implemented")

}