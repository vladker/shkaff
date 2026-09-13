package kotlinx.serialization.json.internal;

import A3.C0144l;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1135k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5741a;
    private final C0144l arrays = new C0144l();

    public final void releaseImpl(char[] array) {
        kotlin.jvm.internal.E.f(array, "array");
        synchronized (this) {
            int i5 = this.f5741a;
            if (array.length + i5 < AbstractC1133i.f5740a) {
                this.f5741a = i5 + array.length;
                this.arrays.addLast(array);
            }
        }
    }

    public final char[] take(int i5) {
        char[] cArr;
        synchronized (this) {
            cArr = (char[]) this.arrays.removeLastOrNull();
            if (cArr != null) {
                this.f5741a -= cArr.length;
            } else {
                cArr = null;
            }
        }
        return cArr == null ? new char[i5] : cArr;
    }
}
