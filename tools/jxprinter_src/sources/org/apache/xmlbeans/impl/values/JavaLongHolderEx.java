package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaLongHolderEx extends JavaLongHolder {
    private final SchemaType _schemaType;

    public JavaLongHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    private static long getLongValue(XmlObject xmlObject) {
        SchemaType schemaType = xmlObject.schemaType();
        int decimalSize = schemaType.getDecimalSize();
        if (decimalSize == 64) {
            return ((XmlObjectBase) xmlObject).getLongValue();
        }
        switch (decimalSize) {
            case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                return ((XmlObjectBase) xmlObject).getBigIntegerValue().longValue();
            case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                return ((XmlObjectBase) xmlObject).getBigDecimalValue().longValue();
            default:
                throw new IllegalStateException("Bad facet type: " + schemaType);
        }
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.LONG, str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(long j6, SchemaType schemaType, ValidationContext validationContext) {
        XmlAnySimpleType facet = schemaType.getFacet(7);
        if (facet != null) {
            long longValue = getLongValue(facet);
            String string = Long.toString(j6);
            int length = string.length();
            if (length > 0 && string.charAt(0) == '-') {
                length--;
            }
            if (length > longValue) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_VALID, new Object[]{Integer.valueOf(length), string, Long.valueOf(longValue), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(3);
        if (facet2 != null) {
            long longValue2 = getLongValue(facet2);
            if (j6 <= longValue2) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, Long.valueOf(j6), Long.valueOf(longValue2), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(4);
        if (facet3 != null) {
            long longValue3 = getLongValue(facet3);
            if (j6 < longValue3) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, Long.valueOf(j6), Long.valueOf(longValue3), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(5);
        if (facet4 != null) {
            long longValue4 = getLongValue(facet4);
            if (j6 > longValue4) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, Long.valueOf(j6), Long.valueOf(longValue4), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet5 = schemaType.getFacet(6);
        if (facet5 != null) {
            long longValue5 = getLongValue(facet5);
            if (j6 >= longValue5) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.LONG, Long.valueOf(j6), Long.valueOf(longValue5), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                if (j6 == getLongValue(xmlAnySimpleType)) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.LONG, Long.valueOf(j6), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long j6) {
        if (_validateOnSet()) {
            validateValue(j6, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_long(j6);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaLongHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        try {
            long jLexLong = XsTypeConverter.lexLong(str);
            if (_validateOnSet()) {
                SchemaType schemaType = this._schemaType;
                ValidationContext validationContext = XmlObjectBase._voorVc;
                validateValue(jLexLong, schemaType, validationContext);
                validateLexical(str, this._schemaType, validationContext);
            }
            super.set_long(jLexLong);
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getLongValue(), schemaType(), validationContext);
    }
}
