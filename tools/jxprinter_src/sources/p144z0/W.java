package p144z0;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f9065a = new HashMap();

    @Nullable
    public <Model> List<T> get(Class<Model> cls) {
        V v6 = (V) this.f9065a.get(cls);
        if (v6 == null) {
            return null;
        }
        return v6.f9064a;
    }
}
