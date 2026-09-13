package p144z0;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: z0.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1918x implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f9103a;

    public AbstractC1918x(B b) {
        this.f9103a = b;
    }

    @Override // p144z0.U
    @NonNull
    public final T build(@NonNull a0 a0Var) {
        return new D(this.f9103a);
    }
}
