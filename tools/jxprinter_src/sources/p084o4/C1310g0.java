package p084o4;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: renamed from: o4.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1310g0 extends AbstractC1346z {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1310g0(b eSerializer) {
        super(eSerializer);
        E.f(eSerializer, "eSerializer");
        this.descriptor = new C1308f0(eSerializer.getDescriptor());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builder, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<Object> a() {
        return new LinkedHashSet<>();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builderSize, reason: merged with bridge method [inline-methods] */
    public int b(LinkedHashSet<Object> linkedHashSet) {
        E.f(linkedHashSet, "<this>");
        return linkedHashSet.size();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: checkCapacity, reason: merged with bridge method [inline-methods] */
    public void c(LinkedHashSet<Object> linkedHashSet, int i5) {
        E.f(linkedHashSet, "<this>");
    }

    @Override // p084o4.AbstractC1344y, p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p084o4.AbstractC1344y
    /* JADX INFO: renamed from: insert, reason: merged with bridge method [inline-methods] */
    public void g(LinkedHashSet<Object> linkedHashSet, int i5, Object obj) {
        E.f(linkedHashSet, "<this>");
        linkedHashSet.add(obj);
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<Object> e(Set<Object> set) {
        E.f(set, "<this>");
        LinkedHashSet<Object> linkedHashSet = set instanceof LinkedHashSet ? (LinkedHashSet) set : null;
        return linkedHashSet == null ? new LinkedHashSet<>(set) : linkedHashSet;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public Set<Object> f(LinkedHashSet<Object> linkedHashSet) {
        E.f(linkedHashSet, "<this>");
        return linkedHashSet;
    }
}
