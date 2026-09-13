package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0522q f3116a = new C0522q(2);
    public static final C0522q b = new C0522q(0);
    public static final C0522q c;
    public static final C0522q d;
    public static final C0522q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p126w0.u f3117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f3118g;

    static {
        C0522q c0522q = new C0522q(1);
        c = c0522q;
        d = new C0522q(3);
        e = c0522q;
        f3117f = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", c0522q);
        f3118g = true;
    }

    public abstract int a(int i5, int i6, int i7, int i8);

    public abstract float b(int i5, int i6, int i7, int i8);
}
