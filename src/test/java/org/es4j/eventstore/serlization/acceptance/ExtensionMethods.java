package org.es4j.eventstore.serlization.acceptance;

import java.net.URI;
import java.util.*;
import org.es4j.eventstore.api.Commit;
import org.es4j.messaging.api.EventMessage;
import org.es4j.util.DateTime;
import org.es4j.util.SystemTime;


//internal static
public class ExtensionMethods {

    public static SimpleMessage populate(/*this*/ SimpleMessage message) {

        message = (message!=null)? message : new SimpleMessage();

        return new SimpleMessage (UUID.randomUUID(),
                                  1234,
                                  new DateTime(new GregorianCalendar(2000, 2, 3, 4, 5, 6 /*,7*/).getTimeInMillis()),
				  message.getValue() + "Hello, World!",
				  Arrays.asList( "a", null, "", "d" ));
    }

    public static Commit buildCommit(/*this*/ UUID streamId)  {

        int                 streamRevision = 2;
        UUID                commitId       = UUID.randomUUID();
        int                 commitSequence = 2;
        Map<String, Object> headers        = new HashMap<String, Object>() {{put("MsgKey1",  "Value");
                                                                             put("Key2", (long)1234);
                                                                             put("Key3", null);}};
        List<EventMessage>  events         = Arrays.asList(
                new EventMessage("some value",
                                 new HashMap<String, Object>(){{
                                     put("MsgKey1", Long.MIN_VALUE); //TimeSpan.MinValue
                                     put("MsgKey2", UUID.randomUUID());
                                     put("MsgKey3", 1.1); //1.1M
                                     put("MsgKey4", 1);}}), //(ushort)1,
                new EventMessage(new String[] { "message body" },
                                 new HashMap<String, Object>(){{
                                     put("MsgKey1", URI.create("http://www.google.com/"));
                                     put("MsgKey2", "some header");}})  );

        return new Commit(streamId, streamRevision, commitId, commitSequence, SystemTime.utcNow(), headers, events);
    }
}



/*
namespace EventStore.Serialization.AcceptanceTests
{
	using System;
	using System.Collections.Generic;
	using System.Linq;

	internal static class ExtensionMethods
	{
		public static SimpleMessage Populate(this SimpleMessage message)
		{
			message = message ?? new SimpleMessage();

			return new SimpleMessage
			{
				Id = Guid.NewGuid(),
				Count = 1234,
				Created = new DateTime(2000, 2, 3, 4, 5, 6, 7).ToUniversalTime(),
				Value = message.Value + "Hello, World!",
				Contents = { "a", null, string.Empty, "d" }
			};
		}

		public static Commit BuildCommit(this Guid streamId)
		{
			const int StreamRevision = 2;
			const int CommitSequence = 2;
			var commitId = Guid.NewGuid();
			var headers = new Dictionary<string, object> { { "Key", "Value" }, { "Key2", (long)1234 }, { "Key3", null } };
			var events = new[]
			{
				new EventMessage
				{
					Headers =
					{
						{ "MsgKey1", TimeSpan.MinValue },
						{ "MsgKey2", Guid.NewGuid() },
						{ "MsgKey3", 1.1M },
						{ "MsgKey4", (ushort)1 }
					},
					Body = "some value"
				},
				new EventMessage
				{
					Headers =
					{
						{ "MsgKey1", new Uri("http://www.google.com/") },
						{ "MsgKey4", "some header" }
					},
					Body = new[] { "message body" }
				}
			};

			return new Commit(streamId, StreamRevision, commitId, CommitSequence, SystemTime.UtcNow, headers, events.ToList());
		}
	}
}
 */