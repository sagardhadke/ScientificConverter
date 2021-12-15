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

public class BytesMB extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWeb4;
    ProgressDialog progressDialogWeb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytes_m_b);
        mywebView=(WebView) findViewById(R.id.webview);
        progressBarWeb4 = (ProgressBar) findViewById(R.id.Progressbar4);
        progressDialogWeb4 = new ProgressDialog(this);
        progressDialogWeb4.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://convertlive.com/u/convert/bytes/to/megabytes");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWeb4.setVisibility(View.VISIBLE);
                progressBarWeb4.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogWeb4.show();
                if (newProgress ==100){

                    progressBarWeb4.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogWeb4.dismiss();

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