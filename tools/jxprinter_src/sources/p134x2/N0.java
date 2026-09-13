package p134x2;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final N0 f8860a;
    public static final N0 b;
    public static final N0 c;
    public static final /* synthetic */ N0[] d;
    public static final /* synthetic */ a e;

    static {
        N0 n6 = new N0("Failed", 0);
        f8860a = n6;
        N0 n7 = new N0("OtherDevice", 1);
        b = n7;
        N0 n8 = new N0("DeviceClosed", 2);
        c = n8;
        N0[] n0Arr = {n6, n7, n8};
        d = n0Arr;
        e = b.enumEntries(n0Arr);
    }

    public static a getEntries() {
        return e;
    }

    public static N0 valueOf(String str) {
        return (N0) Enum.valueOf(N0.class, str);
    }

    public static N0[] values() {
        return (N0[]) d.clone();
    }
}
