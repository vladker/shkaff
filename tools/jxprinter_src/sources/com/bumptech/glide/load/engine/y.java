package com.bumptech.glide.load.engine;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3082a;
    public final I0.m b;
    public final /* synthetic */ C c;

    public /* synthetic */ y(C c, I0.m mVar, int i5) {
        this.f3082a = i5;
        this.c = c;
        this.b = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3082a) {
            case 0:
                I0.m mVar = this.b;
                mVar.f334a.a();
                synchronized (mVar.b) {
                    synchronized (this.c) {
                        try {
                            if (this.c.f2930a.f2928a.contains(new A(this.b, L0.i.b))) {
                                this.c.callCallbackOnLoadFailed(this.b);
                            }
                            this.c.c();
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                }
                return;
            default:
                I0.m mVar2 = this.b;
                mVar2.f334a.a();
                synchronized (mVar2.b) {
                    synchronized (this.c) {
                        try {
                            if (this.c.f2930a.f2928a.contains(new A(this.b, L0.i.b))) {
                                this.c.f2947v.a();
                                this.c.callCallbackOnResourceReady(this.b);
                                this.c.g(this.b);
                            }
                            this.c.c();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                }
                return;
        }
    }
}
