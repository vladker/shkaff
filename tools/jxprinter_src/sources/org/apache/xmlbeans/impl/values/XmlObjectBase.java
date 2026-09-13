package org.apache.xmlbeans.impl.values;

import A3.AbstractC0157z;
import androidx.core.location.LocationRequestCompat;
import androidx.core.os.EnvironmentCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.DelegateXmlObject;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.impl.validator.Validator;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class XmlObjectBase implements TypeStoreUser, Serializable, XmlObject, SimpleValue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FLAGS_DATED = 672;
    private static final int FLAGS_ELEMENT = 7;
    private static final int FLAG_ATTRIBUTE = 8;
    private static final int FLAG_COMPLEXCONTENT = 16384;
    private static final int FLAG_COMPLEXTYPE = 8192;
    private static final int FLAG_ELEMENT_DATED = 512;
    private static final int FLAG_FIXED = 4;
    private static final int FLAG_HASDEFAULT = 2;
    private static final int FLAG_IMMUTABLE = 4096;
    private static final int FLAG_ISDEFAULT = 256;
    private static final int FLAG_NIL = 64;
    private static final int FLAG_NILLABLE = 1;
    private static final int FLAG_NIL_DATED = 128;
    private static final int FLAG_NOT_VARIABLE = 32768;
    private static final int FLAG_ORPHANED = 2048;
    private static final int FLAG_SETTINGDEFAULT = 1024;
    private static final int FLAG_STORE = 16;
    private static final int FLAG_VALIDATE_ON_SET = 65536;
    private static final int FLAG_VALUE_DATED = 32;
    public static final short KIND_SETTERHELPER_ARRAYITEM = 2;
    public static final short KIND_SETTERHELPER_SINGLETON = 1;
    public static final short MAJOR_VERSION_NUMBER = 1;
    public static final short MINOR_VERSION_NUMBER = 1;
    private int _flags = 65;
    private Object _textsource;
    public static final ValidationContext _voorVc = new ValueOutOfRangeValidationContext();
    private static final BigInteger _max = BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
    private static final BigInteger _min = BigInteger.valueOf(Long.MIN_VALUE);
    private static final XmlOptions _toStringOptions = buildInnerPrettyOptions();
    private static final XmlObject[] EMPTY_RESULT = new XmlObject[0];

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ImmutableValueValidationContext implements ValidationContext {
        private final Collection<XmlError> _coll;
        private final XmlObject _loc;

        public ImmutableValueValidationContext(Collection<XmlError> collection, XmlObject xmlObject) {
            this._coll = collection;
            this._loc = xmlObject;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            this._coll.add(XmlError.forObject(str, this._loc));
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            this._coll.add(XmlError.forObject(str, objArr, this._loc));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SerializedInteriorObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient XmlObject _root;

        private int distanceToRoot() {
            XmlCursor xmlCursorNewCursor = this._impl.newCursor();
            int i5 = 0;
            while (!xmlCursorNewCursor.toPrevToken().isNone()) {
                try {
                    if (!xmlCursorNewCursor.currentTokenType().isNamespace()) {
                        i5++;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (xmlCursorNewCursor != null) {
                            try {
                                xmlCursorNewCursor.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            xmlCursorNewCursor.close();
            return i5;
        }

        private XmlObject objectAtDistance(int i5) {
            XmlCursor xmlCursorNewCursor = this._root.newCursor();
            while (i5 > 0) {
                try {
                    xmlCursorNewCursor.toNextToken();
                    if (!xmlCursorNewCursor.currentTokenType().isNamespace()) {
                        i5--;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (xmlCursorNewCursor != null) {
                            try {
                                xmlCursorNewCursor.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            XmlObject object = xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.close();
            return object;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this._root = (XmlObject) objectInputStream.readObject();
            objectInputStream.readBoolean();
            this._impl = objectAtDistance(objectInputStream.readInt());
        }

        private Object readResolve() {
            return this._impl;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._root);
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeInt(distanceToRoot());
        }

        private SerializedInteriorObject(XmlObject xmlObject, XmlObject xmlObject2) {
            this._impl = xmlObject;
            this._root = xmlObject2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SerializedRootObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient Class<? extends XmlObject> _xbeanClass;

        private void readObject(ObjectInputStream objectInputStream) throws Throwable {
            int unsignedShort;
            int unsignedShort2;
            String objectV0;
            try {
                this._xbeanClass = (Class) objectInputStream.readObject();
                int unsignedShort3 = objectInputStream.readUnsignedShort();
                if (unsignedShort3 == 0) {
                    unsignedShort = objectInputStream.readUnsignedShort();
                    unsignedShort2 = objectInputStream.readUnsignedShort();
                } else {
                    unsignedShort = 0;
                    unsignedShort2 = 0;
                }
                if (unsignedShort == 0) {
                    objectV0 = readObjectV0(objectInputStream, unsignedShort3);
                    objectInputStream.readBoolean();
                } else {
                    if (unsignedShort != 1) {
                        throw new IOException("Deserialization error: version number " + unsignedShort + Consts.DOT + unsignedShort2 + " not supported.");
                    }
                    if (unsignedShort2 != 1) {
                        throw new IOException("Deserialization error: version number " + unsignedShort + Consts.DOT + unsignedShort2 + " not supported.");
                    }
                    objectV0 = (String) objectInputStream.readObject();
                    objectInputStream.readBoolean();
                }
                this._impl = XmlBeans.getContextTypeLoader().parse(objectV0, (SchemaType) null, new XmlOptions().setDocumentType(XmlBeans.typeForClass(this._xbeanClass)));
            } catch (Exception e) {
                throw new IOException(e.getMessage(), e);
            }
        }

        private String readObjectV0(ObjectInputStream objectInputStream, int i5) throws Throwable {
            LongUTFDataInputStream longUTFDataInputStream;
            Throwable th;
            byte[] bArr = new byte[i5 + 2];
            int i6 = 0;
            bArr[0] = (byte) ((i5 >> 8) & 255);
            bArr[1] = (byte) (i5 & 255);
            while (i6 < i5) {
                int i7 = objectInputStream.read(bArr, i6 + 2, i5 - i6);
                if (i7 == -1) {
                    break;
                }
                i6 += i7;
            }
            if (i6 != i5) {
                throw new IOException(androidx.collection.a.m("Error reading backwards compatible XmlObject: number of bytes read (", i6, i5, ") != number expected (", ")"));
            }
            try {
                longUTFDataInputStream = new LongUTFDataInputStream(new ByteArrayInputStream(bArr));
                try {
                    String longUTF = longUTFDataInputStream.readLongUTF();
                    longUTFDataInputStream.close();
                    return longUTF;
                } catch (Throwable th2) {
                    th = th2;
                    if (longUTFDataInputStream != null) {
                        longUTFDataInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                longUTFDataInputStream = null;
                th = th3;
            }
        }

        private Object readResolve() {
            return this._impl;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this._xbeanClass);
            objectOutputStream.writeShort(0);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeShort(1);
            objectOutputStream.writeObject(this._impl.xmlText());
            objectOutputStream.writeBoolean(false);
        }

        private SerializedRootObject(XmlObject xmlObject) {
            this._xbeanClass = xmlObject.schemaType().getJavaClass();
            this._impl = xmlObject;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ValueOutOfRangeValidationContext implements ValidationContext {
        private ValueOutOfRangeValidationContext() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            throw new XmlValueOutOfRangeException(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            throw new XmlValueOutOfRangeException(str, objArr);
        }
    }

    private static XmlObject[] _typedArray(XmlObject[] xmlObjectArr) {
        if (xmlObjectArr.length != 0) {
            SchemaType schemaType = xmlObjectArr[0].schemaType();
            if (!schemaType.equals(XmlObject.type) && !schemaType.isNoType()) {
                for (int i5 = 1; i5 < xmlObjectArr.length; i5++) {
                    if (!xmlObjectArr[i5].schemaType().isNoType()) {
                        schemaType = schemaType.getCommonBaseType(xmlObjectArr[i5].schemaType());
                        if (!schemaType.equals(XmlObject.type)) {
                        }
                    }
                }
                Class<? extends XmlObject> javaClass = schemaType.getJavaClass();
                while (javaClass == null) {
                    schemaType = schemaType.getBaseType();
                    if (!XmlObject.type.equals(schemaType)) {
                        javaClass = schemaType.getJavaClass();
                    }
                }
                XmlObject[] xmlObjectArr2 = (XmlObject[]) Array.newInstance(javaClass, xmlObjectArr.length);
                System.arraycopy(xmlObjectArr, 0, xmlObjectArr2, 0, xmlObjectArr.length);
                return xmlObjectArr2;
            }
        }
        return xmlObjectArr;
    }

    private String apply_wscanon(String str) {
        return XmlWhitespace.collapse(str, get_wscanon_rule());
    }

    public static XmlOptions buildInnerPrettyOptions() {
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setSaveInner();
        xmlOptions.setSavePrettyPrint();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setUseDefaultNamespace();
        return xmlOptions;
    }

    private void check_element_dated() {
        int i5 = this._flags;
        if ((i5 & 512) != 0 && (i5 & 32768) == 0) {
            if ((i5 & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            this._flags = get_store().compute_flags() | (this._flags & (-520));
        }
        int i6 = this._flags;
        if ((i6 & 32768) != 0) {
            this._flags = i6 & (-513);
        }
    }

    private boolean comparable_value_spaces(SchemaType schemaType, SchemaType schemaType2) {
        if (!schemaType.isSimpleType() && !schemaType2.isSimpleType()) {
            return schemaType.getContentType() == schemaType2.getContentType();
        }
        if (schemaType.isSimpleType() && schemaType2.isSimpleType()) {
            if (schemaType.getSimpleVariety() == 3 && schemaType2.getSimpleVariety() == 3) {
                return true;
            }
            if (schemaType.getSimpleVariety() != 3 && schemaType2.getSimpleVariety() != 3) {
                return schemaType.getPrimitiveType().equals(schemaType2.getPrimitiveType());
            }
        }
        return false;
    }

    private int compareValueImpl(XmlObject xmlObject) {
        try {
            SchemaType schemaTypeInstanceType = instanceType();
            SchemaType schemaTypeInstanceType2 = ((SimpleValue) xmlObject).instanceType();
            if (schemaTypeInstanceType == null && schemaTypeInstanceType2 == null) {
                return 0;
            }
            if (schemaTypeInstanceType != null && schemaTypeInstanceType2 != null && schemaTypeInstanceType.isSimpleType() && !schemaTypeInstanceType.isURType() && schemaTypeInstanceType2.isSimpleType() && !schemaTypeInstanceType2.isURType()) {
                if (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode() != schemaTypeInstanceType2.getPrimitiveType().getBuiltinTypeCode()) {
                    return 2;
                }
                return compare_to(xmlObject);
            }
            return 2;
        } catch (XmlValueOutOfRangeException unused) {
        }
    }

    private XmlObject ensureStore() {
        String strCompute_text;
        if ((this._flags & 16) != 0) {
            return this;
        }
        check_dated();
        if ((this._flags & 64) != 0) {
            strCompute_text = "";
        } else {
            strCompute_text = compute_text(has_store() ? get_store() : null);
        }
        XmlObject xmlObjectNewInstance = XmlObject.Factory.newInstance(new XmlOptions().setDocumentType(schemaType()));
        XmlCursor xmlCursorNewCursor = xmlObjectNewInstance.newCursor();
        try {
            xmlCursorNewCursor.toNextToken();
            xmlCursorNewCursor.insertChars(strCompute_text);
            xmlCursorNewCursor.close();
            return xmlObjectNewInstance;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private List<XmlObjectBase> getBaseArray(QName qName) {
        check_orphaned();
        ArrayList arrayList = new ArrayList();
        get_store().find_all_element_users(qName, arrayList);
        return arrayList;
    }

    private String getPrimitiveTypeName() {
        SchemaType schemaType = schemaType();
        if (schemaType.isNoType()) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        SchemaType primitiveType = schemaType.getPrimitiveType();
        return primitiveType == null ? "complex" : primitiveType.getName().getLocalPart();
    }

    private XmlObject getRootXmlObject() {
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return this;
        }
        try {
            xmlCursorNewCursor.toStartDoc();
            XmlObject object = xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.close();
            return object;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    xmlCursorNewCursor.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private XmlObjectBase getTargetForSetter(QName qName, int i5, short s6) {
        if (s6 == 1) {
            check_orphaned();
            XmlObjectBase xmlObjectBase = (XmlObjectBase) get_store().find_element_user(qName, i5);
            if (xmlObjectBase == null) {
                xmlObjectBase = (XmlObjectBase) get_store().add_element_user(qName);
            }
            if (xmlObjectBase.isImmutable()) {
                throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
            }
            return xmlObjectBase;
        }
        if (s6 != 2) {
            throw new IllegalArgumentException(AbstractC0157z.k(s6, "Unknown kindSetterHelper: "));
        }
        check_orphaned();
        XmlObjectBase xmlObjectBase2 = (XmlObjectBase) get_store().find_element_user(qName, i5);
        if (xmlObjectBase2 == null) {
            throw new IndexOutOfBoundsException();
        }
        if (xmlObjectBase2.isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        return xmlObjectBase2;
    }

    private boolean isRootXmlObject() {
        XmlCursor xmlCursorNewCursor = newCursor();
        if (xmlCursorNewCursor == null) {
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return false;
        }
        try {
            boolean z6 = !xmlCursorNewCursor.toParent();
            xmlCursorNewCursor.close();
            return z6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    xmlCursorNewCursor.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static Object java_value(XmlObject xmlObject) {
        if (xmlObject.isNil()) {
            return null;
        }
        if (!(xmlObject instanceof XmlAnySimpleType)) {
            return xmlObject;
        }
        SimpleValue simpleValue = (SimpleValue) xmlObject;
        SchemaType schemaTypeInstanceType = simpleValue.instanceType();
        if (schemaTypeInstanceType.getSimpleVariety() == 3) {
            return simpleValue.getListValue();
        }
        switch (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
            case 8:
            case 12:
            default:
                return simpleValue.getStringValue();
            case 3:
                return simpleValue.getBooleanValue() ? Boolean.TRUE : Boolean.FALSE;
            case 4:
            case 5:
                return simpleValue.getByteArrayValue();
            case 6:
                return simpleValue.getStringValue();
            case 7:
                return simpleValue.getQNameValue();
            case 9:
                return Float.valueOf(simpleValue.getFloatValue());
            case 10:
                return Double.valueOf(simpleValue.getDoubleValue());
            case 11:
                int decimalSize = schemaTypeInstanceType.getDecimalSize();
                if (decimalSize == 8) {
                    return Byte.valueOf(simpleValue.getByteValue());
                }
                if (decimalSize == 16) {
                    return Short.valueOf(simpleValue.getShortValue());
                }
                if (decimalSize == 32) {
                    return Integer.valueOf(simpleValue.getIntValue());
                }
                if (decimalSize == 64) {
                    return Long.valueOf(simpleValue.getLongValue());
                }
                switch (decimalSize) {
                    case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                        return simpleValue.getBigIntegerValue();
                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                    default:
                        return simpleValue.getBigDecimalValue();
                }
            case 13:
                return simpleValue.getGDurationValue();
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return simpleValue.getCalendarValue();
        }
    }

    private static XmlOptions makeInnerOptions(XmlOptions xmlOptions) {
        XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
        xmlOptions2.setSaveInner();
        return xmlOptions2;
    }

    private TypeStoreUser objSetterHelper(XmlObjectBase xmlObjectBase, QName qName, int i5, short s6) {
        XmlObjectBase targetForSetter = getTargetForSetter(qName, i5, s6);
        targetForSetter.check_orphaned();
        xmlObjectBase.check_orphaned();
        return targetForSetter.get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    private boolean preCheck() {
        if (has_store()) {
            return get_store().get_locale().noSync();
        }
        return false;
    }

    private SchemaField schemaField() {
        SchemaField containerField = schemaType().getContainerField();
        return containerField == null ? get_store().get_schema_field() : containerField;
    }

    private void set_commit() {
        int i5 = this._flags;
        boolean z6 = (i5 & 64) != 0;
        this._flags = i5 & (-321);
        if ((i5 & 16) == 0) {
            this._textsource = null;
            return;
        }
        this._flags = i5 & (-993);
        get_store().invalidate_text();
        if (z6) {
            get_store().invalidate_nil();
        }
        this._flags &= -673;
    }

    private void set_prepare() {
        check_element_dated();
        if ((this._flags & 4096) != 0) {
            throw new IllegalStateException();
        }
    }

    private TypeStoreUser setterHelper(XmlObjectBase xmlObjectBase) {
        check_orphaned();
        xmlObjectBase.check_orphaned();
        return get_store().copy_contents_from(xmlObjectBase.get_store()).get_store().change_type(xmlObjectBase.schemaType());
    }

    private static XmlObjectBase underlying(XmlObject xmlObject) {
        if (xmlObject == null) {
            return null;
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        while (xmlObject instanceof DelegateXmlObject) {
            xmlObject = ((DelegateXmlObject) xmlObject).underlyingXmlObject();
        }
        if (xmlObject instanceof XmlObjectBase) {
            return (XmlObjectBase) xmlObject;
        }
        throw new IllegalStateException("Non-native implementations of XmlObject should extend FilterXmlObject or implement DelegateXmlObject");
    }

    private void update_from_wscanon_text(String str) {
        int i5 = this._flags;
        if ((i5 & 2) == 0 || (i5 & 1024) != 0 || (i5 & 8) != 0 || !str.equals("")) {
            set_text(str);
            this._flags &= -321;
            return;
        }
        String strCompute_default_text = get_store().compute_default_text();
        if (strCompute_default_text == null) {
            throw new XmlValueOutOfRangeException();
        }
        this._flags |= 1024;
        try {
            setStringValue(strCompute_default_text);
            this._flags = (this._flags & (-1089)) | 256;
        } catch (Throwable th) {
            this._flags &= -1025;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0081  */
    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    private boolean validate_immutable(XmlOptions xmlOptions) {
        String str;
        boolean zHasError;
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(xmlOptions == null ? null : xmlOptions.getErrorListener());
        if (schemaType().isSimpleType() || (xmlOptions != null && xmlOptions.isValidateTextOnly())) {
            str = (String) this._textsource;
            if (str == null) {
                str = "";
            }
            validate_simpleval(str, new ImmutableValueValidationContext(xmlErrorWatcher, this));
            zHasError = xmlErrorWatcher.hasError();
        } else {
            for (SchemaProperty schemaProperty : schemaType().getProperties()) {
                if (schemaProperty.getMinOccurs().signum() > 0) {
                    if (schemaProperty.isAttribute()) {
                        xmlErrorWatcher.add(XmlError.forObject(XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_REQUIRED_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaProperty.getName())}, this));
                    } else {
                        xmlErrorWatcher.add(XmlError.forObject(XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_ELEMENT, new Object[]{schemaProperty.getMinOccurs(), QNameHelper.pretty(schemaProperty.getName())}, this));
                    }
                }
            }
            if (schemaType().getContentType() != 2) {
                zHasError = xmlErrorWatcher.hasError();
            } else {
                str = (String) this._textsource;
                if (str == null) {
                    str = "";
                }
                validate_simpleval(str, new ImmutableValueValidationContext(xmlErrorWatcher, this));
                zHasError = xmlErrorWatcher.hasError();
            }
        }
        return !zHasError;
    }

    private boolean valueEqualsImpl(XmlObject xmlObject) {
        check_dated();
        SchemaType schemaTypeInstanceType = instanceType();
        SchemaType schemaTypeInstanceType2 = ((SimpleValue) xmlObject).instanceType();
        if (schemaTypeInstanceType == null && schemaTypeInstanceType2 == null) {
            return true;
        }
        if (schemaTypeInstanceType == null || schemaTypeInstanceType2 == null || !comparable_value_spaces(schemaTypeInstanceType, schemaTypeInstanceType2)) {
            return false;
        }
        return xmlObject.schemaType().getSimpleVariety() == 2 ? underlying(xmlObject).equal_to(this) : equal_to(xmlObject);
    }

    public final XmlObject _copy() {
        return _copy(null);
    }

    public boolean _isComplexContent() {
        return (this._flags & 16384) != 0;
    }

    public boolean _isComplexType() {
        return (this._flags & 8192) != 0;
    }

    public final XmlObject _set(XmlObject xmlObject) {
        TypeStoreUser typeStoreUserChange_type;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            setNil();
            return this;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            setStringValue(xmlObjectBaseUnderlying.getStringValue());
            typeStoreUserChange_type = this;
        } else {
            check_orphaned();
            xmlObjectBaseUnderlying.check_orphaned();
            typeStoreUserChange_type = get_store().copy_contents_from(xmlObjectBaseUnderlying.get_store()).get_store().change_type(xmlObjectBaseUnderlying.schemaType());
        }
        return (XmlObject) typeStoreUserChange_type;
    }

    public boolean _validateOnSet() {
        return (this._flags & 65536) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void attach_store(TypeStore typeStore) {
        this._textsource = typeStore;
        int i5 = this._flags;
        if ((i5 & 4096) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i5 | 688;
        if (typeStore.is_attribute()) {
            this._flags |= 8;
        }
        if (typeStore.validate_on_set()) {
            this._flags |= 65536;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean build_nil() {
        return (this._flags & 64) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final String build_text(NamespaceManager namespaceManager) {
        if ((this._flags & 320) != 0) {
            return "";
        }
        if (namespaceManager == null) {
            namespaceManager = has_store() ? get_store() : null;
        }
        return compute_text(namespaceManager);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject changeType(SchemaType schemaType) {
        XmlObject xmlObject;
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot have thier type changed");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObject = (XmlObject) get_store().change_type(schemaType);
        }
        return xmlObject;
    }

    public final void check_dated() {
        String str;
        int i5 = this._flags;
        if ((i5 & FLAGS_DATED) != 0) {
            if ((i5 & 2048) != 0) {
                throw new XmlValueDisconnectedException();
            }
            check_element_dated();
            if ((this._flags & 512) != 0) {
                this._flags = get_store().compute_flags() | (this._flags & (-520));
            }
            boolean z6 = false;
            if ((this._flags & 128) != 0) {
                if (get_store().find_nil()) {
                    int i6 = this._flags;
                    if ((i6 & 1) == 0 && (i6 & 65536) != 0) {
                        throw new XmlValueOutOfRangeException();
                    }
                    set_nil();
                    this._flags |= 64;
                    z6 = true;
                } else {
                    this._flags &= -65;
                }
                this._flags &= -129;
            }
            if (!z6) {
                if ((this._flags & 16384) != 0 || (str = get_wscanon_text()) == null) {
                    update_from_complex_content();
                } else {
                    NamespaceContext.push(new NamespaceContext(get_store()));
                    try {
                        update_from_wscanon_text(str);
                        NamespaceContext.pop();
                    } catch (Throwable th) {
                        NamespaceContext.pop();
                        throw th;
                    }
                }
            }
            this._flags &= -33;
        }
    }

    public final void check_orphaned() {
        if (is_orphaned()) {
            throw new XmlValueDisconnectedException();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareTo(Object obj) throws Throwable {
        int iCompareValue = compareValue((XmlObject) obj);
        if (iCompareValue != 2) {
            return iCompareValue;
        }
        throw new ClassCastException();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareValue(XmlObject xmlObject) throws Throwable {
        int iCompareValueImpl;
        int iCompareValueImpl2;
        if (xmlObject == null) {
            return 2;
        }
        boolean z6 = false;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return compareValueImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        iCompareValueImpl2 = compareValueImpl(xmlObject);
                    }
                    return iCompareValueImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return compareValueImpl(xmlObject);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z6 = true;
                        if (z6) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    iCompareValueImpl = compareValueImpl(xmlObject);
                }
                return iCompareValueImpl;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (InterruptedException e6) {
            e = e6;
        }
    }

    public int compare_to(XmlObject xmlObject) {
        return equal_to(xmlObject) ? 0 : 2;
    }

    public abstract String compute_text(NamespaceManager namespaceManager);

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy() {
        XmlObject xmlObject_copy;
        if (preCheck()) {
            return _copy();
        }
        synchronized (monitor()) {
            xmlObject_copy = _copy();
        }
        return xmlObject_copy;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_attribute_user(QName qName) {
        return (TypeStoreUser) ((SchemaTypeImpl) schemaType()).createAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_element_user(QName qName, QName qName2) {
        return (TypeStoreUser) ((SchemaTypeImpl) schemaType()).createElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void disconnect_store() {
        this._flags |= 2720;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            XmlDocumentProperties xmlDocumentPropertiesDocumentProperties = xmlCursorNewCursorForce.documentProperties();
            xmlCursorNewCursorForce.close();
            return xmlDocumentPropertiesDocumentProperties;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.dump();
            xmlCursorNewCursorForce.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public int elementFlags() {
        check_element_dated();
        return this._flags & 7;
    }

    public abstract boolean equal_to(XmlObject xmlObject);

    public final boolean equals(Object obj) {
        if (!isImmutable()) {
            return super.equals(obj);
        }
        if (!(obj instanceof XmlObject)) {
            return false;
        }
        XmlObject xmlObject = (XmlObject) obj;
        if (xmlObject.isImmutable()) {
            return valueEquals(xmlObject);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str) {
        return execQuery(str, null);
    }

    public final XmlObject generatedSetterHelperImpl(XmlObject xmlObject, QName qName, int i5, short s6) {
        XmlObject xmlObject2;
        XmlObject xmlObject3;
        XmlObject xmlObject4;
        XmlObjectBase targetForSetter;
        XmlObjectBase targetForSetter2;
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            synchronized (monitor()) {
                targetForSetter2 = getTargetForSetter(qName, i5, s6);
                targetForSetter2.setNil();
            }
            return targetForSetter2;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            synchronized (monitor()) {
                targetForSetter = getTargetForSetter(qName, i5, s6);
                targetForSetter.setStringValue(xmlObjectBaseUnderlying.getStringValue());
            }
            return targetForSetter;
        }
        boolean zPreCheck = preCheck();
        boolean zPreCheck2 = xmlObjectBaseUnderlying.preCheck();
        if (monitor() == xmlObjectBaseUnderlying.monitor()) {
            if (zPreCheck) {
                return (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i5, s6);
            }
            synchronized (monitor()) {
                xmlObject4 = (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i5, s6);
            }
            return xmlObject4;
        }
        if (zPreCheck) {
            if (zPreCheck2) {
                return (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i5, s6);
            }
            synchronized (xmlObjectBaseUnderlying.monitor()) {
                xmlObject3 = (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i5, s6);
            }
            return xmlObject3;
        }
        if (zPreCheck2) {
            synchronized (monitor()) {
                xmlObject2 = (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i5, s6);
            }
            return xmlObject2;
        }
        boolean z6 = false;
        try {
            try {
                GlobalLock.acquire();
                try {
                    try {
                        synchronized (monitor()) {
                            try {
                                try {
                                    synchronized (xmlObjectBaseUnderlying.monitor()) {
                                        try {
                                            GlobalLock.release();
                                            return (XmlObject) objSetterHelper(xmlObjectBaseUnderlying, qName, i5, s6);
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    throw new XmlRuntimeException(e);
                } catch (Throwable th5) {
                    th = th5;
                    z6 = true;
                    if (z6) {
                        GlobalLock.release();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (InterruptedException e6) {
            e = e6;
        }
    }

    public BigDecimal getBigDecimalValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "numeric"});
    }

    public BigInteger getBigIntegerValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return null;
        }
        return bigDecimalValue.toBigInteger();
    }

    public boolean[] getBooleanArray(QName qName) {
        boolean[] zArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qName);
                int size = baseArray.size();
                zArr = new boolean[size];
                for (int i5 = 0; i5 < size; i5++) {
                    zArr[i5] = baseArray.get(i5).getBooleanValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zArr;
    }

    public boolean getBooleanValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "boolean"});
    }

    public byte[] getByteArray(QName qName) {
        byte[] bArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qName);
                int size = baseArray.size();
                bArr = new byte[size];
                for (int i5 = 0; i5 < size; i5++) {
                    bArr[i5] = baseArray.get(i5).getByteValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    public byte[] getByteArrayValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "byte[]"});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        long intValue = getIntValue();
        if (intValue > 127) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -128) {
            return (byte) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public Calendar getCalendarValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Calendar"});
    }

    public Date getDateValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), HttpHeaders.DATE});
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            Node domNode = xmlCursorNewCursorForce.getDomNode();
            xmlCursorNewCursorForce.close();
            return domNode;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public double[] getDoubleArray(QName qName) {
        double[] array;
        synchronized (monitor()) {
            array = getBaseArray(qName).stream().map(new org.apache.poi.xwpf.usermodel.c(12)).mapToDouble(new j()).toArray();
        }
        return array;
    }

    public double getDoubleValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0d;
        }
        return bigDecimalValue.doubleValue();
    }

    public <T> T[] getEnumArray(QName qName, IntFunction<T[]> intFunction) {
        T[] tArr;
        synchronized (monitor()) {
            tArr = (T[]) getBaseArray(qName).stream().map(new org.apache.poi.xwpf.usermodel.c(13)).toArray(intFunction);
        }
        return tArr;
    }

    public StringEnumAbstractBase getEnumValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "enum"});
    }

    public float[] getFloatArray(QName qName) {
        float[] fArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qName);
                int size = baseArray.size();
                fArr = new float[size];
                for (int i5 = 0; i5 < size; i5++) {
                    fArr[i5] = baseArray.get(i5).getFloatValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fArr;
    }

    public float getFloatValue() {
        BigDecimal bigDecimalValue = getBigDecimalValue();
        if (bigDecimalValue == null) {
            return 0.0f;
        }
        return bigDecimalValue.floatValue();
    }

    public GDate getGDateValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), HttpHeaders.DATE});
    }

    public GDuration getGDurationValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "Duration"});
    }

    public int[] getIntArray(QName qName) {
        int[] array;
        synchronized (monitor()) {
            array = getBaseArray(qName).stream().map(new org.apache.poi.xwpf.usermodel.c(12)).mapToInt(new O4.a(3)).toArray();
        }
        return array;
    }

    public int getIntValue() {
        long longValue = getLongValue();
        if (longValue > 2147483647L) {
            throw new XmlValueOutOfRangeException();
        }
        if (longValue >= -2147483648L) {
            return (int) longValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    public List<?> getListValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "List"});
    }

    public long[] getLongArray(QName qName) {
        long[] array;
        synchronized (monitor()) {
            array = getBaseArray(qName).stream().map(new org.apache.poi.xwpf.usermodel.c(12)).mapToLong(new org.apache.commons.compress.archivers.sevenz.a(5)).toArray();
        }
        return array;
    }

    public long getLongValue() {
        BigInteger bigIntegerValue = getBigIntegerValue();
        if (bigIntegerValue == null) {
            return 0L;
        }
        if (bigIntegerValue.compareTo(_max) >= 0) {
            throw new XmlValueOutOfRangeException();
        }
        if (bigIntegerValue.compareTo(_min) > 0) {
            return bigIntegerValue.longValue();
        }
        throw new XmlValueOutOfRangeException();
    }

    public <T> T[] getObjectArray(QName qName, Function<SimpleValue, T> function, IntFunction<T[]> intFunction) {
        T[] tArr;
        synchronized (monitor()) {
            tArr = (T[]) getBaseArray(qName).stream().map(function).toArray(intFunction);
        }
        return tArr;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object getObjectValue() {
        return java_value(this);
    }

    public QName getQNameValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), XmlErrorCodes.QNAME});
    }

    public short[] getShortArray(QName qName) {
        short[] sArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qName);
                int size = baseArray.size();
                sArr = new short[size];
                for (int i5 = 0; i5 < size; i5++) {
                    sArr[i5] = baseArray.get(i5).getShortValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sArr;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        long intValue = getIntValue();
        if (intValue > 32767) {
            throw new XmlValueOutOfRangeException();
        }
        if (intValue >= -32768) {
            return (short) intValue;
        }
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        if (isImmutable()) {
            if ((this._flags & 64) != 0) {
                return null;
            }
            return compute_text(null);
        }
        synchronized (monitor()) {
            try {
                if (_isComplexContent()) {
                    return get_store().fetch_text(1);
                }
                check_dated();
                if ((this._flags & 64) != 0) {
                    return null;
                }
                return compute_text(has_store() ? get_store() : null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final XmlLocale getXmlLocale() {
        return get_store().get_locale();
    }

    public <T extends XmlObject> T[] getXmlObjectArray(QName qName, T[] tArr) {
        T[] tArr2;
        synchronized (monitor()) {
            tArr2 = (T[]) ((XmlObject[]) getBaseArray(qName).toArray(tArr));
        }
        return tArr2;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaField get_attribute_field(QName qName) {
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null) {
            return null;
        }
        return attributeModel.getAttribute(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_attribute_type(QName qName) {
        return schemaType().getAttributeType(qName, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_attributeflags(QName qName) {
        SchemaProperty attributeProperty;
        if (_isComplexType() && (attributeProperty = schemaType().getAttributeProperty(qName)) != null) {
            return (attributeProperty.hasDefault() == 0 ? 0 : 2) | (attributeProperty.hasFixed() != 0 ? 4 : 0);
        }
        return 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        if (!_isComplexType()) {
            throw new IllegalStateException();
        }
        SchemaProperty attributeProperty = schemaType().getAttributeProperty(qName);
        return attributeProperty == null ? "" : attributeProperty.getDefaultText();
    }

    public XmlAnySimpleType get_default_attribute_value(QName qName) {
        SchemaLocalAttribute attribute;
        SchemaAttributeModel attributeModel = schemaType().getAttributeModel();
        if (attributeModel == null || (attribute = attributeModel.getAttribute(qName)) == null) {
            return null;
        }
        return attribute.getDefaultValue();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        if (!_isComplexContent()) {
            throw new IllegalStateException();
        }
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final QNameSet get_element_ending_delimiters(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return null;
        }
        return elementProperty.getJavaSetterDelimiter();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_element_type(QName qName, QName qName2) {
        return schemaType().getElementType(qName, qName2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty;
        if (!_isComplexContent() || (elementProperty = schemaType().getElementProperty(qName)) == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_schema_type() {
        return schemaType();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final TypeStore get_store() {
        return (TypeStore) this._textsource;
    }

    public int get_wscanon_rule() {
        return 3;
    }

    public final String get_wscanon_text() {
        return (this._flags & 16) == 0 ? apply_wscanon((String) this._textsource) : get_store().fetch_text(get_wscanon_rule());
    }

    public final boolean has_store() {
        return (this._flags & 16) != 0;
    }

    public final int hashCode() {
        if (!isImmutable()) {
            return super.hashCode();
        }
        synchronized (monitor()) {
            try {
                if (isNil()) {
                    return 0;
                }
                return value_hash_code();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void initComplexType(boolean z6, boolean z7) {
        this._flags = (z6 ? 8192 : 0) | (z7 ? 16384 : 0) | this._flags;
    }

    public void init_flags(SchemaProperty schemaProperty) {
        if (schemaProperty == null) {
            return;
        }
        if (schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1 || schemaProperty.hasNillable() == 1) {
            return;
        }
        int i5 = this._flags & (-8);
        this._flags = i5;
        this._flags = (schemaProperty.hasDefault() == 0 ? 0 : 2) | (schemaProperty.hasFixed() == 0 ? 0 : 4) | (schemaProperty.hasNillable() == 0 ? 0 : 1) | 32768 | i5;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        SchemaType schemaType;
        synchronized (monitor()) {
            schemaType = isNil() ? null : schemaType();
        }
        return schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_element_order() {
        this._flags |= FLAGS_DATED;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_nilvalue() {
        this._flags |= 160;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_value() {
        this._flags |= 32;
    }

    public final boolean isDefault() {
        check_dated();
        return (this._flags & 256) != 0;
    }

    public final boolean isDefaultable() {
        check_element_dated();
        return (this._flags & 2) != 0;
    }

    public final boolean isFixed() {
        check_element_dated();
        return (this._flags & 4) != 0;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isImmutable() {
        return (this._flags & 4096) != 0;
    }

    public boolean isInstanceOf(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() != 2) {
            for (SchemaType schemaTypeInstanceType = instanceType(); schemaTypeInstanceType != null; schemaTypeInstanceType = schemaTypeInstanceType.getBaseType()) {
                if (schemaType == schemaTypeInstanceType) {
                    return true;
                }
            }
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes()));
        for (SchemaType schemaTypeInstanceType2 = instanceType(); schemaTypeInstanceType2 != null; schemaTypeInstanceType2 = schemaTypeInstanceType2.getBaseType()) {
            if (hashSet.contains(schemaTypeInstanceType2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean isNil() {
        boolean z6;
        synchronized (monitor()) {
            check_dated();
            z6 = (this._flags & 64) != 0;
        }
        return z6;
    }

    public final boolean isNillable() {
        check_element_dated();
        return (this._flags & 1) != 0;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        if (_isComplexType()) {
            return schemaType().isOrderSensitive();
        }
        return false;
    }

    public boolean is_defaultable_ws(String str) {
        return true;
    }

    public final boolean is_orphaned() {
        return (this._flags & 2048) != 0;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public final Object monitor() {
        return has_store() ? get_store().get_locale() : this;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        XmlCursor xmlCursorNew_cursor;
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot create cursors");
        }
        check_orphaned();
        XmlLocale xmlLocale = getXmlLocale();
        if (xmlLocale.noSync()) {
            xmlLocale.enter();
            try {
                return get_store().new_cursor();
            } finally {
                xmlLocale.exit();
            }
        }
        synchronized (xmlLocale) {
            try {
                xmlLocale.enter();
                try {
                    xmlCursorNew_cursor = get_store().new_cursor();
                    xmlLocale.exit();
                } catch (Throwable th) {
                    xmlLocale.exit();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return xmlCursorNew_cursor;
    }

    public XmlCursor newCursorForce() {
        XmlCursor xmlCursorNewCursor;
        synchronized (monitor()) {
            xmlCursorNewCursor = ensureStore().newCursor();
        }
        return xmlCursorNewCursor;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return newDomNode(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return newInputStream(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return newReader(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return newXMLStreamReader(null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        if (_isComplexContent()) {
            return new SchemaTypeVisitorImpl(schemaType().getContentModel());
        }
        return null;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(contentHandler, lexicalHandler, makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public abstract SchemaType schemaType();

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(QName qName) {
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                xmlCursorNewCursor.close();
                return null;
            }
            if (xmlCursorNewCursor.toFirstAttribute()) {
                while (!xmlCursorNewCursor.getName().equals(qName)) {
                    if (!xmlCursorNewCursor.toNextAttribute()) {
                    }
                }
                XmlObject object = xmlCursorNewCursor.getObject();
                xmlCursorNewCursor.close();
                return object;
            }
            xmlCursorNewCursor.close();
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectAttributes(QNameSet qNameSet) {
        if (qNameSet == null) {
            throw new IllegalArgumentException();
        }
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                XmlObject[] xmlObjectArr = EMPTY_RESULT;
                xmlCursorNewCursor.close();
                return xmlObjectArr;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toFirstAttribute()) {
                do {
                    if (qNameSet.contains(xmlCursorNewCursor.getName())) {
                        arrayList.add(xmlCursorNewCursor.getObject());
                    }
                } while (xmlCursorNewCursor.toNextAttribute());
            }
            if (arrayList.size() == 0) {
                XmlObject[] xmlObjectArr2 = EMPTY_RESULT;
                xmlCursorNewCursor.close();
                return xmlObjectArr2;
            }
            XmlObject[] xmlObjectArr3 = (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
            xmlCursorNewCursor.close();
            return xmlObjectArr3;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QName qName) {
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (!xmlCursorNewCursor.isContainer()) {
                XmlObject[] xmlObjectArr = EMPTY_RESULT;
                xmlCursorNewCursor.close();
                return xmlObjectArr;
            }
            ArrayList arrayList = new ArrayList();
            if (xmlCursorNewCursor.toChild(qName)) {
                do {
                    arrayList.add(xmlCursorNewCursor.getObject());
                } while (xmlCursorNewCursor.toNextSibling(qName));
            }
            if (arrayList.size() == 0) {
                XmlObject[] xmlObjectArr2 = EMPTY_RESULT;
                xmlCursorNewCursor.close();
                return xmlObjectArr2;
            }
            XmlObject[] xmlObjectArr3 = (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
            xmlCursorNewCursor.close();
            return xmlObjectArr3;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str) {
        return selectPath(str, null);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject set(XmlObject xmlObject) throws Throwable {
        TypeStoreUser typeStoreUser;
        if (isImmutable()) {
            throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
        }
        XmlObjectBase xmlObjectBaseUnderlying = underlying(xmlObject);
        if (xmlObjectBaseUnderlying == null) {
            setNil();
            return this;
        }
        if (xmlObjectBaseUnderlying.isImmutable()) {
            setStringValue(xmlObjectBaseUnderlying.getStringValue());
            typeStoreUser = this;
        } else {
            boolean zPreCheck = preCheck();
            boolean zPreCheck2 = xmlObjectBaseUnderlying.preCheck();
            if (monitor() == xmlObjectBaseUnderlying.monitor()) {
                if (zPreCheck) {
                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                } else {
                    synchronized (monitor()) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    }
                }
            } else if (zPreCheck) {
                if (zPreCheck2) {
                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                } else {
                    synchronized (xmlObjectBaseUnderlying.monitor()) {
                        typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                    }
                }
            } else if (zPreCheck2) {
                synchronized (monitor()) {
                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                }
            } else {
                boolean z6 = false;
                try {
                    try {
                        GlobalLock.acquire();
                        try {
                            try {
                                synchronized (monitor()) {
                                    try {
                                        try {
                                            synchronized (xmlObjectBaseUnderlying.monitor()) {
                                                try {
                                                    GlobalLock.release();
                                                    typeStoreUser = setterHelper(xmlObjectBaseUnderlying);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z6 = true;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (InterruptedException e) {
                            e = e;
                            z6 = true;
                            throw new XmlRuntimeException(e);
                        } catch (Throwable th5) {
                            th = th5;
                            z6 = true;
                            if (z6) {
                                GlobalLock.release();
                            }
                            throw th;
                        }
                    } catch (InterruptedException e6) {
                        e = e6;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
        return (XmlObject) typeStoreUser;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigDecimalValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigDecimal(bigDecimal);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigIntegerValue(BigInteger bigInteger) {
        if (bigInteger == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_BigInteger(bigInteger);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBooleanValue(boolean z6) {
        synchronized (monitor()) {
            set_prepare();
            set_boolean(z6);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteArrayValue(byte[] bArr) {
        if (bArr == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_ByteArray(bArr);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteValue(byte b) {
        synchronized (monitor()) {
            set_prepare();
            set_byte(b);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setCalendarValue(Calendar calendar) {
        if (calendar == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Calendar(calendar);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDateValue(Date date) {
        if (date == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_Date(date);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDoubleValue(double d) {
        synchronized (monitor()) {
            set_prepare();
            set_double(d);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase) {
        if (stringEnumAbstractBase == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_enum(stringEnumAbstractBase);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setFloatValue(float f6) {
        synchronized (monitor()) {
            set_prepare();
            set_float(f6);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setGDateValue(GDate gDate) {
        if (gDate == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDate);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setGDurationValue(GDuration gDuration) {
        if (gDuration == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDuration);
            set_commit();
        }
    }

    public void setImmutable() {
        int i5 = this._flags;
        if ((i5 & 4112) != 0) {
            throw new IllegalStateException();
        }
        this._flags = i5 | 4096;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setIntValue(int i5) {
        synchronized (monitor()) {
            set_prepare();
            set_int(i5);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setListValue(List<?> list) {
        if (list == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_list(list);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setLongValue(long j6) {
        synchronized (monitor()) {
            set_prepare();
            set_long(j6);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final void setNil() {
        synchronized (monitor()) {
            try {
                set_prepare();
                int i5 = this._flags;
                if ((i5 & 1) == 0 && (i5 & 65536) != 0) {
                    throw new XmlValueNotNillableException();
                }
                set_nil();
                int i6 = this._flags | 64;
                this._flags = i6;
                if ((i6 & 16) != 0) {
                    get_store().invalidate_text();
                    this._flags &= -673;
                    get_store().invalidate_nil();
                } else {
                    this._textsource = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setObjectValue(Object obj) {
        if (obj == null) {
            setNil();
            return;
        }
        if (obj instanceof XmlObject) {
            set((XmlObject) obj);
            return;
        }
        if (obj instanceof String) {
            setStringValue((String) obj);
            return;
        }
        if (obj instanceof StringEnumAbstractBase) {
            setEnumValue((StringEnumAbstractBase) obj);
            return;
        }
        if (obj instanceof BigInteger) {
            setBigIntegerValue((BigInteger) obj);
            return;
        }
        if (obj instanceof BigDecimal) {
            setBigDecimalValue((BigDecimal) obj);
            return;
        }
        if (obj instanceof Byte) {
            setByteValue(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Short) {
            setShortValue(((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Integer) {
            setIntValue(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            setLongValue(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            setBooleanValue(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Float) {
            setFloatValue(((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            setDoubleValue(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Calendar) {
            setCalendarValue((Calendar) obj);
            return;
        }
        if (obj instanceof Date) {
            setDateValue((Date) obj);
            return;
        }
        if (obj instanceof GDateSpecification) {
            setGDateValue((GDateSpecification) obj);
            return;
        }
        if (obj instanceof GDurationSpecification) {
            setGDurationValue((GDurationSpecification) obj);
            return;
        }
        if (obj instanceof QName) {
            setQNameValue((QName) obj);
        } else if (obj instanceof List) {
            setListValue((List) obj);
        } else {
            if (!(obj instanceof byte[])) {
                throw new XmlValueNotSupportedException("Can't set union object of class : ".concat(obj.getClass().getName()));
            }
            setByteArrayValue((byte[]) obj);
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setQNameValue(QName qName) {
        if (qName == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_QName(qName);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setShortValue(short s6) {
        synchronized (monitor()) {
            set_prepare();
            set_short(s6);
            set_commit();
        }
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setStringValue(String str) {
        if (str == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_String(str);
        }
    }

    public void setValidateOnSet() {
        this._flags |= 65536;
    }

    public void set_BigDecimal(BigDecimal bigDecimal) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"numeric", getPrimitiveTypeName()});
    }

    public void set_BigInteger(BigInteger bigInteger) {
        set_BigDecimal(new BigDecimal(bigInteger));
    }

    public void set_ByteArray(byte[] bArr) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"byte[]", getPrimitiveTypeName()});
    }

    public void set_Calendar(Calendar calendar) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Calendar", getPrimitiveTypeName()});
    }

    public void set_ComplexXml(XmlObject xmlObject) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"complex content", getPrimitiveTypeName()});
    }

    public void set_Date(Date date) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{HttpHeaders.DATE, getPrimitiveTypeName()});
    }

    public void set_GDate(GDateSpecification gDateSpecification) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{HttpHeaders.DATE, getPrimitiveTypeName()});
    }

    public void set_GDuration(GDurationSpecification gDurationSpecification) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"Duration", getPrimitiveTypeName()});
    }

    public void set_QName(QName qName) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{XmlErrorCodes.QNAME, getPrimitiveTypeName()});
    }

    public void set_String(String str) {
        int i5 = this._flags;
        if ((i5 & 4096) != 0) {
            throw new IllegalStateException();
        }
        boolean z6 = (i5 & 64) != 0;
        update_from_wscanon_text(apply_wscanon(str));
        int i6 = this._flags;
        if ((i6 & 16) == 0) {
            this._textsource = str;
            return;
        }
        this._flags = i6 & (-33);
        if ((i6 & 1024) == 0) {
            get_store().store_text(str);
        }
        if (z6) {
            get_store().invalidate_nil();
        }
    }

    public void set_b64(byte[] bArr) {
        set_ByteArray(bArr);
    }

    public void set_boolean(boolean z6) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"boolean", getPrimitiveTypeName()});
    }

    public void set_byte(byte b) {
        set_int(b);
    }

    public void set_char(char c) {
        set_String(Character.toString(c));
    }

    public void set_double(double d) {
        set_BigDecimal(new BigDecimal(d));
    }

    public void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"enum", getPrimitiveTypeName()});
    }

    public void set_float(float f6) {
        set_BigDecimal(new BigDecimal(f6));
    }

    public void set_hex(byte[] bArr) {
        set_ByteArray(bArr);
    }

    public void set_int(int i5) {
        set_long(i5);
    }

    public void set_list(List<?> list) {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_J2S, new Object[]{"List", getPrimitiveTypeName()});
    }

    public void set_long(long j6) {
        set_BigInteger(BigInteger.valueOf(j6));
    }

    public final void set_newValue(XmlObject xmlObject) {
        boolean z6;
        if (xmlObject == null || xmlObject.isNil()) {
            setNil();
            return;
        }
        if (xmlObject instanceof XmlAnySimpleType) {
            XmlAnySimpleType xmlAnySimpleType = (XmlAnySimpleType) xmlObject;
            SchemaType schemaTypeInstanceType = ((SimpleValue) xmlAnySimpleType).instanceType();
            if (schemaTypeInstanceType.getSimpleVariety() == 3) {
                synchronized (monitor()) {
                    set_prepare();
                    set_list(((SimpleValue) xmlAnySimpleType).xgetListValue());
                    set_commit();
                }
                return;
            }
            synchronized (monitor()) {
                try {
                    switch (schemaTypeInstanceType.getPrimitiveType().getBuiltinTypeCode()) {
                        case 2:
                            if (xmlAnySimpleType.isImmutable()) {
                                z6 = false;
                            } else {
                                NamespaceContext.push(new NamespaceContext(xmlAnySimpleType));
                                z6 = true;
                            }
                            try {
                                set_prepare();
                                set_xmlanysimple(xmlAnySimpleType);
                                if (z6) {
                                    NamespaceContext.pop();
                                }
                                set_commit();
                                return;
                            } catch (Throwable th) {
                                if (z6) {
                                    NamespaceContext.pop();
                                }
                                throw th;
                            }
                        case 3:
                            boolean booleanValue = ((SimpleValue) xmlAnySimpleType).getBooleanValue();
                            set_prepare();
                            set_boolean(booleanValue);
                            set_commit();
                            return;
                        case 4:
                            byte[] byteArrayValue = ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
                            set_prepare();
                            set_b64(byteArrayValue);
                            set_commit();
                            return;
                        case 5:
                            byte[] byteArrayValue2 = ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
                            set_prepare();
                            set_hex(byteArrayValue2);
                            set_commit();
                            return;
                        case 6:
                            String stringValue = xmlAnySimpleType.getStringValue();
                            set_prepare();
                            set_text(stringValue);
                            set_commit();
                            return;
                        case 7:
                            QName qNameValue = ((SimpleValue) xmlAnySimpleType).getQNameValue();
                            set_prepare();
                            set_QName(qNameValue);
                            set_commit();
                            return;
                        case 8:
                            String stringValue2 = xmlAnySimpleType.getStringValue();
                            set_prepare();
                            set_notation(stringValue2);
                            set_commit();
                            return;
                        case 9:
                            float floatValue = ((SimpleValue) xmlAnySimpleType).getFloatValue();
                            set_prepare();
                            set_float(floatValue);
                            set_commit();
                            return;
                        case 10:
                            double doubleValue = ((SimpleValue) xmlAnySimpleType).getDoubleValue();
                            set_prepare();
                            set_double(doubleValue);
                            set_commit();
                            return;
                        case 11:
                            int decimalSize = schemaTypeInstanceType.getDecimalSize();
                            if (decimalSize == 8) {
                                byte byteValue = ((SimpleValue) xmlAnySimpleType).getByteValue();
                                set_prepare();
                                set_byte(byteValue);
                            } else if (decimalSize == 16) {
                                short shortValue = ((SimpleValue) xmlAnySimpleType).getShortValue();
                                set_prepare();
                                set_short(shortValue);
                            } else if (decimalSize == 32) {
                                int intValue = ((SimpleValue) xmlAnySimpleType).getIntValue();
                                set_prepare();
                                set_int(intValue);
                            } else if (decimalSize != 64) {
                                switch (decimalSize) {
                                    case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                                        BigInteger bigIntegerValue = ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
                                        set_prepare();
                                        set_BigInteger(bigIntegerValue);
                                        break;
                                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                                    default:
                                        BigDecimal bigDecimalValue = ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
                                        set_prepare();
                                        set_BigDecimal(bigDecimalValue);
                                        break;
                                }
                            } else {
                                long longValue = ((SimpleValue) xmlAnySimpleType).getLongValue();
                                set_prepare();
                                set_long(longValue);
                            }
                            set_commit();
                            return;
                        case 12:
                            String stringValue3 = xmlAnySimpleType.getStringValue();
                            set_prepare();
                            set_String(stringValue3);
                            set_commit();
                            return;
                        case 13:
                            GDuration gDurationValue = ((SimpleValue) xmlAnySimpleType).getGDurationValue();
                            set_prepare();
                            set_GDuration(gDurationValue);
                            set_commit();
                            return;
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            GDate gDateValue = ((SimpleValue) xmlAnySimpleType).getGDateValue();
                            set_prepare();
                            set_GDate(gDateValue);
                            set_commit();
                            return;
                        default:
                            break;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        throw new IllegalStateException("Complex type unexpected");
    }

    public abstract void set_nil();

    public void set_notation(String str) {
        throw new XmlValueNotSupportedException();
    }

    public void set_short(short s6) {
        set_int(s6);
    }

    public abstract void set_text(String str);

    public void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        set_String(xmlAnySimpleType.getStringValue());
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject substitute(QName qName, SchemaType schemaType) {
        XmlObject xmlObject;
        if (qName == null) {
            throw new IllegalArgumentException("Invalid name (null)");
        }
        if (schemaType == null) {
            throw new IllegalArgumentException("Invalid type (null)");
        }
        if ((this._flags & 16) == 0) {
            throw new IllegalStateException("XML Value Objects cannot be used with substitution");
        }
        synchronized (monitor()) {
            check_orphaned();
            xmlObject = (XmlObject) get_store().substitute(qName, schemaType);
        }
        return xmlObject;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final String toString() {
        String strXmlText;
        synchronized (monitor()) {
            strXmlText = ensureStore().xmlText(_toStringOptions);
        }
        return strXmlText;
    }

    public void update_from_complex_content() {
        throw new XmlValueNotSupportedException("Complex content");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final boolean uses_invalidate_value() {
        SchemaType schemaType = schemaType();
        return schemaType.isSimpleType() || schemaType.getContentType() == 2;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate() {
        return validate(null);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void validate_now() {
        check_dated();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean valueEquals(XmlObject xmlObject) throws Throwable {
        boolean zValueEqualsImpl;
        boolean zValueEqualsImpl2;
        boolean z6 = false;
        try {
            try {
                if (isImmutable()) {
                    if (xmlObject.isImmutable()) {
                        return valueEqualsImpl(xmlObject);
                    }
                    synchronized (xmlObject.monitor()) {
                        zValueEqualsImpl2 = valueEqualsImpl(xmlObject);
                    }
                    return zValueEqualsImpl2;
                }
                if (!xmlObject.isImmutable() && monitor() != xmlObject.monitor()) {
                    GlobalLock.acquire();
                    try {
                        try {
                            synchronized (monitor()) {
                                try {
                                    try {
                                        synchronized (xmlObject.monitor()) {
                                            try {
                                                GlobalLock.release();
                                                return valueEqualsImpl(xmlObject);
                                            } catch (Throwable th) {
                                                th = th;
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        throw new XmlRuntimeException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        z6 = true;
                        if (z6) {
                            GlobalLock.release();
                        }
                        throw th;
                    }
                }
                synchronized (monitor()) {
                    zValueEqualsImpl = valueEqualsImpl(xmlObject);
                }
                return zValueEqualsImpl;
            } catch (InterruptedException e6) {
                e = e6;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int valueHashCode() {
        int iValue_hash_code;
        synchronized (monitor()) {
            iValue_hash_code = value_hash_code();
        }
        return iValue_hash_code;
    }

    public abstract int value_hash_code();

    public Object writeReplace() {
        synchronized (monitor()) {
            try {
                if (isRootXmlObject()) {
                    return new SerializedRootObject(this);
                }
                return new SerializedInteriorObject(this, getRootXmlObject());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends XmlObject> T[] xgetArray(QName qName, IntFunction<T[]> intFunction) {
        T[] tArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(qName, arrayList);
            tArr = (T[]) ((XmlObject[]) arrayList.stream().toArray(intFunction));
        }
        return tArr;
    }

    public List<? extends XmlAnySimpleType> xgetListValue() {
        throw new XmlValueNotSupportedException(XmlErrorCodes.EXCEPTION_VALUE_NOT_SUPPORTED_S2J, new Object[]{getPrimitiveTypeName(), "List"});
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return xmlText(null);
    }

    public final XmlObject _copy(XmlOptions xmlOptions) {
        if (isImmutable()) {
            return this;
        }
        check_orphaned();
        return (XmlObject) get_store().copy(get_store().get_schematypeloader(), schemaType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr_typedArray;
        synchronized (monitor()) {
            try {
                TypeStore typeStore = get_store();
                if (typeStore == null) {
                    throw new XmlRuntimeException("Cannot do XQuery on XML Value Objects");
                }
                xmlObjectArr_typedArray = _typedArray(typeStore.exec_query(str, xmlOptions));
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlObjectArr_typedArray;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            Node nodeNewDomNode = xmlCursorNewCursorForce.newDomNode(makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
            return nodeNewDomNode;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            InputStream inputStreamNewInputStream = xmlCursorNewCursorForce.newInputStream(makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
            return inputStreamNewInputStream;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            Reader readerNewReader = xmlCursorNewCursorForce.newReader(makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
            return readerNewReader;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            XMLStreamReader xMLStreamReaderNewXMLStreamReader = xmlCursorNewCursorForce.newXMLStreamReader(makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
            return xMLStreamReaderNewXMLStreamReader;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str, XmlOptions xmlOptions) {
        XmlObject[] xmlObjectArr;
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            if (xmlCursorNewCursor == null) {
                throw new XmlValueDisconnectedException();
            }
            xmlCursorNewCursor.selectPath(str, xmlOptions);
            if (xmlCursorNewCursor.hasNextSelection()) {
                xmlObjectArr = new XmlObject[xmlCursorNewCursor.getSelectionCount()];
                int i5 = 0;
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    xmlObjectArr[i5] = object;
                    if (object == null) {
                        if (xmlCursorNewCursor.toParent()) {
                            XmlObject object2 = xmlCursorNewCursor.getObject();
                            xmlObjectArr[i5] = object2;
                            if (object2 != null) {
                            }
                        }
                        throw new XmlRuntimeException("Path must select only elements and attributes");
                    }
                    i5++;
                }
            } else {
                xmlObjectArr = EMPTY_RESULT;
            }
            xmlCursorNewCursor.close();
            return _typedArray(xmlObjectArr);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate(XmlOptions xmlOptions) {
        boolean zIsValid;
        int i5 = this._flags;
        if ((i5 & 16) == 0) {
            if ((i5 & 4096) != 0) {
                return validate_immutable(xmlOptions);
            }
            throw new IllegalStateException("XML objects with no underlying store cannot be validated");
        }
        synchronized (monitor()) {
            try {
                if ((this._flags & 2048) != 0) {
                    throw new XmlValueDisconnectedException();
                }
                SchemaField schemaField = schemaField();
                SchemaType schemaType = schemaType();
                TypeStore typeStore = get_store();
                Validator validator = new Validator(schemaType, schemaField, typeStore.get_schematypeloader(), xmlOptions, null);
                typeStore.validate(validator);
                zIsValid = validator.isValid();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIsValid;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            String strXmlText = xmlCursorNewCursorForce.xmlText(makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
            return strXmlText;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private List<XmlObjectBase> getBaseArray(QNameSet qNameSet) {
        check_orphaned();
        ArrayList arrayList = new ArrayList();
        get_store().find_all_element_users(qNameSet, arrayList);
        return arrayList;
    }

    public <T> T[] getEnumArray(QNameSet qNameSet, IntFunction<T[]> intFunction) {
        T[] tArr;
        synchronized (monitor()) {
            tArr = (T[]) getBaseArray(qNameSet).stream().map(new org.apache.poi.xwpf.usermodel.c(13)).toArray(intFunction);
        }
        return tArr;
    }

    public <T> T[] getObjectArray(QNameSet qNameSet, Function<SimpleValue, T> function, IntFunction<T[]> intFunction) {
        T[] tArr;
        synchronized (monitor()) {
            tArr = (T[]) getBaseArray(qNameSet).stream().map(function).toArray(intFunction);
        }
        return tArr;
    }

    public <T extends XmlObject> T[] getXmlObjectArray(QNameSet qNameSet, T[] tArr) {
        T[] tArr2;
        synchronized (monitor()) {
            tArr2 = (T[]) ((XmlObject[]) getBaseArray(qNameSet).toArray(tArr));
        }
        return tArr2;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy(XmlOptions xmlOptions) {
        XmlObject xmlObject_copy;
        if (preCheck()) {
            return _copy(xmlOptions);
        }
        synchronized (monitor()) {
            xmlObject_copy = _copy(xmlOptions);
        }
        return xmlObject_copy;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(file, makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public boolean[] getBooleanArray(QNameSet qNameSet) {
        boolean[] zArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qNameSet);
                int size = baseArray.size();
                zArr = new boolean[size];
                for (int i5 = 0; i5 < size; i5++) {
                    zArr[i5] = baseArray.get(i5).getBooleanValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zArr;
    }

    public byte[] getByteArray(QNameSet qNameSet) {
        byte[] bArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qNameSet);
                int size = baseArray.size();
                bArr = new byte[size];
                for (int i5 = 0; i5 < size; i5++) {
                    bArr[i5] = baseArray.get(i5).getByteValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    public float[] getFloatArray(QNameSet qNameSet) {
        float[] fArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qNameSet);
                int size = baseArray.size();
                fArr = new float[size];
                for (int i5 = 0; i5 < size; i5++) {
                    fArr[i5] = baseArray.get(i5).getFloatValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fArr;
    }

    public short[] getShortArray(QNameSet qNameSet) {
        short[] sArr;
        synchronized (monitor()) {
            try {
                List<XmlObjectBase> baseArray = getBaseArray(qNameSet);
                int size = baseArray.size();
                sArr = new short[size];
                for (int i5 = 0; i5 < size; i5++) {
                    sArr[i5] = baseArray.get(i5).getShortValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sArr;
    }

    public final void setGDateValue(GDateSpecification gDateSpecification) {
        if (gDateSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDate(gDateSpecification);
            set_commit();
        }
    }

    public final void setGDurationValue(GDurationSpecification gDurationSpecification) {
        if (gDurationSpecification == null) {
            setNil();
            return;
        }
        synchronized (monitor()) {
            set_prepare();
            set_GDuration(gDurationSpecification);
            set_commit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends XmlObject> T[] xgetArray(QNameSet qNameSet, IntFunction<T[]> intFunction) {
        T[] tArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(qNameSet, arrayList);
            tArr = (T[]) ((XmlObject[]) arrayList.stream().toArray(intFunction));
        }
        return tArr;
    }

    public double[] getDoubleArray(QNameSet qNameSet) {
        double[] array;
        synchronized (monitor()) {
            array = getBaseArray(qNameSet).stream().map(new org.apache.poi.xwpf.usermodel.c(12)).mapToDouble(new j()).toArray();
        }
        return array;
    }

    public int[] getIntArray(QNameSet qNameSet) {
        int[] array;
        synchronized (monitor()) {
            array = getBaseArray(qNameSet).stream().map(new org.apache.poi.xwpf.usermodel.c(12)).mapToInt(new O4.a(3)).toArray();
        }
        return array;
    }

    public long[] getLongArray(QNameSet qNameSet) {
        long[] array;
        synchronized (monitor()) {
            array = getBaseArray(qNameSet).stream().map(new org.apache.poi.xwpf.usermodel.c(12)).mapToLong(new org.apache.commons.compress.archivers.sevenz.a(5)).toArray();
        }
        return array;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(outputStream, makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(String str, String str2) {
        return selectAttribute(new QName(str, str2));
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) {
        XmlCursor xmlCursorNewCursorForce = newCursorForce();
        try {
            xmlCursorNewCursorForce.save(writer, makeInnerOptions(xmlOptions));
            xmlCursorNewCursorForce.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursorForce != null) {
                    try {
                        xmlCursorNewCursorForce.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(String str, String str2) {
        return selectChildren(new QName(str, str2));
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QNameSet qNameSet) {
        if (qNameSet != null) {
            XmlCursor xmlCursorNewCursor = newCursor();
            try {
                if (!xmlCursorNewCursor.isContainer()) {
                    XmlObject[] xmlObjectArr = EMPTY_RESULT;
                    xmlCursorNewCursor.close();
                    return xmlObjectArr;
                }
                ArrayList arrayList = new ArrayList();
                if (xmlCursorNewCursor.toFirstChild()) {
                    do {
                        if (qNameSet.contains(xmlCursorNewCursor.getName())) {
                            arrayList.add(xmlCursorNewCursor.getObject());
                        }
                    } while (xmlCursorNewCursor.toNextSibling());
                }
                if (arrayList.size() == 0) {
                    XmlObject[] xmlObjectArr2 = EMPTY_RESULT;
                    xmlCursorNewCursor.close();
                    return xmlObjectArr2;
                }
                XmlObject[] xmlObjectArr3 = (XmlObject[]) arrayList.toArray(EMPTY_RESULT);
                xmlCursorNewCursor.close();
                return xmlObjectArr3;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) {
        save(contentHandler, lexicalHandler, null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) {
        save(file, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) {
        save(outputStream, (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) {
        save(writer, (XmlOptions) null);
    }

    public void validate_simpleval(String str, ValidationContext validationContext) {
    }
}
