package org.apache.xmlbeans.impl.schema;

import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class e implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7371a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(Object obj, Object obj2, int i5) {
        this.f7371a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7371a) {
            case 0:
                ((SchemaTypePool) this.b).lambda$writeHandlePool$0((XsbReader) this.c, (SchemaComponent) obj, (String) obj2);
                break;
            default:
                ((SchemaTypeSystemImpl) this.b).lambda$buildContainersHelper$1((BiConsumer) this.c, (QName) obj, (SchemaComponent.Ref) obj2);
                break;
        }
    }
}
