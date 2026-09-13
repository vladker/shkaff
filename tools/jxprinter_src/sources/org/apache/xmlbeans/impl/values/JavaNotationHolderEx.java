package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaNotationHolderEx extends JavaNotationHolder {
    private SchemaType _schemaType;

    public JavaNotationHolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    private static boolean check(String str, SchemaType schemaType) {
        XmlTokenSource facet = schemaType.getFacet(0);
        if (facet != null) {
            if (str.length() == ((XmlObjectBase) facet).getBigIntegerValue().intValue()) {
                return false;
            }
        }
        XmlTokenSource facet2 = schemaType.getFacet(1);
        if (facet2 != null) {
            if (str.length() < ((XmlObjectBase) facet2).getBigIntegerValue().intValue()) {
                return false;
            }
        }
        XmlTokenSource facet3 = schemaType.getFacet(2);
        if (facet3 != null) {
            if (str.length() > ((XmlObjectBase) facet3).getBigIntegerValue().intValue()) {
                return false;
            }
        }
        return true;
    }

    public static QName validateLexical(String str, SchemaType schemaType, ValidationContext validationContext, PrefixResolver prefixResolver) {
        QName qNameValidateLexical = JavaQNameHolder.validateLexical(str, validationContext, prefixResolver);
        if (schemaType.hasPatternFacet() && !schemaType.matchPatternFacet(str)) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"NOTATION", str, QNameHelper.readable(schemaType)});
        }
        check(str, schemaType);
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
            validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{"NOTATION", qName, QNameHelper.readable(schemaType)});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaNotationHolder, org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_notation(String str) {
        set_text(str);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaQNameHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
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
}
