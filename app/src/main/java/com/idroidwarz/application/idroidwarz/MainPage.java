package com.idroidwarz.application.idroidwarz;

/**
 * Created by Rizwan Ahmed on 4/18/2015.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainPage extends Activity {

    WebView mWebView;

    String URL="http://idroidwarz.com";

    ProgressBar loadingProgressBar,loadingTitle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);



        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(URL);
        mWebView.setWebViewClient(new MyWebViewClient());

        loadingProgressBar=(ProgressBar)findViewById(R.id.progressBar);

        mWebView.setWebChromeClient(new WebChromeClient() {

            // this will be called on page loading progress

            @Override

            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);


                loadingProgressBar.setProgress(newProgress);
                //loadingTitle.setProgress(newProgress);
                // hide the progress bar if the loading is complete

                if (newProgress == 100) {
                    loadingProgressBar.setVisibility(View.GONE);

                } else{
                    loadingProgressBar.setVisibility(View.VISIBLE);

                }

            }

        });

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }
}

