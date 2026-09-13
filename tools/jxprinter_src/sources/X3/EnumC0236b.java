package X3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v30 X3.b[], still in use, count: 1, list:
  (r0v30 X3.b[]) from 0x018e: INVOKE (r0v30 X3.b[]) STATIC call: H3.b.enumEntries(java.lang.Enum[]):H3.a A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):H3.a (m), WRAPPED] (LINE:399)
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
/* JADX INFO: renamed from: X3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0236b {
    /* JADX INFO: Fake field, exist only in values array */
    UNASSIGNED("Cn"),
    /* JADX INFO: Fake field, exist only in values array */
    UPPERCASE_LETTER("Lu"),
    /* JADX INFO: Fake field, exist only in values array */
    LOWERCASE_LETTER("Ll"),
    /* JADX INFO: Fake field, exist only in values array */
    TITLECASE_LETTER("Lt"),
    /* JADX INFO: Fake field, exist only in values array */
    MODIFIER_LETTER("Lm"),
    /* JADX INFO: Fake field, exist only in values array */
    OTHER_LETTER("Lo"),
    /* JADX INFO: Fake field, exist only in values array */
    NON_SPACING_MARK("Mn"),
    /* JADX INFO: Fake field, exist only in values array */
    ENCLOSING_MARK("Me"),
    /* JADX INFO: Fake field, exist only in values array */
    COMBINING_SPACING_MARK("Mc"),
    /* JADX INFO: Fake field, exist only in values array */
    DECIMAL_DIGIT_NUMBER("Nd"),
    /* JADX INFO: Fake field, exist only in values array */
    LETTER_NUMBER("Nl"),
    /* JADX INFO: Fake field, exist only in values array */
    OTHER_NUMBER("No"),
    /* JADX INFO: Fake field, exist only in values array */
    SPACE_SEPARATOR("Zs"),
    /* JADX INFO: Fake field, exist only in values array */
    LINE_SEPARATOR("Zl"),
    /* JADX INFO: Fake field, exist only in values array */
    PARAGRAPH_SEPARATOR("Zp"),
    /* JADX INFO: Fake field, exist only in values array */
    CONTROL("Cc"),
    /* JADX INFO: Fake field, exist only in values array */
    FORMAT("Cf"),
    /* JADX INFO: Fake field, exist only in values array */
    PRIVATE_USE("Co"),
    /* JADX INFO: Fake field, exist only in values array */
    SURROGATE("Cs"),
    /* JADX INFO: Fake field, exist only in values array */
    DASH_PUNCTUATION("Pd"),
    /* JADX INFO: Fake field, exist only in values array */
    START_PUNCTUATION("Ps"),
    /* JADX INFO: Fake field, exist only in values array */
    END_PUNCTUATION("Pe"),
    /* JADX INFO: Fake field, exist only in values array */
    CONNECTOR_PUNCTUATION("Pc"),
    /* JADX INFO: Fake field, exist only in values array */
    OTHER_PUNCTUATION("Po"),
    /* JADX INFO: Fake field, exist only in values array */
    MATH_SYMBOL("Sm"),
    /* JADX INFO: Fake field, exist only in values array */
    CURRENCY_SYMBOL("Sc"),
    /* JADX INFO: Fake field, exist only in values array */
    MODIFIER_SYMBOL("Sk"),
    /* JADX INFO: Fake field, exist only in values array */
    OTHER_SYMBOL("So"),
    /* JADX INFO: Fake field, exist only in values array */
    INITIAL_QUOTE_PUNCTUATION("Pi"),
    /* JADX INFO: Fake field, exist only in values array */
    FINAL_QUOTE_PUNCTUATION("Pf");

    public static final C0235a Companion = new C0235a();
    public static final /* synthetic */ H3.a b = H3.b.enumEntries(new EnumC0236b[]{new EnumC0236b("Cn"), new EnumC0236b("Lu"), new EnumC0236b("Ll"), new EnumC0236b("Lt"), new EnumC0236b("Lm"), new EnumC0236b("Lo"), new EnumC0236b("Mn"), new EnumC0236b("Me"), new EnumC0236b("Mc"), new EnumC0236b("Nd"), new EnumC0236b("Nl"), new EnumC0236b("No"), new EnumC0236b("Zs"), new EnumC0236b("Zl"), new EnumC0236b("Zp"), new EnumC0236b("Cc"), new EnumC0236b("Cf"), new EnumC0236b("Co"), new EnumC0236b("Cs"), new EnumC0236b("Pd"), new EnumC0236b("Ps"), new EnumC0236b("Pe"), new EnumC0236b("Pc"), new EnumC0236b("Po"), new EnumC0236b("Sm"), new EnumC0236b("Sc"), new EnumC0236b("Sk"), new EnumC0236b("So"), new EnumC0236b("Pi"), new EnumC0236b("Pf")});
    private final String code;

    static {
    }

    public EnumC0236b(String str) {
        super(str, i);
        this.code = str;
    }

    public static H3.a getEntries() {
        return b;
    }

    public static EnumC0236b valueOf(String str) {
        return (EnumC0236b) Enum.valueOf(EnumC0236b.class, str);
    }

    public static EnumC0236b[] values() {
        return (EnumC0236b[]) f855a.clone();
    }

    public final String getCode() {
        return this.code;
    }
}
