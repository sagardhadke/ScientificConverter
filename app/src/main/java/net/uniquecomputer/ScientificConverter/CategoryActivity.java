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

public class CategoryActivity extends AppCompatActivity {
    private WebView mywebView;
    ProgressBar ProgressbarCatego;
    ProgressDialog progressDialogCU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mywebView=(WebView) findViewById(R.id.WebviewCategory);
        ProgressbarCatego = (ProgressBar) findViewById(R.id.ProgressbarCatego);
        progressDialogCU = new ProgressDialog(this);
        progressDialogCU.setMessage("Loading Please Wait");
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://onecompiler.com/");
        mywebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                ProgressbarCatego.setVisibility(View.VISIBLE);
                ProgressbarCatego.setProgress(newProgress);
                setTitle("Loading...");
                progressDialogCU.show();
                if(newProgress ==100){

                    ProgressbarCatego.setVisibility(View.GONE);
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