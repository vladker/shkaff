package org.apache.xmlbeans.impl.schema;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7369a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f7369a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7369a) {
            case 0:
                return SchemaDependencies.lambda$getNamespacesTouched$3((Set) this.b, (Map.Entry) obj);
            case 1:
                return ((Set) this.b).contains((String) obj);
            default:
                return SchemaDependencies.lambda$isFileRepresented$2((String) this.b, (List) obj);
        }
    }
}
