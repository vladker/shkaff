package H0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import p126w0.y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f290a = new ArrayList();

    public synchronized <Z> void append(@NonNull Class<Z> cls, @NonNull y yVar) {
        this.f290a.add(new h(cls, yVar));
    }

    @Nullable
    public synchronized <Z> y get(@NonNull Class<Z> cls) {
        int size = this.f290a.size();
        for (int i5 = 0; i5 < size; i5++) {
            h hVar = (h) this.f290a.get(i5);
            if (hVar.handles(cls)) {
                return hVar.b;
            }
        }
        return null;
    }

    public synchronized <Z> void prepend(@NonNull Class<Z> cls, @NonNull y yVar) {
        this.f290a.add(0, new h(cls, yVar));
    }
}
