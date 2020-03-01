package es.dmoral.toasty.toasty

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.*
import es.dmoral.toasty.R
import es.dmoral.toasty.toasty.ToastyUtils.getColor
import es.dmoral.toasty.toasty.ToastyUtils.getDrawable
import es.dmoral.toasty.toasty.ToastyUtils.setBackground
import es.dmoral.toasty.toasty.ToastyUtils.tint9PatchDrawableFrame
import es.dmoral.toasty.toasty.ToastyUtils.tintIcon

/**
 * This file is part of Toasty.
 *
 *
 * Toasty is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *
 * Toasty is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *
 * You should have received a copy of the GNU General Public License
 * along with Toasty.  If not, see <http:></http:>//www.gnu.org/licenses/>.
 */
object Toasty {
    private val LOADED_TOAST_TYPEFACE =
        Typeface.create("sans-serif-condensed", Typeface.NORMAL)
    private var currentTypeface =
        LOADED_TOAST_TYPEFACE
    private var textSize = 16 // in SP
    private var tintIcon = true
    private var allowQueue = true
    private var lastToast: Toast? = null
    const val LENGTH_SHORT = Toast.LENGTH_SHORT
    const val LENGTH_LONG = Toast.LENGTH_LONG
    @CheckResult
    fun normal(context: Context, @StringRes message: Int): Toast {
        return normal(
            context,
            context.getString(message),
            Toast.LENGTH_SHORT,
            null,
            false
        )
    }

    @CheckResult
    fun normal(
        context: Context,
        message: CharSequence
    ): Toast {
        return normal(
            context,
            message,
            Toast.LENGTH_SHORT,
            null,
            false
        )
    }

    @CheckResult
    fun normal(
        context: Context, @StringRes message: Int,
        icon: Drawable?
    ): Toast {
        return normal(
            context,
            context.getString(message),
            Toast.LENGTH_SHORT,
            icon,
            true
        )
    }

    @CheckResult
    fun normal(
        context: Context,
        message: CharSequence,
        icon: Drawable?
    ): Toast {
        return normal(
            context,
            message,
            Toast.LENGTH_SHORT,
            icon,
            true
        )
    }

    @CheckResult
    fun normal(
        context: Context, @StringRes message: Int,
        duration: Int
    ): Toast {
        return normal(
            context,
            context.getString(message),
            duration,
            null,
            false
        )
    }

    @CheckResult
    fun normal(
        context: Context,
        message: CharSequence,
        duration: Int
    ): Toast {
        return normal(
            context,
            message,
            duration,
            null,
            false
        )
    }

    @CheckResult
    fun normal(
        context: Context, @StringRes message: Int, duration: Int,
        icon: Drawable?
    ): Toast {
        return normal(
            context,
            context.getString(message),
            duration,
            icon,
            true
        )
    }

    @CheckResult
    fun normal(
        context: Context, message: CharSequence, duration: Int,
        icon: Drawable?
    ): Toast {
        return normal(
            context,
            message,
            duration,
            icon,
            true
        )
    }

