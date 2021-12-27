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

public class cpp extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWebCpp;
    ProgressDialog progressDialogCpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpp);
        mywebView=(WebView) findViewById(R.id.WebviewCpp);
        progressBarWebCpp = (ProgressBar) findViewById(R.id.ProgressbarCpp);
        progressDialogCpp = new ProgressDialog(this);
        progressDialogCpp.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.tutorialspoint.com/compile_cpp_online.php");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWebCpp.setVisibility(View.VISIBLE);
                progressBarWebCpp.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogCpp.show();
                if (newProgress ==100) {

                    progressBarWebCpp.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogCpp.dismiss();

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