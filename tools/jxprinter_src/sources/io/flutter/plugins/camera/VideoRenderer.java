package io.flutter.plugins.camera;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class VideoRenderer {
    static String TAG = "VideoRenderer";
    private static final String fragmentShaderCode = " #extension GL_OES_EGL_image_external : require\n            precision mediump float;\n\n            varying vec2 varUvs;\n            uniform samplerExternalOES texSampler;\n\n            void main()\n            {\n                vec4 c = texture2D(texSampler, varUvs);\n                gl_FragColor = vec4(c.r, c.g, c.b, c.a);\n            }";
    private static final String vertexShaderCode = "  precision highp float;\n            attribute vec3 vertexPosition;\n            attribute vec2 uvs;\n            varying vec2 varUvs;\n            uniform mat4 texMatrix;\n            uniform mat4 mvp;\n\n            void main()\n            {\n                varUvs = (texMatrix * vec4(uvs.x, uvs.y, 0, 1.0)).xy;\n                gl_Position = mvp * vec4(vertexPosition, 1.0);\n            }";
    EGLContext context;
    EGLDisplay display;
    private Surface inputSurface;
    SurfaceTexture inputSurfaceTexture;
    private final Surface outputSurface;
    private int program;
    final int recordingHeight;
    final int recordingWidth;
    EGLSurface surface;
    private HandlerThread surfaceTextureFrameAvailableHandler;
    private Thread thread;
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final int[] textureHandles = new int[1];
    private final float[] vertices = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f};
    private final int[] indices = {2, 1, 0, 0, 3, 2};
    private int vertexHandle = 0;
    private final int[] bufferHandles = new int[2];
    private int uvsHandle = 0;
    private int texMatrixHandle = 0;
    private int mvpHandle = 0;
    final Object surfaceTextureAvailableFrameLock = new Object();
    Boolean surfaceTextureFrameAvailable = Boolean.FALSE;
    private int rotation = 0;
    private final Object lock = new Object();

    public VideoRenderer(@NonNull Surface surface, int i5, int i6, @NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.outputSurface = surface;
        this.recordingHeight = i6;
        this.recordingWidth = i5;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        startOpenGL();
        Log.d(TAG, "VideoRenderer setup complete");
    }

    private void cleanupOpenGL() {
        GLES20.glDeleteBuffers(2, this.bufferHandles, 0);
        GLES20.glDeleteTextures(1, this.textureHandles, 0);
        EGL14.eglDestroyContext(this.display, this.context);
        EGL14.eglDestroySurface(this.display, this.surface);
        GLES20.glDeleteProgram(this.program);
    }

    private void deleteShader(int i5) {
        GLES20.glDeleteShader(i5);
    }

    private int loadShader(int i5, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i5);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        return iGlCreateShader;
    }

    private void startOpenGL() {
        Log.d(TAG, "Starting OpenGL Thread");
        Thread thread = new Thread() { // from class: io.flutter.plugins.camera.VideoRenderer.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                VideoRenderer videoRenderer;
                VideoRenderer.this.configureOpenGL();
                while (!Thread.interrupted()) {
                    try {
                        synchronized (VideoRenderer.this.surfaceTextureAvailableFrameLock) {
                            while (!VideoRenderer.this.surfaceTextureFrameAvailable.booleanValue()) {
                                try {
                                    VideoRenderer.this.surfaceTextureAvailableFrameLock.wait(500L);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            videoRenderer = VideoRenderer.this;
                            videoRenderer.surfaceTextureFrameAvailable = Boolean.FALSE;
                        }
                        videoRenderer.inputSurfaceTexture.updateTexImage();
                        float[] fArr = new float[16];
                        VideoRenderer.this.inputSurfaceTexture.getTransformMatrix(fArr);
                        VideoRenderer videoRenderer2 = VideoRenderer.this;
                        videoRenderer2.draw(videoRenderer2.recordingWidth, videoRenderer2.recordingHeight, fArr);
                    } catch (InterruptedException unused) {
                        Log.d(VideoRenderer.TAG, "thread interrupted while waiting for frames");
                        return;
                    }
                }
            }
        };
        this.thread = thread;
        thread.setUncaughtExceptionHandler(this.uncaughtExceptionHandler);
        this.thread.start();
    }

    public void close() {
        this.thread.interrupt();
        this.surfaceTextureFrameAvailableHandler.quitSafely();
        cleanupOpenGL();
        this.inputSurfaceTexture.release();
    }

    public void configureOpenGL() {
        synchronized (this.lock) {
            try {
                EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                this.display = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("eglDisplay == EGL14.EGL_NO_DISPLAY: " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                    throw new RuntimeException("eglInitialize(): " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                }
                if (!EGL14.eglQueryString(this.display, 12373).contains("EGL_ANDROID_presentation_time")) {
                    throw new RuntimeException("cannot configure OpenGL. missing EGL_ANDROID_presentation_time");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!EGL14.eglChooseConfig(this.display, SdkCapabilityChecker.supportsEglRecordableAndroid() ? new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344} : new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    throw new RuntimeException(GLUtils.getEGLErrorString(EGL14.eglGetError()));
                }
                int iEglGetError = EGL14.eglGetError();
                if (iEglGetError != 12288) {
                    throw new RuntimeException(GLUtils.getEGLErrorString(iEglGetError));
                }
                this.context = EGL14.eglCreateContext(this.display, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                int iEglGetError2 = EGL14.eglGetError();
                if (iEglGetError2 != 12288) {
                    throw new RuntimeException(GLUtils.getEGLErrorString(iEglGetError2));
                }
                this.surface = EGL14.eglCreateWindowSurface(this.display, eGLConfigArr[0], this.outputSurface, new int[]{12344}, 0);
                int iEglGetError3 = EGL14.eglGetError();
                if (iEglGetError3 != 12288) {
                    throw new RuntimeException(GLUtils.getEGLErrorString(iEglGetError3));
                }
                EGLDisplay eGLDisplay = this.display;
                EGLSurface eGLSurface = this.surface;
                if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.context)) {
                    throw new RuntimeException("eglMakeCurrent(): " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                }
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.vertices.length * 4);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                byteBufferAllocateDirect.asFloatBuffer().put(this.vertices);
                byteBufferAllocateDirect.asFloatBuffer().position(0);
                ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(this.indices.length * 4);
                byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
                byteBufferAllocateDirect2.asIntBuffer().put(this.indices);
                byteBufferAllocateDirect2.position(0);
                int iLoadShader = loadShader(35633, vertexShaderCode);
                int iLoadShader2 = loadShader(35632, fragmentShaderCode);
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.program = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                GLES20.glAttachShader(this.program, iLoadShader2);
                GLES20.glLinkProgram(this.program);
                deleteShader(iLoadShader);
                deleteShader(iLoadShader2);
                this.vertexHandle = GLES20.glGetAttribLocation(this.program, "vertexPosition");
                this.uvsHandle = GLES20.glGetAttribLocation(this.program, "uvs");
                this.texMatrixHandle = GLES20.glGetUniformLocation(this.program, "texMatrix");
                this.mvpHandle = GLES20.glGetUniformLocation(this.program, "mvp");
                GLES20.glGenBuffers(2, this.bufferHandles, 0);
                GLES20.glBindBuffer(34962, this.bufferHandles[0]);
                GLES20.glBufferData(34962, this.vertices.length * 4, byteBufferAllocateDirect, 35048);
                GLES20.glBindBuffer(34963, this.bufferHandles[1]);
                GLES20.glBufferData(34963, this.indices.length * 4, byteBufferAllocateDirect2, 35048);
                GLES20.glGenTextures(1, this.textureHandles, 0);
                GLES20.glBindTexture(36197, this.textureHandles[0]);
                SurfaceTexture surfaceTexture = new SurfaceTexture(getTexId());
                this.inputSurfaceTexture = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.recordingWidth, this.recordingHeight);
                HandlerThread handlerThread = new HandlerThread("FrameHandlerThread");
                this.surfaceTextureFrameAvailableHandler = handlerThread;
                handlerThread.start();
                this.inputSurface = new Surface(this.inputSurfaceTexture);
                this.inputSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.plugins.camera.VideoRenderer.1
                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                        synchronized (VideoRenderer.this.surfaceTextureAvailableFrameLock) {
                            try {
                                if (VideoRenderer.this.surfaceTextureFrameAvailable.booleanValue()) {
                                    Log.w(VideoRenderer.TAG, "Frame available before processing other frames. dropping frames");
                                }
                                VideoRenderer videoRenderer = VideoRenderer.this;
                                videoRenderer.surfaceTextureFrameAvailable = Boolean.TRUE;
                                videoRenderer.surfaceTextureAvailableFrameLock.notifyAll();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }, new Handler(this.surfaceTextureFrameAvailableHandler.getLooper()));
                this.lock.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void draw(int i5, int i6, @NonNull float[] fArr) {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, i5, i6);
        GLES20.glUseProgram(this.program);
        GLES20.glUniformMatrix4fv(this.texMatrixHandle, 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.mvpHandle, 1, false, moveMatrix(), 0);
        GLES20.glBindBuffer(34962, this.bufferHandles[0]);
        GLES20.glBindBuffer(34963, this.bufferHandles[1]);
        GLES20.glEnableVertexAttribArray(this.vertexHandle);
        GLES20.glVertexAttribPointer(this.vertexHandle, 3, 5126, false, 20, 0);
        GLES20.glEnableVertexAttribArray(this.uvsHandle);
        GLES20.glVertexAttribPointer(this.uvsHandle, 2, 5126, false, 20, 12);
        GLES20.glDrawElements(4, 6, 5125, 0);
        EGLExt.eglPresentationTimeANDROID(this.display, this.surface, SystemClock.uptimeMillis() * 1000000);
        if (EGL14.eglSwapBuffers(this.display, this.surface)) {
            return;
        }
        Log.w(TAG, "eglSwapBuffers() " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
    }

    @NonNull
    public Surface getInputSurface() {
        Surface surface;
        synchronized (this.lock) {
            while (true) {
                try {
                    surface = this.inputSurface;
                    if (surface == null) {
                        this.lock.wait();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return surface;
    }

    public int getTexId() {
        return this.textureHandles[0];
    }

    @NonNull
    public float[] moveMatrix() {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(fArr, 0, this.rotation, 0.0f, 0.0f, 1.0f);
        return fArr;
    }

    public void setRotation(int i5) {
        this.rotation = i5;
    }
}
