package p134x2;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final J f8857a;
    public static final J b;
    public static final /* synthetic */ J[] c;
    public static final /* synthetic */ a d;

    static {
        J j6 = new J("SUCCESS", 0);
        f8857a = j6;
        J j7 = new J("FAILURE", 1);
        b = j7;
        J[] jArr = {j6, j7};
        c = jArr;
        d = b.enumEntries(jArr);
    }

    public static a getEntries() {
        return d;
    }

    public static J valueOf(String str) {
        return (J) Enum.valueOf(J.class, str);
    }

    public static J[] values() {
        return (J[]) c.clone();
    }
}
