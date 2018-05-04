package kr.hellodev.support.base.indicator

/**
 * @date 2018.05.03
 * @author Cura
 */
interface BaseIndicator<in VIEW : BaseView> {

    fun attachView(view: VIEW)
    fun detachView()
}