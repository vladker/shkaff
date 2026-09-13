package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1134j extends AbstractC1135k {
    public static final C1134j INSTANCE = new C1134j();

    public final void release(char[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        releaseImpl(array);
    }

    public final char[] take() {
        return take(128);
    }
}
