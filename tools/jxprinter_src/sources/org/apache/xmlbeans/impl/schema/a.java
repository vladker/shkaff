package org.apache.xmlbeans.impl.schema;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7367a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f7367a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7367a) {
            case 0:
                return (List) ((Map) this.b).get((String) obj);
            case 1:
                return ((SchemaTypeLoaderImpl) this.b).lambda$getTypeSystemOnClasspath$0((String) obj);
            default:
                return StscComplexTypeResolver.lambda$buildAttributePropertyModelByQName$3((SchemaType) this.b, (SchemaLocalAttribute) obj);
        }
    }
}
