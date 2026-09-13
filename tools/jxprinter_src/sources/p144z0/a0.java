package p144z0;

import L0.q;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    public static final b0 e = new b0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Z f9070f = new Z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9071a;
    public final b0 b;
    public final HashSet c;
    public final Pools.Pool d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f9072a;
        public final Class b;
        public final U c;

        public a(@NonNull Class<Object> cls, @NonNull Class<Object> cls2, @NonNull U u6) {
            this.f9072a = cls;
            this.b = cls2;
            this.c = u6;
        }

        public boolean handles(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return handles(cls) && this.b.isAssignableFrom(cls2);
        }

        public boolean handles(@NonNull Class<?> cls) {
            return this.f9072a.isAssignableFrom(cls);
        }
    }

    public a0(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, e);
    }

    private <Model, Data> void add(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6, boolean z6) {
        a aVar = new a(cls, cls2, u6);
        ArrayList arrayList = this.f9071a;
        arrayList.add(z6 ? arrayList.size() : 0, aVar);
    }

    @NonNull
    private static <Model, Data> T emptyModelLoader() {
        return f9070f;
    }

    @NonNull
    private <Model, Data> U getFactory(@NonNull a aVar) {
        return aVar.c;
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        add(cls, cls2, u6, true);
    }

    @NonNull
    public synchronized <Model> List<T> build(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f9071a;
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                a aVar = (a) obj;
                if (!this.c.contains(aVar) && aVar.handles(cls)) {
                    this.c.add(aVar);
                    arrayList.add(build(aVar));
                    this.c.remove(aVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f9071a;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            a aVar = (a) obj;
            if (!arrayList.contains(aVar.b) && aVar.handles(cls)) {
                arrayList.add(aVar.b);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        add(cls, cls2, u6, false);
    }

    @NonNull
    public synchronized <Model, Data> List<U> remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f9071a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.handles(cls, cls2)) {
                it.remove();
                arrayList.add(getFactory(aVar));
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> List<U> replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        List<U> listRemove;
        listRemove = remove(cls, cls2);
        append(cls, cls2, u6);
        return listRemove;
    }

    @VisibleForTesting
    public a0(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull b0 b0Var) {
        this.f9071a = new ArrayList();
        this.c = new HashSet();
        this.d = pool;
        this.b = b0Var;
    }

    @NonNull
    public synchronized <Model, Data> T build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f9071a;
            int size = arrayList2.size();
            boolean z6 = false;
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                a aVar = (a) obj;
                if (this.c.contains(aVar)) {
                    z6 = true;
                } else if (aVar.handles(cls, cls2)) {
                    this.c.add(aVar);
                    arrayList.add(build(aVar));
                    this.c.remove(aVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.build(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (z6) {
                return emptyModelLoader();
            }
            throw new s((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    @NonNull
    private <Model, Data> T build(@NonNull a aVar) {
        return (T) q.checkNotNull(aVar.c.build(this));
    }
}
