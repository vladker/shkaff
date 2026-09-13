package p144z0;

import L0.q;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.J;
import com.bumptech.glide.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class Y implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9067a;
    public final Pools.Pool b;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class a implements e, d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f9068a;
        public final Pools.Pool b;
        public int c;
        public o d;
        public d e;

        @Nullable
        private List<Throwable> exceptions;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9069f;

        public a(@NonNull List<e> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            q.checkNotEmpty(list);
            this.f9068a = list;
            this.c = 0;
        }

        @Override // com.bumptech.glide.load.data.e
        public final void a() {
            List<Throwable> list = this.exceptions;
            if (list != null) {
                this.b.release(list);
            }
            this.exceptions = null;
            Iterator it = this.f9068a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a();
            }
        }

        public final void b() {
            if (this.f9069f) {
                return;
            }
            if (this.c < this.f9068a.size() - 1) {
                this.c++;
                loadData(this.d, this.e);
            } else {
                q.checkNotNull(this.exceptions);
                this.e.onLoadFailed(new J("Fetch failed", new ArrayList(this.exceptions)));
            }
        }

        @Override // com.bumptech.glide.load.data.e
        public final void cancel() {
            this.f9069f = true;
            Iterator it = this.f9068a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.e
        @NonNull
        public Class<Object> getDataClass() {
            return ((e) this.f9068a.get(0)).getDataClass();
        }

        @Override // com.bumptech.glide.load.data.e
        @NonNull
        public p126w0.a getDataSource() {
            return ((e) this.f9068a.get(0)).getDataSource();
        }

        @Override // com.bumptech.glide.load.data.e
        public void loadData(@NonNull o oVar, @NonNull d dVar) {
            this.d = oVar;
            this.e = dVar;
            this.exceptions = (List) this.b.acquire();
            ((e) this.f9068a.get(this.c)).loadData(oVar, this);
            if (this.f9069f) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void onDataReady(@Nullable Object obj) {
            if (obj != null) {
                this.e.onDataReady(obj);
            } else {
                b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void onLoadFailed(@NonNull Exception exc) {
            ((List) q.checkNotNull(this.exceptions)).add(exc);
            b();
        }
    }

    public Y(@NonNull List<T> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f9067a = list;
        this.b = pool;
    }

    @Override // p144z0.T
    public S buildLoadData(@NonNull Object obj, int i5, int i6, @NonNull v vVar) {
        S sBuildLoadData;
        List list = this.f9067a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        p126w0.q qVar = null;
        for (int i7 = 0; i7 < size; i7++) {
            T t6 = (T) list.get(i7);
            if (t6.handles(obj) && (sBuildLoadData = t6.buildLoadData(obj, i5, i6, vVar)) != null) {
                qVar = sBuildLoadData.f9063a;
                arrayList.add(sBuildLoadData.c);
            }
        }
        if (arrayList.isEmpty() || qVar == null) {
            return null;
        }
        return new S(qVar, new a(arrayList, this.b));
    }

    @Override // p144z0.T
    public boolean handles(@NonNull Object obj) {
        Iterator it = this.f9067a.iterator();
        while (it.hasNext()) {
            if (((T) it.next()).handles(obj)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f9067a.toArray()) + '}';
    }
}
