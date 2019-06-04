package com.superm.easy.cloud.commons.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hu.sheng
 * @since 20190425
 */
public class Constants {

    public static final String ROCKTECO = "rockteco12345678";

    public static final int MAX_NUMBER_IN_DEVICE_LIST = 50;

    public static final int EQUIPMENTSHARE_QRCODE_EXPIRED_IN = 20 * 60;
    public static final int EQUIPMENTSHARE_THIRDPARTY_EXPIRED_IN = 20 * 60;
    public static final int EQUIPMENTSHARE_ACCOUNT_EXPIRED_IN = 72 * 3600;
    public static final int EQUIPMENTSHARE_MAX_QRCODE_INVITATIONNUMBER = 1;
    public static final int EQUIPMENTSHARE_MAX_ACCOUNT_INVITATIONNUMBER = 1;
    public static final int EQUIPMENTSHARE_MAX_THIRDPARTY_INVITATIONNUMBER = 10;
    public static final int EQUIPMENTSHARE_MAX_SHARENUMBER = 5;
    public static final int EQUIPMENTSHARE_RIGHT_PREVIEW = 1; // preview
    public static final int EQUIPMENTSHARE_RIGHT_VIEW = 2; // view
    public static final int EQUIPMENTSHARE_RIGHT_EVENT = 4; // event
    public static final int EQUIPMENTSHARE_RIGHT_CONTROL = 8; // control
    public static final int EQUIPMENTSHARE_DEFAULT_RIGHT = EQUIPMENTSHARE_RIGHT_PREVIEW;
    public static final int EQUIPMENTSHARE_STATE_UNKNOWN = 0;
    public static final int EQUIPMENTSHARE_STATE_INVITING = 1;
    public static final int EQUIPMENTSHARE_STATE_ACCEPT = 2;
    public static final int EQUIPMENTSHARE_STATE_CANCEL = 3;
    public static final int EQUIPMENTSHARE_STATE_REJECT = 4;
    public static final int EQUIPMENTSHARE_STATE_EXPIRE = 5;
    public static final int EQUIPMENTSHARE_MAX_FRIEND = 100;
    public static final int EQUIPMENTSHARE_EVENT_TYPE_INVITE = 1;
    public static final int EQUIPMENTSHARE_EVENT_TYPE_ACCEPT = 2;
    public static final int EQUIPMENTSHARE_EVENT_TYPE_REJECT = 3;
    public static final int EQUIPMENTSHARE_EVENT_TYPE_REMOVE_INVITOR = 4;
    public static final int EQUIPMENTSHARE_EVENT_TYPE_REMOVE_INVITEE = 5;
    public static final int EQUIPMENTSHARE_TYPE_QRCODE = 1;
    public static final int EQUIPMENTSHARE_TYPE_ACCOUNT = 2;

    /**
     * authorization urls for third-party accounts TODO: put them into configuration file for better testing
     */
    public static final String AUTH_URL_WEIBO = "https://api.weibo.com/oauth2/get_token_info";
    public static final String AUTH_URL_QQ = "https://graph.qq.com/oauth2.0/me";
    public static final String AUTH_URL_MI = "https://open.account.xiaomi.com/user/openidV2";

    /**
     * constants for data format in synchronizing with xiaomi
     */
    public static final String XIAOMI_RET_CODE_KEY = "code";
    public static final String XIAOMI_RET_MESSAGE_KEY = "message";
    public static final String XIAOMI_RET_RESULT_KEY = "result";

    public static final String XIAOMI_FAILED_KEYS_KEY = "failed_keys";
    public static final String XIAOMI_SYNC_URLENCODING = "utf-8";
    public static final String XIAOMI_SYNC_ARG_DATA = "data";
    public static final String XIAOMI_SYNC_ARG_SIGNATURE = "signature";
    public static final String XIAOMI_SYNC_ARG_SID = "app_id";
    public static final String XIAOMI_SYNC_ARG_NONCE = "_nonce";
    public static final String XIAOMI_SYNC_ARG_TS = "ts";
    public static final String XIAOMI_SYNC_DATA_SECTION = "section";
    public static final String XIAOMI_SYNC_DATA_ACTION = "action";
    public static final String XIAOMI_SYNC_DATA_VALUE = "value";

