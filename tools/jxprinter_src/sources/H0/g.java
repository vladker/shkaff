package H0;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f288a = new ArrayList();
    public final HashMap b = new HashMap();

    @NonNull
    private synchronized List<f> getOrAddEntryList(@NonNull String str) {
        List<f> arrayList;
        try {
            if (!this.f288a.contains(str)) {
                this.f288a.add(str);
            }
            arrayList = (List) this.b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized <T, R> void append(@NonNull String str, @NonNull x xVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        getOrAddEntryList(str).add(new f(cls, cls2, xVar));
    }

    @NonNull
    public synchronized <T, R> List<x> getDecoders(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f288a;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            List<f> list = (List) this.b.get((String) obj);
            if (list != null) {
                for (f fVar : list) {
                    if (fVar.handles(cls, cls2)) {
                        arrayList.add(fVar.c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> getResourceClasses(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f288a;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            List<f> list = (List) this.b.get((String) obj);
            if (list != null) {
                for (f fVar : list) {
                    if (fVar.handles(cls, cls2) && !arrayList.contains(fVar.b)) {
                        arrayList.add(fVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void prepend(@NonNull String str, @NonNull x xVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        getOrAddEntryList(str).add(0, new f(cls, cls2, xVar));
    }

    public synchronized void setBucketPriorityList(@NonNull List<String> list) {
        try {
            ArrayList arrayList = new ArrayList(this.f288a);
            this.f288a.clear();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f288a.add(it.next());
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                String str = (String) obj;
                if (!list.contains(str)) {
                    this.f288a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
