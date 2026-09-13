package p126w0;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class r implements z {
    public final Collection b;

    @SafeVarargs
    public r(@NonNull z... zVarArr) {
        if (zVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.b = Arrays.asList(zVarArr);
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.b.equals(((r) obj).b);
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // p126w0.z
    @NonNull
    public O transform(@NonNull Context context, @NonNull O o6, int i5, int i6) {
        Iterator it = this.b.iterator();
        O o7 = o6;
        while (it.hasNext()) {
            O oTransform = ((z) it.next()).transform(context, o7, i5, i6);
            if (o7 != null && !o7.equals(o6) && !o7.equals(oTransform)) {
                o7.recycle();
            }
            o7 = oTransform;
        }
        return o7;
    }

    @Override // p126w0.z, p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((z) it.next()).updateDiskCacheKey(messageDigest);
        }
    }

    public r(@NonNull Collection<? extends z> collection) {
        if (!collection.isEmpty()) {
            this.b = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
