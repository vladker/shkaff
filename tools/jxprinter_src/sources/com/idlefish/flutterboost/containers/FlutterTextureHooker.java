package com.idlefish.flutterboost.containers;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import io.flutter.embedding.android.FlutterTextureView;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class FlutterTextureHooker {
    private FlutterTextureView flutterTextureView;
    private boolean isNeedRestoreState = false;
    private SurfaceTexture restoreSurface;

    /* JADX INFO: renamed from: com.idlefish.flutterboost.containers.FlutterTextureHooker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        final /* synthetic */ FlutterTextureView val$flutterTextureView;
        final /* synthetic */ TextureView.SurfaceTextureListener val$surfaceTextureListener;

        public AnonymousClass1(TextureView.SurfaceTextureListener surfaceTextureListener, FlutterTextureView flutterTextureView) {
            this.val$surfaceTextureListener = surfaceTextureListener;
            this.val$flutterTextureView = flutterTextureView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i5, int i6) {
            this.val$surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i5, i6);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                Field declaredField = this.val$flutterTextureView.getClass().getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.val$flutterTextureView, Boolean.FALSE);
                FlutterTextureHooker.this.isNeedRestoreState = true;
                return false;
            } catch (Exception e) {
                throw new RuntimeException("You *SHOULD* keep FlutterTextureView: -keep class io.flutter.embedding.android.FlutterTextureView { *; }.", e);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i5, int i6) {
            this.val$surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i5, i6);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            this.val$surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
            FlutterTextureHooker.this.restoreSurface = surfaceTexture;
        }
    }

    public void onFlutterTextureViewRelease() {
    }

    public void onFlutterTextureViewRestoreState() {
    }

    public void hookFlutterTextureView(FlutterTextureView flutterTextureView) {
    }
}
