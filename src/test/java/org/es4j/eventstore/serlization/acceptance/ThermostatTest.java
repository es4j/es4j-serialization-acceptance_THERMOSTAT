package org.es4j.eventstore.serlization.acceptance;

import junit.framework.Assert;
import org.es4j.eventstore.serlization.acceptance.cli.Launcher;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;


public class ThermostatTest {

    @Test
    public void testThermostatMain() {
        Launcher launcher = BDDMockito.mock(Launcher.class);
        Es4jCli.setLauncher(launcher);
        Es4jCli.main(new String[] { "test1", "test2" });
        
        try {
            PowerMockito.verifyNew(Launcher.class).withNoArguments();
        } catch (Exception ex) {
            Assert.fail();
        }
        
        BDDMockito.verify(launcher).run(new String[] { "test1", "test2" });
     }
}