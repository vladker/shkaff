package p144z0;

import K0.d;
import androidx.annotation.NonNull;
import java.io.File;
import p126w0.v;

/* JADX INFO: renamed from: z0.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1907l implements T {
    @Override // p144z0.T
    public S buildLoadData(@NonNull File file, int i5, int i6, @NonNull v vVar) {
        return new S(new d(file), new C1905j(file));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull File file) {
        return true;
    }
}
