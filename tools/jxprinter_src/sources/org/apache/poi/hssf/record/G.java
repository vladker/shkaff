package org.apache.poi.hssf.record;

import java.util.function.Function;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class G implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6995a;

    public /* synthetic */ G(int i5) {
        this.f6995a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6995a) {
            case 0:
                return new ExternSheetRecord.RefSubRecord((ExternSheetRecord.RefSubRecord) obj);
            case 1:
                return new PaletteRecord.PColor((PaletteRecord.PColor) obj);
            case 2:
                return new ExtSSTRecord.InfoSubRecord((ExtSSTRecord.InfoSubRecord) obj);
            case 3:
                return ((CellRangeAddress) obj).copy();
            case 4:
                return Short.valueOf(((HSSFRecordTypes) obj).getSid());
            case 5:
                return ((SubRecord) obj).copy();
            case 6:
                return ((CellRangeAddress8Bit) obj).copy();
            default:
                return Short.valueOf(((SubRecord.SubRecordTypes) obj).getSid());
        }
    }
}
