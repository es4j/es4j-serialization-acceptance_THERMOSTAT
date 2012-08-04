package org.es4j.eventstore.serlization.acceptance;


public class When_serializing_a_list_of_event_messages {

}


/*
	[Subject("Serialization")]
	public class when_serializing_a_list_of_event_messages : using_serialization
	{
		private static readonly List<EventMessage> Messages = new List<EventMessage>
		{
			new EventMessage { Body = "some value" },
			new EventMessage { Body = 42 },
			new EventMessage { Body = new SimpleMessage() }
		};
		static byte[] serialized;
		static List<EventMessage> deserialized;

		Establish context = () =>
			serialized = Serializer.Serialize(Messages);

		Because of = () =>
			deserialized = Serializer.Deserialize<List<EventMessage>>(serialized);

		It should_deserialize_the_same_number_of_event_messages_as_it_serialized = () =>
			Messages.Count.ShouldEqual(deserialized.Count);

		It should_deserialize_the_the_complex_types_within_the_event_messages = () =>
			deserialized.Last().Body.ShouldBeOfType<SimpleMessage>();
	}
*/