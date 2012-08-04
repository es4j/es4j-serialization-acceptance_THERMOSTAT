package org.es4j.eventstore.serlization.acceptance.cli;

import java.util.Collection;

/**
 *
 * @author Esfand
 */
public class CommonCommandOptions {
    
    public static final int LOG_LEVEL_ARG = 1;
    public static final int DB_URL_ARG = 1;

    public CommonCommandOptions() {
    }

    Collection<ArgumentSpec> getAcceptedOptionsFor(Command cmd) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
