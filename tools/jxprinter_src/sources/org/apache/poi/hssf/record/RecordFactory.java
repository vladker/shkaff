package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RecordFactory {
    private static final int DEFAULT_MAX_NUMBER_OF_RECORDS = 5000000;
    private static int MAX_NUMBER_OF_RECORDS = 5000000;
    private static final int NUM_RECORDS = 512;

    private RecordFactory() {
    }

    public static BlankRecord[] convertBlankRecords(MulBlankRecord mulBlankRecord) {
        BlankRecord[] blankRecordArr = new BlankRecord[mulBlankRecord.getNumColumns()];
        for (int i5 = 0; i5 < mulBlankRecord.getNumColumns(); i5++) {
            BlankRecord blankRecord = new BlankRecord();
            blankRecord.setColumn((short) (mulBlankRecord.getFirstColumn() + i5));
            blankRecord.setRow(mulBlankRecord.getRow());
            blankRecord.setXFIndex(mulBlankRecord.getXFAt(i5));
            blankRecordArr[i5] = blankRecord;
        }
        return blankRecordArr;
    }

    public static NumberRecord[] convertRKRecords(MulRKRecord mulRKRecord) {
        int numColumns = mulRKRecord.getNumColumns();
        if (numColumns < 0) {
            throw new RecordFormatException(AbstractC0157z.k(numColumns, "Cannot create RKRecords with negative number of columns: "));
        }
        NumberRecord[] numberRecordArr = new NumberRecord[numColumns];
        for (int i5 = 0; i5 < numColumns; i5++) {
            NumberRecord numberRecord = new NumberRecord();
            numberRecord.setColumn((short) (mulRKRecord.getFirstColumn() + i5));
            numberRecord.setRow(mulRKRecord.getRow());
            numberRecord.setXFIndex(mulRKRecord.getXFAt(i5));
            numberRecord.setValue(mulRKRecord.getRKNumberAt(i5));
            numberRecordArr[i5] = numberRecord;
        }
        return numberRecordArr;
    }

    public static NumberRecord convertToNumberRecord(RKRecord rKRecord) {
        NumberRecord numberRecord = new NumberRecord();
        numberRecord.setColumn(rKRecord.getColumn());
        numberRecord.setRow(rKRecord.getRow());
        numberRecord.setXFIndex(rKRecord.getXFIndex());
        numberRecord.setValue(rKRecord.getRKNumber());
        return numberRecord;
    }

    public static Record[] createRecord(RecordInputStream recordInputStream) {
        Record recordCreateSingleRecord = createSingleRecord(recordInputStream);
        if (recordCreateSingleRecord instanceof DBCellRecord) {
            return new Record[]{null};
        }
        if (recordCreateSingleRecord instanceof RKRecord) {
            return new Record[]{convertToNumberRecord((RKRecord) recordCreateSingleRecord)};
        }
        return recordCreateSingleRecord instanceof MulRKRecord ? convertRKRecords((MulRKRecord) recordCreateSingleRecord) : new Record[]{recordCreateSingleRecord};
    }

    public static List<Record> createRecords(InputStream inputStream) {
        ArrayList arrayList = new ArrayList(512);
        RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(inputStream, true);
        while (true) {
            Record recordNextRecord = recordFactoryInputStream.nextRecord();
            if (recordNextRecord == null) {
                return arrayList;
            }
            arrayList.add(recordNextRecord);
            IOUtils.safelyAllocateCheck(arrayList.size(), MAX_NUMBER_OF_RECORDS);
        }
    }

    public static Record createSingleRecord(RecordInputStream recordInputStream) {
        HSSFRecordTypes hSSFRecordTypesForSID = HSSFRecordTypes.forSID(recordInputStream.getSid());
        if (!hSSFRecordTypesForSID.isParseable()) {
            hSSFRecordTypesForSID = HSSFRecordTypes.UNKNOWN;
        }
        return hSSFRecordTypesForSID.recordConstructor.apply(recordInputStream);
    }

    public static short[] getAllKnownRecordSIDs() {
        int[] array = Arrays.stream(HSSFRecordTypes.values()).mapToInt(new G0()).toArray();
        short[] sArr = new short[array.length];
        for (int i5 = 0; i5 < array.length; i5++) {
            sArr[i5] = (short) array[i5];
        }
        return sArr;
    }

    public static int getMaxNumberOfRecords() {
        return MAX_NUMBER_OF_RECORDS;
    }

    public static Class<? extends Record> getRecordClass(int i5) {
        return HSSFRecordTypes.forSID(i5).clazz;
    }

    public static void setMaxNumberOfRecords(int i5) {
        MAX_NUMBER_OF_RECORDS = i5;
    }
}
