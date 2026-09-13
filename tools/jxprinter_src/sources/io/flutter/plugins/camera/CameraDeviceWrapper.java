package io.flutter.plugins.camera;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
interface CameraDeviceWrapper {
    void close();

    @NonNull
    CaptureRequest.Builder createCaptureRequest(int i5);

    @SuppressLint({"UseRequiresApi"})
    @TargetApi(28)
    void createCaptureSession(SessionConfiguration sessionConfiguration);

    void createCaptureSession(@NonNull List<Surface> list, @NonNull CameraCaptureSession.StateCallback stateCallback, @Nullable Handler handler);
}
