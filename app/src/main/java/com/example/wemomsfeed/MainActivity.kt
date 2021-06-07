package com.example.wemomsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wemomsfeed.WeMomsPostGenerator
import com.example.wemomsfeed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val generator = WeMomsPostGenerator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = DataAdapter().apply {
            submitList(generator.newModels())
        }

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this)).apply {
            recyclerView.adapter = adapter
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    val layoutManager = recyclerView.layoutManager as? LinearLayoutManager ?: return
                    if (layoutManager.findLastVisibleItemPosition() == adapter.itemCount - 1) {
                        adapter.submitList(
                            adapter.currentList + generator.newModels()
                        )
                    }

                }
            })
        }

        setContentView(binding.root)
    }

}
