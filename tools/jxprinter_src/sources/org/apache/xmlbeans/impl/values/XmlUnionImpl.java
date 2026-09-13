package org.apache.xmlbeans.impl.values;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlUnionImpl extends XmlObjectBase implements XmlAnySimpleType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int JAVA_BYTEARRAY = 50;
    private static final int JAVA_CALENDAR = 49;
    private static final int JAVA_DATE = 48;
    private static final int JAVA_LIST = 51;
    private static final int JAVA_NUMBER = 47;
    private final SchemaType _schemaType;
    private String _textvalue = "";
    private XmlAnySimpleType _value;

    public XmlUnionImpl(SchemaType schemaType, boolean z6) {
        this._schemaType = schemaType;
        initComplexType(z6, false);
    }

    private static boolean check(XmlObject xmlObject, SchemaType schemaType) {
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues == null) {
            return true;
        }
        for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
            if (xmlAnySimpleType.valueEquals(xmlObject)) {
                return true;
            }
        }
        return false;
    }

    private static boolean logical_overlap(SchemaType schemaType, int i5) {
        if (i5 <= 46) {
            return schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == i5;
        }
        switch (i5) {
            case 47:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode = schemaType.getPrimitiveType().getBuiltinTypeCode();
                if (builtinTypeCode != 18 && builtinTypeCode != 20 && builtinTypeCode != 21) {
                    switch (builtinTypeCode) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            case 48:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode2 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                return builtinTypeCode2 == 14 || builtinTypeCode2 == 16;
            case 49:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return true;
                    default:
                        return false;
                }
            case 50:
                if (schemaType.getSimpleVariety() != 1) {
                    return false;
                }
                int builtinTypeCode3 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                return builtinTypeCode3 == 4 || builtinTypeCode3 == 5;
            case 51:
                return schemaType.getSimpleVariety() == 3;
            default:
                return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #1 {all -> 0x0026, blocks: (B:7:0x001f, B:12:0x0028, B:14:0x002c, B:16:0x0034, B:17:0x003a), top: B:34:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0044 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:27:0x0068 A[LOOP:0: B:6:0x001d->B:27:0x0068, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x004d A[EDGE_INSN: B:38:0x004d->B:23:0x004d BREAK  A[LOOP:0: B:6:0x001d->B:27:0x0068], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    private void set_primitive(int i5, Object obj) {
        boolean z6;
        int i6;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        boolean z7 = true;
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z6 = true;
        } else {
            z6 = false;
        }
        while (true) {
            if (z7) {
                for (SchemaType schemaType : unionConstituentTypes) {
                    if (logical_overlap(schemaType, i5)) {
                        XmlAnySimpleType xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(obj, z7);
                        this._value = xmlAnySimpleTypeNewValue;
                        this._textvalue = xmlAnySimpleTypeNewValue.getStringValue();
                        if (z6) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (!z7) {
                    break;
                    break;
                }
                z7 = false;
            } else {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    while (i6 < r4) {
                        if (logical_overlap(schemaType, i5)) {
                            try {
                                XmlAnySimpleType xmlAnySimpleTypeNewValue2 = ((SchemaTypeImpl) schemaType).newValue(obj, z7);
                                this._value = xmlAnySimpleTypeNewValue2;
                                this._textvalue = xmlAnySimpleTypeNewValue2.getStringValue();
                                if (z6) {
                                    return;
                                } else {
                                    return;
                                }
                            } catch (XmlValueOutOfRangeException | Exception unused) {
                                continue;
                            }
                        }
                    }
                    if (!z7) {
                        break;
                    } else {
                        z7 = false;
                    }
                } finally {
                    if (z6) {
                        NamespaceContext.pop();
                    }
                }
            }
        }
        if (z6) {
            NamespaceContext.pop();
        }
        throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{obj.toString(), QNameHelper.readable(this._schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        return xmlAnySimpleType != null && ((SimpleValue) xmlAnySimpleType).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (byte) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0d;
        }
        return ((SimpleValue) xmlAnySimpleType).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getEnumValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0f;
        }
        return ((SimpleValue) xmlAnySimpleType).getFloatValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<?> getListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0L;
        }
        return ((SimpleValue) xmlAnySimpleType).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getQNameValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (short) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getShortValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return xmlAnySimpleType.getStringValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).instanceType();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_defaultable_ws(String str) {
        try {
            XmlAnySimpleType xmlAnySimpleType = this._value;
            set_text(str);
            this._value = xmlAnySimpleType;
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal bigDecimal) {
        set_primitive(47, bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger bigInteger) {
        set_primitive(47, bigInteger);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Calendar(Calendar calendar) {
        set_primitive(49, calendar);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_Date(Date date) {
        set_primitive(48, date);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDate(GDateSpecification gDateSpecification) {
        int builtinTypeCode = gDateSpecification.getBuiltinTypeCode();
        if (builtinTypeCode <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        set_primitive(builtinTypeCode, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_GDuration(GDurationSpecification gDurationSpecification) {
        set_primitive(13, gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName qName) {
        set_primitive(7, qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_b64(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_boolean(boolean z6) {
        set_primitive(3, Boolean.valueOf(z6));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_byte(byte b) {
        set_primitive(47, Byte.valueOf(b));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double d) {
        set_primitive(47, Double.valueOf(d));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        set_primitive(12, stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float f6) {
        set_primitive(47, Float.valueOf(f6));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_hex(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int i5) {
        set_primitive(47, Integer.valueOf(i5));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_list(List<?> list) {
        set_primitive(51, list);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long j6) {
        set_primitive(47, Long.valueOf(j6));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_short(short s6) {
        set_primitive(47, Short.valueOf(s6));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #2 {all -> 0x004d, blocks: (B:14:0x0046, B:19:0x004f, B:21:0x0053, B:22:0x0055, B:25:0x0064, B:30:0x006d, B:31:0x0083), top: B:43:0x0046, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064 A[Catch: all -> 0x004d, Exception -> 0x006c, XmlValueOutOfRangeException -> 0x0084, TRY_LEAVE, TryCatch #3 {XmlValueOutOfRangeException -> 0x0084, Exception -> 0x006c, blocks: (B:22:0x0055, B:25:0x0064), top: B:44:0x0055, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a2 A[LOOP:0: B:13:0x0044->B:38:0x00a2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x0089 A[EDGE_INSN: B:46:0x0089->B:34:0x0089 BREAK  A[LOOP:0: B:13:0x0044->B:38:0x00a2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        boolean z6;
        int i5;
        XmlAnySimpleType xmlAnySimpleTypeNewValue;
        if (!this._schemaType.matchPatternFacet(str) && _validateOnSet()) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{TypedValues.Custom.S_STRING, str, QNameHelper.readable(this._schemaType)});
        }
        String str2 = this._textvalue;
        this._textvalue = str;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        boolean z7 = true;
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z6 = true;
        } else {
            z6 = false;
        }
        while (true) {
            if (z7) {
                for (SchemaType schemaType : unionConstituentTypes) {
                    xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(str, z7);
                    if (!check(xmlAnySimpleTypeNewValue, this._schemaType)) {
                        this._value = xmlAnySimpleTypeNewValue;
                        if (z6) {
                            NamespaceContext.pop();
                            return;
                        }
                        return;
                    }
                }
                if (!z7) {
                    break;
                    break;
                }
                z7 = false;
            } else {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    while (i5 < r5) {
                        try {
                            xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(str, z7);
                            if (!check(xmlAnySimpleTypeNewValue, this._schemaType)) {
                                this._value = xmlAnySimpleTypeNewValue;
                                if (z6) {
                                    NamespaceContext.pop();
                                    return;
                                }
                                return;
                            }
                        } catch (XmlValueOutOfRangeException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Troublesome union exception caused by unexpected " + e, e);
                        }
                    }
                    if (!z7) {
                        break;
                    } else {
                        z7 = false;
                    }
                } catch (Throwable th) {
                    if (z6) {
                        NamespaceContext.pop();
                    }
                    throw th;
                }
            }
        }
        if (z6) {
            NamespaceContext.pop();
        }
        this._textvalue = str2;
        throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{str, QNameHelper.readable(this._schemaType)});
    }

    public void set_xmldate(XmlObject xmlObject) {
        set_primitive(16, xmlObject);
    }

    public void set_xmldatetime(XmlObject xmlObject) {
        set_primitive(14, xmlObject);
    }

    public void set_xmldecimal(XmlObject xmlObject) {
        set_primitive(11, xmlObject);
    }

    public void set_xmldouble(XmlObject xmlObject) {
        set_primitive(10, xmlObject);
    }

    public void set_xmlduration(XmlObject xmlObject) {
        set_primitive(13, xmlObject);
    }

    public void set_xmlfloat(XmlObject xmlObject) {
        set_primitive(9, xmlObject);
    }

    public void set_xmlgday(XmlObject xmlObject) {
        set_primitive(20, xmlObject);
    }

    public void set_xmlgmonth(XmlObject xmlObject) {
        set_primitive(21, xmlObject);
    }

    public void set_xmlgmonthday(XmlObject xmlObject) {
        set_primitive(19, xmlObject);
    }

    public void set_xmlgyear(XmlObject xmlObject) {
        set_primitive(18, xmlObject);
    }

    public void set_xmlgyearmonth(XmlObject xmlObject) {
        set_primitive(17, xmlObject);
    }

    public void set_xmltime(XmlObject xmlObject) {
        set_primitive(15, xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String str, ValidationContext validationContext) {
        try {
            check_dated();
            XmlTokenSource xmlTokenSource = this._value;
            if (xmlTokenSource != null) {
                ((XmlObjectBase) xmlTokenSource).validate_simpleval(str, validationContext);
                return;
            }
            StringBuilder sbY = AbstractC0157z.y("'", str, "' does not match any of the member types for ");
            sbY.append(QNameHelper.readable(schemaType()));
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{sbY.toString()});
        } catch (Exception unused) {
            StringBuilder sbY2 = AbstractC0157z.y("'", str, "' does not match any of the member types for ");
            sbY2.append(QNameHelper.readable(schemaType()));
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{sbY2.toString()});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<? extends XmlAnySimpleType> xgetListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).xgetListValue();
    }
}
