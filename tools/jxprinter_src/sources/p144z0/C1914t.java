package p144z0;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: z0.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1914t implements U, InterfaceC1916v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9098a;

    public C1914t(Context context) {
        this.f9098a = context;
    }

    @Override // p144z0.U
    @NonNull
    public T build(@NonNull a0 a0Var) {
        return new C1917w(this.f9098a, this);
    }

    @Override // p144z0.InterfaceC1916v
    public final Class getDataClass() {
        return InputStream.class;
    }

    @Override // p144z0.InterfaceC1916v
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // p144z0.InterfaceC1916v
    public InputStream open(@Nullable Resources.Theme theme, Resources resources, int i5) {
        return resources.openRawResource(i5);
    }
}
