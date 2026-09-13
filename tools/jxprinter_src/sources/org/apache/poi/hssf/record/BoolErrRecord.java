package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BoolErrRecord extends CellRecord {
    public static final short sid = 517;
    private boolean _isError;
    private int _value;

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.BoolErrRecord$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FormulaError;

        static {
            int[] iArr = new int[FormulaError.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = iArr;
            try {
                iArr[FormulaError.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.DIV0.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.REF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BoolErrRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        if (isError()) {
            return FormulaError.forInt(getErrorValue()).getString();
        }
        return null;
    }

    public boolean getBooleanValue() {
        return this._value != 0;
    }

    public byte getErrorValue() {
        return (byte) this._value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.e
            public final /* synthetic */ BoolErrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isBoolean());
                    case 2:
                        return Boolean.valueOf(this.b.getBooleanValue());
                    case 3:
                        return Boolean.valueOf(this.b.isError());
                    case 4:
                        return Byte.valueOf(this.b.getErrorValue());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.e
            public final /* synthetic */ BoolErrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isBoolean());
                    case 2:
                        return Boolean.valueOf(this.b.getBooleanValue());
                    case 3:
                        return Boolean.valueOf(this.b.isError());
                    case 4:
                        return Byte.valueOf(this.b.getErrorValue());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.e
            public final /* synthetic */ BoolErrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isBoolean());
                    case 2:
                        return Boolean.valueOf(this.b.getBooleanValue());
                    case 3:
                        return Boolean.valueOf(this.b.isError());
                    case 4:
                        return Byte.valueOf(this.b.getErrorValue());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.e
            public final /* synthetic */ BoolErrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isBoolean());
                    case 2:
                        return Boolean.valueOf(this.b.getBooleanValue());
                    case 3:
                        return Boolean.valueOf(this.b.isError());
                    case 4:
                        return Byte.valueOf(this.b.getErrorValue());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.e
            public final /* synthetic */ BoolErrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isBoolean());
                    case 2:
                        return Boolean.valueOf(this.b.getBooleanValue());
                    case 3:
                        return Boolean.valueOf(this.b.isError());
                    case 4:
                        return Byte.valueOf(this.b.getErrorValue());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("base", supplier, "isBoolean", supplier2, "booleanVal", supplier3, "isError", supplier4, "errorVal", supplier5, "errorTxt", new Supplier(this) { // from class: org.apache.poi.hssf.record.e
            public final /* synthetic */ BoolErrRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Boolean.valueOf(this.b.isBoolean());
                    case 2:
                        return Boolean.valueOf(this.b.getBooleanValue());
                    case 3:
                        return Boolean.valueOf(this.b.isError());
                    case 4:
                        return Byte.valueOf(this.b.getErrorValue());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public String getRecordName() {
        return "BOOLERR";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 2;
    }

    public boolean isBoolean() {
        return !this._isError;
    }

    public boolean isError() {
        return this._isError;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._value);
        littleEndianOutput.writeByte(this._isError ? 1 : 0);
    }

    public void setValue(boolean z6) {
        this._value = z6 ? 1 : 0;
        this._isError = false;
    }

    public BoolErrRecord(BoolErrRecord boolErrRecord) {
        super(boolErrRecord);
        this._value = boolErrRecord._value;
        this._isError = boolErrRecord._isError;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOOL_ERR;
    }

    public void setValue(byte b) {
        setValue(FormulaError.forInt(b));
    }

    public void setValue(FormulaError formulaError) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FormulaError[formulaError.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                this._value = formulaError.getCode();
                this._isError = true;
                return;
            default:
                throw new IllegalArgumentException("Error Value can only be 0,7,15,23,29,36 or 42. It cannot be " + ((int) formulaError.getCode()) + " (" + formulaError + ")");
        }
    }

    public BoolErrRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        int iRemaining = recordInputStream.remaining();
        if (iRemaining == 2) {
            this._value = recordInputStream.readByte();
        } else if (iRemaining == 3) {
            this._value = recordInputStream.readUShort();
        } else {
            throw new RecordFormatException("Unexpected size (" + recordInputStream.remaining() + ") for BOOLERR record.");
        }
        int uByte = recordInputStream.readUByte();
        if (uByte == 0) {
            this._isError = false;
        } else {
            if (uByte == 1) {
                this._isError = true;
                return;
            }
            throw new RecordFormatException(androidx.collection.a.i(uByte, "Unexpected isError flag (", ") for BOOLERR record."));
        }
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public BoolErrRecord copy() {
        return new BoolErrRecord(this);
    }
}
