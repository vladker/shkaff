package io.flutter.plugins.camera;

import android.app.Activity;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import io.flutter.plugin.common.PluginRegistry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class CameraPermissions {
    private static final String AUDIO_ACCESS_DENIED = "AudioAccessDenied";
    private static final String AUDIO_ACCESS_DENIED_MESSAGE = "Audio access permission was denied.";
    private static final String CAMERA_ACCESS_DENIED = "CameraAccessDenied";
    private static final String CAMERA_ACCESS_DENIED_MESSAGE = "Camera access permission was denied.";
    private static final String CAMERA_PERMISSIONS_REQUEST_ONGOING = "CameraPermissionsRequestOngoing";
    private static final String CAMERA_PERMISSIONS_REQUEST_ONGOING_MESSAGE = "Another request is ongoing and multiple requests cannot be handled at once.";
    private static final int CAMERA_REQUEST_ID = 9796;

    @VisibleForTesting
    boolean ongoing = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @VisibleForTesting
    public static final class CameraRequestPermissionsListener implements PluginRegistry.RequestPermissionsResultListener {
        boolean alreadyCalled = false;
        final ResultCallback callback;

        @VisibleForTesting
        public CameraRequestPermissionsListener(ResultCallback resultCallback) {
            this.callback = resultCallback;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
        public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
            if (this.alreadyCalled || i5 != CameraPermissions.CAMERA_REQUEST_ID) {
                return false;
            }
            this.alreadyCalled = true;
            if (iArr.length == 0 || iArr[0] != 0) {
                this.callback.onResult(CameraPermissions.CAMERA_ACCESS_DENIED, CameraPermissions.CAMERA_ACCESS_DENIED_MESSAGE);
            } else if (iArr.length <= 1 || iArr[1] == 0) {
                this.callback.onResult(null, null);
            } else {
                this.callback.onResult(CameraPermissions.AUDIO_ACCESS_DENIED, CameraPermissions.AUDIO_ACCESS_DENIED_MESSAGE);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface PermissionsRegistry {
        void addListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ResultCallback {
        void onResult(String str, String str2);
    }

    private boolean hasAudioPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.RECORD_AUDIO") == 0;
    }

    private boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestPermissions$0(ResultCallback resultCallback, String str, String str2) {
        this.ongoing = false;
        resultCallback.onResult(str, str2);
    }

    public void requestPermissions(Activity activity, PermissionsRegistry permissionsRegistry, boolean z6, ResultCallback resultCallback) {
        if (this.ongoing) {
            resultCallback.onResult(CAMERA_PERMISSIONS_REQUEST_ONGOING, CAMERA_PERMISSIONS_REQUEST_ONGOING_MESSAGE);
            return;
        }
        if (hasCameraPermission(activity) && (!z6 || hasAudioPermission(activity))) {
            resultCallback.onResult(null, null);
            return;
        }
        permissionsRegistry.addListener(new CameraRequestPermissionsListener(new k(this, resultCallback, 4)));
        this.ongoing = true;
        ActivityCompat.requestPermissions(activity, z6 ? new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"} : new String[]{"android.permission.CAMERA"}, CAMERA_REQUEST_ID);
    }
}
