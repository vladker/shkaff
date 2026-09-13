package org.apache.poi.hssf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentTransaction;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnknownRecord extends StandardRecord {
    public static final int BITMAP_00E9 = 233;
    public static final int CODENAME_1BA = 442;
    public static final int HEADER_FOOTER_089C = 2204;
    public static final int LABELRANGES_015F = 351;
    public static final int PHONETICPR_00EF = 239;
    public static final int PLS_004D = 77;
    public static final int PLV_MAC = 2248;
    public static final int PRINTSIZE_0033 = 51;
    public static final int QUICKTIP_0800 = 2048;
    public static final int SCL_00A0 = 160;
    public static final int SHEETEXT_0862 = 2146;
    public static final int SHEETPROTECTION_0867 = 2151;
    public static final int SHEETPR_0081 = 129;
    public static final int SORT_0090 = 144;
    public static final int STANDARDWIDTH_0099 = 153;
    private byte[] _rawData;
    private int _sid;

    public UnknownRecord(int i5, byte[] bArr) {
        this._sid = i5 & 65535;
        this._rawData = bArr;
    }

    public static String getBiffName(int i5) {
        switch (i5) {
            case 51:
                return "PRINTSIZE";
            case 77:
                return "PLS";
            case 80:
                return "DCON";
            case 127:
                return "IMDATA";
            case 129:
                return "SHEETPR";
            case 144:
                return "SORT";
            case 148:
                return "LHRECORD";
            case 153:
                return "STANDARDWIDTH";
            case 160:
                return "SCL";
            case 174:
                return "SCENMAN";
            case 178:
                return "SXVI";
            case 180:
                return "SXIVD";
            case 181:
                return "SXLI";
            case 211:
                return "OBPROJ";
            case 220:
                return "PARAMQRY";
            case 222:
                return "OLESIZE";
            case 233:
                return "BITMAP";
            case 239:
                return "PHONETICPR";
            case 241:
                return "SXEX";
            case 351:
                return "LABELRANGES";
            case TypedValues.CycleType.TYPE_WAVE_PHASE /* 425 */:
                return "USERBVIEW";
            case Videoio.CAP_PROP_XI_BINNING_HORIZONTAL /* 429 */:
                return "QSI";
            case 442:
                return "CODENAME";
            case Videoio.CAP_PROP_XI_WB_KR /* 448 */:
                return "EXCEL9FILE";
            case 2048:
                return "QUICKTIP";
            case 2050:
                return "QSISXTAG";
            case 2051:
                return "DBQUERYEXT";
            case 2053:
                return "TXTQUERY";
            case 2064:
                return "SXVIEWEX9";
            case 2066:
                return "CONTINUEFRT";
            case SHEETEXT_0862 /* 2146 */:
                return "SHEETEXT";
            case 2147:
                return "BOOKEXT";
            case 2148:
                return "SXADDL";
            case SHEETPROTECTION_0867 /* 2151 */:
                return "SHEETPROTECTION";
            case 2155:
                return "DATALABEXTCONTENTS";
            case 2156:
                return "CELLWATCH";
            case 2162:
                return "SHARED FEATURE v11";
            case 2164:
                return "DROPDOWNOBJIDS";
            case 2166:
                return "DCONN";
            case 2168:
                return "SHARED FEATURE v12";
            case 2171:
                return "CFEX";
            case 2172:
                return "XFCRC";
            case 2173:
                return "XFEXT";
            case 2175:
                return "CONTINUEFRT12";
            case 2187:
                return "PLV";
            case 2188:
                return "COMPAT12";
            case 2189:
                return "DXF";
            case 2194:
                return "STYLEEXT";
            case 2198:
                return "THEME";
            case 2199:
                return "GUIDTYPELIB";
            case 2202:
                return "MTRSETTINGS";
            case 2203:
                return "COMPRESSPICTURES";
            case HEADER_FOOTER_089C /* 2204 */:
                return "HEADERFOOTER";
            case 2205:
                return "CRTLAYOUT12";
            case 2206:
                return "CRTMLFRT";
            case 2207:
                return "CRTMLFRTCONTINUE";
            case 2209:
                return "SHAPEPROPSSTREAM";
            case 2211:
                return "FORCEFULLCALCULATION";
            case 2212:
                return "SHAPEPROPSSTREAM";
            case 2213:
                return "TEXTPROPSSTREAM";
            case 2214:
                return "RICHTEXTSTREAM";
            case 2215:
                return "CRTLAYOUT12A";
            case PLV_MAC /* 2248 */:
                return "PLV{Mac Excel}";
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                return "UNITS";
            case 4102:
                return "CHARTDATAFORMAT";
            case 4103:
                return "CHARTLINEFORMAT";
            default:
                if (!isObservedButUnknown(i5)) {
                    return null;
                }
                return "UNKNOWN-" + Integer.toHexString(i5).toUpperCase(Locale.ROOT);
        }
    }

    private static boolean isObservedButUnknown(int i5) {
        if (i5 == 51 || i5 == 52 || i5 == 4170 || i5 == 4171 || i5 == 4174 || i5 == 4175 || i5 == 4188 || i5 == 4189) {
            return true;
        }
        switch (i5) {
            case Videoio.CAP_PROP_XI_BPC /* 445 */:
            case Videoio.CAP_PROP_XI_WB_KB /* 450 */:
            case 4116:
            case 4125:
            case 4126:
            case 4127:
            case 4128:
            case 4129:
            case 4130:
            case 4154:
            case 4161:
            case 4177:
            case 4191:
            case 4192:
            case 4194:
            case 4195:
            case 4196:
            case 4197:
            case 4198:
                return true;
            default:
                switch (i5) {
                    case 4105:
                    case 4106:
                    case 4107:
                    case 4108:
                        return true;
                    default:
                        switch (i5) {
                            case 4119:
                            case 4120:
                            case 4121:
                            case 4122:
                            case 4123:
                                return true;
                            default:
                                switch (i5) {
                                    case 4132:
                                    case 4133:
                                    case 4134:
                                    case 4135:
                                        return true;
                                    default:
                                        switch (i5) {
                                            case 4146:
                                            case 4147:
                                            case 4148:
                                            case 4149:
                                                return true;
                                            default:
                                                switch (i5) {
                                                    case 4163:
                                                    case 4164:
                                                    case 4165:
                                                    case 4166:
                                                        return true;
                                                    default:
                                                        return false;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getGenericProperties$0() {
        String biffName = getBiffName(this._sid);
        return biffName == null ? "UNKNOWNRECORD" : biffName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return this._rawData;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public UnknownRecord copy() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._rawData.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.V0
            public final /* synthetic */ UnknownRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getSid());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.V0
            public final /* synthetic */ UnknownRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getSid());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("sid", supplier2, "biffName", supplier, "rawData", new Supplier(this) { // from class: org.apache.poi.hssf.record.V0
            public final /* synthetic */ UnknownRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getSid());
                    default:
                        return this.b.lambda$getGenericProperties$1();
                }
            }
        });
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) this._sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this._rawData);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.UNKNOWN;
    }

    public UnknownRecord(RecordInputStream recordInputStream) {
        this._sid = recordInputStream.getSid();
        this._rawData = recordInputStream.readRemainder();
    }
}
