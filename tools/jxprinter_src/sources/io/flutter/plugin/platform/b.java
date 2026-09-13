package io.flutter.plugin.platform;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4091a;
    public final /* synthetic */ int b;
    public final /* synthetic */ PlatformViewsAccessibilityDelegate c;

    public /* synthetic */ b(PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate, int i5, int i6) {
        this.f4091a = i6;
        this.c = platformViewsAccessibilityDelegate;
        this.b = i5;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z6) {
        switch (this.f4091a) {
            case 0:
                ((PlatformViewsController) this.c).lambda$initializePlatformViewIfNeeded$2(this.b, view, z6);
                break;
            default:
                ((PlatformViewsController2) this.c).lambda$initializePlatformViewIfNeeded$0(this.b, view, z6);
                break;
        }
    }
}
