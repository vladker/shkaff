package K0;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements q {
    public final Object b;

    public d(@NonNull Object obj) {
        this.b = L0.q.checkNotNull(obj);
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.b.equals(((d) obj).b);
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }

    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(q.f8812a));
    }
}
