package org.es4j.eventstore.serlization.acceptance;


public class When_serializing_an_untyped_payload_on_a_snapshot {

}


/*
	[Subject("Serialization")]
	public class when_serializing_an_untyped_payload_on_a_snapshot : using_serialization
	{
		static readonly IDictionary<string, List<int>> Payload = new Dictionary<string, List<int>>();
		static readonly Snapshot Snapshot = new Snapshot(Guid.NewGuid(), 42, Payload);
		static byte[] serialized;
		static Snapshot deserialized;

		Establish context = () =>
			serialized = Serializer.Serialize(Snapshot);

		Because of = () =>
			deserialized = Serializer.Deserialize<Snapshot>(serialized);

		It should_correctly_deserialize_the_untyped_payload_contents = () =>
			deserialized.Payload.ShouldEqual(Snapshot.Payload);

		It should_correctly_deserialize_the_untyped_payload_type = () =>
			deserialized.Payload.ShouldBeOfType(Snapshot.Payload.GetType());
	}
*/