package org.opencv.android;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.google.mlkit.vision.common.InputImage;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {
    private static final int MAGIC_TEXTURE_ID = 10;
    private static final String TAG = "JavaCameraView";
    private byte[] mBuffer;
    protected Camera mCamera;
    protected JavaCameraFrame[] mCameraFrame;
    private boolean mCameraFrameReady;
    private int mChainIdx;
    private Mat[] mFrameChain;
    private int mPreviewFormat;
    private boolean mStopThread;
    private SurfaceTexture mSurfaceTexture;
    private Thread mThread;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class CameraWorker implements Runnable {
        private CameraWorker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z6;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.mCameraFrameReady && !JavaCameraView.this.mStopThread) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    z6 = false;
                    if (JavaCameraView.this.mCameraFrameReady) {
                        JavaCameraView javaCameraView = JavaCameraView.this;
                        javaCameraView.mChainIdx = 1 - javaCameraView.mChainIdx;
                        JavaCameraView.this.mCameraFrameReady = false;
                        z6 = true;
                    }
                }
                if (!JavaCameraView.this.mStopThread && z6 && !JavaCameraView.this.mFrameChain[1 - JavaCameraView.this.mChainIdx].empty()) {
                    JavaCameraView javaCameraView2 = JavaCameraView.this;
                    javaCameraView2.deliverAndDrawFrame(javaCameraView2.mCameraFrame[1 - javaCameraView2.mChainIdx]);
                }
            } while (!JavaCameraView.this.mStopThread);
            Log.d(JavaCameraView.TAG, "Finish processing thread");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class JavaCameraFrame implements CameraBridgeViewBase.CvCameraViewFrame {
        private int mHeight;
        private Mat mRgba = new Mat();
        private int mWidth;
        private Mat mYuvFrameData;

        public JavaCameraFrame(Mat mat, int i5, int i6) {
            this.mWidth = i5;
            this.mHeight = i6;
            this.mYuvFrameData = mat;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat gray() {
            return this.mYuvFrameData.submat(0, this.mHeight, 0, this.mWidth);
        }

        public void release() {
            this.mRgba.release();
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat rgba() {
            if (JavaCameraView.this.mPreviewFormat == 17) {
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 96, 4);
            } else {
                if (JavaCameraView.this.mPreviewFormat != 842094169) {
                    throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
                }
                Imgproc.cvtColor(this.mYuvFrameData, this.mRgba, 100, 4);
            }
            return this.mRgba;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class JavaCameraSizeAccessor implements CameraBridgeViewBase.ListItemAccessor {
        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getHeight(Object obj) {
            return ((Camera.Size) obj).height;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getWidth(Object obj) {
            return ((Camera.Size) obj).width;
        }
    }

    public JavaCameraView(Context context, int i5) {
        super(context, i5);
        this.mChainIdx = 0;
        this.mPreviewFormat = 17;
        this.mCameraFrameReady = false;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    public boolean connectCamera(int i5, int i6) {
        Log.d(TAG, "Connecting to camera");
        if (!initializeCamera(i5, i6)) {
            return false;
        }
        this.mCameraFrameReady = false;
        Log.d(TAG, "Starting processing thread");
        this.mStopThread = false;
        Thread thread = new Thread(new CameraWorker());
        this.mThread = thread;
        thread.start();
        return true;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    public void disconnectCamera() {
        Log.d(TAG, "Disconnecting from camera");
        try {
            try {
                this.mStopThread = true;
                Log.d(TAG, "Notify thread");
                synchronized (this) {
                    notify();
                }
                Log.d(TAG, "Waiting for thread");
                Thread thread = this.mThread;
                if (thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mThread = null;
            releaseCamera();
            this.mCameraFrameReady = false;
        } catch (Throwable th) {
            this.mThread = null;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x013e A[Catch: all -> 0x0022, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x0014, B:8:0x001b, B:14:0x003b, B:17:0x0041, B:19:0x0047, B:20:0x0066, B:26:0x0095, B:23:0x006f, B:53:0x013a, B:55:0x013e, B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9, B:103:0x02ed, B:102:0x02ea, B:13:0x0026, B:29:0x009e, B:30:0x00ab, B:32:0x00b1, B:35:0x00b9, B:45:0x00df, B:47:0x00e9, B:48:0x00f1, B:49:0x0110, B:52:0x0118, B:37:0x00be, B:38:0x00cb, B:40:0x00d1, B:43:0x00da), top: B:107:0x000b, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0151 A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0164 A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01b9 A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0204 A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x020d A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x023d A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0256 A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x025d A[Catch: all -> 0x0022, Exception -> 0x01a5, TryCatch #3 {Exception -> 0x01a5, blocks: (B:57:0x0140, B:59:0x0151, B:61:0x0164, B:63:0x016c, B:65:0x0176, B:67:0x017e, B:69:0x0186, B:71:0x0190, B:73:0x019a, B:78:0x01a8, B:81:0x01b3, B:83:0x01bf, B:85:0x0204, B:86:0x0207, B:88:0x020d, B:90:0x0215, B:91:0x021a, B:93:0x023d, B:95:0x0245, B:97:0x0259, B:99:0x025d, B:100:0x0264, B:96:0x0256, B:82:0x01b9), top: B:112:0x0140, outer: #0 }] */
    public boolean initializeCamera(int i5, int i6) {
        int i7;
        Camera camera;
        Camera.Parameters parameters;
        List<Camera.Size> supportedPreviewSizes;
        String str;
        List<String> supportedFocusModes;
        FpsMeter fpsMeter;
        Log.d(TAG, "Initialize java camera");
        synchronized (this) {
            this.mCamera = null;
            int i8 = this.mCameraIndex;
            boolean z6 = false;
            if (i8 != -1) {
                if (i8 == 99) {
                    Log.i(TAG, "Trying to open back camera");
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    i7 = 0;
                    while (i7 < Camera.getNumberOfCameras()) {
                        Camera.getCameraInfo(i7, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            i8 = i7;
                            break;
                        }
                        i7++;
                    }
                } else if (i8 == 98) {
                    Log.i(TAG, "Trying to open front camera");
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    i7 = 0;
                    while (i7 < Camera.getNumberOfCameras()) {
                        Camera.getCameraInfo(i7, cameraInfo2);
                        if (cameraInfo2.facing == 1) {
                            i8 = i7;
                            break;
                        }
                        i7++;
                    }
                }
                if (i8 == 99) {
                    Log.e(TAG, "Back camera not found!");
                } else if (i8 == 98) {
                    Log.e(TAG, "Front camera not found!");
                } else {
                    Log.d(TAG, "Trying to open camera with new open(" + Integer.valueOf(i8) + ")");
                    try {
                        this.mCamera = Camera.open(i8);
                    } catch (RuntimeException e) {
                        Log.e(TAG, "Camera #" + i8 + "failed to open: " + e.getLocalizedMessage());
                    }
                }
                camera = this.mCamera;
                if (camera == null) {
                    return false;
                }
                parameters = camera.getParameters();
                Log.d(TAG, "getSupportedPreviewSizes()");
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    Size sizeCalculateCameraFrameSize = calculateCameraFrameSize(supportedPreviewSizes, new JavaCameraSizeAccessor(), i5, i6);
                    str = Build.FINGERPRINT;
                    if (str.startsWith("generic")) {
                        parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                    } else {
                        parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                    }
                    this.mPreviewFormat = parameters.getPreviewFormat();
                    Log.d(TAG, "Set preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize.height));
                    parameters.setPreviewSize((int) sizeCalculateCameraFrameSize.width, (int) sizeCalculateCameraFrameSize.height);
                    if (!Build.MODEL.equals("GT-I9100")) {
                        parameters.setRecordingHint(true);
                    }
                    supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null) {
                        parameters.setFocusMode("continuous-video");
                    }
                    this.mCamera.setParameters(parameters);
                    Camera.Parameters parameters2 = this.mCamera.getParameters();
                    this.mFrameWidth = parameters2.getPreviewSize().width;
                    this.mFrameHeight = parameters2.getPreviewSize().height;
                    if (getLayoutParams().width == -1) {
                        this.mScale = 0.0f;
                    } else {
                        this.mScale = 0.0f;
                    }
                    fpsMeter = this.mFpsMeter;
                    if (fpsMeter != null) {
                        fpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
                    }
                    byte[] bArr = new byte[((this.mFrameWidth * this.mFrameHeight) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8];
                    this.mBuffer = bArr;
                    this.mCamera.addCallbackBuffer(bArr);
                    this.mCamera.setPreviewCallbackWithBuffer(this);
                    Mat[] matArr = new Mat[2];
                    this.mFrameChain = matArr;
                    int i9 = this.mFrameHeight;
                    int i10 = this.mFrameWidth;
                    int i11 = CvType.CV_8UC1;
                    matArr[0] = new Mat(i9 + (i9 / 2), i10, i11);
                    Mat[] matArr2 = this.mFrameChain;
                    int i12 = this.mFrameHeight;
                    matArr2[1] = new Mat(i12 + (i12 / 2), this.mFrameWidth, i11);
                    AllocateCache();
                    JavaCameraFrame[] javaCameraFrameArr = new JavaCameraFrame[2];
                    this.mCameraFrame = javaCameraFrameArr;
                    javaCameraFrameArr[0] = new JavaCameraFrame(this.mFrameChain[0], this.mFrameWidth, this.mFrameHeight);
                    this.mCameraFrame[1] = new JavaCameraFrame(this.mFrameChain[1], this.mFrameWidth, this.mFrameHeight);
                    SurfaceTexture surfaceTexture = new SurfaceTexture(10);
                    this.mSurfaceTexture = surfaceTexture;
                    this.mCamera.setPreviewTexture(surfaceTexture);
                    Log.d(TAG, "startPreview");
                    this.mCamera.startPreview();
                    z6 = true;
                }
                return z6;
            }
            Log.d(TAG, "Trying to open camera with old open()");
            try {
                this.mCamera = Camera.open();
            } catch (Exception e6) {
                Log.e(TAG, "Camera is not available (in use or does not exist): " + e6.getLocalizedMessage());
            }
            if (this.mCamera != null) {
                camera = this.mCamera;
                if (camera == null) {
                    return false;
                }
                parameters = camera.getParameters();
                Log.d(TAG, "getSupportedPreviewSizes()");
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    Size sizeCalculateCameraFrameSize2 = calculateCameraFrameSize(supportedPreviewSizes, new JavaCameraSizeAccessor(), i5, i6);
                    str = Build.FINGERPRINT;
                    if (str.startsWith("generic")) {
                        parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                    } else {
                        parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                    }
                    this.mPreviewFormat = parameters.getPreviewFormat();
                    Log.d(TAG, "Set preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize2.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize2.height));
                    parameters.setPreviewSize((int) sizeCalculateCameraFrameSize2.width, (int) sizeCalculateCameraFrameSize2.height);
                    if (!Build.MODEL.equals("GT-I9100")) {
                        parameters.setRecordingHint(true);
                    }
                    supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null) {
                        parameters.setFocusMode("continuous-video");
                    }
                    this.mCamera.setParameters(parameters);
                    Camera.Parameters parameters3 = this.mCamera.getParameters();
                    this.mFrameWidth = parameters3.getPreviewSize().width;
                    this.mFrameHeight = parameters3.getPreviewSize().height;
                    if (getLayoutParams().width == -1) {
                        this.mScale = 0.0f;
                    } else {
                        this.mScale = 0.0f;
                    }
                    fpsMeter = this.mFpsMeter;
                    if (fpsMeter != null) {
                        fpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
                    }
                    byte[] bArr2 = new byte[((this.mFrameWidth * this.mFrameHeight) * ImageFormat.getBitsPerPixel(parameters3.getPreviewFormat())) / 8];
                    this.mBuffer = bArr2;
                    this.mCamera.addCallbackBuffer(bArr2);
                    this.mCamera.setPreviewCallbackWithBuffer(this);
                    Mat[] matArr3 = new Mat[2];
                    this.mFrameChain = matArr3;
                    int i13 = this.mFrameHeight;
                    int i14 = this.mFrameWidth;
                    int i15 = CvType.CV_8UC1;
                    matArr3[0] = new Mat(i13 + (i13 / 2), i14, i15);
                    Mat[] matArr4 = this.mFrameChain;
                    int i16 = this.mFrameHeight;
                    matArr4[1] = new Mat(i16 + (i16 / 2), this.mFrameWidth, i15);
                    AllocateCache();
                    JavaCameraFrame[] javaCameraFrameArr2 = new JavaCameraFrame[2];
                    this.mCameraFrame = javaCameraFrameArr2;
                    javaCameraFrameArr2[0] = new JavaCameraFrame(this.mFrameChain[0], this.mFrameWidth, this.mFrameHeight);
                    this.mCameraFrame[1] = new JavaCameraFrame(this.mFrameChain[1], this.mFrameWidth, this.mFrameHeight);
                    SurfaceTexture surfaceTexture2 = new SurfaceTexture(10);
                    this.mSurfaceTexture = surfaceTexture2;
                    this.mCamera.setPreviewTexture(surfaceTexture2);
                    Log.d(TAG, "startPreview");
                    this.mCamera.startPreview();
                    z6 = true;
                }
                return z6;
            }
            boolean z7 = false;
            for (int i17 = 0; i17 < Camera.getNumberOfCameras(); i17++) {
                Log.d(TAG, "Trying to open camera with new open(" + Integer.valueOf(i17) + ")");
                try {
                    this.mCamera = Camera.open(i17);
                    z7 = true;
                } catch (RuntimeException e7) {
                    Log.e(TAG, "Camera #" + i17 + "failed to open: " + e7.getLocalizedMessage());
                }
                if (z7) {
                    break;
                }
            }
            camera = this.mCamera;
            if (camera == null) {
                return false;
            }
            try {
                parameters = camera.getParameters();
                Log.d(TAG, "getSupportedPreviewSizes()");
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    Size sizeCalculateCameraFrameSize3 = calculateCameraFrameSize(supportedPreviewSizes, new JavaCameraSizeAccessor(), i5, i6);
                    str = Build.FINGERPRINT;
                    if (str.startsWith("generic") || str.startsWith(EnvironmentCompat.MEDIA_UNKNOWN)) {
                        parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                    } else {
                        String str2 = Build.MODEL;
                        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))) {
                            parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                        } else if ("google_sdk".equals(Build.PRODUCT)) {
                            parameters.setPreviewFormat(InputImage.IMAGE_FORMAT_YV12);
                        } else {
                            parameters.setPreviewFormat(17);
                        }
                    }
                    this.mPreviewFormat = parameters.getPreviewFormat();
                    Log.d(TAG, "Set preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize3.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize3.height));
                    parameters.setPreviewSize((int) sizeCalculateCameraFrameSize3.width, (int) sizeCalculateCameraFrameSize3.height);
                    if (!Build.MODEL.equals("GT-I9100")) {
                        parameters.setRecordingHint(true);
                    }
                    supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    }
                    this.mCamera.setParameters(parameters);
                    Camera.Parameters parameters4 = this.mCamera.getParameters();
                    this.mFrameWidth = parameters4.getPreviewSize().width;
                    this.mFrameHeight = parameters4.getPreviewSize().height;
                    if (getLayoutParams().width == -1 || getLayoutParams().height != -1) {
                        this.mScale = 0.0f;
                    } else {
                        this.mScale = Math.min(i6 / this.mFrameHeight, i5 / this.mFrameWidth);
                    }
                    fpsMeter = this.mFpsMeter;
                    if (fpsMeter != null) {
                        fpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
                    }
                    byte[] bArr3 = new byte[((this.mFrameWidth * this.mFrameHeight) * ImageFormat.getBitsPerPixel(parameters4.getPreviewFormat())) / 8];
                    this.mBuffer = bArr3;
                    this.mCamera.addCallbackBuffer(bArr3);
                    this.mCamera.setPreviewCallbackWithBuffer(this);
                    Mat[] matArr5 = new Mat[2];
                    this.mFrameChain = matArr5;
                    int i18 = this.mFrameHeight;
                    int i19 = this.mFrameWidth;
                    int i110 = CvType.CV_8UC1;
                    matArr5[0] = new Mat(i18 + (i18 / 2), i19, i110);
                    Mat[] matArr6 = this.mFrameChain;
                    int i111 = this.mFrameHeight;
                    matArr6[1] = new Mat(i111 + (i111 / 2), this.mFrameWidth, i110);
                    AllocateCache();
                    JavaCameraFrame[] javaCameraFrameArr3 = new JavaCameraFrame[2];
                    this.mCameraFrame = javaCameraFrameArr3;
                    javaCameraFrameArr3[0] = new JavaCameraFrame(this.mFrameChain[0], this.mFrameWidth, this.mFrameHeight);
                    this.mCameraFrame[1] = new JavaCameraFrame(this.mFrameChain[1], this.mFrameWidth, this.mFrameHeight);
                    SurfaceTexture surfaceTexture3 = new SurfaceTexture(10);
                    this.mSurfaceTexture = surfaceTexture3;
                    this.mCamera.setPreviewTexture(surfaceTexture3);
                    Log.d(TAG, "startPreview");
                    this.mCamera.startPreview();
                    z6 = true;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            return z6;
            throw th;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.mFrameChain[this.mChainIdx].put(0, 0, bArr);
            this.mCameraFrameReady = true;
            notify();
        }
        Camera camera2 = this.mCamera;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.mBuffer);
        }
    }

    public void releaseCamera() {
        synchronized (this) {
            try {
                Camera camera = this.mCamera;
                if (camera != null) {
                    camera.stopPreview();
                    this.mCamera.setPreviewCallback(null);
                    this.mCamera.release();
                }
                this.mCamera = null;
                Mat[] matArr = this.mFrameChain;
                if (matArr != null) {
                    matArr[0].release();
                    this.mFrameChain[1].release();
                }
                JavaCameraFrame[] javaCameraFrameArr = this.mCameraFrame;
                if (javaCameraFrameArr != null) {
                    javaCameraFrameArr[0].release();
                    this.mCameraFrame[1].release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChainIdx = 0;
        this.mPreviewFormat = 17;
        this.mCameraFrameReady = false;
    }
}