    public static final String XIAOMI_SYNC_DATA_SECTION_DEVICE = "device";
    public static final String XIAOMI_SYNC_DATA_ACTION_UPDATE = "update";
    public static final String XIAOMI_SYNC_DATA_VALUE_DID = "did";
    public static final String XIAOMI_SYNC_DATA_VALUE_TOKEN = "token";
    public static final String XIAOMI_SYNC_DATA_VALUE_NAME = "name";
    public static final String XIAOMI_SYNC_DATA_VALUE_UID = "uid";
    public static final String XIAOMI_SYNC_DATA_VALUE_UPDATETIME = "update_time";
    public static final String XIAOMI_SYNC_DATA_VALUE_MODEL = "model";
    public static final String XIAOMI_SYNC_DATA_VALUE_UPDATETIME_MS = "update_time_millisecond";

    public static final String XIAOMI_SYNC_RET_RESULT_INVALID_JSON = "invalid json data";
    public static final String XIAOMI_SYNC_RET_RESULT_INVALID_FORMAT = "invalid data format";
    public static final String XIAOMI_SYNC_RET_RESULT_UNSUPPORTED_TYPE = "unsupported data type";
    public static final String XIAOMI_SYNC_RET_RESULT_INVALID_USERID = "update failed: invalid xiaomi uid";
    public static final String XIAOMI_SYNC_RET_RESULT_EMPTY_EINUMBER = "update failed: empty ei_number";
    public static final String XIAOMI_SYNC_RET_RESULT_EINUMBER_NOTFOUND = "update failed: ei_number not found";
    public static final String XIAOMI_SYNC_RET_RESULT_ACTION_NOTFOUND = "update failed: action not defined";
    public static final String XIAOMI_SYNC_RET_RESULT_OUT_OF_DATE =
        "update failed: update time is earlier than the time when the device last updates";
    public static final String XIAOMI_SYNC_RET_RESULT_NO_DATA_SECTION = "update failed: no data section";
    public static final String XIAOMI_SYNC_RET_RESULT_INVALID_DATA_SECTION = "invalid data section";
    public static final String XIAOMI_SYNC_RET_RESULT_RETRY_REQUIRED = "retry required";

    public static final String XIAOMI_RET_MESSAGE_OK = "ok";
    public static final String XIAOMI_RET_MESSAGE_DENY = "permission denied";
    public static final String XIAOMI_RET_MESSAGE_TIMEOUT = "request time out";
    public static final String XIAOMI_RET_MESSAGE_SERVERERR = "internal exception occurred from server";
    public static final String XIAOMI_RET_MESSAGE_DEVICEERR = "internal exception occurred from device";
    public static final String XIAOMI_RET_MESSAGE_INVALID = "invalid request";
    public static final String XIAOMI_RET_MESSAGE_UNKNOWNDEVICE = "unknown device id";
    public static final String XIAOMI_RET_MESSAGE_UNKNOWN = "unknown error";
    public static final String XIAOMI_RET_MESSAGE_REPEATED = "repeated request";
    public static final String XIAOMI_RET_MESSAGE_FREQUENT = "frequent request";
    public static final String XIAOMI_RET_MESSAGE_MAXSHARE = "maximal share request";
    public static final String XIAOMI_RET_MESSAGE_INVALIDUSERID = "invalid uid (miid)";
    public static final String XIAOMI_RET_MESSAGE_INVALIDEVENTTYPE = "invalid event type";
    public static final String XIAOMI_RET_MESSAGE_INCONSISTENTDATA = "data is inconsistent with database";

    public static final String XIAOMI_SYNC_TO_URI_BIND = "/open/device/bind";
    public static final String XIAOMI_SYNC_TO_URI_UNBIND = "/open/device/unbind";
    public static final String XIAOMI_SYNC_TO_URI_LISTSCENE = "/open/scene/list";
    public static final String XIAOMI_SYNC_TO_URI_EDITSCENE = "/open/scene/edit";
    public static final String XIAOMI_SYNC_TO_DATA_MODEL = "yunyi.camera.v1";

