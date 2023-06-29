package com.sample.arch.presentation.core.common

interface ViewReducer<S : ViewState, I : ViewIntent> {

    fun reduce(viewState: S?, viewIntent: I): S?
}
