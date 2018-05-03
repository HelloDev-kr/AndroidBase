package kr.hellodev.support.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.hellodev.support.base.indicator.BaseIndicator
import kr.hellodev.support.base.indicator.BaseView

/**
 * @date 2018.05.03
 * @author Cura
 */
abstract class BaseIndicatorFragment<in VIEW : BaseView, INSPECTOR : BaseIndicator<VIEW>> : BaseFragment(), BaseView {

    protected lateinit var inspector: INSPECTOR
        private set

    abstract fun onCreateInspector(): INSPECTOR

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inspector = onCreateInspector()
        inspector.attachView(this as VIEW)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        inspector.detachView()
    }
}