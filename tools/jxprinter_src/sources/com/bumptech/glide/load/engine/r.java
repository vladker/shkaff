package com.bumptech.glide.load.engine;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements M0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0502s f3069a;

    public r(C0502s c0502s) {
        this.f3069a = c0502s;
    }

    @Override // M0.d
    public final Object create() {
        C0502s c0502s = this.f3069a;
        return new RunnableC0497m(c0502s.f3070a, c0502s.b);
    }
}
