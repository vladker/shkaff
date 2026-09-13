package p067m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public enum c {
    AutoCloseSource,
    /* JADX INFO: Fake field, exist only in values array */
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    /* JADX INFO: Fake field, exist only in values array */
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6089a = 1 << ordinal();

    c() {
    }

    public static int a(c[] cVarArr) {
        if (cVarArr == null) {
            return 0;
        }
        int i5 = 0;
        for (c cVar : cVarArr) {
            i5 |= cVar.f6089a;
        }
        return i5;
    }
}
