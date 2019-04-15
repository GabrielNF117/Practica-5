package com.uabc.database.example.examplejpa.components;

import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.LogModel;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("logConverter")
public class LogConverter {

    public Log convertToLogModel2Log(LogModel logModel) throws Exception{
        Log log = new Log();
        //String fecha = logModel.getDate();
        Date fech = new SimpleDateFormat("yyyy-MM-dd").parse(logModel.getDate());
        log.setDate(fech);
        log.setDetails(logModel.getDetails());
        log.setUsername(logModel.getUsername());
        log.setUrl(logModel.getUrl());
        log.setId(logModel.getId());
        return log;
    }

    public LogModel convertLog2LogModel(Log log){
        LogModel logModel = new LogModel();
        logModel.setDate(log.getDate().toString());
        logModel.setDetails(log.getDetails());
        logModel.setUsername(log.getUsername());
        logModel.setUrl(log.getUrl());
        logModel.setId(log.getId());
        return logModel;
    }

}