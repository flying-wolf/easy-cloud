package com.superm.easy.cloud.commons.constant;

/** 
 * @author hu.sheng
 * @since 20190425
 */
public class MessageConstants {

	public static final String JSON_EXCEPTION_CODE = "-10000";
	public static final String PARSE_EXCEPTION_CODE = "-10001";
	public static final String AES_EXCEPTION_CODE = "-10002";

	public static final String EXCEPTION_CODE = "-10003";

	public static final String V2_VERSION_EXCEPTION_CODE = "-10004";

	public static final String ERR_INVALID_TOKEN_TYPE = "20301";
	public static final String ERR_INVALID_USER_ID = "20302";
	public static final String ERR_USER_LOCKED = "20303";
	public static final String ERR_USER_EXISTED = "20304";
	//	public static final String PARSE_EXCEPTION_CODE = "20002";

	/*********************************************二期错误代码********************************************/

	public static final String V2_SUCCESS_CODE = "20000";
	public static final String V2_RESULT_EMPTY_CODE = "20200";
	public static final String V2_HMAC_REQUIRED_CODE = "20201";
	public static final String V2_HMAC_INVALID_CODE = "20202";

	public static final String V2_SEQ_REQUIRED_CODE = "20203";
	public static final String V2_SEQ_INVALID_CODE = "20204";

	public static final String V2_VERSION_REQUIRED_CODE = "20205";
	public static final String V2_MODEL_REQUIRED_CODE = "20206";

	public static final String V2_FILETYPE_REQUIRED_CODE = "20207";
	public static final String V2_FULLNAME_REQUIRED_CODE = "20208";
	public static final String V2_DURATION_REQUIRED_CODE = "20209";
	public static final String V2_STARTTIME_REQUIRED_CODE = "20210";
	public static final String V2_ENDTIME_REQUIRED_CODE = "20211";
	public static final String V2_ORDER_REQUIRED_CODE = "20212";
	public static final String V2_AUTHCODE_REQUIRED_CODE = "20213";
	public static final String V2_AUTHTYPE_REQUIRED_CODE = "20214";
	public static final String V2_AUTHTYPE_INVALID_CODE = "20215";

	public static final String V2_MAC_REQUIRED_CODE = "20216";
	public static final String V2_MAC_INVALID_CODE = "20217";

	public static final String V2_QRCODE_REQUIRED_CODE = "20218";
	public static final String V2_QRCODE_INVALID_CODE = "20219";
	public static final String V2_QRCODE_DUPAUTH_CODE = "20220";
	
	public static final String V2_TOKEN_REQUIRED_CODE = "20230";
	public static final String V2_TOKEN_INVALID_CODE = "20231";
	public static final String V2_TOKEN_RENEW_CODE = "20232";

	public static final String V2_UID_REQUIRED_CODE = "20240";
	public static final String V2_UID_INVALID_CODE = "20241";
	public static final String V2_UID_NOT_EXIST_CODE = "20242";
	public static final String V2_UID_BOUND_CODE = "20243";

	public static final String V2_ACCOUNT_REQUIRED_CODE = "20250";
	public static final String V2_ACCOUNT_FORMAT_INCORRECT_CODE = "20251";
	public static final String V2_ACCOUNT_INVALID_CODE = "20252";
	public static final String V2_ACCOUNT_NOT_EXIST_CODE = "20253";
	public static final String V2_ACCOUNT_IS_EXIST_CODE = "20254";

	public static final String V2_PASSWORD_REQUIRED_CODE = "20260";
	public static final String V2_PASSWORD_INVALID_CODE = "20261";
	public static final String V2_PASSWORD_LENGTH_INVALID_CODE = "20262";

	public static final String V2_TYPE_REQUIRED_CODE = "20265";
	public static final String V2_TYPE_INVALID_CODE = "20266";
	public static final String V2_NUMBER_REQUIRED_CODE = "20267";
	public static final String V2_NUMBER_INVALID_CODE = "20268";

	public static final String V2_TIME_REQUIRED_CODE = "20270";
	public static final String V2_MD5_REQUIRED_CODE = "20271";
	public static final String V2_TIMEOUT_CODE = "20272";
	public static final String V2_NONE_REQUIRED_CODE = "20273";
	public static final String V2_APP_REJECT_CODE = "20274";

	public static final String V2_AUTH_LOGIN_ERROR_CODE = "20280";

	public static final String V2_APP_VERSION_REQUIRED_CODE = "20290";

	public static final String V2_SYNC_FAILED_CODE = "20300";

	public static final String V3_INTER_VERSION_REQUIRED_CODE = "30101";
	public static final String V3_BINDPASS_REQUIRED_CODE = "30102";
	public static final String V3_BINDPASS_INVALID_CODE = "30103";
	public static final String V3_BIND_LIMIT_CODE = "30104";
	public static final String V3_BINDPASS_TIMEOUT_CODE = "30105";
	public static final String V3_INTERFACE_VERSION_INVALID_CODE = "30201";

