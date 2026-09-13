package org.jsoup.nodes;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7466a = 0;
    public final /* synthetic */ c b;

    public b(c cVar) {
        this.b = cVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        c cVar;
        while (true) {
            int i5 = this.f7466a;
            cVar = this.b;
            if (i5 >= cVar.f7467a || !c.l(cVar.b[i5])) {
                break;
            }
            this.f7466a++;
        }
        return this.f7466a < cVar.f7467a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.b;
        String[] strArr = cVar.b;
        int i5 = this.f7466a;
        a aVar = new a(strArr[i5], cVar.c[i5], cVar);
        this.f7466a++;
        return aVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i5 = this.f7466a - 1;
        this.f7466a = i5;
        this.b.n(i5);
    }
}
