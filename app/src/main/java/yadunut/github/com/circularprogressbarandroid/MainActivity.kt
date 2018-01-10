package yadunut.github.com.circularprogressbarandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import yadunut.github.com.circularprogressbar.CircleProgress
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var progressBar1: CircleProgress
    lateinit var progressBar2: CircleProgress

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar1 = findViewById(R.id.progress_bar_1)
        progressBar2 = findViewById(R.id.progress_bar_2)
        Timer().schedule(FunctionTask({
            progressBar1.progress += 1
            progressBar2.progress += 1
        }), 100L, 10L)

    }

    class FunctionTask(var function: () -> Unit) : TimerTask() {

        override fun run() {
            function()
        }

    }

}
