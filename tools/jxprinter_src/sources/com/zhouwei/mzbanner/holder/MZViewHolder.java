package com.zhouwei.mzbanner.holder;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface MZViewHolder<T> {
    View createView(Context context);

    void onBind(Context context, int i5, T t6);
}
