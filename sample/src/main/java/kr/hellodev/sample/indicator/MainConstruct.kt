package kr.hellodev.sample.indicator

import kr.hellodev.support.base.indicator.BaseIndicator
import kr.hellodev.support.base.indicator.BaseView

/**
 * @date 2018.05.03
 * @author Cura
 */
interface MainConstruct {

    interface View : BaseView {
        fun showMessage(message: String)
    }

    interface Indicator : BaseIndicator<View> {
        fun updateMessage()
    }
}