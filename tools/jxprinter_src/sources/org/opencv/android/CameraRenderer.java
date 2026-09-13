package org.opencv.android;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
@TargetApi(15)
public class CameraRenderer extends CameraGLRendererBase {
    public static final String LOGTAG = "CameraRenderer";
    private Camera mCamera;
    private boolean mPreviewStarted;

    public CameraRenderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.mPreviewStarted = false;
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public synchronized void closeCamera() {
        Log.i(LOGTAG, "closeCamera");
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            this.mPreviewStarted = false;
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0133 A[Catch: all -> 0x0020, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0012, B:7:0x0019, B:13:0x0039, B:16:0x003e, B:18:0x0044, B:19:0x005f, B:25:0x008e, B:22:0x0068, B:52:0x012f, B:54:0x0133, B:57:0x013c, B:59:0x0146, B:61:0x014e, B:62:0x0153, B:63:0x0158, B:66:0x0161, B:12:0x0024, B:26:0x0091, B:28:0x0099, B:29:0x00a5, B:31:0x00ab, B:34:0x00b3, B:44:0x00d8, B:46:0x00e2, B:47:0x00ea, B:48:0x0105, B:51:0x010d, B:36:0x00b8, B:37:0x00c4, B:39:0x00ca, B:42:0x00d3), top: B:71:0x0003, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x013c A[Catch: all -> 0x0020, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0012, B:7:0x0019, B:13:0x0039, B:16:0x003e, B:18:0x0044, B:19:0x005f, B:25:0x008e, B:22:0x0068, B:52:0x012f, B:54:0x0133, B:57:0x013c, B:59:0x0146, B:61:0x014e, B:62:0x0153, B:63:0x0158, B:66:0x0161, B:12:0x0024, B:26:0x0091, B:28:0x0099, B:29:0x00a5, B:31:0x00ab, B:34:0x00b3, B:44:0x00d8, B:46:0x00e2, B:47:0x00ea, B:48:0x0105, B:51:0x010d, B:36:0x00b8, B:37:0x00c4, B:39:0x00ca, B:42:0x00d3), top: B:71:0x0003, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0146 A[Catch: all -> 0x0020, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0012, B:7:0x0019, B:13:0x0039, B:16:0x003e, B:18:0x0044, B:19:0x005f, B:25:0x008e, B:22:0x0068, B:52:0x012f, B:54:0x0133, B:57:0x013c, B:59:0x0146, B:61:0x014e, B:62:0x0153, B:63:0x0158, B:66:0x0161, B:12:0x0024, B:26:0x0091, B:28:0x0099, B:29:0x00a5, B:31:0x00ab, B:34:0x00b3, B:44:0x00d8, B:46:0x00e2, B:47:0x00ea, B:48:0x0105, B:51:0x010d, B:36:0x00b8, B:37:0x00c4, B:39:0x00ca, B:42:0x00d3), top: B:71:0x0003, inners: #1, #2, #3, #4 }] */
    @Override // org.opencv.android.CameraGLRendererBase
    public synchronized void openCamera(int i5) {
        Camera camera;
        Camera.Parameters parameters;
        List<String> supportedFocusModes;
        Log.i(LOGTAG, "openCamera");
        closeCamera();
        int i6 = 0;
        if (i5 != -1) {
            int i7 = this.mCameraIndex;
            if (i7 == 99) {
                Log.i(LOGTAG, "Trying to open BACK camera");
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                while (i6 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i6, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        i7 = i6;
                        break;
                    }
                    i6++;
                }
            } else if (i7 == 98) {
                Log.i(LOGTAG, "Trying to open FRONT camera");
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                while (i6 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i6, cameraInfo2);
                    if (cameraInfo2.facing == 1) {
                        i7 = i6;
                        break;
                    }
                    i6++;
                }
            }
            if (i7 == 99) {
                Log.e(LOGTAG, "Back camera not found!");
            } else if (i7 == 98) {
                Log.e(LOGTAG, "Front camera not found!");
            } else {
                Log.d(LOGTAG, "Trying to open camera with new open(" + i7 + ")");
                try {
                    this.mCamera = Camera.open(i7);
                } catch (RuntimeException e) {
                    Log.e(LOGTAG, "Camera #" + i7 + "failed to open: " + e.getLocalizedMessage());
                }
            }
            camera = this.mCamera;
            if (camera == null) {
                Log.e(LOGTAG, "Error: can't open camera");
                return;
            }
            parameters = camera.getParameters();
            supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                parameters.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(parameters);
            this.mCamera.setPreviewTexture(this.mSTexture);
            return;
        }
        Log.d(LOGTAG, "Trying to open camera with old open()");
        try {
            this.mCamera = Camera.open();
        } catch (Exception e6) {
            Log.e(LOGTAG, "Camera is not available (in use or does not exist): " + e6.getLocalizedMessage());
        }
        if (this.mCamera != null) {
            camera = this.mCamera;
            if (camera == null) {
                Log.e(LOGTAG, "Error: can't open camera");
                return;
            }
            parameters = camera.getParameters();
            supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                parameters.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(parameters);
            this.mCamera.setPreviewTexture(this.mSTexture);
            return;
        }
        boolean z6 = false;
        while (i6 < Camera.getNumberOfCameras()) {
            Log.d(LOGTAG, "Trying to open camera with new open(" + i6 + ")");
            try {
                this.mCamera = Camera.open(i6);
                z6 = true;
            } catch (RuntimeException e7) {
                Log.e(LOGTAG, "Camera #" + i6 + "failed to open: " + e7.getLocalizedMessage());
            }
            if (z6) {
                break;
            } else {
                i6++;
            }
        }
        camera = this.mCamera;
        if (camera == null) {
            Log.e(LOGTAG, "Error: can't open camera");
            return;
        }
        parameters = camera.getParameters();
        supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        this.mCamera.setParameters(parameters);
        try {
            this.mCamera.setPreviewTexture(this.mSTexture);
        } catch (IOException e8) {
            Log.e(LOGTAG, "setPreviewTexture() failed: " + e8.getMessage());
        }
        return;
        throw th;
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public synchronized void setCameraPreviewSize(int i5, int i6) {
        Log.i(LOGTAG, "setCameraPreviewSize: " + i5 + "x" + i6);
        Camera camera = this.mCamera;
        if (camera == null) {
            Log.e(LOGTAG, "Camera isn't initialized!");
            return;
        }
        int i7 = this.mMaxCameraWidth;
        if (i7 > 0 && i7 < i5) {
            i5 = i7;
        }
        int i8 = this.mMaxCameraHeight;
        if (i8 > 0 && i8 < i6) {
            i6 = i8;
        }
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes.size() > 0) {
            float f6 = i5 / i6;
            int i9 = 0;
            int i10 = 0;
            for (Camera.Size size : supportedPreviewSizes) {
                int i11 = size.width;
                int i12 = size.height;
                Log.d(LOGTAG, "checking camera preview size: " + i11 + "x" + i12);
                if (i11 <= i5 && i12 <= i6 && i11 >= i9 && i12 >= i10 && Math.abs(f6 - (i11 / i12)) < 0.2d) {
                    i10 = i12;
                    i9 = i11;
                }
            }
            if (i9 <= 0 || i10 <= 0) {
                i9 = supportedPreviewSizes.get(0).width;
                i10 = supportedPreviewSizes.get(0).height;
                Log.e(LOGTAG, "Error: best size was not selected, using " + i9 + " x " + i10);
            } else {
                Log.i(LOGTAG, "Selected best size: " + i9 + " x " + i10);
            }
            if (this.mPreviewStarted) {
                this.mCamera.stopPreview();
                this.mPreviewStarted = false;
            }
            this.mCameraWidth = i9;
            this.mCameraHeight = i10;
            parameters.setPreviewSize(i9, i10);
        }
        parameters.set("orientation", "landscape");
        this.mCamera.setParameters(parameters);
        this.mCamera.startPreview();
        this.mPreviewStarted = true;
    }
}