    public static final String XIAOMI_ACCOUNT_ID_SYSDICT_NAME = "xiaomi_sync_account_id";
    public static final String XIAOMI_ACCOUNT_KEY_SYSDICT_NAME = "xiaomi_sync_account_key";
    public static final String XIAOMI_MIGRATE_HOST_SYSDICT_NAME = "migrate_xiaomi_host";
    public static final String XIAOMI_MIGRATE_SWITCH_SYSDICT_NAME = "migrate_xiaomi_switch";
    public static final String XIAOMI_MIGRATE_PROTOCOL_SYSDICT_NAME = "migrate_xiaomi_protocol";
    public static final String XIAOMI_MIGRATE_METHOD_SYSDICT_NAME = "migrate_xiaomi_method";
    public static final String XIAOMI_FDS_ID_SYSDICT_NAME = "xiaomi_fds_id";
    public static final String XIAOMI_FDS_SECRET_SYSDICT_NAME = "xiaomi_fds_secret";
    public static final String XIAOMI_FDS_REGION_NAME = "mi_fds_region";

    public static final String XIAOMI_DID_PREFIX = "yunyi";

    public static final String DECRYPT_DATA_FILTER_PARAM_HTTP_METHOD_KEY = "http_method";
    public static final String MI_SYNC_GATED_LAUNCH_FILTER_PARAM_TEST_START = "test_start";
    public static final String MI_SYNC_GATED_LAUNCH_FILTER_PARAM_TEST_END = "test_end";
    public static final String PASSPORT_CALLBACK_FILTER_PARAM_EXPIRE_MIN_KEY = "expire_minutes";

    public static final String MI_EVENT_VIDEO_BUCKET = "yimotiondetection";
    public static final String MI_USER_FILE_BUCKET = "publicfiles";

    // default language and timezone
    // public static final String DEFAULT_TIMEZONE = GlobalConfig.getConfigValue("default.timezone", null);
    // public static final String DEFAULT_LANGUAGE = GlobalConfig.getConfigValue("default.languate", null);
    // public static final String DEFAULT_LOCATION = GlobalConfig.getConfigValue("default.location", null);
    // public static final String DEFAULT_COUNTRY = GlobalConfig.getConfigValue("default.country", null);

