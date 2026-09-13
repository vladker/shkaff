package p084o4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends AbstractC1328p0 {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(b kSerializer, b vSerializer) {
        super(kSerializer, vSerializer);
        E.f(kSerializer, "kSerializer");
        E.f(vSerializer, "vSerializer");
        this.descriptor = new P(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builder, reason: merged with bridge method [inline-methods] */
    public HashMap<Object, Object> a() {
        return new HashMap<>();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builderSize, reason: merged with bridge method [inline-methods] */
    public int b(HashMap<Object, Object> map) {
        E.f(map, "<this>");
        return map.size() * 2;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: checkCapacity, reason: merged with bridge method [inline-methods] */
    public void c(HashMap<Object, Object> map, int i5) {
        E.f(map, "<this>");
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(Map<Object, Object> map) {
        E.f(map, "<this>");
        return map.size();
    }

    @Override // p084o4.AbstractC1328p0, p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public HashMap<Object, Object> e(Map<Object, Object> map) {
        E.f(map, "<this>");
        HashMap<Object, Object> map2 = map instanceof HashMap ? (HashMap) map : null;
        return map2 == null ? new HashMap<>(map) : map2;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public Map<Object, Object> f(HashMap<Object, Object> map) {
        E.f(map, "<this>");
        return map;
    }

    @Override // p084o4.AbstractC1297a
    public Iterator<Map.Entry<Object, Object>> collectionIterator(Map<Object, Object> map) {
        E.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // p084o4.AbstractC1328p0
    public void insertKeyValuePair(HashMap<Object, Object> map, int i5, Object obj, Object obj2) {
        E.f(map, "<this>");
        map.put(obj, obj2);
    }
}
