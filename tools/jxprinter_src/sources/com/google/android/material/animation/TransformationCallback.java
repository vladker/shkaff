package com.google.android.material.animation;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface TransformationCallback<T extends View> {
    void onScaleChanged(T t6);

    void onTranslationChanged(T t6);
}
