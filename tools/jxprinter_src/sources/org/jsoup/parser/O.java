package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7560a;

    public static void g(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public final boolean a() {
        return this.f7560a == 4;
    }

    public final boolean b() {
        return this.f7560a == 1;
    }

    public final boolean c() {
        return this.f7560a == 6;
    }

    public final boolean d() {
        return this.f7560a == 3;
    }

    public final boolean e() {
        return this.f7560a == 2;
    }

    public abstract O f();
}
