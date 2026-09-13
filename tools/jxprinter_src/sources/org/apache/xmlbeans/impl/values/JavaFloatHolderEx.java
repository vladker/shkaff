package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaFloatHolderEx extends JavaFloatHolder {
    private final SchemaType _schemaType;

    public JavaFloatHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    public static float validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        float fValidateLexical = JavaFloatHolder.validateLexical(str, validationContext);
        if (!schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"float", str, QNameHelper.readable(schemaType)});
        }
        return fValidateLexical;
    }

    public static void validateValue(float f6, SchemaType schemaType, ValidationContext validationContext) {
        XmlTokenSource facet = schemaType.getFacet(3);
        if (facet != null) {
            float floatValue = ((XmlObjectBase) facet).getFloatValue();
            if (JavaFloatHolder.compare(f6, floatValue) <= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_VALID, new Object[]{"float", Float.valueOf(f6), Float.valueOf(floatValue), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(4);
        if (facet2 != null) {
            float floatValue2 = ((XmlObjectBase) facet2).getFloatValue();
            if (JavaFloatHolder.compare(f6, floatValue2) < 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_VALID, new Object[]{"float", Float.valueOf(f6), Float.valueOf(floatValue2), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(5);
        if (facet3 != null) {
            float floatValue3 = ((XmlObjectBase) facet3).getFloatValue();
            if (JavaFloatHolder.compare(f6, floatValue3) > 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_VALID, new Object[]{"float", Float.valueOf(f6), Float.valueOf(floatValue3), QNameHelper.readable(schemaType)});
            }
        }
        XmlTokenSource facet4 = schemaType.getFacet(6);
        if (facet4 != null) {
            float floatValue4 = ((XmlObjectBase) facet4).getFloatValue();
            if (JavaFloatHolder.compare(f6, floatValue4) >= 0) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_VALID, new Object[]{"float", Float.valueOf(f6), Float.valueOf(floatValue4), QNameHelper.readable(schemaType)});
            }
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (JavaFloatHolder.compare(f6, ((XmlObjectBase) obj).getFloatValue()) == 0) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"float", Float.valueOf(f6), QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaFloatHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float f6) {
        if (_validateOnSet()) {
            validateValue(f6, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_float(f6);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateLexical(str, schemaType(), validationContext);
        validateValue(getFloatValue(), schemaType(), validationContext);
    }
}
