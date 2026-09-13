package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class V implements InterfaceC0493i, InterfaceC0492h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0494j f2979a;
    public final RunnableC0497m b;
    public volatile int c;
    public volatile C0489e d;
    public volatile Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile p144z0.S f2980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile C0490f f2981g;

    public V(C0494j c0494j, RunnableC0497m runnableC0497m) {
        this.f2979a = c0494j;
        this.b = runnableC0497m;
    }

    private boolean cacheData(Object obj) throws Throwable {
        Throwable th;
        long logTime = L0.l.getLogTime();
        boolean z6 = false;
        try {
            com.bumptech.glide.load.data.g rewinder = this.f2979a.c.getRegistry().getRewinder(obj);
            Object objRewindAndGet = rewinder.rewindAndGet();
            p126w0.d sourceEncoder = this.f2979a.getSourceEncoder(objRewindAndGet);
            C0491g c0491g = new C0491g(sourceEncoder, objRewindAndGet, this.f2979a.f3021i);
            p126w0.q qVar = this.f2980f.f9063a;
            C0494j c0494j = this.f2979a;
            C0490f c0490f = new C0490f(qVar, c0494j.f3026n);
            com.bumptech.glide.load.engine.cache.c cVarA = c0494j.f3020h.a();
            cVarA.a(c0490f, c0491g);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + c0490f + ", data: " + obj + ", encoder: " + sourceEncoder + ", duration: " + L0.l.a(logTime));
            }
            if (cVarA.get(c0490f) != null) {
                this.f2981g = c0490f;
                this.d = new C0489e(Collections.singletonList(this.f2980f.f9063a), this.f2979a, this);
                this.f2980f.c.a();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f2981g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.b.onDataFetcherReady(this.f2980f.f9063a, rewinder.rewindAndGet(), this.f2980f.c, this.f2980f.c.getDataSource(), this.f2980f.f9063a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z6 = true;
                if (z6) {
                    throw th;
                }
                this.f2980f.c.a();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x005a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0032 A[SYNTHETIC] */
    @Override // com.bumptech.glide.load.engine.InterfaceC0493i
    public final boolean a() {
        boolean z6;
        C0494j c0494j;
        if (this.e == null) {
            if (this.d != null) {
            }
            this.d = null;
            this.f2980f = null;
            z6 = false;
            while (!z6) {
                ArrayList arrayListB = this.f2979a.b();
                int i5 = this.c;
                this.c = i5 + 1;
                this.f2980f = (p144z0.S) arrayListB.get(i5);
                if (this.f2980f == null) {
                    if (!this.f2979a.f3028p.c(this.f2980f.c.getDataSource())) {
                        c0494j = this.f2979a;
                        if (c0494j.c.getRegistry().getLoadPath(this.f2980f.c.getDataClass(), c0494j.f3019g, c0494j.f3023k) != null) {
                        }
                    }
                    this.f2980f.c.loadData(this.f2979a.f3027o, new U(this, this.f2980f));
                    z6 = true;
                }
            }
            return z6;
        }
        Object obj = this.e;
        this.e = null;
        try {
            if (cacheData(obj)) {
                if (this.d != null || !this.d.a()) {
                    this.d = null;
                    this.f2980f = null;
                    z6 = false;
                    while (!z6 && this.c < this.f2979a.b().size()) {
                        ArrayList arrayListB2 = this.f2979a.b();
                        int i6 = this.c;
                        this.c = i6 + 1;
                        this.f2980f = (p144z0.S) arrayListB2.get(i6);
                        if (this.f2980f == null) {
                            if (!this.f2979a.f3028p.c(this.f2980f.c.getDataSource())) {
                                c0494j = this.f2979a;
                                if (c0494j.c.getRegistry().getLoadPath(this.f2980f.c.getDataClass(), c0494j.f3019g, c0494j.f3023k) != null) {
                                }
                            }
                            this.f2980f.c.loadData(this.f2979a.f3027o, new U(this, this.f2980f));
                            z6 = true;
                        }
                    }
                    return z6;
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
            }
        }
        return true;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0492h
    public final void b(p126w0.q qVar, Exception exc, com.bumptech.glide.load.data.e eVar, p126w0.a aVar) {
        this.b.b(qVar, exc, eVar, this.f2980f.c.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0493i
    public final void cancel() {
        p144z0.S s6 = this.f2980f;
        if (s6 != null) {
            s6.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0492h
    public final void onDataFetcherReady(p126w0.q qVar, Object obj, com.bumptech.glide.load.data.e eVar, p126w0.a aVar, p126w0.q qVar2) {
        this.b.onDataFetcherReady(qVar, obj, eVar, this.f2980f.c.getDataSource(), qVar);
    }

    public void onLoadFailedInternal(p144z0.S s6, @NonNull Exception exc) {
        RunnableC0497m runnableC0497m = this.b;
        C0490f c0490f = this.f2981g;
        com.bumptech.glide.load.data.e eVar = s6.c;
        runnableC0497m.b(c0490f, exc, eVar, eVar.getDataSource());
    }
}
