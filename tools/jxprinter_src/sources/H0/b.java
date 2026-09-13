package H0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f283a = new ArrayList();

    public synchronized <T> void append(@NonNull Class<T> cls, @NonNull p126w0.d dVar) {
        this.f283a.add(new a(cls, dVar));
    }

    @Nullable
    public synchronized <T> p126w0.d getEncoder(@NonNull Class<T> cls) {
        ArrayList arrayList = this.f283a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            a aVar = (a) obj;
            if (aVar.handles(cls)) {
                return aVar.b;
            }
        }
        return null;
    }

    public synchronized <T> void prepend(@NonNull Class<T> cls, @NonNull p126w0.d dVar) {
        this.f283a.add(0, new a(cls, dVar));
    }
}
