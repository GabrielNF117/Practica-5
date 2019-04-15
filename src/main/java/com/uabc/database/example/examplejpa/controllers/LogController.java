package com.uabc.database.example.examplejpa.controllers;


import com.uabc.database.example.examplejpa.constant.ViewConstant;
import com.uabc.database.example.examplejpa.model.LogModel;
import com.uabc.database.example.examplejpa.service.LogService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/logs")
public class LogController {
    @Autowired
    @Qualifier("logServiceImpl")
    private LogService logService;



    private static final Log log = LogFactory.getLog(LogController.class);

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/logs/showLogs";
    }

    @GetMapping("/logForm")
    public String redirectLogForm(Model model,
                                  @RequestParam(name = "id", required = false) int id){
        LogModel logModel = new LogModel();
        if(id != 0){
            logModel = logService.findLogByIdModel(id);
        }
        model.addAttribute("logModel", logModel);
        return ViewConstant.LOG_FORM;
    }

    @PostMapping("/addlog")
    //El ModelAttribute corresponde con el th:object que utilizamos en la vista de logform
    public String addLog(@ModelAttribute(name = "logModel")LogModel logModel,
                         Model model) throws Exception {
        log.info("Method: addLog() -- Params: "+logModel.toString());
        if(logService.addLog(logModel) != null){
            model.addAttribute("result", 1);//esto es para que se muestre un mensaje de que se agregó éxitosamente
        }else{
            model.addAttribute("result", 0);
        }
        return "redirect:/logs/showLogs";
    }

    @GetMapping("/showLogs")
    public ModelAndView showLogs(){
        ModelAndView mav = new ModelAndView(ViewConstant.LOGS);
        mav.addObject("logs", logService.listAllLogs());
        return mav;
    }

    @GetMapping("/removeLog")
    public ModelAndView removeLog(@RequestParam(name = "id", required = true) int id){
        logService.removeLog(id);
        return showLogs();
    }
}