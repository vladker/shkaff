package io.flutter.plugins.camera;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class NoOpVoidResult implements Messages.VoidResult {
    @Override // io.flutter.plugins.camera.Messages.VoidResult
    public void success() {
    }

    @Override // io.flutter.plugins.camera.Messages.VoidResult
    public void error(@NonNull Throwable th) {
    }
}
