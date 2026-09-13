package io.flutter.plugins.camera.types;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CaptureTimeoutsWrapper {
    private Timeout preCaptureFocusing;
    private final long preCaptureFocusingTimeoutMs;
    private Timeout preCaptureMetering;
    private final long preCaptureMeteringTimeoutMs;

    public CaptureTimeoutsWrapper(long j6, long j7) {
        this.preCaptureFocusingTimeoutMs = j6;
        this.preCaptureMeteringTimeoutMs = j7;
        this.preCaptureFocusing = Timeout.create(j6);
        this.preCaptureMetering = Timeout.create(j7);
    }

    @NonNull
    public Timeout getPreCaptureFocusing() {
        return this.preCaptureFocusing;
    }

    @NonNull
    public Timeout getPreCaptureMetering() {
        return this.preCaptureMetering;
    }

    public void reset() {
        this.preCaptureFocusing = Timeout.create(this.preCaptureFocusingTimeoutMs);
        this.preCaptureMetering = Timeout.create(this.preCaptureMeteringTimeoutMs);
    }
}
