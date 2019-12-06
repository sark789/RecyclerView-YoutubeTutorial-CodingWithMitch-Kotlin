package com.timpolicar.recyclerviewtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecyclerAdapter // so we dont have to make it nullable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        //how to write it normally. But apply is better
                //recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
                //blogAdapter = BlogRecyclerAdapter()
                //recycler_view.adapter = blogAdapter

        //apply = makes us able to access recyclerview without having to write the id explicitly
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration) // with this we are setting the padding between cards
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
    }
}
