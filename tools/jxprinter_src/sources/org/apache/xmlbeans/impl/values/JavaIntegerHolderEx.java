package org.apache.xmlbeans.impl.values;

import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlPositiveInteger;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JavaIntegerHolderEx extends JavaIntegerHolder {
    private final SchemaType _schemaType;

    public JavaIntegerHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    private static BigInteger getBigIntegerValue(XmlObject xmlObject) {
        SchemaType schemaType = xmlObject.schemaType();
        switch (schemaType.getDecimalSize()) {
            case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                return ((XmlObjectBase) xmlObject).getBigIntegerValue();
            case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                return ((XmlObjectBase) xmlObject).getBigDecimalValue().toBigInteger();
            default:
                throw new IllegalStateException("Bad facet type for Big Int: " + schemaType);
        }
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (str.lastIndexOf(46) >= 0) {
            validationContext.invalid("integer", new Object[]{str});
        }
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"integer", str, QNameHelper.readable(schemaType)});
    }

    private static void validateValue(BigInteger bigInteger, SchemaType schemaType, ValidationContext validationContext) {
        XmlPositiveInteger xmlPositiveInteger = (XmlPositiveInteger) schemaType.getFacet(7);
        if (xmlPositiveInteger != null) {
            String string = bigInteger.toString();
            int length = string.length();
            if (length > 0 && string.charAt(0) == '-') {
                length--;
            }
            if (length > xmlPositiveInteger.getBigIntegerValue().intValue()) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_VALID, new Object[]{Integer.valueOf(length), string, Integer.valueOf(xmlPositiveInteger.getBigIntegerValue().intValue()), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet = schemaType.getFacet(3);
        if (facet != null) {
            BigInteger bigIntegerValue = getBigIntegerValue(facet);
            if (bigInteger.compareTo(bigIntegerValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{"integer", bigInteger, bigIntegerValue, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            BigInteger bigIntegerValue2 = getBigIntegerValue(facet2);
            if (bigInteger.compareTo(bigIntegerValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{"integer", bigInteger, bigIntegerValue2, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            BigInteger bigIntegerValue3 = getBigIntegerValue(facet3);
            if (bigInteger.compareTo(bigIntegerValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{"integer", bigInteger, bigIntegerValue3, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            BigInteger bigIntegerValue4 = getBigIntegerValue(facet4);
            if (bigInteger.compareTo(bigIntegerValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{"integer", bigInteger, bigIntegerValue4, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                if (bigInteger.equals(getBigIntegerValue(xmlAnySimpleType))) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"integer", bigInteger, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger bigInteger) {
        if (_validateOnSet()) {
            validateValue(bigInteger, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_BigInteger(bigInteger);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaIntegerHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        ValidationContext validationContext = XmlObjectBase._voorVc;
        BigInteger bigIntegerLex = JavaIntegerHolder.lex(str, validationContext);
        if (_validateOnSet()) {
            validateValue(bigIntegerLex, this._schemaType, validationContext);
        }
        if (_validateOnSet()) {
            validateLexical(str, this._schemaType, validationContext);
        }
        super.set_BigInteger(bigIntegerLex);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getBigIntegerValue(), schemaType(), validationContext);
    }
}
