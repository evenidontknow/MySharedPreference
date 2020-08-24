package com.example.mysharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mysharepreference =
            getSharedPreferences("sharedpreference",
                Context.MODE_PRIVATE);

        val editor = mysharepreference.edit()

        btnSave.setOnClickListener {
            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val age = edtAge.text.toString().toInt()
            val male = checkMale.isChecked
            val female = checkFemale.isChecked

            editor.apply {
                putString("Name",name)
                putString("Email",email)
                putInt("Age",age)
                putBoolean("isMale",male)
                putBoolean("isFemale",female)
                apply()

                Toast.makeText(applicationContext,
                    "Data Saved",Toast.LENGTH_SHORT).show()
            }
        }

        btnLoad.setOnClickListener {
            val name = mysharepreference.getString("Name",null)
            val email = mysharepreference.getString("Email",null)
            val age = mysharepreference.getInt("Age",0)
            val male = mysharepreference.getBoolean("isMale",false)
            val female = mysharepreference.getBoolean("isFemale",false)

            edtName.setText(name)
            edtEmail.setText(email)
            edtAge.setText(age.toString())
            checkMale.isChecked = male
            checkFemale.isChecked = female
            Toast.makeText(applicationContext,
                "Data Loaded",Toast.LENGTH_SHORT).show()
        }


    }
}