    @CheckResult
    fun normal(
        context: Context, @StringRes message: Int, duration: Int,
        icon: Drawable?, withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            icon,
            getColor(context, R.color.normalColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun normal(
        context: Context, message: CharSequence, duration: Int,
        icon: Drawable?, withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            icon,
            getColor(context, R.color.normalColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun warning(context: Context, @StringRes message: Int): Toast {
        return warning(
            context,
            context.getString(message),
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun warning(
        context: Context,
        message: CharSequence
    ): Toast {
        return warning(
            context,
            message,
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun warning(
        context: Context, @StringRes message: Int,
        duration: Int
    ): Toast {
        return warning(
            context,
            context.getString(message),
            duration,
            true
        )
    }

    @CheckResult
    fun warning(
        context: Context,
        message: CharSequence,
        duration: Int
    ): Toast {
        return warning(
            context,
            message,
            duration,
            true
        )
    }

    @CheckResult
    fun warning(
        context: Context, @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            getDrawable(
                context,
                R.drawable.ic_error_outline_white_24dp
            ),
            getColor(context, R.color.warningColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun warning(
        context: Context,
        message: CharSequence,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            getDrawable(
                context,
                R.drawable.ic_error_outline_white_24dp
            ),
            getColor(context, R.color.warningColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun info(context: Context, @StringRes message: Int): Toast {
        return info(
            context,
            context.getString(message),
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun info(context: Context, message: CharSequence): Toast {
        return info(
            context,
            message,
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun info(
        context: Context, @StringRes message: Int,
        duration: Int
    ): Toast {
        return info(
            context,
            context.getString(message),
            duration,
            true
        )
    }

    @CheckResult
    fun info(
        context: Context,
        message: CharSequence,
        duration: Int
    ): Toast {
        return info(
            context,
            message,
            duration,
            true
        )
    }

    @CheckResult
    fun info(
        context: Context, @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            getDrawable(
                context,
                R.drawable.ic_info_outline_white_24dp
            ),
            getColor(context, R.color.infoColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun info(
        context: Context,
        message: CharSequence,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            getDrawable(
                context,
                R.drawable.ic_info_outline_white_24dp
            ),
            getColor(context, R.color.infoColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun success(context: Context, @StringRes message: Int): Toast {
        return success(
            context,
            context.getString(message),
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun success(
        context: Context,
        message: CharSequence
    ): Toast {
        return success(
            context,
            message,
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun success(
        context: Context, @StringRes message: Int,
        duration: Int
    ): Toast {
        return success(
            context,
            context.getString(message),
            duration,
            true
        )
    }

    @CheckResult
    fun success(
        context: Context,
        message: CharSequence,
        duration: Int
    ): Toast {
        return success(
            context,
            message,
            duration,
            true
        )
    }

    @CheckResult
    fun success(
        context: Context, @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            getDrawable(
                context,
                R.drawable.ic_check_white_24dp
            ),
            getColor(context, R.color.successColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun success(
        context: Context,
        message: CharSequence,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            getDrawable(
                context,
                R.drawable.ic_check_white_24dp
            ),
            getColor(context, R.color.successColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun error(context: Context, @StringRes message: Int): Toast {
        return error(
            context,
            context.getString(message),
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun error(
        context: Context,
        message: CharSequence
    ): Toast {
        return error(
            context,
            message,
            Toast.LENGTH_SHORT,
            true
        )
    }

    @CheckResult
    fun error(
        context: Context, @StringRes message: Int,
        duration: Int
    ): Toast {
        return error(
            context,
            context.getString(message),
            duration,
            true
        )
    }

    @CheckResult
    fun error(
        context: Context,
        message: CharSequence,
        duration: Int
    ): Toast {
        return error(
            context,
            message,
            duration,
            true
        )
    }

    @CheckResult
    fun error(
        context: Context, @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            getDrawable(
                context,
                R.drawable.ic_clear_white_24dp
            ),
            getColor(context, R.color.errorColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun error(
        context: Context,
        message: CharSequence,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            getDrawable(
                context,
                R.drawable.ic_clear_white_24dp
            ),
            getColor(context, R.color.errorColor),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun custom(
        context: Context, @StringRes message: Int,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            icon,
            -1,
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            false
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            message,
            icon,
            -1,
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            false
        )
    }

    @CheckResult
    fun custom(
        context: Context, @StringRes message: Int, @DrawableRes iconRes: Int,
        @ColorRes tintColorRes: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            getDrawable(context, iconRes),
            getColor(context, tintColorRes),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            shouldTint
        )
    }

    @CheckResult
    fun custom(
        context: Context, message: CharSequence, @DrawableRes iconRes: Int,
        @ColorRes tintColorRes: Int, duration: Int,
        withIcon: Boolean, shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            message,
            getDrawable(context, iconRes),
            getColor(context, tintColorRes),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            shouldTint
        )
    }

    @CheckResult
    fun custom(
        context: Context, @StringRes message: Int,
        icon: Drawable?,
        @ColorRes tintColorRes: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            icon,
            getColor(context, tintColorRes),
            getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            shouldTint
        )
    }

    @CheckResult
    fun custom(
        context: Context, @StringRes message: Int,
        icon: Drawable?,
        @ColorRes tintColorRes: Int, @ColorRes textColorRes: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        return custom(
            context, context.getString(message), icon, getColor(context, tintColorRes),
            getColor(context, textColorRes), duration, withIcon, shouldTint
        )
    }

    @SuppressLint("ShowToast")
    @CheckResult
    fun custom(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        @ColorInt tintColor: Int, @ColorInt textColor: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        val currentToast =
            Toast.makeText(context, "", duration)
        val toastLayout =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.toast_layout, null)
        val toastIcon =
            toastLayout.findViewById<ImageView>(R.id.toast_icon)
        val toastTextView =
            toastLayout.findViewById<TextView>(R.id.toast_text)
        val drawableFrame: Drawable?
        drawableFrame =
            if (shouldTint) tint9PatchDrawableFrame(context, tintColor) else getDrawable(
                context,
                R.drawable.toast_frame
            )
        setBackground(toastLayout, drawableFrame)
        if (withIcon) {
            requireNotNull(icon) { "Avoid passing 'icon' as null if 'withIcon' is set to true" }
            setBackground(
                toastIcon,
                if (tintIcon) tintIcon(icon, textColor) else icon
            )
        } else {
            toastIcon.visibility = View.GONE
        }
        toastTextView.text = message
        toastTextView.setTextColor(textColor)
        toastTextView.typeface = currentTypeface
        toastTextView.setTextSize(
            TypedValue.COMPLEX_UNIT_SP,
            textSize.toFloat()
        )
        currentToast.view = toastLayout
        if (!allowQueue) {
            if (lastToast != null) lastToast!!.cancel()
            lastToast = currentToast
        }
        return currentToast
    }

    class Config private constructor() {
        private var typeface = currentTypeface
        private var textSize = Toasty.textSize
        private var tintIcon = Toasty.tintIcon
        private var allowQueue = true
        @CheckResult
        fun setToastTypeface(typeface: Typeface): Config {
            this.typeface = typeface
            return this
        }

        @CheckResult
        fun setTextSize(sizeInSp: Int): Config {
            this.textSize = sizeInSp
            return this
        }

        @CheckResult
        fun tintIcon(tintIcon: Boolean): Config {
            this.tintIcon = tintIcon
            return this
        }

        @CheckResult
        fun allowQueue(allowQueue: Boolean): Config {
            this.allowQueue = allowQueue
            return this
        }

        fun apply() {
            currentTypeface = typeface
            Toasty.textSize = textSize
            Toasty.tintIcon = tintIcon
            Toasty.allowQueue = allowQueue
        }

        companion object {
            @get:CheckResult
            val instance: Config
                get() = Config()

            fun reset() {
                currentTypeface =
                    LOADED_TOAST_TYPEFACE
                textSize = 16
                tintIcon = true
                allowQueue = true
            }
        }
    }
}