    public static final String ID_ALERT_TIME = "ID_ALERT_TIME";
    public static final String ID_ALERT_BODY = "ID_ALERT_BODY";
    public static final String ID_ALERT_TITLE_WITH_NAME = "ID_ALERT_TITLE_WITH_NAME";
    public static final String ID_ALERT_TITLE_WITHOUT_NAME = "ID_ALERT_TITLE_WITHOUT_NAME";
    public static final String ID_PEOPLE_DETECT_BODY = "ID_PEOPLE_DETECT_BODY";
    public static final String ID_PEOPLE_DETECT_TITLE_WITH_NAME = "ID_PEOPLE_DETECT_TITLE_WITH_NAME";
    public static final String ID_PEOPLE_DETECT_TITLE_WITHOUT_NAME = "ID_PEOPLE_DETECT_TITLE_WITHOUT_NAME";
    public static final String ID_GESTURE_DETECT_BODY = "ID_GESTURE_DETECT_BODY";
    public static final String ID_GESTURE_DETECT_TITLE_WITH_NAME = "ID_GESTURE_DETECT_TITLE_WITH_NAME";
    public static final String ID_GESTURE_DETECT_TITLE_WITHOUT_NAME = "ID_GESTURE_DETECT_TITLE_WITHOUT_NAME";
    public static final String ID_CRYING_DETECT_BODY = "ID_CRYING_DETECT_BODY";
    public static final String ID_CRYING_DETECT_TITLE_WITH_NAME = "ID_CRYING_DETECT_TITLE_WITH_NAME";
    public static final String ID_CRYING_DETECT_TITLE_WITHOUT_NAME = "ID_CRYING_DETECT_TITLE_WITHOUT_NAME";
    public static final String ID_MOTION_TRACKING_BODY = "ID_MOTION_TRACKING_BODY";
    public static final String ID_MOTION_TRACKING_TITLE_WITH_NAME = "ID_MOTION_TRACKING_TITLE_WITH_NAME";
    public static final String ID_MOTION_TRACKING_TITLE_WITHOUT_NAME = "ID_MOTION_TRACKING_TITLE_WITHOUT_NAME";
    public static final String ID_ABNORMAL_AUDIO_DETECT_BODY = "ID_ABNORMAL_AUDIO_DETECT_BODY";
    public static final String ID_ABNORMAL_AUDIO_DETECT_TITLE_WITH_NAME = "ID_ABNORMAL_AUDIO_DETECT_TITLE_WITH_NAME";
    public static final String ID_ABNORMAL_AUDIO_DETECT_TITLE_WITHOUT_NAME =
        "ID_ABNORMAL_AUDIO_DETECT_TITLE_WITHOUT_NAME";
    public static final String ID_PANO_BODY = "ID_PANO_BODY";
    public static final String ID_PANO_TITLE_WITH_NAME = "ID_PANO_TITLE_WITH_NAME";
    public static final String ID_PANO_TITLE_WITHOUT_NAME = "ID_PANO_TITLE_WITHOUT_NAME";
    public static final String ID_CAPTURE_PIC_BODY = "ID_CAPTURE_PIC_BODY";
    public static final String ID_CAPTURE_PIC_TITLE_WITH_NAME = "ID_CAPTURE_PIC_TITLE_WITH_NAME";
    public static final String ID_CAPTURE_PIC_TITLE_WITHOUT_NAME = "ID_CAPTURE_PIC_TITLE_WITHOUT_NAME";
    public static final String ID_CAPTURE_VIDEO_BODY = "ID_CAPTURE_VIDEO_BODY";
    public static final String ID_CAPTURE_VIDEO_TITLE_WITH_NAME = "ID_CAPTURE_VIDEO_TITLE_WITH_NAME";
    public static final String ID_CAPTURE_VIDEO_TITLE_WITHOUT_NAME = "ID_CAPTURE_VIDEO_TITLE_WITHOUT_NAME";
    public static final String ID_DEVICE_DEFAULT_NAME = "ID_DEVICE_DEFAULT_NAME";
    public static final String ID_DOME_DEVICE_DEFAULT_NAME = "ID_DOME_DEVICE_DEFAULT_NAME";
    public static final String ID_KAMI_DEVICE_DEFAULT_NAME = "ID_KAMI_DEVICE_DEFAULT_NAME";
    public static final String ID_KAMI_WIREFREE_CAMERA_DEFAULT_NAME = "ID_KAMI_WIREFREE_CAMERA_DEFAULT_NAME";
    public static final String ID_KAMI_HUB_DEFAULT_NAME = "ID_KAMI_HUB_DEFAULT_NAME";
    public static final String ID_KAMI_ENTRY_SENSOR_DEFAULT_NAME = "ID_KAMI_ENTRY_SENSOR_DEFAULT_NAME";
    public static final String ID_KAMI_WIREFREE_CAMERA_BIND_BODY = "ID_KAMI_WIREFREE_CAMERA_BIND_BODY";
    public static final String ID_KAMI_ENTRY_SENSOR_OPENED_DETECT_BODY = "ID_KAMI_ENTRY_SENSOR_OPENED_DETECT_BODY";
    public static final String ID_KAMI_ENTRY_SENSOR_CLOSED_DETECT_BODY = "ID_KAMI_ENTRY_SENSOR_CLOSED_DETECT_BODY";
    public static final String ID_KAMI_MOTION_SENSOR_DEFAULT_NAME = "ID_KAMI_MOTION_SENSOR_DEFAULT_NAME";
    public static final String ID_KAMI_MOTION_SENSOR_MOTION_DETECT_BODY = "ID_KAMI_MOTION_SENSOR_MOTION_DETECT_BODY";
    public static final String ID_KAMI_G_SENSOR_MOTION_DETECT_BODY = "ID_KAMI_G_SENSOR_MOTION_DETECT_BODY";
    public static final String ID_KAMI_WIREFREE_CAMERA_AWD_DETECT_BODY = "ID_KAMI_WIREFREE_CAMERA_AWD_DETECT_BODY";

