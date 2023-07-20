package com.sample.core.common.presentation

interface ViewReducer<S : ViewState, I : ViewIntent> {

    fun reduce(viewState: S?, viewIntent: I): S?
}
