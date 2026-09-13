package W3;

import A3.C0130a;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H implements InterfaceC0233q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f798a;
    public final /* synthetic */ InterfaceC0233q b;
    public final /* synthetic */ Object c;

    public /* synthetic */ H(InterfaceC0233q interfaceC0233q, Object obj, int i5) {
        this.f798a = i5;
        this.b = interfaceC0233q;
        this.c = obj;
    }

    @Override // W3.InterfaceC0233q
    public final Iterator iterator() {
        switch (this.f798a) {
            case 0:
                return L.filter(this.b, new G(new kotlin.jvm.internal.P(), this.c, 0)).iterator();
            case 1:
                return L.filterNot(this.b, new C0130a((Object[]) this.c, 7)).iterator();
            case 2:
                Collection collectionConvertToListIfNotCollection = A3.O.convertToListIfNotCollection((Iterable) this.c);
                boolean zIsEmpty = collectionConvertToListIfNotCollection.isEmpty();
                InterfaceC0233q interfaceC0233q = this.b;
                return zIsEmpty ? interfaceC0233q.iterator() : L.filterNot(interfaceC0233q, new C0130a(collectionConvertToListIfNotCollection, 8)).iterator();
            case 3:
                InterfaceC0233q interfaceC0233q2 = (InterfaceC0233q) this.c;
                List list = L.toList(this.b);
                return list.isEmpty() ? interfaceC0233q2.iterator() : L.filterNot(interfaceC0233q2, new C0130a(list, 9)).iterator();
            default:
                List mutableList = L.toMutableList(this.b);
                A3.N.sortWith(mutableList, (Comparator) this.c);
                return mutableList.iterator();
        }
    }

    public H(Iterable iterable, InterfaceC0233q interfaceC0233q) {
        this.f798a = 2;
        this.c = iterable;
        this.b = interfaceC0233q;
    }
}
