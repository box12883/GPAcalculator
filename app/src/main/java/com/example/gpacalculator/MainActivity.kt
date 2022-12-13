package com.example.gpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.widget.Toast
import java.text.DecimalFormat
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ok.setOnClickListener{
            var sub1 = subject1.text.toString()
            var cre1 = credit1.text.toString()
            var poi1 = point1.text.toString()

            var sub2 = subject2.text.toString()
            var cre2 = credit2.text.toString()
            var poi2 = point2.text.toString()

            var sub3 = subject3.text.toString()
            var cre3 = credit3.text.toString()
            var poi3 = point3.text.toString()

            var sub4 = subject4.text.toString()
            var cre4 = credit4.text.toString()
            var poi4 = point4.text.toString()

            var sub5 = subject5.text.toString()
            var cre5 = credit5.text.toString()
            var poi5 = point5.text.toString()
            if (sub1 == "" || cre1 == ""|| poi1 == ""|| sub2 == "" || cre2 == ""|| poi2 == ""|| sub3 == "" || cre3 == ""|| poi3 == ""
                || sub4 == "" || cre4 == ""|| poi4 == ""|| sub5 == "" || cre5 == ""|| poi5 == "") {
                toast {
                    "Please Input All Text Box Before Press OK !!!"
                }
            } else if (cre1.toInt() > 3 || cre2.toInt() > 3 || cre3.toInt() > 3 || cre4.toInt() >3 || cre5.toInt() > 3){
                toast {
                    "Please Input Credit < 3 !!!"
                }
            } else{
                var sumcredit = cre1.toInt() + cre2.toInt() + cre3.toInt() + cre4.toInt() + cre5.toInt()
                totalcredits.setText("$sumcredit")
                var cxd1 = cre1.toDouble() * poi1.toDouble()
                var cxd2 = cre2.toDouble() * poi2.toDouble()
                var cxd3 = cre3.toDouble() * poi3.toDouble()
                var cxd4 = cre4.toDouble() * poi4.toDouble()
                var cxd5 = cre5.toDouble() * poi5.toDouble()
                var sumcxd = cxd1 + cxd2 + cxd3 + cxd4 + cxd5
                var grade = sumcxd / sumcredit
                val ss = "%.2f".format(grade)
                totalgpa.setText("$ss")

            }
        }
        clear.setOnClickListener {
            subject1.setText("")
            credit1.setText("")
            point1.setText("")

            subject2.setText("")
            credit2.setText("")
            point2.setText("")

            subject3.setText("")
            credit3.setText("")
            point3.setText("")

            subject4.setText("")
            credit4.setText("")
            point4.setText("")

            subject5.setText("")
            credit5.setText("")
            point5.setText("")
        }

    }
}
inline fun Context.toast(message:()->String){
    Toast.makeText(this, message() , Toast.LENGTH_LONG).show()
}