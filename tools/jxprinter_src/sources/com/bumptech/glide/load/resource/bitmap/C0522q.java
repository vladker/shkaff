package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0522q extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f3115h;

    @Override // com.bumptech.glide.load.resource.bitmap.r
    public final int a(int i5, int i6, int i7, int i8) {
        switch (this.f3115h) {
            case 0:
                if (b(i5, i6, i7, i8) == 1.0f) {
                    return 2;
                }
                return r.f3116a.a(i5, i6, i7, i8);
            case 1:
                return 2;
            case 2:
                return r.f3118g ? 2 : 1;
            default:
                return 2;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.r
    public final float b(int i5, int i6, int i7, int i8) {
        switch (this.f3115h) {
            case 0:
                return Math.min(1.0f, r.f3116a.b(i5, i6, i7, i8));
            case 1:
                return Math.max(i7 / i5, i8 / i6);
            case 2:
                if (r.f3118g) {
                    return Math.min(i7 / i5, i8 / i6);
                }
                int iMax = Math.max(i6 / i8, i5 / i7);
                if (iMax == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(iMax);
            default:
                return 1.0f;
        }
    }
}
