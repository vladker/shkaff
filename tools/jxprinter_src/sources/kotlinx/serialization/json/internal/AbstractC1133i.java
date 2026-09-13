package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1133i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5740a;

    static {
        Object objM1361constructorimpl;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            kotlin.jvm.internal.E.e(property, "getProperty(...)");
            objM1361constructorimpl = p147z3.u.m1361constructorimpl(X3.V.toIntOrNull(property));
        } catch (Throwable th) {
            objM1361constructorimpl = p147z3.u.m1361constructorimpl(p147z3.v.createFailure(th));
        }
        if (objM1361constructorimpl instanceof z3.u.a) {
            objM1361constructorimpl = null;
        }
        Integer num = (Integer) objM1361constructorimpl;
        f5740a = num != null ? num.intValue() : 2097152;
    }
}
