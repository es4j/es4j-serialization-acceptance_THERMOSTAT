package org.es4j.eventstore.serlization.acceptance;

//import org.es4j.dotnet.NotSupportedException;
import org.es4j.serialization.*;
import org.es4j.serialization.api.ISerialize;


public class SerializationFactory {

    private static final byte[] encryptionKey = new byte[] {
        0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x0
    };

    // virtual
    public ISerialize build() {

        String setting = ConfigurationExtensions.getSetting("serializer");
        switch (setting) {
        case "Binary":           return new BinarySerializer();
        case "Gzip":             return new GzipSerializer(new BinarySerializer());
        case "Rijndael":         return new RijndaelSerializer(new BinarySerializer(), encryptionKey);
        case "Json":             return new JsonSerializer();
        case "Bson":             return new BsonSerializer();
        case "ServiceStackJson": return new JsonSerializer();
        default:                 throw  new UnsupportedOperationException("The configured serializer is not registered with the SerializationFactory.");
        }
    }
}