package p134x2;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L0 f8859a;
    public static final L0 b;
    public static final L0 c;
    public static final /* synthetic */ L0[] d;
    public static final /* synthetic */ a e;

    static {
        L0 l6 = new L0("BLUETOOTH", 0);
        f8859a = l6;
        L0 l7 = new L0("USB", 1);
        b = l7;
        L0 l8 = new L0("WIFI", 2);
        c = l8;
        L0[] l0Arr = {l6, l7, l8};
        d = l0Arr;
        e = b.enumEntries(l0Arr);
    }

    public static a getEntries() {
        return e;
    }

    public static L0 valueOf(String str) {
        return (L0) Enum.valueOf(L0.class, str);
    }

    public static L0[] values() {
        return (L0[]) d.clone();
    }
}
