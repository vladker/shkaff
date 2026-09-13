package androidx.core.view;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(View view, float f6, float f7, boolean z6);

    boolean onNestedPreFling(View view, float f6, float f7);

    void onNestedPreScroll(View view, int i5, int i6, int[] iArr);

    void onNestedScroll(View view, int i5, int i6, int i7, int i8);

    void onNestedScrollAccepted(View view, View view2, int i5);

    boolean onStartNestedScroll(View view, View view2, int i5);

    void onStopNestedScroll(View view);
}
