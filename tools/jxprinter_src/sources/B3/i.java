package B3;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Map.Entry, P3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94a;
    public final int b;
    private final m map;

    public i(m map, int i5) {
        E.f(map, "map");
        this.map = map;
        this.f94a = i5;
        this.b = map.d;
    }

    public final void b() {
        if (this.map.d != this.b) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return E.a(entry.getKey(), getKey()) && E.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        b();
        return this.map.keysArray[this.f94a];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        b();
        Object[] objArr = this.map.valuesArray;
        E.c(objArr);
        return objArr[this.f94a];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        b();
        this.map.h();
        Object[] objArrG = this.map.g();
        int i5 = this.f94a;
        Object obj2 = objArrG[i5];
        objArrG[i5] = obj;
        return obj2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(Chars.EQ);
        sb.append(getValue());
        return sb.toString();
    }
}
