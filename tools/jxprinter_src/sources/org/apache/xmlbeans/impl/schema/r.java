package org.apache.xmlbeans.impl.schema;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.SchemaComponent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class r implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7383a;
    public final /* synthetic */ XsbReader b;

    public /* synthetic */ r(XsbReader xsbReader, int i5) {
        this.f7383a = i5;
        this.b = xsbReader;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        String str = (String) obj;
        switch (this.f7383a) {
            case 0:
                this.b.lambda$writeClassnameMap$0(str, (SchemaComponent.Ref) obj2);
                break;
            default:
                this.b.lambda$writeIdConstraintData$1(str, (String) obj2);
                break;
        }
    }
}
