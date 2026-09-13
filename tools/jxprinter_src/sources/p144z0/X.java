package p144z0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f9066a;
    public final W b;

    public X(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new a0(pool));
    }

    @NonNull
    private static <A> Class<A> getClass(@NonNull A a6) {
        return (Class<A>) a6.getClass();
    }

    @NonNull
    private synchronized <A> List<T> getModelLoadersForClass(@NonNull Class<A> cls) {
        List<T> listUnmodifiableList;
        listUnmodifiableList = this.b.get(cls);
        if (listUnmodifiableList == null) {
            listUnmodifiableList = Collections.unmodifiableList(this.f9066a.build(cls));
            if (((V) this.b.f9065a.put(cls, new V(listUnmodifiableList))) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
        return listUnmodifiableList;
    }

    private <Model, Data> void tearDown(@NonNull List<U> list) {
        Iterator<U> it = list.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        this.f9066a.append(cls, cls2, u6);
        this.b.f9065a.clear();
    }

    public synchronized <Model, Data> T build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f9066a.build(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        return this.f9066a.getDataClasses(cls);
    }

    @NonNull
    public <A> List<T> getModelLoaders(@NonNull A a6) {
        List<T> modelLoadersForClass = getModelLoadersForClass(getClass(a6));
        if (modelLoadersForClass.isEmpty()) {
            throw new s(a6);
        }
        int size = modelLoadersForClass.size();
        List<T> arrayList = Collections.EMPTY_LIST;
        boolean z6 = true;
        for (int i5 = 0; i5 < size; i5++) {
            T t6 = modelLoadersForClass.get(i5);
            if (t6.handles(a6)) {
                if (z6) {
                    arrayList = new ArrayList<>(size - i5);
                    z6 = false;
                }
                arrayList.add(t6);
            }
        }
        if (arrayList.isEmpty()) {
            throw new s(a6, modelLoadersForClass);
        }
        return arrayList;
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        this.f9066a.prepend(cls, cls2, u6);
        this.b.f9065a.clear();
    }

    public synchronized <Model, Data> void remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        tearDown(this.f9066a.remove(cls, cls2));
        this.b.f9065a.clear();
    }

    public synchronized <Model, Data> void replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull U u6) {
        tearDown(this.f9066a.replace(cls, cls2, u6));
        this.b.f9065a.clear();
    }

    private X(@NonNull a0 a0Var) {
        this.b = new W();
        this.f9066a = a0Var;
    }
}
