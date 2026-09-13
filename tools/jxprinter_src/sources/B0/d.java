package B0;

import L0.q;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class d implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f87a;

    public d(@NonNull Object obj) {
        this.f87a = q.checkNotNull(obj);
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public final Object get() {
        return this.f87a;
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<Object> getResourceClass() {
        return this.f87a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
    }
}
