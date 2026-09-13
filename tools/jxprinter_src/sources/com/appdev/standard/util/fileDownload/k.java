package com.appdev.standard.util.fileDownload;

import A4.InterfaceC0171n;
import A4.N;
import okhttp3.B;
import okhttp3.W;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W f2848a;
    public final S4.h b;
    public InterfaceC0171n c;
    public final String d;

    public k(String str, W w6, S4.h hVar) {
        this.f2848a = w6;
        this.b = hVar;
        this.d = str;
    }

    @Override // okhttp3.W
    public final long c() {
        return this.f2848a.c();
    }

    @Override // okhttp3.W
    public final B contentType() {
        return this.f2848a.contentType();
    }

    @Override // okhttp3.W
    public final InterfaceC0171n d() {
        if (this.c == null) {
            this.c = N.buffer(new j(this, this.f2848a.d()));
        }
        return this.c;
    }
}
