package com.example.greekkino.ui.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.greekkino.utils.extensions.observeEvent

abstract class BaseActivity<BaseBinding : ViewBinding, S : BaseState, E : BaseEvent, A : BaseAction> :
    AppCompatActivity() {

    val binding by this.doBinding()

//    @Inject
//    lateinit var moshi: Moshi

//    @EntryPoint
//    @InstallIn(SingletonComponent::class)
//    interface AppManagerEntryPoint {
//        val appManager: AppManager
//    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        provideViewModel().eventLiveData.observeEvent(this) { action ->
            onEvent(action)
        }

        provideViewModel().baseEventLiveData.observeEvent(this) { event ->
            onBaseEvent(event)
        }

        provideViewModel().viewStateLiveData.observe(this) { state ->
            render(state)
        }
    }

//    override fun attachBaseContext(newBase: Context?) {
//        newBase?.let {
//            val appManager = EntryPoints.get(newBase.applicationContext, AppManagerEntryPoint::class.java).appManager
//        } ?: super.attachBaseContext(newBase)
//    }

    private fun onBaseEvent(event: BaseEvent) = Unit


    abstract fun doBinding(): Lazy<BaseBinding>
    abstract fun provideViewModel(): BaseViewModel<S, E, A>
    abstract fun render(state: S)
    abstract fun onEvent(event: E)

    override fun onDestroy() {
        super.onDestroy()
    }
}