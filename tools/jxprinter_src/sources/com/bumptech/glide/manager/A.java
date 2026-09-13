package com.bumptech.glide.manager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3162a;
    public final /* synthetic */ B b;

    public A(B b, boolean z6) {
        this.b = b;
        this.f3162a = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        L0.s.a();
        C c = this.b.f3163a;
        boolean z6 = c.f3164a;
        boolean z7 = this.f3162a;
        c.f3164a = z7;
        if (z6 != z7) {
            c.b.a(z7);
        }
    }
}
