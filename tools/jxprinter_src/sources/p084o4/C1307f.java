package p084o4;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;

/* JADX INFO: renamed from: o4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1307f extends AbstractC1346z {
    private final r descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1307f(b element) {
        super(element);
        E.f(element, "element");
        this.descriptor = new C1305e(element.getDescriptor());
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
    public ArrayList<Object> e(List<Object> list) {
        E.f(list, "<this>");
        ArrayList<Object> arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList<>(list) : arrayList;
    }

    @Override // p084o4.AbstractC1297a
    /* JADX INFO: renamed from: toResult, reason: merged with bridge method [inline-methods] */
    public List<Object> f(ArrayList<Object> arrayList) {
        E.f(arrayList, "<this>");
        return arrayList;
    }
}
