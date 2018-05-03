package kr.hellodev.sample

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_main.*
import kr.hellodev.sample.indicator.MainConstruct
import kr.hellodev.sample.indicator.MainIndicator
import kr.hellodev.support.base.view.BaseIndicatorFragment

/**
 * @date 2018.05.03
 * @author Cura
 */
class MainFragment : BaseIndicatorFragment<MainConstruct.View, MainConstruct.Indicator>(), MainConstruct.View {

    override fun onCreateIndicator(): MainConstruct.Indicator = MainIndicator()

    override fun getLayoutResource(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        indicator.updateMessage()
    }

    override fun showMessage(message: String) {
        textView.text = message
    }
}