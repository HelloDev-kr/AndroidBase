package kr.hellodev.support.base.view

import android.os.Bundle
import kr.hellodev.support.base.indicator.BaseIndicator
import kr.hellodev.support.base.indicator.BaseView

/**
 * @date 2018.05.03
 * @author Cura
 */
abstract class BaseIndicatorActivity<in VIEW : BaseView, INDICATOR : BaseIndicator<VIEW>> : BaseActivity(), BaseView {

    protected lateinit var indicator: INDICATOR
        private set

    abstract fun onCreateIndicator(): INDICATOR

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        indicator = onCreateIndicator()
        indicator.attachView(this as VIEW)
    }

    override fun onDestroy() {
        super.onDestroy()
        indicator.detachView()
    }
}