package com.bumptech.glide;

import androidx.annotation.NonNull;
import java.util.List;
import p144z0.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class s extends q {
    public s(@NonNull Object obj) {
        super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
    }

    public <M> s(@NonNull M m6, @NonNull List<T> list) {
        super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m6);
    }

    public s(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
    }
}
