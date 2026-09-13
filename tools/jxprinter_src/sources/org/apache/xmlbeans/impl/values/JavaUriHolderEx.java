package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JavaUriHolderEx extends JavaUriHolder {
    private final SchemaType _schemaType;

    public JavaUriHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    private static boolean check(String str, SchemaType schemaType) {
        int length = str == null ? 0 : str.length();
        XmlAnySimpleType facet = schemaType.getFacet(0);
        if (facet != null && length == ((SimpleValue) facet).getBigIntegerValue().intValue()) {
            return false;
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(1);
        if (facet2 != null && length < ((SimpleValue) facet2).getBigIntegerValue().intValue()) {
            return false;
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(2);
        return facet3 == null || length <= ((SimpleValue) facet3).getBigIntegerValue().intValue();
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        JavaUriHolder.validateLexical(str, validationContext);
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i5 = 0;
            while (i5 < enumerationValues.length && !((SimpleValue) enumerationValues[i5]).getStringValue().equals(str)) {
                i5++;
            }
            if (i5 >= enumerationValues.length) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.ANYURI, str, QNameHelper.readable(schemaType)});
            }
        }
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.ANYURI, str, QNameHelper.readable(schemaType)});
        }
        XmlAnySimpleType facet = schemaType.getFacet(0);
        if (facet != null && (iIntValue3 = ((SimpleValue) facet).getBigIntegerValue().intValue()) != str.length()) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_LENGTH_VALID$STRING, new Object[]{XmlErrorCodes.ANYURI, str, Integer.valueOf(iIntValue3), QNameHelper.readable(schemaType)});
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(1);
        if (facet2 != null && (iIntValue2 = ((SimpleValue) facet2).getBigIntegerValue().intValue()) > str.length()) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_LENGTH_VALID$STRING, new Object[]{XmlErrorCodes.ANYURI, str, Integer.valueOf(iIntValue2), QNameHelper.readable(schemaType)});
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(2);
        if (facet3 == null || (iIntValue = ((SimpleValue) facet3).getBigIntegerValue().intValue()) >= str.length()) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_LENGTH_VALID$STRING, new Object[]{XmlErrorCodes.ANYURI, str, Integer.valueOf(iIntValue), QNameHelper.readable(schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaUriHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaUriHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        if (_validateOnSet()) {
            if (!check(str, this._schemaType)) {
                throw new XmlValueOutOfRangeException();
            }
            if (!this._schemaType.matchPatternFacet(str)) {
                throw new XmlValueOutOfRangeException();
            }
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(getStringValue(), schemaType(), validationContext);
    }
}
