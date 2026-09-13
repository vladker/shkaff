package org.apache.poi.hssf.record;

import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.util.IntList;

/* JADX INFO: renamed from: org.apache.poi.hssf.record.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C1381b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7038a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1381b(Object obj, int i5) {
        this.f7038a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7038a) {
            case 0:
                return Short.valueOf(((AutoFilterInfoRecord) this.b).getNumEntries());
            case 1:
                return Short.valueOf(((BackupRecord) this.b).getBackup());
            case 2:
                return Short.valueOf(((BookBoolRecord) this.b).getSaveLinkValues());
            case 3:
                return Double.valueOf(((BottomMarginRecord) this.b).getMargin());
            case 4:
                return Short.valueOf(((CalcCountRecord) this.b).getIterations());
            case 5:
                return Short.valueOf(((CalcModeRecord) this.b).getCalcMode());
            case 6:
                return Short.valueOf(((CodepageRecord) this.b).getCodepage());
            case 7:
                return ((ContinueRecord) this.b).getData();
            case 8:
                return Short.valueOf(((DateWindow1904Record) this.b).getWindowing());
            case 9:
                return Integer.valueOf(((DefaultColWidthRecord) this.b).getColWidth());
            case 10:
                return Double.valueOf(((DeltaRecord) this.b).getMaxChange());
            case 11:
                return ((ExternSheetRecord) this.b).lambda$getGenericProperties$0();
            case 12:
                return ((Formula) this.b).getTokens();
            case 13:
                return Short.valueOf(((FnGroupCountRecord) this.b).getCount());
            case 14:
                return ((FtCblsSubRecord) this.b).lambda$getGenericProperties$0();
            case 15:
                return Short.valueOf(((FtCfSubRecord) this.b).getFlags());
            case 16:
                return Short.valueOf(((FtPioGrbitSubRecord) this.b).getFlags());
            case 17:
                return Boolean.valueOf(((GridsetRecord) this.b).getGridset());
            case 18:
                return ((GroupMarkerSubRecord) this.b).lambda$getGenericProperties$0();
            case 19:
                return Boolean.valueOf(((HCenterRecord) this.b).getHCenter());
            case 20:
                return ((HeaderFooterBase) this.b).getText();
            case 21:
                return ((HeaderFooterRecord) this.b).lambda$getGenericProperties$0();
            case 22:
                return Short.valueOf(((HideObjRecord) this.b).getHideObj());
            case 23:
                return ((IntList) this.b).toArray();
            case 24:
                return ((InterfaceHdrRecord) this.b).lambda$getGenericProperties$0();
            case 25:
                return Double.valueOf(((LeftMarginRecord) this.b).getMargin());
            case 26:
                return ((NoteStructureSubRecord) this.b).lambda$getGenericProperties$0();
            case 27:
                return Boolean.valueOf(((ObjectProtectRecord) this.b).getProtect());
            case 28:
                return ((OldStringRecord) this.b).getString();
            default:
                return ((PaletteRecord) this.b).lambda$getGenericProperties$0();
        }
    }
}