    public static final String ID_MAIL_ACTIVATION_TITLE = "ID_MAIL_ACTIVATION_TITLE";
    public static final String ID_MAIL_ACTIVATION_BODY = "ID_MAIL_ACTIVATION_BODY";
    public static final String ID_MAIL_RESET_TITLE = "ID_MAIL_RESET_TITLE";
    public static final String ID_MAIL_RESET_BODY = "ID_MAIL_RESET_BODY";
    public static final String ID_DEFAULT_NICKNAME_VALUE = "ID_DEFAULT_NICKNAME_VALUE";
    public static final String ID_OP_PAYAPL_FAILURE_INTIATE_ECTRANS = "ID_OP_PAYAPL_FAILURE_INTIATE_ECTRANS";
    public static final String ID_OP_PAYPAL_FAILURE_TRANSDETAILS = "ID_OP_PAYPAL_FAILURE_TRANSDETAILS";
    public static final String ID_OP_PAYPAL_FAILURE_ORDER_CREATION = "ID_OP_PAYPAL_FAILURE_ORDER_CREATION";
    public static final String ID_OP_PAYPAL_FAILURE_ONESUB_ALLOWED = "ID_OP_PAYPAL_FAILURE_ONESUB_ALLOWED";
    public static final String ID_OP_PAYPAL_FAILURE_SUB_CREATION_1 = "ID_OP_PAYPAL_FAILURE_SUB_CREATION_1";
    public static final String ID_OP_PAYPAL_FAILURE_SUB_CREATION_2 = "ID_OP_PAYPAL_FAILURE_SUB_CREATION_2";
    public static final String ID_OP_PAYPAL_FAILURE_SYNC_PROFILEID = "ID_OP_PAYPAL_FAILURE_SYNC_PROFILEID";
    public static final String ID_OP_PAYPAL_FAILURE_ERROR_MSGFROM = "ID_OP_PAYAPL_FAILURE_INTIATE_ECTRANS";
    public static final String ID_OP_PAYPAL_FAILURE_EXCEPTION_RETURNPAGE = "ID_OP_PAYAPL_FAILURE_INTIATE_ECTRANS";
    public static final String ID_OP_SUBSCRIPTION_NOTRIAL_FAILURE = "ID_OP_SUBSCRIPTION_NOTRIAL_FAILURE";
    public static final String ID_OP_UID_NOALLOWED_SUBMITORDER_FAILURE = "ID_OP_UID_NOALLOWED_SUBMITORDER_FAILURE";
    public static final String ID_EQUIPMENTSHARE_INVITE = "ID_EQUIPMENTSHARE_INVITE";
    public static final String ID_EQUIPMENTSHARE_ACCEPT = "ID_EQUIPMENTSHARE_ACCEPT";
    public static final String ID_EQUIPMENTSHARE_REJECT = "ID_EQUIPMENTSHARE_REJECT";
    public static final String ID_EQUIPMENTSHARE_REMOVE_INVITOR = "ID_EQUIPMENTSHARE_REMOVE_INVITOR";
    public static final String ID_EQUIPMENTSHARE_REMOVE_INVITEE = "ID_EQUIPMENTSHARE_REMOVE_INVITEE";
    public static final String ID_EQUIPMENTSHARE_TITLE = "ID_EQUIPMENTSHARE_TITLE";
    public static final String ID_NEUTRAL_EQUIPMENTSHARE_INVITE = "ID_NEUTRAL_EQUIPMENTSHARE_INVITE";
    public static final String ID_NEUTRAL_EQUIPMENTSHARE_ACCEPT = "ID_NEUTRAL_EQUIPMENTSHARE_ACCEPT";
    public static final String ID_NEUTRAL_EQUIPMENTSHARE_REJECT = "ID_NEUTRAL_EQUIPMENTSHARE_REJECT";
    public static final String ID_NEUTRAL_EQUIPMENTSHARE_REMOVE_INVITOR = "ID_NEUTRAL_EQUIPMENTSHARE_REMOVE_INVITOR";
    public static final String ID_NEUTRAL_EQUIPMENTSHARE_REMOVE_INVITEE = "ID_NEUTRAL_EQUIPMENTSHARE_REMOVE_INVITEE";

    public static final String ID_MSG_BODY_LOGIN_NOTIFICATION = "MSG_BODY_LOGIN_NOTIFICATION";
    public static final String ID_MSG_TITLE_LOGIN_NOTIFICATION = "MSG_TITLE_LOGIN_NOTIFICATION";

