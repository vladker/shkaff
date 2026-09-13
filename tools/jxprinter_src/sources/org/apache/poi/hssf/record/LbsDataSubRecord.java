package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LbsDataSubRecord extends SubRecord {
    public static final int sid = 19;
    private boolean[] _bsels;
    private int _cLines;
    private int _cbFContinued;
    private LbsDropData _dropData;
    private int _flags;
    private int _iSel;
    private int _idEdit;
    private Ptg _linkPtg;
    private String[] _rgLines;
    private Byte _unknownPostFormulaByte;
    private int _unknownPreFormulaInt;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LbsDropData implements Duplicatable, GenericRecord {
        public static final int STYLE_COMBO_DROPDOWN = 0;
        public static final int STYLE_COMBO_EDIT_DROPDOWN = 1;
        public static final int STYLE_COMBO_SIMPLE_DROPDOWN = 2;
        private int _cLine;
        private int _dxMin;
        private final String _str;
        private Byte _unused;
        private int _wStyle;

        public LbsDropData() {
            this._str = "";
            this._unused = (byte) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$0() {
            return Integer.valueOf(this._wStyle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$1() {
            return Integer.valueOf(this._cLine);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$2() {
            return Integer.valueOf(this._dxMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$3() {
            return this._str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$getGenericProperties$4() {
            return this._unused;
        }

        public int getDataSize() {
            int encodedSize = StringUtil.getEncodedSize(this._str);
            return this._unused != null ? encodedSize + 7 : encodedSize + 6;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final int i5 = 0;
            Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.g0
                public final /* synthetic */ LbsDataSubRecord.LbsDropData b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i5) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        case 2:
                            return this.b.lambda$getGenericProperties$2();
                        case 3:
                            return this.b.lambda$getGenericProperties$3();
                        default:
                            return this.b.lambda$getGenericProperties$4();
                    }
                }
            };
            final int i6 = 1;
            Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g0
                public final /* synthetic */ LbsDataSubRecord.LbsDropData b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i6) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        case 2:
                            return this.b.lambda$getGenericProperties$2();
                        case 3:
                            return this.b.lambda$getGenericProperties$3();
                        default:
                            return this.b.lambda$getGenericProperties$4();
                    }
                }
            };
            final int i7 = 2;
            Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g0
                public final /* synthetic */ LbsDataSubRecord.LbsDropData b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i7) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        case 2:
                            return this.b.lambda$getGenericProperties$2();
                        case 3:
                            return this.b.lambda$getGenericProperties$3();
                        default:
                            return this.b.lambda$getGenericProperties$4();
                    }
                }
            };
            final int i8 = 3;
            Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.g0
                public final /* synthetic */ LbsDataSubRecord.LbsDropData b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i8) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        case 2:
                            return this.b.lambda$getGenericProperties$2();
                        case 3:
                            return this.b.lambda$getGenericProperties$3();
                        default:
                            return this.b.lambda$getGenericProperties$4();
                    }
                }
            };
            final int i9 = 4;
            return GenericRecordUtil.getGenericProperties("wStyle", supplier, "cLine", supplier2, "dxMin", supplier3, "str", supplier4, "unused", new Supplier(this) { // from class: org.apache.poi.hssf.record.g0
                public final /* synthetic */ LbsDataSubRecord.LbsDropData b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i9) {
                        case 0:
                            return this.b.lambda$getGenericProperties$0();
                        case 1:
                            return this.b.lambda$getGenericProperties$1();
                        case 2:
                            return this.b.lambda$getGenericProperties$2();
                        case 3:
                            return this.b.lambda$getGenericProperties$3();
                        default:
                            return this.b.lambda$getGenericProperties$4();
                    }
                }
            });
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._wStyle);
            littleEndianOutput.writeShort(this._cLine);
            littleEndianOutput.writeShort(this._dxMin);
            StringUtil.writeUnicodeString(littleEndianOutput, this._str);
            Byte b = this._unused;
            if (b != null) {
                littleEndianOutput.writeByte(b.byteValue());
            }
        }

        public void setNumLines(int i5) {
            this._cLine = i5;
        }

        public void setStyle(int i5) {
            this._wStyle = i5;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }

        @Override // org.apache.poi.common.Duplicatable
        public LbsDropData copy() {
            return new LbsDropData(this);
        }

        public LbsDropData(LbsDropData lbsDropData) {
            this._wStyle = lbsDropData._wStyle;
            this._cLine = lbsDropData._cLine;
            this._dxMin = lbsDropData._dxMin;
            this._str = lbsDropData._str;
            this._unused = lbsDropData._unused;
        }

        public LbsDropData(LittleEndianInput littleEndianInput) {
            this._wStyle = littleEndianInput.readUShort();
            this._cLine = littleEndianInput.readUShort();
            this._dxMin = littleEndianInput.readUShort();
            String unicodeString = StringUtil.readUnicodeString(littleEndianInput);
            this._str = unicodeString;
            if (StringUtil.getEncodedSize(unicodeString) % 2 != 0) {
                this._unused = Byte.valueOf(littleEndianInput.readByte());
            }
        }
    }

    public LbsDataSubRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this._cbFContinued);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this._unknownPreFormulaInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return this._unknownPostFormulaByte;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Integer.valueOf(this._iSel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$4() {
        return Integer.valueOf(this._flags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$5() {
        return Integer.valueOf(this._idEdit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$6() {
        return this._dropData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$7() {
        return this._rgLines;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$8() {
        return this._bsels;
    }

    public static LbsDataSubRecord newAutoFilterInstance() {
        LbsDataSubRecord lbsDataSubRecord = new LbsDataSubRecord();
        lbsDataSubRecord._cbFContinued = 8174;
        lbsDataSubRecord._iSel = 0;
        lbsDataSubRecord._flags = 769;
        LbsDropData lbsDropData = new LbsDropData();
        lbsDataSubRecord._dropData = lbsDropData;
        lbsDropData._wStyle = 2;
        lbsDataSubRecord._dropData._cLine = 8;
        return lbsDataSubRecord;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        int i5;
        Ptg ptg = this._linkPtg;
        if (ptg != null) {
            int size = ptg.getSize();
            i5 = 8 + size;
            if (this._unknownPostFormulaByte != null) {
                i5 = size + 9;
            }
        } else {
            i5 = 2;
        }
        int encodedSize = i5 + 8;
        LbsDropData lbsDropData = this._dropData;
        if (lbsDropData != null) {
            encodedSize += lbsDropData.getDataSize();
        }
        String[] strArr = this._rgLines;
        if (strArr != null) {
            for (String str : strArr) {
                encodedSize += StringUtil.getEncodedSize(str);
            }
        }
        boolean[] zArr = this._bsels;
        return zArr != null ? encodedSize + zArr.length : encodedSize;
    }

    public Ptg getFormula() {
        return this._linkPtg;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("unknownShort1", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i6 = 3;
        linkedHashMap.put("unknownPreFormulaInt", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i7 = 4;
        linkedHashMap.put("formula", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i8 = 5;
        linkedHashMap.put("unknownPostFormulaByte", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i9 = 6;
        linkedHashMap.put("numberOfItems", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i10 = 7;
        linkedHashMap.put("selEntryIx", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i11 = 8;
        linkedHashMap.put("style", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i12 = 9;
        linkedHashMap.put("unknownShort10", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i13 = 10;
        linkedHashMap.put("dropData", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i14 = 1;
        linkedHashMap.put("rgLines", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        final int i15 = 2;
        linkedHashMap.put("bsels", new Supplier(this) { // from class: org.apache.poi.hssf.record.f0
            public final /* synthetic */ LbsDataSubRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$7();
                    case 2:
                        return this.b.lambda$getGenericProperties$8();
                    case 3:
                        return this.b.lambda$getGenericProperties$1();
                    case 4:
                        return this.b.getFormula();
                    case 5:
                        return this.b.lambda$getGenericProperties$2();
                    case 6:
                        return Integer.valueOf(this.b.getNumberOfItems());
                    case 7:
                        return this.b.lambda$getGenericProperties$3();
                    case 8:
                        return this.b.lambda$getGenericProperties$4();
                    case 9:
                        return this.b.lambda$getGenericProperties$5();
                    default:
                        return this.b.lambda$getGenericProperties$6();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public int getNumberOfItems() {
        return this._cLines;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public boolean isTerminating() {
        return true;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(19);
        littleEndianOutput.writeShort(this._cbFContinued);
        Ptg ptg = this._linkPtg;
        if (ptg == null) {
            littleEndianOutput.writeShort(0);
        } else {
            int size = ptg.getSize();
            int i5 = size + 6;
            if (this._unknownPostFormulaByte != null) {
                i5 = size + 7;
            }
            littleEndianOutput.writeShort(i5);
            littleEndianOutput.writeShort(size);
            littleEndianOutput.writeInt(this._unknownPreFormulaInt);
            this._linkPtg.write(littleEndianOutput);
            Byte b = this._unknownPostFormulaByte;
            if (b != null) {
                littleEndianOutput.writeByte(b.intValue());
            }
        }
        littleEndianOutput.writeShort(this._cLines);
        littleEndianOutput.writeShort(this._iSel);
        littleEndianOutput.writeShort(this._flags);
        littleEndianOutput.writeShort(this._idEdit);
        LbsDropData lbsDropData = this._dropData;
        if (lbsDropData != null) {
            lbsDropData.serialize(littleEndianOutput);
        }
        String[] strArr = this._rgLines;
        if (strArr != null) {
            for (String str : strArr) {
                StringUtil.writeUnicodeString(littleEndianOutput, str);
            }
        }
        boolean[] zArr = this._bsels;
        if (zArr != null) {
            for (boolean z6 : zArr) {
                littleEndianOutput.writeByte(z6 ? 1 : 0);
            }
        }
    }

    public LbsDataSubRecord(LbsDataSubRecord lbsDataSubRecord) {
        super(lbsDataSubRecord);
        this._cbFContinued = lbsDataSubRecord._cbFContinued;
        this._unknownPreFormulaInt = lbsDataSubRecord._unknownPreFormulaInt;
        Ptg ptg = lbsDataSubRecord._linkPtg;
        this._linkPtg = ptg == null ? null : ptg.copy();
        this._unknownPostFormulaByte = lbsDataSubRecord._unknownPostFormulaByte;
        this._cLines = lbsDataSubRecord._cLines;
        this._iSel = lbsDataSubRecord._iSel;
        this._flags = lbsDataSubRecord._flags;
        this._idEdit = lbsDataSubRecord._idEdit;
        LbsDropData lbsDropData = lbsDataSubRecord._dropData;
        this._dropData = lbsDropData == null ? null : lbsDropData.copy();
        String[] strArr = lbsDataSubRecord._rgLines;
        this._rgLines = strArr == null ? null : (String[]) strArr.clone();
        boolean[] zArr = lbsDataSubRecord._bsels;
        this._bsels = zArr != null ? (boolean[]) zArr.clone() : null;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.LBS_DATA;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public LbsDataSubRecord copy() {
        return new LbsDataSubRecord(this);
    }

    public LbsDataSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        this._cbFContinued = i5;
        int uShort = littleEndianInput.readUShort();
        if (uShort > 0) {
            int uShort2 = littleEndianInput.readUShort();
            this._unknownPreFormulaInt = littleEndianInput.readInt();
            Ptg[] tokens = Ptg.readTokens(uShort2, littleEndianInput);
            if (tokens.length == 1) {
                this._linkPtg = tokens[0];
                int i7 = (uShort - uShort2) - 6;
                if (i7 == 0) {
                    this._unknownPostFormulaByte = null;
                } else if (i7 == 1) {
                    this._unknownPostFormulaByte = Byte.valueOf(littleEndianInput.readByte());
                } else {
                    throw new RecordFormatException("Unexpected leftover bytes");
                }
            } else {
                throw new RecordFormatException(AbstractC0157z.l(" tokens but expected exactly 1", tokens.length, new StringBuilder("Read ")));
            }
        }
        this._cLines = littleEndianInput.readUShort();
        this._iSel = littleEndianInput.readUShort();
        this._flags = littleEndianInput.readUShort();
        this._idEdit = littleEndianInput.readUShort();
        if (i6 == 20) {
            this._dropData = new LbsDropData(littleEndianInput);
        }
        if ((this._flags & 2) != 0) {
            this._rgLines = new String[this._cLines];
            for (int i8 = 0; i8 < this._cLines; i8++) {
                this._rgLines[i8] = StringUtil.readUnicodeString(littleEndianInput);
            }
        }
        int i9 = this._flags;
        if (((i9 >> 4) & 1) + ((i9 >> 5) & 1) != 0) {
            this._bsels = new boolean[this._cLines];
            for (int i10 = 0; i10 < this._cLines; i10++) {
                this._bsels[i10] = littleEndianInput.readByte() == 1;
            }
        }
    }
}
