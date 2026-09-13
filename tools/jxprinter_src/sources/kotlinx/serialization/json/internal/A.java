package kotlinx.serialization.json.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class A extends kotlin.jvm.internal.B implements O3.p {
    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        p072m4.r p1 = (p072m4.r) obj;
        int iIntValue = ((Number) obj2).intValue();
        kotlin.jvm.internal.E.f(p1, "p0");
        B b = (B) this.receiver;
        b.getClass();
        boolean z6 = !p1.isElementOptional(iIntValue) && p1.getElementDescriptor(iIntValue).a();
        b.f5725a = z6;
        return Boolean.valueOf(z6);
    }
}
