package A0;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import kotlin.jvm.internal.D;
import p126w0.v;
import p144z0.S;
import p144z0.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20a;
    public final T b;
    public final T c;
    public final Class d;

    public k(Context context, T t6, T t7, Class cls) {
        this.f20a = context.getApplicationContext();
        this.b = t6;
        this.c = t7;
        this.d = cls;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        return new S(new K0.d(uri), new j(this.f20a, this.b, this.c, uri, i5, i6, vVar, this.d));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && D.b(uri);
    }
}
