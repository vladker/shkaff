package A0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.p;
import org.opencv.videoio.Videoio;
import p126w0.u;
import p126w0.v;
import p144z0.E;
import p144z0.P;
import p144z0.Q;
import p144z0.S;
import p144z0.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class b implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f8a = u.memory("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(Videoio.CAP_UEYE));

    @Nullable
    private final Q modelCache;

    public b(@Nullable Q q6) {
        this.modelCache = q6;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull E e, int i5, int i6, @NonNull v vVar) {
        Q q6 = this.modelCache;
        if (q6 != null) {
            E e6 = (E) q6.get(e, 0, 0);
            if (e6 == null) {
                Q q7 = this.modelCache;
                q7.getClass();
                q7.f9062a.put(P.a(e, 0, 0), e);
            } else {
                e = e6;
            }
        }
        return new S(e, new p(e, ((Integer) vVar.get(f8a)).intValue()));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull E e) {
        return true;
    }
}
