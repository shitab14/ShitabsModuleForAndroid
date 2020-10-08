package com.mr_mir.uiuxdesign.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.mr_mir.uiuxdesign.R
import com.mr_mir.uiuxdesign.adapter.PokeHomeOptionAdapter
import com.mr_mir.uiuxdesign.model.PokeHomeOption
import kotlinx.android.synthetic.main.activity_rotom_phone.*

class RotomPhoneActivity : AppCompatActivity() {
    var context: Context = this
    private var optionList: ArrayList<PokeHomeOption>? = null
    var optionAdapter: PokeHomeOptionAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotom_phone)

        optionList = ArrayList<PokeHomeOption>()
        optionList?.add(PokeHomeOption(R.drawable.ic_pokegym, "Pokemon Gym"))
        optionList?.add(PokeHomeOption(R.drawable.ic_pokegym, "Pokemon Gym"))
        optionList?.add(PokeHomeOption(R.drawable.ic_pokegym, "Pokemon Gym"))
        optionList?.add(PokeHomeOption(R.drawable.ic_pokegym, "Pokemon Gym"))
        optionAdapter = PokeHomeOptionAdapter(optionList!!, context)
        rvHomeOptions.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = optionAdapter
        }
    }
}