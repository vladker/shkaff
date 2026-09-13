package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaBase64HolderEx extends JavaBase64Holder {
    private final SchemaType _schemaType;

    public JavaBase64HolderEx(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    public static void validateValue(byte[] bArr, SchemaType schemaType, ValidationContext validationContext) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        XmlTokenSource facet = schemaType.getFacet(0);
        if (facet != null && (iIntValue3 = ((XmlObjectBase) facet).getBigIntegerValue().intValue()) != bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.BASE64BINARY, Integer.valueOf(bArr.length), Integer.valueOf(iIntValue3), QNameHelper.readable(schemaType)});
        }
        XmlTokenSource facet2 = schemaType.getFacet(1);
        if (facet2 != null && (iIntValue2 = ((XmlObjectBase) facet2).getBigIntegerValue().intValue()) > bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.BASE64BINARY, Integer.valueOf(bArr.length), Integer.valueOf(iIntValue2), QNameHelper.readable(schemaType)});
        }
        XmlTokenSource facet3 = schemaType.getFacet(2);
        if (facet3 != null && (iIntValue = ((XmlObjectBase) facet3).getBigIntegerValue().intValue()) < bArr.length) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_LENGTH_VALID$BINARY, new Object[]{XmlErrorCodes.BASE64BINARY, Integer.valueOf(bArr.length), Integer.valueOf(iIntValue), QNameHelper.readable(schemaType)});
        }
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int i5 = 0;
            loop0: while (i5 < enumerationValues.length) {
                byte[] byteArrayValue = ((XmlObjectBase) enumerationValues[i5]).getByteArrayValue();
                if (byteArrayValue.length == bArr.length) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= byteArrayValue.length) {
                            break loop0;
                        } else if (byteArrayValue[i6] != bArr[i6]) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
                i5++;
            }
            if (i5 >= enumerationValues.length) {
                validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID$NO_VALUE, new Object[]{XmlErrorCodes.BASE64BINARY, QNameHelper.readable(schemaType)});
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return schemaType().getWhiteSpaceRule();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBase64Holder, org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBase64Holder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] bArr) {
        if (_validateOnSet()) {
            validateValue(bArr, schemaType(), XmlObjectBase._voorVc);
        }
        super.set_ByteArray(bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.JavaBase64Holder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        byte[] bArrValidateLexical = _validateOnSet() ? JavaBase64Holder.validateLexical(str, schemaType(), XmlObjectBase._voorVc) : JavaBase64Holder.lex(str, XmlObjectBase._voorVc);
        if (bArrValidateLexical != null && _validateOnSet()) {
            validateValue(bArrValidateLexical, schemaType(), XmlObjectBase._voorVc);
        }
        if (bArrValidateLexical != null) {
            super.set_ByteArray(bArrValidateLexical);
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        JavaBase64Holder.validateLexical(str, schemaType(), validationContext);
        validateValue(getByteArrayValue(), schemaType(), validationContext);
    }
}
