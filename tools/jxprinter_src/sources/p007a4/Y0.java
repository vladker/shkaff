package p007a4;

import p028e4.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Y0 {
    private static final H COMPLETING_ALREADY = new H("COMPLETING_ALREADY");
    public static final H COMPLETING_WAITING_CHILDREN = new H("COMPLETING_WAITING_CHILDREN");
    private static final H COMPLETING_RETRY = new H("COMPLETING_RETRY");
    private static final H TOO_LATE_TO_CANCEL = new H("TOO_LATE_TO_CANCEL");
    private static final H SEALED = new H("SEALED");
    private static final C0286k0 EMPTY_NEW = new C0286k0(false);
    private static final C0286k0 EMPTY_ACTIVE = new C0286k0(true);

    public static final Object boxIncomplete(Object obj) {
        return obj instanceof B0 ? new C0((B0) obj) : obj;
    }

    public static final Object unboxState(Object obj) {
        B0 b1;
        C0 c6 = obj instanceof C0 ? (C0) obj : null;
        return (c6 == null || (b1 = c6.state) == null) ? obj : b1;
    }
}
