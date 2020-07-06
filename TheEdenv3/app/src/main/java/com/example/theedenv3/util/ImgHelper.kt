import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

object ImgHelper {
    fun getBitmapFormResources(context: Context, resId: Int): Bitmap {
        return BitmapFactory.decodeResource(context.resources, resId)
    }

    fun getDrawableFromResources(
        context: Context,
        resId: Int
    ): Drawable {
        return context.resources.getDrawable(resId)
    }

    fun getDrawbleFormBitmap(
        context: Context,
        bitmap: Bitmap?
    ): Drawable {
        return BitmapDrawable(context.resources, bitmap)
    }

    fun getBitmapFormDrawable(
        context: Context?,
        drawable: Drawable
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            if (drawable.opacity != PixelFormat.OPAQUE) Bitmap.Config.ARGB_8888 else Bitmap.Config.RGB_565
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        //设置绘画的边界，此处表示完整绘制
        drawable.draw(canvas)
        return bitmap
    }
}