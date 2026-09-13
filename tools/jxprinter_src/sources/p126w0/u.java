package p126w0;

import A3.AbstractC0157z;
import L0.q;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static final s e = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8813a;
    public final t b;
    public final String c;
    public volatile byte[] d;

    private u(@NonNull String str, @Nullable Object obj, @NonNull t tVar) {
        this.c = q.checkNotEmpty(str);
        this.f8813a = obj;
        this.b = (t) q.checkNotNull(tVar);
    }

    @NonNull
    public static <T> u disk(@NonNull String str, @NonNull t tVar) {
        return new u(str, null, tVar);
    }

    @NonNull
    private static <T> t emptyUpdater() {
        return e;
    }

    @NonNull
    private byte[] getKeyBytes() {
        if (this.d == null) {
            this.d = this.c.getBytes(q.f8812a);
        }
        return this.d;
    }

    @NonNull
    public static <T> u memory(@NonNull String str) {
        return new u(str, null, emptyUpdater());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            return this.c.equals(((u) obj).c);
        }
        return false;
    }

    @Nullable
    public Object getDefaultValue() {
        return this.f8813a;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return AbstractC0157z.s(new StringBuilder("Option{key='"), this.c, "'}");
    }

    public void update(@NonNull Object obj, @NonNull MessageDigest messageDigest) {
        this.b.update(getKeyBytes(), obj, messageDigest);
    }

    @NonNull
    public static <T> u disk(@NonNull String str, @Nullable T t6, @NonNull t tVar) {
        return new u(str, t6, tVar);
    }

    @NonNull
    public static <T> u memory(@NonNull String str, @NonNull T t6) {
        return new u(str, t6, emptyUpdater());
    }
}
