package org.apache.xmlbeans.impl.store;

import java.util.Collection;
import java.util.Map;
import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7439a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ Object c;

    public /* synthetic */ r(Cursor cursor, Object obj, int i5) {
        this.f7439a = i5;
        this.b = cursor;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7439a) {
            case 0:
                this.b.lambda$clearBookmark$50(this.c);
                break;
            case 1:
                this.b.lambda$setBookmark$48((XmlCursor.XmlBookmark) this.c);
                break;
            case 2:
                this.b.lambda$getAllNamespaces$28((Map) this.c);
                break;
            default:
                this.b.lambda$getAllBookmarkRefs$51((Collection) this.c);
                break;
        }
    }
}
