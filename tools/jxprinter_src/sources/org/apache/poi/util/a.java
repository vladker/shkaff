package org.apache.poi.util;

import java.util.Map;
import java.util.function.Predicate;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7244a;
    public final /* synthetic */ GenericRecordJsonWriter b;

    public /* synthetic */ a(GenericRecordJsonWriter genericRecordJsonWriter, int i5) {
        this.f7244a = i5;
        this.b = genericRecordJsonWriter;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7244a) {
            case 0:
                return this.b.lambda$writeProperties$0((Map.Entry) obj);
            default:
                return this.b.lambda$writeChildren$1((GenericRecord) obj);
        }
    }
}
