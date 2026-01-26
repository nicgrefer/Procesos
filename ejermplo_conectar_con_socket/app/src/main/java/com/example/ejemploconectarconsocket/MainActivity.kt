package com.example.ejemploconectarconsocket

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemploconectarconsocket.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pbConexion.max = 20

        binding.bttConectar.setOnClickListener { boton ->

           CoroutineScope(Dispatchers.Main).launch {
               for (i in 1..20){
                   binding.pbConexion.progress = i
                   binding.tvContador.text=contador.toString()
                   contador++
                   delay(500)
               }
           }
        }

    }
}