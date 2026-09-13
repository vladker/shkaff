package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaStringEnumerationHolderEx extends JavaStringHolderEx {
    private StringEnumAbstractBase _val;

    public JavaStringEnumerationHolderEx(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }

    public static void validateLexical(String str, SchemaType schemaType, ValidationContext validationContext) {
        JavaStringHolderEx.validateLexical(str, schemaType, validationContext);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        return this._val;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        Class<? extends StringEnumAbstractBase> enumJavaClass = schemaType().getEnumJavaClass();
        if (enumJavaClass != null && !stringEnumAbstractBase.getClass().equals(enumJavaClass)) {
            throw new XmlValueOutOfRangeException();
        }
        super.set_text(stringEnumAbstractBase.toString());
        this._val = stringEnumAbstractBase;
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._val = null;
        super.set_nil();
    }

    @Override // org.apache.xmlbeans.impl.values.JavaStringHolderEx, org.apache.xmlbeans.impl.values.JavaStringHolder, org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        StringEnumAbstractBase stringEnumAbstractBaseEnumForString = schemaType().enumForString(str);
        if (stringEnumAbstractBaseEnumForString == null) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{TypedValues.Custom.S_STRING, str, QNameHelper.readable(schemaType())});
        }
        super.set_text(str);
        this._val = stringEnumAbstractBaseEnumForString;
    }
}
