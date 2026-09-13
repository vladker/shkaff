package com.google.android.material.motion;

import android.window.OnBackInvokedCallback;
import io.flutter.embedding.android.FlutterActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3343a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f3343a = i5;
        this.b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f3343a) {
            case 0:
                ((MaterialBackHandler) this.b).handleBackInvoked();
                break;
            default:
                ((FlutterActivity) this.b).onBackPressed();
                break;
        }
    }
}
