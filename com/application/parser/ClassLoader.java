package com.application.parser;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.ArrayList;

/**
 * Created by GUNGUI on 10/7/2017.
 */
class ClassLoader{
    private ArrayList<Class> classes;
    ClassLoader(String dir) throws IOException, ClassNotFoundException {
        if(dir == null)
            throw new java.lang.IllegalArgumentException("NULL file dir is not accepted");
        if(dir.endsWith(".jar"))
            fileLoader(dir);
        else
            dirLoader(dir);
    }
    private void fileLoader(String pathToJar) throws IOException, ClassNotFoundException {
        JarFile jarFile = new JarFile(pathToJar);
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = {new URL("jar:file:" + pathToJar + "!/")};
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            classes.add(cl.loadClass(className));
        }
    }
    private void dirLoader(String dir){
        //TODO
    }
}
