package p089p4;

import p060k4.m;
import p078n4.h;
import p078n4.l;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface r extends l, h {
    @Override // p078n4.l
    /* synthetic */ h beginCollection(p072m4.r rVar, int i5);

    /* synthetic */ h beginStructure(p072m4.r rVar);

    @Override // p078n4.h
    /* synthetic */ void encodeBooleanElement(p072m4.r rVar, int i5, boolean z6);

    @Override // p078n4.h
    /* synthetic */ void encodeByteElement(p072m4.r rVar, int i5, byte b);

    @Override // p078n4.h
    /* synthetic */ void encodeCharElement(p072m4.r rVar, int i5, char c);

    @Override // p078n4.h
    /* synthetic */ void encodeDoubleElement(p072m4.r rVar, int i5, double d);

    /* synthetic */ void encodeEnum(p072m4.r rVar, int i5);

    @Override // p078n4.h
    /* synthetic */ void encodeFloatElement(p072m4.r rVar, int i5, float f6);

    /* synthetic */ l encodeInline(p072m4.r rVar);

    @Override // p078n4.h
    /* synthetic */ l encodeInlineElement(p072m4.r rVar, int i5);

    @Override // p078n4.h
    /* synthetic */ void encodeIntElement(p072m4.r rVar, int i5, int i6);

    void encodeJsonElement(m mVar);

    @Override // p078n4.h
    /* synthetic */ void encodeLongElement(p072m4.r rVar, int i5, long j6);

    /* synthetic */ void encodeNotNullMark();

    /* synthetic */ void encodeNull();

    /* synthetic */ void encodeNullableSerializableElement(p072m4.r rVar, int i5, m mVar, Object obj);

    @Override // p078n4.l
    /* synthetic */ void encodeNullableSerializableValue(m mVar, Object obj);

    @Override // p078n4.h
    /* synthetic */ void encodeSerializableElement(p072m4.r rVar, int i5, m mVar, Object obj);

    /* synthetic */ void encodeSerializableValue(m mVar, Object obj);

    @Override // p078n4.h
    /* synthetic */ void encodeShortElement(p072m4.r rVar, int i5, short s6);

    @Override // p078n4.l
    /* synthetic */ void encodeString(String str);

    @Override // p078n4.h
    /* synthetic */ void encodeStringElement(p072m4.r rVar, int i5, String str);

    /* synthetic */ void endStructure(p072m4.r rVar);

    AbstractC1519d getJson();

    @Override // p078n4.l, p078n4.h
    /* synthetic */ g getSerializersModule();

    /* synthetic */ boolean shouldEncodeElementDefault(p072m4.r rVar, int i5);
}
