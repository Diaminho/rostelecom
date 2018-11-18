package com.example.rostelecom.beans;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class RequestXML {
    double[] numeric_parameter;
    String[] string_parametr;
    Map atribValues;

    public double[] getNumeric_parameter() {
        return numeric_parameter;
    }

    @XmlElement
    public void setNumeric_parameter(double[] numeric_parameter) {
        this.numeric_parameter = numeric_parameter;
    }

    public String[] getString_parametr() {
        return string_parametr;
    }

    @XmlElement
    public void setString_parametr(String[] string_parametr) {
        this.string_parametr = string_parametr;
    }

    public RequestXML(String[] string_parametr) {
        this.string_parametr = string_parametr;
    }


}
