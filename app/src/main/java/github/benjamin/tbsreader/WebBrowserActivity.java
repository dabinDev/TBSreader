package github.benjamin.tbsreader;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import github.benjamin.tbsreader.bridge.BridgeHandler;
import github.benjamin.tbsreader.bridge.CallBackFunction;
import github.benjamin.tbsreader.bridge.DefaultHandler;
import github.benjamin.tbsreader.bridge.SimpleBridgeWebViewClientListener;
import github.benjamin.tbsreader.bridge.TbsBridgeWebView;

/**
 * Project :  TBSreader.
 * Package name: github.benjamin.tbsreader
 * Created by :  Benjamin.
 * Created time: 2018/1/3 15:36
 * Changed by :  Benjamin.
 * Changed time: 2018/1/3 15:36
 * Class description:
 */

public class WebBrowserActivity extends Activity {
    private String file;
    TbsBridgeWebView webView;
    private String TAG = "WebBrowserActivity";
    private Button mAndroidCallJs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);//（这个对宿主没什么影响，建议声明）
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        file = getIntent().getStringExtra("filePath") == null ? "" : getIntent().getStringExtra("filePath");
        initView();
    }

    @SuppressWarnings("deprecation")
    @JavascriptInterface
    private void initView() {
        webView = findViewById(R.id.webView);
        mAndroidCallJs = findViewById(R.id.androidCallJs);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        //设定支持h5viewport
        webView.getSettings().setUseWideViewPort(true);
        // 自适应屏幕.
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.setBridgeWebViewClientListener(new SimpleBridgeWebViewClientListener());
        //=======================此方法必须调用==========================
        webView.setDefaultHandler(new DefaultHandler());
        //=======================js桥使用改方法替换原有setWebViewClient()方法==========================
        //=======================js桥使用改方法替换原有setWebViewClient()方法==========================

        webView.setBridgeWebViewClientListener(new SimpleBridgeWebViewClientListener() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "超链接：" + url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap bitmap) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {


            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }

            @Override
            public boolean onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                String message;
                switch (sslError.getPrimaryError()) {
                    case android.net.http.SslError.SSL_UNTRUSTED:
                        message = "证书颁发机构不受信任";
                        break;
                    case android.net.http.SslError.SSL_EXPIRED:
                        message = "证书过期";
                        break;
                    case android.net.http.SslError.SSL_IDMISMATCH:
                        message = "网站名称与证书不一致";
                        break;
                    case android.net.http.SslError.SSL_NOTYETVALID:
                        message = "证书无效";
                        break;
                    case android.net.http.SslError.SSL_DATE_INVALID:
                        message = "证书日期无效";
                        break;
                    case android.net.http.SslError.SSL_INVALID:
                    default:
                        message = "证书错误";
                        break;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(WebBrowserActivity.this);
                builder.setTitle("提示").setMessage(message + "，是否继续").setCancelable(true)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                sslErrorHandler.proceed();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                sslErrorHandler.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });
        //=======================此方法必须调用==========================
        webView.setDefaultHandler(new DefaultHandler());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);
            }
        });

        webView.loadUrl(file);


        // webView.setCustom("桥名");
        webView.setCustom("TestJavascriptBridge");

        //=======================以下4个web调用native示例方法==========================
        webView.registerHandler("jsCallPhone", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "回传结果：" + data);
                Toast.makeText(WebBrowserActivity.this, data, Toast.LENGTH_LONG).show();
            }
        });
        mAndroidCallJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//写死的字符串需要注意
                String message = "javascript:phoneCallJs(\"" + "你好 大胡子" + "\")";//需要放到pagefind里面或者在loadurl后面否则会返回null
                webView.loadUrl(message);
            }
        });

    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, WebBrowserActivity.class);
        intent.putExtra("filePath", "http://www.dabinDev.cn/Bridge/test.html");
        context.startActivity(intent);
    }

    public static void openActivity(Context context,String file) {
        Intent intent = new Intent(context, WebBrowserActivity.class);
        intent.putExtra("filePath", file);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (webView != null) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                finish();
            }
        }
    }
}
