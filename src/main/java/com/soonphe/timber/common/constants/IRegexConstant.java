package com.soonphe.timber.common.constants;

/**
 * 统一正则验证
 *
 * @author soonphe
 * @since 1.0
 */
public interface IRegexConstant {

    /**
     * 主键id 1~12位
     */
    String ID = "\\d{1,12}";

    /**
     * 手机号码 11位
     */
    String MOBILE = "\\d{11}";

    /**
     * 身证号
     */
    String IDENTITY_NO = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";

    /**
     * YYYY-MM-DD
     */
    String DATE_10 = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))$";


    /**
     * 非特殊字符
     */
    String NON_SPECIAL_CHARACTER = "^(\\w|[^\\x00-\\xff]|[:,-|;])*$";

    /**
     * 汉字 字符
     */
    String CHINESE_CHAR = "^[\\u4E00-\\u9FBF]+$";

    /**
     * 数字型且保留1~2位小数
     */
    String DIGITAL_DECIMAL_2 = "^[0-9]+(.[0-9]{1,2})?$";

    /**
     * 短时间类型
     */
    String SHORT_TIME = "^\\d{2}\\s*:\\s*\\d{2}$";

    /**
     * 逗号和分号分隔的数字字符串
     */
    String MULTI_NUM = "^([0-9]+,[0-9]+;)+$";

}
