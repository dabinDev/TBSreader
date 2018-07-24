package github.benjamin.tbsreader.bridge;

/**
 * 配置文件
 */
public class BridgeConfig {

    public static final String toLoadJs = "WebViewJavascriptBridge.js";
    /**
     * 默认桥名
     */
    public static final String defaultJs = "WebViewJavascriptBridge";
    /**
     * 自定义桥名
     */
    public static String customJs = BridgeConfig.defaultJs;
}
