package p115u1;

import p092q1.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements b {
    public static final c d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8733a;
    public boolean b;
    public volatile UnsatisfiedLinkError c;

    static {
        c cVar = new c();
        cVar.add("conceal");
        d = cVar;
    }

    public final synchronized boolean a() {
        if (!this.f8733a) {
            return this.b;
        }
        try {
            c cVar = d;
            int size = cVar.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = cVar.get(i5);
                i5++;
                System.loadLibrary((String) obj);
            }
            this.b = true;
        } catch (UnsatisfiedLinkError e) {
            this.c = e;
            this.b = false;
        }
        this.f8733a = false;
        return this.b;
    }

    @Override // p115u1.b
    public synchronized void ensureCryptoLoaded() {
        if (!a()) {
            throw new a(this.c);
        }
    }
}
