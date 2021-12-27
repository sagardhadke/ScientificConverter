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

public class htmlcssjs extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar progressBarHtml;
    ProgressDialog progressDialogHtml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlcssjs);
        mywebView=(WebView) findViewById(R.id.WebviewHtml);
        progressBarHtml = (ProgressBar) findViewById(R.id.ProgressbarHtml);
        progressDialogHtml = new ProgressDialog(this);
        progressDialogHtml.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.tutorialspoint.com/online_html_editor.php");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBarHtml.setVisibility(View.VISIBLE);
                progressBarHtml.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogHtml.show();
                if (newProgress ==100) {

                    progressBarHtml.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialogHtml.dismiss();
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