package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewCreationRequest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4092a;
    public final /* synthetic */ PlatformViewsController b;
    public final /* synthetic */ PlatformViewCreationRequest c;

    public /* synthetic */ c(PlatformViewsController platformViewsController, PlatformViewCreationRequest platformViewCreationRequest, int i5) {
        this.f4092a = i5;
        this.b = platformViewsController;
        this.c = platformViewCreationRequest;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z6) {
        switch (this.f4092a) {
            case 0:
                this.b.lambda$configureForTextureLayerComposition$1(this.c, view, z6);
                break;
            default:
                this.b.lambda$configureForVirtualDisplay$0(this.c, view, z6);
                break;
        }
    }
}
