package kotlinx.serialization.json.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5725a;
    private final p084o4.H origin;

    public B(p072m4.r descriptor) {
        kotlin.jvm.internal.E.f(descriptor, "descriptor");
        this.origin = new p084o4.H(descriptor, new A(2, this, B.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0));
    }

    public final void a(int i5) {
        this.origin.a(i5);
    }

    public final int b() {
        return this.origin.b();
    }
}
