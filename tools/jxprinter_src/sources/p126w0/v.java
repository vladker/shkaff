package p126w0;

import L0.d;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements q {
    public final d b = new d();

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.b.equals(((v) obj).b);
        }
        return false;
    }

    @Nullable
    public <T> T get(@NonNull u uVar) {
        d dVar = this.b;
        return dVar.containsKey(uVar) ? (T) dVar.get(uVar) : (T) uVar.getDefaultValue();
    }

    @Override // p126w0.q
    public final int hashCode() {
        return this.b.hashCode();
    }

    public void putAll(@NonNull v vVar) {
        this.b.putAll((SimpleArrayMap) vVar.b);
    }

    public v remove(@NonNull u uVar) {
        this.b.remove(uVar);
        return this;
    }

    @NonNull
    public <T> v set(@NonNull u uVar, @NonNull T t6) {
        this.b.put(uVar, t6);
        return this;
    }

    public final String toString() {
        return "Options{values=" + this.b + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        int i5 = 0;
        while (true) {
            d dVar = this.b;
            if (i5 >= dVar.size()) {
                return;
            }
            updateDiskCacheKey((u) dVar.keyAt(i5), dVar.valueAt(i5), messageDigest);
            i5++;
        }
    }

    private static <T> void updateDiskCacheKey(@NonNull u uVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        uVar.update(obj, messageDigest);
    }
}
