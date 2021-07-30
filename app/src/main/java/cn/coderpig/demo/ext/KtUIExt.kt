package cn.coderpig.demo.ext

import android.content.res.AssetManager
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.RequiresApi

/**
 * Author: zpj
 * Date: 2021-07-30
 * Desc: KT UI相关扩展
 */
/*=== 无需传入context，无需在app中初始化，直接用  ===*/
val Float.dp: Float get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

val Int.dp: Int get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

val Float.sp: Float get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)

val Int.sp: Int get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()

/*=== 旧单位转换 ===*/
fun dp2px(dpValue: Float): Int = (PartnerKotlinExtKit.context.resources.displayMetrics.density * dpValue + 0.5f).toInt()

fun px2dp(pxValue: Float): Int = (PartnerKotlinExtKit.context.resources.displayMetrics.density / pxValue + 0.5f).toInt()

fun px2sp(pxValue: Float): Int = (PartnerKotlinExtKit.context.resources.displayMetrics.scaledDensity / pxValue + 0.5f).toInt()

fun sp2px(spValue: Float): Int = (PartnerKotlinExtKit.context.resources.displayMetrics.scaledDensity * spValue + 0.5f).toInt()

/*=== 弹Toast  ===*/
fun shortToast(msg: String) = Toast.makeText(PartnerKotlinExtKit.context, msg, Toast.LENGTH_SHORT).show()

fun longToast(msg: String) = Toast.makeText(PartnerKotlinExtKit.context, msg, Toast.LENGTH_LONG).show()

/*=== 获取屏幕宽高、分辨率 ===*/
fun getScreenWidth(): Int = PartnerKotlinExtKit.context.resources.displayMetrics.widthPixels

fun getScreenHeight(): Int = PartnerKotlinExtKit.context.resources.displayMetrics.heightPixels

fun getScreenDensity(): Float = PartnerKotlinExtKit.context.resources.displayMetrics.density

/*=== 获得各种资源 ===*/
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun getDrawableRes(resId: Int): Drawable = PartnerKotlinExtKit.context.resources.getDrawable(resId, null)

fun getDimensionPixelSizeRes(resId: Int) = PartnerKotlinExtKit.context.resources.getDimensionPixelSize(resId)

fun getDimensionRes(resId: Int) = PartnerKotlinExtKit.context.resources.getDimension(resId)

fun getBooleanRes(resId: Int) = PartnerKotlinExtKit.context.resources.getBoolean(resId)

fun getColorRes(resId: Int) = PartnerKotlinExtKit.context.resources.getColor(resId)

fun getTextRes(resId: Int): String = PartnerKotlinExtKit.context.resources.getString(resId)

fun getAssets(): AssetManager = PartnerKotlinExtKit.context.resources.assets
