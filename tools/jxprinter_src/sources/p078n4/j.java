package p078n4;

import p060k4.a;
import p072m4.r;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface j {
    double a();

    byte b();

    f beginStructure(r rVar);

    long c();

    short d();

    int decodeEnum(r rVar);

    j decodeInline(r rVar);

    boolean decodeNotNullMark();

    Void decodeNull();

    <T> T decodeNullableSerializableValue(a aVar);

    <T> T decodeSerializableValue(a aVar);

    String decodeString();

    char e();

    int f();

    float g();

    g getSerializersModule();

    boolean h();
}
