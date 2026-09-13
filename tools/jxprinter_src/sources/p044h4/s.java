package p044h4;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f4039a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final /* synthetic */ s[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a f4040f;

    static {
        s sVar = new s("SUCCESSFUL", 0);
        f4039a = sVar;
        s sVar2 = new s("REREGISTER", 1);
        b = sVar2;
        s sVar3 = new s("CANCELLED", 2);
        c = sVar3;
        s sVar4 = new s("ALREADY_SELECTED", 3);
        d = sVar4;
        s[] sVarArr = {sVar, sVar2, sVar3, sVar4};
        e = sVarArr;
        f4040f = b.enumEntries(sVarArr);
    }

    public static a getEntries() {
        return f4040f;
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) e.clone();
    }
}
