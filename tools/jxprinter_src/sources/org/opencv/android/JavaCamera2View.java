package org.opencv.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.collection.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
@TargetApi(21)
public class JavaCamera2View extends CameraBridgeViewBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LOGTAG = "JavaCamera2View";
    protected Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    protected CameraDevice mCameraDevice;
    protected String mCameraID;
    protected CameraCaptureSession mCaptureSession;
    protected ImageReader mImageReader;
    protected int mPreviewFormat;
    protected CaptureRequest.Builder mPreviewRequestBuilder;
    protected Size mPreviewSize;
    private final CameraDevice.StateCallback mStateCallback;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class JavaCamera2Frame implements CameraBridgeViewBase.CvCameraViewFrame {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Image mImage;
        private Mat mRgba = new Mat();
        private Mat mGray = new Mat();

        public JavaCamera2Frame(Image image) {
            this.mImage = image;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat gray() {
            Image.Plane[] planes = this.mImage.getPlanes();
            Mat mat = new Mat(this.mImage.getHeight(), this.mImage.getWidth(), CvType.CV_8UC1, planes[0].getBuffer(), planes[0].getRowStride());
            this.mGray = mat;
            return mat;
        }

        public void release() {
            this.mRgba.release();
            this.mGray.release();
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame
        public Mat rgba() {
            int i5;
            Image.Plane[] planes = this.mImage.getPlanes();
            int width = this.mImage.getWidth();
            int height = this.mImage.getHeight();
            if (planes[1].getPixelStride() == 2) {
                ByteBuffer buffer = planes[0].getBuffer();
                int rowStride = planes[0].getRowStride();
                ByteBuffer buffer2 = planes[1].getBuffer();
                int rowStride2 = planes[1].getRowStride();
                ByteBuffer buffer3 = planes[2].getBuffer();
                int rowStride3 = planes[2].getRowStride();
                Mat mat = new Mat(height, width, CvType.CV_8UC1, buffer, rowStride);
                int i6 = height / 2;
                int i7 = width / 2;
                int i8 = CvType.CV_8UC2;
                Mat mat2 = new Mat(i6, i7, i8, buffer2, rowStride2);
                Mat mat3 = new Mat(i6, i7, i8, buffer3, rowStride3);
                if (mat3.dataAddr() - mat2.dataAddr() > 0) {
                    Imgproc.cvtColorTwoPlane(mat, mat2, this.mRgba, 94);
                } else {
                    Imgproc.cvtColorTwoPlane(mat, mat3, this.mRgba, 96);
                }
                return this.mRgba;
            }
            int i9 = height / 2;
            int i10 = height + i9;
            byte[] bArr = new byte[width * i10];
            ByteBuffer buffer4 = planes[0].getBuffer();
            ByteBuffer buffer5 = planes[1].getBuffer();
            ByteBuffer buffer6 = planes[2].getBuffer();
            int rowStride4 = planes[0].getRowStride();
            if (rowStride4 == width) {
                i5 = width * height;
                buffer4.get(bArr, 0, i5);
            } else {
                int i11 = rowStride4 - width;
                int i12 = 0;
                for (int i13 = 0; i13 < height; i13++) {
                    buffer4.get(bArr, i12, width);
                    i12 += width;
                    if (i13 < height - 1) {
                        buffer4.position(buffer4.position() + i11);
                    }
                }
                i5 = i12;
            }
            int i14 = width / 2;
            int rowStride5 = planes[1].getRowStride() - i14;
            if (rowStride5 == 0) {
                int i15 = (width * height) / 4;
                buffer5.get(bArr, i5, i15);
                buffer6.get(bArr, i5 + i15, i15);
            } else {
                for (int i16 = 0; i16 < i9; i16++) {
                    buffer5.get(bArr, i5, i14);
                    i5 += i14;
                    if (i16 < i9 - 1) {
                        buffer5.position(buffer5.position() + rowStride5);
                    }
                }
                for (int i17 = 0; i17 < i9; i17++) {
                    buffer6.get(bArr, i5, i14);
                    i5 += i14;
                    if (i17 < i9 - 1) {
                        buffer6.position(buffer6.position() + rowStride5);
                    }
                }
            }
            Mat mat4 = new Mat(i10, width, CvType.CV_8UC1);
            mat4.put(0, 0, bArr);
            Imgproc.cvtColor(mat4, this.mRgba, 104, 4);
            return this.mRgba;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class JavaCameraSizeAccessor implements CameraBridgeViewBase.ListItemAccessor {
        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getHeight(Object obj) {
            return ((Size) obj).getHeight();
        }

        @Override // org.opencv.android.CameraBridgeViewBase.ListItemAccessor
        public int getWidth(Object obj) {
            return ((Size) obj).getWidth();
        }
    }

    public JavaCamera2View(Context context, int i5) {
        super(context, i5);
        this.mPreviewFormat = 35;
        this.mPreviewSize = new Size(-1, -1);
        this.mStateCallback = new CameraDevice.StateCallback() { // from class: org.opencv.android.JavaCamera2View.1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                cameraDevice.close();
                JavaCamera2View.this.mCameraDevice = null;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i6) {
                cameraDevice.close();
                JavaCamera2View.this.mCameraDevice = null;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                JavaCamera2View javaCamera2View = JavaCamera2View.this;
                javaCamera2View.mCameraDevice = cameraDevice;
                javaCamera2View.createCameraPreviewSession();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCameraPreviewSession() {
        int width = this.mPreviewSize.getWidth();
        int height = this.mPreviewSize.getHeight();
        Log.i(LOGTAG, a.m("createCameraPreviewSession(", width, height, "x", ")"));
        if (width < 0 || height < 0) {
            return;
        }
        try {
            if (this.mCameraDevice == null) {
                Log.e(LOGTAG, "createCameraPreviewSession: camera isn't opened");
                return;
            }
            if (this.mCaptureSession != null) {
                Log.e(LOGTAG, "createCameraPreviewSession: mCaptureSession is already started");
                return;
            }
            ImageReader imageReaderNewInstance = ImageReader.newInstance(width, height, this.mPreviewFormat, 2);
            this.mImageReader = imageReaderNewInstance;
            imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: org.opencv.android.JavaCamera2View.2
                static final /* synthetic */ boolean $assertionsDisabled = false;

                @Override // android.media.ImageReader.OnImageAvailableListener
                public void onImageAvailable(ImageReader imageReader) {
                    Image imageAcquireLatestImage = imageReader.acquireLatestImage();
                    if (imageAcquireLatestImage == null) {
                        return;
                    }
                    imageAcquireLatestImage.getPlanes();
                    JavaCamera2Frame javaCamera2Frame = JavaCamera2View.this.new JavaCamera2Frame(imageAcquireLatestImage);
                    JavaCamera2View.this.deliverAndDrawFrame(javaCamera2Frame);
                    javaCamera2Frame.release();
                    imageAcquireLatestImage.close();
                }
            }, this.mBackgroundHandler);
            Surface surface = this.mImageReader.getSurface();
            CaptureRequest.Builder builderCreateCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewRequestBuilder = builderCreateCaptureRequest;
            builderCreateCaptureRequest.addTarget(surface);
            this.mCameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() { // from class: org.opencv.android.JavaCamera2View.3
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Log.e(JavaCamera2View.LOGTAG, "createCameraPreviewSession failed");
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    Log.i(JavaCamera2View.LOGTAG, "createCaptureSession::onConfigured");
                    JavaCamera2View javaCamera2View = JavaCamera2View.this;
                    if (javaCamera2View.mCameraDevice == null) {
                        return;
                    }
                    javaCamera2View.mCaptureSession = cameraCaptureSession;
                    try {
                        javaCamera2View.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                        JavaCamera2View.this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 2);
                        JavaCamera2View javaCamera2View2 = JavaCamera2View.this;
                        javaCamera2View2.mCaptureSession.setRepeatingRequest(javaCamera2View2.mPreviewRequestBuilder.build(), null, JavaCamera2View.this.mBackgroundHandler);
                        Log.i(JavaCamera2View.LOGTAG, "CameraPreviewSession has been started");
                    } catch (Exception e) {
                        Log.e(JavaCamera2View.LOGTAG, "createCaptureSession failed", e);
                    }
                }
            }, null);
        } catch (CameraAccessException e) {
            Log.e(LOGTAG, "createCameraPreviewSession", e);
        }
    }

    private void startBackgroundThread() {
        Log.i(LOGTAG, "startBackgroundThread");
        stopBackgroundThread();
        HandlerThread handlerThread = new HandlerThread("OpenCVCameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        Log.i(LOGTAG, "stopBackgroundThread");
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        try {
            this.mBackgroundThread.join();
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (InterruptedException e) {
            Log.e(LOGTAG, "stopBackgroundThread", e);
        }
    }

    public boolean calcPreviewSize(int i5, int i6) {
        Log.i(LOGTAG, "calcPreviewSize: " + i5 + "x" + i6);
        if (this.mCameraID == null) {
            Log.e(LOGTAG, "Camera isn't initialized!");
            return false;
        }
        try {
            org.opencv.core.Size sizeCalculateCameraFrameSize = calculateCameraFrameSize(Arrays.asList(((StreamConfigurationMap) ((CameraManager) getContext().getSystemService("camera")).getCameraCharacteristics(this.mCameraID).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(ImageReader.class)), new JavaCameraSizeAccessor(), i5, i6);
            Log.i(LOGTAG, "Selected preview size to " + Integer.valueOf((int) sizeCalculateCameraFrameSize.width) + "x" + Integer.valueOf((int) sizeCalculateCameraFrameSize.height));
            if (this.mPreviewSize.getWidth() == sizeCalculateCameraFrameSize.width && this.mPreviewSize.getHeight() == sizeCalculateCameraFrameSize.height) {
                return false;
            }
            this.mPreviewSize = new Size((int) sizeCalculateCameraFrameSize.width, (int) sizeCalculateCameraFrameSize.height);
            return true;
        } catch (CameraAccessException e) {
            Log.e(LOGTAG, "calcPreviewSize - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e6) {
            Log.e(LOGTAG, "calcPreviewSize - Illegal Argument Exception", e6);
            return false;
        } catch (SecurityException e7) {
            Log.e(LOGTAG, "calcPreviewSize - Security Exception", e7);
            return false;
        }
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    public boolean connectCamera(int i5, int i6) {
        Log.i(LOGTAG, a.m("setCameraPreviewSize(", i5, i6, "x", ")"));
        startBackgroundThread();
        initializeCamera();
        try {
            boolean zCalcPreviewSize = calcPreviewSize(i5, i6);
            this.mFrameWidth = this.mPreviewSize.getWidth();
            this.mFrameHeight = this.mPreviewSize.getHeight();
            if (getLayoutParams().width == -1 && getLayoutParams().height == -1) {
                this.mScale = Math.min(i6 / this.mFrameHeight, i5 / this.mFrameWidth);
            } else {
                this.mScale = 0.0f;
            }
            AllocateCache();
            if (!zCalcPreviewSize) {
                return true;
            }
            if (this.mCaptureSession != null) {
                Log.d(LOGTAG, "closing existing previewSession");
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            createCameraPreviewSession();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    public void disconnectCamera() {
        Log.i(LOGTAG, "close camera");
        try {
            CameraDevice cameraDevice = this.mCameraDevice;
            this.mCameraDevice = null;
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.mCaptureSession = null;
            }
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            stopBackgroundThread();
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.close();
                this.mImageReader = null;
            }
            Log.i(LOGTAG, "camera closed!");
        } catch (Throwable th) {
            stopBackgroundThread();
            ImageReader imageReader2 = this.mImageReader;
            if (imageReader2 != null) {
                imageReader2.close();
                this.mImageReader = null;
            }
            throw th;
        }
    }

    public boolean initializeCamera() {
        Log.i(LOGTAG, "initializeCamera");
        CameraManager cameraManager = (CameraManager) getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e(LOGTAG, "Error: camera isn't detected.");
                return false;
            }
            if (this.mCameraIndex != -1) {
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if ((this.mCameraIndex == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (this.mCameraIndex == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                        this.mCameraID = str;
                        break;
                    }
                }
            } else {
                this.mCameraID = cameraIdList[0];
            }
            if (this.mCameraID != null) {
                Log.i(LOGTAG, "Opening camera: " + this.mCameraID);
                cameraManager.openCamera(this.mCameraID, this.mStateCallback, this.mBackgroundHandler);
            } else {
                Log.i(LOGTAG, "Trying to open camera with the value (" + this.mCameraIndex + ")");
                int i5 = this.mCameraIndex;
                if (i5 >= cameraIdList.length) {
                    throw new CameraAccessException(2);
                }
                String str2 = cameraIdList[i5];
                this.mCameraID = str2;
                cameraManager.openCamera(str2, this.mStateCallback, this.mBackgroundHandler);
            }
            return true;
        } catch (CameraAccessException e) {
            Log.e(LOGTAG, "OpenCamera - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e6) {
            Log.e(LOGTAG, "OpenCamera - Illegal Argument Exception", e6);
            return false;
        } catch (SecurityException e7) {
            Log.e(LOGTAG, "OpenCamera - Security Exception", e7);
            return false;
        }
    }

    public JavaCamera2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPreviewFormat = 35;
        this.mPreviewSize = new Size(-1, -1);
        this.mStateCallback = new CameraDevice.StateCallback() { // from class: org.opencv.android.JavaCamera2View.1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                cameraDevice.close();
                JavaCamera2View.this.mCameraDevice = null;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i6) {
                cameraDevice.close();
                JavaCamera2View.this.mCameraDevice = null;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                JavaCamera2View javaCamera2View = JavaCamera2View.this;
                javaCamera2View.mCameraDevice = cameraDevice;
                javaCamera2View.createCameraPreviewSession();
            }
        };
    }
}
