package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NameRecord extends ContinuableRecord {
    public static final byte BUILTIN_AUTO_ACTIVATE = 10;
    public static final byte BUILTIN_AUTO_CLOSE = 3;
    public static final byte BUILTIN_AUTO_DEACTIVATE = 11;
    public static final byte BUILTIN_AUTO_OPEN = 2;
    public static final byte BUILTIN_CONSOLIDATE_AREA = 1;
    public static final byte BUILTIN_CRITERIA = 5;
    public static final byte BUILTIN_DATABASE = 4;
    public static final byte BUILTIN_DATA_FORM = 9;
    public static final byte BUILTIN_FILTER_DB = 13;
    public static final byte BUILTIN_PRINT_AREA = 6;
    public static final byte BUILTIN_PRINT_TITLE = 7;
    public static final byte BUILTIN_RECORDER = 8;
    public static final byte BUILTIN_SHEET_TITLE = 12;
    public static final short sid = 24;
    private boolean field_11_nameIsMultibyte;
    private byte field_12_built_in_code;
    private String field_12_name_text;
    private Formula field_13_name_definition;
    private String field_14_custom_menu_text;
    private String field_15_description_text;
    private String field_16_help_topic_text;
    private String field_17_status_bar_text;
    private short field_1_option_flag;
    private byte field_2_keyboard_shortcut;
    private short field_5_externSheetIndex_plus1;
    private int field_6_sheetNumber;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Option {
        public static final int OPT_BINDATA = 4096;
        public static final int OPT_BUILTIN = 32;
        public static final int OPT_COMMAND_NAME = 4;
        public static final int OPT_COMPLEX = 16;
        public static final int OPT_FUNCTION_NAME = 2;
        public static final int OPT_HIDDEN_NAME = 1;
        public static final int OPT_MACRO = 8;

        private Option() {
        }

        public static boolean isFormula(int i5) {
            return (i5 & 15) == 0;
        }
    }

    public NameRecord() {
        this.field_13_name_definition = Formula.create(Ptg.EMPTY_PTG_ARRAY);
        this.field_12_name_text = "";
        this.field_14_custom_menu_text = "";
        this.field_15_description_text = "";
        this.field_16_help_topic_text = "";
        this.field_17_status_bar_text = "";
    }

    private int getNameRawSize() {
        if (isBuiltInName()) {
            return 1;
        }
        int length = this.field_12_name_text.length();
        return this.field_11_nameIsMultibyte ? length * 2 : length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNameTextLength() {
        if (isBuiltInName()) {
            return 1;
        }
        return this.field_12_name_text.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Short.valueOf(this.field_5_externSheetIndex_plus1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Boolean.valueOf(this.field_11_nameIsMultibyte);
    }

    private static String translateBuiltInName(byte b) {
        switch (b) {
            case 1:
                return "Consolidate_Area";
            case 2:
                return "Auto_Open";
            case 3:
                return "Auto_Close";
            case 4:
                return "Database";
            case 5:
                return "Criteria";
            case 6:
                return "Print_Area";
            case 7:
                return "Print_Titles";
            case 8:
                return "Recorder";
            case 9:
                return "Data_Form";
            case 10:
                return "Auto_Activate";
            case 11:
                return "Auto_Deactivate";
            case 12:
                return "Sheet_Title";
            case 13:
                return "_FilterDatabase";
            default:
                return "Unknown";
        }
    }

    public byte getBuiltInName() {
        return this.field_12_built_in_code;
    }

    public String getCustomMenuText() {
        return this.field_14_custom_menu_text;
    }

    public int getDataSize() {
        return this.field_13_name_definition.getEncodedSize() + this.field_17_status_bar_text.length() + this.field_16_help_topic_text.length() + this.field_15_description_text.length() + this.field_14_custom_menu_text.length() + getNameRawSize() + 13;
    }

    public String getDescriptionText() {
        return this.field_15_description_text;
    }

    public int getExternSheetNumber() {
        Ptg[] tokens = this.field_13_name_definition.getTokens();
        if (tokens.length == 0) {
            return 0;
        }
        Ptg ptg = tokens[0];
        if (ptg.getClass() == Area3DPtg.class) {
            return ((Area3DPtg) ptg).getExternSheetIndex();
        }
        if (ptg.getClass() == Ref3DPtg.class) {
            return ((Ref3DPtg) ptg).getExternSheetIndex();
        }
        return 0;
    }

    public byte getFnGroup() {
        return (byte) ((this.field_1_option_flag & 4032) >> 4);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("dataSize", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i6 = 9;
        linkedHashMap.put("optionFlag", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i7 = 10;
        linkedHashMap.put("keyboardShortcut", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i8 = 11;
        linkedHashMap.put("externSheetIndex", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i9 = 12;
        linkedHashMap.put("sheetNumber", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i10 = 13;
        linkedHashMap.put("nameIsMultibyte", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i11 = 1;
        linkedHashMap.put("builtInName", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i12 = 2;
        linkedHashMap.put("nameLength", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i13 = 3;
        linkedHashMap.put("nameText", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i14 = 4;
        linkedHashMap.put("formula", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i15 = 5;
        linkedHashMap.put("customMenuText", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i16 = 6;
        linkedHashMap.put("descriptionText", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i17 = 7;
        linkedHashMap.put("helpTopicText", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i17) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        final int i18 = 8;
        linkedHashMap.put("statusBarText", new Supplier(this) { // from class: org.apache.poi.hssf.record.n0
            public final /* synthetic */ NameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i18) {
                    case 0:
                        return Integer.valueOf(this.b.getDataSize());
                    case 1:
                        return Byte.valueOf(this.b.getBuiltInName());
                    case 2:
                        return Integer.valueOf(this.b.getNameTextLength());
                    case 3:
                        return this.b.getNameText();
                    case 4:
                        return this.b.getNameDefinition();
                    case 5:
                        return this.b.getCustomMenuText();
                    case 6:
                        return this.b.getDescriptionText();
                    case 7:
                        return this.b.getHelpTopicText();
                    case 8:
                        return this.b.getStatusBarText();
                    case 9:
                        return Short.valueOf(this.b.getOptionFlag());
                    case 10:
                        return Byte.valueOf(this.b.getKeyboardShortcut());
                    case 11:
                        return this.b.lambda$getGenericProperties$0();
                    case 12:
                        return Integer.valueOf(this.b.getSheetNumber());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String getHelpTopicText() {
        return this.field_16_help_topic_text;
    }

    public byte getKeyboardShortcut() {
        return this.field_2_keyboard_shortcut;
    }

    public Ptg[] getNameDefinition() {
        return this.field_13_name_definition.getTokens();
    }

    public String getNameText() {
        return isBuiltInName() ? translateBuiltInName(getBuiltInName()) : this.field_12_name_text;
    }

    public short getOptionFlag() {
        return this.field_1_option_flag;
    }

    public int getSheetNumber() {
        return this.field_6_sheetNumber;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 24;
    }

    public String getStatusBarText() {
        return this.field_17_status_bar_text;
    }

    public boolean hasFormula() {
        return Option.isFormula(this.field_1_option_flag) && this.field_13_name_definition.getEncodedTokenSize() > 0;
    }

    public boolean isBuiltInName() {
        return (this.field_1_option_flag & 32) != 0;
    }

    public boolean isCommandName() {
        return (this.field_1_option_flag & 4) != 0;
    }

    public boolean isComplexFunction() {
        return (this.field_1_option_flag & 16) != 0;
    }

    public boolean isFunctionName() {
        return (this.field_1_option_flag & 2) != 0;
    }

    public boolean isHiddenName() {
        return (this.field_1_option_flag & 1) != 0;
    }

    public boolean isMacro() {
        return (this.field_1_option_flag & 8) != 0;
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        int length = this.field_14_custom_menu_text.length();
        int length2 = this.field_15_description_text.length();
        int length3 = this.field_16_help_topic_text.length();
        int length4 = this.field_17_status_bar_text.length();
        continuableRecordOutput.writeShort(getOptionFlag());
        continuableRecordOutput.writeByte(getKeyboardShortcut());
        continuableRecordOutput.writeByte(getNameTextLength());
        continuableRecordOutput.writeShort(this.field_13_name_definition.getEncodedTokenSize());
        continuableRecordOutput.writeShort(this.field_5_externSheetIndex_plus1);
        continuableRecordOutput.writeShort(this.field_6_sheetNumber);
        continuableRecordOutput.writeByte(length);
        continuableRecordOutput.writeByte(length2);
        continuableRecordOutput.writeByte(length3);
        continuableRecordOutput.writeByte(length4);
        continuableRecordOutput.writeByte(this.field_11_nameIsMultibyte ? 1 : 0);
        if (isBuiltInName()) {
            continuableRecordOutput.writeByte(this.field_12_built_in_code);
        } else {
            String str = this.field_12_name_text;
            if (this.field_11_nameIsMultibyte) {
                StringUtil.putUnicodeLE(str, continuableRecordOutput);
            } else {
                StringUtil.putCompressedUnicode(str, continuableRecordOutput);
            }
        }
        this.field_13_name_definition.serializeTokens(continuableRecordOutput);
        this.field_13_name_definition.serializeArrayConstantData(continuableRecordOutput);
        StringUtil.putCompressedUnicode(getCustomMenuText(), continuableRecordOutput);
        StringUtil.putCompressedUnicode(getDescriptionText(), continuableRecordOutput);
        StringUtil.putCompressedUnicode(getHelpTopicText(), continuableRecordOutput);
        StringUtil.putCompressedUnicode(getStatusBarText(), continuableRecordOutput);
    }

    public void setCustomMenuText(String str) {
        this.field_14_custom_menu_text = str;
    }

    public void setDescriptionText(String str) {
        this.field_15_description_text = str;
    }

    public void setFunction(boolean z6) {
        if (z6) {
            this.field_1_option_flag = (short) (this.field_1_option_flag | 2);
        } else {
            this.field_1_option_flag = (short) (this.field_1_option_flag & (-3));
        }
    }

    public void setHelpTopicText(String str) {
        this.field_16_help_topic_text = str;
    }

    public void setHidden(boolean z6) {
        if (z6) {
            this.field_1_option_flag = (short) (this.field_1_option_flag | 1);
        } else {
            this.field_1_option_flag = (short) (this.field_1_option_flag & (-2));
        }
    }

    public void setKeyboardShortcut(byte b) {
        this.field_2_keyboard_shortcut = b;
    }

    public void setNameDefinition(Ptg[] ptgArr) {
        this.field_13_name_definition = Formula.create(ptgArr);
    }

    public void setNameText(String str) {
        this.field_12_name_text = str;
        this.field_11_nameIsMultibyte = StringUtil.hasMultibyte(str);
    }

    public void setOptionFlag(short s6) {
        this.field_1_option_flag = s6;
    }

    public void setSheetNumber(int i5) {
        this.field_6_sheetNumber = i5;
    }

    public void setStatusBarText(String str) {
        this.field_17_status_bar_text = str;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NAME;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public NameRecord copy() {
        return new NameRecord(this);
    }

    public NameRecord(NameRecord nameRecord) {
        super(nameRecord);
        this.field_1_option_flag = nameRecord.field_1_option_flag;
        this.field_2_keyboard_shortcut = nameRecord.field_2_keyboard_shortcut;
        this.field_5_externSheetIndex_plus1 = nameRecord.field_5_externSheetIndex_plus1;
        this.field_6_sheetNumber = nameRecord.field_6_sheetNumber;
        this.field_11_nameIsMultibyte = nameRecord.field_11_nameIsMultibyte;
        this.field_12_built_in_code = nameRecord.field_12_built_in_code;
        this.field_12_name_text = nameRecord.field_12_name_text;
        this.field_13_name_definition = nameRecord.field_13_name_definition;
        this.field_14_custom_menu_text = nameRecord.field_14_custom_menu_text;
        this.field_15_description_text = nameRecord.field_15_description_text;
        this.field_16_help_topic_text = nameRecord.field_16_help_topic_text;
        this.field_17_status_bar_text = nameRecord.field_17_status_bar_text;
    }

    public NameRecord(byte b, int i5) {
        this();
        this.field_12_built_in_code = b;
        setOptionFlag((short) (this.field_1_option_flag | 32));
        this.field_6_sheetNumber = i5;
    }

    public NameRecord(RecordInputStream recordInputStream) {
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(recordInputStream.readAllContinuedRemainder());
        this.field_1_option_flag = littleEndianByteArrayInputStream.readShort();
        this.field_2_keyboard_shortcut = littleEndianByteArrayInputStream.readByte();
        int uByte = littleEndianByteArrayInputStream.readUByte();
        short s6 = littleEndianByteArrayInputStream.readShort();
        this.field_5_externSheetIndex_plus1 = littleEndianByteArrayInputStream.readShort();
        this.field_6_sheetNumber = littleEndianByteArrayInputStream.readUShort();
        int uByte2 = littleEndianByteArrayInputStream.readUByte();
        int uByte3 = littleEndianByteArrayInputStream.readUByte();
        int uByte4 = littleEndianByteArrayInputStream.readUByte();
        int uByte5 = littleEndianByteArrayInputStream.readUByte();
        this.field_11_nameIsMultibyte = littleEndianByteArrayInputStream.readByte() != 0;
        if (isBuiltInName()) {
            this.field_12_built_in_code = littleEndianByteArrayInputStream.readByte();
        } else if (this.field_11_nameIsMultibyte) {
            this.field_12_name_text = StringUtil.readUnicodeLE(littleEndianByteArrayInputStream, uByte);
        } else {
            this.field_12_name_text = StringUtil.readCompressedUnicode(littleEndianByteArrayInputStream, uByte);
        }
        this.field_13_name_definition = Formula.read(s6, littleEndianByteArrayInputStream, littleEndianByteArrayInputStream.available() - (((uByte2 + uByte3) + uByte4) + uByte5));
        this.field_14_custom_menu_text = StringUtil.readCompressedUnicode(littleEndianByteArrayInputStream, uByte2);
        this.field_15_description_text = StringUtil.readCompressedUnicode(littleEndianByteArrayInputStream, uByte3);
        this.field_16_help_topic_text = StringUtil.readCompressedUnicode(littleEndianByteArrayInputStream, uByte4);
        this.field_17_status_bar_text = StringUtil.readCompressedUnicode(littleEndianByteArrayInputStream, uByte5);
    }
}
