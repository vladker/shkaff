package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.List;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0489e implements InterfaceC0493i, com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3011a;
    public final C0494j b;
    public final InterfaceC0492h c;
    public int d = -1;
    public p126w0.q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f3012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile p144z0.S f3014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f3015i;

    public C0489e(List list, C0494j c0494j, InterfaceC0492h interfaceC0492h) {
        this.f3011a = list;
        this.b = c0494j;
        this.c = interfaceC0492h;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0493i
    public final boolean a() {
        while (true) {
            List list = this.f3012f;
            boolean z6 = false;
            if (list != null && this.f3013g < list.size()) {
                this.f3014h = null;
                while (!z6 && this.f3013g < this.f3012f.size()) {
                    List list2 = this.f3012f;
                    int i5 = this.f3013g;
                    this.f3013g = i5 + 1;
                    p144z0.T t6 = (p144z0.T) list2.get(i5);
                    File file = this.f3015i;
                    C0494j c0494j = this.b;
                    this.f3014h = t6.buildLoadData(file, c0494j.e, c0494j.f3018f, c0494j.f3021i);
                    if (this.f3014h != null) {
                        C0494j c0494j2 = this.b;
                        if (c0494j2.c.getRegistry().getLoadPath(this.f3014h.c.getDataClass(), c0494j2.f3019g, c0494j2.f3023k) != null) {
                            this.f3014h.c.loadData(this.b.f3027o, this);
                            z6 = true;
                        }
                    }
                }
                return z6;
            }
            int i6 = this.d + 1;
            this.d = i6;
            if (i6 >= this.f3011a.size()) {
                return false;
            }
            p126w0.q qVar = (p126w0.q) this.f3011a.get(this.d);
            C0494j c0494j3 = this.b;
            File file2 = c0494j3.f3020h.a().get(new C0490f(qVar, c0494j3.f3026n));
            this.f3015i = file2;
            if (file2 != null) {
                this.e = qVar;
                this.f3012f = this.b.getModelLoaders(file2);
                this.f3013g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0493i
    public final void cancel() {
        p144z0.S s6 = this.f3014h;
        if (s6 != null) {
            s6.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void onDataReady(Object obj) {
        this.c.onDataFetcherReady(this.e, obj, this.f3014h.c, p126w0.a.c, this.e);
    }

    @Override // com.bumptech.glide.load.data.d
    public void onLoadFailed(@NonNull Exception exc) {
        this.c.b(this.e, exc, this.f3014h.c, p126w0.a.c);
    }
}
