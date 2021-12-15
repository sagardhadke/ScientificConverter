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

public class BytesTB extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWeb5;
    ProgressDialog progressDialogWeb5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytes_t_b);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarWeb5 = (ProgressBar) findViewById(R.id.Progressbar5);
        progressDialogWeb5 = new ProgressDialog(this);
        progressDialogWeb5.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://convertlive.com/u/convert/bytes/to/terabytes");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWeb5.setVisibility(View.VISIBLE);
                progressBarWeb5.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogWeb5.show();
                if (newProgress ==100){

                    progressBarWeb5.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogWeb5.dismiss();

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