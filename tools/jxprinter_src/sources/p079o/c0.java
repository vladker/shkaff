package p079o;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v1 o.c0, still in use, count: 1, list:
  (r3v1 o.c0) from 0x018c: IGET (r3v1 o.c0) A[WRAPPED] (LINE:397) o.c0.a int
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
public final class c0 {
    QuoteFieldNames,
    UseSingleQuotes,
    /* JADX INFO: Fake field, exist only in values array */
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    /* JADX INFO: Fake field, exist only in values array */
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;


    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final c0[] f6382D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final int f6383G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6406a;

    static {
        c0 c0Var = WriteNullListAsEmpty;
        c0 c0Var2 = WriteNullStringAsEmpty;
        c0 c0Var3 = WriteNullNumberAsZero;
        c0 c0Var4 = WriteNullBooleanAsFalse;
        f6382D = new c0[0];
        f6383G = c0Var.f6406a | c0Var4.f6406a | c0Var.f6406a | c0Var3.f6406a | c0Var2.f6406a;
    }

    public c0() {
        super(str, i);
        this.f6406a = 1 << ordinal();
    }

    public static int a(c0[] c0VarArr) {
        if (c0VarArr == null) {
            return 0;
        }
        int i5 = 0;
        for (c0 c0Var : c0VarArr) {
            i5 |= c0Var.f6406a;
        }
        return i5;
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f6384H.clone();
    }
}
