package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.poi.extractor.ExtractorProvider;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.poifs.filesystem.Entry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class l implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6963a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ l(ArrayList arrayList, int i5) {
        this.f6963a = i5;
        this.b = arrayList;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ArrayList arrayList;
        Object obj2;
        switch (this.f6963a) {
            case 0:
                arrayList = this.b;
                obj2 = (EscherRecord) obj;
                break;
            case 1:
                arrayList = this.b;
                obj2 = (EscherDggRecord.FileIdCluster) obj;
                break;
            case 2:
                arrayList = this.b;
                obj2 = (Entry) obj;
                break;
            case 3:
                arrayList = this.b;
                obj2 = (ExtractorProvider) obj;
                break;
            case 4:
                arrayList = this.b;
                obj2 = (CFRuleBase) obj;
                break;
            default:
                arrayList = this.b;
                obj2 = (ColumnInfoRecord) obj;
                break;
        }
        arrayList.add(obj2);
    }
}
