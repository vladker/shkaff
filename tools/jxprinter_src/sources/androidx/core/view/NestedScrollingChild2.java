package androidx.core.view;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2, int i7);

    boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr, int i9);

    boolean hasNestedScrollingParent(int i5);

    boolean startNestedScroll(int i5, int i6);

    void stopNestedScroll(int i5);
}
