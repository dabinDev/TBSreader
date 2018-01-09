package github.benjamin.tbsreader.okgo;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import java.io.File;

/**
 * Project :  TBSreader.
 * Package name: github.benjamin.tbsreader.okgo
 * Created by :  Benjamin.
 * Created time: 2018/1/8 12:46
 * Changed by :  Benjamin.
 * Changed time: 2018/1/8 12:46
 * Class description:
 */

public class Ok {
    private static Ok okClicent;

    private Ok() {

    }

    public static Ok getInstant() {
        if (okClicent == null) {
            okClicent = new Ok();
        }
        return okClicent;
    }

    public void loadFile(String url, String tag) {
        OkGo.<File>get("").execute(new FileCallback() {
            @Override
            public void onSuccess(Response<File> response) {

            }

            @Override
            public void onError(Response<File> response) {
                super.onError(response);
            }

            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);

            }
        });
    }

}
