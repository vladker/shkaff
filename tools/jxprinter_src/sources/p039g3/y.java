package p039g3;

import java.util.Collection;
import java.util.Map;
import p027e3.b;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f4009a;
    public final o b;
    public final o c;

    public y(o oVar, o oVar2, o oVar3) {
        this.f4009a = oVar;
        this.b = oVar2;
        this.c = oVar3;
    }

    @Override // p027e3.b
    public void accept(Map<Object, Collection<Object>> map, Object obj) {
        Object objApply = this.c.apply(obj);
        Collection<Object> collection = map.get(objApply);
        if (collection == null) {
            collection = (Collection) this.f4009a.apply(objApply);
            map.put(objApply, collection);
        }
        collection.add(this.b.apply(obj));
    }
}
