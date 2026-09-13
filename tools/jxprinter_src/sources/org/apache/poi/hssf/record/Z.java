package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Z implements HSSFRecordTypes.RecordConstructor, SubRecord.SubRecordTypes.RecordConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7031a;

    public /* synthetic */ Z(int i5) {
        this.f7031a = i5;
    }

    @Override // org.apache.poi.hssf.record.HSSFRecordTypes.RecordConstructor
    public Record apply(RecordInputStream recordInputStream) {
        switch (this.f7031a) {
            case 0:
                return new DateWindow1904Record(recordInputStream);
            case 1:
                return new ExternalNameRecord(recordInputStream);
            case 2:
                return new LeftMarginRecord(recordInputStream);
            case 3:
                return new RightMarginRecord(recordInputStream);
            case 4:
                return new TopMarginRecord(recordInputStream);
            case 5:
                return new BottomMarginRecord(recordInputStream);
            case 6:
                return new PrintHeadersRecord(recordInputStream);
            case 7:
                return new PrintGridlinesRecord(recordInputStream);
            case 8:
                return new ArrayRecord(recordInputStream);
            case 9:
                return new FilePassRecord(recordInputStream);
            case 10:
                return new FontRecord(recordInputStream);
            case 11:
                return new EOFRecord(recordInputStream);
            case 12:
                return new ContinueRecord(recordInputStream);
            case 13:
                return new WindowOneRecord(recordInputStream);
            case 14:
                return new BackupRecord(recordInputStream);
            case 15:
                return new PaneRecord(recordInputStream);
            case 16:
                return new CodepageRecord(recordInputStream);
            case 17:
                return new DConRefRecord(recordInputStream);
            case 18:
                return new DefaultColWidthRecord(recordInputStream);
            default:
                return new DefaultRowHeightRecord(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.SubRecord.SubRecordTypes.RecordConstructor
    public SubRecord apply(LittleEndianInput littleEndianInput, int i5, int i6) {
        switch (this.f7031a) {
            case 20:
                return new CommonObjectDataSubRecord(littleEndianInput, i5, i6);
            case 21:
                return new EndSubRecord(littleEndianInput, i5, i6);
            case 22:
                return new GroupMarkerSubRecord(littleEndianInput, i5, i6);
            case 23:
                return new FtCfSubRecord(littleEndianInput, i5, i6);
            case 24:
                return new FtPioGrbitSubRecord(littleEndianInput, i5, i6);
            case 25:
                return new EmbeddedObjectRefSubRecord(littleEndianInput, i5, i6);
            case 26:
                return new FtCblsSubRecord(littleEndianInput, i5, i6);
            case 27:
                return new NoteStructureSubRecord(littleEndianInput, i5, i6);
            default:
                return new LbsDataSubRecord(littleEndianInput, i5, i6);
        }
    }
}
