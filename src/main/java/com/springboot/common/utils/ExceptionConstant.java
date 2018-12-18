package com.springboot.common.utils;

/**
 * @Author :yan
 * @Date :Create in 12/18/18
 * @Description :
 */

public class ExceptionConstant {
    public static final int EXCEPTION_OTHER = -1;
    public static final int EXCEPTION_SUCCESS = 0;
    public static final int EXCEPTION_PHONEING = 101;
    public static final int EXCEPTION_FILE_DOWNING = 102;
    public static final int EXCEPTION_FALLBACK = 103;
    public static final int EXCEPTION_NOSERVICE = 104;
    public static final int EXCEPTION_WEAKSIGNAL = 106;
    public static final int EXCEPTION_PPPFAIL = 107;
    public static final int EXCEPTION_PPPDROP = 108;
    public static final int EXCEPTION_USEDFLOW_OVER = 109;

    public static final int EXCEPTION_NP_GETOPERERROR = 110;
    public static final int EXCEPTION_NP_NOWGETOPER = 111;
    public static final int EXCEPTION_NP_OPERNOTMATCH = 112;
    public static final int EXCEPTION_NP_NETWORKTYPEUNKNOWN = 113;

    public static final int EXCEPTION_SERVERMATCH_CONNECT = 121;
    public static final int EXCEPTION_SERVERMATCH_RESPONSE = 122;
    public static final int EXCEPTION_SERVERMATCH_NOTINLIST = 123;
    public static final int EXCEPTION_SERVER_CONNECT = 130;
    public static final int EXCEPTION_SERVER_RESPONSE = 131;
    public static final int EXCEPTION_SERVER_REFUSE = 132;
    public static final int EXCEPTION_SERVER_WAIT = 133;
    public static final int EXCEPTION_SERVER_ERRPARAM = 134;
    public static final int EXCEPTION_SERVERORNET_ERROR = 135;
    public static final int EXCEPTION_INVALID_PARAM = 136;
    public static final int EXCEPTION_DOWNLOAD_ZERO = 137;
    public static final int EXCEPTION_UPLOAD_ZERO = 138;
    public static final int EXCEPTION_SERVER_NOSELECT = 139;

    public static final int HTTP_REQUEST_SERVER_OK = 200;
    public static final int EXCEPTION_DNS_HOSTNOTFOUND = 201;
    public static final int EXCEPTION_DNS_TRYAGAIN = 202;
    public static final int EXCEPTION_DNS_UNRECOVERABLE = 203;
    public static final int EXCEPTION_DNS_FAILED = 204;

    public static final int EXCEPTION_WLAN_MORELOGIN = 301;
    public static final int EXCEPTION_WLAN_OVERTIME = 302;
    public static final int EXCEPTION_WLAN_CONERROR = 303;
    public static final int EXCEPTION_WLAN_PSWERROR = 304;

    public static final int EXCEPTION_SERVER_EORROR = 500;

    public static final int EXCEPTION_USERSTOP = 990;
    public static final int EXCEPTION_UNKNOWN = 999;

    public static String getName(int code) {
        switch (code) {
            //以下服务器匹配共同异常
            case EXCEPTION_OTHER:
                return "不知名异常";
            case EXCEPTION_SUCCESS://最好不要用这个异常
                return "成功，无异常";
            case EXCEPTION_PHONEING:
                return "通话";
            case EXCEPTION_FILE_DOWNING:
                return "此文件正在下载";
            case EXCEPTION_FALLBACK:
                return "回落";
            case EXCEPTION_NOSERVICE:
                return "无服务";
            case EXCEPTION_WEAKSIGNAL:
                return "无线信号差";
            case EXCEPTION_PPPFAIL:
                return "数据连接异常";
            case EXCEPTION_PPPDROP:
                return "数据连接掉线";
            case EXCEPTION_USEDFLOW_OVER:
                return "用户使用流量已超出限制";

            case EXCEPTION_NP_GETOPERERROR:
                return "未能获取网络运营商信息，请退出重试。";
            case EXCEPTION_NP_NOWGETOPER:
                return "正在获取网络运营商信息,请稍后测试。";
            case EXCEPTION_NP_OPERNOTMATCH:
                return "SIM卡运营商与外网IP不匹配，请使用主卡或禁用多余卡后测试，如有问题请联系管理员。";
            case EXCEPTION_NP_NETWORKTYPEUNKNOWN:
                return "未能获取网络类型信息，请使用主卡或禁用多余卡后退出重试，如有问题请联系管理员。";
            //以下服务器节点自动匹配中异常
            case EXCEPTION_SERVERMATCH_CONNECT:
                return "主服务器连接失败";
            case EXCEPTION_SERVERMATCH_RESPONSE:
                return "主服务器响应错误";
            case EXCEPTION_SERVERMATCH_NOTINLIST:
                return "没匹配到列表中服务器";

            //以下探测服务器连接情况过程中异常
            case EXCEPTION_SERVER_CONNECT:
                return "服务器连接失败";
            case EXCEPTION_SERVER_RESPONSE:
                return "服务器无响应";
            case EXCEPTION_SERVER_REFUSE:
                return "服务器拒绝";
            case EXCEPTION_SERVER_WAIT:
                return "服务器忙，请稍后再试";
            case EXCEPTION_SERVER_ERRPARAM:
                return "请求排队参数错误";
            case EXCEPTION_SERVERORNET_ERROR:
                return "服务器或网络异常";
            case EXCEPTION_INVALID_PARAM:
                return "参数设置错误";
            case EXCEPTION_DOWNLOAD_ZERO:
                return "下行测试无响应";
            case EXCEPTION_UPLOAD_ZERO:
                return "上行测试无响应";
            case EXCEPTION_SERVER_NOSELECT:
                return "当前未选择服务器节点";
            case HTTP_REQUEST_SERVER_OK:
                return "请求成功";

            case EXCEPTION_DNS_HOSTNOTFOUND:
                return "域名未找到";
            case EXCEPTION_DNS_TRYAGAIN:
                return "超时或网络错误";
            case EXCEPTION_DNS_UNRECOVERABLE:
                return "服务器异常";
            case EXCEPTION_DNS_FAILED:
                return "DNS解析失败";
            case EXCEPTION_WLAN_MORELOGIN:
                return "网络已登入";
            case EXCEPTION_WLAN_OVERTIME:
                return "网络连接超时";
            case EXCEPTION_WLAN_CONERROR:
                return "网络连接错误";
            case EXCEPTION_WLAN_PSWERROR:
                return "配置信息错误";

            case EXCEPTION_SERVER_EORROR:
                return "服务器内部发生错误";

            //其他异常
            case EXCEPTION_USERSTOP:
                return "用户中止测试";
            case EXCEPTION_UNKNOWN:
                return "服务器或网络异常";
        }

        return "其他原因失败";
    }
}
