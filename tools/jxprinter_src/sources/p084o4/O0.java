package p084o4;

import A3.AbstractC0151t;
import V3.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O0 extends AbstractC1344y {
    private final r descriptor;
    private final c kClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O0(c kClass, b eSerializer) {
        super(eSerializer);
        E.f(kClass, "kClass");
        E.f(eSerializer, "eSerializer");
        this.kClass = kClass;
        this.descriptor = new C1303d(eSerializer.getDescriptor());
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builder, reason: merged with bridge method [inline-methods] */
    public ArrayList<Object> a() {
        return new ArrayList<>();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: builderSize, reason: merged with bridge method [inline-methods] */
    public int b(ArrayList<Object> arrayList) {
        E.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: checkCapacity, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList<Object> arrayList, int i5) {
        E.f(arrayList, "<this>");
        arrayList.ensureCapacity(i5);
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: collectionSize, reason: merged with bridge method [inline-methods] */
    public int d(Object[] objArr) {
        E.f(objArr, "<this>");
        return objArr.length;
    }

    @Override // p084o4.AbstractC1344y, p084o4.AbstractC1297a, p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.descriptor;
    }

    @Override // p084o4.AbstractC1344y
    /* JADX INFO: renamed from: insert, reason: merged with bridge method [inline-methods] */
    public void g(ArrayList<Object> arrayList, int i5, Object obj) {
        E.f(arrayList, "<this>");
        arrayList.add(i5, obj);
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public ArrayList<Object> e(Object[] objArr) {
        E.f(objArr, "<this>");
        return new ArrayList<>(AbstractC0151t.asList(objArr));
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public Object[] f(ArrayList<Object> arrayList) {
        E.f(arrayList, "<this>");
        return C0.toNativeArrayImpl(arrayList, this.kClass);
    }

    @Override // p084o4.AbstractC1297a
    public Iterator<Object> collectionIterator(Object[] objArr) {
        E.f(objArr, "<this>");
        return AbstractC1095i.iterator(objArr);
    }
}
