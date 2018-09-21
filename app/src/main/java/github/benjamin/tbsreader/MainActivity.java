package github.benjamin.tbsreader;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tencent.smtt.sdk.TbsMediaFactory;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.tencent.smtt.sdk.TbsVideo;

/**
 * Project :  TBSreader.
 * Package name: github.benjamin.tbsreader
 * Created by :  Benjamin.
 * Created time: 2018/1/3 10:33
 * Changed by :  Benjamin.
 * Changed time: 2018/1/3 10:33
 * Class description:
 */

public class MainActivity extends Activity implements View.OnClickListener, TbsMediaPlayer.TbsMediaPlayerListener {


    private Button mBrowserOpen;
    private Button mWordOpen;
    private Button mExcellOpen;
    private Button mPdfOpen;
    private Button mVideoOpen;
    private Button mMusicOpen;

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
        mVideoOpen = (Button) findViewById(R.id.open_video);
        mVideoOpen.setOnClickListener(this);
        mMusicOpen = (Button) findViewById(R.id.open_music);
        mMusicOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_browser:
                WebBrowserActivity.openActivity(this);
                break;
            case R.id.open_word:// TODO 18/01/09
                FileDisplayActivity.openActivity(this, "http://www.dabinDev.cn/file/123doc.doc");
                break;
            case R.id.open_excell:// TODO 18/01/09
                FileDisplayActivity.openActivity(this, "http://www.dabinDev.cn/file/123xls.xls");
                break;
            case R.id.open_pdf:// TODO 18/01/09
                FileDisplayActivity.openActivity(this, "http://www.dabinDev.cn/file/123pdf.pdf");
                break;
            case R.id.open_music:// TODO 18/01/09
                TbsMediaFactory factory = new TbsMediaFactory(this);
                TbsMediaPlayer player = factory.createPlayer();
                player.setSurfaceTexture(new SurfaceTexture(true));
                if (player.isAvailable()) {
                    player.setVolume(1f);
                    player.startPlay("http://www.dabinDev.cn/file/123hope.mp3", new Bundle());
                    player.setPlayerListener(this);
                }
                break;
            case R.id.open_video:// TODO 18/01/09
                Bundle extraData = new Bundle();
                extraData.putInt("screenMode", 102);
                extraData.putBoolean("supportLiteWnd", false);
                TbsVideo.openVideo(this, "http://www.dabinDev.cn/file/12312312.mp4", extraData);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPlayerPrepared(long l, int i, int i1, int i2, int i3) {
        Log.e("audio", "onPlayerPrepared");

    }

    @Override
    public void onPlayerExtra(int i, Object o) {
        Log.e("audio", "onPlayerExtra");

    }

    @Override
    public void onPlayerError(String s, int i, int i1, Throwable throwable) {
        Log.e("audio", "onPlayerError");

    }

    @Override
    public void onPlayerInfo(int i, int i1) {
        Log.e("audio", "onPlayerInfo");

    }

    @Override
    public void onPlayerPlaying() {
        Log.e("audio", "onPlayerPlaying");

    }

    @Override
    public void onPlayerProgress(long l) {
        Log.e("audio", "onPlayerProgress");

    }

    @Override
    public void onPlayerSubtitle(String s) {
        Log.e("audio", "onPlayerSubtitle");

    }

    @Override
    public void onPlayerPaused() {
        Log.e("audio", "onPlayerPaused");

    }

    @Override
    public void onPlayerSeeked(long l) {
        Log.e("audio", "onPlayerSeeked");

    }

    @Override
    public void onPlayerCompleted() {
        Log.e("audio", "onPlayerCompleted");

    }

    @Override
    public void onBufferingUpdate(float v) {
        Log.e("audio", "onBufferingUpdate");

    }
}
