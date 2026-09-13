package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import androidx.core.location.LocationRequestCompat;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.ParseException;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class StscSimpleTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final RegularExpression[] EMPTY_REGEX_ARRAY = new RegularExpression[0];
    private static final CodeForNameEntry[] facetCodes = {new CodeForNameEntry(QNameHelper.forLNS("length", "http://www.w3.org/2001/XMLSchema"), 0), new CodeForNameEntry(QNameHelper.forLNS("minLength", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("maxLength", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("pattern", "http://www.w3.org/2001/XMLSchema"), 10), new CodeForNameEntry(QNameHelper.forLNS("enumeration", "http://www.w3.org/2001/XMLSchema"), 11), new CodeForNameEntry(QNameHelper.forLNS("whiteSpace", "http://www.w3.org/2001/XMLSchema"), 9), new CodeForNameEntry(QNameHelper.forLNS("maxInclusive", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("maxExclusive", "http://www.w3.org/2001/XMLSchema"), 6), new CodeForNameEntry(QNameHelper.forLNS("minInclusive", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("minExclusive", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("totalDigits", "http://www.w3.org/2001/XMLSchema"), 7), new CodeForNameEntry(QNameHelper.forLNS("fractionDigits", "http://www.w3.org/2001/XMLSchema"), 8)};
    private static final Map<QName, Integer> facetCodeMap = buildFacetCodeMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CodeForNameEntry {
        public int code;
        public QName name;

        public CodeForNameEntry(QName qName, int i5) {
            this.name = qName;
            this.code = i5;
        }
    }

    private static Map<QName, Integer> buildFacetCodeMap() {
        HashMap map = new HashMap();
        for (CodeForNameEntry codeForNameEntry : facetCodes) {
            map.put(codeForNameEntry.name, Integer.valueOf(codeForNameEntry.code));
        }
        return map;
    }

    private static int decimalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        int iMathematicalSizeOfType = mathematicalSizeOfType(schemaTypeImpl);
        if (iMathematicalSizeOfType == 8 && !XmlByte.type.isAssignableFrom(schemaTypeImpl)) {
            iMathematicalSizeOfType = 16;
        }
        if (iMathematicalSizeOfType != 16 || XmlShort.type.isAssignableFrom(schemaTypeImpl) || XmlUnsignedByte.type.isAssignableFrom(schemaTypeImpl)) {
            return iMathematicalSizeOfType;
        }
        return 32;
    }

    public static boolean facetAppliesToType(int i5, SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            return i5 == 10 || i5 == 11;
        }
        if (simpleVariety == 3) {
            if (i5 != 0 && i5 != 1 && i5 != 2) {
                switch (i5) {
                    case 9:
                    case 10:
                    case 11:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
        switch (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return false;
            case 3:
                return i5 == 9 || i5 == 10;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
                if (i5 != 0 && i5 != 1 && i5 != 2) {
                    switch (i5) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            case 9:
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                switch (i5) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    case 7:
                    case 8:
                    default:
                        return false;
                }
            case 11:
                switch (i5) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private static boolean isDiscreteType(SchemaTypeImpl schemaTypeImpl) {
        int builtinTypeCode;
        if (schemaTypeImpl.getFacet(8) == null && (builtinTypeCode = schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) != 3) {
            switch (builtinTypeCode) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean isMultipleFacet(int i5) {
        return i5 == 11 || i5 == 10;
    }

    private static boolean isNumericPrimitive(SchemaType schemaType) {
        switch (schemaType.getBuiltinTypeCode()) {
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SchemaType.Ref[] lambda$makeRefArray$0(int i5) {
        return new SchemaType.Ref[i5];
    }

    private static SchemaType.Ref[] makeRefArray(List<? extends SchemaType> list) {
        return (SchemaType.Ref[]) list.stream().map(new m(1)).toArray(new f(13));
    }

    private static XmlValueRef[] makeValueRefArray(XmlAnySimpleType[] xmlAnySimpleTypeArr) {
        int length = xmlAnySimpleTypeArr.length;
        XmlValueRef[] xmlValueRefArr = new XmlValueRef[length];
        for (int i5 = 0; i5 < length; i5++) {
            XmlAnySimpleType xmlAnySimpleType = xmlAnySimpleTypeArr[i5];
            xmlValueRefArr[i5] = xmlAnySimpleType == null ? null : new XmlValueRef(xmlAnySimpleType);
        }
        return xmlValueRefArr;
    }

    private static int mathematicalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode() != 11) {
            return 0;
        }
        if (schemaTypeImpl.getFacet(8) == null || ((SimpleValue) schemaTypeImpl.getFacet(8)).getBigIntegerValue().signum() != 0) {
            return SchemaType.SIZE_BIG_DECIMAL;
        }
        BigInteger bigIntegerValueOf = null;
        BigInteger bigIntegerValue = schemaTypeImpl.getFacet(3) != null ? ((SimpleValue) schemaTypeImpl.getFacet(3)).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(4) != null) {
            bigIntegerValue = ((SimpleValue) schemaTypeImpl.getFacet(4)).getBigIntegerValue();
        }
        BigInteger bigIntegerValue2 = schemaTypeImpl.getFacet(5) != null ? ((SimpleValue) schemaTypeImpl.getFacet(5)).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(6) != null) {
            bigIntegerValue2 = ((SimpleValue) schemaTypeImpl.getFacet(6)).getBigIntegerValue();
        }
        if (schemaTypeImpl.getFacet(7) != null) {
            try {
                switch (((SimpleValue) schemaTypeImpl.getFacet(7)).getBigIntegerValue().intValue()) {
                    case 0:
                    case 1:
                    case 2:
                        bigIntegerValueOf = BigInteger.valueOf(99L);
                        break;
                    case 3:
                    case 4:
                        bigIntegerValueOf = BigInteger.valueOf(9999L);
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        bigIntegerValueOf = BigInteger.valueOf(999999999L);
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        bigIntegerValueOf = BigInteger.valueOf(999999999999999999L);
                        break;
                }
            } catch (XmlValueOutOfRangeException unused) {
            }
            if (bigIntegerValueOf != null) {
                BigInteger bigIntegerNegate = bigIntegerValueOf.negate();
                if (bigIntegerValue != null) {
                    bigIntegerNegate = bigIntegerValue.max(bigIntegerNegate);
                }
                bigIntegerValue = bigIntegerNegate;
                bigIntegerValue2 = bigIntegerValue2 == null ? bigIntegerValueOf : bigIntegerValue2.min(bigIntegerValueOf);
            }
        }
        if (bigIntegerValue == null || bigIntegerValue2 == null) {
            return SchemaType.SIZE_BIG_INTEGER;
        }
        if (bigIntegerValue.signum() < 0) {
            bigIntegerValue = bigIntegerValue.negate().subtract(BigInteger.ONE);
        }
        if (bigIntegerValue2.signum() < 0) {
            bigIntegerValue2 = bigIntegerValue2.negate().subtract(BigInteger.ONE);
        }
        BigInteger bigIntegerMax = bigIntegerValue2.max(bigIntegerValue);
        if (bigIntegerMax.compareTo(BigInteger.valueOf(127L)) <= 0) {
            return 8;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(32767L)) <= 0) {
            return 16;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(2147483647L)) <= 0) {
            return 32;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL)) <= 0) {
            return 64;
        }
        return SchemaType.SIZE_BIG_INTEGER;
    }

    private static int other_similar_limit(int i5) {
        if (i5 == 3) {
            return 4;
        }
        if (i5 == 4) {
            return 3;
        }
        if (i5 == 5) {
            return 6;
        }
        if (i5 == 6) {
            return 5;
        }
        throw new IllegalStateException();
    }

    public static void resolveErrorSimpleType(SchemaTypeImpl schemaTypeImpl) {
        schemaTypeImpl.setSimpleTypeVariety(1);
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl2.getRef());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:164:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:172:0x02f9 A[Catch: all -> 0x005d, TryCatch #5 {all -> 0x005d, blocks: (B:5:0x001d, B:7:0x0026, B:213:0x0393, B:11:0x003d, B:13:0x004b, B:16:0x0061, B:18:0x0069, B:24:0x007c, B:25:0x008d, B:27:0x0091, B:29:0x0097, B:30:0x009e, B:34:0x00b1, B:36:0x00bc, B:37:0x00c1, B:41:0x00dd, B:43:0x00ee, B:44:0x00f3, B:47:0x010f, B:49:0x011d, B:51:0x0129, B:52:0x0135, B:54:0x013f, B:55:0x0144, B:57:0x0148, B:59:0x0150, B:60:0x0158, B:62:0x015e, B:64:0x0164, B:65:0x016a, B:67:0x016e, B:69:0x0174, B:70:0x017a, B:71:0x017e, B:73:0x0188, B:74:0x018f, B:76:0x0193, B:78:0x019b, B:79:0x01a3, B:81:0x01a7, B:83:0x01ad, B:84:0x01b3, B:85:0x01b7, B:87:0x01bf, B:101:0x01de, B:102:0x01e7, B:104:0x01eb, B:106:0x01f3, B:107:0x01fc, B:109:0x0200, B:111:0x0206, B:113:0x020c, B:115:0x0213, B:116:0x021f, B:130:0x0243, B:131:0x0248, B:142:0x0263, B:143:0x0272, B:144:0x0281, B:145:0x0290, B:146:0x029f, B:148:0x02a9, B:149:0x02b0, B:151:0x02b6, B:153:0x02be, B:154:0x02c7, B:156:0x02cb, B:158:0x02d1, B:162:0x02da, B:166:0x02e7, B:169:0x02f0, B:170:0x02f5, B:172:0x02f9, B:174:0x02ff, B:175:0x0307, B:177:0x030d, B:179:0x0313, B:180:0x031b, B:181:0x031f, B:183:0x032b, B:184:0x0332, B:186:0x0336, B:188:0x033e, B:189:0x0347, B:191:0x034c, B:193:0x0352, B:195:0x035a, B:199:0x0364, B:200:0x0369, B:202:0x036d, B:204:0x0373, B:206:0x037b, B:208:0x0381, B:209:0x0387, B:210:0x0389, B:212:0x038f, B:39:0x00c7, B:46:0x00f9), top: B:270:0x001d, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0307 A[Catch: all -> 0x005d, TryCatch #5 {all -> 0x005d, blocks: (B:5:0x001d, B:7:0x0026, B:213:0x0393, B:11:0x003d, B:13:0x004b, B:16:0x0061, B:18:0x0069, B:24:0x007c, B:25:0x008d, B:27:0x0091, B:29:0x0097, B:30:0x009e, B:34:0x00b1, B:36:0x00bc, B:37:0x00c1, B:41:0x00dd, B:43:0x00ee, B:44:0x00f3, B:47:0x010f, B:49:0x011d, B:51:0x0129, B:52:0x0135, B:54:0x013f, B:55:0x0144, B:57:0x0148, B:59:0x0150, B:60:0x0158, B:62:0x015e, B:64:0x0164, B:65:0x016a, B:67:0x016e, B:69:0x0174, B:70:0x017a, B:71:0x017e, B:73:0x0188, B:74:0x018f, B:76:0x0193, B:78:0x019b, B:79:0x01a3, B:81:0x01a7, B:83:0x01ad, B:84:0x01b3, B:85:0x01b7, B:87:0x01bf, B:101:0x01de, B:102:0x01e7, B:104:0x01eb, B:106:0x01f3, B:107:0x01fc, B:109:0x0200, B:111:0x0206, B:113:0x020c, B:115:0x0213, B:116:0x021f, B:130:0x0243, B:131:0x0248, B:142:0x0263, B:143:0x0272, B:144:0x0281, B:145:0x0290, B:146:0x029f, B:148:0x02a9, B:149:0x02b0, B:151:0x02b6, B:153:0x02be, B:154:0x02c7, B:156:0x02cb, B:158:0x02d1, B:162:0x02da, B:166:0x02e7, B:169:0x02f0, B:170:0x02f5, B:172:0x02f9, B:174:0x02ff, B:175:0x0307, B:177:0x030d, B:179:0x0313, B:180:0x031b, B:181:0x031f, B:183:0x032b, B:184:0x0332, B:186:0x0336, B:188:0x033e, B:189:0x0347, B:191:0x034c, B:193:0x0352, B:195:0x035a, B:199:0x0364, B:200:0x0369, B:202:0x036d, B:204:0x0373, B:206:0x037b, B:208:0x0381, B:209:0x0387, B:210:0x0389, B:212:0x038f, B:39:0x00c7, B:46:0x00f9), top: B:270:0x001d, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x030d A[Catch: all -> 0x005d, TryCatch #5 {all -> 0x005d, blocks: (B:5:0x001d, B:7:0x0026, B:213:0x0393, B:11:0x003d, B:13:0x004b, B:16:0x0061, B:18:0x0069, B:24:0x007c, B:25:0x008d, B:27:0x0091, B:29:0x0097, B:30:0x009e, B:34:0x00b1, B:36:0x00bc, B:37:0x00c1, B:41:0x00dd, B:43:0x00ee, B:44:0x00f3, B:47:0x010f, B:49:0x011d, B:51:0x0129, B:52:0x0135, B:54:0x013f, B:55:0x0144, B:57:0x0148, B:59:0x0150, B:60:0x0158, B:62:0x015e, B:64:0x0164, B:65:0x016a, B:67:0x016e, B:69:0x0174, B:70:0x017a, B:71:0x017e, B:73:0x0188, B:74:0x018f, B:76:0x0193, B:78:0x019b, B:79:0x01a3, B:81:0x01a7, B:83:0x01ad, B:84:0x01b3, B:85:0x01b7, B:87:0x01bf, B:101:0x01de, B:102:0x01e7, B:104:0x01eb, B:106:0x01f3, B:107:0x01fc, B:109:0x0200, B:111:0x0206, B:113:0x020c, B:115:0x0213, B:116:0x021f, B:130:0x0243, B:131:0x0248, B:142:0x0263, B:143:0x0272, B:144:0x0281, B:145:0x0290, B:146:0x029f, B:148:0x02a9, B:149:0x02b0, B:151:0x02b6, B:153:0x02be, B:154:0x02c7, B:156:0x02cb, B:158:0x02d1, B:162:0x02da, B:166:0x02e7, B:169:0x02f0, B:170:0x02f5, B:172:0x02f9, B:174:0x02ff, B:175:0x0307, B:177:0x030d, B:179:0x0313, B:180:0x031b, B:181:0x031f, B:183:0x032b, B:184:0x0332, B:186:0x0336, B:188:0x033e, B:189:0x0347, B:191:0x034c, B:193:0x0352, B:195:0x035a, B:199:0x0364, B:200:0x0369, B:202:0x036d, B:204:0x0373, B:206:0x037b, B:208:0x0381, B:209:0x0387, B:210:0x0389, B:212:0x038f, B:39:0x00c7, B:46:0x00f9), top: B:270:0x001d, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x038f A[Catch: all -> 0x005d, TryCatch #5 {all -> 0x005d, blocks: (B:5:0x001d, B:7:0x0026, B:213:0x0393, B:11:0x003d, B:13:0x004b, B:16:0x0061, B:18:0x0069, B:24:0x007c, B:25:0x008d, B:27:0x0091, B:29:0x0097, B:30:0x009e, B:34:0x00b1, B:36:0x00bc, B:37:0x00c1, B:41:0x00dd, B:43:0x00ee, B:44:0x00f3, B:47:0x010f, B:49:0x011d, B:51:0x0129, B:52:0x0135, B:54:0x013f, B:55:0x0144, B:57:0x0148, B:59:0x0150, B:60:0x0158, B:62:0x015e, B:64:0x0164, B:65:0x016a, B:67:0x016e, B:69:0x0174, B:70:0x017a, B:71:0x017e, B:73:0x0188, B:74:0x018f, B:76:0x0193, B:78:0x019b, B:79:0x01a3, B:81:0x01a7, B:83:0x01ad, B:84:0x01b3, B:85:0x01b7, B:87:0x01bf, B:101:0x01de, B:102:0x01e7, B:104:0x01eb, B:106:0x01f3, B:107:0x01fc, B:109:0x0200, B:111:0x0206, B:113:0x020c, B:115:0x0213, B:116:0x021f, B:130:0x0243, B:131:0x0248, B:142:0x0263, B:143:0x0272, B:144:0x0281, B:145:0x0290, B:146:0x029f, B:148:0x02a9, B:149:0x02b0, B:151:0x02b6, B:153:0x02be, B:154:0x02c7, B:156:0x02cb, B:158:0x02d1, B:162:0x02da, B:166:0x02e7, B:169:0x02f0, B:170:0x02f5, B:172:0x02f9, B:174:0x02ff, B:175:0x0307, B:177:0x030d, B:179:0x0313, B:180:0x031b, B:181:0x031f, B:183:0x032b, B:184:0x0332, B:186:0x0336, B:188:0x033e, B:189:0x0347, B:191:0x034c, B:193:0x0352, B:195:0x035a, B:199:0x0364, B:200:0x0369, B:202:0x036d, B:204:0x0373, B:206:0x037b, B:208:0x0381, B:209:0x0387, B:210:0x0389, B:212:0x038f, B:39:0x00c7, B:46:0x00f9), top: B:270:0x001d, inners: #0, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x040e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0125 A[PHI: r13 r14 r15 r20 r24
  0x0125: PHI (r13v10 int) = 
  (r13v5 int)
  (r13v5 int)
  (r13v6 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v5 int)
  (r13v8 int)
  (r13v5 int)
 binds: [B:39:0x00c7, B:46:0x00f9, B:211:0x038d, B:208:0x0381, B:199:0x0364, B:188:0x033e, B:183:0x032b, B:179:0x0313, B:174:0x02ff, B:169:0x02f0, B:153:0x02be, B:148:0x02a9, B:145:0x0290, B:144:0x0281, B:143:0x0272, B:142:0x0263, B:141:0x0261, B:130:0x0243, B:106:0x01f3, B:87:0x01bf, B:78:0x019b, B:59:0x0150, B:49:0x011d, B:10:0x0039] A[DONT_GENERATE, DONT_INLINE]
  0x0125: PHI (r14v8 java.util.ArrayList) = 
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v6 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
  (r14v3 java.util.ArrayList)
 binds: [B:39:0x00c7, B:46:0x00f9, B:211:0x038d, B:208:0x0381, B:199:0x0364, B:188:0x033e, B:183:0x032b, B:179:0x0313, B:174:0x02ff, B:169:0x02f0, B:153:0x02be, B:148:0x02a9, B:145:0x0290, B:144:0x0281, B:143:0x0272, B:142:0x0263, B:141:0x0261, B:130:0x0243, B:106:0x01f3, B:87:0x01bf, B:78:0x019b, B:59:0x0150, B:49:0x011d, B:10:0x0039] A[DONT_GENERATE, DONT_INLINE]
  0x0125: PHI (r15v8 java.util.ArrayList) = 
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v6 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
  (r15v3 java.util.ArrayList)
 binds: [B:39:0x00c7, B:46:0x00f9, B:211:0x038d, B:208:0x0381, B:199:0x0364, B:188:0x033e, B:183:0x032b, B:179:0x0313, B:174:0x02ff, B:169:0x02f0, B:153:0x02be, B:148:0x02a9, B:145:0x0290, B:144:0x0281, B:143:0x0272, B:142:0x0263, B:141:0x0261, B:130:0x0243, B:106:0x01f3, B:87:0x01bf, B:78:0x019b, B:59:0x0150, B:49:0x011d, B:10:0x0039] A[DONT_GENERATE, DONT_INLINE]
  0x0125: PHI (r20v2 boolean[]) = 
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v0 boolean[])
  (r20v3 boolean[])
 binds: [B:39:0x00c7, B:46:0x00f9, B:211:0x038d, B:208:0x0381, B:199:0x0364, B:188:0x033e, B:183:0x032b, B:179:0x0313, B:174:0x02ff, B:169:0x02f0, B:153:0x02be, B:148:0x02a9, B:145:0x0290, B:144:0x0281, B:143:0x0272, B:142:0x0263, B:141:0x0261, B:130:0x0243, B:106:0x01f3, B:87:0x01bf, B:78:0x019b, B:59:0x0150, B:49:0x011d, B:10:0x0039] A[DONT_GENERATE, DONT_INLINE]
  0x0125: PHI (r24v5 org.apache.xmlbeans.XmlAnySimpleType[]) = 
  (r24v7 org.apache.xmlbeans.XmlAnySimpleType[])
  (r24v8 org.apache.xmlbeans.XmlObject[])
  (r24v9 org.apache.xmlbeans.XmlObject[])
  (r24v10 org.apache.xmlbeans.XmlObject[])
  (r24v11 org.apache.xmlbeans.XmlObject[])
  (r24v12 org.apache.xmlbeans.XmlObject[])
  (r24v13 org.apache.xmlbeans.XmlObject[])
  (r24v14 org.apache.xmlbeans.XmlObject[])
  (r24v15 org.apache.xmlbeans.XmlObject[])
  (r24v16 org.apache.xmlbeans.XmlObject[])
  (r24v17 org.apache.xmlbeans.XmlObject[])
  (r24v18 org.apache.xmlbeans.XmlObject[])
  (r24v19 org.apache.xmlbeans.XmlObject[])
  (r24v20 org.apache.xmlbeans.XmlObject[])
  (r24v21 org.apache.xmlbeans.XmlObject[])
  (r24v22 org.apache.xmlbeans.XmlObject[])
  (r24v23 org.apache.xmlbeans.XmlObject[])
  (r24v24 org.apache.xmlbeans.XmlObject[])
  (r24v25 org.apache.xmlbeans.XmlObject[])
  (r24v26 org.apache.xmlbeans.XmlObject[])
  (r24v27 org.apache.xmlbeans.XmlObject[])
  (r24v28 org.apache.xmlbeans.XmlObject[])
  (r24v29 org.apache.xmlbeans.XmlObject[])
  (r24v6 org.apache.xmlbeans.XmlAnySimpleType[])
 binds: [B:39:0x00c7, B:46:0x00f9, B:211:0x038d, B:208:0x0381, B:199:0x0364, B:188:0x033e, B:183:0x032b, B:179:0x0313, B:174:0x02ff, B:169:0x02f0, B:153:0x02be, B:148:0x02a9, B:145:0x0290, B:144:0x0281, B:143:0x0272, B:142:0x0263, B:141:0x0261, B:130:0x0243, B:106:0x01f3, B:87:0x01bf, B:78:0x019b, B:59:0x0150, B:49:0x011d, B:10:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public static void resolveFacets(SchemaTypeImpl schemaTypeImpl, XmlObject xmlObject, SchemaTypeImpl schemaTypeImpl2) {
        XmlAnySimpleType[] xmlAnySimpleTypeArr;
        boolean z6;
        int i5;
        int whiteSpaceRule;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i6;
        SchemaType baseEnumType;
        SchemaType baseEnumType2;
        boolean[] zArr;
        boolean z7;
        XmlAnySimpleType facet;
        XmlAnySimpleType facet2;
        XmlAnySimpleType xmlAnySimpleType;
        XmlAnySimpleType xmlAnySimpleType2;
        XmlAnySimpleType[] xmlAnySimpleTypeArr2;
        XmlAnySimpleType[] xmlAnySimpleTypeArr3;
        StscState stscState = StscState.get();
        boolean[] zArr2 = new boolean[12];
        XmlAnySimpleType[] basicFacets = schemaTypeImpl2.getBasicFacets();
        boolean[] fixedFacets = schemaTypeImpl2.getFixedFacets();
        boolean z8 = true;
        if (xmlObject != null) {
            XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
            try {
                boolean firstChild = xmlCursorNewCursor.toFirstChild();
                whiteSpaceRule = 0;
                arrayList = null;
                arrayList2 = null;
                while (firstChild) {
                    QName name = xmlCursorNewCursor.getName();
                    String localPart = name.getLocalPart();
                    int iTranslateFacetCode = translateFacetCode(name);
                    if (iTranslateFacetCode == -1) {
                        zArr = zArr2;
                        xmlAnySimpleTypeArr3 = basicFacets;
                        z7 = true;
                        xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                    } else {
                        Facet facet3 = (Facet) xmlCursorNewCursor.getObject();
                        if (facetAppliesToType(iTranslateFacetCode, schemaTypeImpl2)) {
                            zArr = zArr2;
                            if (schemaTypeImpl2.getSimpleVariety() == z8 && schemaTypeImpl2.getPrimitiveType().getBuiltinTypeCode() == 8 && (iTranslateFacetCode == 0 || iTranslateFacetCode == z8 || iTranslateFacetCode == 2)) {
                                stscState.warning(XmlErrorCodes.FACETS_DEPRECATED_NOTATION, new Object[]{localPart, QNameHelper.pretty(schemaTypeImpl2.getName())}, facet3);
                            }
                            if (!zArr[iTranslateFacetCode] || isMultipleFacet(iTranslateFacetCode)) {
                                zArr[iTranslateFacetCode] = z8;
                                XmlObject[] xmlObjectArr = basicFacets;
                                switch (iTranslateFacetCode) {
                                    case 0:
                                        XmlNonNegativeInteger xmlNonNegativeIntegerBuildNnInteger = StscTranslator.buildNnInteger(facet3.getValue());
                                        if (xmlNonNegativeIntegerBuildNnInteger == null) {
                                            stscState.error("Must be a nonnegative integer", 20, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        } else if (fixedFacets[iTranslateFacetCode] && !xmlObjectArr[iTranslateFacetCode].valueEquals(xmlNonNegativeIntegerBuildNnInteger)) {
                                            stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        } else if (xmlObjectArr[1] != null && ((facet2 = schemaTypeImpl2.getFacet(1)) == null || !facet2.valueEquals(xmlObjectArr[1]) || facet2.compareValue(xmlNonNegativeIntegerBuildNnInteger) > 0)) {
                                            stscState.error(XmlErrorCodes.DATATYPE_LENGTH, (Object[]) null, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        } else if (xmlObjectArr[2] == null || ((facet = schemaTypeImpl2.getFacet(2)) != null && facet.valueEquals(xmlObjectArr[2]) && facet.compareValue(xmlNonNegativeIntegerBuildNnInteger) >= 0)) {
                                            xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger;
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            if (!facet3.getFixed()) {
                                                z7 = true;
                                                fixedFacets[iTranslateFacetCode] = true;
                                                xmlAnySimpleTypeArr2 = xmlObjectArr;
                                            }
                                        } else {
                                            stscState.error(XmlErrorCodes.DATATYPE_LENGTH, (Object[]) null, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        }
                                        z7 = true;
                                        xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        break;
                                    case 1:
                                    case 2:
                                        XmlNonNegativeInteger xmlNonNegativeIntegerBuildNnInteger2 = StscTranslator.buildNnInteger(facet3.getValue());
                                        if (xmlNonNegativeIntegerBuildNnInteger2 == null) {
                                            stscState.error("Must be a nonnegative integer", 20, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        } else if (fixedFacets[iTranslateFacetCode] && !xmlObjectArr[iTranslateFacetCode].valueEquals(xmlNonNegativeIntegerBuildNnInteger2)) {
                                            stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        } else if (xmlObjectArr[0] == null) {
                                            xmlAnySimpleType = xmlObjectArr[2];
                                            if (xmlAnySimpleType != null || xmlNonNegativeIntegerBuildNnInteger2.compareValue(xmlAnySimpleType) <= 0) {
                                                xmlAnySimpleType2 = xmlObjectArr[1];
                                                if (xmlAnySimpleType2 != null || xmlNonNegativeIntegerBuildNnInteger2.compareValue(xmlAnySimpleType2) >= 0) {
                                                    xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger2;
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                    if (!facet3.getFixed()) {
                                                        z7 = true;
                                                        fixedFacets[iTranslateFacetCode] = true;
                                                        xmlAnySimpleTypeArr2 = xmlObjectArr;
                                                    }
                                                } else {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MIN_LENGTH_RESTRICTION, (Object[]) null, facet3);
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                }
                                            } else {
                                                stscState.error(XmlErrorCodes.DATATYPE_MAX_LENGTH_RESTRICTION, (Object[]) null, facet3);
                                                xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            }
                                        } else {
                                            XmlAnySimpleType facet4 = schemaTypeImpl2.getFacet(iTranslateFacetCode);
                                            if (facet4 != null && facet4.valueEquals(xmlNonNegativeIntegerBuildNnInteger2)) {
                                                if (iTranslateFacetCode == 1) {
                                                    if (facet4.compareTo(xmlObjectArr[0]) <= 0) {
                                                        xmlAnySimpleType = xmlObjectArr[2];
                                                        if (xmlAnySimpleType != null) {
                                                            xmlAnySimpleType2 = xmlObjectArr[1];
                                                            if (xmlAnySimpleType2 != null) {
                                                            }
                                                            xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger2;
                                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                            if (!facet3.getFixed()) {
                                                                z7 = true;
                                                                fixedFacets[iTranslateFacetCode] = true;
                                                                xmlAnySimpleTypeArr2 = xmlObjectArr;
                                                            }
                                                        } else {
                                                            xmlAnySimpleType2 = xmlObjectArr[1];
                                                            if (xmlAnySimpleType2 != null) {
                                                            }
                                                            xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger2;
                                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                            if (!facet3.getFixed()) {
                                                                z7 = true;
                                                                fixedFacets[iTranslateFacetCode] = true;
                                                                xmlAnySimpleTypeArr2 = xmlObjectArr;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                } else if (facet4.compareTo(xmlObjectArr[0]) >= 0) {
                                                    xmlAnySimpleType = xmlObjectArr[2];
                                                    if (xmlAnySimpleType != null) {
                                                        xmlAnySimpleType2 = xmlObjectArr[1];
                                                        if (xmlAnySimpleType2 != null) {
                                                        }
                                                        xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger2;
                                                        xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                        if (!facet3.getFixed()) {
                                                            z7 = true;
                                                            fixedFacets[iTranslateFacetCode] = true;
                                                            xmlAnySimpleTypeArr2 = xmlObjectArr;
                                                        }
                                                    } else {
                                                        xmlAnySimpleType2 = xmlObjectArr[1];
                                                        if (xmlAnySimpleType2 != null) {
                                                        }
                                                        xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger2;
                                                        xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                        if (!facet3.getFixed()) {
                                                            z7 = true;
                                                            fixedFacets[iTranslateFacetCode] = true;
                                                            xmlAnySimpleTypeArr2 = xmlObjectArr;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            stscState.error(XmlErrorCodes.DATATYPE_LENGTH, (Object[]) null, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        }
                                        z7 = true;
                                        xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                        if (zArr[other_similar_limit(iTranslateFacetCode)]) {
                                            stscState.error("Cannot define both inclusive and exclusive limit in the same restriciton", 19, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        } else {
                                            boolean z9 = iTranslateFacetCode == 3 || iTranslateFacetCode == 4;
                                            boolean z10 = iTranslateFacetCode == 3 || iTranslateFacetCode == 6;
                                            try {
                                                XmlAnySimpleType xmlAnySimpleTypeNewValue = schemaTypeImpl2.newValue(facet3.getValue(), true);
                                                if (!fixedFacets[iTranslateFacetCode] || xmlObjectArr[iTranslateFacetCode].valueEquals(xmlAnySimpleTypeNewValue)) {
                                                    if (xmlObjectArr[iTranslateFacetCode] != null) {
                                                        SchemaType schemaType = xmlAnySimpleTypeNewValue.schemaType();
                                                        if (schemaType != null && !schemaType.isSimpleType() && schemaType.getContentType() == 2) {
                                                            xmlAnySimpleTypeNewValue = schemaTypeImpl2.getContentBasedOnType().newValue(facet3.getValue());
                                                        }
                                                        int iCompareValue = xmlAnySimpleTypeNewValue.compareValue(xmlObjectArr[iTranslateFacetCode]);
                                                        if (iCompareValue != 2) {
                                                            if (iCompareValue == (z9 ? -1 : 1)) {
                                                            }
                                                        }
                                                        stscState.error(z9 ? z10 ? "Must be greater than or equal to previous minExclusive" : "Must be greater than or equal to previous minInclusive" : z10 ? "Must be less than or equal to previous maxExclusive" : "Must be less than or equal to previous maxInclusive", 20, facet3);
                                                        xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                    }
                                                    xmlObjectArr[iTranslateFacetCode] = xmlAnySimpleTypeNewValue;
                                                    xmlObjectArr[other_similar_limit(iTranslateFacetCode)] = null;
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                    if (!facet3.getFixed()) {
                                                        z7 = true;
                                                        fixedFacets[iTranslateFacetCode] = true;
                                                        xmlAnySimpleTypeArr2 = xmlObjectArr;
                                                    }
                                                } else {
                                                    stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                }
                                                break;
                                            } catch (XmlValueOutOfRangeException e) {
                                                if (iTranslateFacetCode == 3) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                } else if (iTranslateFacetCode == 4) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                } else if (iTranslateFacetCode == 5) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                } else if (iTranslateFacetCode != 6) {
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                } else {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                    xmlAnySimpleTypeArr3 = xmlObjectArr;
                                                }
                                            }
                                        }
                                        z7 = true;
                                        xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        break;
                                    case 7:
                                        XmlPositiveInteger xmlPositiveIntegerBuildPosInteger = StscTranslator.buildPosInteger(facet3.getValue());
                                        if (xmlPositiveIntegerBuildPosInteger != null) {
                                            if (!fixedFacets[iTranslateFacetCode] || xmlObjectArr[iTranslateFacetCode].valueEquals(xmlPositiveIntegerBuildPosInteger)) {
                                                XmlObject xmlObject2 = xmlObjectArr[7];
                                                if (xmlObject2 != null && xmlPositiveIntegerBuildPosInteger.compareValue(xmlObject2) > 0) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_RESTRICTION, (Object[]) null, facet3);
                                                }
                                                xmlObjectArr[iTranslateFacetCode] = xmlPositiveIntegerBuildPosInteger;
                                            } else {
                                                stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                                xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            }
                                            z7 = true;
                                            xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        } else {
                                            stscState.error("Must be a positive integer", 20, facet3);
                                        }
                                        xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        if (!facet3.getFixed()) {
                                            z7 = true;
                                            xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        } else {
                                            z7 = true;
                                            fixedFacets[iTranslateFacetCode] = true;
                                            xmlAnySimpleTypeArr2 = xmlObjectArr;
                                        }
                                        break;
                                    case 8:
                                        XmlNonNegativeInteger xmlNonNegativeIntegerBuildNnInteger3 = StscTranslator.buildNnInteger(facet3.getValue());
                                        if (xmlNonNegativeIntegerBuildNnInteger3 != null) {
                                            if (!fixedFacets[iTranslateFacetCode] || xmlObjectArr[iTranslateFacetCode].valueEquals(xmlNonNegativeIntegerBuildNnInteger3)) {
                                                XmlObject xmlObject3 = xmlObjectArr[8];
                                                if (xmlObject3 != null && xmlNonNegativeIntegerBuildNnInteger3.compareValue(xmlObject3) > 0) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_FRACTION_DIGITS_RESTRICTION, (Object[]) null, facet3);
                                                }
                                                XmlObject xmlObject4 = xmlObjectArr[7];
                                                if (xmlObject4 != null && xmlNonNegativeIntegerBuildNnInteger3.compareValue(xmlObject4) > 0) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_FRACTION_DIGITS_LE_TOTAL_DIGITS, (Object[]) null, facet3);
                                                }
                                                xmlObjectArr[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger3;
                                            } else {
                                                stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                                xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            }
                                            z7 = true;
                                            xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        } else {
                                            stscState.error("Must be a nonnegative integer", 20, facet3);
                                        }
                                        xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        if (!facet3.getFixed()) {
                                            z7 = true;
                                            xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        } else {
                                            z7 = true;
                                            fixedFacets[iTranslateFacetCode] = true;
                                            xmlAnySimpleTypeArr2 = xmlObjectArr;
                                        }
                                        break;
                                    case 9:
                                        whiteSpaceRule = translateWhitespaceCode(facet3.getValue());
                                        if (schemaTypeImpl2.getWhiteSpaceRule() <= whiteSpaceRule) {
                                            xmlObjectArr[iTranslateFacetCode] = StscState.build_wsstring(whiteSpaceRule).get();
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            if (!facet3.getFixed()) {
                                                z7 = true;
                                                fixedFacets[iTranslateFacetCode] = true;
                                                xmlAnySimpleTypeArr2 = xmlObjectArr;
                                            }
                                        } else {
                                            stscState.error(XmlErrorCodes.DATATYPE_WHITESPACE_RESTRICTION, (Object[]) null, facet3);
                                            whiteSpaceRule = 0;
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        }
                                        z7 = true;
                                        xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        break;
                                    case 10:
                                        try {
                                            RegularExpression regularExpression = new RegularExpression(facet3.getValue().getStringValue(), "X");
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(regularExpression);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            if (!facet3.getFixed()) {
                                                z7 = true;
                                                xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                            } else {
                                                z7 = true;
                                                fixedFacets[iTranslateFacetCode] = true;
                                                xmlAnySimpleTypeArr2 = xmlObjectArr;
                                            }
                                        } catch (ParseException e6) {
                                            stscState.error(XmlErrorCodes.PATTERN_REGEX, new Object[]{facet3.getValue().getStringValue(), e6.getMessage()}, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        }
                                        break;
                                    case 11:
                                        try {
                                            XmlAnySimpleType xmlAnySimpleTypeNewValue2 = schemaTypeImpl2.newValue(facet3.getValue(), true);
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(xmlAnySimpleTypeNewValue2);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                            if (!facet3.getFixed()) {
                                                z7 = true;
                                                xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                            } else {
                                                z7 = true;
                                                fixedFacets[iTranslateFacetCode] = true;
                                                xmlAnySimpleTypeArr2 = xmlObjectArr;
                                            }
                                        } catch (XmlValueOutOfRangeException e7) {
                                            stscState.error(XmlErrorCodes.DATATYPE_ENUM_RESTRICTION, new Object[]{facet3.getValue().getStringValue(), e7.getMessage()}, facet3);
                                            xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        }
                                        break;
                                    default:
                                        xmlAnySimpleTypeArr3 = xmlObjectArr;
                                        if (!facet3.getFixed()) {
                                            z7 = true;
                                            xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                                        } else {
                                            z7 = true;
                                            fixedFacets[iTranslateFacetCode] = true;
                                            xmlAnySimpleTypeArr2 = xmlObjectArr;
                                        }
                                        break;
                                }
                            } else {
                                stscState.error(XmlErrorCodes.DATATYPE_SINGLE_FACET_VALUE, (Object[]) null, facet3);
                                xmlAnySimpleTypeArr3 = basicFacets;
                                z7 = true;
                                xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                            }
                        } else {
                            stscState.error(XmlErrorCodes.FACETS_APPLICABLE, new Object[]{localPart, QNameHelper.pretty(schemaTypeImpl2.getName())}, facet3);
                            zArr = zArr2;
                            xmlAnySimpleTypeArr3 = basicFacets;
                            z7 = true;
                            xmlAnySimpleTypeArr2 = xmlAnySimpleTypeArr3;
                        }
                    }
                    firstChild = xmlCursorNewCursor.toNextSibling();
                    zArr2 = zArr;
                    z8 = z7;
                    basicFacets = xmlAnySimpleTypeArr2;
                }
                xmlAnySimpleTypeArr = basicFacets;
                z6 = z8;
                i5 = 0;
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor == null) {
                        throw th2;
                    }
                    try {
                        xmlCursorNewCursor.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        } else {
            xmlAnySimpleTypeArr = basicFacets;
            z6 = true;
            i5 = 0;
            whiteSpaceRule = 0;
            arrayList = null;
            arrayList2 = null;
        }
        schemaTypeImpl.setBasicFacets(makeValueRefArray(xmlAnySimpleTypeArr), fixedFacets);
        if (whiteSpaceRule == 0) {
            whiteSpaceRule = schemaTypeImpl2.getWhiteSpaceRule();
        }
        schemaTypeImpl.setWhiteSpaceRule(whiteSpaceRule);
        if (arrayList != null) {
            i6 = i5;
            schemaTypeImpl.setEnumerationValues(makeValueRefArray((XmlAnySimpleType[]) arrayList.toArray(new XmlAnySimpleType[i6])));
            if (schemaTypeImpl.isRedefinition()) {
                baseEnumType2 = schemaTypeImpl.getBaseType().getBaseEnumType();
                if (baseEnumType2 == null || schemaTypeImpl.getBaseType() == baseEnumType2) {
                    baseEnumType = baseEnumType2;
                    baseEnumType = schemaTypeImpl;
                }
            } else if (schemaTypeImpl.getBaseType().getBaseEnumType() != null) {
                baseEnumType = schemaTypeImpl.getBaseType().getBaseEnumType();
            } else {
                baseEnumType = baseEnumType2;
                baseEnumType = schemaTypeImpl;
            }
            baseEnumType = baseEnumType2;
            schemaTypeImpl.setBaseEnumTypeRef(baseEnumType.getRef());
        } else {
            i6 = i5;
            schemaTypeImpl.copyEnumerationValues(schemaTypeImpl2);
        }
        RegularExpression[] regularExpressionArr = EMPTY_REGEX_ARRAY;
        if (arrayList2 != null) {
            regularExpressionArr = (RegularExpression[]) arrayList2.toArray(regularExpressionArr);
        }
        schemaTypeImpl.setPatternFacet((regularExpressionArr.length > 0 || schemaTypeImpl2.hasPatternFacet()) ? z6 : i6);
        schemaTypeImpl.setPatterns(regularExpressionArr);
        if (schemaTypeImpl2.getBuiltinTypeCode() == 8 && schemaTypeImpl.getEnumerationValues() == null) {
            stscState.recover(XmlErrorCodes.DATATYPE_ENUM_NOTATION, null, xmlObject);
        }
    }

    public static void resolveFundamentalFacets(SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 1) {
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
            schemaTypeImpl.setOrdered(schemaTypeImpl2.ordered());
            schemaTypeImpl.setBounded(((schemaTypeImpl.getFacet(3) == null && schemaTypeImpl.getFacet(4) == null) || (schemaTypeImpl.getFacet(5) == null && schemaTypeImpl.getFacet(6) == null)) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl2.isFinite() || (schemaTypeImpl.isBounded() && isDiscreteType(schemaTypeImpl)));
            schemaTypeImpl.setNumeric(schemaTypeImpl2.isNumeric() || isNumericPrimitive(schemaTypeImpl.getPrimitiveType()));
            schemaTypeImpl.setDecimalSize(decimalSizeOfType(schemaTypeImpl));
            return;
        }
        if (simpleVariety != 2) {
            if (simpleVariety != 3) {
                return;
            }
            schemaTypeImpl.setOrdered(0);
            schemaTypeImpl.setBounded((schemaTypeImpl.getFacet(0) == null && schemaTypeImpl.getFacet(2) == null) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl.getListItemType().isFinite() && schemaTypeImpl.isBounded());
            schemaTypeImpl.setNumeric(false);
            schemaTypeImpl.setDecimalSize(0);
            return;
        }
        int i5 = 0;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        for (SchemaType schemaType : schemaTypeImpl.getUnionMemberTypes()) {
            if (schemaType.ordered() != 0) {
                i5 = 1;
            }
            if (!schemaType.isBounded()) {
                z6 = false;
            }
            if (!schemaType.isFinite()) {
                z7 = false;
            }
            if (!schemaType.isNumeric()) {
                z8 = false;
            }
        }
        schemaTypeImpl.setOrdered(i5);
        schemaTypeImpl.setBounded(z6);
        schemaTypeImpl.setFinite(z7);
        schemaTypeImpl.setNumeric(z8);
        schemaTypeImpl.setDecimalSize(0);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
    public static void resolveListType(SchemaTypeImpl schemaTypeImpl, ListDocument.List list, List<SchemaType> list2) {
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        XmlQName xmlQNameXgetItemType;
        SchemaTypeImpl schemaTypeImpl2;
        StscState stscState = StscState.get();
        schemaTypeImpl.setSimpleTypeVariety(3);
        SchemaTypeImpl schemaTypeImpl3 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{XmlErrorCodes.LIST}, list);
        }
        QName itemType = list.getItemType();
        LocalSimpleType simpleType = list.getSimpleType();
        if (itemType != null && simpleType != null) {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$LIST_HAS_BOTH_ITEM_OR_SIMPLE_TYPE, (Object[]) null, list);
            simpleType = null;
        }
        if (itemType != null) {
            schemaTypeImplTranslateAnonymousSimpleType = stscState.findGlobalType(itemType, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            xmlQNameXgetItemType = list.xgetItemType();
            if (schemaTypeImplTranslateAnonymousSimpleType == null) {
                stscState.notFoundError(itemType, 0, list.xgetItemType(), true);
                schemaTypeImplTranslateAnonymousSimpleType = schemaTypeImpl3;
            }
        } else if (simpleType == null) {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$LIST_HAS_NEITHER_ITEM_OR_SIMPLE_TYPE, (Object[]) null, list);
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        } else {
            LocalSimpleType localSimpleType = simpleType;
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(localSimpleType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list2, schemaTypeImpl);
            xmlQNameXgetItemType = localSimpleType;
        }
        if (schemaTypeImplTranslateAnonymousSimpleType.finalList()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$LIST_FINAL, (Object[]) null, list);
        }
        StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
        if (schemaTypeImplTranslateAnonymousSimpleType.isSimpleType()) {
            schemaTypeImpl2 = schemaTypeImpl;
        } else {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_NOT_SIMPLE, (Object[]) null, xmlQNameXgetItemType);
            schemaTypeImpl2 = schemaTypeImpl3;
        }
        int simpleVariety = schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
            if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
                stscState.recover(XmlErrorCodes.DATATYPE_ENUM_NOTATION, null, xmlQNameXgetItemType);
            }
        } else if (simpleVariety == 2) {
            if (schemaTypeImplTranslateAnonymousSimpleType.isUnionOfLists()) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_IS_UNION_OF_LIST, (Object[]) null, xmlQNameXgetItemType);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
            if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
                stscState.recover(XmlErrorCodes.DATATYPE_ENUM_NOTATION, null, xmlQNameXgetItemType);
            }
        } else {
            if (simpleVariety == 3) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_IS_LIST, (Object[]) null, xmlQNameXgetItemType);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImpl3.getRef());
        }
        schemaTypeImpl2.setBasicFacets(StscState.FACETS_LIST, StscState.FIXED_FACETS_LIST);
        schemaTypeImpl2.setWhiteSpaceRule(3);
        resolveFundamentalFacets(schemaTypeImpl2);
    }

    public static void resolveSimpleRestrictionType(SchemaTypeImpl schemaTypeImpl, RestrictionDocument.Restriction restriction, List<SchemaType> list) {
        LocalSimpleType localSimpleType;
        SchemaTypeImpl schemaTypeImpl2;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        QName base = restriction.getBase();
        LocalSimpleType simpleType = restriction.getSimpleType();
        StscState stscState = StscState.get();
        if (base == null || simpleType == null) {
            localSimpleType = simpleType;
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$RESTRICTION_HAS_BOTH_BASE_OR_SIMPLE_TYPE, (Object[]) null, restriction);
            localSimpleType = null;
        }
        if (base != null) {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplTranslateAnonymousSimpleType = stscState.findRedefinedGlobalType(restriction.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplTranslateAnonymousSimpleType != null && !schemaTypeImplTranslateAnonymousSimpleType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(base), QNameHelper.pretty(schemaTypeImpl.getName())}, restriction);
                }
            } else {
                schemaTypeImplTranslateAnonymousSimpleType = stscState.findGlobalType(base, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            }
            if (schemaTypeImplTranslateAnonymousSimpleType == null) {
                stscState.notFoundError(base, 0, restriction.xgetBase(), true);
                schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
            schemaTypeImpl2 = schemaTypeImpl;
        } else if (localSimpleType != null) {
            if (schemaTypeImpl.isRedefinition()) {
                StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<simpleType>"}, localSimpleType);
            }
            schemaTypeImpl2 = schemaTypeImpl;
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(localSimpleType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl2);
        } else {
            schemaTypeImpl2 = schemaTypeImpl;
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$RESTRICTION_HAS_NEITHER_BASE_OR_SIMPLE_TYPE, (Object[]) null, restriction);
            schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType)) {
            schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplTranslateAnonymousSimpleType.finalRestriction()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$RESTRICTION_FINAL, (Object[]) null, restriction);
        }
        schemaTypeImpl2.setBaseTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
        schemaTypeImpl2.setBaseDepth(schemaTypeImplTranslateAnonymousSimpleType.getBaseDepth() + 1);
        schemaTypeImpl2.setDerivationType(1);
        if (!schemaTypeImplTranslateAnonymousSimpleType.isSimpleType()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$ATOMIC_NOT_SIMPLE, (Object[]) null, restriction.xgetBase());
            resolveErrorSimpleType(schemaTypeImpl2);
            return;
        }
        schemaTypeImpl2.setSimpleTypeVariety(schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety());
        int simpleVariety = schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl2.setPrimitiveTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getPrimitiveType().getRef());
        } else if (simpleVariety == 2) {
            schemaTypeImpl2.setUnionOfLists(schemaTypeImplTranslateAnonymousSimpleType.isUnionOfLists());
            schemaTypeImpl2.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImplTranslateAnonymousSimpleType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getListItemType().getRef());
        }
        resolveFacets(schemaTypeImpl2, restriction, schemaTypeImplTranslateAnonymousSimpleType);
        resolveFundamentalFacets(schemaTypeImpl2);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    public static void resolveSimpleType(SchemaTypeImpl schemaTypeImpl) {
        Object finalDefault;
        boolean zContains;
        SimpleType simpleType = (SimpleType) schemaTypeImpl.getParseObject();
        SchemaDocument.Schema schema = StscComplexTypeResolver.getSchema(simpleType);
        int i5 = (simpleType.isSetRestriction() ? 1 : 0) + (simpleType.isSetUnion() ? 1 : 0) + (simpleType.isSetList() ? 1 : 0);
        boolean z6 = true;
        if (i5 > 1) {
            StscState.get().error("A simple type must define either a list, a union, or a restriction: more than one found.", 52, simpleType);
        } else if (i5 < 1) {
            StscState.get().error("A simple type must define either a list, a union, or a restriction: none was found.", 52, simpleType);
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        if (simpleType.isSetFinal()) {
            finalDefault = simpleType.getFinal();
        } else {
            finalDefault = (schema == null || !schema.isSetFinalDefault()) ? null : schema.getFinalDefault();
        }
        boolean z7 = false;
        if (finalDefault == null) {
            z6 = false;
            zContains = false;
        } else if (finalDefault instanceof String) {
            if ("#all".equals(finalDefault)) {
                z7 = true;
                zContains = true;
            } else {
                z6 = false;
                zContains = false;
            }
        } else if (finalDefault instanceof List) {
            List list = (List) finalDefault;
            boolean zContains2 = list.contains("restriction");
            zContains = list.contains(XmlErrorCodes.LIST);
            z7 = list.contains(XmlErrorCodes.UNION);
            z6 = zContains2;
        } else {
            z6 = false;
            zContains = false;
        }
        schemaTypeImpl.setSimpleFinal(z6, zContains, z7);
        ArrayList arrayList = new ArrayList();
        if (simpleType.getList() != null) {
            resolveListType(schemaTypeImpl, simpleType.getList(), arrayList);
        } else if (simpleType.getUnion() != null) {
            resolveUnionType(schemaTypeImpl, simpleType.getUnion(), arrayList);
        } else if (simpleType.getRestriction() != null) {
            resolveSimpleRestrictionType(schemaTypeImpl, simpleType.getRestriction(), arrayList);
        }
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    public static void resolveUnionType(SchemaTypeImpl schemaTypeImpl, UnionDocument.Union union, List<SchemaType> list) {
        String str;
        XmlObject xmlObjectXgetMemberTypes;
        XmlObject xmlObjectXgetMemberTypes2;
        schemaTypeImpl.setSimpleTypeVariety(2);
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        StscState stscState = StscState.get();
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{XmlErrorCodes.UNION}, union);
        }
        List<QName> memberTypes = union.getMemberTypes();
        LocalSimpleType[] simpleTypeArray = union.getSimpleTypeArray();
        ArrayList arrayList = new ArrayList();
        if (simpleTypeArray.length == 0 && (memberTypes == null || memberTypes.size() == 0)) {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$UNION_HAS_MEMBER_TYPES_OR_SIMPLE_TYPES, (Object[]) null, union);
        }
        int i5 = 0;
        if (memberTypes != null) {
            for (QName qName : memberTypes) {
                SchemaTypeImpl schemaTypeImplFindGlobalType = stscState.findGlobalType(qName, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
                if (schemaTypeImplFindGlobalType == null) {
                    stscState.notFoundError(qName, 0, union.xgetMemberTypes(), true);
                } else {
                    arrayList.add(schemaTypeImplFindGlobalType);
                }
            }
        }
        int i6 = 0;
        while (i6 < simpleTypeArray.length) {
            SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(simpleTypeArray[i6], schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
            arrayList.add(schemaTypeImplTranslateAnonymousSimpleType);
            i6++;
            schemaTypeImplTranslateAnonymousSimpleType.setAnonymousUnionMemberOrdinal(i6);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            String str2 = "";
            if (!it.hasNext()) {
                break;
            }
            SchemaTypeImpl schemaTypeImpl3 = (SchemaTypeImpl) it.next();
            if (!StscResolver.resolveType(schemaTypeImpl3)) {
                if (Objects.equals(schemaTypeImpl3.getOuterType(), schemaTypeImpl)) {
                    xmlObjectXgetMemberTypes2 = schemaTypeImpl3.getParseObject();
                } else {
                    str2 = QNameHelper.pretty(schemaTypeImpl3.getName()) + " ";
                    xmlObjectXgetMemberTypes2 = union.xgetMemberTypes();
                }
                stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$CYCLIC_UNION, new Object[]{str2}, xmlObjectXgetMemberTypes2);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        boolean z6 = false;
        while (it2.hasNext()) {
            SchemaTypeImpl schemaTypeImpl4 = (SchemaTypeImpl) it2.next();
            if (!schemaTypeImpl4.isSimpleType()) {
                if (schemaTypeImpl4.getOuterType() == null || !schemaTypeImpl4.getOuterType().equals(schemaTypeImpl)) {
                    str = QNameHelper.pretty(schemaTypeImpl4.getName()) + " ";
                    xmlObjectXgetMemberTypes = union.xgetMemberTypes();
                } else {
                    xmlObjectXgetMemberTypes = schemaTypeImpl4.getParseObject();
                    str = "";
                }
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$UNION_MEMBER_NOT_SIMPLE, new Object[]{str}, xmlObjectXgetMemberTypes);
                it2.remove();
            } else if (schemaTypeImpl4.getSimpleVariety() == 3 || (schemaTypeImpl4.getSimpleVariety() == 2 && schemaTypeImpl4.isUnionOfLists())) {
                z6 = true;
            }
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            if (((SchemaTypeImpl) obj).finalUnion()) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$UNION_FINAL, (Object[]) null, union);
            }
        }
        schemaTypeImpl.setUnionOfLists(z6);
        schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setBasicFacets(StscState.FACETS_UNION, StscState.FIXED_FACETS_UNION);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    private static int translateFacetCode(QName qName) {
        return facetCodeMap.getOrDefault(qName, -1).intValue();
    }

    public static int translateWhitespaceCode(XmlAnySimpleType xmlAnySimpleType) {
        String stringValue = xmlAnySimpleType.getStringValue();
        if (stringValue.equals("collapse")) {
            return 3;
        }
        if (stringValue.equals("preserve")) {
            return 1;
        }
        if (stringValue.equals("replace")) {
            return 2;
        }
        StscState.get().error(AbstractC0157z.o("Unrecognized whitespace value \"", stringValue, "\""), 20, xmlAnySimpleType);
        return 0;
    }
}
