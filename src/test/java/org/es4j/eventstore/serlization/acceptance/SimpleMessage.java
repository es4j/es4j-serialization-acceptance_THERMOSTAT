package org.es4j.eventstore.serlization.acceptance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.es4j.util.DateTime;
//import org.es4j.dotnet.DateTime;
//import org.es4j.dotnet.Guid;
//using System.Diagnostics.CodeAnalysis;

public class SimpleMessage implements Serializable {

    private UUID id;       // { get; set; }
    private DateTime created;  // { get; set; }
    private String value;    // { get; set; }
    private int count;    // { get; set; }
    private List<String> contents; // { get; private set; }

    public SimpleMessage() {
        this.contents = new ArrayList<String>();
    }

    /*
        return new SimpleMessage (Guid.newGuid(),
                                  1234,
				  new GregorianCalendar(2000, 2, 3, 4, 5, 6, 7), //.toUniversalTime(),
				  message.getValue() + "Hello, World!",
				  Arrays.asList( "a", null, "", "d" ));
                                  */
    public SimpleMessage(UUID id, int count, DateTime created, String value, List<String> contents) {
        this.id = id;
        this.count = count;
        this.created = created;
        this.value = value;
        this.contents = contents;
    }

    public List<String> getContents() {
        return contents;
    }

    public int getCount() {
        return count;
    }

    public DateTime getCreated() {
        return created;
    }

    public UUID getId() {
        return id;
    }

    public String getValue() {
        return value;
    }


}