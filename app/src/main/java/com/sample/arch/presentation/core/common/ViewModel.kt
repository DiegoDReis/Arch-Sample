package com.sample.arch.presentation.core.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class ViewModel<S : ViewState, I : ViewIntent>(
    viewState: S,
    viewReducer: ViewReducer<S, I>
) : ViewModel() {

    private val reducer: ViewReducer<S, I> = viewReducer
    private val _state: MutableLiveData<S> = MutableLiveData(viewState)
    open val state: LiveData<S> = _state

    fun reduce(viewIntent: I) {
        _state.value = reducer.reduce(state, viewIntent)
    }
}
