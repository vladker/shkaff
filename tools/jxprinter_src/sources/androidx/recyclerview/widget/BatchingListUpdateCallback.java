package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    final ListUpdateCallback mWrapped;
    int mLastEventType = 0;
    int mLastEventPosition = -1;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i5 = this.mLastEventType;
        if (i5 == 0) {
            return;
        }
        if (i5 == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i5 == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i5 == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i5, int i6, Object obj) {
        int i7;
        if (this.mLastEventType == 3) {
            int i8 = this.mLastEventPosition;
            int i9 = this.mLastEventCount;
            if (i5 <= i8 + i9 && (i7 = i5 + i6) >= i8 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i5, i8);
                this.mLastEventCount = Math.max(i9 + i8, i7) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i5;
        this.mLastEventCount = i6;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i5, int i6) {
        int i7;
        if (this.mLastEventType == 1 && i5 >= (i7 = this.mLastEventPosition)) {
            int i8 = this.mLastEventCount;
            if (i5 <= i7 + i8) {
                this.mLastEventCount = i8 + i6;
                this.mLastEventPosition = Math.min(i5, i7);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i5;
        this.mLastEventCount = i6;
        this.mLastEventType = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i5, int i6) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i5, int i6) {
        int i7;
        if (this.mLastEventType == 2 && (i7 = this.mLastEventPosition) >= i5 && i7 <= i5 + i6) {
            this.mLastEventCount += i6;
            this.mLastEventPosition = i5;
        } else {
            dispatchLastEvent();
            this.mLastEventPosition = i5;
            this.mLastEventCount = i6;
            this.mLastEventType = 2;
        }
    }
}
