package yadunut.github.com.circularprogressbar

import android.content.res.Resources

/**
 * Created by yadunand on 24/12/17.
 */

fun dp2px(resources: Resources, dp: Float): Float = dp * resources.displayMetrics.density + 0.5F

fun sp2px(resources: Resources, sp: Float): Float = sp * resources.displayMetrics.scaledDensity
