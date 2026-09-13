package A3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements o0 {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final O3.l f1default;
    private final Map<Object, Object> map;

    public p0(Map<Object, Object> map, O3.l lVar) {
        kotlin.jvm.internal.E.f(map, "map");
        kotlin.jvm.internal.E.f(lVar, "default");
        this.map = map;
        this.f1default = lVar;
    }

    @Override // A3.g0
    public final Object a(Object obj) {
        Map<Object, Object> map = getMap();
        Object obj2 = map.get(obj);
        return (obj2 != null || map.containsKey(obj)) ? obj2 : this.f1default.invoke(obj);
    }

    @Override // java.util.Map
    public final void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return getMap().get(obj);
    }

    public Set<Map.Entry<Object, Object>> getEntries() {
        return getMap().entrySet();
    }

    public Set<Object> getKeys() {
        return getMap().keySet();
    }

    @Override // A3.o0, A3.g0
    public Map<Object, Object> getMap() {
        return this.map;
    }

    public Collection<Object> getValues() {
        return getMap().values();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return getMap().put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map<Object, Object> from) {
        kotlin.jvm.internal.E.f(from, "from");
        getMap().putAll(from);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return getMap().remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return getMap().size();
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}
