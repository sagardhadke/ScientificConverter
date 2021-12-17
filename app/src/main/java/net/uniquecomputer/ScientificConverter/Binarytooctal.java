package net.uniquecomputer.ScientificConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Binarytooctal extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarBinaOc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binarytooctal);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarBinaOc = (ProgressBar) findViewById(R.id.ProgressbarBinaOc);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.unitconverters.net/numbers/binary-to-octal.htm");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarBinaOc.setVisibility(View.VISIBLE);
                progressBarBinaOc.setProgress(newProgress);
                setTitle("Loading...");

                if (newProgress==100){
                    progressBarBinaOc.setVisibility(View.GONE);
                    setTitle(getTitle());

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