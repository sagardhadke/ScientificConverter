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

public class php extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWebPhp;
    ProgressDialog progressDialogPhp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);
        mywebView=(WebView) findViewById(R.id.webviewPhp);
        progressBarWebPhp = (ProgressBar) findViewById(R.id.ProgressbarPhp);
        progressDialogPhp = new ProgressDialog(this);
        progressDialogPhp.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.tutorialspoint.com/execute_php_online.php");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWebPhp.setVisibility(View.VISIBLE);
                progressBarWebPhp.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogPhp.show();
                if (newProgress ==100) {

                    progressBarWebPhp.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogPhp.dismiss();

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