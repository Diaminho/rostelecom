package com.example.rostelecom.web;

import com.example.rostelecom.service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import java.util.*;

@RestController
public class MainController {

    @Autowired
    public MainController() { }

    @RequestMapping("/main")
    public DOMSource getRequestXML(HttpServletRequest request) throws ParserConfigurationException {
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
    }
}