package X3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 X3.K[], still in use, count: 1, list:
  (r0v1 X3.K[]) from 0x0048: INVOKE (r0v1 X3.K[]) STATIC call: H3.b.enumEntries(java.lang.Enum[]):H3.a A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):H3.a (m), WRAPPED] (LINE:73)
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
/* JADX INFO: loaded from: classes3.dex */
public final class K implements InterfaceC0244j {
    /* JADX INFO: Fake field, exist only in values array */
    IGNORE_CASE(2),
    /* JADX INFO: Fake field, exist only in values array */
    MULTILINE(8),
    LITERAL(16),
    /* JADX INFO: Fake field, exist only in values array */
    UNIX_LINES(1),
    /* JADX INFO: Fake field, exist only in values array */
    COMMENTS(4),
    /* JADX INFO: Fake field, exist only in values array */
    DOT_MATCHES_ALL(32),
    /* JADX INFO: Fake field, exist only in values array */
    CANON_EQ(128);

    public static final /* synthetic */ H3.a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f849a;
    public final int b;

    static {
        e = H3.b.enumEntries(kArr);
    }

    public K(int i5) {
        super(str, i);
        this.f849a = i5;
        this.b = i5;
    }

    public static H3.a getEntries() {
        return e;
    }

    public static K valueOf(String str) {
        return (K) Enum.valueOf(K.class, str);
    }

    public static K[] values() {
        return (K[]) d.clone();
    }
}
