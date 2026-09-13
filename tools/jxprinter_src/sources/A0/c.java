package A0;

import android.content.Context;
import androidx.annotation.NonNull;
import p144z0.T;
import p144z0.U;
import p144z0.a0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9a;

    public c(Context context) {
        this.f9a = context;
    }

    @Override // p144z0.U
    @NonNull
    public T build(a0 a0Var) {
        return new d(this.f9a);
    }
}
