package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1129e extends p078n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC1131g f5736a;
    public final /* synthetic */ String b;
    public final /* synthetic */ p072m4.r c;

    public C1129e(AbstractC1131g abstractC1131g, String str, p072m4.r rVar) {
        this.f5736a = abstractC1131g;
        this.b = str;
        this.c = rVar;
    }

    @Override // p078n4.b, p078n4.l
    public final void encodeString(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        this.f5736a.putElement(this.b, new p089p4.s(value, false, this.c));
    }

    @Override // p078n4.b, p078n4.l, p078n4.h
    public final p095q4.g getSerializersModule() {
        return this.f5736a.getJson().getSerializersModule();
    }
}
