package org.es4j.eventstore.serlization.acceptance;

import org.es4j.eventstore.serlization.acceptance.cli.Launcher;


class Es4jCli/*Thermostat*/ {

    private static Launcher launcher = new Launcher();

    public static void main(String[] args) {
        launcher.run(args);
    }

    static void setLauncher(Launcher launcher) {
        Es4jCli/*Thermostat*/.launcher = launcher;
    }
}
