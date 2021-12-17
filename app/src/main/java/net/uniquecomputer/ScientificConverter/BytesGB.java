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

public class BytesGB extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWeb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytes_g_b);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarWeb3 = (ProgressBar) findViewById(R.id.Progressbar3);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://convertlive.com/u/convert/bytes/to/gigabytes");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWeb3.setVisibility(View.VISIBLE);
                progressBarWeb3.setProgress(newProgress);
                setTitle("Loading...");
                if (newProgress ==100){

                    progressBarWeb3.setVisibility(View.GONE);
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