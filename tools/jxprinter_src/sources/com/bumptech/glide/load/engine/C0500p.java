package com.bumptech.glide.load.engine;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0500p extends AbstractC0501q {
    public final /* synthetic */ int e;

    @Override // com.bumptech.glide.load.engine.AbstractC0501q
    public final boolean a() {
        switch (this.e) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return false;
            default:
                return true;
        }
    }

    @Override // com.bumptech.glide.load.engine.AbstractC0501q
    public final boolean b() {
        switch (this.e) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return true;
            default:
                return true;
        }
    }

    @Override // com.bumptech.glide.load.engine.AbstractC0501q
    public final boolean c(p126w0.a aVar) {
        switch (this.e) {
            case 0:
                return false;
            case 1:
                return (aVar == p126w0.a.c || aVar == p126w0.a.e) ? false : true;
            case 2:
                return false;
            default:
                return aVar == p126w0.a.b;
        }
    }

    @Override // com.bumptech.glide.load.engine.AbstractC0501q
    public final boolean d(boolean z6, p126w0.a aVar, p126w0.c cVar) {
        switch (this.e) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return (aVar == p126w0.a.d || aVar == p126w0.a.e) ? false : true;
            default:
                return ((z6 && aVar == p126w0.a.c) || aVar == p126w0.a.f8801a) && cVar == p126w0.c.b;
        }
    }
}
