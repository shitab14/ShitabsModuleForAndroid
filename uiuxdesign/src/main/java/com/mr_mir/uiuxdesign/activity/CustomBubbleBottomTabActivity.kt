package com.mr_mir.uiuxdesign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mr_mir.uiuxdesign.R
import kotlinx.android.synthetic.main.activity_custom_bubble_bottom_tab.*

class CustomBubbleBottomTabActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_bubble_bottom_tab)

        setListeners()
    }

    private fun setListeners() {
        llHomeTab.setOnClickListener(this)
        llLiveTvTab.setOnClickListener(this)
        llPlaylistTab.setOnClickListener(this)
        llSettingsTab.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.llHomeTab -> {
                circleVisibility(0, 4, 4, 4)
            }
            R.id.llLiveTvTab -> {
                circleVisibility(4, 0, 4, 4)
            }
            R.id.llPlaylistTab -> {
                circleVisibility(4, 4, 0, 4)
            }
            R.id.llSettingsTab -> {
                circleVisibility(4, 4, 4, 0)
            }
        }
    }

    private fun circleVisibility(v1: Int, v2: Int, v3: Int, v4:Int) {
        llCircleHome.visibility = v1
        llCircleLiveTv.visibility = v2
        llCirclePlaylist.visibility = v3
        llCircleSettings.visibility = v4

        tvHome.visibility = v1
        tvLiveTV.visibility = v2
        tvPlaylist.visibility = v3
        tvSettings.visibility = v4

//        ivHome.visibility = v2
    }

}