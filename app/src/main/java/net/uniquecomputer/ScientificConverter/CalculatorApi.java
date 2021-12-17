package net.uniquecomputer.ScientificConverter;

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

public class CalculatorApi extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarcalprog;
    ProgressDialog progressDialogCalprogk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_api);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarcalprog = (ProgressBar) findViewById(R.id.CalcuProg);
        progressDialogCalprogk = new ProgressDialog(this);
        progressDialogCalprogk.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://sagardhadke.github.io/OnCalculator/");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarcalprog.setVisibility(View.VISIBLE);
                progressBarcalprog.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogCalprogk.show();
                if (newProgress ==100){

                    progressBarcalprog.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogCalprogk.dismiss();
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