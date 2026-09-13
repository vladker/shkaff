package L0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f407a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;
    public long d;

    public n(long j6) {
        this.b = j6;
        this.c = j6;
    }

    public final synchronized void a(long j6) {
        while (this.d > j6) {
            Iterator it = this.f407a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            m mVar = (m) entry.getValue();
            this.d -= (long) mVar.b;
            Object key = entry.getKey();
            it.remove();
            onItemEvicted(key, mVar.f406a);
        }
    }

    public synchronized boolean contains(@NonNull Object obj) {
        return this.f407a.containsKey(obj);
    }

    @Nullable
    public synchronized Object get(@NonNull Object obj) {
        m mVar;
        mVar = (m) this.f407a.get(obj);
        return mVar != null ? mVar.f406a : null;
    }

    public int getSize(@Nullable Object obj) {
        return 1;
    }

    @Nullable
    public synchronized Object put(@NonNull Object obj, @Nullable Object obj2) {
        int size = getSize(obj2);
        long j6 = size;
        if (j6 >= this.c) {
            onItemEvicted(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.d += j6;
        }
        m mVar = (m) this.f407a.put(obj, obj2 == null ? null : new m(obj2, size));
        if (mVar != null) {
            this.d -= (long) mVar.b;
            if (!mVar.f406a.equals(obj2)) {
                onItemEvicted(obj, mVar.f406a);
            }
        }
        a(this.c);
        return mVar != null ? mVar.f406a : null;
    }

    @Nullable
    public synchronized Object remove(@NonNull Object obj) {
        m mVar = (m) this.f407a.remove(obj);
        if (mVar == null) {
            return null;
        }
        this.d -= (long) mVar.b;
        return mVar.f406a;
    }

    public void onItemEvicted(@NonNull Object obj, @Nullable Object obj2) {
    }
}
