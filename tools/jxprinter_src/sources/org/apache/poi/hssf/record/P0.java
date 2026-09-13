package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class P0 implements SubRecord.SubRecordTypes.RecordConstructor, HSSFRecordTypes.RecordConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7013a;

    public /* synthetic */ P0(int i5) {
        this.f7013a = i5;
    }

    @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
    public Record apply(RecordInputStream recordInputStream) {
        switch (this.f7013a) {
            case 1:
                return new UnknownRecord(recordInputStream);
            case 2:
                return new CRNCountRecord(recordInputStream);
            case 3:
                return new CRNRecord(recordInputStream);
            case 4:
                return new WriteAccessRecord(recordInputStream);
            case 5:
                return new CalcCountRecord(recordInputStream);
            case 6:
                return new FileSharingRecord(recordInputStream);
            case 7:
                return new ObjRecord(recordInputStream);
            case 8:
                return new UncalcedRecord(recordInputStream);
            case 9:
                return new SaveRecalcRecord(recordInputStream);
            case 10:
                return new ObjectProtectRecord(recordInputStream);
            case 11:
                return new ColumnInfoRecord(recordInputStream);
            case 12:
                return new TableRecord(recordInputStream);
            case 13:
                return new GutsRecord(recordInputStream);
            case 14:
                return new WSBoolRecord(recordInputStream);
            case 15:
                return new GridsetRecord(recordInputStream);
            case 16:
                return new HCenterRecord(recordInputStream);
            case 17:
                return new CalcModeRecord(recordInputStream);
            case 18:
                return new VCenterRecord(recordInputStream);
            case 19:
                return new BoundSheetRecord(recordInputStream);
            case 20:
                return new WriteProtectRecord(recordInputStream);
            case 21:
                return new CountryRecord(recordInputStream);
            case 22:
                return new HideObjRecord(recordInputStream);
            case 23:
                return new PasswordRecord(recordInputStream);
            case 24:
                return new PaletteRecord(recordInputStream);
            case 25:
                return new FnGroupCountRecord(recordInputStream);
            case 26:
                return new AutoFilterInfoRecord(recordInputStream);
            case 27:
                return new SCLRecord(recordInputStream);
            case 28:
                return new PrintSetupRecord(recordInputStream);
            default:
                return new PrecisionRecord(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.SubRecord.SubRecordTypes.RecordConstructor
    public SubRecord apply(LittleEndianInput littleEndianInput, int i5, int i6) {
        return new SubRecord.UnknownSubRecord(littleEndianInput, i5, i6);
    }
}
