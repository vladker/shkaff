package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class FlutterViewFactory extends PlatformViewFactory {
    private final AndroidWebkitLibraryPigeonInstanceManager instanceManager;

    public FlutterViewFactory(AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager) {
        super(StandardMessageCodec.INSTANCE);
        this.instanceManager = androidWebkitLibraryPigeonInstanceManager;
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    @NonNull
    public PlatformView create(Context context, int i5, @Nullable Object obj) {
        Integer num = (Integer) obj;
        if (num == null) {
            throw new IllegalStateException("An identifier is required to retrieve a View instance.");
        }
        final Object androidWebkitLibraryPigeonInstanceManager = this.instanceManager.getInstance(num.intValue());
        if (androidWebkitLibraryPigeonInstanceManager instanceof PlatformView) {
            return (PlatformView) androidWebkitLibraryPigeonInstanceManager;
        }
        if (androidWebkitLibraryPigeonInstanceManager instanceof View) {
            return new PlatformView() { // from class: io.flutter.plugins.webviewflutter.FlutterViewFactory.1
                @Override // io.flutter.plugin.platform.PlatformView
                public View getView() {
                    return (View) androidWebkitLibraryPigeonInstanceManager;
                }

                @Override // io.flutter.plugin.platform.PlatformView
                public void dispose() {
                }
            };
        }
        throw new IllegalStateException("Unable to find a PlatformView or View instance: " + obj + ", " + androidWebkitLibraryPigeonInstanceManager);
    }
}
