package p078n4;

import p060k4.a;
import p072m4.r;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface f {
    public static final d Companion = d.f6317a;

    boolean decodeBooleanElement(r rVar, int i5);

    byte decodeByteElement(r rVar, int i5);

    char decodeCharElement(r rVar, int i5);

    int decodeCollectionSize(r rVar);

    double decodeDoubleElement(r rVar, int i5);

    int decodeElementIndex(r rVar);

    float decodeFloatElement(r rVar, int i5);

    j decodeInlineElement(r rVar, int i5);

    int decodeIntElement(r rVar, int i5);

    long decodeLongElement(r rVar, int i5);

    <T> T decodeNullableSerializableElement(r rVar, int i5, a aVar, T t6);

    boolean decodeSequentially();

    <T> T decodeSerializableElement(r rVar, int i5, a aVar, T t6);

    short decodeShortElement(r rVar, int i5);

    String decodeStringElement(r rVar, int i5);

    void endStructure(r rVar);

    g getSerializersModule();
}
