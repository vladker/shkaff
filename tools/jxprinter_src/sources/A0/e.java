package A0;

import android.content.Context;
import androidx.annotation.NonNull;
import p144z0.T;
import p144z0.U;
import p144z0.a0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11a;

    public e(Context context) {
        this.f11a = context;
    }

    @Override // p144z0.U
    @NonNull
    public T build(a0 a0Var) {
        return new f(this.f11a);
    }
}
