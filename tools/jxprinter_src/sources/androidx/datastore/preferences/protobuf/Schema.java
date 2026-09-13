package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T t6, T t7);

    int getSerializedSize(T t6);

    int hashCode(T t6);

    boolean isInitialized(T t6);

    void makeImmutable(T t6);

    void mergeFrom(T t6, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t6, T t7);

    void mergeFrom(T t6, byte[] bArr, int i5, int i6, ArrayDecoders.Registers registers);

    T newInstance();

    void writeTo(T t6, Writer writer);
}
