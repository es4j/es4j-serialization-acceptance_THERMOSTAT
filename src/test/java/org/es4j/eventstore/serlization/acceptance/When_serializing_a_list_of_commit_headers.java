package org.es4j.eventstore.serlization.acceptance;

/**
 *
 * @author Esfand
 */
public class When_serializing_a_list_of_commit_headers {

}


/*
	[Subject("Serialization")]
	public class when_serializing_a_list_of_commit_headers : using_serialization
	{
		private static readonly Dictionary<string, object> Headers = new Dictionary<string, object>
		{
			{ "HeaderKey", "SomeValue" },
			{ "AnotherKey", 42 },
			{ "AndAnotherKey", Guid.NewGuid() },
			{ "LastKey", new SimpleMessage() }
		};
		static byte[] serialized;
		static Dictionary<string, object> deserialized;

		Establish context = () =>
			serialized = Serializer.Serialize(Headers);

		Because of = () =>
			deserialized = Serializer.Deserialize<Dictionary<string, object>>(serialized);

		It should_deserialize_the_same_number_of_event_messages_as_it_serialized = () =>
			Headers.Count.ShouldEqual(deserialized.Count);

		It should_deserialize_the_the_complex_types_within_the_event_messages = () =>
			deserialized.Last().Value.ShouldBeOfType<SimpleMessage>();
	}
*/