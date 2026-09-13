package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TextObjectRecord extends ContinuableRecord {
    private static final int FORMAT_RUN_ENCODED_SIZE = 8;
    public static final short HORIZONTAL_TEXT_ALIGNMENT_CENTERED = 2;
    public static final short HORIZONTAL_TEXT_ALIGNMENT_JUSTIFIED = 4;
    public static final short HORIZONTAL_TEXT_ALIGNMENT_LEFT_ALIGNED = 1;
    public static final short HORIZONTAL_TEXT_ALIGNMENT_RIGHT_ALIGNED = 3;
    public static final short TEXT_ORIENTATION_NONE = 0;
    public static final short TEXT_ORIENTATION_ROT_LEFT = 3;
    public static final short TEXT_ORIENTATION_ROT_RIGHT = 2;
    public static final short TEXT_ORIENTATION_TOP_TO_BOTTOM = 1;
    public static final short VERTICAL_TEXT_ALIGNMENT_BOTTOM = 3;
    public static final short VERTICAL_TEXT_ALIGNMENT_CENTER = 2;
    public static final short VERTICAL_TEXT_ALIGNMENT_JUSTIFY = 4;
    public static final short VERTICAL_TEXT_ALIGNMENT_TOP = 1;
    public static final short sid = 438;
    private OperandPtg _linkRefPtg;
    private HSSFRichTextString _text;
    private Byte _unknownPostFormulaByte;
    private int _unknownPreFormulaInt;
    private int field_1_options;
    private int field_2_textOrientation;
    private int field_3_reserved4;
    private int field_4_reserved5;
    private int field_5_reserved6;
    private int field_8_reserved7;
    private static final BitField HorizontalTextAlignment = BitFieldFactory.getInstance(14);
    private static final BitField VerticalTextAlignment = BitFieldFactory.getInstance(112);
    private static final BitField textLocked = BitFieldFactory.getInstance(512);

    public TextObjectRecord() {
    }

    private int getFormattingDataLength() {
        if (this._text.length() < 1) {
            return 0;
        }
        return (this._text.numFormattingRuns() + 1) * 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field_3_reserved4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.field_4_reserved5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this.field_5_reserved6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return Integer.valueOf(this.field_8_reserved7);
    }

    private static void processFontRuns(RecordInputStream recordInputStream, HSSFRichTextString hSSFRichTextString, int i5) {
        if (i5 % 8 != 0) {
            throw new RecordFormatException(androidx.collection.a.i(i5, "Bad format run data length ", ")"));
        }
        int i6 = i5 / 8;
        for (int i7 = 0; i7 < i6; i7++) {
            short s6 = recordInputStream.readShort();
            short s7 = recordInputStream.readShort();
            recordInputStream.readInt();
            hSSFRichTextString.applyFont(s6, hSSFRichTextString.length(), s7);
        }
    }

    private static String readRawString(RecordInputStream recordInputStream, int i5) {
        return (recordInputStream.readByte() & 1) == 0 ? recordInputStream.readCompressedUnicode(i5) : recordInputStream.readUnicodeLEString(i5);
    }

    private void serializeTXORecord(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeShort(this.field_1_options);
        continuableRecordOutput.writeShort(this.field_2_textOrientation);
        continuableRecordOutput.writeShort(this.field_3_reserved4);
        continuableRecordOutput.writeShort(this.field_4_reserved5);
        continuableRecordOutput.writeShort(this.field_5_reserved6);
        continuableRecordOutput.writeShort(this._text.length());
        continuableRecordOutput.writeShort(getFormattingDataLength());
        continuableRecordOutput.writeInt(this.field_8_reserved7);
        OperandPtg operandPtg = this._linkRefPtg;
        if (operandPtg != null) {
            continuableRecordOutput.writeShort(operandPtg.getSize());
            continuableRecordOutput.writeInt(this._unknownPreFormulaInt);
            this._linkRefPtg.write(continuableRecordOutput);
            Byte b = this._unknownPostFormulaByte;
            if (b != null) {
                continuableRecordOutput.writeByte(b.byteValue());
            }
        }
    }

    private void serializeTrailingRecords(ContinuableRecordOutput continuableRecordOutput) {
        continuableRecordOutput.writeContinue();
        continuableRecordOutput.writeStringData(this._text.getString());
        continuableRecordOutput.writeContinue();
        writeFormatData(continuableRecordOutput, this._text);
    }

    private static void writeFormatData(ContinuableRecordOutput continuableRecordOutput, HSSFRichTextString hSSFRichTextString) {
        int iNumFormattingRuns = hSSFRichTextString.numFormattingRuns();
        for (int i5 = 0; i5 < iNumFormattingRuns; i5++) {
            continuableRecordOutput.writeShort(hSSFRichTextString.getIndexOfFormattingRun(i5));
            short fontOfFormattingRun = hSSFRichTextString.getFontOfFormattingRun(i5);
            if (fontOfFormattingRun == 0) {
                fontOfFormattingRun = 0;
            }
            continuableRecordOutput.writeShort(fontOfFormattingRun);
            continuableRecordOutput.writeInt(0);
        }
        continuableRecordOutput.writeShort(hSSFRichTextString.length());
        continuableRecordOutput.writeShort(0);
        continuableRecordOutput.writeInt(0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("isHorizontal", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("isVertical", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("textLocked", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("textOrientation", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put(TypedValues.Custom.S_STRING, new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("reserved4", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("reserved5", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("reserved6", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        final int i13 = 8;
        linkedHashMap.put("reserved7", new Supplier(this) { // from class: org.apache.poi.hssf.record.U0
            public final /* synthetic */ TextObjectRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getHorizontalTextAlignment());
                    case 1:
                        return Integer.valueOf(this.b.getVerticalTextAlignment());
                    case 2:
                        return Boolean.valueOf(this.b.isTextLocked());
                    case 3:
                        return Integer.valueOf(this.b.getTextOrientation());
                    case 4:
                        return this.b.getStr();
                    case 5:
                        return this.b.lambda$getGenericProperties$0();
                    case 6:
                        return this.b.lambda$getGenericProperties$1();
                    case 7:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public int getHorizontalTextAlignment() {
        return HorizontalTextAlignment.getValue(this.field_1_options);
    }

    public Ptg getLinkRefPtg() {
        return this._linkRefPtg;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public HSSFRichTextString getStr() {
        return this._text;
    }

    public int getTextOrientation() {
        return this.field_2_textOrientation;
    }

    public int getVerticalTextAlignment() {
        return VerticalTextAlignment.getValue(this.field_1_options);
    }

    public boolean isTextLocked() {
        return textLocked.isSet(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        serializeTXORecord(continuableRecordOutput);
        if (this._text.getString().length() > 0) {
            serializeTrailingRecords(continuableRecordOutput);
        }
    }

    public void setHorizontalTextAlignment(int i5) {
        this.field_1_options = HorizontalTextAlignment.setValue(this.field_1_options, i5);
    }

    public void setStr(HSSFRichTextString hSSFRichTextString) {
        this._text = hSSFRichTextString;
    }

    public void setTextLocked(boolean z6) {
        this.field_1_options = textLocked.setBoolean(this.field_1_options, z6);
    }

    public void setTextOrientation(int i5) {
        this.field_2_textOrientation = i5;
    }

    public void setVerticalTextAlignment(int i5) {
        this.field_1_options = VerticalTextAlignment.setValue(this.field_1_options, i5);
    }

    public TextObjectRecord(TextObjectRecord textObjectRecord) {
        super(textObjectRecord);
        this.field_1_options = textObjectRecord.field_1_options;
        this.field_2_textOrientation = textObjectRecord.field_2_textOrientation;
        this.field_3_reserved4 = textObjectRecord.field_3_reserved4;
        this.field_4_reserved5 = textObjectRecord.field_4_reserved5;
        this.field_5_reserved6 = textObjectRecord.field_5_reserved6;
        this.field_8_reserved7 = textObjectRecord.field_8_reserved7;
        this._text = textObjectRecord._text;
        OperandPtg operandPtg = textObjectRecord._linkRefPtg;
        if (operandPtg != null) {
            this._unknownPreFormulaInt = textObjectRecord._unknownPreFormulaInt;
            this._linkRefPtg = operandPtg.copy();
            this._unknownPostFormulaByte = textObjectRecord._unknownPostFormulaByte;
        }
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TEXT_OBJECT;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public TextObjectRecord copy() {
        return new TextObjectRecord(this);
    }

    public TextObjectRecord(RecordInputStream recordInputStream) {
        String rawString;
        this.field_1_options = recordInputStream.readUShort();
        this.field_2_textOrientation = recordInputStream.readUShort();
        this.field_3_reserved4 = recordInputStream.readUShort();
        this.field_4_reserved5 = recordInputStream.readUShort();
        this.field_5_reserved6 = recordInputStream.readUShort();
        int uShort = recordInputStream.readUShort();
        int uShort2 = recordInputStream.readUShort();
        this.field_8_reserved7 = recordInputStream.readInt();
        if (recordInputStream.remaining() > 0) {
            if (recordInputStream.remaining() >= 11) {
                int uShort3 = recordInputStream.readUShort();
                this._unknownPreFormulaInt = recordInputStream.readInt();
                Ptg[] tokens = Ptg.readTokens(uShort3, recordInputStream);
                if (tokens.length == 1) {
                    this._linkRefPtg = (OperandPtg) tokens[0];
                    this._unknownPostFormulaByte = recordInputStream.remaining() > 0 ? Byte.valueOf(recordInputStream.readByte()) : null;
                } else {
                    throw new RecordFormatException(AbstractC0157z.l(" tokens but expected exactly 1", tokens.length, new StringBuilder("Read ")));
                }
            } else {
                throw new RecordFormatException("Not enough remaining data for a link formula");
            }
        } else {
            this._linkRefPtg = null;
        }
        if (recordInputStream.remaining() <= 0) {
            if (uShort > 0) {
                rawString = readRawString(recordInputStream, uShort);
            } else {
                rawString = "";
            }
            HSSFRichTextString hSSFRichTextString = new HSSFRichTextString(rawString);
            this._text = hSSFRichTextString;
            if (uShort2 > 0) {
                processFontRuns(recordInputStream, hSSFRichTextString, uShort2);
                return;
            }
            return;
        }
        throw new RecordFormatException("Unused " + recordInputStream.remaining() + " bytes at end of record");
    }
}
