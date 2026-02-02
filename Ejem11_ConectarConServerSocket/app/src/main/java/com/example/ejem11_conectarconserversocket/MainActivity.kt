package com.example.ejem11_conectarconserversocket

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
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
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {
    private val ip = "172.26.8.7"
    lateinit var binding : ActivityMainBinding
    var contador:Int=0
    lateinit var oos: ObjectOutputStream

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbConexion.max=10


        binding.bConectar.setOnClickListener { boton->
            binding.sflShimmer.startShimmer()
            CoroutineScope(Dispatchers.Main).launch {
                for (i in 1..11) {
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
            var socket: Socket= Socket(ip,4444)
            var os:OutputStream = socket.getOutputStream()
            oos= ObjectOutputStream(os)
        }
        binding.bEnviar.setOnClickListener {
            oos.writeObject(Persona(binding.tietDatoEnviar.text.toString(),18))
        }

    }
}