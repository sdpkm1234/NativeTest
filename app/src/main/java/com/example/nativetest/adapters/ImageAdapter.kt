package com.example.nativetest.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nativetest.R


class ImageAdapter(var context: Context, private var Image: ArrayList<Int>) :

    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_image_row, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // setting image resource
        viewHolder.imgview.setImageResource(Image[i])
    }

    override fun getItemCount(): Int {
        return Image.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgview: ImageView
        init {
            // getting ImageView reference
            imgview = itemView.findViewById<View>(R.id.imgView) as ImageView
        }
    }
}