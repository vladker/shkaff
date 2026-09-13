package org.apache.xmlbeans.impl.schema;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class f implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7372a;

    public /* synthetic */ f(int i5) {
        this.f7372a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7372a) {
            case 0:
                return SchemaTypeSystemImpl.lambda$globalAttributes$8(i5);
            case 1:
                return SchemaTypeSystemImpl.lambda$redefinedAttributeGroups$12(i5);
            case 2:
                return SchemaTypeSystemImpl.lambda$modelGroups$9(i5);
            case 3:
                return SchemaTypeSystemImpl.lambda$documentTypes$5(i5);
            case 4:
                return SchemaTypeSystemImpl.lambda$attributeTypes$6(i5);
            case 5:
                return SchemaTypeSystemImpl.lambda$globalElements$7(i5);
            case 6:
                return SchemaTypeSystemImpl.lambda$globalTypes$3(i5);
            case 7:
                return SchemaTypeSystemImpl.lambda$attributeGroups$11(i5);
            case 8:
                return SchemaTypeSystemImpl.lambda$identityConstraints$13(i5);
            case 9:
                return SchemaTypeSystemImpl.lambda$redefinedGlobalTypes$4(i5);
            case 10:
                return SchemaTypeSystemImpl.lambda$redefinedModelGroups$10(i5);
            case 11:
                return StscComplexTypeResolver.lambda$makeRefArray$0(i5);
            case 12:
                return StscResolver.lambda$makeRefArray$0(i5);
            default:
                return StscSimpleTypeResolver.lambda$makeRefArray$0(i5);
        }
    }
}
