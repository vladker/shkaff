package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i5, int i6, @Nullable Object obj);

    void onInserted(int i5, int i6);

    void onMoved(int i5, int i6);

    void onRemoved(int i5, int i6);
}
