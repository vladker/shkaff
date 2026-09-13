package H0;

import L0.p;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.C0499o;
import com.bumptech.glide.load.engine.M;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final M c = new M(Object.class, Object.class, Object.class, Collections.singletonList(new C0499o(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new F0.h(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f285a = new ArrayMap();
    public final AtomicReference b = new AtomicReference();

    @Nullable
    public <Data, TResource, Transcode> M get(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        M m6;
        p pVar = (p) this.b.getAndSet(null);
        if (pVar == null) {
            pVar = new p();
        }
        pVar.set(cls, cls2, cls3);
        synchronized (this.f285a) {
            m6 = (M) this.f285a.get(pVar);
        }
        this.b.set(pVar);
        return m6;
    }

    public boolean isEmptyLoadPath(@Nullable M m6) {
        return c.equals(m6);
    }

    public void put(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable M m6) {
        synchronized (this.f285a) {
            ArrayMap arrayMap = this.f285a;
            p pVar = new p(cls, cls2, cls3);
            if (m6 == null) {
                m6 = c;
            }
            arrayMap.put(pVar, m6);
        }
    }
}
