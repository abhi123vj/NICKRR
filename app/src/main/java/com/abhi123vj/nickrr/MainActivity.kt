package com.abhi123vj.nickrr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mweb1: WebView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mweb1=findViewById<View>(R.id.web1) as WebView

        mweb1!!.webViewClient= object  : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true

            }
        }
        val webSettings = mweb1!!.getSettings()
        webSettings.setJavaScriptEnabled(true)
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        webSettings.setAppCacheEnabled(true)
        webSettings.domStorageEnabled=true
        webSettings.layoutAlgorithm=WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSettings.useWideViewPort=true
        webSettings.setSavePassword(true)
        webSettings.saveFormData=true
        webSettings.setEnableSmoothTransition(true)



        mweb1!!.loadUrl("https://nickrr.com")


    }

    override fun onBackPressed() {
        if(mweb1!!.canGoBack())
            mweb1!!.goBack()
        else
            super.onBackPressed()

    }
}
