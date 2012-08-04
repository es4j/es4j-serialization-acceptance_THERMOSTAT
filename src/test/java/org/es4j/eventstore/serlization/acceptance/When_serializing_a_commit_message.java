package org.es4j.eventstore.serlization.acceptance;


public class When_serializing_a_commit_message {

}


/*
	[Subject("Serialization")]
	public class when_serializing_a_commit_message : using_serialization
	{
		static readonly Commit Message = Guid.NewGuid().BuildCommit();
		static byte[] serialized;
		static Commit deserialized;

		Establish context = () =>
			serialized = Serializer.Serialize(Message);

		Because of = () =>
			deserialized = Serializer.Deserialize<Commit>(serialized);

		It should_deserialize_a_commit_which_contains_the_same_StreamId_as_the_serialized_commit = () =>
			deserialized.StreamId.ShouldEqual(Message.StreamId);

		It should_deserialize_a_commit_which_contains_the_same_CommitId_as_the_serialized_commit = () =>
			deserialized.CommitId.ShouldEqual(Message.CommitId);

		It should_deserialize_a_commit_which_contains_the_same_StreamRevision_as_the_serialized_commit = () =>
			deserialized.StreamRevision.ShouldEqual(Message.StreamRevision);

		It should_deserialize_a_commit_which_contains_the_same_CommitSequence_as_the_serialized_commit = () =>
			deserialized.CommitSequence.ShouldEqual(Message.CommitSequence);

		It should_deserialize_a_commit_which_contains_the_same_number_of_headers_as_the_serialized_commit = () =>
			deserialized.Headers.Count.ShouldEqual(Message.Headers.Count);

		It should_deserialize_a_commit_which_contains_the_same_headers_as_the_serialized_commit = () =>
		{
			foreach (var header in deserialized.Headers)
				header.Value.ShouldEqual(Message.Headers[header.Key]);

			deserialized.Headers.Values.SequenceEqual(Message.Headers.Values);
		};

		It should_deserialize_a_commit_which_contains_the_same_number_of_events_as_the_serialized_commit = () =>
			deserialized.Events.Count.ShouldEqual(Message.Events.Count);
	}
*/