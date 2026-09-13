package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.BitField;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DVRecord extends StandardRecord {
    public static final short sid = 446;
    private final UnicodeString _errorText;
    private final UnicodeString _errorTitle;
    private final Formula _formula1;
    private final Formula _formula2;
    private short _not_used_1;
    private short _not_used_2;
    private int _option_flags;
    private final UnicodeString _promptText;
    private final UnicodeString _promptTitle;
    private final CellRangeAddressList _regions;
    private static final UnicodeString NULL_TEXT_STRING = new UnicodeString(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR);
    private static final BitField opt_data_type = new BitField(15);
    private static final BitField opt_error_style = new BitField(112);
    private static final BitField opt_string_list_formula = new BitField(128);
    private static final BitField opt_empty_cell_allowed = new BitField(256);
    private static final BitField opt_suppress_dropdown_arrow = new BitField(512);
    private static final BitField opt_show_prompt_on_cell_selected = new BitField(262144);
    private static final BitField opt_show_error_on_invalid_value = new BitField(524288);
    private static final BitField opt_condition_operator = new BitField(7340032);
    private static final int[] FLAG_MASKS = {15, 112, 128, 256, 512, 262144, 524288, 7340032};
    private static final String[] FLAG_NAMES = {"DATA_TYPE", "ERROR_STYLE", "STRING_LIST_FORMULA", "EMPTY_CELL_ALLOWED", "SUPPRESS_DROPDOWN_ARROW", "SHOW_PROMPT_ON_CELL_SELECTED", "SHOW_ERROR_ON_INVALID_VALUE", "CONDITION_OPERATOR"};

    public DVRecord(DVRecord dVRecord) {
        super(dVRecord);
        this._not_used_1 = (short) 16352;
        this._not_used_2 = (short) 0;
        this._option_flags = dVRecord._option_flags;
        this._promptTitle = dVRecord._promptTitle.copy();
        this._errorTitle = dVRecord._errorTitle.copy();
        this._promptText = dVRecord._promptText.copy();
        this._errorText = dVRecord._errorText.copy();
        this._not_used_1 = dVRecord._not_used_1;
        Formula formula = dVRecord._formula1;
        this._formula1 = formula == null ? null : formula.copy();
        this._not_used_2 = dVRecord._not_used_2;
        Formula formula2 = dVRecord._formula2;
        this._formula2 = formula2 == null ? null : formula2.copy();
        CellRangeAddressList cellRangeAddressList = dVRecord._regions;
        this._regions = cellRangeAddressList != null ? cellRangeAddressList.copy() : null;
    }

    private static int getUnicodeStringSize(UnicodeString unicodeString) {
        String string = unicodeString.getString();
        return (string.length() * (StringUtil.hasMultibyte(string) ? 2 : 1)) + 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$0() {
        return Integer.valueOf(this._option_flags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this._regions;
    }

    private static UnicodeString readUnicodeString(RecordInputStream recordInputStream) {
        return new UnicodeString(recordInputStream);
    }

    private static String resolveTitleString(UnicodeString unicodeString) {
        if (unicodeString == null || unicodeString.equals(NULL_TEXT_STRING)) {
            return null;
        }
        return unicodeString.getString();
    }

    private static UnicodeString resolveTitleText(String str) {
        return (str == null || str.length() < 1) ? NULL_TEXT_STRING : new UnicodeString(str);
    }

    private static void serializeUnicodeString(UnicodeString unicodeString, LittleEndianOutput littleEndianOutput) {
        StringUtil.writeUnicodeString(littleEndianOutput, unicodeString.getString());
    }

    public CellRangeAddressList getCellRangeAddress() {
        return this._regions;
    }

    public int getConditionOperator() {
        return opt_condition_operator.getValue(this._option_flags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._regions.getSize() + this._formula2.getEncodedTokenSize() + this._formula1.getEncodedTokenSize() + getUnicodeStringSize(this._promptTitle) + 12 + getUnicodeStringSize(this._errorTitle) + getUnicodeStringSize(this._promptText) + getUnicodeStringSize(this._errorText);
    }

    public int getDataType() {
        return opt_data_type.getValue(this._option_flags);
    }

    public boolean getEmptyCellAllowed() {
        return opt_empty_cell_allowed.isSet(this._option_flags);
    }

    public int getErrorStyle() {
        return opt_error_style.getValue(this._option_flags);
    }

    public String getErrorText() {
        return resolveTitleString(this._errorText);
    }

    public String getErrorTitle() {
        return resolveTitleString(this._errorTitle);
    }

    public Ptg[] getFormula1() {
        return Formula.getTokens(this._formula1);
    }

    public Ptg[] getFormula2() {
        return Formula.getTokens(this._formula2);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, FLAG_MASKS, FLAG_NAMES);
        final int i6 = 1;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i10 = 5;
        final int i11 = 6;
        final int i12 = 7;
        return GenericRecordUtil.getGenericProperties("optionFlags", bitsAsString, "promptTitle", supplier, "errorTitle", supplier2, "promptText", supplier3, "errorText", supplier4, "formula1", new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "formula2", new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        }, "regions", new Supplier(this) { // from class: org.apache.poi.hssf.record.v
            public final /* synthetic */ DVRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getPromptTitle();
                    case 2:
                        return this.b.getErrorTitle();
                    case 3:
                        return this.b.getPromptText();
                    case 4:
                        return this.b.getErrorText();
                    case 5:
                        return this.b.getFormula1();
                    case 6:
                        return this.b.getFormula2();
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    public boolean getListExplicitFormula() {
        return opt_string_list_formula.isSet(this._option_flags);
    }

    public String getPromptText() {
        return resolveTitleString(this._promptText);
    }

    public String getPromptTitle() {
        return resolveTitleString(this._promptTitle);
    }

    public boolean getShowErrorOnInvalidValue() {
        return opt_show_error_on_invalid_value.isSet(this._option_flags);
    }

    public boolean getShowPromptOnCellSelected() {
        return opt_show_prompt_on_cell_selected.isSet(this._option_flags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean getSuppressDropdownArrow() {
        return opt_suppress_dropdown_arrow.isSet(this._option_flags);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this._option_flags);
        serializeUnicodeString(this._promptTitle, littleEndianOutput);
        serializeUnicodeString(this._errorTitle, littleEndianOutput);
        serializeUnicodeString(this._promptText, littleEndianOutput);
        serializeUnicodeString(this._errorText, littleEndianOutput);
        littleEndianOutput.writeShort(this._formula1.getEncodedTokenSize());
        littleEndianOutput.writeShort(this._not_used_1);
        this._formula1.serializeTokens(littleEndianOutput);
        littleEndianOutput.writeShort(this._formula2.getEncodedTokenSize());
        littleEndianOutput.writeShort(this._not_used_2);
        this._formula2.serializeTokens(littleEndianOutput);
        this._regions.serialize(littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DV;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public DVRecord copy() {
        return new DVRecord(this);
    }

    public DVRecord(int i5, int i6, int i7, boolean z6, boolean z7, boolean z8, boolean z9, String str, String str2, boolean z10, String str3, String str4, Ptg[] ptgArr, Ptg[] ptgArr2, CellRangeAddressList cellRangeAddressList) {
        this._not_used_1 = (short) 16352;
        this._not_used_2 = (short) 0;
        if (str != null && str.length() > 32) {
            throw new IllegalStateException("Prompt-title cannot be longer than 32 characters, but had: ".concat(str));
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Prompt-text cannot be longer than 255 characters, but had: ".concat(str2));
        }
        if (str3 != null && str3.length() > 32) {
            throw new IllegalStateException("Error-title cannot be longer than 32 characters, but had: ".concat(str3));
        }
        if (str4 != null && str4.length() > 255) {
            throw new IllegalStateException("Error-text cannot be longer than 255 characters, but had: ".concat(str4));
        }
        this._option_flags = opt_show_error_on_invalid_value.setBoolean(opt_show_prompt_on_cell_selected.setBoolean(opt_string_list_formula.setBoolean(opt_suppress_dropdown_arrow.setBoolean(opt_empty_cell_allowed.setBoolean(opt_error_style.setValue(opt_condition_operator.setValue(opt_data_type.setValue(0, i5), i6), i7), z6), z7), z8), z9), z10);
        this._promptTitle = resolveTitleText(str);
        this._promptText = resolveTitleText(str2);
        this._errorTitle = resolveTitleText(str3);
        this._errorText = resolveTitleText(str4);
        this._formula1 = Formula.create(ptgArr);
        this._formula2 = Formula.create(ptgArr2);
        this._regions = cellRangeAddressList;
    }

    public DVRecord(RecordInputStream recordInputStream) {
        this._not_used_1 = (short) 16352;
        this._not_used_2 = (short) 0;
        this._option_flags = recordInputStream.readInt();
        this._promptTitle = readUnicodeString(recordInputStream);
        this._errorTitle = readUnicodeString(recordInputStream);
        this._promptText = readUnicodeString(recordInputStream);
        this._errorText = readUnicodeString(recordInputStream);
        int uShort = recordInputStream.readUShort();
        this._not_used_1 = recordInputStream.readShort();
        this._formula1 = Formula.read(uShort, recordInputStream);
        int uShort2 = recordInputStream.readUShort();
        this._not_used_2 = recordInputStream.readShort();
        this._formula2 = Formula.read(uShort2, recordInputStream);
        this._regions = new CellRangeAddressList(recordInputStream);
    }
}
