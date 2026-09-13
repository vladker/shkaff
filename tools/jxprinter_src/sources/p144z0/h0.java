package p144z0;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9083a;

    public h0(Context context) {
        this.f9083a = context;
    }

    @Override // p144z0.U
    @NonNull
    public T build(@NonNull a0 a0Var) {
        return new i0(this.f9083a, a0Var.build(Integer.class, InputStream.class));
    }
}
