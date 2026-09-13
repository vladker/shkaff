package com.appdev.standard.page.printerlabel.widget;

import I0.i;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2813a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Drawable[] c;
    public final /* synthetic */ boolean[] d;
    public final /* synthetic */ boolean[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Drawable[] f2814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ PrinterLabelBgView.BgImageLoadListener f2815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int[] f2816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ i f2818j;

    public /* synthetic */ b(i iVar, String str, Drawable[] drawableArr, boolean[] zArr, boolean[] zArr2, Drawable[] drawableArr2, PrinterLabelBgView.BgImageLoadListener bgImageLoadListener, int[] iArr, int i5, int i6) {
        this.f2813a = i6;
        this.f2818j = iVar;
        this.b = str;
        this.c = drawableArr;
        this.d = zArr;
        this.e = zArr2;
        this.f2814f = drawableArr2;
        this.f2815g = bgImageLoadListener;
        this.f2816h = iArr;
        this.f2817i = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2813a) {
            case 0:
                ((PrinterLabelBgView.AnonymousClass2) this.f2818j).lambda$onLoadFailed$0(this.b, this.c, this.d, this.e, this.f2814f, this.f2815g, this.f2816h, this.f2817i);
                break;
            default:
                ((PrinterLabelBgView.AnonymousClass4) this.f2818j).lambda$onLoadFailed$0(this.b, this.c, this.d, this.e, this.f2814f, this.f2815g, this.f2816h, this.f2817i);
                break;
        }
    }
}
