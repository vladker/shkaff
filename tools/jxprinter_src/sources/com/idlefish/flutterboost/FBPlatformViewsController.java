package com.idlefish.flutterboost;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.TextureRegistry;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FBPlatformViewsController extends PlatformViewsController {
    private Context appCtx;
    private FlutterView curFlutterView = null;
    private FlutterView dummyFlutterView = null;

    @Override // io.flutter.plugin.platform.PlatformViewsController
    public void attach(@Nullable Context context, @NonNull TextureRegistry textureRegistry, @NonNull DartExecutor dartExecutor) {
        if (this.appCtx == null && context != null) {
            this.appCtx = context.getApplicationContext();
            this.dummyFlutterView = new FlutterView(this.appCtx);
        }
        super.attach(context, textureRegistry, dartExecutor);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsController
    public void attachToView(@NonNull FlutterView flutterView) {
        FlutterView flutterView2 = this.curFlutterView;
        if (flutterView2 == null) {
            super.attachToView(flutterView);
            this.curFlutterView = flutterView;
        } else if (flutterView != flutterView2) {
            removePlatformWrapperOrParents();
            super.attachToView(flutterView);
            this.curFlutterView = flutterView;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsController
    public void detach() {
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("context");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception unused) {
        }
        destroyOverlaySurfaces();
    }

    @Override // io.flutter.plugin.platform.PlatformViewsController
    public void detachFromView() {
        if (this.curFlutterView != null) {
            super.detachFromView();
            this.curFlutterView = null;
            attachToView(this.dummyFlutterView);
        }
    }

    public void removePlatformWrapperOrParents() {
        if (this.curFlutterView != null) {
            ArrayList arrayList = new ArrayList();
            int childCount = this.curFlutterView.getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = this.curFlutterView.getChildAt(i6);
                if (childAt.getClass().getName().contains("PlatformViewWrapper") || (childAt instanceof FlutterMutatorView)) {
                    arrayList.add(childAt);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int size = arrayList.size();
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                this.curFlutterView.removeView((View) obj);
            }
        }
    }
}
