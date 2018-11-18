package com.example.rostelecom.web;

import com.example.rostelecom.beans.RequestXML;
import com.example.rostelecom.service.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/main")
    public RequestXML getRequestXML(HttpServletRequest request){
        //
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        List<String> par=new ArrayList<>();
        while(enumeration.hasMoreElements()){
            par.add((String) enumeration.nextElement());
        }
        //

        double[] a={1,2};
        String[] b={"Test1", "Test2"};
        return new RequestXML(a, par.toArray(new String[0]));
    }


}
