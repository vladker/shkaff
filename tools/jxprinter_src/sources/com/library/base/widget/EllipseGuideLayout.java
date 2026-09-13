package com.library.base.widget;

import Y1.a;
import Y1.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class EllipseGuideLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f3609a;

    public EllipseGuideLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3609a = null;
    }

    public void init(int i5, @DimenRes int i6) {
        this.f3609a = new ArrayList();
        setOrientation(0);
        int dimension = (int) getContext().getResources().getDimension(i6);
        int dimension2 = (int) getContext().getResources().getDimension(a.px8dp);
        for (int i7 = 1; i7 <= i5; i7++) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, dimension);
            if (i7 != i5) {
                layoutParams.rightMargin = dimension2;
            }
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(b.bg_unselected_ellipse);
            addView(view);
            this.f3609a.add(view);
        }
        ((View) this.f3609a.get(0)).setBackgroundResource(b.bg_selected_ellipse);
    }

    public EllipseGuideLayout(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f3609a = null;
    }
}
