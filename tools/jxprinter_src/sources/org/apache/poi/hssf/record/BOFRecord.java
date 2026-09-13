package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BOFRecord extends StandardRecord {
    public static final int BUILD = 4307;
    public static final int BUILD_YEAR = 1996;
    public static final int HISTORY_MASK = 65;
    public static final int TYPE_CHART = 32;
    public static final int TYPE_EXCEL_4_MACRO = 64;
    public static final int TYPE_VB_MODULE = 6;
    public static final int TYPE_WORKBOOK = 5;
    public static final int TYPE_WORKSHEET = 16;
    public static final int TYPE_WORKSPACE_FILE = 256;
    public static final int VERSION = 1536;
    public static final short biff2_sid = 9;
    public static final short biff3_sid = 521;
    public static final short biff4_sid = 1033;
    public static final short biff5_sid = 2057;
    public static final short sid = 2057;
    private int field_1_version;
    private int field_2_type;
    private int field_3_build;
    private int field_4_year;
    private int field_5_history;
    private int field_6_rversion;

    public BOFRecord() {
    }

    public static BOFRecord createSheetBOF() {
        return new BOFRecord(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTypeName() {
        int i5 = this.field_2_type;
        if (i5 == 5) {
            return "workbook";
        }
        if (i5 == 6) {
            return "vb module";
        }
        if (i5 == 16) {
            return "worksheet";
        }
        if (i5 == 32) {
            return "chart";
        }
        if (i5 != 64) {
            return i5 != 256 ? "#error unknown type#" : "workspace file";
        }
        return "excel 4 macro";
    }

    public int getBuild() {
        return this.field_3_build;
    }

    public int getBuildYear() {
        return this.field_4_year;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("version", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("type", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("typeName", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("build", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("buildYear", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("history", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("requiredVersion", new Supplier(this) { // from class: org.apache.poi.hssf.record.c
            public final /* synthetic */ BOFRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getVersion());
                    case 1:
                        return Integer.valueOf(this.b.getType());
                    case 2:
                        return this.b.getTypeName();
                    case 3:
                        return Integer.valueOf(this.b.getBuild());
                    case 4:
                        return Integer.valueOf(this.b.getBuildYear());
                    case 5:
                        return Integer.valueOf(this.b.getHistoryBitMask());
                    default:
                        return Integer.valueOf(this.b.getRequiredVersion());
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public int getHistoryBitMask() {
        return this.field_5_history;
    }

    public int getRequiredVersion() {
        return this.field_6_rversion;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 2057;
    }

    public int getType() {
        return this.field_2_type;
    }

    public int getVersion() {
        return this.field_1_version;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getVersion());
        littleEndianOutput.writeShort(getType());
        littleEndianOutput.writeShort(getBuild());
        littleEndianOutput.writeShort(getBuildYear());
        littleEndianOutput.writeInt(getHistoryBitMask());
        littleEndianOutput.writeInt(getRequiredVersion());
    }

    public void setBuild(int i5) {
        this.field_3_build = i5;
    }

    public void setBuildYear(int i5) {
        this.field_4_year = i5;
    }

    public void setHistoryBitMask(int i5) {
        this.field_5_history = i5;
    }

    public void setRequiredVersion(int i5) {
        this.field_6_rversion = i5;
    }

    public void setType(int i5) {
        this.field_2_type = i5;
    }

    public void setVersion(int i5) {
        this.field_1_version = i5;
    }

    public BOFRecord(BOFRecord bOFRecord) {
        super(bOFRecord);
        this.field_1_version = bOFRecord.field_1_version;
        this.field_2_type = bOFRecord.field_2_type;
        this.field_3_build = bOFRecord.field_3_build;
        this.field_4_year = bOFRecord.field_4_year;
        this.field_5_history = bOFRecord.field_5_history;
        this.field_6_rversion = bOFRecord.field_6_rversion;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOF;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public BOFRecord copy() {
        return new BOFRecord(this);
    }

    private BOFRecord(int i5) {
        this.field_1_version = VERSION;
        this.field_2_type = i5;
        this.field_3_build = BUILD;
        this.field_4_year = BUILD_YEAR;
        this.field_5_history = 1;
        this.field_6_rversion = VERSION;
    }

    public BOFRecord(RecordInputStream recordInputStream) {
        this.field_1_version = recordInputStream.readShort();
        this.field_2_type = recordInputStream.readShort();
        if (recordInputStream.remaining() >= 2) {
            this.field_3_build = recordInputStream.readShort();
        }
        if (recordInputStream.remaining() >= 2) {
            this.field_4_year = recordInputStream.readShort();
        }
        if (recordInputStream.remaining() >= 4) {
            this.field_5_history = recordInputStream.readInt();
        }
        if (recordInputStream.remaining() >= 4) {
            this.field_6_rversion = recordInputStream.readInt();
        }
    }
}
