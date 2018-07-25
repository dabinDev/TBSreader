# **https://x5.tencent.com/tbs/ 腾讯浏览服务** 
## 操作演示
![文件查看/浏览器](https://github.com/Knowledgeables/TBSreader/blob/master/img/gif.gif "文件查看/浏览器")
## 1.腾讯浏览器集成 

X5内核相对于系统webview，具有下述明显优势：

1) 速度快：相比系统webview的网页打开速度有30+%的提升；

2) 省流量：使用云端优化技术使流量节省20+%；

3) 更安全：安全问题可以在24小时内修复；

4) 更稳定：经过亿级用户的使用考验，CRASH率低于0.15%；

5) 兼容好：无系统内核的碎片化问题，更少的兼容性问题；

6) 体验优：支持夜间模式、适屏排版、字体设置等浏览增强功能；

7) 功能全：在Html5、ES6上有更完整支持；

8) 更强大：集成强大的视频播放器，支持视频格式远多于系统webview；

9) 视频和文件格式的支持x5内核多于系统内核

10) 防劫持是x5内核的一大亮点
##  2.tbs文件查看能力

目前支持42种文件格式，包括20种文档、12种音乐、6种图片和4种压缩包。帮助应用实现应用内文档浏览，无需跳转调用其他应用。 

##  3.jsbridge支持解决Android和H5之间的通讯问题

android调用JS方法

```java
   String message = "javascript:phoneCallJs(\"" + "你好 大胡子" + "\")";
   //需要放到pagefind里面或者在loadurl后面否则会返回null
   webView.loadUrl(message);
```
```javascript
    function phoneCallJs(str) {
        alert(str.toString());
       
    }
```
JS调用Android方法



```java
  webView.registerHandler("jsCallPhone", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "回传结果：" + data);
                Toast.makeText(WebBrowserActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
```






### 使用方式：
 ####  下载关联moudle
#### *支持查看网络文件（注意打开权限）
         <uses-permission android:name="android.permission.READ_PHONE_STATE" />
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

#### 打开文件（word/excell/pdf/以及其他很多办公文档格式）
    FileDisplayActivity.openActivity(this, "http://www.xiaobeifeng.top/file/123pdf.pdf");


前端页面放在压缩目录 `bridge`里面
#### 其他解决方式
1.永中云
[http://www.dcsapi.com/](http://www.dcsapi.com/ "http://www.dcsapi.com/")
- 这个用起来也很方便，不需要做什么操作，注册永中云账号，在管理后台吧你们服务器的域名添加信任，然后在你移动端本地用X5浏览器（用本地浏览器需要设置的东西就比较多了，js插件什么的，推荐使用X5浏览器），打开永中云给你拼接后的url就可以直接查看。
- 注*每天每个服务器域名对应文件，免费用户解析只有500次，如果次数超过当天就无法使用，所以自己做做测试什么的还可以
- 将你服务器的文件转成pdf 在浏览器查看，集成简单但是次数显示，支持的格式没有腾讯的多
