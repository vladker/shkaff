package p073n;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p067m.b;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends l {
    public final int c;
    public final List d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f6208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f6209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Collection f6210h;

    public r(b bVar, List list, int i5) {
        super(null, null);
        this.e = bVar;
        this.c = i5;
        this.d = list;
        this.f6208f = null;
        this.f6209g = null;
        this.f6210h = null;
    }

    @Override // p073n.l
    public final void c(Object obj, Object obj2) {
        p050j.b bVar;
        Object obj3;
        Map map = this.f6209g;
        if (map != null) {
            map.put(this.f6208f, obj2);
            return;
        }
        Collection collection = this.f6210h;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        List list = this.d;
        int i5 = this.c;
        list.set(i5, obj2);
        if (!(list instanceof p050j.b) || (obj3 = (bVar = (p050j.b) list).f5378k) == null || Array.getLength(obj3) <= i5) {
            return;
        }
        Class cls = bVar.f5379l;
        if (cls != null) {
            obj2 = j.c(obj2, cls, this.e.b);
        }
        Array.set(obj3, i5, obj2);
    }

    public r(Map map, Object obj) {
        super(null, null);
        this.e = null;
        this.c = -1;
        this.d = null;
        this.f6208f = obj;
        this.f6209g = map;
        this.f6210h = null;
    }

    public r(Collection collection) {
        super(null, null);
        this.e = null;
        this.c = -1;
        this.d = null;
        this.f6208f = null;
        this.f6209g = null;
        this.f6210h = collection;
    }

    @Override // p073n.l
    public final void b(Object obj, Type type, Map map, b bVar) {
    }
}
