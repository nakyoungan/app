package com.example.middleterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class activity_btn1 : AppCompatActivity() {
    var data:ArrayList<MyData> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btn1)
        initData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = MyAdapter(data)
    }


    private fun initData() {
        data.add(MyData("item1", 10))
        data.add(MyData("item2", 10))
        data.add(MyData("item3", 10))
        data.add(MyData("item4", 10))
        data.add(MyData("item5", 10))
        data.add(MyData("item6", 10))
    }
}