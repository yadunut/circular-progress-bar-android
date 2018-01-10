package yadunut.github.com.circularprogressbar

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by yadunand on 24/12/17.
 */
class CircleProgress : View {
    val mContext: Context
    private var finishedPaint: Paint = Paint()
    private var unfinishedPaint: Paint = Paint()
    private var innerPaint: Paint = Paint()
    private var ringPaint: Paint = Paint()
    private var textPaint: Paint = Paint()

    var finishedPaintColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var unfinishedPaintColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var innerPaintColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var ringPaintColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    var finishedPaintWidth: Float = 0F
        set(value) {
            field = value
            invalidate()
        }
    var unfinishedPaintWidth: Float = 0F
        set(value) {
            field = value
            invalidate()
        }
    var ringPaintWidth: Float = 0F
        set(value) {
            field = value
            invalidate()
        }

    var max: Float = 100F
        set(value) {
            field = value
            invalidate()
        }
    var progress: Float = 0F
        set(value) {
            if (value > max) field = value % max
            else field = value
            invalidate()
        }
    var startAngle: Float = 0F
        set(value) {
            field = value
            invalidate()
        }

    val progressAngle: Float get() = progress / max * 360F

    var rect = RectF()
    var ringRect = RectF()

    var showText: Boolean = false
        set(value) {
            field = value
            invalidate()
        }

    var text: String? = null
        set(value) {
            field = value
            invalidate()
        }
    var textColor: Int = 0
        set(value) {
            field = value
            invalidate()
        }
    var textSize: Float = 0F
        set(value) {
            field = value
            invalidate()
        }

    constructor(mContext: Context) : this(mContext, null)
    constructor(mContext: Context, attrs: AttributeSet?) : this(mContext, attrs, 0)
    constructor(mContext: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(mContext, attrs, defStyleAttr, 0) {
        this.mContext = mContext

        val attributes = mContext.theme.obtainStyledAttributes(attrs, R.styleable.CircleProgress, defStyleAttr, 0)
        initVariables(attributes)
        attributes.recycle()

        initPaint()
    }

    private fun initVariables(attribues: TypedArray) {
        finishedPaintColor = attribues.getColor(R.styleable.CircleProgress_circle_finished_color, Color.BLUE)
        unfinishedPaintColor = attribues.getColor(R.styleable.CircleProgress_circle_unfinished_color, Color.GRAY)
        innerPaintColor = attribues.getColor(R.styleable.CircleProgress_circle_inner_color, Color.LTGRAY)
        ringPaintColor = attribues.getColor(R.styleable.CircleProgress_circle_ring_color, innerPaintColor)

        finishedPaintWidth = attribues.getDimension(R.styleable.CircleProgress_circle_finished_width, dp2px(resources, 10F))
        unfinishedPaintWidth = attribues.getDimension(R.styleable.CircleProgress_circle_unfinished_width, finishedPaintWidth)
        ringPaintWidth = attribues.getDimension(R.styleable.CircleProgress_circle_ring_width, 0F)

        max = attribues.getFloat(R.styleable.CircleProgress_circle_progress_max, 100F)
        progress = attribues.getFloat(R.styleable.CircleProgress_circle_progress, 0F)
        startAngle = attribues.getFloat(R.styleable.CircleProgress_circle_start_angle, 0F)
        showText = attribues.getBoolean(R.styleable.CircleProgress_circle_show_text, false)


        if (showText) {
            text = attribues.getString(R.styleable.CircleProgress_circle_text)
            textColor = attribues.getColor(R.styleable.CircleProgress_circle_text_color, finishedPaintColor)
            textSize = attribues.getDimension(R.styleable.CircleProgress_circle_text_size, sp2px(resources, 18F))
        }


    }

    private fun initPaint() {
        finishedPaint.color = finishedPaintColor
        finishedPaint.style = Paint.Style.STROKE
        finishedPaint.strokeWidth = finishedPaintWidth
        finishedPaint.isAntiAlias = true

        unfinishedPaint.color = unfinishedPaintColor
        unfinishedPaint.style = Paint.Style.STROKE
        unfinishedPaint.strokeWidth = unfinishedPaintWidth
        unfinishedPaint.isAntiAlias = true

        innerPaint.color = innerPaintColor
        innerPaint.style = Paint.Style.FILL
        unfinishedPaint.isAntiAlias = true

        ringPaint.color = ringPaintColor
        ringPaint.style = Paint.Style.STROKE
        ringPaint.strokeWidth = ringPaintWidth
        ringPaint.isAntiAlias = true

        if (showText) {
            textPaint.color = textColor
            textPaint.style = Paint.Style.FILL
            textPaint.textSize = textSize
            textPaint.textAlign = Paint.Align.CENTER
        }
    }

    override fun invalidate() {
        super.invalidate()
        initPaint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val delta = (Math.max(finishedPaintWidth, unfinishedPaintWidth) + ringPaintWidth) / 2
        val rpw = ringPaintWidth / 2
        val innerDiameter = width - delta * 2 - Math.min(finishedPaintWidth, unfinishedPaintWidth)

        rect.set(delta, height / 2 - width / 2 + delta, width - delta, height / 2 + width / 2 - delta)
        ringRect.set(rpw, height / 2 - width / 2 + rpw, width - rpw, height / 2 + width / 2 - rpw)

        canvas?.let {
            it.drawArc(ringRect, 0F, 360F, true, ringPaint)
            if (unfinishedPaintWidth > finishedPaintWidth) {
                if (progressAngle != 0F) it.drawArc(rect, startAngle, progressAngle, true, finishedPaint)
                it.drawArc(rect, startAngle + progressAngle, 360 - progressAngle, true, unfinishedPaint)
            } else {
                it.drawArc(rect, startAngle + progressAngle, 360 - progressAngle, true, unfinishedPaint)
                if (progressAngle != 0F) it.drawArc(rect, startAngle, progressAngle, true, finishedPaint)
            }
            it.drawCircle(width / 2F, height / 2F, innerDiameter / 2, innerPaint)

            if (showText) {
                var textVal = text
                if (text.isNullOrBlank()) textVal = "${progress}"
                val yPos = ((canvas.height / 2) - ((textPaint.descent() + textPaint.ascent()) / 2))
                canvas.drawText(textVal, width / 2F, yPos, textPaint)
            }
        }
    }


}