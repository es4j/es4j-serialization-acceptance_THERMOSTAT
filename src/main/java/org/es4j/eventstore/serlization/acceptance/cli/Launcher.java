package org.es4j.eventstore.serlization.acceptance.cli;


import java.util.Arrays;
import java.util.ServiceLoader;

public class Launcher {

    private String[] args;

    public void run(String[] args) {
        this.args = args;
        registerDefaultCommands();
        if (hasNoArguments()) {
            runHelpCommand();
        } else {
            runCommandFromArguments();
        }
    }

    private boolean hasNoArguments() {
        return args.length == 0;
    }

    private void runHelpCommand() {
        runCommand("help", new String[0]);
    }

    private void runCommandFromArguments() {
        runCommand(args[0], Arrays.copyOfRange(args, 1, args.length));
    }

    private void runCommand(String cmdName, String[] cmdArgs) {
        CommandContextFactory cmdCtxFactory = CommandContextFactory.getInstance();
        CommandRegistry registry = cmdCtxFactory.getCommandRegistry();
        Command cmd = registry.getCommand(cmdName);
        CommandContext ctx = cmdCtxFactory.createContext(cmdArgs);
        runCommandWithContext(cmd, ctx);
    }

    private void runCommandWithContext(Command cmd, CommandContext ctx) {
        try {
            cmd.run(ctx);
        } catch (CommandException e) {
            ctx.getConsole().getError().println(e.getMessage());
        }
    }

    private void registerDefaultCommands() {
        CommandContextFactory  cmdCtxFactory = CommandContextFactory.getInstance();
        CommandRegistry        registry = cmdCtxFactory.getCommandRegistry();
        ServiceLoader<Command> cmds = ServiceLoader.load(Command.class);
        registry.registerCommands(cmds);
    }
}

/*
//package com.redhat.thermostat.cli;

import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceLoader;
import java.util.logging.Level;

//import com.redhat.thermostat.common.config.ClientPreferences;
//import com.redhat.thermostat.common.config.InvalidConfigurationException;
//import com.redhat.thermostat.common.storage.ConnectionException;
//import com.redhat.thermostat.common.utils.LoggingUtils;

public class Launcher {

    private ClientPreferences prefs = new ClientPreferences();

    private String[] args;

    public void run(String[] args) {
        initLogging();
        this.args = args;
        registerDefaultCommands();
        if (hasNoArguments() || unknownCommand()) {
            runHelpCommand();
        } else {
            runCommandFromArguments();
        }
    }

    void setPreferences(ClientPreferences prefs) {
        this.prefs = prefs;
    }

    private void initLogging() {
        try {
            LoggingUtils.loadGlobalLoggingConfig();
        } catch (InvalidConfigurationException e) {
            System.err.println("WARNING: Could not read global Thermostat logging configuration.");
        }
        try {
            LoggingUtils.loadUserLoggingConfig();
        } catch (InvalidConfigurationException e) {
            // We intentionally ignore this.
        }
    }

    private boolean hasNoArguments() {
        return args.length == 0;
    }

    private boolean unknownCommand() {
        CommandContextFactory cmdCtxFactory = CommandContextFactory.getInstance();
        CommandRegistry registry = cmdCtxFactory.getCommandRegistry();
        Command cmd = registry.getCommand(args[0]);
        return cmd == null;
    }

    private void runHelpCommand() {
        runCommand("help", new String[0]);
    }

    private void runCommandFromArguments() {
        runCommand(args[0], Arrays.copyOfRange(args, 1, args.length));
    }

    private void runCommand(String cmdName, String[] cmdArgs) {
        try {
            parseArgsAndRunCommand(cmdName, cmdArgs);
        } catch (CommandException e) {
            CommandContextFactory cmdCtxFactory = CommandContextFactory.getInstance();
            cmdCtxFactory.getConsole().getError().println(e.getMessage());
        }
    }

    private void parseArgsAndRunCommand(String cmdName, String[] cmdArgs) throws CommandException {

        Command cmd = getCommand(cmdName);
        CommonCommandOptions commonOpts = new CommonCommandOptions();
        Collection<ArgumentSpec> acceptedOptions = commonOpts.getAcceptedOptionsFor(cmd);
        Arguments args = parseCommandArguments(cmdArgs, acceptedOptions);
        setupLogLevel(args);
        CommandContext ctx = setupCommandContext(cmd, args);
        cmd.run(ctx);
    }

    private void setupLogLevel(Arguments args) {
        if (args.hasArgument(CommonCommandOptions.LOG_LEVEL_ARG)) {
            String levelOption = args.getArgument(CommonCommandOptions.LOG_LEVEL_ARG);
            setLogLevel(levelOption);
        }
    }

    private void setLogLevel(String levelOption) {
        try {
            Level level = Level.parse(levelOption);
            LoggingUtils.setGlobalLogLevel(level);
        } catch (IllegalArgumentException ex) {
            // Ignore this, use default loglevel.
        }
    }

    private Command getCommand(String cmdName) {

        CommandContextFactory cmdCtxFactory = CommandContextFactory.getInstance();
        CommandRegistry registry = cmdCtxFactory.getCommandRegistry();
        Command cmd = registry.getCommand(cmdName);
        return cmd;
    }

    private Arguments parseCommandArguments(String[] cmdArgs, Collection<ArgumentSpec> acceptedArguments)
            throws CommandLineArgumentParseException {

        CommandLineArgumentsParser cliArgsParser = new CommandLineArgumentsParser();
        cliArgsParser.addArguments(acceptedArguments);
        Arguments args = cliArgsParser.parse(cmdArgs);
        return args;
    }

    private CommandContext setupCommandContext(Command cmd, Arguments args) throws CommandException {

        CommandContextFactory cmdCtxFactory = CommandContextFactory.getInstance();
        CommandContext ctx = cmdCtxFactory.createContext(args);
        if (cmd.isStorageRequired()) {
            String dbUrl = ctx.getArguments().getArgument(CommonCommandOptions.DB_URL_ARG);
            if (dbUrl == null) {
                dbUrl = prefs.getConnectionUrl();
            }
            try {
                ctx.getAppContextSetup().setupAppContext(dbUrl);
            } catch (ConnectionException ex) {
                throw new CommandException("Could not connect to: " + dbUrl, ex);
            }
        }
        return ctx;
    }


    private void registerDefaultCommands() {
        CommandContextFactory cmdCtxFactory = CommandContextFactory.getInstance();
        CommandRegistry registry = cmdCtxFactory.getCommandRegistry();
        ServiceLoader<Command> cmds = ServiceLoader.load(Command.class);
        registry.registerCommands(cmds);
    }
}
*/