	public static final String V3_PUSH_FLAG_REQUIRED_CODE = "30301";
	public static final String V3_PUSH_FLAG_INVALID_CODE = "30302";
	public static final String V3_UPLOAD_FLAG_REQUIRED_CODE = "30303";
	public static final String V3_UPLOAD_FLAG_INVALID_CODE = "30304";

	public static final String V3_REGISTER_FORBIDDEN_CODE = "30301";
	public static final String V3_ADD_FORBIDDEN_CODE = "30302";

	public static final String V4_PARAM_INVALID_CODE = "40000";
	public static final String V4_SUFFIX_REQUIRED_CODE = "40101";
	public static final String V4_TOO_MANY = "40102";
	public static final String V4_PINCODE_MISMATCH = "40103";
	public static final String V4_PINCODE_REQUIRED_CODE = "40104";

	public static final String V4_ACCOUNT_INACTIVATE_CODE = "40110";
	public static final String V4_ACCOUNT_VALIDATION_MISMATCH_CODE = "40111";
	public static final String V4_ACCOUNT_VALIDATION_EXPIRE_CODE = "40112";
	public static final String V4_ACCOUNT_SEND_MAIL_FAIL_CODE = "40113";
	public static final String V4_ACCOUNT_ACTIVATE_CODE = "40114";
	public static final String V4_VALIDATION_CODE_FAIL_CODE = "40120";
	public static final String V4_REQUEST_FAILED_CODE = "40122";
	
	public static final String V4_TNP_INVALID_ID = "40201";
	public static final String V4_TNP_INVALID_IP = "40202";

	public static final String V4_INTERNAL_ERROR_CODE = "40222";
	public static final String V4_PROCCESS_FAILED_CODE = "40300";

	public static final String V4_SERVICE_DISABLED   = "40401";
	public static final String V4_SERVICE_EXPIRED   = "40402";
	public static final String V4_TASK_TYPE_UNSUPPORT   = "40450";
	public static final String V4_TASK_TASK_NOT_FOUND   = "40451";
	public static final String V4_TASK_PROC_NOT_ALLOWED   = "40452";

	public static final String V4_SHAREINVITATION_EXPIRED_CODE="41401";
	public static final String V4_SHARENUMBER_EXCEEDED_CODE="41402";
	public static final String V4_SHAREDEVICE_DUPLICATED_CODE="41403";
	public static final String V4_SHAREINVITATION_SHARETOKEN_INVALID_CODE="41404";
	public static final String V4_SHAREINVITATION_SHARETOKEN_REQUIRED_CODE="41405";
	public static final String V4_SHAREDEVICE_SHARERECORD_NOTEIXIST_CODE="41406";
	public static final String V4_SHAREDEVICE_GETPASSWORD_FAILURE_CODE="41407";
	public static final String V4_SHAREDEVICE_LANGUAGE_INVALID_CODE="41408";
	public static final String V4_SHAREDEVICE_CANNT_SHARETOYOUSELF_CODE="41409";
	public static final String V4_SHAREINVITATION_INVALID_STATE = "41410";
	public static final String V4_SHAREINVITATION_INVALID_ID = "41411";
	public static final String V4_SHAREDEVICE_EXIST = "41412";
	public static final String V4_SHAREINVITATION_EXIST = "41413";
	public static final String V4_SHAREINVITATION_INVALID_SHARDTO_ID = "41414";

	public static final String V5_PUSH_INVALID_TIME_PERIOD = "50101";
	public static final String V5_DATA_REQUIRED_CODE = "50102";
	
	public static final String V5_DEVICE_PINCODE_MISMATCH_CODE = "51125";

	public static final String V5_INVALID_PRODUCTID_FAILURE_CODE="51004";
	public static final String V5_PRODUCTCHANNEL_REQUIRED_CODE = "51005";
	public static final String V5_PRODUCTCHANNEL_INVALID_CODE = "51006";
	public static final String V5_PRODUCTCURRENCY_REQUIRED_CODE = "51007";
	public static final String V5_ORDERCODE_REQUIRED_CODE = "51008";
	public static final String V5_PAYRESULT_REQUIRED_CODE = "51009";
	public static final String V5_UNPAIDORDER_EXISTS_CODE = "51010";
	public static final String V5_ORDER_NOTEXISTS_CODE = "51011";
	public static final String V5_CANCEL_ORDER_FAILURE_CODE = "51012";
	public static final String V5_ONLYUNPAIDCORDER_CANBECANCELLED_CODE = "51013";
	public static final String V5_PRODUCTNAME_REQUIRED_CODE = "51014";
	public static final String V5_PRODUCTDESCRIPTION_REQUIRED_CODE = "51015";
	public static final String V5_DEVICE_NOCSCHARGECARD_CODE = "51016";
	public static final String V5_ORDERCODE_DUPLICATED_CODE = "51017";
	public static final String V5_CSCHARGE_PASSWORD_INVALID_CODE = "51018";
	public static final String V5_CSCHARGE_SKU_INVALID_CODE = "51019";
	public static final String V5_PAYMENTTYPE_REQURIED_CODE = "51020";
	public static final String V5_PAYMENTTYPE_REQUIRED_CODE = "51021";
	public static final String V5_UID_NOTALLOWED_SUBMITORDER_CODE = "51022";
	public static final String V5_PRODUCTATTRIBUTE_INVALID_CODE = "51023";
	public static final String V5_PRODUCTID_INVALID_CODE = "51024";
	
