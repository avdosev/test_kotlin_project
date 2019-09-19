package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.firstproject.NumberConvertor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById<Button>(R.id.ShiftBtn)
        // set on-click listener
        btn_click_me.setOnClickListener {
            // your code to perform when the user clicks on the button
            val num = findViewById<EditText>(R.id.NumberInput).text.toString()
            val converted_num = NumberConvertor(num, NumberConvertor.Numbering.DEC).convert(NumberConvertor.Numbering.BIN) // ыыыы какая длинная строка
            this.showNumber(converted_num)
        }
    }

    fun showNumber(str: String) {
        val view = findViewById<TextView>(R.id.OutputView)
        view.text = str;
    }


}
