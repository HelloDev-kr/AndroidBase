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
abstract class BaseIndicatorFragment<in VIEW : BaseView, INDICATOR : BaseIndicator<VIEW>> : BaseFragment(), BaseView {

    protected lateinit var indicator: INDICATOR
        private set

    abstract fun onCreateIndicator(): INDICATOR

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        indicator = onCreateIndicator()
        indicator.attachView(this as VIEW)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        indicator.detachView()
    }
}