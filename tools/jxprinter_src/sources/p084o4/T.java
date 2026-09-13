package p084o4;

import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends AbstractC1346z {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(b eSerializer) {
        super(eSerializer);
        E.f(eSerializer, "eSerializer");
        this.descriptor = new S(eSerializer.getDescriptor());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builder, reason: merged with bridge method [inline-methods] */
    public HashSet<Object> a() {
        return new HashSet<>();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builderSize, reason: merged with bridge method [inline-methods] */
    public int b(HashSet<Object> hashSet) {
        E.f(hashSet, "<this>");
        return hashSet.size();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: checkCapacity, reason: merged with bridge method [inline-methods] */
    public void c(HashSet<Object> hashSet, int i5) {
        E.f(hashSet, "<this>");
    }

    @Override // p084o4.AbstractC1344y, p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p084o4.AbstractC1344y
    /* JADX INFO: renamed from: insert, reason: merged with bridge method [inline-methods] */
    public void g(HashSet<Object> hashSet, int i5, Object obj) {
        E.f(hashSet, "<this>");
        hashSet.add(obj);
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public HashSet<Object> e(Set<Object> set) {
        E.f(set, "<this>");
        HashSet<Object> hashSet = set instanceof HashSet ? (HashSet) set : null;
        return hashSet == null ? new HashSet<>(set) : hashSet;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public Set<Object> f(HashSet<Object> hashSet) {
        E.f(hashSet, "<this>");
        return hashSet;
    }
}
