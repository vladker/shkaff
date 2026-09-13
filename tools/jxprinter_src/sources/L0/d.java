package L0;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends ArrayMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        this.f400a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final int hashCode() {
        if (this.f400a == 0) {
            this.f400a = super.hashCode();
        }
        return this.f400a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f400a = 0;
        return super.put(obj, obj2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final void putAll(SimpleArrayMap simpleArrayMap) {
        this.f400a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object removeAt(int i5) {
        this.f400a = 0;
        return super.removeAt(i5);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object setValueAt(int i5, Object obj) {
        this.f400a = 0;
        return super.setValueAt(i5, obj);
    }
}
