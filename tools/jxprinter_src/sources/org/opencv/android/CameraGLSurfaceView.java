package org.opencv.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import org.opencv.R;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CameraGLSurfaceView extends GLSurfaceView {
    private static final String LOGTAG = "CameraGLSurfaceView";
    private CameraGLRendererBase mRenderer;
    private CameraTextureListener mTexListener;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CameraTextureListener {
        boolean onCameraTexture(int i5, int i6, int i7, int i8);

        void onCameraViewStarted(int i5, int i6);

        void onCameraViewStopped();
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraBridgeViewBase);
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        typedArrayObtainStyledAttributes.recycle();
        this.mRenderer = new Camera2Renderer(this);
        setCameraIndex(i5);
        setEGLContextClientVersion(2);
        setRenderer(this.mRenderer);
        setRenderMode(0);
    }

    public void disableView() {
        this.mRenderer.disableView();
    }

    public void enableView() {
        this.mRenderer.enableView();
    }

    public CameraTextureListener getCameraTextureListener() {
        return this.mTexListener;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Log.i(LOGTAG, "onPause");
        this.mRenderer.onPause();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Log.i(LOGTAG, "onResume");
        super.onResume();
        this.mRenderer.onResume();
    }

    public void setCameraIndex(int i5) {
        this.mRenderer.setCameraIndex(i5);
    }

    public void setCameraTextureListener(CameraTextureListener cameraTextureListener) {
        this.mTexListener = cameraTextureListener;
    }

    public void setMaxCameraPreviewSize(int i5, int i6) {
        this.mRenderer.setMaxCameraPreviewSize(i5, i6);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
        super.surfaceChanged(surfaceHolder, i5, i6, i7);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mRenderer.mHaveSurface = false;
        super.surfaceDestroyed(surfaceHolder);
    }
}
