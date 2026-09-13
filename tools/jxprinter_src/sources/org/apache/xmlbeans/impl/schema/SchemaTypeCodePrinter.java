package org.apache.xmlbeans.impl.schema;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.xml.namespace.QName;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.repackage.Repackager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class SchemaTypeCodePrinter implements SchemaCodePrinter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_NEW_VALUE = 3;
    private static final int INDENT_INCREMENT = 4;
    static final String INDEX_CLASSNAME = "TypeSystemHolder";
    private static final String MAX_SPACES = "                                        ";
    private static final int NOTHING = 1;
    private static final int THROW_EXCEPTION = 4;
    private int _indent = 0;
    private Writer _writer;
    private XmlOptions opt;

    private void emitSpecializedAccessors(SchemaType schemaType) throws IOException {
        int decimalSize;
        if (schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == 11 && ((decimalSize = schemaType.getDecimalSize()) != schemaType.getBaseType().getDecimalSize() || schemaType.getBaseType().getFullJavaName() == null)) {
            if (decimalSize == 8) {
                emit("byte getByteValue();", XmlOptions.BeanMethod.GET);
                emit("void setByteValue(byte b);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 16) {
                emit("short getShortValue();", XmlOptions.BeanMethod.GET);
                emit("void setShortValue(short s);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 32) {
                emit("int getIntValue();", XmlOptions.BeanMethod.GET);
                emit("void setIntValue(int i);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 64) {
                emit("long getLongValue();", XmlOptions.BeanMethod.GET);
                emit("void setLongValue(long l);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 1000000) {
                emit("java.math.BigInteger getBigIntegerValue();", XmlOptions.BeanMethod.GET);
                emit("void setBigIntegerValue(java.math.BigInteger bi);", XmlOptions.BeanMethod.SET);
            }
        }
        if (schemaType.getSimpleVariety() == 2) {
            emit("java.lang.Object getObjectValue();", XmlOptions.BeanMethod.GET);
            emit("void setObjectValue(java.lang.Object val);", XmlOptions.BeanMethod.SET);
            emit("org.apache.xmlbeans.SchemaType instanceType();", XmlOptions.BeanMethod.INSTANCE_TYPE);
            SchemaType unionCommonBaseType = schemaType.getUnionCommonBaseType();
            if (unionCommonBaseType != null && unionCommonBaseType.getSimpleVariety() != 2) {
                emitSpecializedAccessors(unionCommonBaseType);
            }
        }
        if (schemaType.getSimpleVariety() == 3) {
            emit("java.util.List getListValue();", XmlOptions.BeanMethod.GET_LIST);
            emit("java.util.List xgetListValue();", XmlOptions.BeanMethod.XGET_LIST);
            emit("void setListValue(java.util.List<?> list);", XmlOptions.BeanMethod.SET_LIST);
        }
    }

    public static SchemaType findBaseType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    private SchemaProperty[] getDerivedProperties(SchemaType schemaType) {
        QName name = schemaType.getName();
        if (name == null || !name.equals(schemaType.getBaseType().getName())) {
            return schemaType.getDerivedProperties();
        }
        SchemaProperty[] derivedProperties = schemaType.getDerivedProperties();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SchemaProperty schemaProperty : derivedProperties) {
            linkedHashMap.put(schemaProperty.getName(), schemaProperty);
        }
        for (SchemaType baseType = schemaType.getBaseType(); baseType != null && name.equals(baseType.getName()); baseType = baseType.getBaseType()) {
            for (SchemaProperty schemaProperty2 : baseType.getDerivedProperties()) {
                if (!linkedHashMap.containsKey(schemaProperty2.getName())) {
                    linkedHashMap.put(schemaProperty2.getName(), schemaProperty2);
                }
            }
        }
        return (SchemaProperty[]) linkedHashMap.values().toArray(new SchemaProperty[0]);
    }

    private static String getExtensionInterfaces(SchemaType schemaType) {
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        InterfaceExtension[] interfaceExtensions = impl.getInterfaceExtensions();
        if (interfaceExtensions != null) {
            for (InterfaceExtension interfaceExtension : interfaceExtensions) {
                sb.append(", ");
                sb.append(interfaceExtension.getInterface());
            }
        }
        return sb.toString();
    }

    private String getFullJavaName(SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
        String fullJavaName = schemaTypeImpl.getFullJavaName();
        while (schemaTypeImpl != null && schemaTypeImpl.isRedefinition()) {
            fullJavaName = schemaTypeImpl.getFullJavaName();
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        }
        return fullJavaName;
    }

    private static SchemaTypeImpl getImpl(SchemaType schemaType) {
        if (schemaType instanceof SchemaTypeImpl) {
            return (SchemaTypeImpl) schemaType;
        }
        return null;
    }

    private String getUserTypeStaticHandlerMethod(boolean z6, SchemaTypeImpl schemaTypeImpl) {
        String upperCase;
        String localPart = schemaTypeImpl.getName().getLocalPart();
        if (localPart.length() < 2) {
            upperCase = localPart.toUpperCase(Locale.ROOT);
        } else {
            upperCase = localPart.substring(0, 1).toUpperCase(Locale.ROOT) + localPart.substring(1);
        }
        if (z6) {
            return schemaTypeImpl.getUserTypeHandlerName() + ".encode" + upperCase;
        }
        return schemaTypeImpl.getUserTypeHandlerName() + ".decode" + upperCase;
    }

    private boolean hasBase(SchemaType schemaType) {
        SchemaType baseEnumType = schemaType.getBaseEnumType();
        if (!baseEnumType.isAnonymousType() || !baseEnumType.isSkippedAnonymousType()) {
            return baseEnumType != schemaType;
        }
        if (schemaType.getContentBasedOnType() != null) {
            return schemaType.getContentBasedOnType().getBaseType() != baseEnumType;
        }
        return schemaType.getBaseType() != baseEnumType;
    }

    public static String indexClassForSystem(SchemaTypeSystem schemaTypeSystem) {
        return androidx.collection.a.n(schemaTypeSystem.getName(), ".TypeSystemHolder");
    }

    public static boolean isJavaPrimitive(int i5) {
        return i5 >= 1 && i5 <= 7;
    }

    public static String javaStringEscape(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\"' || cCharAt == '\\') {
                StringBuilder sb = new StringBuilder();
                for (int i6 = 0; i6 < str.length(); i6++) {
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 == '\n') {
                        sb.append("\\n");
                    } else if (cCharAt2 == '\r') {
                        sb.append("\\r");
                    } else if (cCharAt2 == '\"') {
                        sb.append("\\\"");
                    } else if (cCharAt2 != '\\') {
                        sb.append(cCharAt2);
                    } else {
                        sb.append("\\\\");
                    }
                }
                return sb.toString();
            }
        }
        return str;
    }

    public static String javaWrappedType(int i5) {
        switch (i5) {
            case 1:
                return "java.lang.Boolean";
            case 2:
                return "java.lang.Float";
            case 3:
                return "java.lang.Double";
            case 4:
                return "java.lang.Byte";
            case 5:
                return "java.lang.Short";
            case 6:
                return "java.lang.Integer";
            case 7:
                return "java.lang.Long";
            default:
                throw new IllegalStateException();
        }
    }

    private static String makeSafe(String str) {
        CharsetEncoder charsetEncoderNewEncoder = Charset.forName(System.getProperty("file.encoding")).newEncoder();
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (i5 < str.length() && charsetEncoderNewEncoder.canEncode(str.charAt(i5))) {
            i5++;
        }
        while (i5 < str.length()) {
            char cCharAt = str.charAt(i5);
            if (charsetEncoderNewEncoder.canEncode(cCharAt)) {
                sb.append(cCharAt);
            } else {
                String hexString = Integer.toHexString(cCharAt);
                int length = hexString.length();
                if (length == 1) {
                    sb.append("\\u000");
                    sb.append(hexString);
                } else if (length == 2) {
                    sb.append("\\u00");
                    sb.append(hexString);
                } else if (length == 3) {
                    sb.append("\\u0");
                    sb.append(hexString);
                } else {
                    if (length != 4) {
                        throw new IllegalStateException();
                    }
                    sb.append("\\u");
                    sb.append(hexString);
                }
            }
            i5++;
        }
        return sb.toString();
    }

    public static String prettyQName(QName qName) {
        if (qName == null) {
            return "";
        }
        String localPart = qName.getLocalPart();
        if (qName.getNamespaceURI() == null) {
            return localPart;
        }
        StringBuilder sbX = AbstractC0157z.x(localPart, "(@");
        sbX.append(qName.getNamespaceURI());
        sbX.append(")");
        return sbX.toString();
    }

    private void printExtensionImplMethods(SchemaType schemaType) throws IOException {
        InterfaceExtension[] interfaceExtensions;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (interfaceExtensions = impl.getInterfaceExtensions()) == null) {
            return;
        }
        for (InterfaceExtension interfaceExtension : interfaceExtensions) {
            InterfaceExtension.MethodSignature[] methods = interfaceExtension.getMethods();
            if (methods != null) {
                for (InterfaceExtension.MethodSignature methodSignature : methods) {
                    printJavaDoc("Implementation method for interface " + interfaceExtension.getStaticHandler());
                    printInterfaceMethodDecl(methodSignature);
                    startBlock();
                    printInterfaceMethodImpl(interfaceExtension.getStaticHandler(), methodSignature);
                    endBlock();
                }
            }
        }
    }

    public static boolean xmlTypeForPropertyIsUnion(SchemaProperty schemaProperty) {
        SchemaType schemaTypeJavaBasedOnType = schemaProperty.javaBasedOnType();
        return schemaTypeJavaBasedOnType.isSimpleType() && schemaTypeJavaBasedOnType.getSimpleVariety() == 2;
    }

    public void emit(String str, XmlOptions.BeanMethod beanMethod) throws IOException {
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        if (compilePartialMethod == null || compilePartialMethod.contains(beanMethod)) {
            emit(str);
        }
    }

    public void emitAddTarget(String str, boolean z6, String str2) throws IOException {
        if (z6) {
            emit(androidx.collection.a.p("target = (", str2, ")get_store().add_attribute_user(", str, ");"));
        } else {
            emit(androidx.collection.a.p("target = (", str2, ")get_store().add_element_user(", str, ");"));
        }
    }

    public void emitGetTarget(String str, String str2, boolean z6, String str3, int i5, String str4) throws IOException {
        emit(str4 + " target = null;");
        if (z6) {
            emit(androidx.collection.a.p("target = (", str4, ")get_store().find_attribute_user(", str2, ");"));
        } else {
            StringBuilder sbU = androidx.collection.a.u("target = (", str4, ")get_store().find_element_user(", str, ", ");
            sbU.append(str3);
            sbU.append(");");
            emit(sbU.toString());
        }
        if (i5 == 1) {
            return;
        }
        emit("if (target == null) {");
        startBlock();
        if (i5 == 3) {
            emitAddTarget(str2, z6, str4);
        } else if (i5 == 4) {
            emit("throw new IndexOutOfBoundsException();");
        }
        endBlock();
    }

    public void emitImplementationPostamble() throws IOException {
        outdent();
        emit(VectorFormat.DEFAULT_SUFFIX);
    }

    public void emitImplementationPreamble() throws IOException {
        emit("synchronized (monitor()) {");
        indent();
        emit("check_orphaned();");
    }

    public void emitPost(SchemaType schemaType, int i5, String str, boolean z6) throws IOException {
        emitPost(schemaType, i5, str, z6, StructuredDataId.RESERVED);
    }

    public void emitPre(SchemaType schemaType, int i5, String str, boolean z6) throws IOException {
        emitPre(schemaType, i5, str, z6, StructuredDataId.RESERVED);
    }

    public void endBlock() throws IOException {
        outdent();
        emit(VectorFormat.DEFAULT_SUFFIX);
    }

    public String findJavaType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType.getFullJavaName();
    }

    public String getAtomicRestrictionType(SchemaType schemaType) {
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return "org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl";
            case 3:
                return "org.apache.xmlbeans.impl.values.JavaBooleanHolderEx";
            case 4:
                return "org.apache.xmlbeans.impl.values.JavaBase64HolderEx";
            case 5:
                return "org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx";
            case 6:
                return "org.apache.xmlbeans.impl.values.JavaUriHolderEx";
            case 7:
                return "org.apache.xmlbeans.impl.values.JavaQNameHolderEx";
            case 8:
                return "org.apache.xmlbeans.impl.values.JavaNotationHolderEx";
            case 9:
                return "org.apache.xmlbeans.impl.values.JavaFloatHolderEx";
            case 10:
                return "org.apache.xmlbeans.impl.values.JavaDoubleHolderEx";
            case 11:
                int decimalSize = schemaType.getDecimalSize();
                if (decimalSize == 8 || decimalSize == 16 || decimalSize == 32) {
                    return "org.apache.xmlbeans.impl.values.JavaIntHolderEx";
                }
                if (decimalSize == 64) {
                    return "org.apache.xmlbeans.impl.values.JavaLongHolderEx";
                }
                switch (decimalSize) {
                    case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                        return "org.apache.xmlbeans.impl.values.JavaIntegerHolderEx";
                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                    default:
                        return "org.apache.xmlbeans.impl.values.JavaDecimalHolderEx";
                }
            case 12:
                return schemaType.hasStringEnumValues() ? "org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx" : "org.apache.xmlbeans.impl.values.JavaStringHolderEx";
            case 13:
                return "org.apache.xmlbeans.impl.values.JavaGDurationHolderEx";
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return "org.apache.xmlbeans.impl.values.JavaGDateHolderEx";
            default:
                return null;
        }
    }

    public String getBaseClass(SchemaType schemaType) {
        SchemaType schemaTypeFindBaseType = findBaseType(schemaType.getBaseType());
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            return !XmlObject.type.equals(schemaTypeFindBaseType) ? schemaTypeFindBaseType.getFullJavaImplName() : "org.apache.xmlbeans.impl.values.XmlComplexContentImpl";
        }
        if (simpleVariety == 1) {
            return getAtomicRestrictionType(schemaType);
        }
        if (simpleVariety == 2) {
            return "org.apache.xmlbeans.impl.values.XmlUnionImpl";
        }
        if (simpleVariety == 3) {
            return "org.apache.xmlbeans.impl.values.XmlListImpl";
        }
        throw new IllegalStateException();
    }

    public String getIdentifier(Map<QName, Integer> map, QName qName) {
        return "PROPERTY_QNAME[" + map.get(qName) + "]";
    }

    public SchemaProperty[] getSchemaProperties(SchemaType schemaType) {
        if (schemaType.getContentType() != 2) {
            return getDerivedProperties(schemaType);
        }
        SchemaType baseType = schemaType.getBaseType();
        ArrayList arrayList = null;
        while (true) {
            if (baseType.isSimpleType() || baseType.isBuiltinType()) {
                break;
            }
            for (SchemaProperty schemaProperty : baseType.getDerivedProperties()) {
                if (!schemaProperty.isAttribute() || schemaType.getAttributeProperty(schemaProperty.getName()) == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(schemaProperty);
                }
            }
            baseType = baseType.getBaseType();
        }
        SchemaProperty[] properties = schemaType.getProperties();
        if (arrayList == null) {
            return properties;
        }
        Collections.addAll(arrayList, properties);
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[0]);
    }

    public String getSetIdentifier(Map<QName, Integer> map, QName qName, Map<QName, Integer> map2) {
        Integer num = map2.get(qName);
        if (num == null) {
            return getIdentifier(map, qName);
        }
        return "PROPERTY_QSET[" + num + "]";
    }

    public void indent() {
        this._indent += 4;
    }

    public String javaTypeForProperty(SchemaProperty schemaProperty) {
        if (schemaProperty.getJavaTypeCode() == 0) {
            return findJavaType(schemaProperty.javaBasedOnType()).replace('$', '.');
        }
        if (schemaProperty.getJavaTypeCode() == 20) {
            return ((SchemaTypeImpl) schemaProperty.getType()).getUserTypeName();
        }
        switch (schemaProperty.getJavaTypeCode()) {
            case 1:
                return "boolean";
            case 2:
                return "float";
            case 3:
                return XmlErrorCodes.DOUBLE;
            case 4:
                return "byte";
            case 5:
                return "short";
            case 6:
                return XmlErrorCodes.INT;
            case 7:
                return XmlErrorCodes.LONG;
            case 8:
                return "java.math.BigDecimal";
            case 9:
                return "java.math.BigInteger";
            case 10:
                return "java.lang.String";
            case 11:
                return "byte[]";
            case 12:
                return "org.apache.xmlbeans.GDate";
            case 13:
                return "org.apache.xmlbeans.GDuration";
            case 14:
                return "java.util.Date";
            case 15:
                return "javax.xml.namespace.QName";
            case 16:
                return "java.util.List";
            case 17:
                return "java.util.Calendar";
            case 18:
                SchemaType schemaTypeJavaBasedOnType = schemaProperty.javaBasedOnType();
                if (schemaTypeJavaBasedOnType.getSimpleVariety() == 2) {
                    schemaTypeJavaBasedOnType = schemaTypeJavaBasedOnType.getUnionCommonBaseType();
                }
                if (hasBase(schemaTypeJavaBasedOnType)) {
                    return findJavaType(schemaTypeJavaBasedOnType.getBaseEnumType()).replace('$', '.') + ".Enum";
                }
                return findJavaType(schemaTypeJavaBasedOnType).replace('$', '.') + ".Enum";
            case 19:
                return "java.lang.Object";
            default:
                throw new IllegalStateException();
        }
    }

    public void makeAttributeDefaultValue(String str, SchemaProperty schemaProperty, String str2) throws IOException {
        if (str == null) {
            str = schemaProperty.javaBasedOnType().getFullJavaName().replace('$', '.');
        }
        emit(androidx.collection.a.p("target = (", str, ")get_default_attribute_value(", str2, ");"));
    }

    public String makeMissingValue(int i5) {
        switch (i5) {
            case 1:
                return "false";
            case 2:
                return "0.0f";
            case 3:
                return IdManager.DEFAULT_VERSION_NAME;
            case 4:
            case 5:
            case 6:
                return "0";
            case 7:
                return "0L";
            default:
                return AbstractC1127c.NULL;
        }
    }

    public void outdent() {
        this._indent -= 4;
    }

    public String prePostOpString(int i5) {
        if (i5 == 1) {
            return "org.apache.xmlbeans.PrePostExtension.OPERATION_SET";
        }
        if (i5 != 2) {
            return i5 != 3 ? "org.apache.xmlbeans.PrePostExtension.OPERATION_SET" : "org.apache.xmlbeans.PrePostExtension.OPERATION_REMOVE";
        }
        return "org.apache.xmlbeans.PrePostExtension.OPERATION_INSERT";
    }

    public void printConstructor(SchemaType schemaType, String str) throws IOException {
        String string;
        emit("");
        emit("public " + str + "(org.apache.xmlbeans.SchemaType sType) {");
        startBlock();
        StringBuilder sb = new StringBuilder("super(sType");
        if (schemaType.getSimpleVariety() == 0) {
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder(", ");
            sb2.append(!schemaType.isSimpleType());
            string = sb2.toString();
        }
        sb.append(string);
        sb.append(");");
        emit(sb.toString());
        endBlock();
        if (schemaType.getSimpleVariety() != 0) {
            emit("");
            emit("protected " + str + "(org.apache.xmlbeans.SchemaType sType, boolean b) {");
            startBlock();
            emit("super(sType, b);");
            endBlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:103:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:106:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:109:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:110:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:113:0x030f  */
    /* JADX WARN: Code duplicated, block: B:115:0x031b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0320  */
    /* JADX WARN: Code duplicated, block: B:123:0x0345  */
    /* JADX WARN: Code duplicated, block: B:125:0x0361  */
    /* JADX WARN: Code duplicated, block: B:133:0x0398  */
    /* JADX WARN: Code duplicated, block: B:135:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:138:0x040b  */
    /* JADX WARN: Code duplicated, block: B:139:0x0419  */
    /* JADX WARN: Code duplicated, block: B:146:0x0446  */
    /* JADX WARN: Code duplicated, block: B:153:0x0483  */
    /* JADX WARN: Code duplicated, block: B:164:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:171:0x0540  */
    /* JADX WARN: Code duplicated, block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:109:0x02dc, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:110:0x02f3, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:123:0x0345, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:133:0x0398, please report this as an issue */
    public void printGetterImpls(SchemaProperty schemaProperty, Map<QName, Integer> map, Map<QName, Integer> map2) throws IOException {
        String str;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        String strN;
        String strJavaWrappedType;
        String str6;
        boolean z6;
        int i6;
        String str7;
        String str8;
        String str9;
        boolean z7;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z8;
        String str15;
        String str16;
        SchemaProperty schemaProperty2;
        int i7;
        String str17;
        QName name = schemaProperty.getName();
        String identifier = getIdentifier(map, name);
        String setIdentifier = getSetIdentifier(map, name, map2);
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        boolean z9 = schemaProperty.hasNillable() != 0;
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        String str18 = identifier;
        boolean zIsAttribute = schemaProperty.isAttribute();
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        String documentation = schemaProperty.getDocumentation();
        StringBuilder sb = new StringBuilder("\"");
        sb.append(name.getLocalPart());
        sb.append("\"");
        sb.append(zIsAttribute ? " attribute" : " element");
        String string = sb.toString();
        boolean z10 = javaTypeCode == 0;
        String str19 = (xmlTypeForPropertyIsUnion(schemaProperty) || !z10) ? "org.apache.xmlbeans.SimpleValue" : strXmlTypeForProperty;
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        String str20 = "public boolean isNil";
        String str21 = " xget";
        String str22 = ";";
        String str23 = "public ";
        boolean z11 = z9;
        if (schemaProperty.extendsJavaSingleton()) {
            if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.GET)) {
                if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(zExtendsJavaArray ? "Gets first " : "Gets the ");
                    sb2.append(string);
                    printJavaDoc(sb2.toString());
                } else {
                    printJavaDocParagraph(documentation);
                }
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(androidx.collection.a.p("public ", strJavaTypeForProperty, " get", javaPropertyName, "() {"));
                startBlock();
                emitImplementationPreamble();
                str = " get";
                str22 = str22;
                emitGetTarget(setIdentifier, str18, zIsAttribute, "0", 1, str19);
                str16 = str19;
                if (zIsAttribute && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                    emit("if (target == null) {");
                    startBlock();
                    schemaProperty2 = schemaProperty;
                    makeAttributeDefaultValue(str16, schemaProperty2, str18);
                    endBlock();
                } else {
                    schemaProperty2 = schemaProperty;
                }
                StringBuilder sb3 = new StringBuilder("return (target == null) ? ");
                i7 = javaTypeCode;
                sb3.append(makeMissingValue(i7));
                sb3.append(" : ");
                sb3.append(printJGetValue(i7, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty2.getType()));
                sb3.append(str22);
                emit(sb3.toString());
                emitImplementationPostamble();
                endBlock();
            } else {
                str = " get";
                str16 = str19;
                schemaProperty2 = schemaProperty;
                str22 = str22;
                i7 = javaTypeCode;
            }
            if (z10 || !(compilePartialMethod == 0 || compilePartialMethod.contains(XmlOptions.BeanMethod.XGET))) {
                str18 = str18;
                i5 = i7;
                str2 = "return target;";
                setIdentifier = setIdentifier;
                str17 = strXmlTypeForProperty;
                str23 = str23;
                str4 = str16;
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(zExtendsJavaArray ? "Gets (as xml) first " : "Gets (as xml) the ");
                sb4.append(string);
                printJavaDoc(sb4.toString());
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                str17 = strXmlTypeForProperty;
                emit(androidx.collection.a.p("public ", str17, str21, javaPropertyName, "() {"));
                startBlock();
                emitImplementationPreamble();
                str18 = str18;
                i5 = i7;
                str4 = str16;
                setIdentifier = setIdentifier;
                str23 = "public ";
                emitGetTarget(setIdentifier, str18, zIsAttribute, "0", 1, str17);
                if (zIsAttribute && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                    emit("if (target == null) {");
                    startBlock();
                    makeAttributeDefaultValue(str17, schemaProperty, str18);
                    endBlock();
                }
                str2 = "return target;";
                emit(str2);
                emitImplementationPostamble();
                endBlock();
            }
            if (z11 && (compilePartialMethod == 0 || compilePartialMethod.contains(XmlOptions.BeanMethod.IS_NIL))) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(zExtendsJavaArray ? "Tests for nil first " : "Tests for nil ");
                sb5.append(string);
                printJavaDoc(sb5.toString());
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(str20 + javaPropertyName + "() {");
                startBlock();
                emitImplementationPreamble();
                str20 = str20;
                emitGetTarget(setIdentifier, str18, zIsAttribute, "0", 1, str17);
                zIsAttribute = zIsAttribute;
                str3 = str17;
                str5 = str18;
                emit("return target != null && target.isNil();");
                emitImplementationPostamble();
                endBlock();
            } else {
                str3 = str17;
            }
            if (schemaProperty.extendsJavaOption() && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.IS_SET))) {
                StringBuilder sb6 = new StringBuilder();
                if (zExtendsJavaArray) {
                    str15 = "True if has at least one ";
                } else {
                    str15 = "True if has ";
                }
                sb6.append(str15);
                sb6.append(string);
                printJavaDoc(sb6.toString());
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit("public boolean isSet" + javaPropertyName + "() {");
                startBlock();
                emitImplementationPreamble();
                if (zIsAttribute) {
                    emit("return get_store().find_attribute_user(" + str5 + ") != null;");
                } else {
                    emit("return get_store().count_elements(" + setIdentifier + ") != 0;");
                }
                emitImplementationPostamble();
                endBlock();
            }
            if (zExtendsJavaArray) {
                strN = androidx.collection.a.n(javaPropertyName, SoapEncSchemaTypeSystem.SOAP_ARRAY);
                if (isJavaPrimitive(i5)) {
                    strJavaWrappedType = javaWrappedType(i5);
                } else {
                    strJavaWrappedType = strJavaTypeForProperty;
                }
                str6 = setIdentifier;
                String str24 = strJavaWrappedType;
                z6 = z10;
                printListGetterImpl(string, javaPropertyName, str24, z6, false);
                if (compilePartialMethod != null || compilePartialMethod.contains(XmlOptions.BeanMethod.GET_ARRAY)) {
                    printJavaDoc("Gets array of all " + string + "s");
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit(androidx.collection.a.p(str23, strJavaTypeForProperty, "[] get", strN, "() {"));
                    startBlock();
                    i6 = i5;
                    printJGetArrayValue(i6, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType(), str6);
                    endBlock();
                } else {
                    i6 = i5;
                }
                if (compilePartialMethod != null || compilePartialMethod.contains(XmlOptions.BeanMethod.GET_IDX)) {
                    printJavaDoc("Gets ith " + string);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit(androidx.collection.a.p(str23, strJavaTypeForProperty, str, strN, "(int i) {"));
                    startBlock();
                    emitImplementationPreamble();
                    str7 = str6;
                    String str25 = str5;
                    boolean z12 = zIsAttribute;
                    str8 = str2;
                    str9 = "s";
                    emitGetTarget(str7, str25, z12, Complex.DEFAULT_SUFFIX, 4, str4);
                    str5 = str25;
                    z7 = z12;
                    emit("return " + printJGetValue(i6, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType()) + str22);
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str7 = str6;
                    z7 = zIsAttribute;
                    str9 = "s";
                    str8 = str2;
                }
                if (z6) {
                    str10 = str3;
                    str11 = r1;
                } else {
                    str10 = str3;
                    printListGetterImpl(string, javaPropertyName, str10, false, true);
                    str11 = string;
                }
                if (!z6 && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.XGET_ARRAY))) {
                    printJavaDoc("Gets (as xml) array of all " + str11 + str9);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit(androidx.collection.a.p(str23, str10, "[] xget", strN, "() {"));
                    startBlock();
                    emit("return xgetArray(" + str7 + ", " + str10 + "[]::new);");
                    endBlock();
                }
                if (z6 && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.XGET_IDX))) {
                    printJavaDoc("Gets (as xml) ith " + str11);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit(androidx.collection.a.p(str23, str10, str21, strN, "(int i) {"));
                    startBlock();
                    emitImplementationPreamble();
                    str12 = str5;
                    str13 = str7;
                    str14 = str10;
                    z8 = z7;
                    emitGetTarget(str13, str12, z8, Complex.DEFAULT_SUFFIX, 4, str14);
                    emit(str8);
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str12 = str5;
                    str13 = str7;
                    str14 = str10;
                    z8 = z7;
                }
                if (z11 && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.IS_NIL_IDX))) {
                    printJavaDoc("Tests for nil ith " + str11);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit(str20 + strN + r3);
                    startBlock();
                    emitImplementationPreamble();
                    emitGetTarget(str13, str12, z8, Complex.DEFAULT_SUFFIX, 4, str14);
                    emit("return target.isNil();");
                    emitImplementationPostamble();
                    endBlock();
                }
                if (compilePartialMethod != null || compilePartialMethod.contains(XmlOptions.BeanMethod.SIZE_OF_ARRAY)) {
                    printJavaDoc("Returns number of " + str11);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit("public int sizeOf" + strN + "() {");
                    startBlock();
                    emitImplementationPreamble();
                    emit("return get_store().count_elements(" + str13 + ");");
                    emitImplementationPostamble();
                    endBlock();
                }
                return;
            }
        }
        compilePartialMethod = compilePartialMethod;
        str = " get";
        i5 = javaTypeCode;
        str2 = "return target;";
        str3 = strXmlTypeForProperty;
        str21 = str21;
        str4 = str19;
        str5 = str18;
        if (schemaProperty.extendsJavaOption()) {
            StringBuilder sb7 = new StringBuilder();
            if (zExtendsJavaArray) {
                str15 = "True if has at least one ";
            } else {
                str15 = "True if has ";
            }
            sb7.append(str15);
            sb7.append(string);
            printJavaDoc(sb7.toString());
            if (!this.opt.isCompileNoAnnotations()) {
                emit("@Override");
            }
            emit("public boolean isSet" + javaPropertyName + "() {");
            startBlock();
            emitImplementationPreamble();
            if (zIsAttribute) {
                emit("return get_store().find_attribute_user(" + str5 + ") != null;");
            } else {
                emit("return get_store().count_elements(" + setIdentifier + ") != 0;");
            }
            emitImplementationPostamble();
            endBlock();
        }
        if (zExtendsJavaArray) {
            strN = androidx.collection.a.n(javaPropertyName, SoapEncSchemaTypeSystem.SOAP_ARRAY);
            if (isJavaPrimitive(i5)) {
                strJavaWrappedType = javaWrappedType(i5);
            } else {
                strJavaWrappedType = strJavaTypeForProperty;
            }
            str6 = setIdentifier;
            String str26 = strJavaWrappedType;
            z6 = z10;
            printListGetterImpl(string, javaPropertyName, str26, z6, false);
            if (compilePartialMethod != null) {
                printJavaDoc("Gets array of all " + string + "s");
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(androidx.collection.a.p(str23, strJavaTypeForProperty, "[] get", strN, "() {"));
                startBlock();
                i6 = i5;
                printJGetArrayValue(i6, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType(), str6);
                endBlock();
            } else {
                printJavaDoc("Gets array of all " + string + "s");
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(androidx.collection.a.p(str23, strJavaTypeForProperty, "[] get", strN, "() {"));
                startBlock();
                i6 = i5;
                printJGetArrayValue(i6, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType(), str6);
                endBlock();
            }
            if (compilePartialMethod != null) {
                printJavaDoc("Gets ith " + string);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(androidx.collection.a.p(str23, strJavaTypeForProperty, str, strN, "(int i) {"));
                startBlock();
                emitImplementationPreamble();
                str7 = str6;
                String str27 = str5;
                boolean z13 = zIsAttribute;
                str8 = str2;
                str9 = "s";
                emitGetTarget(str7, str27, z13, Complex.DEFAULT_SUFFIX, 4, str4);
                str5 = str27;
                z7 = z13;
                emit("return " + printJGetValue(i6, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType()) + str22);
                emitImplementationPostamble();
                endBlock();
            } else {
                printJavaDoc("Gets ith " + string);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(androidx.collection.a.p(str23, strJavaTypeForProperty, str, strN, "(int i) {"));
                startBlock();
                emitImplementationPreamble();
                str7 = str6;
                String str28 = str5;
                boolean z14 = zIsAttribute;
                str8 = str2;
                str9 = "s";
                emitGetTarget(str7, str28, z14, Complex.DEFAULT_SUFFIX, 4, str4);
                str5 = str28;
                z7 = z14;
                emit("return " + printJGetValue(i6, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType()) + str22);
                emitImplementationPostamble();
                endBlock();
            }
            if (z6) {
                str10 = str3;
                printListGetterImpl(string, javaPropertyName, str10, false, true);
                str11 = string;
            } else {
                str10 = str3;
                str11 = r1;
            }
            if (!z6) {
                printJavaDoc("Gets (as xml) array of all " + str11 + str9);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(androidx.collection.a.p(str23, str10, "[] xget", strN, "() {"));
                startBlock();
                emit("return xgetArray(" + str7 + ", " + str10 + "[]::new);");
                endBlock();
            }
            if (z6) {
                str12 = str5;
                str13 = str7;
                str14 = str10;
                z8 = z7;
            } else {
                str12 = str5;
                str13 = str7;
                str14 = str10;
                z8 = z7;
            }
            if (z11) {
                printJavaDoc("Tests for nil ith " + str11);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(str20 + strN + r3);
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str13, str12, z8, Complex.DEFAULT_SUFFIX, 4, str14);
                emit("return target.isNil();");
                emitImplementationPostamble();
                endBlock();
            }
            if (compilePartialMethod != null) {
            }
            printJavaDoc("Returns number of " + str11);
            if (!this.opt.isCompileNoAnnotations()) {
                emit("@Override");
            }
            emit("public int sizeOf" + strN + "() {");
            startBlock();
            emitImplementationPreamble();
            emit("return get_store().count_elements(" + str13 + ");");
            emitImplementationPostamble();
            endBlock();
        }
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printHolder(Writer writer, SchemaTypeSystem schemaTypeSystem, XmlOptions xmlOptions, Repackager repackager) throws IOException {
        this._writer = writer;
        String name = schemaTypeSystem.getName();
        if (repackager != null) {
            name = repackager.repackage(new StringBuffer(name)).toString();
        }
        emit("package " + name + ";");
        emit("");
        emit("import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;");
        emit("");
        emit("public final class TypeSystemHolder extends SchemaTypeSystemImpl {");
        indent();
        emit("public static final TypeSystemHolder typeSystem = new TypeSystemHolder();");
        emit("");
        emit("private TypeSystemHolder() {");
        indent();
        emit("super(TypeSystemHolder.class);");
        outdent();
        emit(VectorFormat.DEFAULT_SUFFIX);
        outdent();
        emit(VectorFormat.DEFAULT_SUFFIX);
    }

    public void printInnerType(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        emit("");
        printInnerTypeJavaDoc(schemaType);
        startInterface(schemaType);
        printStaticTypeDeclaration(schemaType, schemaTypeSystem);
        if (!schemaType.isSimpleType()) {
            if (schemaType.getContentType() == 2 && schemaType.hasStringEnumValues()) {
                printStringEnumeration(schemaType);
            }
            for (SchemaProperty schemaProperty : getDerivedProperties(schemaType)) {
                printPropertyGetters(schemaProperty);
                if (!schemaProperty.isReadOnly()) {
                    printPropertySetters(schemaProperty);
                }
            }
        } else if (schemaType.hasStringEnumValues()) {
            printStringEnumeration(schemaType);
        }
        printNestedInnerTypes(schemaType, schemaTypeSystem);
        endBlock();
    }

    public void printInnerTypeImpl(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem, boolean z6) throws IOException {
        String shortJavaImplName = schemaType.getShortJavaImplName();
        printInnerTypeJavaDoc(schemaType);
        startClass(schemaType, z6);
        printConstructor(schemaType, shortJavaImplName);
        printExtensionImplMethods(schemaType);
        if (!schemaType.isSimpleType()) {
            SchemaProperty[] schemaProperties = getSchemaProperties(schemaType);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            printStaticFields(schemaProperties, map, map2);
            for (SchemaProperty schemaProperty : schemaProperties) {
                printGetterImpls(schemaProperty, map, map2);
                if (!schemaProperty.isReadOnly()) {
                    printSetterImpls(schemaProperty, map, map2, schemaType);
                }
            }
        }
        printNestedTypeImpls(schemaType, schemaTypeSystem);
        endBlock();
    }

    public void printInnerTypeJavaDoc(SchemaType schemaType) throws IOException {
        QName name = schemaType.getName();
        if (name == null) {
            if (schemaType.isDocumentType()) {
                name = schemaType.getDocumentElementName();
            } else if (schemaType.isAttributeType()) {
                name = schemaType.getAttributeTypeAttributeName();
            } else if (schemaType.getContainerField() != null) {
                name = schemaType.getContainerField().getName();
            }
        }
        emit("/**");
        if (this.opt.isCompileAnnotationAsJavadoc() && schemaType.getDocumentation() != null && schemaType.getDocumentation().length() > 0) {
            emit(" *");
            printJavaDocBody(schemaType.getDocumentation());
            emit(" *");
        }
        if (schemaType.isDocumentType()) {
            emit(" * A document containing one " + prettyQName(name) + " element.");
        } else if (schemaType.isAttributeType()) {
            emit(" * A document containing one " + prettyQName(name) + " attribute.");
        } else if (name != null) {
            emit(" * An XML " + prettyQName(name) + Consts.DOT);
        } else {
            emit(" * An anonymous inner XML type.");
        }
        emit(" *");
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            emit(" * This is a complex type.");
        } else if (simpleVariety == 1) {
            emit(" * This is an atomic type that is a restriction of " + getFullJavaName(schemaType) + Consts.DOT);
        } else if (simpleVariety == 2) {
            emit(" * This is a union type. Instances are of one of the following types:");
            for (SchemaType schemaType2 : schemaType.getUnionConstituentTypes()) {
                emit(" *     " + schemaType2.getFullJavaName());
            }
        } else if (simpleVariety == 3) {
            emit(" * This is a list type whose items are " + schemaType.getListItemType().getFullJavaName() + Consts.DOT);
        }
        emit(" */");
    }

    public void printInterfaceMethodDecl(InterfaceExtension.MethodSignature methodSignature) throws IOException {
        StringBuilder sb = new StringBuilder(60);
        sb.append("public ");
        sb.append(methodSignature.getReturnType());
        sb.append(" ");
        sb.append(methodSignature.getName());
        sb.append("(");
        String[] parameterTypes = methodSignature.getParameterTypes();
        String[] parameterNames = methodSignature.getParameterNames();
        for (int i5 = 1; i5 < parameterTypes.length; i5++) {
            if (i5 > 1) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i5]);
            sb.append(" ");
            sb.append(parameterNames[i5]);
        }
        sb.append(")");
        String[] exceptionTypes = methodSignature.getExceptionTypes();
        int i6 = 0;
        while (i6 < exceptionTypes.length) {
            sb.append(i6 == 0 ? " throws " : ", ");
            sb.append(exceptionTypes[i6]);
            i6++;
        }
        sb.append(" {");
        emit(sb.toString());
    }

    public void printInterfaceMethodImpl(String str, InterfaceExtension.MethodSignature methodSignature) throws IOException {
        StringBuilder sb = new StringBuilder(60);
        if (!methodSignature.getReturnType().equals("void")) {
            sb.append("return ");
        }
        sb.append(str);
        sb.append(Consts.DOT);
        sb.append(methodSignature.getName());
        sb.append("(this");
        String[] parameterTypes = methodSignature.getParameterTypes();
        String[] parameterNames = methodSignature.getParameterNames();
        for (int i5 = 1; i5 < parameterTypes.length; i5++) {
            sb.append(", ");
            sb.append(parameterNames[i5]);
        }
        sb.append(");");
        emit(sb.toString());
    }

    public void printJGetArrayValue(int i5, String str, SchemaTypeImpl schemaTypeImpl, String str2) throws IOException {
        String strO;
        switch (i5) {
            case 0:
                strO = AbstractC0157z.o("XmlObjectArray(#ID#, new ", str, "[0]);");
                break;
            case 1:
                strO = "BooleanArray(#ID#);";
                break;
            case 2:
                strO = "FloatArray(#ID#);";
                break;
            case 3:
                strO = "DoubleArray(#ID#);";
                break;
            case 4:
                strO = "ByteArray(#ID#);";
                break;
            case 5:
                strO = "ShortArray(#ID#);";
                break;
            case 6:
                strO = "IntArray(#ID#);";
                break;
            case 7:
                strO = "LongArray(#ID#);";
                break;
            case 8:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getBigDecimalValue, java.math.BigDecimal[]::new);";
                break;
            case 9:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getBigIntegerValue, java.math.BigInteger[]::new);";
                break;
            case 10:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getStringValue, String[]::new);";
                break;
            case 11:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getByteArrayValue, byte[][]::new);";
                break;
            case 12:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getGDateValue, org.apache.xmlbeans.GDate[]::new);";
                break;
            case 13:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getGDurationValue, org.apache.xmlbeans.GDuration[]::new);";
                break;
            case 14:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getDateValue, java.util.Date[]::new);";
                break;
            case 15:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getQNameValue, javax.xml.namespace.QName[]::new);";
                break;
            case 16:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getListValue, java.util.List[]::new);";
                break;
            case 17:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getCalendarValue, java.util.Calendar[]::new);";
                break;
            case 18:
                strO = AbstractC0157z.o("EnumArray(#ID#, ", str, "[]::new);");
                break;
            case 19:
                strO = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getObjectValue, java.lang.Object[]::new);";
                break;
            case 20:
                strO = "ObjectArray(#ID#, e -> " + getUserTypeStaticHandlerMethod(false, schemaTypeImpl) + "(e), " + schemaTypeImpl.getUserTypeName() + "[]::new);";
                break;
            default:
                throw new IllegalStateException();
        }
        emit("return get" + strO.replace("#ID#", str2), XmlOptions.BeanMethod.GET_ARRAY);
    }

    public String printJGetValue(int i5, String str, SchemaTypeImpl schemaTypeImpl) {
        switch (i5) {
            case 0:
                return TypedValues.AttributesType.S_TARGET;
            case 1:
                return "target.getBooleanValue()";
            case 2:
                return "target.getFloatValue()";
            case 3:
                return "target.getDoubleValue()";
            case 4:
                return "target.getByteValue()";
            case 5:
                return "target.getShortValue()";
            case 6:
                return "target.getIntValue()";
            case 7:
                return "target.getLongValue()";
            case 8:
                return "target.getBigDecimalValue()";
            case 9:
                return "target.getBigIntegerValue()";
            case 10:
                return "target.getStringValue()";
            case 11:
                return "target.getByteArrayValue()";
            case 12:
                return "target.getGDateValue()";
            case 13:
                return "target.getGDurationValue()";
            case 14:
                return "target.getDateValue()";
            case 15:
                return "target.getQNameValue()";
            case 16:
                return "target.getListValue()";
            case 17:
                return "target.getCalendarValue()";
            case 18:
                return AbstractC0157z.o("(", str, ")target.getEnumValue()");
            case 19:
                return "target.getObjectValue()";
            case 20:
                return AbstractC0157z.s(new StringBuilder(), getUserTypeStaticHandlerMethod(false, schemaTypeImpl), "(target)");
            default:
                throw new IllegalStateException();
        }
    }

    public void printJSetValue(int i5, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        String strS;
        switch (i5) {
            case 0:
                strS = "target.set(#VARNAME#)";
                break;
            case 1:
                strS = "target.setBooleanValue(#VARNAME#)";
                break;
            case 2:
                strS = "target.setFloatValue(#VARNAME#)";
                break;
            case 3:
                strS = "target.setDoubleValue(#VARNAME#)";
                break;
            case 4:
                strS = "target.setByteValue(#VARNAME#)";
                break;
            case 5:
                strS = "target.setShortValue(#VARNAME#)";
                break;
            case 6:
                strS = "target.setIntValue(#VARNAME#)";
                break;
            case 7:
                strS = "target.setLongValue(#VARNAME#)";
                break;
            case 8:
                strS = "target.setBigDecimalValue(#VARNAME#)";
                break;
            case 9:
                strS = "target.setBigIntegerValue(#VARNAME#)";
                break;
            case 10:
                strS = "target.setStringValue(#VARNAME#)";
                break;
            case 11:
                strS = "target.setByteArrayValue(#VARNAME#)";
                break;
            case 12:
                strS = "target.setGDateValue(#VARNAME#)";
                break;
            case 13:
                strS = "target.setGDurationValue(#VARNAME#)";
                break;
            case 14:
                strS = "target.setDateValue(#VARNAME#)";
                break;
            case 15:
                strS = "target.setQNameValue(#VARNAME#)";
                break;
            case 16:
                strS = "target.setListValue(#VARNAME#)";
                break;
            case 17:
                strS = "target.setCalendarValue(#VARNAME#)";
                break;
            case 18:
                strS = "target.setEnumValue(#VARNAME#)";
                break;
            case 19:
                strS = "target.setObjectValue(#VARNAME#)";
                break;
            case 20:
                strS = AbstractC0157z.s(new StringBuilder(), getUserTypeStaticHandlerMethod(true, schemaTypeImpl), "(#VARNAME#, target)");
                break;
            default:
                throw new IllegalStateException();
        }
        emit(strS.replace("#VARNAME#", str) + ";");
    }

    public void printJavaDoc(String str, XmlOptions.BeanMethod beanMethod) throws IOException {
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        if (compilePartialMethod == null || compilePartialMethod.contains(beanMethod)) {
            printJavaDoc(str);
        }
    }

    public void printJavaDocBody(String str) throws IOException {
        for (String str2 : str.trim().replace("\t", "").replace("*/", "* /").split("[\\n\\r]+")) {
            emit(" * " + str2);
        }
    }

    public void printJavaDocParagraph(String str) throws IOException {
        emit("");
        emit("/**");
        printJavaDocBody(str);
        emit(" */");
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00df  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:66:0x010b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0116  */
    public void printListGetterImpl(String str, String str2, String str3, boolean z6, boolean z7) throws IOException {
        String str4;
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        if (compilePartialMethod != null) {
            if (!compilePartialMethod.contains(z7 ? XmlOptions.BeanMethod.XGET_LIST : XmlOptions.BeanMethod.GET_LIST)) {
                return;
            }
        }
        String strN = androidx.collection.a.n(str2, SoapEncSchemaTypeSystem.SOAP_ARRAY);
        printJavaDoc(androidx.exifinterface.media.a.s(new StringBuilder("Gets "), z7 ? "(as xml) " : "", "a List of ", str, "s"));
        if (!this.opt.isCompileNoAnnotations()) {
            emit("@Override");
        }
        StringBuilder sbY = AbstractC0157z.y("public java.util.List<", str3, "> ");
        sbY.append(z7 ? "xget" : "get");
        sbY.append(str2);
        sbY.append("List() {");
        emit(sbY.toString());
        startBlock();
        emitImplementationPreamble();
        StringBuilder sb = new StringBuilder("return new org.apache.xmlbeans.impl.values.JavaList");
        sb.append((z6 || z7) ? "Xml" : "");
        sb.append("Object<>(");
        emit(sb.toString());
        indent();
        if (compilePartialMethod == null) {
            StringBuilder sb2 = new StringBuilder("this::");
            sb2.append(z7 ? "xget" : "get");
            sb2.append(strN);
            sb2.append(",");
            emit(sb2.toString());
        } else {
            if (compilePartialMethod.contains(z7 ? XmlOptions.BeanMethod.XGET_IDX : XmlOptions.BeanMethod.GET_IDX)) {
                StringBuilder sb3 = new StringBuilder("this::");
                sb3.append(z7 ? "xget" : "get");
                sb3.append(strN);
                sb3.append(",");
                emit(sb3.toString());
            } else {
                emit("null,");
            }
        }
        if (compilePartialMethod == null) {
            StringBuilder sb4 = new StringBuilder("this::");
            if (z7) {
                str4 = "xset";
            } else {
                str4 = "set";
            }
            sb4.append(str4);
            sb4.append(strN);
            sb4.append(",");
            emit(sb4.toString());
        } else {
            if (compilePartialMethod.contains(z7 ? XmlOptions.BeanMethod.XSET_IDX : XmlOptions.BeanMethod.SET_IDX)) {
                StringBuilder sb5 = new StringBuilder("this::");
                if (z7) {
                    str4 = "xset";
                } else {
                    str4 = "set";
                }
                sb5.append(str4);
                sb5.append(strN);
                sb5.append(",");
                emit(sb5.toString());
            } else {
                emit("null,");
            }
        }
        if (compilePartialMethod == null) {
            StringBuilder sb6 = new StringBuilder("this::insert");
            sb6.append((!z6 || z7) ? "New" : "");
            sb6.append(str2);
            sb6.append(",");
            emit(sb6.toString());
        } else {
            if (compilePartialMethod.contains((z6 || z7) ? XmlOptions.BeanMethod.INSERT_NEW_IDX : XmlOptions.BeanMethod.INSERT_IDX)) {
                StringBuilder sb7 = new StringBuilder("this::insert");
                sb7.append((!z6 || z7) ? "New" : "");
                sb7.append(str2);
                sb7.append(",");
                emit(sb7.toString());
            } else {
                emit("null,");
            }
        }
        if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.REMOVE_IDX)) {
            emit("this::remove" + str2 + ",");
        } else {
            emit("null,");
        }
        if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.SIZE_OF_ARRAY)) {
            emit("this::sizeOf" + strN);
        } else {
            emit(AbstractC1127c.NULL);
        }
        outdent();
        emit(");");
        emitImplementationPostamble();
        endBlock();
    }

    public void printNestedInnerTypes(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z6 = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            for (SchemaType schemaType2 : schemaType.getAnonymousTypes()) {
                if (schemaType2.isSkippedAnonymousType()) {
                    printNestedInnerTypes(schemaType2, schemaTypeSystem);
                } else {
                    printInnerType(schemaType2, schemaTypeSystem);
                }
            }
            if (!z6) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }

    public void printNestedTypeImpls(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z6 = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            for (SchemaType schemaType2 : schemaType.getAnonymousTypes()) {
                if (schemaType2.isSkippedAnonymousType()) {
                    printNestedTypeImpls(schemaType2, schemaTypeSystem);
                } else {
                    printInnerTypeImpl(schemaType2, schemaTypeSystem, true);
                }
            }
            if (!z6) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }

    public void printPackage(SchemaType schemaType, boolean z6) throws IOException {
        String fullJavaName = z6 ? schemaType.getFullJavaName() : schemaType.getFullJavaImplName();
        int iLastIndexOf = fullJavaName.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return;
        }
        emit("package " + fullJavaName.substring(0, iLastIndexOf) + ";");
    }

    public void printPropertyGetters(SchemaProperty schemaProperty) throws IOException {
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        boolean z6 = schemaProperty.hasNillable() != 0;
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        String documentation = schemaProperty.getDocumentation();
        StringBuilder sb = new StringBuilder("\"");
        sb.append(schemaProperty.getName().getLocalPart());
        sb.append("\"");
        sb.append(schemaProperty.isAttribute() ? " attribute" : " element");
        String string = sb.toString();
        boolean z7 = javaTypeCode == 0;
        if (schemaProperty.extendsJavaSingleton()) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                printJavaDoc(AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Gets first " : "Gets the ", string), XmlOptions.BeanMethod.GET);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit(androidx.exifinterface.media.a.A(strJavaTypeForProperty, " get", javaPropertyName, "();"), XmlOptions.BeanMethod.GET);
            if (!z7) {
                String strS = AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Gets (as xml) first " : "Gets (as xml) the ", string);
                XmlOptions.BeanMethod beanMethod = XmlOptions.BeanMethod.XGET;
                printJavaDoc(strS, beanMethod);
                emit(strXmlTypeForProperty + " xget" + javaPropertyName + "();", beanMethod);
            }
            if (z6) {
                String strS2 = AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Tests for nil first " : "Tests for nil ", string);
                XmlOptions.BeanMethod beanMethod2 = XmlOptions.BeanMethod.IS_NIL;
                printJavaDoc(strS2, beanMethod2);
                emit("boolean isNil" + javaPropertyName + "();", beanMethod2);
            }
        }
        if (schemaProperty.extendsJavaOption()) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                printJavaDoc(AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "True if has at least one " : "True if has ", string), XmlOptions.BeanMethod.IS_SET);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit(AbstractC0157z.o("boolean isSet", javaPropertyName, "();"), XmlOptions.BeanMethod.IS_SET);
        }
        if (zExtendsJavaArray) {
            if (this.opt.isCompileAnnotationAsJavadoc() && documentation != null && documentation.length() > 0) {
                printJavaDocParagraph(documentation);
            }
            String strN = androidx.collection.a.n(javaPropertyName, SoapEncSchemaTypeSystem.SOAP_ARRAY);
            String strJavaWrappedType = isJavaPrimitive(javaTypeCode) ? javaWrappedType(javaTypeCode) : strJavaTypeForProperty;
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                printJavaDoc(AbstractC0157z.o("Gets a List of ", string, "s"), XmlOptions.BeanMethod.GET_LIST);
            } else {
                printJavaDocParagraph(documentation);
            }
            boolean z8 = z7;
            emit(androidx.collection.a.p("java.util.List<", strJavaWrappedType, "> get", javaPropertyName, "List();"), XmlOptions.BeanMethod.GET_LIST);
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                printJavaDoc(AbstractC0157z.o("Gets array of all ", string, "s"), XmlOptions.BeanMethod.GET_ARRAY);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit(androidx.exifinterface.media.a.A(strJavaTypeForProperty, "[] get", strN, "();"), XmlOptions.BeanMethod.GET_ARRAY);
            XmlOptions.BeanMethod beanMethod3 = XmlOptions.BeanMethod.GET_IDX;
            printJavaDoc("Gets ith " + string, beanMethod3);
            emit(strJavaTypeForProperty + " get" + strN + "(int i);", beanMethod3);
            if (!z8) {
                String strO = AbstractC0157z.o("Gets (as xml) a List of ", string, "s");
                XmlOptions.BeanMethod beanMethod4 = XmlOptions.BeanMethod.XGET_LIST;
                printJavaDoc(strO, beanMethod4);
                StringBuilder sb2 = new StringBuilder("java.util.List<");
                sb2.append(strXmlTypeForProperty);
                emit(androidx.exifinterface.media.a.r(sb2, "> xget", javaPropertyName, "List();"), beanMethod4);
                XmlOptions.BeanMethod beanMethod5 = XmlOptions.BeanMethod.XGET_ARRAY;
                printJavaDoc("Gets (as xml) array of all " + string + "s", beanMethod5);
                emit(strXmlTypeForProperty + "[] xget" + strN + "();", beanMethod5);
                String strN2 = AbstractC0157z.n("Gets (as xml) ith ", string);
                XmlOptions.BeanMethod beanMethod6 = XmlOptions.BeanMethod.XGET_IDX;
                printJavaDoc(strN2, beanMethod6);
                emit(strXmlTypeForProperty + " xget" + strN + "(int i);", beanMethod6);
            }
            if (z6) {
                String strN3 = AbstractC0157z.n("Tests for nil ith ", string);
                XmlOptions.BeanMethod beanMethod7 = XmlOptions.BeanMethod.IS_NIL_IDX;
                printJavaDoc(strN3, beanMethod7);
                emit("boolean isNil" + strN + "(int i);", beanMethod7);
            }
            String strN4 = AbstractC0157z.n("Returns number of ", string);
            XmlOptions.BeanMethod beanMethod8 = XmlOptions.BeanMethod.SIZE_OF_ARRAY;
            printJavaDoc(strN4, beanMethod8);
            emit("int sizeOf" + strN + "();", beanMethod8);
        }
    }

    public void printPropertySetters(SchemaProperty schemaProperty) throws IOException {
        String str;
        String str2;
        QName name = schemaProperty.getName();
        boolean zIsAttribute = schemaProperty.isAttribute();
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        boolean z6 = schemaProperty.hasNillable() != 0;
        boolean zExtendsJavaOption = schemaProperty.extendsJavaOption();
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        boolean zExtendsJavaSingleton = schemaProperty.extendsJavaSingleton();
        String documentation = schemaProperty.getDocumentation();
        String strNonJavaKeyword = NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(javaPropertyName));
        if (strNonJavaKeyword.equals(Complex.DEFAULT_SUFFIX)) {
            strNonJavaKeyword = "iValue";
        }
        boolean z7 = javaTypeCode == 0;
        StringBuilder sb = new StringBuilder("\"");
        sb.append(name.getLocalPart());
        sb.append("\"");
        sb.append(zIsAttribute ? " attribute" : " element");
        String string = sb.toString();
        String str3 = " addNew";
        boolean z8 = z6;
        boolean z9 = z7;
        if (zExtendsJavaSingleton) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                printJavaDoc(AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Sets first " : "Sets the ", string), XmlOptions.BeanMethod.SET);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit(AbstractC0157z.s(androidx.collection.a.u("void set", javaPropertyName, "(", strJavaTypeForProperty, " "), strNonJavaKeyword, ");"), XmlOptions.BeanMethod.SET);
            if (!z9) {
                String strS = AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Sets (as xml) first " : "Sets (as xml) the ", string);
                XmlOptions.BeanMethod beanMethod = XmlOptions.BeanMethod.XSET;
                printJavaDoc(strS, beanMethod);
                StringBuilder sb2 = new StringBuilder("void xset");
                sb2.append(javaPropertyName);
                androidx.collection.a.y(sb2, "(", strXmlTypeForProperty, " ", strNonJavaKeyword);
                sb2.append(");");
                emit(sb2.toString(), beanMethod);
            }
            if (z9 && !zExtendsJavaArray) {
                String strN = AbstractC0157z.n("Appends and returns a new empty ", string);
                XmlOptions.BeanMethod beanMethod2 = XmlOptions.BeanMethod.ADD_NEW;
                printJavaDoc(strN, beanMethod2);
                emit(strXmlTypeForProperty + " addNew" + javaPropertyName + "();", beanMethod2);
            }
            if (z8) {
                String strS2 = AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Nils the first " : "Nils the ", string);
                XmlOptions.BeanMethod beanMethod3 = XmlOptions.BeanMethod.SET_NIL;
                printJavaDoc(strS2, beanMethod3);
                emit("void setNil" + javaPropertyName + "();", beanMethod3);
            }
        } else {
            documentation = documentation;
        }
        if (zExtendsJavaOption) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                str = documentation;
                printJavaDoc(AbstractC0157z.s(new StringBuilder(), zExtendsJavaArray ? "Removes first " : "Unsets the ", string), XmlOptions.BeanMethod.UNSET);
            } else {
                str = documentation;
                printJavaDocParagraph(str);
            }
            emit(AbstractC0157z.o("void unset", javaPropertyName, "();"), XmlOptions.BeanMethod.UNSET);
        } else {
            str3 = " addNew";
            str = documentation;
        }
        if (zExtendsJavaArray) {
            String strN2 = androidx.collection.a.n(javaPropertyName, SoapEncSchemaTypeSystem.SOAP_ARRAY);
            if (!this.opt.isCompileAnnotationAsJavadoc() || str == null || str.length() <= 0) {
                printJavaDoc(AbstractC0157z.n("Sets array of all ", string), XmlOptions.BeanMethod.SET_ARRAY);
            } else {
                printJavaDocParagraph(str);
            }
            emit(AbstractC0157z.s(androidx.collection.a.u("void set", strN2, "(", strJavaTypeForProperty, "[] "), strNonJavaKeyword, "Array);"), XmlOptions.BeanMethod.SET_ARRAY);
            if (!this.opt.isCompileAnnotationAsJavadoc() || str == null || str.length() <= 0) {
                printJavaDoc(AbstractC0157z.n("Sets ith ", string), XmlOptions.BeanMethod.SET_IDX);
            } else {
                printJavaDocParagraph(str);
            }
            emit(AbstractC0157z.s(androidx.collection.a.u("void set", strN2, "(int i, ", strJavaTypeForProperty, " "), strNonJavaKeyword, ");"), XmlOptions.BeanMethod.SET_IDX);
            if (!z9) {
                String strN3 = AbstractC0157z.n("Sets (as xml) array of all ", string);
                XmlOptions.BeanMethod beanMethod4 = XmlOptions.BeanMethod.XSET_ARRAY;
                printJavaDoc(strN3, beanMethod4);
                StringBuilder sb3 = new StringBuilder("void xset");
                sb3.append(strN2);
                androidx.collection.a.y(sb3, "(", strXmlTypeForProperty, "[] ", strNonJavaKeyword);
                sb3.append("Array);");
                emit(sb3.toString(), beanMethod4);
                XmlOptions.BeanMethod beanMethod5 = XmlOptions.BeanMethod.XSET_IDX;
                printJavaDoc("Sets (as xml) ith " + string, beanMethod5);
                StringBuilder sb4 = new StringBuilder("void xset");
                sb4.append(strN2);
                androidx.collection.a.y(sb4, "(int i, ", strXmlTypeForProperty, " ", strNonJavaKeyword);
                sb4.append(");");
                emit(sb4.toString(), beanMethod5);
            }
            if (z8) {
                String strN4 = AbstractC0157z.n("Nils the ith ", string);
                XmlOptions.BeanMethod beanMethod6 = XmlOptions.BeanMethod.SET_NIL_IDX;
                printJavaDoc(strN4, beanMethod6);
                emit("void setNil" + strN2 + "(int i);", beanMethod6);
            }
            if (z9) {
                str2 = javaPropertyName;
            } else {
                String strN5 = AbstractC0157z.n("Inserts the value as the ith ", string);
                XmlOptions.BeanMethod beanMethod7 = XmlOptions.BeanMethod.INSERT_IDX;
                printJavaDoc(strN5, beanMethod7);
                StringBuilder sb5 = new StringBuilder("void insert");
                str2 = javaPropertyName;
                sb5.append(str2);
                androidx.collection.a.y(sb5, "(int i, ", strJavaTypeForProperty, " ", strNonJavaKeyword);
                sb5.append(");");
                emit(sb5.toString(), beanMethod7);
                XmlOptions.BeanMethod beanMethod8 = XmlOptions.BeanMethod.ADD;
                printJavaDoc("Appends the value as the last " + string, beanMethod8);
                StringBuilder sb6 = new StringBuilder("void add");
                sb6.append(str2);
                androidx.collection.a.y(sb6, "(", strJavaTypeForProperty, " ", strNonJavaKeyword);
                sb6.append(");");
                emit(sb6.toString(), beanMethod8);
            }
            String strN6 = AbstractC0157z.n("Inserts and returns a new empty value (as xml) as the ith ", string);
            XmlOptions.BeanMethod beanMethod9 = XmlOptions.BeanMethod.INSERT_NEW_IDX;
            printJavaDoc(strN6, beanMethod9);
            emit(strXmlTypeForProperty + " insertNew" + str2 + "(int i);", beanMethod9);
            String strN7 = AbstractC0157z.n("Appends and returns a new empty value (as xml) as the last ", string);
            XmlOptions.BeanMethod beanMethod10 = XmlOptions.BeanMethod.ADD_NEW;
            printJavaDoc(strN7, beanMethod10);
            emit(strXmlTypeForProperty + str3 + str2 + "();", beanMethod10);
            String strN8 = AbstractC0157z.n("Removes the ith ", string);
            XmlOptions.BeanMethod beanMethod11 = XmlOptions.BeanMethod.REMOVE_IDX;
            printJavaDoc(strN8, beanMethod11);
            emit("void remove" + str2 + "(int i);", beanMethod11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:217:0x0726  */
    /* JADX WARN: Code duplicated, block: B:227:0x0791  */
    /* JADX WARN: Code duplicated, block: B:237:0x081d  */
    /* JADX WARN: Code duplicated, block: B:248:0x0896  */
    /* JADX WARN: Code duplicated, block: B:262:0x0966  */
    /* JADX WARN: Code duplicated, block: B:273:0x09ec  */
    /* JADX WARN: Code duplicated, block: B:275:0x0a05  */
    /* JADX WARN: Code duplicated, block: B:278:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:279:0x0a49  */
    /* JADX WARN: Code duplicated, block: B:284:0x0a7f  */
    /* JADX WARN: Code duplicated, block: B:286:0x0a98  */
    /* JADX WARN: Code duplicated, block: B:293:0x0af4  */
    /* JADX WARN: Instruction removed from duplicated block: B:273:0x09ec, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:284:0x0a7f, please report this as an issue */
    public void printSetterImpls(SchemaProperty schemaProperty, Map<QName, Integer> map, Map<QName, Integer> map2, SchemaType schemaType) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z6;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        SchemaType schemaType2;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        Set<XmlOptions.BeanMethod> set;
        String str19;
        String str20;
        String str21;
        String str22;
        int i5;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        SchemaType schemaType3;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        SchemaType schemaType4;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        SchemaTypeCodePrinter schemaTypeCodePrinter = this;
        QName name = schemaProperty.getName();
        String identifier = schemaTypeCodePrinter.getIdentifier(map, name);
        String setIdentifier = schemaTypeCodePrinter.getSetIdentifier(map, name, map2);
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        boolean z7 = schemaProperty.hasNillable() != 0;
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        boolean zIsAttribute = schemaProperty.isAttribute();
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        XmlOptions xmlOptions = schemaTypeCodePrinter.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        String strNonExtraKeyword = NameUtil.nonExtraKeyword(NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(javaPropertyName)));
        boolean z8 = javaTypeCode == 0;
        boolean z9 = javaTypeCode == 19;
        boolean zEquals = Objects.equals(identifier, setIdentifier);
        String str50 = (xmlTypeForPropertyIsUnion(schemaProperty) || !z8) ? "org.apache.xmlbeans.SimpleValue" : strXmlTypeForProperty;
        StringBuilder sb = new StringBuilder("\"");
        sb.append(name.getLocalPart());
        sb.append("\"");
        sb.append(zIsAttribute ? " attribute" : " element");
        String string = sb.toString();
        String str51 = "public void xset";
        String str52 = " target = null;";
        String str53 = "() {";
        String str54 = ") {";
        boolean z10 = z7;
        String str55 = " ";
        String str56 = ", ";
        if (schemaProperty.extendsJavaSingleton()) {
            if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.SET)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(zExtendsJavaArray ? "Sets first " : "Sets the ");
                sb2.append(string);
                schemaTypeCodePrinter.printJavaDoc(sb2.toString());
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit("@Override");
                }
                StringBuilder sbU = androidx.collection.a.u("public void set", javaPropertyName, "(", strJavaTypeForProperty, " ");
                sbU.append(strNonExtraKeyword);
                sbU.append(") {");
                schemaTypeCodePrinter.emit(sbU.toString());
                schemaTypeCodePrinter.startBlock();
                if (z8 && zEquals && !zIsAttribute) {
                    String str57 = zExtendsJavaArray ? "0" : StructuredDataId.RESERVED;
                    str2 = "public void set";
                    str8 = strNonExtraKeyword;
                    str11 = string;
                    identifier = identifier;
                    schemaTypeCodePrinter.emitPre(schemaType, 1, identifier, false, str57);
                    schemaTypeCodePrinter.emit(androidx.collection.a.p("generatedSetterHelperImpl(", str8, ", ", setIdentifier, ", 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);"));
                    schemaTypeCodePrinter.emitPost(schemaType, 1, identifier, false, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    schemaTypeCodePrinter = this;
                    z6 = zIsAttribute;
                } else {
                    str2 = "public void set";
                    str8 = strNonExtraKeyword;
                    str11 = string;
                    emitImplementationPreamble();
                    emitPre(schemaType, 1, identifier, zIsAttribute, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    schemaTypeCodePrinter = this;
                    schemaTypeCodePrinter.emitGetTarget(setIdentifier, identifier, zIsAttribute, "0", 3, str50);
                    z6 = zIsAttribute;
                    setIdentifier = setIdentifier;
                    identifier = identifier;
                    schemaTypeCodePrinter.printJSetValue(javaTypeCode, str8, (SchemaTypeImpl) schemaProperty.getType());
                    schemaTypeCodePrinter.emitPost(schemaType, 1, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                }
                schemaTypeCodePrinter.endBlock();
            } else {
                str2 = "public void set";
                str54 = ") {";
                strJavaTypeForProperty = strJavaTypeForProperty;
                str51 = str51;
                str52 = str52;
                str53 = str53;
                z6 = zIsAttribute;
                str8 = strNonExtraKeyword;
                str11 = string;
            }
            if (z8 || !(compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.XSET))) {
                identifier = identifier;
                str9 = str54;
                schemaType4 = schemaType;
                str45 = setIdentifier;
                str46 = strXmlTypeForProperty;
                str7 = ");";
                str4 = str51;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(zExtendsJavaArray ? "Sets (as xml) first " : "Sets (as xml) the ");
                sb3.append(str11);
                schemaTypeCodePrinter.printJavaDoc(sb3.toString());
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit("@Override");
                }
                String str58 = str51;
                StringBuilder sbU2 = androidx.collection.a.u(str58, javaPropertyName, "(", strXmlTypeForProperty, " ");
                sbU2.append(str8);
                String str59 = str54;
                sbU2.append(str59);
                schemaTypeCodePrinter.emit(sbU2.toString());
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                str4 = str58;
                schemaTypeCodePrinter.emitPre(schemaType, 1, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                String str60 = identifier;
                boolean z11 = z6;
                String str61 = setIdentifier;
                schemaTypeCodePrinter = this;
                schemaTypeCodePrinter.emitGetTarget(str61, str60, z11, "0", 3, strXmlTypeForProperty);
                z6 = z11;
                identifier = str60;
                schemaTypeCodePrinter.emit("target.set(" + str8 + ");");
                schemaType4 = schemaType;
                str45 = str61;
                str9 = str59;
                str46 = strXmlTypeForProperty;
                str7 = ");";
                schemaTypeCodePrinter.emitPost(schemaType4, 1, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            }
            if (z8 && !zExtendsJavaArray && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.ADD_NEW))) {
                schemaTypeCodePrinter.printJavaDoc("Appends and returns a new empty " + str11);
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit("@Override");
                }
                str47 = "public ";
                str = str53;
                schemaTypeCodePrinter.emit(androidx.collection.a.p(str47, str46, " addNew", javaPropertyName, str));
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str46);
                str49 = str52;
                sb4.append(str49);
                schemaTypeCodePrinter.emit(sb4.toString());
                schemaTypeCodePrinter.emitPre(schemaType4, 2, identifier, z6);
                schemaTypeCodePrinter.emitAddTarget(identifier, z6, str46);
                schemaTypeCodePrinter.emitPost(schemaType4, 2, identifier, z6);
                str48 = "return target;";
                schemaTypeCodePrinter.emit(str48);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            } else {
                str47 = "public ";
                str48 = r5;
                str49 = str52;
                str = str53;
            }
            if (z10 && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.SET_NIL))) {
                StringBuilder sb5 = new StringBuilder();
                String str62 = str48;
                sb5.append(zExtendsJavaArray ? "Nils the first " : "Nils the ");
                sb5.append(str11);
                schemaTypeCodePrinter.printJavaDoc(sb5.toString());
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit("@Override");
                }
                schemaTypeCodePrinter.emit("public void setNil" + javaPropertyName + str);
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                str6 = str47;
                str3 = str62;
                schemaTypeCodePrinter.emitPre(schemaType, 1, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                String str63 = identifier;
                boolean z12 = z6;
                String str64 = str45;
                schemaTypeCodePrinter = this;
                schemaTypeCodePrinter.emitGetTarget(str64, str63, z12, "0", 3, str46);
                z6 = z12;
                String str65 = str46;
                setIdentifier = str64;
                identifier = str63;
                schemaTypeCodePrinter.emit("target.setNil();");
                str5 = str49;
                str10 = str65;
                schemaTypeCodePrinter.emitPost(schemaType, 1, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            } else {
                str3 = str48;
                str6 = str47;
                str5 = str49;
                str10 = str46;
                setIdentifier = str45;
            }
        } else {
            str55 = " ";
            str = str53;
            str2 = "public void set";
            str3 = "return target;";
            strJavaTypeForProperty = strJavaTypeForProperty;
            javaTypeCode = javaTypeCode;
            str4 = str51;
            str5 = str52;
            z6 = zIsAttribute;
            str6 = "public ";
            str7 = ");";
            str8 = strNonExtraKeyword;
            str9 = ") {";
            str56 = ", ";
            str10 = strXmlTypeForProperty;
            str11 = string;
        }
        if (schemaProperty.extendsJavaOption() && (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.UNSET))) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(zExtendsJavaArray ? "Removes first " : "Unsets the ");
            sb6.append(str11);
            schemaTypeCodePrinter.printJavaDoc(sb6.toString());
            if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                schemaTypeCodePrinter.emit("@Override");
            }
            schemaTypeCodePrinter.emit("public void unset" + javaPropertyName + str);
            schemaTypeCodePrinter.startBlock();
            schemaTypeCodePrinter.emitImplementationPreamble();
            schemaTypeCodePrinter.emitPre(schemaType, 3, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
            if (z6) {
                schemaTypeCodePrinter.emit("get_store().remove_attribute(" + identifier + str7);
            } else {
                schemaTypeCodePrinter.emit("get_store().remove_element(" + setIdentifier + ", 0);");
            }
            schemaType2 = schemaType;
            schemaTypeCodePrinter.emitPost(schemaType2, 3, identifier, z6, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
            schemaTypeCodePrinter.emitImplementationPostamble();
            schemaTypeCodePrinter.endBlock();
        } else {
            schemaType2 = schemaType;
        }
        if (zExtendsJavaArray) {
            String strN = androidx.collection.a.n(javaPropertyName, SoapEncSchemaTypeSystem.SOAP_ARRAY);
            String str66 = str;
            String str67 = "Array, ";
            if (compilePartialMethod != null && !compilePartialMethod.contains(XmlOptions.BeanMethod.SET_ARRAY)) {
                str12 = strN;
                str18 = "arraySetterHelper(";
                str17 = "@Override";
                str13 = str56;
                str14 = strJavaTypeForProperty;
                str15 = str2;
            } else if (z8) {
                schemaTypeCodePrinter.printJavaDoc("Sets array of all " + str11 + "  WARNING: This method is not atomicaly synchronized.");
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit("@Override");
                }
                str17 = "@Override";
                str14 = strJavaTypeForProperty;
                str15 = str2;
                StringBuilder sbU3 = androidx.collection.a.u(str15, strN, "(", str14, "[] ");
                sbU3.append(str8);
                str12 = strN;
                sbU3.append("Array) {");
                schemaTypeCodePrinter.emit(sbU3.toString());
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emit("check_orphaned();");
                schemaTypeCodePrinter.emitPre(schemaType2, 1, identifier, z6);
                if (!z9) {
                    str13 = str56;
                    if (zEquals) {
                        schemaTypeCodePrinter.emit(androidx.collection.a.p("arraySetterHelper(", str8, "Array, ", identifier, str7));
                    } else {
                        StringBuilder sbU4 = androidx.collection.a.u("arraySetterHelper(", str8, "Array, ", identifier, str13);
                        sbU4.append(setIdentifier);
                        sbU4.append(str7);
                        schemaTypeCodePrinter.emit(sbU4.toString());
                    }
                } else if (zEquals) {
                    schemaTypeCodePrinter.emit(androidx.collection.a.p("unionArraySetterHelper(", str8, "Array, ", identifier, str7));
                    str13 = str56;
                } else {
                    str13 = str56;
                    StringBuilder sbU5 = androidx.collection.a.u("unionArraySetterHelper(", str8, "Array, ", identifier, str13);
                    sbU5.append(setIdentifier);
                    sbU5.append(str7);
                    schemaTypeCodePrinter.emit(sbU5.toString());
                }
                schemaTypeCodePrinter.emitPost(schemaType2, 1, identifier, z6);
                schemaTypeCodePrinter.endBlock();
                str18 = "arraySetterHelper(";
            } else {
                str12 = strN;
                str13 = str56;
                str14 = strJavaTypeForProperty;
                str15 = str2;
                schemaTypeCodePrinter.printJavaDoc("Sets array of all " + str11);
                if (schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    str16 = "@Override";
                } else {
                    str16 = "@Override";
                    schemaTypeCodePrinter.emit(str16);
                }
                str17 = str16;
                StringBuilder sbU6 = androidx.collection.a.u(str15, str12, "(", str14, "[] ");
                sbU6.append(str8);
                sbU6.append("Array) {");
                schemaTypeCodePrinter.emit(sbU6.toString());
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                schemaTypeCodePrinter.emitPre(schemaType2, 1, identifier, z6);
                if (!z9) {
                    if (schemaProperty.getJavaTypeCode() == 20) {
                        if (zEquals) {
                            schemaTypeCodePrinter.emit(androidx.collection.a.p("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(", str8, "Array.length, ", identifier, str7));
                            schemaTypeCodePrinter.emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
                            schemaTypeCodePrinter.emit(androidx.exifinterface.media.a.s(new StringBuilder("    "), schemaTypeCodePrinter.getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl) schemaProperty.getType()), "(", str8, "Array[i], dests[i]);"));
                            schemaTypeCodePrinter.emit(VectorFormat.DEFAULT_SUFFIX);
                        } else {
                            StringBuilder sbU7 = androidx.collection.a.u("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(", str8, "Array.length, ", identifier, str13);
                            sbU7.append(setIdentifier);
                            sbU7.append(str7);
                            schemaTypeCodePrinter.emit(sbU7.toString());
                            schemaTypeCodePrinter.emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
                            schemaTypeCodePrinter.emit(androidx.exifinterface.media.a.s(new StringBuilder("    "), schemaTypeCodePrinter.getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl) schemaProperty.getType()), "(", str8, "Array[i], dests[i]);"));
                            schemaTypeCodePrinter.emit(VectorFormat.DEFAULT_SUFFIX);
                        }
                    } else if (zEquals) {
                        str18 = "arraySetterHelper(";
                        schemaTypeCodePrinter.emit(androidx.collection.a.p(str18, str8, "Array, ", identifier, str7));
                    } else {
                        str18 = "arraySetterHelper(";
                        StringBuilder sbU8 = androidx.collection.a.u(str18, str8, "Array, ", identifier, str13);
                        sbU8.append(setIdentifier);
                        sbU8.append(str7);
                        schemaTypeCodePrinter.emit(sbU8.toString());
                    }
                    schemaTypeCodePrinter.emitPost(schemaType2, 1, identifier, z6);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                } else if (zEquals) {
                    schemaTypeCodePrinter.emit(androidx.collection.a.p("unionArraySetterHelper(", str8, "Array, ", identifier, str7));
                } else {
                    StringBuilder sbU9 = androidx.collection.a.u("unionArraySetterHelper(", str8, "Array, ", identifier, str13);
                    sbU9.append(setIdentifier);
                    sbU9.append(str7);
                    schemaTypeCodePrinter.emit(sbU9.toString());
                }
                str18 = "arraySetterHelper(";
                schemaTypeCodePrinter.emitPost(schemaType2, 1, identifier, z6);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            }
            if (compilePartialMethod != 0) {
                set = compilePartialMethod;
                if (!set.contains(XmlOptions.BeanMethod.SET_IDX)) {
                    i5 = javaTypeCode;
                    str67 = "Array, ";
                    str13 = str13;
                    str14 = str14;
                    str50 = str50;
                    str22 = str55;
                    str20 = str17;
                    str21 = str12;
                }
                if (z8 && (set == null || set.contains(XmlOptions.BeanMethod.XSET_ARRAY))) {
                    schemaTypeCodePrinter.printJavaDoc("Sets (as xml) array of all " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str20);
                    }
                    str23 = str10;
                    str24 = str4;
                    StringBuilder sbU10 = androidx.collection.a.u(str24, str21, "(", str23, "[]");
                    sbU10.append(str8);
                    sbU10.append("Array) {");
                    schemaTypeCodePrinter.emit(sbU10.toString());
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    schemaTypeCodePrinter.emitPre(schemaType2, 1, identifier, z6);
                    schemaTypeCodePrinter.emit(androidx.collection.a.p(str18, str8, str67, identifier, str7));
                    schemaTypeCodePrinter.emitPost(schemaType2, 1, identifier, z6);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                } else {
                    str23 = str10;
                    str24 = str4;
                }
                if (z8 && (set == null || set.contains(XmlOptions.BeanMethod.XSET_IDX))) {
                    schemaTypeCodePrinter.printJavaDoc("Sets (as xml) ith " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str20);
                    }
                    str28 = str22;
                    StringBuilder sbU11 = androidx.collection.a.u(str24, str21, "(int i, ", str23, str28);
                    sbU11.append(str8);
                    str27 = str9;
                    sbU11.append(str27);
                    schemaTypeCodePrinter.emit(sbU11.toString());
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    str26 = str23;
                    schemaTypeCodePrinter.emitPre(schemaType2, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                    String str68 = setIdentifier;
                    String str69 = identifier;
                    boolean z13 = z6;
                    schemaTypeCodePrinter = this;
                    schemaTypeCodePrinter.emitGetTarget(str68, str69, z13, Complex.DEFAULT_SUFFIX, 4, str26);
                    z6 = z13;
                    str25 = str68;
                    identifier = str69;
                    schemaTypeCodePrinter.emit("target.set(" + str8 + str7);
                    schemaTypeCodePrinter.emitPost(schemaType, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                } else {
                    str25 = setIdentifier;
                    str26 = str23;
                    str27 = str9;
                    str28 = str22;
                }
                if (z10 || !(set == null || set.contains(XmlOptions.BeanMethod.SET_NIL_IDX))) {
                    str29 = str26;
                } else {
                    schemaTypeCodePrinter.printJavaDoc("Nils the ith " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str20);
                    }
                    schemaTypeCodePrinter.emit("public void setNil" + str21 + "(int i) {");
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    schemaTypeCodePrinter.emitPre(schemaType, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                    String str70 = identifier;
                    boolean z14 = z6;
                    String str71 = str25;
                    String str72 = str26;
                    schemaTypeCodePrinter = this;
                    schemaTypeCodePrinter.emitGetTarget(str71, str70, z14, Complex.DEFAULT_SUFFIX, 4, str72);
                    z6 = z14;
                    str29 = str72;
                    str25 = str71;
                    identifier = str70;
                    schemaTypeCodePrinter.emit("target.setNil();");
                    schemaTypeCodePrinter.emitPost(schemaType, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                }
                if (z8 && (set == null || set.contains(XmlOptions.BeanMethod.INSERT_IDX))) {
                    schemaTypeCodePrinter.printJavaDoc("Inserts the value as the ith " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str20);
                    }
                    str32 = javaPropertyName;
                    str34 = str14;
                    StringBuilder sbU12 = androidx.collection.a.u("public void insert", str32, "(int i, ", str34, str28);
                    sbU12.append(str8);
                    sbU12.append(str27);
                    schemaTypeCodePrinter.emit(sbU12.toString());
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    schemaTypeCodePrinter.emitPre(schemaType, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                    schemaTypeCodePrinter.emit(str50 + " target =");
                    schemaTypeCodePrinter.indent();
                    if (zEquals) {
                        str43 = "(";
                        schemaTypeCodePrinter.emit(androidx.collection.a.p(str43, str50, ")get_store().insert_element_user(", identifier, ", i);"));
                        str44 = str13;
                    } else {
                        str43 = r8;
                        str44 = str13;
                        StringBuilder sbU13 = androidx.collection.a.u(str43, str50, ")get_store().insert_element_user(", str25, str44);
                        sbU13.append(identifier);
                        sbU13.append(", i);");
                        schemaTypeCodePrinter.emit(sbU13.toString());
                    }
                    schemaTypeCodePrinter.outdent();
                    schemaTypeCodePrinter.printJSetValue(i5, str8, (SchemaTypeImpl) schemaProperty.getType());
                    str30 = ", i);";
                    str33 = str44;
                    str31 = str43;
                    schemaType3 = schemaType;
                    schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                } else {
                    str30 = ", i);";
                    str31 = r8;
                    str32 = javaPropertyName;
                    str33 = str13;
                    str34 = str14;
                    schemaType3 = schemaType;
                }
                if (z8 && (set == null || set.contains(XmlOptions.BeanMethod.ADD))) {
                    schemaTypeCodePrinter.printJavaDoc("Appends the value as the last " + str11);
                    if (schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        str35 = str20;
                    } else {
                        str35 = str20;
                        schemaTypeCodePrinter.emit(str35);
                    }
                    StringBuilder sbU14 = androidx.collection.a.u("public void add", str32, str31, str34, str28);
                    sbU14.append(str8);
                    sbU14.append(str27);
                    schemaTypeCodePrinter.emit(sbU14.toString());
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str50);
                    str36 = str5;
                    sb7.append(str36);
                    schemaTypeCodePrinter.emit(sb7.toString());
                    schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6);
                    schemaTypeCodePrinter.emitAddTarget(identifier, z6, str50);
                    schemaTypeCodePrinter.printJSetValue(i5, str8, (SchemaTypeImpl) schemaProperty.getType());
                    schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                } else {
                    str35 = str20;
                    str36 = str5;
                }
                if (set != null || set.contains(XmlOptions.BeanMethod.INSERT_NEW_IDX)) {
                    schemaTypeCodePrinter.printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str35);
                    }
                    str37 = str29;
                    str38 = str6;
                    schemaTypeCodePrinter.emit(androidx.collection.a.p(str38, str37, " insertNew", str32, "(int i) {"));
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    schemaTypeCodePrinter.emit(str37 + str36);
                    str39 = str35;
                    schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                    if (zEquals) {
                        str40 = str30;
                        schemaTypeCodePrinter.emit(androidx.collection.a.p("target = (", str37, ")get_store().insert_element_user(", identifier, str40));
                        str41 = str25;
                    } else {
                        str40 = str30;
                        str41 = str25;
                        StringBuilder sbU15 = androidx.collection.a.u("target = (", str37, ")get_store().insert_element_user(", str41, str33);
                        sbU15.append(identifier);
                        sbU15.append(str40);
                        schemaTypeCodePrinter.emit(sbU15.toString());
                    }
                    schemaType3 = schemaType;
                    schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                    str42 = str3;
                    schemaTypeCodePrinter.emit(str42);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                } else {
                    str39 = str35;
                    str40 = str30;
                    str41 = str25;
                    str42 = str3;
                    str38 = str6;
                }
                if (set != null || set.contains(XmlOptions.BeanMethod.ADD_NEW)) {
                    str37 = str29;
                    str37 = str29;
                    schemaTypeCodePrinter.printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str39);
                    }
                    schemaTypeCodePrinter.emit(androidx.collection.a.p(str38, str37, " addNew", str32, str66));
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    schemaTypeCodePrinter.emit(str37 + str36);
                    schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6);
                    schemaTypeCodePrinter.emitAddTarget(identifier, z6, str37);
                    schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6);
                    schemaTypeCodePrinter.emit(str42);
                    schemaTypeCodePrinter.emitImplementationPostamble();
                    schemaTypeCodePrinter.endBlock();
                }
                if (set != null || set.contains(XmlOptions.BeanMethod.REMOVE_IDX)) {
                    schemaTypeCodePrinter.printJavaDoc("Removes the ith " + str11);
                    if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                        schemaTypeCodePrinter.emit(str39);
                    }
                    schemaTypeCodePrinter.emit("public void remove" + str32 + "(int i) {");
                    schemaTypeCodePrinter.startBlock();
                    schemaTypeCodePrinter.emitImplementationPreamble();
                    schemaTypeCodePrinter.emitPre(schemaType3, 3, identifier, z6, Complex.DEFAULT_SUFFIX);
                    schemaTypeCodePrinter.emit("get_store().remove_element(" + str41 + str40);
                    schemaTypeCodePrinter.emitPost(schemaType, 3, identifier, z6, Complex.DEFAULT_SUFFIX);
                    emitImplementationPostamble();
                    endBlock();
                }
                return;
            }
            set = compilePartialMethod;
            schemaTypeCodePrinter.printJavaDoc("Sets ith " + str11);
            if (schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                str19 = str17;
            } else {
                str19 = str17;
                schemaTypeCodePrinter.emit(str19);
            }
            str20 = str19;
            String str73 = str55;
            str21 = str12;
            StringBuilder sbU16 = androidx.collection.a.u(str15, str21, "(int i, ", str14, str73);
            sbU16.append(str8);
            str9 = str9;
            sbU16.append(str9);
            schemaTypeCodePrinter.emit(sbU16.toString());
            schemaTypeCodePrinter.startBlock();
            if (z8 && zEquals) {
                str22 = str73;
                schemaTypeCodePrinter.emitPre(schemaType, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                schemaTypeCodePrinter.emit(androidx.collection.a.p("generatedSetterHelperImpl(", str8, str13, setIdentifier, ", i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);"));
                schemaType2 = schemaType;
                schemaTypeCodePrinter.emitPost(schemaType2, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                schemaTypeCodePrinter = this;
                i5 = javaTypeCode;
            } else {
                str22 = str73;
                emitImplementationPreamble();
                emitPre(schemaType, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                String str74 = identifier;
                boolean z15 = z6;
                String str75 = setIdentifier;
                schemaTypeCodePrinter = this;
                schemaTypeCodePrinter.emitGetTarget(str75, str74, z15, Complex.DEFAULT_SUFFIX, 4, str50);
                z6 = z15;
                setIdentifier = str75;
                identifier = str74;
                int i6 = javaTypeCode;
                schemaTypeCodePrinter.printJSetValue(i6, str8, (SchemaTypeImpl) schemaProperty.getType());
                i5 = i6;
                schemaType2 = schemaType;
                schemaTypeCodePrinter.emitPost(schemaType2, 1, identifier, z6, Complex.DEFAULT_SUFFIX);
                schemaTypeCodePrinter.emitImplementationPostamble();
            }
            schemaTypeCodePrinter.endBlock();
            if (z8) {
                str23 = str10;
                str24 = str4;
            } else {
                str23 = str10;
                str24 = str4;
            }
            if (z8) {
                str25 = setIdentifier;
                str26 = str23;
                str27 = str9;
                str28 = str22;
            } else {
                str25 = setIdentifier;
                str26 = str23;
                str27 = str9;
                str28 = str22;
            }
            if (z10) {
                str29 = str26;
            } else {
                str29 = str26;
            }
            if (z8) {
                str30 = ", i);";
                str31 = r8;
                str32 = javaPropertyName;
                str33 = str13;
                str34 = str14;
                schemaType3 = schemaType;
            } else {
                str30 = ", i);";
                str31 = r8;
                str32 = javaPropertyName;
                str33 = str13;
                str34 = str14;
                schemaType3 = schemaType;
            }
            if (z8) {
                str35 = str20;
                str36 = str5;
            } else {
                str35 = str20;
                str36 = str5;
            }
            if (set != null) {
                schemaTypeCodePrinter.printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str11);
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit(str35);
                }
                str37 = str29;
                str38 = str6;
                schemaTypeCodePrinter.emit(androidx.collection.a.p(str38, str37, " insertNew", str32, "(int i) {"));
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                schemaTypeCodePrinter.emit(str37 + str36);
                str39 = str35;
                schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                if (zEquals) {
                    str40 = str30;
                    schemaTypeCodePrinter.emit(androidx.collection.a.p("target = (", str37, ")get_store().insert_element_user(", identifier, str40));
                    str41 = str25;
                } else {
                    str40 = str30;
                    str41 = str25;
                    StringBuilder sbU17 = androidx.collection.a.u("target = (", str37, ")get_store().insert_element_user(", str41, str33);
                    sbU17.append(identifier);
                    sbU17.append(str40);
                    schemaTypeCodePrinter.emit(sbU17.toString());
                }
                schemaType3 = schemaType;
                schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                str42 = str3;
                schemaTypeCodePrinter.emit(str42);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            } else {
                schemaTypeCodePrinter.printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str11);
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit(str35);
                }
                str37 = str29;
                str38 = str6;
                schemaTypeCodePrinter.emit(androidx.collection.a.p(str38, str37, " insertNew", str32, "(int i) {"));
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                schemaTypeCodePrinter.emit(str37 + str36);
                str39 = str35;
                schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                if (zEquals) {
                    str40 = str30;
                    schemaTypeCodePrinter.emit(androidx.collection.a.p("target = (", str37, ")get_store().insert_element_user(", identifier, str40));
                    str41 = str25;
                } else {
                    str40 = str30;
                    str41 = str25;
                    StringBuilder sbU18 = androidx.collection.a.u("target = (", str37, ")get_store().insert_element_user(", str41, str33);
                    sbU18.append(identifier);
                    sbU18.append(str40);
                    schemaTypeCodePrinter.emit(sbU18.toString());
                }
                schemaType3 = schemaType;
                schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6, Complex.DEFAULT_SUFFIX);
                str42 = str3;
                schemaTypeCodePrinter.emit(str42);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            }
            if (set != null) {
                str37 = str29;
                str37 = str29;
                schemaTypeCodePrinter.printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str11);
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit(str39);
                }
                schemaTypeCodePrinter.emit(androidx.collection.a.p(str38, str37, " addNew", str32, str66));
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                schemaTypeCodePrinter.emit(str37 + str36);
                schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6);
                schemaTypeCodePrinter.emitAddTarget(identifier, z6, str37);
                schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6);
                schemaTypeCodePrinter.emit(str42);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            } else {
                str37 = str29;
                str37 = str29;
                schemaTypeCodePrinter.printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str11);
                if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                    schemaTypeCodePrinter.emit(str39);
                }
                schemaTypeCodePrinter.emit(androidx.collection.a.p(str38, str37, " addNew", str32, str66));
                schemaTypeCodePrinter.startBlock();
                schemaTypeCodePrinter.emitImplementationPreamble();
                schemaTypeCodePrinter.emit(str37 + str36);
                schemaTypeCodePrinter.emitPre(schemaType3, 2, identifier, z6);
                schemaTypeCodePrinter.emitAddTarget(identifier, z6, str37);
                schemaTypeCodePrinter.emitPost(schemaType3, 2, identifier, z6);
                schemaTypeCodePrinter.emit(str42);
                schemaTypeCodePrinter.emitImplementationPostamble();
                schemaTypeCodePrinter.endBlock();
            }
            if (set != null) {
            }
            schemaTypeCodePrinter.printJavaDoc("Removes the ith " + str11);
            if (!schemaTypeCodePrinter.opt.isCompileNoAnnotations()) {
                schemaTypeCodePrinter.emit(str39);
            }
            schemaTypeCodePrinter.emit("public void remove" + str32 + "(int i) {");
            schemaTypeCodePrinter.startBlock();
            schemaTypeCodePrinter.emitImplementationPreamble();
            schemaTypeCodePrinter.emitPre(schemaType3, 3, identifier, z6, Complex.DEFAULT_SUFFIX);
            schemaTypeCodePrinter.emit("get_store().remove_element(" + str41 + str40);
            schemaTypeCodePrinter.emitPost(schemaType, 3, identifier, z6, Complex.DEFAULT_SUFFIX);
            emitImplementationPostamble();
            endBlock();
        }
    }

    public void printStaticFields(SchemaProperty[] schemaPropertyArr, Map<QName, Integer> map, Map<QName, Integer> map2) throws IOException {
        if (schemaPropertyArr.length == 0) {
            return;
        }
        emit("");
        emit("private static final QName[] PROPERTY_QNAME = {");
        indent();
        int iMax = 0;
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            QName name = schemaProperty.getName();
            map.put(name, Integer.valueOf(map.size()));
            emit("new QName(\"" + name.getNamespaceURI() + "\", \"" + name.getLocalPart() + "\"),");
            iMax = Math.max(iMax, schemaProperty.acceptedNames() == null ? 0 : schemaProperty.acceptedNames().length);
        }
        outdent();
        emit("};");
        emit("");
        int i5 = 1;
        if (iMax > 1) {
            emit("private static final QNameSet[] PROPERTY_QSET = {");
            int length = schemaPropertyArr.length;
            int i6 = 0;
            while (i6 < length) {
                SchemaProperty schemaProperty2 = schemaPropertyArr[i6];
                QName name2 = schemaProperty2.getName();
                QName[] qNameArrAcceptedNames = schemaProperty2.acceptedNames();
                if (qNameArrAcceptedNames != null && qNameArrAcceptedNames.length > i5) {
                    map2.put(name2, Integer.valueOf(map2.size()));
                    emit("QNameSet.forArray( new QName[] { ");
                    indent();
                    for (QName qName : qNameArrAcceptedNames) {
                        emit("new QName(\"" + qName.getNamespaceURI() + "\", \"" + qName.getLocalPart() + "\"),");
                    }
                    outdent();
                    emit("}),");
                }
                i6++;
                i5 = 1;
            }
            emit("};");
        }
    }

    public void printStaticTypeDeclaration(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        Class cls;
        if (schemaType.isAnonymousType() && !schemaType.isDocumentType() && !schemaType.isAttributeType()) {
            cls = ElementFactory.class;
        } else if (schemaType.isSimpleType()) {
            cls = SimpleTypeFactory.class;
        } else {
            cls = schemaType.isAbstract() ? AbstractDocumentFactory.class : DocumentFactory.class;
        }
        String simpleName = cls.getSimpleName();
        String strReplace = schemaType.getFullJavaName().replace('$', '.');
        String name = schemaType.getTypeSystem().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append("<");
        sb.append(strReplace);
        sb.append("> Factory = new ");
        sb.append(simpleName);
        androidx.collection.a.x(sb, "<>(", name, ".TypeSystemHolder.typeSystem, \"");
        sb.append(((SchemaTypeSystemImpl) schemaTypeSystem).handleForType(schemaType));
        sb.append("\");");
        emit(sb.toString());
        emit("org.apache.xmlbeans.SchemaType type = Factory.getType();");
        emit("");
    }

    public void printStringEnumeration(SchemaType schemaType) throws IOException {
        String fullJavaName = schemaType.getBaseEnumType().getFullJavaName();
        boolean zHasBase = hasBase(schemaType);
        if (!zHasBase) {
            emit("");
            emit("org.apache.xmlbeans.StringEnumAbstractBase getEnumValue();", XmlOptions.BeanMethod.GET);
            emit("void setEnumValue(org.apache.xmlbeans.StringEnumAbstractBase e);", XmlOptions.BeanMethod.SET);
        }
        emit("");
        SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (SchemaStringEnumEntry schemaStringEnumEntry : stringEnumEntries) {
            String string = schemaStringEnumEntry.getString();
            if (hashSet.contains(string)) {
                hashSet2.add(string);
            } else {
                hashSet.add(string);
                String enumName = schemaStringEnumEntry.getEnumName();
                if (zHasBase) {
                    emit(fullJavaName + ".Enum " + enumName + " = " + fullJavaName + Consts.DOT + enumName + ";");
                } else {
                    StringBuilder sbY = AbstractC0157z.y("Enum ", enumName, " = Enum.forString(\"");
                    sbY.append(javaStringEscape(string));
                    sbY.append("\");");
                    emit(sbY.toString());
                }
            }
        }
        emit("");
        for (SchemaStringEnumEntry schemaStringEnumEntry2 : stringEnumEntries) {
            if (!hashSet2.contains(schemaStringEnumEntry2.getString())) {
                String str = "INT_" + schemaStringEnumEntry2.getEnumName();
                if (zHasBase) {
                    StringBuilder sbU = androidx.collection.a.u("int ", str, " = ", fullJavaName, Consts.DOT);
                    sbU.append(str);
                    sbU.append(";");
                    emit(sbU.toString());
                } else {
                    emit(androidx.collection.a.p("int ", str, " = Enum.", str, ";"));
                }
            }
        }
        if (zHasBase) {
            return;
        }
        emit("");
        emit("/**");
        emit(" * Enumeration value class for " + fullJavaName + Consts.DOT);
        emit(" * These enum values can be used as follows:");
        emit(" * <pre>");
        emit(" * enum.toString(); // returns the string value of the enum");
        emit(" * enum.intValue(); // returns an int value, useful for switches");
        if (stringEnumEntries.length > 0) {
            emit(" * // e.g., case Enum.INT_" + stringEnumEntries[0].getEnumName());
        }
        emit(" * Enum.forString(s); // returns the enum value for a string");
        emit(" * Enum.forInt(i); // returns the enum value for an int");
        emit(" * </pre>");
        emit(" * Enumeration objects are immutable singleton objects that");
        emit(" * can be compared using == object equality. They have no");
        emit(" * public constructor. See the constants defined within this");
        emit(" * class for all the valid values.");
        emit(" */");
        emit("final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase {");
        indent();
        emit("/**");
        emit(" * Returns the enum value for a string, or null if none.");
        emit(" */");
        emit("public static Enum forString(java.lang.String s) {");
        emit("    return (Enum)table.forString(s);");
        emit(VectorFormat.DEFAULT_SUFFIX);
        emit("");
        emit("/**");
        emit(" * Returns the enum value corresponding to an int, or null if none.");
        emit(" */");
        emit("public static Enum forInt(int i) {");
        emit("    return (Enum)table.forInt(i);");
        emit(VectorFormat.DEFAULT_SUFFIX);
        emit("");
        emit("private Enum(java.lang.String s, int i) {");
        emit("    super(s, i);");
        emit(VectorFormat.DEFAULT_SUFFIX);
        emit("");
        for (SchemaStringEnumEntry schemaStringEnumEntry3 : stringEnumEntries) {
            emit("static final int " + ("INT_" + schemaStringEnumEntry3.getEnumName()) + " = " + schemaStringEnumEntry3.getIntValue() + ";");
        }
        emit("");
        emit("public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =");
        emit("    new org.apache.xmlbeans.StringEnumAbstractBase.Table(new Enum[] {");
        indent();
        for (SchemaStringEnumEntry schemaStringEnumEntry4 : stringEnumEntries) {
            emit("new Enum(\"" + javaStringEscape(schemaStringEnumEntry4.getString()) + "\", " + ("INT_" + schemaStringEnumEntry4.getEnumName()) + "),");
        }
        outdent();
        emit("});");
        emit("private static final long serialVersionUID = 1L;");
        emit("private java.lang.Object readResolve() {");
        emit("    return forInt(intValue());");
        emit(VectorFormat.DEFAULT_SUFFIX);
        outdent();
        emit(VectorFormat.DEFAULT_SUFFIX);
    }

    public void printTopComment(SchemaType schemaType) throws IOException {
        QName attributeTypeAttributeName;
        emit("/*");
        if (schemaType.getName() != null) {
            emit(" * XML Type:  " + schemaType.getName().getLocalPart());
            emit(" * Namespace: " + schemaType.getName().getNamespaceURI());
        } else {
            if (schemaType.isDocumentType()) {
                attributeTypeAttributeName = schemaType.getDocumentElementName();
                emit(" * An XML document type.");
            } else if (schemaType.isAttributeType()) {
                attributeTypeAttributeName = schemaType.getAttributeTypeAttributeName();
                emit(" * An XML attribute type.");
            } else {
                attributeTypeAttributeName = null;
            }
            emit(" * Localname: " + attributeTypeAttributeName.getLocalPart());
            emit(" * Namespace: " + attributeTypeAttributeName.getNamespaceURI());
        }
        emit(" * Java type: " + schemaType.getFullJavaName());
        emit(" *");
        emit(" * Automatically generated - do not modify.");
        emit(" */");
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printType(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        this.opt = xmlOptions;
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, true);
        emit("");
        emit("import " + ElementFactory.class.getName() + ";");
        emit("import " + AbstractDocumentFactory.class.getName() + ";");
        emit("import " + DocumentFactory.class.getName() + ";");
        emit("import " + SimpleTypeFactory.class.getName() + ";");
        emit("");
        printInnerType(schemaType, schemaType.getTypeSystem());
        this._writer.flush();
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printTypeImpl(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        this.opt = xmlOptions;
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, false);
        emit("");
        emit("import javax.xml.namespace.QName;");
        emit("import org.apache.xmlbeans.QNameSet;");
        emit("import org.apache.xmlbeans.XmlObject;");
        emit("");
        printInnerTypeImpl(schemaType, schemaType.getTypeSystem(), false);
    }

    public void startBlock() {
        indent();
    }

    public void startClass(SchemaType schemaType, boolean z6) throws IOException {
        String shortJavaImplName = schemaType.getShortJavaImplName();
        String baseClass = getBaseClass(schemaType);
        StringBuilder sb = new StringBuilder();
        sb.append(schemaType.getFullJavaName().replace('$', '.'));
        if (schemaType.getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : schemaType.getUnionMemberTypes()) {
                sb.append(", ");
                sb.append(schemaType2.getFullJavaName().replace('$', '.'));
            }
        }
        StringBuilder sb2 = new StringBuilder("public ");
        androidx.collection.a.y(sb2, z6 ? "static " : "", "class ", shortJavaImplName, " extends ");
        sb2.append(baseClass);
        sb2.append(" implements ");
        sb2.append((Object) sb);
        sb2.append(" {");
        emit(sb2.toString());
        startBlock();
        emit("private static final long serialVersionUID = 1L;");
    }

    public void startInterface(SchemaType schemaType) throws IOException {
        emit("public interface " + schemaType.getShortJavaName() + " extends " + findJavaType(schemaType.getBaseType()) + getExtensionInterfaces(schemaType) + " {");
        indent();
        emitSpecializedAccessors(schemaType);
    }

    public String xmlTypeForProperty(SchemaProperty schemaProperty) {
        return findJavaType(schemaProperty.javaBasedOnType()).replace('$', '.');
    }

    public void emitPost(SchemaType schemaType, int i5, String str, boolean z6, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null) {
            return;
        }
        if (prePostExtension.hasPreCall()) {
            endBlock();
        }
        if (prePostExtension.hasPostCall()) {
            emit(prePostExtension.getStaticHandler() + ".postSet(" + prePostOpString(i5) + ", this, " + str + ", " + z6 + ", " + str2 + ");");
        }
    }

    public void emitPre(SchemaType schemaType, int i5, String str, boolean z6, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null || !prePostExtension.hasPreCall()) {
            return;
        }
        emit("if ( " + prePostExtension.getStaticHandler() + ".preSet(" + prePostOpString(i5) + ", this, " + str + ", " + z6 + ", " + str2 + ")) {");
        startBlock();
    }

    public void emit(String str) throws IOException {
        if (!str.trim().isEmpty()) {
            int i5 = this._indent;
            if (i5 > 20) {
                i5 = (i5 / 2) + 10;
            }
            if (i5 > 40) {
                i5 = 40;
            }
            this._writer.write(MAX_SPACES.substring(0, i5));
        }
        try {
            this._writer.write(str);
        } catch (CharacterCodingException unused) {
            this._writer.write(makeSafe(str));
        }
        this._writer.write(System.lineSeparator());
    }

    public void printJavaDoc(String str) throws IOException {
        emit("");
        emit("/**");
        emit(" * " + str);
        emit(" */");
    }
}
