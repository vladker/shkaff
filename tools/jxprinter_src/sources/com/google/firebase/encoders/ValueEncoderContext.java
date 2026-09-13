package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d);

    @NonNull
    ValueEncoderContext add(float f6);

    @NonNull
    ValueEncoderContext add(int i5);

    @NonNull
    ValueEncoderContext add(long j6);

    @NonNull
    ValueEncoderContext add(@Nullable String str);

    @NonNull
    ValueEncoderContext add(boolean z6);

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr);
}
