package org.apache.xmlbeans.impl.schema;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class l implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7377a;

    public /* synthetic */ l(int i5) {
        this.f7377a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7377a) {
            case 0:
                return ((StscComplexTypeResolver.CodeForNameEntry) obj).name;
            case 1:
                return StscComplexTypeResolver.lambda$static$5((StscComplexTypeResolver.CodeForNameEntry) obj);
            case 2:
                return ((StscComplexTypeResolver.CodeForNameEntry) obj).name;
            case 3:
                return StscComplexTypeResolver.lambda$static$7((StscComplexTypeResolver.CodeForNameEntry) obj);
            case 4:
                return StscTranslator.RedefinitionMaster.lambda$new$0((String) obj);
            case 5:
                return StscTranslator.RedefinitionMaster.lambda$new$1((String) obj);
            case 6:
                return StscTranslator.RedefinitionMaster.lambda$new$2((String) obj);
            case 7:
                return StscTranslator.RedefinitionMaster.lambda$new$3((String) obj);
            case 8:
                return ((SchemaType.Ref) obj).get();
            case 9:
                return ((SchemaModelGroup.Ref) obj).get();
            case 10:
                return ((SchemaAttributeGroup.Ref) obj).get();
            case 11:
                return ((SchemaIdentityConstraint.Ref) obj).get();
            case 12:
                return ((SchemaGlobalAttribute.Ref) obj).get();
            case 13:
                return ((SchemaGlobalElement.Ref) obj).get();
            case 14:
                return SchemaDependencies.lambda$registerContribution$1((String) obj);
            case 15:
                return ((List) obj).stream();
            case 16:
                return (String) ((Map.Entry) obj).getKey();
            case 17:
                return SchemaDependencies.lambda$registerDependency$0((String) obj);
            case 18:
                return ((SchemaComponent) obj).getName();
            case 19:
                return ((Map) obj).entrySet();
            case 20:
                return ((Set) obj).stream();
            case 21:
                return (QName) ((Map.Entry) obj).getKey();
            case 22:
                return (SchemaComponent.Ref) ((Map.Entry) obj).getValue();
            case 23:
                return ((SchemaComponent) obj).getComponentRef();
            case 24:
                return SchemaTypeSystemImpl.lambda$refHelper$2((SchemaComponent.Ref) obj);
            case 25:
                return SchemaTypeSystemImpl.buildComponentRefList((List<? extends SchemaComponent>) obj);
            case 26:
                return SchemaTypeSystemImpl.buildComponentRefMap((List<? extends SchemaComponent>) obj);
            case 27:
                return (Group) ((Supplier) obj).get();
            case 28:
                return ((SchemaLocalAttribute) obj).getName();
            default:
                return ((SchemaProperty) obj).getName();
        }
    }
}
