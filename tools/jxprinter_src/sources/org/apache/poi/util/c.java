package org.apache.poi.util;

import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7246a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f7246a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7246a) {
            case 0:
                return GenericRecordJsonWriter.lambda$writeValue$2(this.b, (Map.Entry) obj);
            default:
                return GenericRecordXmlWriter.lambda$writeValue$2(this.b, (Map.Entry) obj);
        }
    }
}
