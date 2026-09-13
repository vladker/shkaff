package org.apache.xmlbeans.impl.store;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1459u implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7442a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1459u(Object obj, Object obj2, int i5) {
        this.f7442a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7442a) {
            case 0:
                return ((Cursor) this.b).lambda$toBookmark$22((XmlCursor.XmlBookmark) this.c);
            default:
                return DomImpl.lambda$syncWrapVoid$109((Consumer) this.b, (DomImpl.Dom) this.c);
        }
    }
}
