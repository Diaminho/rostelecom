package com.example.rostelecom.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLService {

    public XMLService() {}

    public static DOMSource createXML(Map map, List clientInfo, String method) throws ParserConfigurationException {
        Set keySet=map.keySet();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("request_detail");
        doc.appendChild(rootElement);

        //CLIENT INFO
        Element client_info = doc.createElement("client_info");
        rootElement.appendChild(client_info);

        Element ip = doc.createElement("ip-address");
        ip.appendChild(doc.createTextNode((String)clientInfo.get(0)));
        client_info.appendChild(ip);

        Element user_agent = doc.createElement("user_agent");
        user_agent.appendChild(doc.createTextNode((String)clientInfo.get(1)));
        client_info.appendChild(user_agent);
        //END OF CLIENT INFO

        Element parameters = doc.createElement("parameters");
        Attr attr = doc.createAttribute("method");
        attr.setValue(method);
        parameters.setAttributeNode(attr);
        rootElement.appendChild(parameters);

        //NUMERIC PARAMS
        Element numeric_parameters = doc.createElement("numeric_parameters");
        parameters.appendChild(numeric_parameters);

        //String PARAMS
        Element string_parameters = doc.createElement("string_parameters");
        parameters.appendChild(string_parameters);

        for (Object key:keySet){
            Element parameter = doc.createElement("parameter");
            attr = doc.createAttribute("name");
            attr.setValue((String)key);
            parameter.setAttributeNode(attr);
            parameter.appendChild(doc.createTextNode((String)map.get(key)));
            //Parse parameters
            if (ParametersParser.parseParameter((String)map.get(key))){
                numeric_parameters.appendChild(parameter);
            } else {
                string_parameters.appendChild(parameter);
            }
        }

        DOMSource source = new DOMSource(doc);
        return source;
    }
}