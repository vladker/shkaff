package A0;

import androidx.annotation.NonNull;
import java.net.URL;
import p126w0.v;
import p144z0.E;
import p144z0.S;
import p144z0.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f21a;

    public m(T t6) {
        this.f21a = t6;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull URL url, int i5, int i6, @NonNull v vVar) {
        return this.f21a.buildLoadData(new E(url), i5, i6, vVar);
    }

    @Override // p144z0.T
    public boolean handles(@NonNull URL url) {
        return true;
    }
}
