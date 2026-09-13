package io.flutter.plugins.webviewflutter;

import android.webkit.ValueCallback;

/* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0671g implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4147a;
    public final /* synthetic */ O3.l b;

    public /* synthetic */ C0671g(int i5, O3.l lVar) {
        this.f4147a = i5;
        this.b = lVar;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        switch (this.f4147a) {
            case 0:
                ResultCompat.success((Boolean) obj, this.b);
                break;
            default:
                ResultCompat.success((String) obj, this.b);
                break;
        }
    }
}
