package p144z0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f9088a;

    public n0(T t6) {
        this.f9088a = t6;
    }

    @Nullable
    private static Uri parseUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return Uri.fromFile(new File(str));
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? Uri.fromFile(new File(str)) : uri;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull String str, int i5, int i6, @NonNull v vVar) {
        Uri uri = parseUri(str);
        if (uri == null) {
            return null;
        }
        T t6 = this.f9088a;
        if (t6.handles(uri)) {
            return t6.buildLoadData(uri, i5, i6, vVar);
        }
        return null;
    }

    @Override // p144z0.T
    public boolean handles(@NonNull String str) {
        return true;
    }
}
