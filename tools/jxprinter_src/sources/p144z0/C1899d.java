package p144z0;

import K0.d;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import io.flutter.plugins.firebase.crashlytics.Constants;
import p126w0.v;

/* JADX INFO: renamed from: z0.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1899d implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f9076a;
    public final Object b;

    public C1899d(AssetManager assetManager, InterfaceC1896a interfaceC1896a) {
        this.f9076a = assetManager;
        this.b = interfaceC1896a;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, z0.a] */
    @Override // p144z0.T
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        return new S(new d(uri), this.b.a(this.f9076a, uri.toString().substring(22)));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return Constants.FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
