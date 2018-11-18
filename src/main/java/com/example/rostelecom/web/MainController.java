package com.example.rostelecom.web;

import com.example.rostelecom.beans.RequestXML;
import com.example.rostelecom.service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import java.util.*;

@RestController
public class MainController {

    //MainService mainService;
    private ModelMap modelMap;

    @Autowired
    public MainController() {
        //this.mainService = new MainService();
        this.modelMap = new ModelMap();
    }

    @RequestMapping("/main")
    public DOMSource getRequestXML(HttpServletRequest request) throws ParserConfigurationException, TransformerConfigurationException {
        //
        String method=request.getMethod();
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> atribValues = new HashMap<>();
        String str="";
        while(enumeration.hasMoreElements()){
            str=(String) enumeration.nextElement();
            atribValues.put(str,request.getParameter(str));

        }

        List clientInfo=new ArrayList();
        clientInfo.add(request.getRemoteAddr());

        clientInfo.add(request.getHeader("User-Agent"));

        DOMSource dom=XMLService.createXML(atribValues, clientInfo, method);
        return dom;
        //
        //String[] arr=atribValues.keySet().toArray(new String[atribValues.keySet().size()]);

        //return new RequestXML(arr);
    }


}
