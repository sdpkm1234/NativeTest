package com.example.nativetest.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nativetest.R
import com.example.nativetest.models.Comment


class CommentsAdapter(var context: Context, private var Comment: ArrayList<Comment>) :

    RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_comment_row, viewGroup, false)
        return ViewHolder(v)
    }

    @SuppressLint("UseCompatLoadingForDrawables", "DiscouragedApi")
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // setting image resource
        val uri=Comment[i].img

        val imageResource: Int = context.resources.getIdentifier(uri, null, context.getPackageName())
        val res: Drawable = context.resources.getDrawable(imageResource)
        viewHolder.imgview.setImageDrawable(res)
        viewHolder.name.text=Comment[i].name
        viewHolder.desc.text=Comment[i].desc


    }

    override fun getItemCount(): Int {
        return Comment.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgview: ImageView
        var name: TextView
        var desc: TextView
        init {
            // getting ImageView reference
            imgview = itemView.findViewById<View>(R.id.imgView) as ImageView
            name = itemView.findViewById<View>(R.id.name) as TextView
            desc = itemView.findViewById<View>(R.id.desc) as TextView
        }
    }
}