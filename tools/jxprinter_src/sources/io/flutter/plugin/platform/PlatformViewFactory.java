package io.flutter.plugin.platform;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MessageCodec;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PlatformViewFactory {
    private final MessageCodec<Object> createArgsCodec;

    public PlatformViewFactory(@Nullable MessageCodec<Object> messageCodec) {
        this.createArgsCodec = messageCodec;
    }

    @NonNull
    public abstract PlatformView create(Context context, int i5, @Nullable Object obj);

    @Nullable
    public final MessageCodec<Object> getCreateArgsCodec() {
        return this.createArgsCodec;
    }
}
