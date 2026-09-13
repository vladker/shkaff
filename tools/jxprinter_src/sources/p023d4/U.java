package p023d4;

import O3.l;
import io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonProxyApiRegistrar;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class U implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3832a;
    public final /* synthetic */ long b;

    public /* synthetic */ U(long j6, int i5) {
        this.f3832a = i5;
        this.b = j6;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f3832a) {
            case 0:
                return Long.valueOf(this.b);
            default:
                return AndroidWebkitLibraryPigeonProxyApiRegistrar.AnonymousClass1.onFinalize$lambda$0(this.b, (u) obj);
        }
    }
}
