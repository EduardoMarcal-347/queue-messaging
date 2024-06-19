package org.marcal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.marcal.models.AeroQueue;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
    }
}