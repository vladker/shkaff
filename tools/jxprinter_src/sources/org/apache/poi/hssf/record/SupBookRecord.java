package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import androidx.core.view.InputDeviceCompat;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SupBookRecord extends StandardRecord {
    static final char CH_ALT_STARTUP_DIR = 7;
    static final char CH_DOWN_DIR = 3;
    static final char CH_LIB_DIR = '\b';
    static final char CH_LONG_VOLUME = 5;
    static final char CH_SAME_VOLUME = 2;
    static final char CH_STARTUP_DIR = 6;
    static final char CH_UP_DIR = 4;
    static final char CH_VOLUME = 1;
    private static final Logger LOG = LogManager.getLogger((Class<?>) SupBookRecord.class);
    static final String PATH_SEPERATOR = System.getProperty("file.separator");
    private static final short SMALL_RECORD_SIZE = 4;
    private static final short TAG_ADD_IN_FUNCTIONS = 14849;
    private static final short TAG_INTERNAL_REFERENCES = 1025;
    public static final short sid = 430;
    private final boolean _isAddInFunctions;
    private short field_1_number_of_sheets;
    private String field_2_encoded_url;
    private final String[] field_3_sheet_names;

    public SupBookRecord(SupBookRecord supBookRecord) {
        super(supBookRecord);
        this.field_1_number_of_sheets = supBookRecord.field_1_number_of_sheets;
        this.field_2_encoded_url = supBookRecord.field_2_encoded_url;
        this.field_3_sheet_names = supBookRecord.field_3_sheet_names;
        this._isAddInFunctions = supBookRecord._isAddInFunctions;
    }

    public static SupBookRecord createAddInFunctions() {
        return new SupBookRecord(true, (short) 1);
    }

    public static SupBookRecord createExternalReferences(String str, String[] strArr) {
        return new SupBookRecord(str, strArr);
    }

    public static SupBookRecord createInternalReferences(short s6) {
        return new SupBookRecord(false, s6);
    }

    private static String decodeFileName(String str) {
        StringBuilder sb = new StringBuilder();
        int i5 = 1;
        while (i5 < str.length()) {
            char cCharAt = str.charAt(i5);
            switch (cCharAt) {
                case 1:
                    i5++;
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 != '@') {
                        sb.append(cCharAt2);
                        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                    } else {
                        sb.append("\\\\");
                    }
                    break;
                case 2:
                case 3:
                    sb.append(PATH_SEPERATOR);
                    break;
                case 4:
                    sb.append("..");
                    sb.append(PATH_SEPERATOR);
                    break;
                case 5:
                    LOG.atWarn().log("Found unexpected key: ChLongVolume - IGNORING");
                    break;
                case 6:
                case 7:
                case '\b':
                    LOG.atWarn().log("EXCEL.EXE path unknown - using this directory instead: .");
                    sb.append('.');
                    sb.append(PATH_SEPERATOR);
                    break;
                default:
                    sb.append(cCharAt);
                    break;
            }
            i5++;
        }
        return sb.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if (!isExternalReferences()) {
            return 4;
        }
        int encodedSize = StringUtil.getEncodedSize(this.field_2_encoded_url) + 2;
        for (String str : this.field_3_sheet_names) {
            encodedSize += StringUtil.getEncodedSize(str);
        }
        return encodedSize;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.R0
            public final /* synthetic */ SupBookRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Boolean.valueOf(this.b.isExternalReferences());
                    case 1:
                        return Boolean.valueOf(this.b.isInternalReferences());
                    case 2:
                        return this.b.getURL();
                    case 3:
                        return Short.valueOf(this.b.getNumberOfSheets());
                    case 4:
                        return this.b.getSheetNames();
                    default:
                        return Boolean.valueOf(this.b.isAddInFunctions());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.R0
            public final /* synthetic */ SupBookRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Boolean.valueOf(this.b.isExternalReferences());
                    case 1:
                        return Boolean.valueOf(this.b.isInternalReferences());
                    case 2:
                        return this.b.getURL();
                    case 3:
                        return Short.valueOf(this.b.getNumberOfSheets());
                    case 4:
                        return this.b.getSheetNames();
                    default:
                        return Boolean.valueOf(this.b.isAddInFunctions());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.R0
            public final /* synthetic */ SupBookRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Boolean.valueOf(this.b.isExternalReferences());
                    case 1:
                        return Boolean.valueOf(this.b.isInternalReferences());
                    case 2:
                        return this.b.getURL();
                    case 3:
                        return Short.valueOf(this.b.getNumberOfSheets());
                    case 4:
                        return this.b.getSheetNames();
                    default:
                        return Boolean.valueOf(this.b.isAddInFunctions());
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.R0
            public final /* synthetic */ SupBookRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Boolean.valueOf(this.b.isExternalReferences());
                    case 1:
                        return Boolean.valueOf(this.b.isInternalReferences());
                    case 2:
                        return this.b.getURL();
                    case 3:
                        return Short.valueOf(this.b.getNumberOfSheets());
                    case 4:
                        return this.b.getSheetNames();
                    default:
                        return Boolean.valueOf(this.b.isAddInFunctions());
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.R0
            public final /* synthetic */ SupBookRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Boolean.valueOf(this.b.isExternalReferences());
                    case 1:
                        return Boolean.valueOf(this.b.isInternalReferences());
                    case 2:
                        return this.b.getURL();
                    case 3:
                        return Short.valueOf(this.b.getNumberOfSheets());
                    case 4:
                        return this.b.getSheetNames();
                    default:
                        return Boolean.valueOf(this.b.isAddInFunctions());
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("externalReferences", supplier, "internalReferences", supplier2, "url", supplier3, "numberOfSheets", supplier4, "sheetNames", supplier5, "addInFunctions", new Supplier(this) { // from class: org.apache.poi.hssf.record.R0
            public final /* synthetic */ SupBookRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Boolean.valueOf(this.b.isExternalReferences());
                    case 1:
                        return Boolean.valueOf(this.b.isInternalReferences());
                    case 2:
                        return this.b.getURL();
                    case 3:
                        return Short.valueOf(this.b.getNumberOfSheets());
                    case 4:
                        return this.b.getSheetNames();
                    default:
                        return Boolean.valueOf(this.b.isAddInFunctions());
                }
            }
        });
    }

    public short getNumberOfSheets() {
        return this.field_1_number_of_sheets;
    }

    public String[] getSheetNames() {
        String[] strArr = this.field_3_sheet_names;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public String getURL() {
        String str = this.field_2_encoded_url;
        if (str == null || str.length() < 2) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != 0) {
            if (cCharAt == 1) {
                return decodeFileName(str);
            }
            if (cCharAt != 2) {
                return str;
            }
        }
        return str.substring(1);
    }

    public boolean isAddInFunctions() {
        return this.field_3_sheet_names == null && this._isAddInFunctions;
    }

    public boolean isExternalReferences() {
        return this.field_3_sheet_names != null;
    }

    public boolean isInternalReferences() {
        return this.field_3_sheet_names == null && !this._isAddInFunctions;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_number_of_sheets);
        if (!isExternalReferences()) {
            littleEndianOutput.writeShort(this._isAddInFunctions ? 14849 : InputDeviceCompat.SOURCE_GAMEPAD);
            return;
        }
        StringUtil.writeUnicodeString(littleEndianOutput, this.field_2_encoded_url);
        for (String str : this.field_3_sheet_names) {
            StringUtil.writeUnicodeString(littleEndianOutput, str);
        }
    }

    public void setNumberOfSheets(short s6) {
        this.field_1_number_of_sheets = s6;
    }

    public void setURL(String str) {
        this.field_2_encoded_url = this.field_2_encoded_url.charAt(0) + str;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SUP_BOOK;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public SupBookRecord copy() {
        return new SupBookRecord(this);
    }

    private SupBookRecord(boolean z6, short s6) {
        this.field_1_number_of_sheets = s6;
        this.field_2_encoded_url = null;
        this.field_3_sheet_names = null;
        this._isAddInFunctions = z6;
    }

    public SupBookRecord(String str, String[] strArr) {
        this.field_1_number_of_sheets = (short) strArr.length;
        this.field_2_encoded_url = str;
        this.field_3_sheet_names = strArr;
        this._isAddInFunctions = false;
    }

    public SupBookRecord(RecordInputStream recordInputStream) {
        int iRemaining = recordInputStream.remaining();
        this.field_1_number_of_sheets = recordInputStream.readShort();
        if (iRemaining > 4) {
            this._isAddInFunctions = false;
            this.field_2_encoded_url = recordInputStream.readString();
            int i5 = this.field_1_number_of_sheets;
            String[] strArr = new String[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                strArr[i6] = recordInputStream.readString();
            }
            this.field_3_sheet_names = strArr;
            return;
        }
        this.field_2_encoded_url = null;
        this.field_3_sheet_names = null;
        short s6 = recordInputStream.readShort();
        if (s6 == 1025) {
            this._isAddInFunctions = false;
            return;
        }
        if (s6 == 14849) {
            this._isAddInFunctions = true;
            if (this.field_1_number_of_sheets == 1) {
                return;
            }
            throw new IllegalArgumentException(AbstractC0157z.l(")", this.field_1_number_of_sheets, new StringBuilder("Expected 0x0001 for number of sheets field in 'Add-In Functions' but got (")));
        }
        throw new IllegalArgumentException("invalid EXTERNALBOOK code (" + Integer.toHexString(s6) + ")");
    }
}
