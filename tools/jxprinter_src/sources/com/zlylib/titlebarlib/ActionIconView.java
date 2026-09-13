package com.zlylib.titlebarlib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ActionIconView extends AppCompatImageView {
    public ActionIconView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i5, int i6) {
        int size = View.MeasureSpec.getSize(i6);
        setMeasuredDimension(size, size);
    }

    public ActionIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionIconView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
