package net.uniquecomputer.bcaallinone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class CMToM extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarCmtom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_m_to_m);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarCmtom = (ProgressBar) findViewById(R.id.ProgCmtom);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://convertlive.com/u/convert/centimetres/to/meters");
        mywebView.setWebChromeClient(new WebChromeClient(){


            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBarCmtom.setVisibility(View.VISIBLE);
                progressBarCmtom.setProgress(newProgress);
                setTitle("Loading...");
                if (newProgress ==100){

                    progressBarCmtom.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                }

                super.onProgressChanged(view, newProgress);
            }
        });


        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}