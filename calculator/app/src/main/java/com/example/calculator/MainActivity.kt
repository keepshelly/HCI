package com.example.calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    private lateinit var tvdisplay: TextView
    private var input = "0"
    private var operator = ""
    private var firstnumber = 0.0
    private var secondnumber = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //нахожу по айди
        tvdisplay = findViewById(R.id.tvdisplay)
        //нахожу все кнопки и обрабатываю
        number()
        //кнопки операции
        operation()
        //кнопка С
        val btnclear: Button = findViewById(R.id.btnclear)
        btnclear.setOnClickListener {
            clear()
        }
        //кнопка равно
        val btnravno: Button = findViewById(R.id.btnravno)
        btnravno.setOnClickListener {
            result()
        }
    }
    //настраивание самих кнопок
    private fun number() {
        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )
        buttons.forEach { buttonId ->
            val button: Button = findViewById(buttonId)
            button.setOnClickListener {
                val number = (it as Button).text.toString()
                addnumber(number)
            }
        }
    }
    //привязка
    private fun operation() {
        val btnsum: Button = findViewById(R.id.btnsum)
        btnsum.setOnClickListener {
            setoperator("+")
        }
        val btnminus: Button = findViewById(R.id.btnminus)
        btnminus.setOnClickListener {
            setoperator("-")
        }
        val btnumnozh: Button = findViewById(R.id.btnumnozh)
        btnumnozh.setOnClickListener {
            setoperator("*")
        }
        val btndel: Button = findViewById(R.id.btndel)
        btndel.setOnClickListener {
            setoperator("/")
        }
    }
    //функци чтобы добавить цифру
    private fun addnumber(number: String) {
        if (input == "0") {
            input = number
        } else {
            input += number
        }
        display()
    }
    //ставлю операторов
    private fun setoperator(op: String) {
        if (operator.isEmpty()) {
            firstnumber = input.toDouble()
            operator = op
            input = "0"
            display()
        }
    }
    //вычисление
    private fun result() {
        if (operator.isNotEmpty()) {
            secondnumber = input.toDouble()
            var result = 0.0
            //кейсы для всех операторов, типо на выбор
            when (operator) {
                "+" -> result = firstnumber + secondnumber
                "-" -> result = firstnumber - secondnumber
                "*" -> result = firstnumber * secondnumber
                "/" -> {
                    if (secondnumber != 0.0) {
                        result = firstnumber / secondnumber
                    } else {
                        tvdisplay.text = "Ошибка"
                        return
                    }
                }
            }
            //отображаю
            input = if (result % 1 == 0.0) {
                result.toInt().toString()
            } else {
                result.toString()
            }
            operator = ""
            display()
        }
    }
    //очистка калькулятора
    private fun clear() {
        input = "0"
        operator = ""
        firstnumber = 0.0
        secondnumber = 0.0
        display()
    }
    //сделал функцию отображения
    private fun display() {
        tvdisplay.text = input
    }
}