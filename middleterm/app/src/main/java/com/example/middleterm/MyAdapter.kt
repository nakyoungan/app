package com.example.middleterm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (val items:ArrayList<MyData>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textView5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //row.xml 파일을 인스턴스화 시켜줌
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].textString
        holder.textView.textSize = items[position].textPt.toFloat()
        //뷰홀더에 데이터 바인딩
    }

    override fun getItemCount(): Int {
        //데이터 개수 정보 반황
        return items.size
    }

}