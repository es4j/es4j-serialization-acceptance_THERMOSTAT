package org.es4j.eventstore.serlization.acceptance;


public class When_serializing_a_simple_message {

}


/*
	[Subject("Serialization")]
	public class when_serializing_a_simple_message : using_serialization
	{
		static readonly SimpleMessage Message = new SimpleMessage().Populate();
		static byte[] serialized;
		static SimpleMessage deserialized;

		Establish context = () =>
			serialized = Serializer.Serialize(Message);

		Because of = () =>
			deserialized = Serializer.Deserialize<SimpleMessage>(serialized);

		It should_deserialize_a_message_which_contains_the_same_Id_as_the_serialized_message = () =>
			deserialized.Id.ShouldEqual(Message.Id);

		It should_deserialize_a_message_which_contains_the_same_Value_as_the_serialized_message = () =>
			deserialized.Value.ShouldEqual(Message.Value);

		It should_deserialize_a_message_which_contains_the_same_Created_value_as_the_serialized_message = () =>
			deserialized.Created.ShouldEqual(Message.Created);

		It should_deserialize_a_message_which_contains_the_same_Count_as_the_serialized_message = () =>
			deserialized.Count.ShouldEqual(Message.Count);

		It should_deserialize_a_message_which_contains_the_number_of_elements_as_the_serialized_message = () =>
			deserialized.Contents.Count.ShouldEqual(Message.Contents.Count);

		It should_deserialize_a_message_which_contains_the_same_Contents_as_the_serialized_message = () =>
			deserialized.Contents.SequenceEqual(Message.Contents).ShouldBeTrue();
	}
*/