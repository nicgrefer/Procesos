package com.example.ejem11_conectarconserversocket

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem11_conectarconserversocket.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var contador:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbConexion.max=20



        binding.bConectar.setOnClickListener { boton->
            CoroutineScope(Dispatchers.Main).launch {
                binding.sflShimmer.startShimmer()
                for (i in 1..20) {
                    binding.pbConexion.progress=i
                    binding.tvContador.text = contador.toString()
                    contador++
                    Log.d("Depurando","Contador: $contador")
                    delay(500)
                }
                binding.sflShimmer.stopShimmer()
                binding.sflShimmer.hideShimmer()
                binding.sflShimmer.visibility=android.view.View.GONE

                            }
        }



    }
}