package com.application.parser;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by GUNGUI on 10/7/2017.
 */
public class DataWrapper {
    HashMap<Class,Class> inherent;
    ClassLoader cl;
    public DataWrapper(String dir) throws IOException, ClassNotFoundException {
        cl = new ClassLoader(dir);
    }

}
