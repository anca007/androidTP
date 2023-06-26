package com.example.mod6tp1

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.mod6tp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        isGranted ->
        if(isGranted){
            //Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: ${binding.etPhone.text}?body=Rappelle-moi!" ))
            Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: ${binding.etPhone.text}" )).also {
                it.putExtra("sms_body", "Rappelle-moi !")
                startActivity(it)
            }
        }else{
            Toast.makeText(this, "T'es une enclume (dixit JPP)", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)
        }


    }
}