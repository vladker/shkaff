package org.apache.poi.util;

import java.io.Closeable;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class j implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7253a;
    public final /* synthetic */ Closeable b;

    public /* synthetic */ j(Closeable closeable, int i5) {
        this.f7253a = i5;
        this.b = closeable;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7253a) {
            case 0:
                ((GenericRecordXmlWriter) this.b).lambda$writeChildren$0((GenericRecord) obj);
                break;
            case 1:
                ((GenericRecordXmlWriter) this.b).writeProp((Map.Entry) obj);
                break;
            case 2:
                ((GenericRecordXmlWriter) this.b).lambda$printList$4(obj);
                break;
            default:
                ((GenericRecordJsonWriter) this.b).lambda$printList$3(obj);
                break;
        }
    }
}
