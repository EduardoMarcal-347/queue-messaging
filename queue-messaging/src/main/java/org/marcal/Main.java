package org.marcal;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
    }
}