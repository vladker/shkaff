package com.google.android.gms.common.stats;

import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.inspector.InspectionCompanion;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ ColorStateListDrawable g(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    public static /* synthetic */ Surface j(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* synthetic */ SurfaceControl.Builder k() {
        return new SurfaceControl.Builder();
    }

    public static /* synthetic */ SurfaceControl.Transaction l() {
        return new SurfaceControl.Transaction();
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction n(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }

    public static /* synthetic */ InspectionCompanion.UninitializedPropertyMapException p() {
        return new InspectionCompanion.UninitializedPropertyMapException();
    }

    public static /* synthetic */ void q() {
    }

    public static /* bridge */ /* synthetic */ boolean y(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
