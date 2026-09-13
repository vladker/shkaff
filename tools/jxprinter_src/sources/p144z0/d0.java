package p144z0;

import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f9077a;

    public d0(Resources resources) {
        this.f9077a = resources;
    }

    @Override // p144z0.U
    @NonNull
    public T build(a0 a0Var) {
        return new f0(this.f9077a, a0Var.build(Uri.class, InputStream.class));
    }
}
