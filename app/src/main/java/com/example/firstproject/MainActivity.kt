package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.firstproject.NumberConvertor
import androidx.appcompat.app.AlertDialog
import kotlin.text.Regex

class MainActivity : AppCompatActivity() {

    val STATE_OUTPUT_VIEW = "OUTPUT_VIEW_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ShiftToBinaryBtn = findViewById<Button>(R.id.ShiftToBinaryBtn)
        // set on-click listener
        ShiftToBinaryBtn.setOnClickListener {
            // your code to perform when the user clicks on the button
            val num = findViewById<EditText>(R.id.NumberInput).text.toString()
            val converted_num = NumberConvertor(num, NumberConvertor.Numbering.DEC).convert(NumberConvertor.Numbering.BIN) // ыыыы какая длинная строка
            this.showNumber(converted_num)
        }

        val ShiftToDecimalBtn = findViewById<Button>(R.id.ShiftToDecimalBtn)
        ShiftToDecimalBtn.setOnClickListener {
            val num = findViewById<EditText>(R.id.NumberInput).text.toString()
            val reg = Regex("^[1,0]+\$")
            if (reg.matches(num)) {
                val converted_num = NumberConvertor(num, NumberConvertor.Numbering.BIN).convert(NumberConvertor.Numbering.DEC) // ыыыы какая длинная строка
                this.showNumber(converted_num)
            } else {
                this.showErrorMessage("Для бинарной строки нужны только нолики и еденички")
            }

        }
    }

    fun showErrorMessage(message:String?, title:String?="Ошибка") {
        val alertDialogBuilder = AlertDialog.Builder(this)
        with(alertDialogBuilder) {
            setTitle(title)
            setMessage(message)
            setPositiveButton(
                android.R.string.yes
            ) { dialog, _ -> dialog.cancel() }
            alertDialogBuilder.show()
        }
    }

    fun showNumber(str: String) {
        val view = findViewById<TextView>(R.id.OutputView)
        view.text = str;
    }

    override fun onSaveInstanceState(saveInstanceState: Bundle) {
        // получаем ссылку на текстовую метку
        val myTextView =findViewById<TextView>(R.id.OutputView)

        // Сохраняем его состояние
        saveInstanceState.putString(STATE_OUTPUT_VIEW, myTextView.text.toString())

        // всегда вызывайте суперкласс для сохранения состояний видов
        super.onSaveInstanceState(saveInstanceState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState)

        // Сохраняем его состояние
        val savedNumber = savedInstanceState.getString(STATE_OUTPUT_VIEW)
        this.showNumber(savedNumber!!)
    }


}
