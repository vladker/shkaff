package org.apache.xmlbeans.impl.schema;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7368a;

    public /* synthetic */ b(int i5) {
        this.f7368a = i5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7368a) {
            case 0:
                return Objects.nonNull((List) obj);
            case 1:
                return Objects.nonNull((Group) obj);
            default:
                return StscComplexTypeResolver.lambda$extractElementModel$1((SchemaProperty) obj);
        }
    }
}
