package kotlinx.coroutines.flow.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A {
    public static final int checkIndexOverflow(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void checkOwnership(C1112a c1112a, Object obj) {
        if (c1112a.owner != obj) {
            throw c1112a;
        }
    }
}
