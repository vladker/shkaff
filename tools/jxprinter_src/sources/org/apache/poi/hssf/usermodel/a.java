package org.apache.poi.hssf.usermodel;

import java.util.Map;
import java.util.function.Consumer;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.GenericRecordXmlWriter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7134a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object obj, int i5, Object obj2, Object obj3) {
        this.f7134a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7134a) {
            case 0:
                HSSFShapeFactory.createShapeTree((EscherContainerRecord) obj, (EscherAggregate) this.b, (HSSFShapeGroup) this.c, (DirectoryNode) this.d);
                break;
            default:
                ((GenericRecordXmlWriter) this.b).lambda$writeValue$3((String) this.c, this.d, (Map.Entry) obj);
                break;
        }
    }
}
