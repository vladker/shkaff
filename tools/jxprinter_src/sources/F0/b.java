package F0;

import L0.q;
import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;
import com.bumptech.glide.load.resource.bitmap.H;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f238a;

    public b(@NonNull Context context) {
        this(context.getResources());
    }

    @Override // F0.e
    @Nullable
    public O transcode(@NonNull O o6, @NonNull v vVar) {
        return H.obtain(this.f238a, o6);
    }

    @Deprecated
    public b(@NonNull Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(resources);
    }

    public b(@NonNull Resources resources) {
        this.f238a = (Resources) q.checkNotNull(resources);
    }
}
