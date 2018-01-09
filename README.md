# https://x5.tencent.com/tbs/ 腾讯浏览服务 
### 1.腾讯浏览器集成
###  2.tbs文件查看能力
![文件查看/浏览器](https://github.com/Knowledgeables/TBSreader/blob/master/img/gif.gif "文件查看/浏览器")
### 使用方式：
 ####  下载关联moudle
#### *支持查看网络文件（注意打开权限）
         <uses-permission android:name="android.permission.READ_PHONE_STATE" />
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

#### 打开文件（word/excell/pdf/以及其他很多办公文档格式）
    FileDisplayActivity.openActivity(this, "http://www.xiaobeifeng.top/file/123pdf.pdf");
    
	
