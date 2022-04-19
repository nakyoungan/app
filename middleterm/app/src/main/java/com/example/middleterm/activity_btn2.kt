package com.example.middleterm

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    private fun callAlertDlg(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("반드시 CALL_PHONE 권한이 허용되어야 합니다.")
            .setTitle("권한 체크")
            .setPositiveButton("OK"){
                _,_->
                ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.CALL_PHONE), CALL_REQUEST)
            }
            .setNegativeButton("Cancel"){
                dlg,_->dlg.dismiss()
            }
    }

    private fun callAction(){
        val number = Uri.parse("tel:010-3375-4177")
        val callIntent = Intent(Intent.ACTION_CALL, number)
        when{
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                    ==PackageManager.PERMISSION_GRANTED ->{
                startActivity(callIntent)

                    }
            ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)
                    ->{
                        callAlertDlg()

                    }
            else ->{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), CALL_REQUEST)

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
                    callAction()
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
