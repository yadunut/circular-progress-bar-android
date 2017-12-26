package yadunut.github.com.circularprogressbarandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import yadunut.github.com.circularprogressbar.CircleProgress
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var progressBar: CircleProgress

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progress_bar)
        Timer().schedule(Test({progressBar.progress += 1}), 1000L, 10L)

    }

    class Test(var function: () -> Unit) : TimerTask() {

        override fun run() {
            function()
        }

    }

}
