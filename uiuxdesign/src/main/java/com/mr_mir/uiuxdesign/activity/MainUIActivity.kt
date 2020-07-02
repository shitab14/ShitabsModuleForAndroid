package com.mr_mir.uiuxdesign.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.uiuxdesign.R
import com.mr_mir.uiuxdesign.adapter.PostAdapter
import com.mr_mir.uiuxdesign.adapter.StoryAdapter
import com.mr_mir.uiuxdesign.model.InstaPost
import kotlinx.android.synthetic.main.activity_ux_main.*

class MainUIActivity : AppCompatActivity() {

    private var storyAdapter: StoryAdapter? = null
    private var storyLayoutManager: LinearLayoutManager? = null
    private var storyList: ArrayList<Int>? = null
    private var postAdapter: PostAdapter? = null
    private var postLayoutManager: LinearLayoutManager? = null
    private var postList: ArrayList<InstaPost>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ux_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        populateStoryList()
        populatePostList()
    }

    private fun populateStoryList() {
        storyList = ArrayList()
        storyList?.add(R.drawable.ar)
        storyList?.add(R.drawable.arsh)
        storyList?.add(R.drawable.riz)
        storyList?.add(R.drawable.now)
        storyList?.add(R.drawable.gol)
        storyList?.add(R.drawable.profile_pic)
        storyList?.add(R.drawable.cap)

        storyAdapter = StoryAdapter(storyList!!,this)
        storyLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvStories.layoutManager = storyLayoutManager
        rvStories.adapter = storyAdapter
    }

    private fun populatePostList() {
        postList = ArrayList()
        postList?.add(InstaPost("@shitttman2therescue", "Dhaka, Bangladesh", R.drawable.profile_pic, R.drawable.cap))
        postList?.add(InstaPost("@shitttman2therescue", "Dhaka, Bangladesh", R.drawable.profile_pic, R.drawable.cap))
        postAdapter = PostAdapter(postList!!,this)
        postLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvPosts.layoutManager = postLayoutManager
        rvPosts.adapter = postAdapter
    }

}