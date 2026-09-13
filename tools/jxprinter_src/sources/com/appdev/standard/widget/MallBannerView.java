package com.appdev.standard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zhouwei.mzbanner.MZBannerView;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MallBannerView extends MZBannerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2857a;

    public MallBannerView(@NonNull Context context) {
        super(context);
        this.f2857a = 1.0f;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z6) {
        super.onWindowFocusChanged(z6);
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth > 0) {
            int i5 = (int) (measuredWidth * this.f2857a);
            a.k("onWindowFocusChanged", measuredWidth + " " + i5);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = i5;
            setLayoutParams(layoutParams);
        }
    }

    public void setWHRatio(float f6) {
        this.f2857a = f6;
    }

    public MallBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2857a = 1.0f;
    }

    public MallBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f2857a = 1.0f;
    }

    public MallBannerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f2857a = 1.0f;
    }
}
