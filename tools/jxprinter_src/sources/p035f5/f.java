package p035f5;

import g5.b;
import g5.d;
import java.util.ArrayList;
import java.util.Objects;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f3978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f3979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3980m;

    public final void G(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            arrayList2.add(c.r(this.f3978k.f4026a, (b) obj));
        }
        c.q(arrayList2, this.f3973j);
        int size2 = arrayList.size();
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            b bVar = (b) obj2;
            this.f3979l.b.put(AbstractC1282k.a(bVar.f4024a), bVar);
        }
    }

    public final void H(ArrayList arrayList) {
        Objects.toString(arrayList);
        F(this.f3978k.f4026a, arrayList);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            this.f3979l.b.remove(AbstractC1282k.a((String) obj));
        }
    }
}
