package github.benjamin.tbsreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

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
    private String  file;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        WebView tbsView = findViewById(R.id.twv_test);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        file=getIntent().getStringExtra("filePath")==null?"":getIntent().getStringExtra("filePath");
        tbsView.loadUrl(file);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        tbsView.getView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        tbsView.setWebChromeClient(new WebChromeClient());

    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, WebBrowserActivity.class);
        intent.putExtra("filePath", "http://www.xiaobeifeng.top/yunnaIT/index.html");
        context.startActivity(intent);
    }
}
