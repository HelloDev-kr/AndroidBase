package kr.hellodev.sample.indicator

import kr.hellodev.support.base.indicator.CommonIndicator

/**
 * @date 2018.05.03
 * @author Cura
 */
class MainIndicator : CommonIndicator<MainConstruct.View>(), MainConstruct.Indicator {

    override fun updateMessage() {
        view?.showMessage("MainIndicator example")
    }
}