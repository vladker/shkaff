package org.apache.xmlbeans.impl.schema;

import java.util.function.BinaryOperator;
import org.apache.xmlbeans.SchemaComponent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class i implements BinaryOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7374a;

    public /* synthetic */ i(int i5) {
        this.f7374a = i5;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f7374a) {
            case 0:
                return SchemaTypeSystemImpl.lambda$buildComponentRefMap$0((SchemaComponent.Ref) obj, (SchemaComponent.Ref) obj2);
            default:
                return StscComplexTypeResolver.lambda$throwingMerger$2(obj, obj2);
        }
    }
}
