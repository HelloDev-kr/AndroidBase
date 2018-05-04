package kr.hellodev.support.base.utils

import android.content.Context
import android.graphics.Bitmap
import android.support.v8.renderscript.Allocation
import android.support.v8.renderscript.Element
import android.support.v8.renderscript.RenderScript
import android.support.v8.renderscript.ScriptIntrinsicBlur

/**
 * @date 2018.05.03
 * @author Cura
 */
fun Bitmap?.createBlurImage(context: Context, radius: Float = 25.0f): Bitmap? {
    return this?.let {
        createBlurImage(context, it.width / 2, it.height / 2, radius)
    }
}

fun Bitmap?.createBlurImage(context: Context, dstWidth: Int, dstHeight: Int, radius: Float = 25.0f): Bitmap? {
    return this?.let {
        val tempRadius = getRadius(radius)
        val bitmap: Bitmap = Bitmap.createScaledBitmap(this, dstWidth, dstHeight, false)
        val renderScript: RenderScript = RenderScript.create(context)
        val blurInput: Allocation = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT)
        val blurOutput: Allocation = Allocation.createTyped(renderScript, blurInput.type)
        val blur: ScriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

        // Set the radius of the Blur. Supported range 0 < radius <= 25
        blur.setRadius(tempRadius)
        blur.setInput(blurInput)
        blur.forEach(blurOutput)

        blurOutput.copyTo(bitmap)
        renderScript.destroy()

        return bitmap
    }
}

private fun getRadius(radius: Float): Float {
    if (radius < 0) {
        return 0f
    } else if (radius > 25.0f) {
        return 25.0f
    }

    return radius
}