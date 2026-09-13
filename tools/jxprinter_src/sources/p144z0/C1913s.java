package p144z0;

import D0.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: z0.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1913s implements U, InterfaceC1916v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9096a;

    public C1913s(Context context) {
        this.f9096a = context;
    }

    @Override // p144z0.U
    @NonNull
    public T build(@NonNull a0 a0Var) {
        return new C1917w(this.f9096a, this);
    }

    @Override // p144z0.InterfaceC1916v
    public final Class getDataClass() {
        return Drawable.class;
    }

    @Override // p144z0.InterfaceC1916v
    public void close(Drawable drawable) {
    }

    @Override // p144z0.InterfaceC1916v
    public Drawable open(@Nullable Resources.Theme theme, Resources resources, int i5) {
        return e.getDrawable(this.f9096a, i5, theme);
    }
}
