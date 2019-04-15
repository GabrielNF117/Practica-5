package com.uabc.database.example.examplejpa.service;

import com.uabc.database.example.examplejpa.entity.Contact;
import com.uabc.database.example.examplejpa.entity.Log;
import com.uabc.database.example.examplejpa.model.ContactModel;
import com.uabc.database.example.examplejpa.model.LogModel;

import java.util.List;

public interface LogService {
    public abstract LogModel addLog(LogModel logModel) throws Exception;

    public abstract List<LogModel> listAllLogs();

    public abstract Log findLogById(int id);

    public abstract void removeLog(int id);

    public abstract LogModel findLogByIdModel(int id);
}
