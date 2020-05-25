package com.lukasanda.viewbindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lukasanda.viewbindingsample.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().replace(binding.container.id, ExampleFragment()).commit()
    }
}