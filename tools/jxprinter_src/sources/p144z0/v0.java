package p144z0;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements T {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(ProxyConfig.MATCH_HTTP, ProxyConfig.MATCH_HTTPS)));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f9101a;

    public v0(T t6) {
        this.f9101a = t6;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Uri uri, int i5, int i6, @NonNull v vVar) {
        return this.f9101a.buildLoadData(new E(uri.toString()), i5, i6, vVar);
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
