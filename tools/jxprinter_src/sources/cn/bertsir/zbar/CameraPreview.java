package cn.bertsir.zbar;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.Toast;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CameraPreview extends FrameLayout implements SurfaceHolder.Callback {
    private boolean isPreviewStart;
    private Runnable mAutoFocusTask;
    private CameraManager mCameraManager;
    private Camera.AutoFocusCallback mFocusCallback;
    private CameraScanAnalysis mPreviewCallback;
    private SurfaceView mSurfaceView;

    public CameraPreview(Context context) {
        this(context, null);
    }

    private void startCameraPreview(SurfaceHolder surfaceHolder) {
        try {
            this.mCameraManager.startPreview(surfaceHolder, this.mPreviewCallback);
            this.mCameraManager.autoFocus(this.mFocusCallback);
            this.isPreviewStart = true;
        } catch (Exception e) {
            e.printStackTrace();
            new Handler().postDelayed(new Runnable() { // from class: cn.bertsir.zbar.CameraPreview.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraPreview.this.mCameraManager.autoFocus(CameraPreview.this.mFocusCallback);
                }
            }, 200L);
        }
    }

    public void handleZoom(boolean z6) {
        this.mCameraManager.handleZoom(z6);
    }

    public boolean isPreviewStart() {
        return this.isPreviewStart;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        stop();
        super.onDetachedFromWindow();
    }

    public void setFlash() {
        this.mCameraManager.setFlash();
    }

    public void setScanCallback(ScanCallback scanCallback) {
        this.mPreviewCallback.setScanCallback(scanCallback);
    }

    public void setZoom(float f6) {
        this.mCameraManager.setCameraZoom(f6);
    }

    public boolean start() {
        try {
            this.mCameraManager.openDriver();
            this.mPreviewCallback.onStart();
            if (this.mSurfaceView == null) {
                SurfaceView surfaceView = new SurfaceView(getContext());
                this.mSurfaceView = surfaceView;
                addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
                SurfaceHolder holder = this.mSurfaceView.getHolder();
                holder.addCallback(this);
                holder.setType(3);
            }
            startCameraPreview(this.mSurfaceView.getHolder());
            return true;
        } catch (Exception unused) {
            Toast.makeText(getContext(), "摄像头权限被拒绝！", 0).show();
            return false;
        }
    }

    public void stop() {
        removeCallbacks(this.mAutoFocusTask);
        this.mPreviewCallback.onStop();
        this.mCameraManager.stopPreview();
        this.mCameraManager.closeDriver();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        this.mCameraManager.stopPreview();
        startCameraPreview(surfaceHolder);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setFlash(boolean z6) {
        this.mCameraManager.setFlash(z6);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.isPreviewStart = false;
        this.mFocusCallback = new Camera.AutoFocusCallback() { // from class: cn.bertsir.zbar.CameraPreview.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z6, Camera camera) {
                CameraPreview cameraPreview = CameraPreview.this;
                cameraPreview.postDelayed(cameraPreview.mAutoFocusTask, 500L);
            }
        };
        this.mAutoFocusTask = new Runnable() { // from class: cn.bertsir.zbar.CameraPreview.3
            @Override // java.lang.Runnable
            public void run() {
                CameraPreview.this.mCameraManager.autoFocus(CameraPreview.this.mFocusCallback);
            }
        };
        this.mCameraManager = new CameraManager(context);
        this.mPreviewCallback = new CameraScanAnalysis(context);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
