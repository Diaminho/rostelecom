package com.example.rostelecom.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametersParser {

    public static boolean parseParameter(String parameter){
        Pattern p = Pattern.compile("^\\d{1,10}[.,]?((?<=[.,])\\d{0,10}|)$");
        Matcher m = p.matcher(parameter);
        return m.matches();
    }
}