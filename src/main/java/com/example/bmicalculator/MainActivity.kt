package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val userName : EditText = findViewById(R.id.et1)
        val age: EditText =findViewById(R.id.et2)
        val height: EditText =findViewById(R.id.et3)
        val weight: EditText = findViewById(R.id.et4)
        val btn: Button = findViewById(R.id.bt1)

        btn.setOnClickListener {
            val weightValue = weight.text.toString().toFloatOrNull()
            val heigthValue = height.text.toString().toFloatOrNull()


            if(heigthValue == null || weightValue == null){
                Toast.makeText(this,"Please enter a valid height and width.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val heigthInmeters =heigthValue/100
            val bmi = weightValue/(heigthInmeters*heigthInmeters)

            val msg= when{
                bmi<16.0 -> "You are *Severely* Underweight"
                bmi in 16.0..16.9 -> "You are *Moderately* Underweight"
                bmi in 17.0..18.4 -> "You are *Mildly* Underweight"
                bmi in 18.5..24.9-> "You are *Normal*."
                else -> "You are *Overweight*"
            }
            Toast.makeText(this,"Your BMI is : %.2f.\n%s".format(bmi,msg), Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}