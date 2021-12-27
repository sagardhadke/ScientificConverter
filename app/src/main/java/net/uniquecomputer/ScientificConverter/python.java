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

public class python extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarWebPy;
    ProgressDialog progressDialogPy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
        mywebView=(WebView) findViewById(R.id.webviewPy);
        progressBarWebPy = (ProgressBar) findViewById(R.id.ProgressbarPython);
        progressDialogPy = new ProgressDialog(this);
        progressDialogPy.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.tutorialspoint.com/execute_python_online.php");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarWebPy.setVisibility(View.VISIBLE);
                progressBarWebPy.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogPy.show();
                if (newProgress ==100) {

                    progressBarWebPy.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogPy.dismiss();

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