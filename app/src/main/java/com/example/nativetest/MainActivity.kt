package com.example.nativetest

import android.os.Bundle
import android.os.Handler
import android.os.Looper

import android.view.View
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nativetest.adapters.CommentsAdapter
import com.example.nativetest.adapters.ImageAdapter
import com.example.nativetest.databinding.ActivityMainBinding
import com.example.nativetest.models.Comment


class MainActivity : ComponentActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var rvImageAdapter: ImageAdapter
    private lateinit var rvCommentAdapter: CommentsAdapter
    private lateinit var ImageList: ArrayList<Int>

    private lateinit var CommentsList: ArrayList<Comment>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()


        val lm: RecyclerView.LayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvImage.layoutManager = lm
        rvImageAdapter = ImageAdapter(this, ImageList)
        binding.rvImage.adapter = rvImageAdapter
        // setting recycle view adapter


        val lm1: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvComments.layoutManager = lm1
        rvCommentAdapter = CommentsAdapter(this, CommentsList)
        binding.rvComments.adapter = rvCommentAdapter

        binding.fab.setOnClickListener {


            binding.gifView.visibility = View.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed({

                binding.gifView.visibility = View.GONE

            }, 8000)


        }


    }


    private fun initialize() {
        ImageList = ArrayList(
            mutableListOf(
                R.drawable.k1,
                R.drawable.k2,
                R.drawable.k3,
                R.drawable.k4,
                R.drawable.k5,
                R.drawable.k6
            )
        )

        CommentsList = ArrayList()
        CommentsList.add(Comment("Thomas", "sent a gift to Tom", "@drawable/k1"))
        CommentsList.add(Comment("Thomas", "sent a gift to Jack", "@drawable/k2"))
        CommentsList.add(Comment("Thomas", "sent a gift to John", "@drawable/k3"))
        CommentsList.add(Comment("Thomas", "sent a gift to Don", "@drawable/k4"))
        CommentsList.add(Comment("Thomas", "sent a gift to Peter", "@drawable/k5"))
        CommentsList.add(Comment("Thomas", "sent a gift to Steffy", "@drawable/k6"))


    }


}
