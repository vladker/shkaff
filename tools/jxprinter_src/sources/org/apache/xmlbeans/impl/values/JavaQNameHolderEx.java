package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaQNameHolderEx extends JavaQNameHolder {
    private SchemaType _schemaType;

    public JavaQNameHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    public static QName validateLexical(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        QName qNameValidateLexical = JavaQNameHolder.validateLexical(str, validationContext, prefixResolver);
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.QNAME, str, QNameHelper.readable(schemaType)});
        }
        return qNameValidateLexical;
    }

    public static void validateValue(QName qName, SchemaType schemaType, ValidationContext validationContext) {
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            for (Object obj : enumerationValues) {
                if (qName.equals(((XmlObjectBase) obj).getQNameValue())) {
                    return;
                }
            }
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.QNAME, qName, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName qName) {
        if (_validateOnSet()) {
            validateValue(qName, this._schemaType, XmlObjectBase._voorVc);
        }
        super.set_QName(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        QName qNameValidateLexical;
        PrefixResolver current = NamespaceContext.getCurrent();
        if (current == null && has_store()) {
            current = get_store();
        }
        if (_validateOnSet()) {
            SchemaType schemaType = this._schemaType;
            ValidationContext validationContext = XmlObjectBase._voorVc;
            qNameValidateLexical = validateLexical(str, schemaType, validationContext, current);
            if (qNameValidateLexical != null) {
                validateValue(qNameValidateLexical, this._schemaType, validationContext);
            }
        } else {
            qNameValidateLexical = JavaQNameHolder.validateLexical(str, XmlObjectBase._voorVc, current);
        }
        super.set_QName(qNameValidateLexical);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        QName qNameValidateLexical;
        if (_validateOnSet()) {
            String stringValue = xmlAnySimpleType.getStringValue();
            SchemaType schemaType = this._schemaType;
            ValidationContext validationContext = XmlObjectBase._voorVc;
            qNameValidateLexical = validateLexical(stringValue, schemaType, validationContext, NamespaceContext.getCurrent());
            if (qNameValidateLexical != null) {
                validateValue(qNameValidateLexical, this._schemaType, validationContext);
            }
        } else {
            qNameValidateLexical = JavaQNameHolder.validateLexical(xmlAnySimpleType.getStringValue(), XmlObjectBase._voorVc, NamespaceContext.getCurrent());
        }
        super.set_QName(qNameValidateLexical);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        validateValue(getQNameValue(), schemaType(), validationContext);
    }
}
