package p072m4;

import A3.AbstractC0139g;
import P3.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class t implements Iterator, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6173a;
    public int b;
    public final /* synthetic */ Object c;

    public t(AbstractC0139g abstractC0139g) {
        this.f6173a = 2;
        this.c = abstractC0139g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f6173a) {
            case 0:
                return this.b > 0;
            case 1:
                return this.b > 0;
            default:
                return this.b < ((AbstractC0139g) this.c).b();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f6173a) {
            case 0:
                r rVar = (r) this.c;
                int iB = rVar.b();
                int i5 = this.b;
                this.b = i5 - 1;
                return rVar.getElementDescriptor(iB - i5);
            case 1:
                r rVar2 = (r) this.c;
                int iB2 = rVar2.b();
                int i6 = this.b;
                this.b = i6 - 1;
                return rVar2.getElementName(iB2 - i6);
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                AbstractC0139g abstractC0139g = (AbstractC0139g) this.c;
                int i7 = this.b;
                this.b = i7 + 1;
                return abstractC0139g.get(i7);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f6173a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public t(r rVar, int i5) {
        this.f6173a = i5;
        switch (i5) {
            case 1:
                this.c = rVar;
                this.b = rVar.b();
                break;
            default:
                this.c = rVar;
                this.b = rVar.b();
                break;
        }
    }
}
