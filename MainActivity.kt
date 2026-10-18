package com.alpha.applock

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private val accessCode = "102030405060708090"
    private lateinit var root: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        showLock()
    }

    private fun showLock() {
        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(15, 17, 23))
        }
        val title = TextView(this).apply {
            text = "ALPHA APP LOCK"
            textSize = 27f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }
        val subtitle = TextView(this).apply {
            text = "أدخل رمز الدخول للمتابعة"
            textSize = 18f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 18, 0, 28)
        }
        val code = EditText(this).apply {
            hint = "رمز الدخول"
            setSingleLine(true)
            inputType = 2
            setTextColor(Color.WHITE)
            setHintTextColor(Color.GRAY)
            textSize = 18f
            gravity = Gravity.CENTER
            contentDescription = "رمز الدخول"
        }
        val message = TextView(this).apply {
            textSize = 16f
            gravity = Gravity.CENTER
            setTextColor(Color.RED)
            setPadding(0, 12, 0, 12)
        }
        val button = Button(this).apply { text = "فتح التطبيق" }
        button.setOnClickListener {
            if (code.text.toString() == accessCode) showUnlocked()
            else message.text = "الرمز غير صحيح، حاول مرة أخرى"
        }
        root.addView(title, matchWrap())
        root.addView(subtitle, matchWrap())
        root.addView(code, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        root.addView(message, matchWrap())
        root.addView(button, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        setContentView(root)
    }

    private fun showUnlocked() {
        root.removeAllViews()
        val text = TextView(this).apply {
            text = "تم فتح التطبيق\n\nمرحبًا بك في Alpha App Lock"
            textSize = 23f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
        }
        root.addView(text, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        val button = Button(this).apply { text = "قفل التطبيق" }
        button.setOnClickListener { showLock() }
        root.addView(button, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }

    private fun matchWrap() = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
}
