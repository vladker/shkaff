package com.zlylib.titlebarlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class StatusBarView extends View {
    public StatusBarView(Context context) {
        super(context);
    }

    public boolean isVisibility() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(View.MeasureSpec.getSize(i5), c.getHeight(getContext()));
    }

    public void setVisibility(boolean z6) {
        setVisibility(z6 ? 0 : 8);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
