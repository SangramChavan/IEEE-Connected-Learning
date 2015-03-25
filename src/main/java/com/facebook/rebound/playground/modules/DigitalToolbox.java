package com.facebook.rebound.playground.modules;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.rebound.playground.R;


/***
 *  Created by Sangram on 20/3/15.
 */
public class DigitalToolbox extends FrameLayout{
    private final FrameLayout mRootView;
        ProgressBar progressBar;
        public DigitalToolbox(Context context) {
            this(context, null);
        }

        public DigitalToolbox(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public DigitalToolbox(final Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            LayoutInflater inflater = LayoutInflater.from(context);
            mRootView = (FrameLayout) inflater.inflate(R.layout.digitaltoolbox, this, false);
            WebView webView = (WebView)mRootView.findViewById(R.id.webView);
            webView.getSettings().setAllowFileAccess( true );
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            webView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
            webView.setWebViewClient(new MyWebViewClient());
            Toast.makeText(context, " Loading... ", Toast.LENGTH_LONG).show();
            webView.loadUrl("http://m.ieee.org/publications_standards/publications/authors/author_tools.html");
            addView(mRootView);
        }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon)
        {
            progressBar = (ProgressBar) mRootView.findViewById(R.id.progressBar);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url)
        {
            progressBar.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }

    }
  }