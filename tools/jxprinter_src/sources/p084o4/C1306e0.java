package p084o4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: renamed from: o4.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1306e0 extends AbstractC1328p0 {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1306e0(b kSerializer, b vSerializer) {
        super(kSerializer, vSerializer);
        E.f(kSerializer, "kSerializer");
        E.f(vSerializer, "vSerializer");
        this.descriptor = new C1304d0(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builder, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap<Object, Object> a() {
        return new LinkedHashMap<>();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builderSize, reason: merged with bridge method [inline-methods] */
    public int b(LinkedHashMap<Object, Object> linkedHashMap) {
        E.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: checkCapacity, reason: merged with bridge method [inline-methods] */
    public void c(LinkedHashMap<Object, Object> linkedHashMap, int i5) {
        E.f(linkedHashMap, "<this>");
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
    public LinkedHashMap<Object, Object> e(Map<Object, Object> map) {
        E.f(map, "<this>");
        LinkedHashMap<Object, Object> linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap<>(map) : linkedHashMap;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public Map<Object, Object> f(LinkedHashMap<Object, Object> linkedHashMap) {
        E.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }

    @Override // p084o4.AbstractC1297a
    public Iterator<Map.Entry<Object, Object>> collectionIterator(Map<Object, Object> map) {
        E.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // p084o4.AbstractC1328p0
    public void insertKeyValuePair(LinkedHashMap<Object, Object> linkedHashMap, int i5, Object obj, Object obj2) {
        E.f(linkedHashMap, "<this>");
        linkedHashMap.put(obj, obj2);
    }
}
