package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1136l extends AbstractC1135k {
    public static final C1136l INSTANCE = new C1136l();

    public final void release(char[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        if (array.length == 16384) {
            releaseImpl(array);
        } else {
            throw new IllegalArgumentException(("Inconsistent internal invariant: unexpected array size " + array.length).toString());
        }
    }

    public final char[] take() {
        return take(16384);
    }
}
