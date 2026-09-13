package com.library.base.util.recyclerview;

import android.util.Log;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ScrollLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i5, int i6) {
        if (canScrollHorizontally()) {
            return;
        }
        Log.i(NotificationCompat.CATEGORY_MESSAGE, "onMeasure---MeasureSpec-" + View.MeasureSpec.getSize(i6));
        int itemCount = getItemCount();
        int decoratedBottom = 0;
        for (int i7 = 0; i7 < itemCount; i7++) {
            View viewForPosition = recycler.getViewForPosition(i7);
            measureChild(viewForPosition, i5, i6);
            decoratedBottom += getDecoratedBottom(viewForPosition) + viewForPosition.getMeasuredHeight();
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + decoratedBottom;
        Log.i(NotificationCompat.CATEGORY_MESSAGE, "onMeasure---height-" + paddingBottom);
        setMeasuredDimension(View.MeasureSpec.getSize(i5), paddingBottom);
    }
}
