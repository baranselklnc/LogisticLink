package com.example.logisticlink

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

object CustomToastManager {
    private var customToastHelper: CustomToastHelper? = null

    fun initialize(context: Context) {
        if (customToastHelper == null) {
            customToastHelper = CustomToastHelper(context)
        }
    }

    fun showCustomToast(context: Context, message: String) {
        customToastHelper?.showCustomToast(message)
    }
}

class CustomToastHelper(private val context: Context) {

    fun showCustomToast(message: String) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.special_toast, null)
        val text = layout.findViewById<TextView>(R.id.dispatchText)
        text.text = message

        val image = layout.findViewById<ImageView>(R.id.customImageView)

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}
