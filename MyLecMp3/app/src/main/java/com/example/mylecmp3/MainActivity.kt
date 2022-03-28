package com.example.mylecmp3

import android.media.MediaParser
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer?=null
    var vol = 0.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLayout()
    }

    private fun initLayout(){
        val imageView= findViewById<VolumeControlView>(R.id.imageView)
        imageView.setVolumeListener(object:VolumeControlView.VolumeListener{
            override fun onChanged(angle:Float){
                vol = if(angle>0) {
                    angle / 260
                }else{
                    (360+angle)/360
                }
                mediaPlayer?.setVolume(vol, vol)
            }
        })

        val playBtn = findViewById<Button>(R.id.playBtn)
        playBtn.setOnClickListener{
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.song)
                mediaPlayer?.setVolume(vol, vol)
            }
            mediaPlayer?.start()
        }
        val pauseBtn = findViewById<Button>(R.id.pauseBtn)
        pauseBtn.setOnClickListener{
            mediaPlayer?.pause()

        }
        val stopBtn = findViewById<Button>(R.id.stopBtn)
        stopBtn.setOnClickListener{
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null

        }
    }
}

