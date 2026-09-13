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
public abstract class JavaIntHolderEx extends JavaIntHolder {
    private final SchemaType _schemaType;

    public JavaIntHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    private static int getIntValue(XmlObject xmlObject) {
        int decimalSize = xmlObject.schemaType().getDecimalSize();
        if (decimalSize == 64) {
            return (int) ((XmlObjectBase) xmlObject).getLongValue();
        }
        switch (decimalSize) {
            case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                return ((XmlObjectBase) xmlObject).getBigIntegerValue().intValue();
            case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                return ((XmlObjectBase) xmlObject).getBigDecimalValue().intValue();
            default:
                return ((XmlObjectBase) xmlObject).getIntValue();
        }
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.INT, str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(int i5, SchemaType schemaType, ValidationContext validationContext) {
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        XmlAnySimpleType facet = schemaType.getFacet(7);
        if (facet != null) {
            String string = Integer.toString(i5);
            int length = string.length();
            if (length > 0 && string.charAt(0) == '-') {
                length--;
            }
            if (length > getIntValue(facet)) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_VALID, new Object[]{Integer.valueOf(length), string, Integer.valueOf(getIntValue(facet)), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(3);
        if (facet2 != null && i5 <= (intValue4 = getIntValue(facet2))) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.INT, Integer.valueOf(i5), Integer.valueOf(intValue4), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(4);
        if (facet3 != null && i5 < (intValue3 = getIntValue(facet3))) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.INT, Integer.valueOf(i5), Integer.valueOf(intValue3), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(5);
        if (facet4 != null && i5 > (intValue2 = getIntValue(facet4))) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.INT, Integer.valueOf(i5), Integer.valueOf(intValue2), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType facet5 = schemaType.getFacet(6);
        if (facet5 != null && i5 >= (intValue = getIntValue(facet5))) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.INT, Integer.valueOf(i5), Integer.valueOf(intValue), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                if (i5 == getIntValue(xmlAnySimpleType)) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.INT, Integer.valueOf(i5), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int i5) {
        if (_validateOnSet()) {
            validateValue(i5, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_int(i5);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        try {
            int iLexInt = XsTypeConverter.lexInt(str);
            if (_validateOnSet()) {
                SchemaType schemaType = this._schemaType;
                ValidationContext validationContext = XmlObjectBase._voorVc;
                validateValue(iLexInt, schemaType, validationContext);
                validateLexical(str, this._schemaType, validationContext);
            }
            super.set_int(iLexInt);
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getIntValue(), schemaType(), validationContext);
    }
}