    public static final String ID_MSG_TITLE_DEVICE_NOTIFICATION = "ID_MSG_TITLE_DEVICE_NOTIFICATION";

    // public static final String ID_MSG_BODY_DEVICE_OFFLINE = "MSG_BODY_DEVICE_OFFLINE";
    // public static final String ID_MSG_BODY_DEVICE_WAKE_FREQUENTLY = "MSG_BODY_DEVICE_WAKE_FREQUENTLY";
    // public static final String ID_MSG_BODY_DEVICE_LIMITED_BANDWIDTH = "MSG_BODY_DEVICE_LIMITED_BANDWIDTH";
    // public static final String ID_MSG_BODY_DEVICE_HIGH_TEMPERATURE = "MSG_BODY_DEVICE_HIGH_TEMPERATURE";
    // public static final String ID_MSG_BODY_DEVICE_LOW_TEMPERATURE = "MSG_BODY_DEVICE_LOW_TEMPERATURE";
    // public static final String ID_MSG_BODY_DEVICE_WASTING_POWER = "MSG_BODY_DEVICE_WASTING_POWER";
    // ip check

    public static final String IPCHECK_DID_VERSION_DATE = "ipcheck_did_version_date";

    public static final String PWD_SALT = "rdstdMk8";
    public static final String USERID_HASH_KEY = "w77SvPBFv9Pmuynd";
    public static final String VALIDATION_CODE_KEY = "sXGGPRwCcylzzJ2O";
    public static final Long ACCOUNT_ACTIVATION_EXPIRE = 1800000L; // 30 mins
    public static final Long ACCOUNT_RESET_EXPIRE = 600000L; // 10 mins
    public static final Long VALIDATION_CODE_EXPIRE = 60000L; // 60 seconds
    public static final int UploadExpiresMinutes = 30;

    public static final String PASSPORT_HOST_SYSDICT_NAME = "passport_host";
    public static final String PASSPORT_APPID_SYSDICT_NAME = "passport_app_id";
    public static final String PASSPORT_APPKEY_SYSDICT_NAME = "passport_app_key";

    public static final int DEFAULT_IMAGE_INTERVAL = 180;

    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int DEFAULT_UPLOAD_EXPIRE = 3600;

    public enum PushInterval {
        Low, Middle, High
    }

    /**
     * algo data max people counting data: 31 days
     */
    public static final long MAX_PEOPLE_COUNTING_DATA_TIME = 31L * 24L * 3600L * 1000L;
    public static final int TYPE_PEOPLE_COUNTING = 1;

    // server id
//    public static final String MY_SERVER_ID = GlobalConfig.getConfigValue("my_server_id", null);

    public enum Protocol {
        HTTP("http"), HTTPS("https");

        private final String protocol;

        private Protocol(String protocol) {
            this.protocol = protocol;
        }

        @Override
        public String toString() {
            return protocol;
        }
    }

    public enum Version {
        NONE("v0"), V1("v1"), V2("v2"), V3("v3"), V4("v4"), V5("v5");
        private String code;
        private static final Map<String, Version> REFERRER_VERSIONS;
        static {
            Map<String, Version> refererVersions = new HashMap<String, Version>();
            for (Version version : Version.values()) {
                refererVersions.put(version.getCode(), version);
            }
            REFERRER_VERSIONS = Collections.unmodifiableMap(refererVersions);
        }

        private Version(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }

        public static Version exValueOf(String code) {
            String lowerCode = StringUtils.lowerCase(code);
            return StringUtils.isEmpty(lowerCode) ? Version.NONE : REFERRER_VERSIONS.get(lowerCode);
        }

        public boolean after(Version version) {
            if (null == version) {
                return true;
            }
            return this.code.compareTo(version.getCode()) > 0;
        }

        public boolean before(Version version) {
            if (null == version) {
                return true;
            }
            return this.code.compareTo(version.getCode()) < 0;
        }
    }

    public enum CloudDeviceWorkMode {
        WORK_MODE_EVENT_TRIGGER(0), WORK_MODE_FULL_DAY(1), WORK_MODE_ON_LIVE(2);
        private final int mode;

