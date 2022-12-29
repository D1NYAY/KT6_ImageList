package com.example.kt6_imagelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kt6_imagelist.adapter.ImageAdapter
import com.example.kt6_imagelist.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var imageList : ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent.getIntegerArrayListExtra(MainActivity.SELECT_IMAGE)
        if (result != null) {
            imageList = result
        }

        val adapter = ImageAdapter(list = imageList , null , null)
        binding.recycler.layoutManager = GridLayoutManager(this , 3)
        binding.recycler.adapter = adapter
    }
}