package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaStringHolderEx extends JavaStringHolder {
    private final SchemaType _schemaType;

    public JavaStringHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{TypedValues.Custom.S_STRING, str, QNameHelper.readable(schemaType)});
            return;
        }
        XmlTokenSource facet = schemaType.getFacet(0);
        if (facet != null && str.length() != (iIntValue3 = ((XmlObjectBase) facet).getBigIntegerValue().intValue())) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_LENGTH_VALID$STRING, new Object[]{TypedValues.Custom.S_STRING, Integer.valueOf(str.length()), Integer.valueOf(iIntValue3), QNameHelper.readable(schemaType)});
            return;
        }
        XmlTokenSource facet2 = schemaType.getFacet(1);
        if (facet2 != null && str.length() < (iIntValue2 = ((XmlObjectBase) facet2).getBigIntegerValue().intValue())) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_LENGTH_VALID$STRING, new Object[]{TypedValues.Custom.S_STRING, Integer.valueOf(str.length()), Integer.valueOf(iIntValue2), QNameHelper.readable(schemaType)});
            return;
        }
        XmlTokenSource facet3 = schemaType.getFacet(2);
        if (facet3 != null && str.length() > (iIntValue = ((XmlObjectBase) facet3).getBigIntegerValue().intValue())) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_LENGTH_VALID$STRING, new Object[]{TypedValues.Custom.S_STRING, Integer.valueOf(str.length()), Integer.valueOf(iIntValue), QNameHelper.readable(schemaType)});
            return;
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                if (str.equals(xmlAnySimpleType.getStringValue())) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{TypedValues.Custom.S_STRING, str, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_defaultable_ws(String str) {
        try {
            validateLexical(str, this._schemaType, XmlObjectBase._voorVc);
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        if (_validateOnSet()) {
            validateLexical(str, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(getStringValue(), schemaType(), validationContext);
    }
}
