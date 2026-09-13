package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface e {
    void a();

    void cancel();

    @NonNull
    Class<Object> getDataClass();

    @NonNull
    p126w0.a getDataSource();

    void loadData(@NonNull com.bumptech.glide.o oVar, @NonNull d dVar);
}
