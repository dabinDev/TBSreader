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
    
	
#### 其他解决方式
1.永中云
[http://www.dcsapi.com/](http://www.dcsapi.com/ "http://www.dcsapi.com/")
- 这个用起来也很方便，不需要做什么操作，注册永中云账号，在管理后台吧你们服务器的域名添加信任，然后在你移动端本地用X5浏览器（用本地浏览器需要设置的东西就比较多了，js插件什么的，推荐使用X5浏览器），打开永中云给你拼接后的url就可以直接查看。
- 注*每天每个服务器域名对应文件，免费用户解析只有500次，如果次数超过当天就无法使用，所以自己做做测试什么的还可以
