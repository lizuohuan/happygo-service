package com.magicbeans.happygo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.magicbeans.happygo.AbstractLogService;
import com.magicbeans.happygo.annotation.BusinessLog;
import com.magicbeans.base.BaseServiceImp;
import com.magicbeans.happygo.entity.Log;
import com.magicbeans.happygo.mapper.LogMapper;
import com.magicbeans.happygo.service.ILogService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author magicbeans
 * @since 2017-12-26
 */
@Service
public class LogServiceImpl extends BaseServiceImp<LogMapper, Log> implements ILogService ,AbstractLogService{


    @Override
    public void saveBusinessLog(BusinessLog businessLog,String ip,LogType logType) {
        Log log = new Log();
        log.setIp(ip);
        log.setType(logType);
        log.setContent(businessLog.instruction());
        log.setModule(businessLog.bussinessModel());
        mapper.insert(log);
    }

    @Override
    public void saveRequestLog(LogType type, String url, String method, String ip, String className, Map<String, String[]> paramsMap) {
        Log log = new Log();
        log.setIp(ip);
        log.setType(type);
        JSONObject contentObj = new JSONObject();
        contentObj.put("url",url);
        contentObj.put("method",method);
        contentObj.put("className",className);
        contentObj.put("params",paramsMap);
        log.setContent(contentObj.toJSONString());
        mapper.insert(log);
    }

    @Override
    public void saveExceptionLog(LogType logType, BusinessLog businessLog, Throwable e) {
        Log log = new Log();
        log.setContent(businessLog.instruction()+"--"+JSON.toJSONString(e));
        log.setType(logType);
        log.setModule(businessLog.bussinessModel());
        mapper.insert(log);
    }
}
