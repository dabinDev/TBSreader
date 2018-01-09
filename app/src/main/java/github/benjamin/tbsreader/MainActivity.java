package github.benjamin.tbsreader;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Project :  TBSreader.
 * Package name: github.benjamin.tbsreader
 * Created by :  Benjamin.
 * Created time: 2018/1/3 10:33
 * Changed by :  Benjamin.
 * Changed time: 2018/1/3 10:33
 * Class description:
 */

public class MainActivity extends Activity implements View.OnClickListener {


    private Button mBrowserOpen;
    private Button mWordOpen;
    private Button mExcellOpen;
    private Button mPdfOpen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {

        mBrowserOpen = findViewById(R.id.open_browser);
        mBrowserOpen.setOnClickListener(this);
        mWordOpen = findViewById(R.id.open_word);
        mWordOpen.setOnClickListener(this);
        mExcellOpen = findViewById(R.id.open_excell);
        mExcellOpen.setOnClickListener(this);
        mPdfOpen = findViewById(R.id.open_pdf);
        mPdfOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_browser:
                WebBrowserActivity.openActivity(this);
                break;
            case R.id.open_word:// TODO 18/01/09
                FileDisplayActivity.openActivity(this, "http://www.xiaobeifeng.top/file/123doc.doc");
                break;
            case R.id.open_excell:// TODO 18/01/09
                FileDisplayActivity.openActivity(this, "http://www.xiaobeifeng.top/file/123xls.xls");
                break;
            case R.id.open_pdf:// TODO 18/01/09
                FileDisplayActivity.openActivity(this, "http://www.xiaobeifeng.top/file/123pdf.pdf");
                break;
            default:
                break;
        }
    }
}
