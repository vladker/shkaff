package p084o4;

import P3.a;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1322m0 implements Map.Entry, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6468a;
    public final Object b;

    public C1322m0(Object obj, Object obj2) {
        this.f6468a = obj;
        this.b = obj2;
    }

    public final C1322m0 copy(Object obj, Object obj2) {
        return new C1322m0(obj, obj2);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1322m0)) {
            return false;
        }
        C1322m0 c1322m0 = (C1322m0) obj;
        return E.a(this.f6468a, c1322m0.f6468a) && E.a(this.b, c1322m0.b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f6468a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f6468a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "MapEntry(key=" + this.f6468a + ", value=" + this.b + ')';
    }
}