	public static final String V5_PREMIUM_ABILITY_EXPIRED = "51051";
	
	public static final String V5_REQUEST_FAILED_CODE = "51122";
	public static final String V5_QUERY_NOORDER_CODE = "51123";
  	public static final String V5_BRAINTBREE_SUBSCRIPTIONACTIVE_CODE = "51124";
	public static final String V5_BRAINTBREE_INVALIDPAYMENTMETHOD_CODE = "51125";
	public static final String V5_BRAINTBREE_CANCELSUBSCRIPTION_FAILURE_CODE = "51126";
	public static final String V5_BRAINTBREE_GENERATESUBSCRIPTION_FAILURE_CODE = "51127";
	public static final String V5_BRAINTBREE_NOCUSTOMERDRELEATED_FAILURE_CODE = "51128";
	public static final String V5_BRAINTBREE_SUBSCRIPTIONPOSTDUE_FAILURE_CODE = "51129";
	public static final String V5_BRAINTBREE_ACTIVESUBSCRIPTIONALREADY_FAILURE_CODE = "51130";
	public static final String V5_BRAINTBREE_SUBSCRIPTIONINTRIAL_FAILURE_CODE = "51131";
	public static final String V5_BRAINTBREE_SUBSCRIPTIONID_REQUIRED_CODE = "51135";
	public static final String V5_PAYPAL_SUBSCRIPTIONID_REQUIRED_CODE = "51132";
	public static final String V5_PAYPAL_SUBSCRIPTIONID_INVALID_CODE = "51133";
	public static final String V5_SUBSCRIPTIONID_NOTRIAL_CODE = "51134";
	public static final String V5_SUBSCRIPTION_EXIST_CODE = "51135";
 	public static final String V5_COUPON_EXCEED_LIMITEDNUM_CODE = "51136";
	public static final String V5_INVALID_COUPONCODE_CODE = "51137";
	public static final String V5_COUPONCODE_REQUIRED_CODE = "51138";
	public static final String V5_23HOURS_FREETIRAL_EQUIP_MODEL_NOTSUPPORTED_CODE = "51139";
	public static final String V5_23HOURS_FREETIRAL_STATUS_INVALID_CODE = "51140";
	public static final String V5_PAYPAL_ORDERID_ISNULL="51148";
	public static final String V5_23HOURS_FREETIRAL_STATUS_REQUIRED_CODE = "51145";
    
	public static final String V5_APPLEPAY_IAP_RECEIPT_REQUIRED_CODE = "51139";
	public static final String V5_APPLEPAY_IAP_PAYMENT_FAILURE_CODE = "51140";
	public static final String V5_APPLEPAY_IAP_RENEW_ORTHERUSER_CODE = "51141";
	public static final String V5_APPLEPAY_IAP_IDENTIFIER_PRODUCTID_NOMATCH_CODE = "51142";
	public static final String V5_DID_NOT_EXIST = "54003";    
	public static final String V5_CLOUD_SCENE_TYPE_NOT_SUPPORT = "53006";
	public static final String V5_APPLEPAY_IAP_ORDER_PAID_ALREADY = "51143";
	public static final String V5_APPLEPAY_IAP_ORDER_EXIST_ALREADY_CODE = "51146";

	public static final String V5_AESNUM_NOT_EXIST = "54002";
	public static final String V5_MUILTIPLE_EQUIPMENT_OWNER = "54004";
	public static final String V5_RELATION_NOT_EXIST = "54005";
	public static final String V5_RELATION_NOT_MATCHED = "54006";
	public static final String V5_EQUIPMENT_NOT_OWNED_BY_USER = "54007";
	public static final String V5_START_PAGESIZE_ISNULL = "54008";
	public static final String V5_ROUND_ISNULL = "54009"; 
	public static final String V5_PROXIED_DEVICE_INVALID = "54010";
	public static final String V5_DEVICE_NOT_NEW = "54011";
	public static final String V5_DEVICE_IS_NEW = "54012";
	public static final String V5_NOONLIGHT_ERROR = "54013";
}