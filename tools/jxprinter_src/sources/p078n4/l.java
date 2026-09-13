package p078n4;

import p060k4.m;
import p072m4.r;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface l {
    void a(short s6);

    void b(boolean z6);

    h beginCollection(r rVar, int i5);

    h beginStructure(r rVar);

    void c(int i5);

    void d(long j6);

    void e(char c);

    void encodeEnum(r rVar, int i5);

    l encodeInline(r rVar);

    void encodeNotNullMark();

    void encodeNull();

    <T> void encodeNullableSerializableValue(m mVar, T t6);

    <T> void encodeSerializableValue(m mVar, T t6);

    void encodeString(String str);

    void f(byte b);

    void g(float f6);

    g getSerializersModule();

    void h(double d);
}
