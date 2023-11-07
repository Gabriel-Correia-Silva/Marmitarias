package com.example.projeto_final_mobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_final_mobile.ConteudoMarmitaria

class MyAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<MyViewHolder>() {

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_layout, parent, false)
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position]

        // Adiciona um OnClickListener
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ConteudoMarmitaria::class.java).apply {
                putExtra("ITEM_INDEX", position)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = myDataset.size
}