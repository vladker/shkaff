package org.apache.poi.hssf.model;

import java.util.List;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class RecordOrderer {
    private RecordOrderer() {
    }

    public static void addNewSheetRecord(List<RecordBase> list, RecordBase recordBase) {
        list.add(findSheetInsertPos(list, recordBase.getClass()), recordBase);
    }

    private static int findDataValidationTableInsertPos(List<RecordBase> list) {
        int size = list.size() - 1;
        if (!(list.get(size) instanceof EOFRecord)) {
            throw new IllegalStateException("Last sheet record should be EOFRecord");
        }
        while (size > 0) {
            int i5 = size - 1;
            RecordBase recordBase = list.get(i5);
            if (isDVTPriorRecord(recordBase)) {
                Record record = (Record) list.get(size);
                if (isDVTSubsequentRecord(record.getSid())) {
                    return size;
                }
                throw new IllegalStateException("Unexpected (" + record.getClass().getName() + ") found after (" + recordBase.getClass().getName() + ")");
            }
            Record record2 = (Record) recordBase;
            if (!isDVTSubsequentRecord(record2.getSid())) {
                throw new IllegalStateException("Unexpected (" + record2.getClass().getName() + ") while looking for DV Table insert pos");
            }
            size = i5;
        }
        return 0;
    }

    private static int findInsertPosForNewCondFormatTable(List<RecordBase> list) {
        short sid;
        for (int size = list.size() - 2; size >= 0; size--) {
            RecordBase recordBase = list.get(size);
            if (recordBase instanceof MergedCellsTable) {
                return size + 1;
            }
            if (!(recordBase instanceof DataValidityTable) && ((sid = ((Record) recordBase).getSid()) == 29 || sid == 65 || sid == 153 || sid == 160 || sid == 239 || sid == 351 || sid == 574)) {
                return size + 1;
            }
        }
        throw new IllegalArgumentException("Did not find Window2 record");
    }

    private static int findInsertPosForNewMergedRecordTable(List<RecordBase> list) {
        short sid;
        for (int size = list.size() - 2; size >= 0; size--) {
            RecordBase recordBase = list.get(size);
            if ((recordBase instanceof Record) && ((sid = ((Record) recordBase).getSid()) == 29 || sid == 65 || sid == 153 || sid == 160 || sid == 574)) {
                return size + 1;
            }
        }
        throw new IllegalArgumentException("Did not find Window2 record");
    }

    private static int findSheetInsertPos(List<RecordBase> list, Class<? extends RecordBase> cls) {
        if (cls == DataValidityTable.class) {
            return findDataValidationTableInsertPos(list);
        }
        if (cls == MergedCellsTable.class) {
            return findInsertPosForNewMergedRecordTable(list);
        }
        if (cls == ConditionalFormattingTable.class) {
            return findInsertPosForNewCondFormatTable(list);
        }
        if (cls == GutsRecord.class) {
            return getGutsRecordInsertPos(list);
        }
        if (cls == PageSettingsBlock.class) {
            return getPageBreakRecordInsertPos(list);
        }
        if (cls == WorksheetProtectionBlock.class) {
            return getWorksheetProtectionBlockInsertPos(list);
        }
        throw new IllegalArgumentException("Unexpected record class (" + cls.getName() + ")");
    }

    private static int getDimensionsIndex(List<RecordBase> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (list.get(i5) instanceof DimensionsRecord) {
                return i5;
            }
        }
        throw new IllegalArgumentException("DimensionsRecord not found");
    }

    private static int getGutsRecordInsertPos(List<RecordBase> list) {
        int dimensionsIndex = getDimensionsIndex(list) - 1;
        while (dimensionsIndex > 0) {
            int i5 = dimensionsIndex - 1;
            if (isGutsPriorRecord(list.get(i5))) {
                return dimensionsIndex;
            }
            dimensionsIndex = i5;
        }
        throw new IllegalArgumentException("Did not find insert point for GUTS");
    }

    private static int getPageBreakRecordInsertPos(List<RecordBase> list) {
        int dimensionsIndex = getDimensionsIndex(list) - 1;
        while (dimensionsIndex > 0) {
            int i5 = dimensionsIndex - 1;
            if (isPageBreakPriorRecord(list.get(i5))) {
                return dimensionsIndex;
            }
            dimensionsIndex = i5;
        }
        throw new IllegalArgumentException("Did not find insert point for GUTS");
    }

    private static int getWorksheetProtectionBlockInsertPos(List<RecordBase> list) {
        int dimensionsIndex = getDimensionsIndex(list);
        while (dimensionsIndex > 0) {
            int i5 = dimensionsIndex - 1;
            if (!isProtectionSubsequentRecord(list.get(i5))) {
                return dimensionsIndex;
            }
            dimensionsIndex = i5;
        }
        throw new IllegalStateException("did not find insert pos for protection block");
    }

    private static boolean isDVTPriorRecord(RecordBase recordBase) {
        short sid;
        return (recordBase instanceof MergedCellsTable) || (recordBase instanceof ConditionalFormattingTable) || (sid = ((Record) recordBase).getSid()) == 29 || sid == 65 || sid == 153 || sid == 160 || sid == 239 || sid == 351 || sid == 440 || sid == 442 || sid == 574 || sid == 2048;
    }

    private static boolean isDVTSubsequentRecord(short s6) {
        return s6 == 10 || s6 == 2146 || s6 == 2248 || s6 == 2151 || s6 == 2152;
    }

    public static boolean isEndOfRowBlock(int i5) {
        if (i5 == 10) {
            throw new IllegalArgumentException("Found EOFRecord before WindowTwoRecord was encountered");
        }
        if (i5 == 61 || i5 == 93 || i5 == 125 || i5 == 128 || i5 == 176 || i5 == 434 || i5 == 438 || i5 == 574 || i5 == 236 || i5 == 237) {
            return true;
        }
        return PageSettingsBlock.isComponentRecord(i5);
    }

    private static boolean isGutsPriorRecord(RecordBase recordBase) {
        if (!(recordBase instanceof Record)) {
            return false;
        }
        short sid = ((Record) recordBase).getSid();
        if (sid == 34 || sid == 130 || sid == 523 || sid == 2057 || sid == 42 || sid == 43 || sid == 94 || sid == 95) {
            return true;
        }
        switch (sid) {
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    private static boolean isPageBreakPriorRecord(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        short sid = ((Record) obj).getSid();
        if (sid == 34 || sid == 523 || sid == 549 || sid == 2057 || sid == 42 || sid == 43 || sid == 94 || sid == 95 || sid == 129 || sid == 130) {
            return true;
        }
        switch (sid) {
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    private static boolean isProtectionSubsequentRecord(Object obj) {
        if (obj instanceof ColumnInfoRecordsAggregate) {
            return true;
        }
        if (!(obj instanceof Record)) {
            return false;
        }
        short sid = ((Record) obj).getSid();
        return sid == 85 || sid == 144;
    }

    public static boolean isRowBlockRecord(int i5) {
        if (i5 == 6 || i5 == 253 || i5 == 513 || i5 == 520 || i5 == 545 || i5 == 566 || i5 == 638 || i5 == 1212) {
            return true;
        }
        switch (i5) {
            case Videoio.CAP_PROP_XI_LENS_FOCUS_DISTANCE /* 515 */:
            case Videoio.CAP_PROP_XI_LENS_FOCAL_LENGTH /* 516 */:
            case Videoio.CAP_PROP_XI_LENS_FEATURE_SELECTOR /* 517 */:
                return true;
            default:
                return false;
        }
    }
}
