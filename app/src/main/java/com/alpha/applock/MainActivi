
package com.alpha.applock

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val accessCode = "102030405060708090"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
        showLock()
    }

    private fun showLock() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(15, 17, 23))
        }

        val title = TextView(this).apply {
            text = "ALPHA APP LOCK"
            textSize = 26f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
        }

        val input = EditText(this).apply {
            hint = "أدخل رمز الدخول"
            inputType = 2
            setSingleLine(true)
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
        }

        val message = TextView(this).apply {
            gravity = Gravity.CENTER
            setTextColor(Color.RED)
        }

        val button = Button(this).apply {
            text = "فتح التطبيق"
        }

        layout.addView(title)
        layout.addView(input)
        layout.addView(message)
        layout.addView(button)

        button.setOnClickListener {
            if (input.text.toString() == accessCode) {
                layout.removeAllViews()
                layout.addView(TextView(this).apply {
                    text = "تم فتح التطبيق\nمرحبًا بك في Alpha App Lock"
                    textSize = 23f
                    gravity = Gravity.CENTER
                    setTextColor(Color.WHITE)
                })
            } else {
                message.text = "الرمز غير صحيح"
            }
        }

        setContentView(layout)
    }
}