        private CloudDeviceWorkMode(int mode) {
            this.mode = mode;
        }

        public static CloudDeviceWorkMode valueOf(Short mode) {
            if (null == mode) {
                return Constants.defaultDevWorkMode;
            }
            for (CloudDeviceWorkMode workMode : CloudDeviceWorkMode.values()) {
                if (workMode.mode == mode) {
                    return workMode;
                }
            }
            return Constants.defaultDevWorkMode;
        }

        public short getCode() {
            return (short)this.mode;
        }

        @Override
        public String toString() {
            return String.valueOf(this.mode);
        }
    }

    public static final CloudDeviceWorkMode defaultDevWorkMode = CloudDeviceWorkMode.WORK_MODE_FULL_DAY;

    public static final String ORERPAYMENT_UID_SEPERATOR = ",";

    public static final String ORDERPAYMENT_HOST_SYSDICT_NAME = "orderpayment_host";
    public static final String ORDERPAYMENT_APPID_SYSDICT_NAME = "orderpayment_app_id";
    public static final String ORDERPAYMENT_APPKEY_SYSDICT_NAME = "orderpayment_app_value";
    public static final String ORDERPAYMENT_DHPAY_APPID_SYSDICT_NAME = "orderpayment_dhpay_id";

    public static final String ORDERPAYMENT_CALLBACK_FILTER_PARAM_EXPIRE_MIN_KEY = "expire_minutes";
    public static final int ORDERPAYMENT_UNPAIDORDER_EXPIRE_HOURS = -24;

    public static final String ORDERPAYMENT_PRODUCT_CHANNEL_FOR_CHARGECARD = "3";

    public enum AppType {
        Android, iOS, Android_Neutral, IOS_Neutral, Android_Kami, IOS_Kami
    }

    public class PCPosition {
        public static final int Header = 2;
    }

    public enum BillingPeriodUnit {
        DAY("Day"), WEEK("Week"), SEMIMONTH("SemiMonth"), MONTH("Month"), YEAR("Year");
        private String _value;

        private BillingPeriodUnit(String value) {
            this._value = value;
        }

        public String value() {
            return _value;
        }

        @Override
        public String toString() {
            return String.valueOf(this._value);
        }
    }

    public enum AdEMailPush {
        OFF(0), ON(1);

        private int _value;

        private AdEMailPush(int value) {
            this._value = value;
        }

        public int value() {
            return _value;
        }

        @Override
        public String toString() {
            return String.valueOf(this._value);
        }
    }

    public static final String PP_TRIALPERIOD_UNIT = "Month";
    public static final String PP_BILLINGPERIOD_UNIT = "Month";
    public static final String PP_TRIALPERIOD = "1";
    public static final String PRODUCTID_TRIALPERIOD = "18";
    public static final int SERVICETIME_TRIALPERIOD = 15;

    public static final String EI_NUMBER_SEPARATOR = ",";
    public static final String EI_NUMBER_NULL_IN_DB = " "; // the value of ei_number is set into tb_order_info if no any
                                                           // ei_number selected for this order.
    public static final int MAX_NUMBER_COUPON_ALLOWED = 5;
    public static final String APPLE_IAP_TRIAL_PAYCODE = "trialperiod";
    public static final String APPLE_IAP_PRODUCT_CHANNEL = "5";

    public static final String USERMODEL_HOST_SYSDICT_NAME = "usermodel_host";
    public static final String USERMODEL_PRODID_SYSDICT_NAME = "usermodel_prod_id";
    public static final String USERMODEL_KEY_SYSDICT_NAME = "usermodel_key";

    public static final int DEFAULT_MULTI_DOWNLOADER_THRESHOLD = 3;

    public static final String SHARE_HOST = "www.yitechnology.com";

    public static final int BIND_CHECK_INTERVAL_SECONDS = 3;
    public static final int BIND_CODE_LENTH = 14;
    public static final int BIND_CODE_EXPIRE_AFTER_SECONDS = 300;

    public static final int AUTH_LOGIN_TYPE_XIAOMI = 1;
    public static final int AUTH_LOGIN_TYPE_WEIBO = 2;
    public static final int AUTH_LOGIN_TYPE_QQ = 3;
}
