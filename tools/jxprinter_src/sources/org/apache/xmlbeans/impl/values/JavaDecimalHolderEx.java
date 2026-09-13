package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaDecimalHolderEx extends JavaDecimalHolder {
    private final SchemaType _schemaType;

    public JavaDecimalHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaDecimalHolder.validateLexical(str, validationContext);
        if (!schemaType.hasPatternFacet() || schemaType.matchPatternFacet(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.DECIMAL, str, QNameHelper.readable(schemaType)});
    }

    public static void validateValue(BigDecimal bigDecimal, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(8);
        if (facet != null) {
            int iIntValue = ((XmlObjectBase) facet).getBigIntegerValue().intValue();
            try {
                bigDecimal.setScale(iIntValue, RoundingMode.UNNECESSARY);
            } catch (ArithmeticException unused) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_FRACTION_DIGITS_VALID, new Object[]{Integer.valueOf(bigDecimal.scale()), bigDecimal.toString(), Integer.valueOf(iIntValue), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(7);
        if (facet2 != null) {
            String string = bigDecimal.unscaledValue().toString();
            int iIntValue2 = ((XmlObjectBase) facet2).getBigIntegerValue().intValue();
            int length = string.length();
            if (length > 0) {
                int i5 = string.charAt(0) == '-' ? length - 1 : length;
                int iScale = bigDecimal.scale();
                int i6 = 0;
                for (int i7 = length - 1; string.charAt(i7) == '0' && i7 > 0 && i6 < iScale; i7--) {
                    i6++;
                }
                length = i5 - i6;
            }
            if (length > iIntValue2) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_VALID, new Object[]{Integer.valueOf(length), bigDecimal.toString(), Integer.valueOf(iIntValue2), QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(3);
        if (facet3 != null) {
            BigDecimal bigDecimalValue = ((XmlObjectBase) facet3).getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DECIMAL, bigDecimal, bigDecimalValue, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(4);
        if (facet4 != null) {
            BigDecimal bigDecimalValue2 = ((XmlObjectBase) facet4).getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DECIMAL, bigDecimal, bigDecimalValue2, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlTokenSource facet5 = schemaType.getFacet(5);
        if (facet5 != null) {
            BigDecimal bigDecimalValue3 = ((XmlObjectBase) facet5).getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{XmlErrorCodes.DECIMAL, bigDecimal, bigDecimalValue3, QNameHelper.readable(schemaType)});
                return;
            }
        }
        XmlTokenSource facet6 = schemaType.getFacet(6);
        if (facet6 != null) {
            BigDecimal bigDecimalValue4 = ((XmlObjectBase) facet6).getBigDecimalValue();
            if (bigDecimal.compareTo(bigDecimalValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{XmlErrorCodes.DECIMAL, bigDecimal, bigDecimalValue4, QNameHelper.readable(schemaType)});
                return;
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (bigDecimal.compareTo(((XmlObjectBase) obj).getBigDecimalValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.DECIMAL, bigDecimal, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal bigDecimal) {
        if (_validateOnSet()) {
            validateValue(bigDecimal, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_BigDecimal(bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaDecimalHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        BigDecimal bigDecimal;
        if (_validateOnSet()) {
            validateLexical(str, this._schemaType, XmlObjectBase._voorVc);
        }
        try {
            bigDecimal = new BigDecimal(str);
        } catch (NumberFormatException unused) {
            XmlObjectBase._voorVc.invalid(XmlErrorCodes.DECIMAL, new Object[]{str});
            bigDecimal = null;
        }
        if (_validateOnSet()) {
            validateValue(bigDecimal, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_BigDecimal(bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getBigDecimalValue(), schemaType(), validationContext);
    }
}
