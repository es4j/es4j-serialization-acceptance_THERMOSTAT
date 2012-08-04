package org.es4j.eventstore.serlization.acceptance;

import org.es4j.eventstore.serlization.acceptance.cli.Launcher;


public class App {

    private static Launcher launcher = new Launcher();

    static void setLauncher(Launcher launcher) {
        App.launcher = launcher;
    }

    public static void main(String[] args) {
        launcher.run(args);
    }
}
