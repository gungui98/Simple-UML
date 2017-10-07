package com.application.parser.com.component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by GUNGUI on 10/7/2017.
 */
public class Attributes {
    Field[] fields;
    Attributes(Class cl){
        fields = cl.getDeclaredFields();
    }

    @Override
    public String toString() {
        StringBuilder string= new StringBuilder();
        for(Field i : fields){
            if(i.getType().isPrimitive())
            {
                string.append("-");
            }
            else string.append("+");
            string.append(i.getName()+" : ");
            string.append(i.getType().toString());
        }
        return string.toString();
    }
    private String formalized(String input){
        switch (input){
            case "java.lang.String" :return "String";
        }
        return "";
    }

}
