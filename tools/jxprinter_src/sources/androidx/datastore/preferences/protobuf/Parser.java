package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream);

    MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(ByteString byteString);

    MessageType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(CodedInputStream codedInputStream);

    MessageType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(InputStream inputStream);

    MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(ByteBuffer byteBuffer);

    MessageType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(byte[] bArr);

    MessageType parseFrom(byte[] bArr, int i5, int i6);

    MessageType parseFrom(byte[] bArr, int i5, int i6, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialDelimitedFrom(InputStream inputStream);

    MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialFrom(ByteString byteString);

    MessageType parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialFrom(CodedInputStream codedInputStream);

    MessageType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialFrom(InputStream inputStream);

    MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialFrom(byte[] bArr);

    MessageType parsePartialFrom(byte[] bArr, int i5, int i6);

    MessageType parsePartialFrom(byte[] bArr, int i5, int i6, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);
}
