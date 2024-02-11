package com.example.greekkino.utils.extensions

import androidx.lifecycle.MutableLiveData
import com.example.greekkino.ui.base.Event

typealias EventLiveData<T> = MutableLiveData<Event<T>>

fun <T> MutableLiveData<Event<T>>.postEvent(event: T) {
    postValue(Event(event))
}

fun <T> MutableLiveData<Event<T>>.setEvent(event: T) {
    value = Event(event)
}