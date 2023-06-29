package com.sample.arch.presentation.core.common

import androidx.lifecycle.LiveData

interface ViewReducer<S : ViewState, I : ViewIntent> {

    fun reduce(viewState: LiveData<S>, viewIntent: I): S?
}
