package kr.hellodev.sample

import android.os.Bundle
import kr.hellodev.sample.indicator.MainIndicator
import kr.hellodev.support.base.utils.replaceFragment
import kr.hellodev.support.base.view.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        replaceFragment(R.id.frame_layout, mainFragment)

        MainIndicator().attachView(mainFragment)
    }
}
