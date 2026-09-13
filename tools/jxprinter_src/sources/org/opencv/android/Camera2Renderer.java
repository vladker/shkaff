package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.collection.a;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
@TargetApi(21)
public class Camera2Renderer extends CameraGLRendererBase {
    protected final String LOGTAG;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private CameraDevice mCameraDevice;
    private String mCameraID;
    private Semaphore mCameraOpenCloseLock;
    private CameraCaptureSession mCaptureSession;
    private CaptureRequest.Builder mPreviewRequestBuilder;
    private Size mPreviewSize;
    private final CameraDevice.StateCallback mStateCallback;

    public Camera2Renderer(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.LOGTAG = "Camera2Renderer";
        this.mPreviewSize = new Size(-1, -1);
        this.mCameraOpenCloseLock = new Semaphore(1);
        this.mStateCallback = new CameraDevice.StateCallback() { // from class: org.opencv.android.Camera2Renderer.1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                cameraDevice.close();
                Camera2Renderer.this.mCameraDevice = null;
                Camera2Renderer.this.mCameraOpenCloseLock.release();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i5) {
                cameraDevice.close();
                Camera2Renderer.this.mCameraDevice = null;
                Camera2Renderer.this.mCameraOpenCloseLock.release();
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                Camera2Renderer.this.mCameraDevice = cameraDevice;
                Camera2Renderer.this.mCameraOpenCloseLock.release();
                Camera2Renderer.this.createCameraPreviewSession();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCameraPreviewSession() {
        int width = this.mPreviewSize.getWidth();
        int height = this.mPreviewSize.getHeight();
        Log.i("Camera2Renderer", a.m("createCameraPreviewSession(", width, height, "x", ")"));
        if (width < 0 || height < 0) {
            return;
        }
        try {
            this.mCameraOpenCloseLock.acquire();
            if (this.mCameraDevice == null) {
                this.mCameraOpenCloseLock.release();
                Log.e("Camera2Renderer", "createCameraPreviewSession: camera isn't opened");
                return;
            }
            if (this.mCaptureSession != null) {
                this.mCameraOpenCloseLock.release();
                Log.e("Camera2Renderer", "createCameraPreviewSession: mCaptureSession is already started");
                return;
            }
            SurfaceTexture surfaceTexture = this.mSTexture;
            if (surfaceTexture == null) {
                this.mCameraOpenCloseLock.release();
                Log.e("Camera2Renderer", "createCameraPreviewSession: preview SurfaceTexture is null");
                return;
            }
            surfaceTexture.setDefaultBufferSize(width, height);
            Surface surface = new Surface(this.mSTexture);
            CaptureRequest.Builder builderCreateCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewRequestBuilder = builderCreateCaptureRequest;
            builderCreateCaptureRequest.addTarget(surface);
            this.mCameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() { // from class: org.opencv.android.Camera2Renderer.2
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Log.e("Camera2Renderer", "createCameraPreviewSession failed");
                    Camera2Renderer.this.mCameraOpenCloseLock.release();
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    Camera2Renderer.this.mCaptureSession = cameraCaptureSession;
                    try {
                        Camera2Renderer.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                        Camera2Renderer.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                        Camera2Renderer.this.mCaptureSession.setRepeatingRequest(Camera2Renderer.this.mPreviewRequestBuilder.build(), null, Camera2Renderer.this.mBackgroundHandler);
                        Log.i("Camera2Renderer", "CameraPreviewSession has been started");
                    } catch (CameraAccessException unused) {
                        Log.e("Camera2Renderer", "createCaptureSession failed");
                    }
                    Camera2Renderer.this.mCameraOpenCloseLock.release();
                }
            }, this.mBackgroundHandler);
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "createCameraPreviewSession");
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while createCameraPreviewSession", e);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void startBackgroundThread() {
        Log.i("Camera2Renderer", "startBackgroundThread");
        stopBackgroundThread();
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        Log.i("Camera2Renderer", "stopBackgroundThread");
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        try {
            this.mBackgroundThread.join();
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (InterruptedException unused) {
            Log.e("Camera2Renderer", "stopBackgroundThread");
        }
    }

    public boolean cacPreviewSize(int i5, int i6) {
        Log.i("Camera2Renderer", "cacPreviewSize: " + i5 + "x" + i6);
        if (this.mCameraID == null) {
            Log.e("Camera2Renderer", "Camera isn't initialized!");
            return false;
        }
        try {
            float f6 = i5 / i6;
            int i7 = 0;
            int i8 = 0;
            for (Size size : ((StreamConfigurationMap) ((CameraManager) this.mView.getContext().getSystemService("camera")).getCameraCharacteristics(this.mCameraID).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                Log.d("Camera2Renderer", "trying size: " + width + "x" + height);
                if (i5 >= width && i6 >= height && i7 <= width && i8 <= height && Math.abs(f6 - (width / height)) < 0.2d) {
                    i8 = height;
                    i7 = width;
                }
            }
            Log.i("Camera2Renderer", "best size: " + i7 + "x" + i8);
            if (i7 != 0 && i8 != 0 && (this.mPreviewSize.getWidth() != i7 || this.mPreviewSize.getHeight() != i8)) {
                this.mPreviewSize = new Size(i7, i8);
                return true;
            }
            return false;
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "cacPreviewSize - Camera Access Exception");
            return false;
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "cacPreviewSize - Illegal Argument Exception");
            return false;
        } catch (SecurityException unused3) {
            Log.e("Camera2Renderer", "cacPreviewSize - Security Exception");
            return false;
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public void closeCamera() {
        Log.i("Camera2Renderer", "closeCamera");
        try {
            try {
                this.mCameraOpenCloseLock.acquire();
                CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.mCaptureSession = null;
                }
                CameraDevice cameraDevice = this.mCameraDevice;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.mCameraDevice = null;
                }
                this.mCameraOpenCloseLock.release();
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
            }
        } catch (Throwable th) {
            this.mCameraOpenCloseLock.release();
            throw th;
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public void doStart() {
        Log.d("Camera2Renderer", "doStart");
        startBackgroundThread();
        super.doStart();
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public void doStop() {
        Log.d("Camera2Renderer", "doStop");
        super.doStop();
        stopBackgroundThread();
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public void openCamera(int i5) {
        Log.i("Camera2Renderer", "openCamera");
        CameraManager cameraManager = (CameraManager) this.mView.getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("Camera2Renderer", "Error: camera isn't detected.");
                return;
            }
            if (i5 != -1) {
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if ((i5 == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (i5 == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                        this.mCameraID = str;
                        break;
                    }
                }
            } else {
                this.mCameraID = cameraIdList[0];
            }
            if (this.mCameraID != null) {
                if (!this.mCameraOpenCloseLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                    throw new RuntimeException("Time out waiting to lock camera opening.");
                }
                Log.i("Camera2Renderer", "Opening camera: " + this.mCameraID);
                cameraManager.openCamera(this.mCameraID, this.mStateCallback, this.mBackgroundHandler);
            }
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "OpenCamera - Camera Access Exception");
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "OpenCamera - Illegal Argument Exception");
        } catch (InterruptedException unused3) {
            Log.e("Camera2Renderer", "OpenCamera - Interrupted Exception");
        } catch (SecurityException unused4) {
            Log.e("Camera2Renderer", "OpenCamera - Security Exception");
        }
    }

    @Override // org.opencv.android.CameraGLRendererBase
    public void setCameraPreviewSize(int i5, int i6) {
        Log.i("Camera2Renderer", a.m("setCameraPreviewSize(", i5, i6, "x", ")"));
        int i7 = this.mMaxCameraWidth;
        if (i7 > 0 && i7 < i5) {
            i5 = i7;
        }
        int i8 = this.mMaxCameraHeight;
        if (i8 > 0 && i8 < i6) {
            i6 = i8;
        }
        try {
            this.mCameraOpenCloseLock.acquire();
            boolean zCacPreviewSize = cacPreviewSize(i5, i6);
            this.mCameraWidth = this.mPreviewSize.getWidth();
            this.mCameraHeight = this.mPreviewSize.getHeight();
            if (!zCacPreviewSize) {
                this.mCameraOpenCloseLock.release();
                return;
            }
            if (this.mCaptureSession != null) {
                Log.d("Camera2Renderer", "closing existing previewSession");
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            this.mCameraOpenCloseLock.release();
            createCameraPreviewSession();
        } catch (InterruptedException e) {
            this.mCameraOpenCloseLock.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }
}
