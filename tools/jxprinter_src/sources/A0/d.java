package A0;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import kotlin.jvm.internal.D;
import p126w0.v;
import p144z0.S;
import p144z0.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10a;

    public d(Context context) {
        this.f10a = context.getApplicationContext();
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        if (i5 == Integer.MIN_VALUE || i6 == Integer.MIN_VALUE || i5 > 512 || i6 > 384) {
            return null;
        }
        K0.d dVar = new K0.d(uri);
        Context context = this.f10a;
        return new S(dVar, p132x0.b.b(context, uri, new p132x0.a(context.getContentResolver(), 0)));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return D.b(uri) && !uri.getPathSegments().contains("video");
    }
}
