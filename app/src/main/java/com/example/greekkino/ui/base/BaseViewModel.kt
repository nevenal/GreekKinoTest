package com.example.greekkino.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.greekkino.utils.extensions.EventLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.xml.transform.ErrorListener
import javax.xml.transform.TransformerException
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S : BaseState, E : BaseEvent, A : BaseAction> : ViewModel() {

    private val errorHandler = ExceptionHandler()
    protected var lastAction: A? = null

    protected val event = EventLiveData<E>()
    val eventLiveData: LiveData<Event<E>> = event

    protected val fragmentEvent = EventLiveData<E>()
    val fragmentEventLiveData: LiveData<Event<E>> = fragmentEvent

    protected val baseEvent = EventLiveData<BaseEvent>()
    val baseEventLiveData: LiveData<Event<BaseEvent>> = baseEvent

    protected val state = MutableLiveData<S>()
    val viewStateLiveData: LiveData<S> = state

    @CallSuper
    open fun executeAction(action: A) {
        lastAction = action
    }

    fun retryLastAction() {
        lastAction?.let {
            executeAction(it)
        } ?: reload()
    }

    protected open fun reload() = Unit

    open inner class ExceptionHandler : AbstractCoroutineContextElement(CoroutineExceptionHandler),
        CoroutineExceptionHandler,
        ErrorListener {

        override fun handleException(context: CoroutineContext, exception: Throwable) {
            Timber.d(exception)
        }

        override fun warning(p0: TransformerException?) = Unit

        override fun error(p0: TransformerException?) = Unit

        override fun fatalError(p0: TransformerException?) = Unit
    }

    protected fun CoroutineScope.launchWithErrorHandling(block: suspend CoroutineScope.() -> Unit): Job {
        return launch(errorHandler, block = block)
    }

    protected fun CoroutineScope.launchWithIgnoringError(block: suspend CoroutineScope.() -> Unit): Job {
        return launch(object : ExceptionHandler() {
        }, block = block)
    }
}
