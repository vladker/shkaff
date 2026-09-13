package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d);

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f6);

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i5);

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j6);

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj);

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z6);

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, double d);

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, int i5);

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, long j6);

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj);

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, boolean z6);

    @NonNull
    ObjectEncoderContext inline(@Nullable Object obj);

    @NonNull
    ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor);

    @NonNull
    ObjectEncoderContext nested(@NonNull String str);
}
