package androidx.core.view;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(View view, int i5, int i6, int[] iArr, int i7);

    void onNestedScroll(View view, int i5, int i6, int i7, int i8, int i9);

    void onNestedScrollAccepted(View view, View view2, int i5, int i6);

    boolean onStartNestedScroll(View view, View view2, int i5, int i6);

    void onStopNestedScroll(View view, int i5);
}
