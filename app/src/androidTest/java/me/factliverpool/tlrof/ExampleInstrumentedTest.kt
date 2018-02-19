package me.factliverpool.tlrof

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import me.factliverpool.tlrof.app.home.HomeActivity
import org.junit.Rule
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<HomeActivity>(HomeActivity::class.java)




}
