package p089p4;

import p060k4.a;
import p072m4.r;
import p078n4.f;
import p078n4.j;
import p095q4.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface k extends j, f {
    /* synthetic */ f beginStructure(r rVar);

    @Override // p078n4.f
    /* synthetic */ boolean decodeBooleanElement(r rVar, int i5);

    @Override // p078n4.f
    /* synthetic */ byte decodeByteElement(r rVar, int i5);

    @Override // p078n4.f
    /* synthetic */ char decodeCharElement(r rVar, int i5);

    @Override // p078n4.f
    /* synthetic */ int decodeCollectionSize(r rVar);

    @Override // p078n4.f
    /* synthetic */ double decodeDoubleElement(r rVar, int i5);

    /* synthetic */ int decodeElementIndex(r rVar);

    /* synthetic */ int decodeEnum(r rVar);

    @Override // p078n4.f
    /* synthetic */ float decodeFloatElement(r rVar, int i5);

    /* synthetic */ j decodeInline(r rVar);

    @Override // p078n4.f
    /* synthetic */ j decodeInlineElement(r rVar, int i5);

    @Override // p078n4.f
    /* synthetic */ int decodeIntElement(r rVar, int i5);

    m decodeJsonElement();

    @Override // p078n4.f
    /* synthetic */ long decodeLongElement(r rVar, int i5);

    /* synthetic */ boolean decodeNotNullMark();

    /* synthetic */ Void decodeNull();

    @Override // p078n4.f
    /* synthetic */ Object decodeNullableSerializableElement(r rVar, int i5, a aVar, Object obj);

    @Override // p078n4.j
    /* synthetic */ Object decodeNullableSerializableValue(a aVar);

    @Override // p078n4.f
    /* synthetic */ boolean decodeSequentially();

    /* synthetic */ Object decodeSerializableElement(r rVar, int i5, a aVar, Object obj);

    /* synthetic */ Object decodeSerializableValue(a aVar);

    @Override // p078n4.f
    /* synthetic */ short decodeShortElement(r rVar, int i5);

    /* synthetic */ String decodeString();

    @Override // p078n4.f
    /* synthetic */ String decodeStringElement(r rVar, int i5);

    /* synthetic */ void endStructure(r rVar);

    AbstractC1519d getJson();

    /* synthetic */ g getSerializersModule();
}
