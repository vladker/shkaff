package io.flutter.plugins.camera.types;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Timeout {
    private final long timeStarted = SystemClock.elapsedRealtime();
    private final long timeoutMs;

    private Timeout(long j6) {
        this.timeoutMs = j6;
    }

    @NonNull
    public static Timeout create(long j6) {
        return new Timeout(j6);
    }

    public boolean getIsExpired() {
        return SystemClock.elapsedRealtime() - this.timeStarted > this.timeoutMs;
    }
}
