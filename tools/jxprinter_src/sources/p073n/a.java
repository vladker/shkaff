package p073n;

import java.util.HashMap;
import p096r.d;
import p096r.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6183a;
    public final HashMap b = new HashMap();
    public final Class c;
    public final g d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d[] f6184f;

    public a(String str, g gVar, int i5) {
        this.f6183a = -1;
        this.e = str;
        this.c = gVar.f7912a;
        this.f6183a = i5;
        this.d = gVar;
        this.f6184f = gVar.f7915h;
    }

    public final int a(String str) {
        HashMap map = this.b;
        if (((Integer) map.get(str)) == null) {
            map.put(str, Integer.valueOf(this.f6183a));
            this.f6183a += 2;
        }
        return ((Integer) map.get(str)).intValue();
    }

    public final int b(String str) {
        HashMap map = this.b;
        if (((Integer) map.get(str)) == null) {
            int i5 = this.f6183a;
            this.f6183a = i5 + 1;
            map.put(str, Integer.valueOf(i5));
        }
        return ((Integer) map.get(str)).intValue();
    }
}
