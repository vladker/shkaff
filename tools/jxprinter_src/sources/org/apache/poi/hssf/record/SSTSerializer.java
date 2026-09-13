package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.IntMapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class SSTSerializer {
    private final int _numStrings;
    private final int _numUniqueStrings;
    private final int[] bucketAbsoluteOffsets;
    private final int[] bucketRelativeOffsets;
    private final IntMapper<UnicodeString> strings;

    public SSTSerializer(IntMapper<UnicodeString> intMapper, int i5, int i6) {
        this.strings = intMapper;
        this._numStrings = i5;
        this._numUniqueStrings = i6;
        int numberOfInfoRecsForStrings = ExtSSTRecord.getNumberOfInfoRecsForStrings(intMapper.size());
        this.bucketAbsoluteOffsets = new int[numberOfInfoRecsForStrings];
        this.bucketRelativeOffsets = new int[numberOfInfoRecsForStrings];
    }

    private UnicodeString getUnicodeString(int i5) {
        return getUnicodeString(this.strings, i5);
    }

    public int[] getBucketAbsoluteOffsets() {
        return this.bucketAbsoluteOffsets;
    }

    public int[] getBucketRelativeOffsets() {
        return this.bucketRelativeOffsets;
    }

    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeInt(this._numStrings);
        continuableRecordOutput.writeInt(this._numUniqueStrings);
        for (int i5 = 0; i5 < this.strings.size(); i5++) {
            if (i5 % 8 == 0) {
                int totalSize = continuableRecordOutput.getTotalSize();
                int i6 = i5 / 8;
                if (i6 < 128) {
                    this.bucketAbsoluteOffsets[i6] = totalSize;
                    this.bucketRelativeOffsets[i6] = totalSize;
                }
            }
            getUnicodeString(i5).serialize(continuableRecordOutput);
        }
    }

    private static UnicodeString getUnicodeString(IntMapper<UnicodeString> intMapper, int i5) {
        return intMapper.get(i5);
    }
}
