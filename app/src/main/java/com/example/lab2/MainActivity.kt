package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var checkBox:CheckBox
    private lateinit var switch: Switch
    private lateinit var buttonPressMe: Button
    private lateinit var textView: TextView
    private lateinit var edtextView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonPressMe=findViewById(R.id.buttonPressMe)
        textView=findViewById(R.id.textView)
        edtextView=findViewById(R.id.editText)
        checkBox = findViewById(R.id.checkbox)

        // Step 4
        buttonPressMe.setOnClickListener {
            val inputText = edtextView.text.toString()
            textView.text = inputText

            val toastMessage = resources.getString(R.string.toast_message)
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }

        // Step 5
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            val snackbarMessage = resources.getString(R.string.snackbar_message)
            val snackbarText = "$snackbarMessage ${if (isChecked) "on" else "off"}"

            val snackbar = Snackbar.make(buttonView, snackbarText, Snackbar.LENGTH_LONG)
            snackbar.setAction("Undo") {
                checkBox.isChecked = !isChecked
            }
            snackbar.show()
        }

    }
}