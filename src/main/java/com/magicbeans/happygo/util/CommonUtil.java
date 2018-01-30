package com.magicbeans.happygo.util;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * 通用工具
 * Created by Eric Xie on 2017/2/13 0013.
 */
public class CommonUtil {




    public static boolean isEmpty(Object... args){
        for (Object arg : args) {
            if(null == arg){
                return true;
            }
            if(arg instanceof String ){
                if( ((String) arg).trim().length() == 0 || "null".equals(arg)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 不为空 为true
     * @param args
     * @return
     */
    public static boolean isEmpty2(Object... args){
        for (Object arg : args) {
            if(null != arg){
                return true;
            }
            if(arg instanceof String ){
                if( ((String) arg).trim().length() > 0 || !"null".equals(arg)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isIdCard(String idCard){

        String reg = "^\\d{15}$|^\\d{17}[0-9Xx]$";
        if (!idCard.matches(reg)) {
            System.out.println("Format Error!");
            return false;
        }
        return true;
    }




    /**
     *  获取手机号的后四位
     * @return
     */
    public static String subMobile(String mobile){
        if(null == mobile || mobile.length() <= 5){
            return "0000";
        }
        return mobile.substring(mobile.length() - 4);
    }

    /**
     *  订单号生成规则
     * @return
     */
    public static String buildOrderNumber(){
        SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmssSSSS");
        return format.format(new Date());
    }


    public static String get32UUID(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }



}
