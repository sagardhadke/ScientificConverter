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

public class Currencyconverterapi extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWebcu;
    ProgressDialog progressDialogCU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencyconverterapi);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarWebcu = (ProgressBar) findViewById(R.id.ProgressbarCurrency);
        progressDialogCU = new ProgressDialog(this);
        progressDialogCU.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://sagardhadke.github.io/Currency-Converter/");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBarWebcu.setVisibility(View.VISIBLE);
                progressBarWebcu.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogCU.show();
                if(newProgress ==100) {

                    progressBarWebcu.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogCU.dismiss();

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