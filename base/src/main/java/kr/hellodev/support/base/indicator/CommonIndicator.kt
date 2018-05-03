package kr.hellodev.support.base.indicator

/**
 * @date 2018.05.03
 * @author Cura
 */
abstract class CommonIndicator<VIEW : BaseView> : BaseIndicator<VIEW> {

    protected var view: VIEW? = null
        private set

    override fun attachView(view: VIEW) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}