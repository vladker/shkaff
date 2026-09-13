package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import cn.bertsir.zbar.utils.QRUtils;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraManager {
    private static final String TAG = "CameraManager";
    private Context context;
    private Camera mCamera;
    private final CameraConfiguration mConfiguration;

    public CameraManager(Context context) {
        this.context = context;
        this.mConfiguration = new CameraConfiguration(context);
    }

    public void autoFocus(Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.autoFocus(autoFocusCallback);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void closeDriver() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public CameraConfiguration getConfiguration() {
        return this.mConfiguration;
    }

    public void handleZoom(boolean z6) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (!parameters.isZoomSupported()) {
                Log.i(TAG, "zoom not supported");
                return;
            }
            int maxZoom = parameters.getMaxZoom();
            int zoom = parameters.getZoom();
            if (z6 && zoom < maxZoom) {
                zoom++;
            } else if (zoom > 0) {
                zoom--;
            }
            parameters.setZoom(zoom);
            this.mCamera.setParameters(parameters);
        }
    }

    public boolean isOpen() {
        return this.mCamera != null;
    }

    public synchronized void openDriver() {
        if (this.mCamera != null) {
            return;
        }
        Camera cameraOpen = Camera.open();
        this.mCamera = cameraOpen;
        if (cameraOpen == null) {
            throw new IOException("The camera is occupied.");
        }
        this.mConfiguration.initFromCameraParameters(cameraOpen);
        Camera.Parameters parameters = this.mCamera.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.mConfiguration.setDesiredCameraParameters(this.mCamera, false);
        } catch (RuntimeException unused) {
            if (strFlatten != null) {
                Camera.Parameters parameters2 = this.mCamera.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    this.mCamera.setParameters(parameters2);
                    this.mConfiguration.setDesiredCameraParameters(this.mCamera, true);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setCameraZoom(float f6) {
        int maxZoom;
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported() && (maxZoom = parameters.getMaxZoom()) != 0) {
                parameters.setZoom((int) (maxZoom * f6));
                this.mCamera.setParameters(parameters);
            }
        }
    }

    public void setFlash() {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() == null) {
                return;
            }
            if (parameters.getFlashMode().endsWith("torch")) {
                parameters.setFlashMode("off");
            } else {
                parameters.setFlashMode("torch");
            }
            this.mCamera.setParameters(parameters);
        }
    }

    public void startPreview(SurfaceHolder surfaceHolder, Camera.PreviewCallback previewCallback) throws IOException {
        if (this.mCamera != null) {
            if (Build.MANUFACTURER.equals("LGE") && Build.MODEL.equals("Nexus 5X")) {
                this.mCamera.setDisplayOrientation(QRUtils.getInstance().isScreenOriatationPortrait(this.context) ? 270 : 180);
            } else {
                this.mCamera.setDisplayOrientation(QRUtils.getInstance().isScreenOriatationPortrait(this.context) ? 90 : 0);
            }
            this.mCamera.setPreviewDisplay(surfaceHolder);
            this.mCamera.setPreviewCallback(previewCallback);
            this.mCamera.startPreview();
        }
    }

    public void stopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Exception unused) {
            }
            try {
                this.mCamera.setPreviewDisplay(null);
            } catch (IOException unused2) {
            }
        }
    }

    public void setFlash(boolean z6) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() == null) {
                return;
            }
            if (z6) {
                if (parameters.getFlashMode().endsWith("off")) {
                    parameters.setFlashMode("torch");
                }
            } else if (parameters.getFlashMode().endsWith("torch")) {
                parameters.setFlashMode("off");
            }
            this.mCamera.setParameters(parameters);
        }
    }
}
