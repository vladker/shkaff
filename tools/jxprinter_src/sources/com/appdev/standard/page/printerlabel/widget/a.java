package com.appdev.standard.page.printerlabel.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements BaseTextView.TextLengthCalculator, PrinterLabelBgView.BgImageLoadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2812a;
    public final /* synthetic */ View b;

    public /* synthetic */ a(View view, int i5) {
        this.f2812a = i5;
        this.b = view;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseTextView.TextLengthCalculator
    public float calculate(String str) {
        switch (this.f2812a) {
            case 0:
                return ((BaseTextView) this.b).lambda$measureHorizontal$0(str);
            case 1:
                return ((BaseTextView) this.b).lambda$measureScrollPair$1(str);
            default:
                return ((BaseTextView) this.b).lambda$measureScrollPair$1(str);
        }
    }

    @Override // com.appdev.standard.page.printerlabel.widget.PrinterLabelBgView.BgImageLoadListener
    public void onBgImageLoad(Drawable drawable, Drawable drawable2) {
        ((PrinterLabelBgView) this.b).lambda$loadBg$0(drawable, drawable2);
    }
}
