package com.website.pdf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 *
 * @author chentong
 * 
 */
public class PdfWebView extends WebView {

    public PdfWebView(Context context) {
        this(context,null);
    }

    public PdfWebView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PdfWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSettings();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initSettings(){
        WebSettings webSettings = getSettings();
        // 开启 javascript 功能；原因：站点采用了 javascript
        webSettings.setJavaScriptEnabled(true);
        // 这句解决本地跨域问题，如果你的 PDF 文件在站点里，是不需要的，但是，我们一般情况是加载站点外部 PDF 文件
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webSettings.setAllowFileAccessFromFileURLs(true);
        }
    }

    public void loadPdfPath(String path){
        // demo code
        /*
         * "file:///android_asset/pdf-website/index.html?pdf="这里是固定的，当然 `pdf-website`
         * 取决于开发者自己目录名称
         * 参数：pdf = 这里是 PDF 文件路径
         */
//        String url = "file:///android_asset/pdf-website/index.html?pdf="+path;
        String url = "file:///android_asset/web/viewer.html?file="+path;
        loadUrl(url);
    }

}
