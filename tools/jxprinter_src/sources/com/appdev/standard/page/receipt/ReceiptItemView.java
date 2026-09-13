package com.appdev.standard.page.receipt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.appdev.standard.page.printerlabel.widget.BaseTableView;
import com.appdev.standard.page.printerlabel.widget.BaseTextView;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ReceiptItemView extends RelativeLayout {
    public ReceiptItemView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BaseTableView baseTableView;
        BaseTextView baseTextViewTestHitCell;
        a.d("ReceiptItemView", "width=" + getWidth() + ", height=" + getHeight());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if ((childAt instanceof BaseTableView) && motionEvent.getAction() == 1 && (baseTextViewTestHitCell = (baseTableView = (BaseTableView) childAt).testHitCell((int) motionEvent.getX(), (int) motionEvent.getY())) != null) {
                baseTableView.select(baseTextViewTestHitCell);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ReceiptItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReceiptItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
