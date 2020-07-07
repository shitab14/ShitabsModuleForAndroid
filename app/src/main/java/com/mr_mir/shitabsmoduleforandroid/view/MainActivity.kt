package com.mr_mir.shitabsmoduleforandroid.view

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.InputFilter
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr_mir.shitabsmoduleforandroid.R
import com.mr_mir.shitabsmoduleforandroid.activitycalls.ActivityCallUtils
import com.mr_mir.shitabsmoduleforandroid.adapters.ActionsAdapter
import com.mr_mir.shitabsmoduleforandroid.input.DigitsInputFilter
import com.mr_mir.shitabsmoduleforandroid.moduleinterfacing.Navigator
import com.mr_mir.shitabsmoduleforandroid.network.NetworkUtil
import com.mr_mir.shitabsmoduleforandroid.security.SecurityUtil
import com.mr_mir.uiuxdesign.activity.CustomBubbleBottomTabActivity
import com.mr_mir.uiuxdesign.activity.MainUIActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var toolbarMenu: Menu? = null
    private var menuMainItem: MenuItem? = null
    private var context: Context = this
    private var url: String = "https://www.facebook.com/"

    private var list: ArrayList<String> = arrayListOf<String>()
    private lateinit var adapter: ActionsAdapter

    //android:foreground="?attr/selectableItemBackground"
    /*val outValue = TypedValue()
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        buttonView.foreground = resources.getDrawable(outValue.resourceId)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        SecurityUtil.disableScreenshot(context)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActionBar()
        setupData()
        setupView()

        setupListeners()
        //showWebView()
        //(context as Activity).overridePendingTransition(R.anim.right_in, R.anim.left_out) // animation
    }

    private fun setupListeners() {
        bGoingToAnActivity.setOnClickListener {
            /*val launchIntent =
                packageManager.getLaunchIntentForPackage("com.mr_mir.uiuxdesign.activity.MainUIActivity")
            startActivity(launchIntent)
//            ActivityCallUtils.goToNextActivity(this, Class.forName("com.mr_mir.uiuxdesign.activity.MainUIActivity"))*/

            /*val intent = Intent(Intent.ACTION_VIEW).setClassName("com.mr_mir.uiuxdesign", "com.mr_mir.uiuxdesign.activity.MainUIActivity")
            startActivity(intent)*/

            //Navigator.goToUXModule(this)

            ActivityCallUtils.goToNextActivity(context, CustomBubbleBottomTabActivity::class.java)
//ActivityCallUtils.goToNextActivity(context, MainUIActivity::class.java)
        }
    }


/*
    fun goToPosLandingPage() {
            val inter: PosModuleInterface = PosModuleIntImp()
            setPosInventoryData(this, AppDataManager(this), inter)
            CommonUtil.goToNextActivity(this, PosLandingActivity::class.java)
            val intent = Intent(this@SplashActivity, PosLandingActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

    }
*/

    private fun setupData() {
        list.add("Item 01")
        list.add("Item 00")
    }
    private fun setupView() {
        etTest01.filters = arrayOf<InputFilter>(
            DigitsInputFilter(
                2,
                2,
                99.99
            )
        )

        adapter = ActionsAdapter(list, context)
        val mLayoutManager = LinearLayoutManager(this)
        rv?.layoutManager = mLayoutManager
        rv?.adapter = adapter


    }

    // RECYCLEVIEW SETUP
    /*private fun setRecyclerView(contacts: java.util.ArrayList<ContactModel>, searchText: String) {
        //Collections.reverse(contacts)
        adapter = ContactListAdapter(this@ReferFromPhonebookActivity, contacts)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvContacts.itemAnimator = DefaultItemAnimator()
        rvContacts.layoutManager = layoutManager
        rvContacts.adapter = adapter
    }*/


    //WEBVIEW DEMONSTRATION -----------------------------------------------------------------------
    private fun showWebView() {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        initWeb()
        webView.loadUrl(url)
    }
    private fun initWeb(): Unit {
        if (NetworkUtil.isNetworkConnected(context)) {
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                    view.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    appBarLayout.visibility = View.VISIBLE
                    webView.visibility = View.VISIBLE
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
            } else {
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
            }
            webView.clearCache(true)
            webView.clearHistory()
            webView.settings.javaScriptEnabled = true
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true
            webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
            webView.isHorizontalScrollBarEnabled = false
        } else {
            webView.visibility = View.GONE
        }
    }
    // --------------------------------------------------------------------------------------------



    //Setting up Menu in ActionBar ----------------------------------------------------------------
    private fun initActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        supportActionBar!!.setDisplayShowHomeEnabled(false)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.module_generic_menu, menu)
        toolbarMenu = menu
        menuMainItem = menu.findItem(R.id.menu)
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
    // --------------------------------------------------------------------------------------------

}
