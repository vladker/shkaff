package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface MethodCodec {
    @NonNull
    Object decodeEnvelope(@NonNull ByteBuffer byteBuffer);

    @NonNull
    MethodCall decodeMethodCall(@NonNull ByteBuffer byteBuffer);

    @NonNull
    ByteBuffer encodeErrorEnvelope(@NonNull String str, @Nullable String str2, @Nullable Object obj);

    @NonNull
    ByteBuffer encodeErrorEnvelopeWithStacktrace(@NonNull String str, @Nullable String str2, @Nullable Object obj, @Nullable String str3);

    @NonNull
    ByteBuffer encodeMethodCall(@NonNull MethodCall methodCall);

    @NonNull
    ByteBuffer encodeSuccessEnvelope(@Nullable Object obj);
}
