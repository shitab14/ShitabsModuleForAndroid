package com.mr_mir.shitabsmoduleforandroid

import android.os.Bundle
import android.text.InputFilter
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mr_mir.shitabsmoduleforandroid.input.DigitsInputFilter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        etTest01.filters = arrayOf<InputFilter>(
            DigitsInputFilter(
                2,
                2,
                99.99
            )
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.module_generic_menu, menu)


        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        /*
        val menuSendSms: MenuItem = menu.findItem(R.id.menuSendSms)
        val menushowPdfReport: MenuItem = menu.findItem(R.id.menushowPdfReport)
*/

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            /*android.R.id.home -> {
                super.onBackPressed()
                return true
            }*/
            /*R.id.menu_call -> { callCustomer() }
            R.id.menu_showPdf -> {
                goToPdfReport()
            }

            R.id.menuContactDelete -> {
                deleteConfirmDialog?.show()
            }
            R.id.menuSendSms -> { sendSms()}
            R.id.menushowPdfReport -> {
                goToPdfReport()
            }*/
        }
        return true
    }

}
