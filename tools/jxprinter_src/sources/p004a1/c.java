package p004a1;

import xyz.doikki.videoplayer.player.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f929a;
    public boolean b;
    public boolean c;
    public boolean d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f933i;

    public c() {
        if (!d.c) {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    public final k a() {
        k kVar = new k(1);
        a aVar = new a(d.f934a);
        String str = this.f929a;
        if (str != null) {
            aVar.b = str;
        }
        if (this.c) {
            if (this.b) {
                aVar.c = true;
            } else {
                aVar.c = false;
            }
        }
        if (this.f931g) {
            if (this.d) {
                String str2 = this.e;
                int i5 = this.f930f;
                aVar.d = true;
                aVar.e = str2;
                aVar.f908f = i5;
            } else {
                aVar.d = false;
                aVar.e = null;
                aVar.f908f = 0;
            }
        }
        if (this.f933i) {
            if (this.f932h) {
                aVar.f909g = true;
            } else {
                aVar.f909g = false;
            }
        }
        kVar.b = aVar.a();
        kVar.c = d.b;
        return kVar;
    }

    @Deprecated
    public c b() {
        this.f932h = true;
        this.f933i = true;
        return this;
    }

    @Deprecated
    public c nb() {
        this.f932h = false;
        this.f933i = true;
        return this;
    }

    @Deprecated
    public c nst() {
        this.d = false;
        this.e = null;
        this.f930f = 0;
        this.f931g = true;
        return this;
    }

    @Deprecated
    public c nt() {
        this.b = false;
        this.c = true;
        return this;
    }

    @Deprecated
    public c st(int i5) {
        this.d = true;
        this.f930f = i5;
        this.f931g = true;
        return this;
    }

    @Deprecated
    public c t() {
        this.b = true;
        this.c = true;
        return this;
    }

    @Deprecated
    public c st(String str, int i5) {
        this.d = true;
        this.e = str;
        this.f930f = i5;
        this.f931g = true;
        return this;
    }
}
