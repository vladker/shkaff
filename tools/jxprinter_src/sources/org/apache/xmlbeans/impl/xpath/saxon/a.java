package org.apache.xmlbeans.impl.xpath.saxon;

import java.util.function.BiConsumer;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.sxpath.IndependentContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7461a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f7461a = i5;
        this.b = obj;
    }

    private final void a(Object obj, Object obj2) {
        ((IndependentContext) this.b).declareNamespace((String) obj, (String) obj2);
    }

    private final void b(Object obj, Object obj2) {
        ((StaticQueryContext) this.b).declareNamespace((String) obj, (String) obj2);
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7461a) {
            case 0:
                a(obj, obj2);
                break;
            default:
                b(obj, obj2);
                break;
        }
    }
}
