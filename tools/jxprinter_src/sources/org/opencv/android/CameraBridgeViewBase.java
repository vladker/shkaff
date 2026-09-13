package org.opencv.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.exifinterface.media.a;
import androidx.webkit.ProxyConfig;
import java.util.List;
import org.opencv.R;
import org.opencv.core.Mat;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class CameraBridgeViewBase extends SurfaceView implements SurfaceHolder.Callback {
    public static final int CAMERA_ID_ANY = -1;
    public static final int CAMERA_ID_BACK = 99;
    public static final int CAMERA_ID_FRONT = 98;
    public static final int GRAY = 2;
    protected static final int MAX_UNSPECIFIED = -1;
    public static final int RGBA = 1;
    private static final int STARTED = 1;
    private static final int STOPPED = 0;
    private static final String TAG = "CameraBridge";
    private Bitmap mCacheBitmap;
    protected int mCameraIndex;
    protected boolean mCameraPermissionGranted;
    protected boolean mEnabled;
    protected FpsMeter mFpsMeter;
    protected int mFrameHeight;
    protected int mFrameWidth;
    private CvCameraViewListener2 mListener;
    protected int mMaxHeight;
    protected int mMaxWidth;
    protected int mPreviewFormat;
    protected float mScale;
    private int mState;
    private boolean mSurfaceExist;
    private final Object mSyncObject;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CvCameraViewFrame {
        Mat gray();

        Mat rgba();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CvCameraViewListener {
        Mat onCameraFrame(Mat mat);

        void onCameraViewStarted(int i5, int i6);

        void onCameraViewStopped();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CvCameraViewListener2 {
        Mat onCameraFrame(CvCameraViewFrame cvCameraViewFrame);

        void onCameraViewStarted(int i5, int i6);

        void onCameraViewStopped();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class CvCameraViewListenerAdapter implements CvCameraViewListener2 {
        private CvCameraViewListener mOldStyleListener;
        private int mPreviewFormat = 1;

        public CvCameraViewListenerAdapter(CvCameraViewListener cvCameraViewListener) {
            this.mOldStyleListener = cvCameraViewListener;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
        public Mat onCameraFrame(CvCameraViewFrame cvCameraViewFrame) {
            int i5 = this.mPreviewFormat;
            if (i5 == 1) {
                return this.mOldStyleListener.onCameraFrame(cvCameraViewFrame.rgba());
            }
            if (i5 == 2) {
                return this.mOldStyleListener.onCameraFrame(cvCameraViewFrame.gray());
            }
            Log.e(CameraBridgeViewBase.TAG, "Invalid frame format! Only RGBA and Gray Scale are supported!");
            return null;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
        public void onCameraViewStarted(int i5, int i6) {
            this.mOldStyleListener.onCameraViewStarted(i5, i6);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2
        public void onCameraViewStopped() {
            this.mOldStyleListener.onCameraViewStopped();
        }

        public void setFrameFormat(int i5) {
            this.mPreviewFormat = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ListItemAccessor {
        int getHeight(Object obj);

        int getWidth(Object obj);
    }

    public CameraBridgeViewBase(Context context, int i5) {
        super(context);
        this.mState = 0;
        this.mSyncObject = new Object();
        this.mScale = 0.0f;
        this.mPreviewFormat = 1;
        this.mCameraPermissionGranted = false;
        this.mFpsMeter = null;
        this.mCameraIndex = i5;
        getHolder().addCallback(this);
        this.mMaxWidth = -1;
        this.mMaxHeight = -1;
    }

    private void checkCurrentState() {
        Log.d(TAG, "call checkCurrentState");
        int i5 = (this.mEnabled && this.mCameraPermissionGranted && this.mSurfaceExist && getVisibility() == 0) ? 1 : 0;
        int i6 = this.mState;
        if (i5 != i6) {
            processExitState(i6);
            this.mState = i5;
            processEnterState(i5);
        }
    }

    private void onEnterStartedState() {
        Log.d(TAG, "call onEnterStartedState");
        if (connectCamera(getWidth(), getHeight())) {
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(getContext()).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setMessage("It seems that your device does not support camera (or it is locked). Application will be closed.");
        alertDialogCreate.setButton(-3, "OK", new DialogInterface.OnClickListener() { // from class: org.opencv.android.CameraBridgeViewBase.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.dismiss();
                ((Activity) CameraBridgeViewBase.this.getContext()).finish();
            }
        });
        alertDialogCreate.show();
    }

    private void onExitStartedState() {
        disconnectCamera();
        Bitmap bitmap = this.mCacheBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    private void processEnterState(int i5) {
        a.v(i5, "call processEnterState: ", TAG);
        if (i5 == 0) {
            onEnterStoppedState();
            CvCameraViewListener2 cvCameraViewListener2 = this.mListener;
            if (cvCameraViewListener2 != null) {
                cvCameraViewListener2.onCameraViewStopped();
                return;
            }
            return;
        }
        if (i5 != 1) {
            return;
        }
        onEnterStartedState();
        CvCameraViewListener2 cvCameraViewListener3 = this.mListener;
        if (cvCameraViewListener3 != null) {
            cvCameraViewListener3.onCameraViewStarted(this.mFrameWidth, this.mFrameHeight);
        }
    }

    private void processExitState(int i5) {
        a.v(i5, "call processExitState: ", TAG);
        if (i5 == 0) {
            onExitStoppedState();
        } else {
            if (i5 != 1) {
                return;
            }
            onExitStartedState();
        }
    }

    public void AllocateCache() {
        this.mCacheBitmap = Bitmap.createBitmap(this.mFrameWidth, this.mFrameHeight, Bitmap.Config.ARGB_8888);
    }

    public void SetCaptureFormat(int i5) {
        this.mPreviewFormat = i5;
        CvCameraViewListener2 cvCameraViewListener2 = this.mListener;
        if (cvCameraViewListener2 instanceof CvCameraViewListenerAdapter) {
            ((CvCameraViewListenerAdapter) cvCameraViewListener2).setFrameFormat(i5);
        }
    }

    public Size calculateCameraFrameSize(List<?> list, ListItemAccessor listItemAccessor, int i5, int i6) {
        int i7 = this.mMaxWidth;
        if (i7 != -1 && i7 < i5) {
            i5 = i7;
        }
        int i8 = this.mMaxHeight;
        if (i8 != -1 && i8 < i6) {
            i6 = i8;
        }
        int width = 0;
        int height = 0;
        for (Object obj : list) {
            int width2 = listItemAccessor.getWidth(obj);
            int height2 = listItemAccessor.getHeight(obj);
            Log.d(TAG, "trying size: " + width2 + "x" + height2);
            if (width2 <= i5 && height2 <= i6 && width2 >= width && height2 >= height) {
                height = height2;
                width = width2;
            }
        }
        if ((width == 0 || height == 0) && list.size() > 0) {
            Log.i(TAG, "fallback to the first frame size");
            Object obj2 = list.get(0);
            width = listItemAccessor.getWidth(obj2);
            height = listItemAccessor.getHeight(obj2);
        }
        return new Size(width, height);
    }

    public abstract boolean connectCamera(int i5, int i6);

    public void deliverAndDrawFrame(CvCameraViewFrame cvCameraViewFrame) {
        Canvas canvasLockCanvas;
        CvCameraViewListener2 cvCameraViewListener2 = this.mListener;
        Mat matOnCameraFrame = cvCameraViewListener2 != null ? cvCameraViewListener2.onCameraFrame(cvCameraViewFrame) : cvCameraViewFrame.rgba();
        if (matOnCameraFrame != null) {
            try {
                Utils.matToBitmap(matOnCameraFrame, this.mCacheBitmap);
            } catch (Exception e) {
                Log.e(TAG, "Mat type: " + matOnCameraFrame);
                Log.e(TAG, "Bitmap type: " + this.mCacheBitmap.getWidth() + ProxyConfig.MATCH_ALL_SCHEMES + this.mCacheBitmap.getHeight());
                StringBuilder sb = new StringBuilder("Utils.matToBitmap() throws an exception: ");
                sb.append(e.getMessage());
                Log.e(TAG, sb.toString());
                return;
            }
        }
        if (this.mCacheBitmap == null || (canvasLockCanvas = getHolder().lockCanvas()) == null) {
            return;
        }
        canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.mScale != 0.0f) {
            canvasLockCanvas.drawBitmap(this.mCacheBitmap, new Rect(0, 0, this.mCacheBitmap.getWidth(), this.mCacheBitmap.getHeight()), new Rect((int) androidx.collection.a.b(this.mScale, this.mCacheBitmap.getWidth(), canvasLockCanvas.getWidth(), 2.0f), (int) androidx.collection.a.b(this.mScale, this.mCacheBitmap.getHeight(), canvasLockCanvas.getHeight(), 2.0f), (int) ((this.mScale * this.mCacheBitmap.getWidth()) + androidx.collection.a.b(this.mScale, this.mCacheBitmap.getWidth(), canvasLockCanvas.getWidth(), 2.0f)), (int) ((this.mScale * this.mCacheBitmap.getHeight()) + androidx.collection.a.b(this.mScale, this.mCacheBitmap.getHeight(), canvasLockCanvas.getHeight(), 2.0f))), (Paint) null);
        } else {
            canvasLockCanvas.drawBitmap(this.mCacheBitmap, new Rect(0, 0, this.mCacheBitmap.getWidth(), this.mCacheBitmap.getHeight()), new Rect((canvasLockCanvas.getWidth() - this.mCacheBitmap.getWidth()) / 2, (canvasLockCanvas.getHeight() - this.mCacheBitmap.getHeight()) / 2, this.mCacheBitmap.getWidth() + ((canvasLockCanvas.getWidth() - this.mCacheBitmap.getWidth()) / 2), this.mCacheBitmap.getHeight() + ((canvasLockCanvas.getHeight() - this.mCacheBitmap.getHeight()) / 2)), (Paint) null);
        }
        FpsMeter fpsMeter = this.mFpsMeter;
        if (fpsMeter != null) {
            fpsMeter.measure();
            this.mFpsMeter.draw(canvasLockCanvas, 20.0f, 30.0f);
        }
        getHolder().unlockCanvasAndPost(canvasLockCanvas);
    }

    public void disableFpsMeter() {
        this.mFpsMeter = null;
    }

    public void disableView() {
        synchronized (this.mSyncObject) {
            this.mEnabled = false;
            checkCurrentState();
        }
    }

    public abstract void disconnectCamera();

    public void enableFpsMeter() {
        if (this.mFpsMeter == null) {
            FpsMeter fpsMeter = new FpsMeter();
            this.mFpsMeter = fpsMeter;
            fpsMeter.setResolution(this.mFrameWidth, this.mFrameHeight);
        }
    }

    public void enableView() {
        synchronized (this.mSyncObject) {
            this.mEnabled = true;
            checkCurrentState();
        }
    }

    public void setCameraIndex(int i5) {
        this.mCameraIndex = i5;
    }

    public void setCameraPermissionGranted() {
        synchronized (this.mSyncObject) {
            this.mCameraPermissionGranted = true;
            checkCurrentState();
        }
    }

    public void setCvCameraViewListener(CvCameraViewListener2 cvCameraViewListener2) {
        this.mListener = cvCameraViewListener2;
    }

    public void setMaxFrameSize(int i5, int i6) {
        this.mMaxWidth = i5;
        this.mMaxHeight = i6;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
        Log.d(TAG, "call surfaceChanged event");
        synchronized (this.mSyncObject) {
            try {
                if (this.mSurfaceExist) {
                    this.mSurfaceExist = false;
                    checkCurrentState();
                    this.mSurfaceExist = true;
                    checkCurrentState();
                } else {
                    this.mSurfaceExist = true;
                    checkCurrentState();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.mSyncObject) {
            this.mSurfaceExist = false;
            checkCurrentState();
        }
    }

    public void setCvCameraViewListener(CvCameraViewListener cvCameraViewListener) {
        CvCameraViewListenerAdapter cvCameraViewListenerAdapter = new CvCameraViewListenerAdapter(cvCameraViewListener);
        cvCameraViewListenerAdapter.setFrameFormat(this.mPreviewFormat);
        this.mListener = cvCameraViewListenerAdapter;
    }

    public CameraBridgeViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.mSyncObject = new Object();
        this.mScale = 0.0f;
        this.mPreviewFormat = 1;
        this.mCameraIndex = -1;
        this.mCameraPermissionGranted = false;
        this.mFpsMeter = null;
        Log.d(TAG, "Attr count: " + Integer.valueOf(attributeSet.getAttributeCount()));
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraBridgeViewBase);
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.CameraBridgeViewBase_show_fps, false)) {
            enableFpsMeter();
        }
        this.mCameraIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        getHolder().addCallback(this);
        this.mMaxWidth = -1;
        this.mMaxHeight = -1;
        typedArrayObtainStyledAttributes.recycle();
    }

    private void onEnterStoppedState() {
    }

    private void onExitStoppedState() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }
}
