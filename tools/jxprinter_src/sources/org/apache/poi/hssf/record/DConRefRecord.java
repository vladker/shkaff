package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DConRefRecord extends StandardRecord {
    public static final short sid = 81;
    private byte[] _unused;
    private final int charCount;
    private final int charType;
    private final int firstCol;
    private final int firstRow;
    private final int lastCol;
    private final int lastRow;
    private final byte[] path;

    public DConRefRecord(DConRefRecord dConRefRecord) {
        super(dConRefRecord);
        this.firstCol = dConRefRecord.firstCol;
        this.firstRow = dConRefRecord.firstRow;
        this.lastCol = dConRefRecord.lastCol;
        this.lastRow = dConRefRecord.lastRow;
        this.charCount = dConRefRecord.charCount;
        this.charType = dConRefRecord.charType;
        byte[] bArr = dConRefRecord.path;
        this.path = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = dConRefRecord._unused;
        this._unused = bArr2 != null ? (byte[]) bArr2.clone() : null;
    }

    private static RecordInputStream bytesToRIStream(byte[] bArr) {
        RecordInputStream recordInputStream = new RecordInputStream(new UnsynchronizedByteArrayInputStream(bArr));
        recordInputStream.nextRecord();
        return recordInputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.charCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.charType);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        byte[] bArr = this.path;
        int length = bArr.length + 9;
        return bArr[0] == 2 ? length + this._unused.length : length;
    }

    public int getFirstColumn() {
        return this.firstCol;
    }

    public int getFirstRow() {
        return this.firstRow;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        };
        final int i11 = 6;
        return GenericRecordUtil.getGenericProperties("firstRow", supplier, "lastRow", supplier2, "firstColumn", supplier3, "lastColumn", supplier4, "charCount", supplier5, "charType", supplier6, "path", new Supplier(this) { // from class: org.apache.poi.hssf.record.s
            public final /* synthetic */ DConRefRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getFirstRow());
                    case 1:
                        return Integer.valueOf(this.b.getLastRow());
                    case 2:
                        return Integer.valueOf(this.b.getFirstColumn());
                    case 3:
                        return Integer.valueOf(this.b.getLastColumn());
                    case 4:
                        return this.b.lambda$getGenericProperties$0();
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getReadablePath();
                }
            }
        });
    }

    public int getLastColumn() {
        return this.lastCol;
    }

    public int getLastRow() {
        return this.lastRow;
    }

    public byte[] getPath() {
        byte[] bArr = this.path;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public String getReadablePath() {
        byte[] bArr;
        if (this.path == null) {
            return null;
        }
        int i5 = 1;
        while (true) {
            bArr = this.path;
            if (i5 >= bArr.length || bArr[i5] >= 32) {
                break;
            }
            i5++;
        }
        return new String(Arrays.copyOfRange(bArr, i5, bArr.length), StringUtil.UTF8).replace("\u0003", PackagingURIHelper.FORWARD_SLASH_STRING);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 81;
    }

    public boolean isExternalRef() {
        return this.path[0] == 1;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.firstRow);
        littleEndianOutput.writeShort(this.lastRow);
        littleEndianOutput.writeByte(this.firstCol);
        littleEndianOutput.writeByte(this.lastCol);
        littleEndianOutput.writeShort(this.charCount);
        littleEndianOutput.writeByte(this.charType);
        littleEndianOutput.write(this.path);
        if (this.path[0] == 2) {
            littleEndianOutput.write(this._unused);
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DCON_REF;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DConRefRecord copy() {
        return new DConRefRecord(this);
    }

    public DConRefRecord(byte[] bArr) {
        this(bytesToRIStream(bArr));
    }

    public DConRefRecord(RecordInputStream recordInputStream) {
        if (recordInputStream.getSid() == 81) {
            this.firstRow = recordInputStream.readUShort();
            this.lastRow = recordInputStream.readUShort();
            this.firstCol = recordInputStream.readUByte();
            this.lastCol = recordInputStream.readUByte();
            int uShort = recordInputStream.readUShort();
            this.charCount = uShort;
            int uByte = recordInputStream.readUByte() & 1;
            this.charType = uByte;
            byte[] bArrSafelyAllocate = IOUtils.safelyAllocate((uByte + 1) * uShort, HSSFWorkbook.getMaxRecordLength());
            this.path = bArrSafelyAllocate;
            recordInputStream.readFully(bArrSafelyAllocate);
            if (bArrSafelyAllocate[0] == 2) {
                this._unused = recordInputStream.readRemainder();
                return;
            }
            return;
        }
        throw new RecordFormatException("Wrong sid: " + ((int) recordInputStream.getSid()));
    }
}
