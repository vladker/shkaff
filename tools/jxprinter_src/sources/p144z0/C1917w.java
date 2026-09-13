package p144z0;

import D0.h;
import K0.d;
import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import p126w0.v;

/* JADX INFO: renamed from: z0.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1917w implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9102a;
    public final Object b;

    public C1917w(Context context, InterfaceC1916v interfaceC1916v) {
        this.f9102a = context.getApplicationContext();
        this.b = interfaceC1916v;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, z0.v] */
    @Override // p144z0.T
    public S buildLoadData(@NonNull Integer num, int i5, int i6, @NonNull v vVar) {
        Resources.Theme theme = (Resources.Theme) vVar.get(h.b);
        return new S(new d(num), new C1915u(theme, theme != null ? theme.getResources() : this.f9102a.getResources(), this.b, num.intValue()));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Integer num) {
        return true;
    }
}
