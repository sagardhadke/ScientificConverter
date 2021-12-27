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

public class JavaComp extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWebJava;
    ProgressDialog progressDialogJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_comp);
        mywebView=(WebView) findViewById(R.id.WebJava);
        progressBarWebJava = (ProgressBar) findViewById(R.id.ProgressbarJava);
        progressDialogJava = new ProgressDialog(this);
        progressDialogJava.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.tutorialspoint.com/compile_java_online.php");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWebJava.setVisibility(View.VISIBLE);
                progressBarWebJava.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogJava.show();
                if (newProgress ==100){

                    progressBarWebJava.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogJava.dismiss();
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