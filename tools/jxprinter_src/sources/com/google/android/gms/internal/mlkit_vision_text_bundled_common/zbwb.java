package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.collection.a;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbwb implements Map.Entry, Comparable {
    final /* synthetic */ zbwh zba;
    private final Comparable zbb;
    private Object zbc;

    public zbwb(zbwh zbwhVar, Comparable comparable, Object obj) {
        this.zba = zbwhVar;
        this.zbb = comparable;
        this.zbc = obj;
    }

    private static final boolean zbb(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zbb.compareTo(((zbwb) obj).zbb);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zbb(this.zbb, entry.getKey()) && zbb(this.zbc, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zbb;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zbc;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zbb;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.zbc;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.zba.zbo();
        Object obj2 = this.zbc;
        this.zbc = obj;
        return obj2;
    }

    public final String toString() {
        return a.o(String.valueOf(this.zbb), "=", String.valueOf(this.zbc));
    }

    public final Comparable zba() {
        return this.zbb;
    }
}
