package p144z0;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l0 implements U {
    @Override // p144z0.U
    @NonNull
    public T build(@NonNull a0 a0Var) {
        return new n0(a0Var.build(Uri.class, ParcelFileDescriptor.class));
    }
}
