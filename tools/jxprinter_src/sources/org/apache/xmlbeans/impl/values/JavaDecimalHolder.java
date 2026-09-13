package org.apache.xmlbeans.impl.values;

import androidx.core.location.LocationRequestCompat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JavaDecimalHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BigInteger _maxlong = BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
    private static final BigInteger _minlong = BigInteger.valueOf(Long.MIN_VALUE);
    private BigDecimal _value;

    public static void validateLexical(String str, ValidationContext validationContext) {
        char cCharAt;
        int length = str.length();
        boolean z6 = false;
        boolean z7 = false;
        for (int i5 = (length <= 0 || !((cCharAt = str.charAt(0)) == '+' || cCharAt == '-')) ? 0 : 1; i5 < length; i5++) {
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 == '.') {
                if (z7) {
                    validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{"saw '.' more than once: ".concat(str)});
                    return;
                }
                z7 = true;
            } else {
                if (cCharAt2 < '0' || cCharAt2 > '9') {
                    validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{androidx.collection.a.i(cCharAt2, "unexpected char '", "'")});
                    return;
                }
                z6 = true;
            }
        }
        if (z6) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DECIMAL, new Object[]{"expected at least one digit"});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject xmlObject) {
        return this._value.compareTo(((XmlObjectBase) xmlObject).getBigDecimalValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return XsTypeConverter.printDecimal(this._value);
    }

    public int decimalHashCode() {
        String string = this._value.toString();
        int length = string.length() - 1;
        while (length >= 0 && string.charAt(length) == '0') {
            length--;
        }
        return string.substring(0, length + 1).hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.compareTo(((XmlObjectBase) xmlObject).getBigDecimalValue()) == 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_DECIMAL;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal bigDecimal) {
        this._value = bigDecimal;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        if (_validateOnSet()) {
            validateLexical(str, XmlObjectBase._voorVc);
        }
        try {
            set_BigDecimal(new BigDecimal(str));
        } catch (NumberFormatException unused) {
            XmlObjectBase._voorVc.invalid(XmlErrorCodes.DECIMAL, new Object[]{str});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        if (this._value.scale() > 0 && this._value.setScale(0, RoundingMode.DOWN).compareTo(this._value) != 0) {
            return decimalHashCode();
        }
        BigInteger bigInteger = this._value.toBigInteger();
        if (bigInteger.compareTo(_maxlong) > 0 || bigInteger.compareTo(_minlong) < 0) {
            return bigInteger.hashCode();
        }
        long jLongValue = bigInteger.longValue();
        return (int) (((jLongValue >> 32) * 19) + jLongValue);
    }
}
