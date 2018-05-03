package kr.hellodev.support.base.view

import android.os.Bundle
import kr.hellodev.support.base.indicator.BaseIndicator
import kr.hellodev.support.base.indicator.BaseView

/**
 * @date 2018.05.03
 * @author Cura
 */
abstract class BaseIndicatorActivity<in VIEW : BaseView, INSPECTOR : BaseIndicator<VIEW>> : BaseActivity(), BaseView {

    protected lateinit var inspector: INSPECTOR
        private set

    abstract fun onCreateInspector(): INSPECTOR

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inspector = onCreateInspector()
        inspector.attachView(this as VIEW)
    }

    override fun onDestroy() {
        super.onDestroy()
        inspector.detachView()
    }
}