package A0;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.File;
import p144z0.T;
import p144z0.U;
import p144z0.a0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13a;
    public final Class b;

    public g(Context context, Class cls) {
        this.f13a = context;
        this.b = cls;
    }

    @Override // p144z0.U
    @NonNull
    public final T build(@NonNull a0 a0Var) {
        Class cls = this.b;
        return new k(this.f13a, a0Var.build(File.class, cls), a0Var.build(Uri.class, cls), cls);
    }
}
