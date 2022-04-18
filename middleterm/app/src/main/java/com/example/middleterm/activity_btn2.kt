package com.example.middleterm

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.middleterm.databinding.ActivityBtn2Binding
import com.example.middleterm.databinding.ActivityMainBinding

class activity_btn2 : AppCompatActivity() {
    lateinit var binding: ActivityBtn2Binding
    val CALL_REQUEST = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBtn2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun callAction(){
        val number = Uri.parse("tel:010-3375-4177")
        val callIntent = Intent(Intent.ACTION_CALL, number)
        startActivity(callIntent)
        when{
            ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    ==PackageManager.PERMISSION_GRANTED ->{

                    }
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)
                    ->{
                    }
            else ->{
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), CALL_REQUEST)

            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CALL_REQUEST->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"권한 승인", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "권한 승인이 거부되었습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun initLayout() {
        binding.name.setOnClickListener { //객체 엑세스
            callAction()
        //눌렀을때 수행하는 것들, 전화걸기
        }
    }
}