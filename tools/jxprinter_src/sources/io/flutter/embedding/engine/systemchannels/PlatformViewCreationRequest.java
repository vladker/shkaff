package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewCreationRequest {
    public final int direction;
    public final RequestedDisplayMode displayMode;
    public final double logicalHeight;
    public final double logicalLeft;
    public final double logicalTop;
    public final double logicalWidth;

    @Nullable
    public final ByteBuffer params;
    public final int viewId;

    @NonNull
    public final String viewType;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum RequestedDisplayMode {
        TEXTURE_WITH_VIRTUAL_FALLBACK,
        TEXTURE_WITH_HYBRID_FALLBACK,
        HYBRID_ONLY
    }

    @VisibleForTesting
    public PlatformViewCreationRequest(int i5, @NonNull String str, double d, double d6, double d7, double d8, int i6, @Nullable ByteBuffer byteBuffer) {
        this(i5, str, d, d6, d7, d8, i6, RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
    }

    public static PlatformViewCreationRequest createHCPPRequest(int i5, String str, int i6, ByteBuffer byteBuffer) {
        return new PlatformViewCreationRequest(i5, str, 0.0d, 0.0d, 0.0d, 0.0d, i6, null, byteBuffer);
    }

    public static PlatformViewCreationRequest createHybridCompositionRequest(int i5, String str, int i6, ByteBuffer byteBuffer) {
        return new PlatformViewCreationRequest(i5, str, 0.0d, 0.0d, 0.0d, 0.0d, i6, RequestedDisplayMode.HYBRID_ONLY, byteBuffer);
    }

    public static PlatformViewCreationRequest createTLHCWithFallbackRequest(int i5, String str, double d, double d6, double d7, double d8, int i6, boolean z6, ByteBuffer byteBuffer) {
        return new PlatformViewCreationRequest(i5, str, d, d6, d7, d8, i6, z6 ? RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK : RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
    }

    public PlatformViewCreationRequest(int i5, @NonNull String str, double d, double d6, double d7, double d8, int i6, @Nullable RequestedDisplayMode requestedDisplayMode, @Nullable ByteBuffer byteBuffer) {
        this.viewId = i5;
        this.viewType = str;
        this.logicalTop = d;
        this.logicalLeft = d6;
        this.logicalWidth = d7;
        this.logicalHeight = d8;
        this.direction = i6;
        this.displayMode = requestedDisplayMode;
        this.params = byteBuffer;
    }
}
