package X3;

import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v19 X3.d[], still in use, count: 1, list:
  (r0v19 X3.d[]) from 0x00d1: INVOKE (r0v19 X3.d[]) STATIC call: H3.b.enumEntries(java.lang.Enum[]):H3.a A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):H3.a (m), WRAPPED] (LINE:210)
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
/* JADX INFO: renamed from: X3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0238d {
    /* JADX INFO: Fake field, exist only in values array */
    UNDEFINED(-1),
    /* JADX INFO: Fake field, exist only in values array */
    LEFT_TO_RIGHT(0),
    /* JADX INFO: Fake field, exist only in values array */
    RIGHT_TO_LEFT(1),
    /* JADX INFO: Fake field, exist only in values array */
    RIGHT_TO_LEFT_ARABIC(2),
    /* JADX INFO: Fake field, exist only in values array */
    EUROPEAN_NUMBER(3),
    /* JADX INFO: Fake field, exist only in values array */
    EUROPEAN_NUMBER_SEPARATOR(4),
    /* JADX INFO: Fake field, exist only in values array */
    EUROPEAN_NUMBER_TERMINATOR(5),
    /* JADX INFO: Fake field, exist only in values array */
    ARABIC_NUMBER(6),
    /* JADX INFO: Fake field, exist only in values array */
    COMMON_NUMBER_SEPARATOR(7),
    /* JADX INFO: Fake field, exist only in values array */
    NONSPACING_MARK(8),
    /* JADX INFO: Fake field, exist only in values array */
    BOUNDARY_NEUTRAL(9),
    /* JADX INFO: Fake field, exist only in values array */
    PARAGRAPH_SEPARATOR(10),
    /* JADX INFO: Fake field, exist only in values array */
    SEGMENT_SEPARATOR(11),
    /* JADX INFO: Fake field, exist only in values array */
    WHITESPACE(12),
    /* JADX INFO: Fake field, exist only in values array */
    OTHER_NEUTRALS(13),
    /* JADX INFO: Fake field, exist only in values array */
    LEFT_TO_RIGHT_EMBEDDING(14),
    /* JADX INFO: Fake field, exist only in values array */
    LEFT_TO_RIGHT_OVERRIDE(15),
    /* JADX INFO: Fake field, exist only in values array */
    RIGHT_TO_LEFT_EMBEDDING(16),
    /* JADX INFO: Fake field, exist only in values array */
    RIGHT_TO_LEFT_OVERRIDE(17),
    /* JADX INFO: Fake field, exist only in values array */
    POP_DIRECTIONAL_FORMAT(18);

    public static final /* synthetic */ H3.a c = H3.b.enumEntries(new EnumC0238d[]{new EnumC0238d(-1), new EnumC0238d(0), new EnumC0238d(1), new EnumC0238d(2), new EnumC0238d(3), new EnumC0238d(4), new EnumC0238d(5), new EnumC0238d(6), new EnumC0238d(7), new EnumC0238d(8), new EnumC0238d(9), new EnumC0238d(10), new EnumC0238d(11), new EnumC0238d(12), new EnumC0238d(13), new EnumC0238d(14), new EnumC0238d(15), new EnumC0238d(16), new EnumC0238d(17), new EnumC0238d(18)});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f856a;
    public static final C0237c Companion = new C0237c();
    private static final InterfaceC1934n directionalityMap$delegate = AbstractC1935o.lazy(new S2.d(1));

    static {
    }

    public EnumC0238d(int i5) {
        super(str, i);
        this.f856a = i5;
    }

    public static H3.a getEntries() {
        return c;
    }

    public static EnumC0238d valueOf(String str) {
        return (EnumC0238d) Enum.valueOf(EnumC0238d.class, str);
    }

    public static EnumC0238d[] values() {
        return (EnumC0238d[]) b.clone();
    }
}
