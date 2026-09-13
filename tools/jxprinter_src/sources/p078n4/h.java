package p078n4;

import p060k4.m;
import p072m4.r;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface h {
    void encodeBooleanElement(r rVar, int i5, boolean z6);

    void encodeByteElement(r rVar, int i5, byte b);

    void encodeCharElement(r rVar, int i5, char c);

    void encodeDoubleElement(r rVar, int i5, double d);

    void encodeFloatElement(r rVar, int i5, float f6);

    l encodeInlineElement(r rVar, int i5);

    void encodeIntElement(r rVar, int i5, int i6);

    void encodeLongElement(r rVar, int i5, long j6);

    <T> void encodeNullableSerializableElement(r rVar, int i5, m mVar, T t6);

    <T> void encodeSerializableElement(r rVar, int i5, m mVar, T t6);

    void encodeShortElement(r rVar, int i5, short s6);

    void encodeStringElement(r rVar, int i5, String str);

    void endStructure(r rVar);

    g getSerializersModule();

    boolean shouldEncodeElementDefault(r rVar, int i5);
}
