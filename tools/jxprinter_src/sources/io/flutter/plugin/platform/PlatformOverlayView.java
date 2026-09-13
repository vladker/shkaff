package io.flutter.plugin.platform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.android.FlutterImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PlatformOverlayView extends FlutterImageView {

    @Nullable
    private AccessibilityEventsDelegate accessibilityDelegate;

    public PlatformOverlayView(@NonNull Context context, int i5, int i6, @NonNull AccessibilityEventsDelegate accessibilityEventsDelegate) {
        super(context, i5, i6, FlutterImageView.SurfaceKind.overlay);
        this.accessibilityDelegate = accessibilityEventsDelegate;
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        AccessibilityEventsDelegate accessibilityEventsDelegate = this.accessibilityDelegate;
        if (accessibilityEventsDelegate == null || !accessibilityEventsDelegate.onAccessibilityHoverEvent(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }

    public PlatformOverlayView(@NonNull Context context) {
        this(context, 1, 1, null);
    }

    public PlatformOverlayView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, 1, 1, null);
    }
}
