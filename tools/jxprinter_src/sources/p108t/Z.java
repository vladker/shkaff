package p108t;

import H3.a;
import H3.b;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 t.Z[], still in use, count: 1, list:
  (r0v1 t.Z[]) from 0x002e: INVOKE (r0v1 t.Z[]) STATIC call: H3.b.enumEntries(java.lang.Enum[]):H3.a A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):H3.a (m), WRAPPED] (LINE:47)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class Z {
    UNCONNECTED(0),
    BLUETOOTH(1),
    USB(2),
    WIFI(3);

    public static final Y Companion = new Y();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ a f8525g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8526a;

    static {
        f8525g = b.enumEntries(new Z[]{r0, r1, r2, r3});
    }

    public Z(int i5) {
        super(str, i);
        this.f8526a = i5;
    }

    public static a getEntries() {
        return f8525g;
    }

    public static Z valueOf(String str) {
        return (Z) Enum.valueOf(Z.class, str);
    }

    public static Z[] values() {
        return (Z[]) f8524f.clone();
    }
}
