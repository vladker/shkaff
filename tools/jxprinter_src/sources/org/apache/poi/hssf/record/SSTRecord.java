package org.apache.poi.hssf.record;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IntMapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SSTRecord extends ContinuableRecord {
    private static final UnicodeString EMPTY_STRING = new UnicodeString("");
    public static final short sid = 252;
    private int[] bucketAbsoluteOffsets;
    private int[] bucketRelativeOffsets;
    private final SSTDeserializer deserializer;
    private int field_1_num_strings;
    private int field_2_num_unique_strings;
    private final IntMapper<UnicodeString> field_3_strings;

    public SSTRecord() {
        this.field_1_num_strings = 0;
        this.field_2_num_unique_strings = 0;
        IntMapper<UnicodeString> intMapper = new IntMapper<>();
        this.field_3_strings = intMapper;
        this.deserializer = new SSTDeserializer(intMapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.bucketAbsoluteOffsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this.bucketRelativeOffsets;
    }

    public int addString(UnicodeString unicodeString) {
        this.field_1_num_strings++;
        if (unicodeString == null) {
            unicodeString = EMPTY_STRING;
        }
        int index = this.field_3_strings.getIndex(unicodeString);
        if (index != -1) {
            return index;
        }
        int size = this.field_3_strings.size();
        this.field_2_num_unique_strings++;
        SSTDeserializer.addToStringTable(this.field_3_strings, unicodeString);
        return size;
    }

    public int calcExtSSTRecordSize() {
        return ExtSSTRecord.getRecordSizeForStrings(this.field_3_strings.size());
    }

    public int countStrings() {
        return this.field_3_strings.size();
    }

    public ExtSSTRecord createExtSSTRecord(int i5) {
        if (this.bucketAbsoluteOffsets == null || this.bucketRelativeOffsets == null) {
            throw new IllegalStateException("SST record has not yet been serialized.");
        }
        ExtSSTRecord extSSTRecord = new ExtSSTRecord();
        extSSTRecord.setNumStringsPerBucket((short) 8);
        int[] iArr = (int[]) this.bucketAbsoluteOffsets.clone();
        int[] iArr2 = (int[]) this.bucketRelativeOffsets.clone();
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = iArr[i6] + i5;
        }
        extSSTRecord.setBucketOffsets(iArr, iArr2);
        return extSSTRecord;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.K0
            public final /* synthetic */ SSTRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getNumStrings());
                    case 1:
                        return Integer.valueOf(this.b.getNumUniqueStrings());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.K0
            public final /* synthetic */ SSTRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getNumStrings());
                    case 1:
                        return Integer.valueOf(this.b.getNumUniqueStrings());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        IntMapper<UnicodeString> intMapper = this.field_3_strings;
        intMapper.getClass();
        A0 a6 = new A0(intMapper, 7);
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.K0
            public final /* synthetic */ SSTRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getNumStrings());
                    case 1:
                        return Integer.valueOf(this.b.getNumUniqueStrings());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("numStrings", supplier, "numUniqueStrings", supplier2, "strings", a6, "bucketAbsoluteOffsets", supplier3, "bucketRelativeOffsets", new Supplier(this) { // from class: org.apache.poi.hssf.record.K0
            public final /* synthetic */ SSTRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getNumStrings());
                    case 1:
                        return Integer.valueOf(this.b.getNumUniqueStrings());
                    case 2:
                        return this.b.lambda$getGenericProperties$0();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public int getNumStrings() {
        return this.field_1_num_strings;
    }

    public int getNumUniqueStrings() {
        return this.field_2_num_unique_strings;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public UnicodeString getString(int i5) {
        return this.field_3_strings.get(i5);
    }

    public Iterator<UnicodeString> getStrings() {
        return this.field_3_strings.iterator();
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        SSTSerializer sSTSerializer = new SSTSerializer(this.field_3_strings, getNumStrings(), getNumUniqueStrings());
        sSTSerializer.serialize(continuableRecordOutput);
        this.bucketAbsoluteOffsets = sSTSerializer.getBucketAbsoluteOffsets();
        this.bucketRelativeOffsets = sSTSerializer.getBucketRelativeOffsets();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SST;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SSTRecord copy() {
        return new SSTRecord(this);
    }

    public SSTRecord(SSTRecord sSTRecord) {
        super(sSTRecord);
        this.field_1_num_strings = sSTRecord.field_1_num_strings;
        this.field_2_num_unique_strings = sSTRecord.field_2_num_unique_strings;
        IntMapper<UnicodeString> intMapperCopy = sSTRecord.field_3_strings.copy();
        this.field_3_strings = intMapperCopy;
        this.deserializer = new SSTDeserializer(intMapperCopy);
        int[] iArr = sSTRecord.bucketAbsoluteOffsets;
        this.bucketAbsoluteOffsets = iArr == null ? null : (int[]) iArr.clone();
        int[] iArr2 = sSTRecord.bucketRelativeOffsets;
        this.bucketRelativeOffsets = iArr2 != null ? (int[]) iArr2.clone() : null;
    }

    public SSTRecord(RecordInputStream recordInputStream) {
        this.field_1_num_strings = recordInputStream.readInt();
        this.field_2_num_unique_strings = recordInputStream.readInt();
        IntMapper<UnicodeString> intMapper = new IntMapper<>();
        this.field_3_strings = intMapper;
        SSTDeserializer sSTDeserializer = new SSTDeserializer(intMapper);
        this.deserializer = sSTDeserializer;
        if (this.field_1_num_strings == 0) {
            this.field_2_num_unique_strings = 0;
        } else {
            sSTDeserializer.manufactureStrings(this.field_2_num_unique_strings, recordInputStream);
        }
    }
}
