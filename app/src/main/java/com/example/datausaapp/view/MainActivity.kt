package com.example.datausaapp.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datausaapp.states.StatesFragment
import com.example.datausaapp.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setFragmentCity()
    }

    private fun setFragmentCity() {
        supportFragmentManager.beginTransaction().replace(R.id.container, StatesFragment()).commit()
    }

}
