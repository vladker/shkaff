package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class P implements InterfaceC0493i, com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunnableC0497m f2965a;
    public final C0494j b;
    public int c;
    public int d = -1;
    public p126w0.q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f2966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile p144z0.S f2968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f2969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Q f2970j;

    public P(C0494j c0494j, RunnableC0497m runnableC0497m) {
        this.b = c0494j;
        this.f2965a = runnableC0497m;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0493i
    public final boolean a() {
        ArrayList arrayListA = this.b.a();
        boolean z6 = false;
        if (!arrayListA.isEmpty()) {
            C0494j c0494j = this.b;
            List<Class<?>> registeredResourceClasses = c0494j.c.getRegistry().getRegisteredResourceClasses(c0494j.d.getClass(), c0494j.f3019g, c0494j.f3023k);
            if (!registeredResourceClasses.isEmpty()) {
                while (true) {
                    List list = this.f2966f;
                    if (list != null && this.f2967g < list.size()) {
                        this.f2968h = null;
                        while (!z6 && this.f2967g < this.f2966f.size()) {
                            List list2 = this.f2966f;
                            int i5 = this.f2967g;
                            this.f2967g = i5 + 1;
                            p144z0.T t6 = (p144z0.T) list2.get(i5);
                            File file = this.f2969i;
                            C0494j c0494j2 = this.b;
                            this.f2968h = t6.buildLoadData(file, c0494j2.e, c0494j2.f3018f, c0494j2.f3021i);
                            if (this.f2968h != null) {
                                C0494j c0494j3 = this.b;
                                if (c0494j3.c.getRegistry().getLoadPath(this.f2968h.c.getDataClass(), c0494j3.f3019g, c0494j3.f3023k) != null) {
                                    this.f2968h.c.loadData(this.b.f3027o, this);
                                    z6 = true;
                                }
                            }
                        }
                        return z6;
                    }
                    int i6 = this.d + 1;
                    this.d = i6;
                    if (i6 >= registeredResourceClasses.size()) {
                        int i7 = this.c + 1;
                        this.c = i7;
                        if (i7 < arrayListA.size()) {
                            this.d = 0;
                        }
                    }
                    p126w0.q qVar = (p126w0.q) arrayListA.get(this.c);
                    Class<?> cls = registeredResourceClasses.get(this.d);
                    p126w0.z zVarC = this.b.c(cls);
                    com.bumptech.glide.load.engine.bitmap_recycle.a arrayPool = this.b.c.getArrayPool();
                    C0494j c0494j4 = this.b;
                    this.f2970j = new Q(arrayPool, qVar, c0494j4.f3026n, c0494j4.e, c0494j4.f3018f, zVarC, cls, c0494j4.f3021i);
                    File file2 = c0494j4.f3020h.a().get(this.f2970j);
                    this.f2969i = file2;
                    if (file2 != null) {
                        this.e = qVar;
                        this.f2966f = this.b.getModelLoaders(file2);
                        this.f2967g = 0;
                    }
                }
            } else if (!File.class.equals(this.b.f3023k)) {
                throw new IllegalStateException("Failed to find any load path from " + this.b.d.getClass() + " to " + this.b.f3023k);
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0493i
    public final void cancel() {
        p144z0.S s6 = this.f2968h;
        if (s6 != null) {
            s6.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void onDataReady(Object obj) {
        this.f2965a.onDataFetcherReady(this.e, obj, this.f2968h.c, p126w0.a.d, this.f2970j);
    }

    @Override // com.bumptech.glide.load.data.d
    public void onLoadFailed(@NonNull Exception exc) {
        this.f2965a.b(this.f2970j, exc, this.f2968h.c, p126w0.a.d);
    }
}
