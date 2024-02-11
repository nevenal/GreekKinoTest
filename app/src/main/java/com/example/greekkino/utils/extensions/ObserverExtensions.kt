package com.example.greekkino.utils.extensions

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.greekkino.ui.base.Event
import com.example.greekkino.ui.base.EventObserver

@MainThread
inline fun <T> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
): Observer<Event<T>> {
    val wrappedObserver = EventObserver<T> { value ->
        onChanged.invoke(value)
    }
    observe(owner, wrappedObserver)
    return wrappedObserver
}