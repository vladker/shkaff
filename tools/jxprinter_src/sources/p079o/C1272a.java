package p079o;

import java.util.HashMap;
import p096r.d;

/* JADX INFO: renamed from: o.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1272a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d[] f6352a;
    public final String b;
    public final X c;
    public final boolean d;
    public final HashMap e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6353f = 9;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f6354g;

    public C1272a(d[] dVarArr, X x6, String str, boolean z6, boolean z7) {
        this.f6352a = dVarArr;
        this.b = str;
        this.c = x6;
        this.d = z6;
        this.f6354g = z7;
    }

    public final int a(String str) {
        HashMap map = this.e;
        if (((Integer) map.get(str)) == null) {
            int i5 = this.f6353f;
            this.f6353f = i5 + 1;
            map.put(str, Integer.valueOf(i5));
        }
        return ((Integer) map.get(str)).intValue();
    }

    public final int b(String str) {
        HashMap map = this.e;
        if (((Integer) map.get(str)) == null) {
            map.put(str, Integer.valueOf(this.f6353f));
            this.f6353f += 2;
        }
        return ((Integer) map.get(str)).intValue();
    }
}
