package org.apache.xmlbeans.impl.tool;

import A3.AbstractC0157z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.namespace.QName;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XsbDumper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DATA_BABE = -629491010;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    public static final int MAJOR_VERSION = 2;
    public static final int MINOR_VERSION = 24;
    private static final XmlOptions prettyOptions = new XmlOptions().setSavePrettyPrint();
    private String _indent;
    LongUTFDataInputStream _input;
    private int _majorver;
    private int _minorver;
    private final PrintStream _out;
    private int _releaseno;
    StringPool _stringPool;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class StringPool {
        private final List<String> intsToStrings;
        private final Map<String, Integer> stringsToInts;

        public StringPool() {
            ArrayList arrayList = new ArrayList();
            this.intsToStrings = arrayList;
            this.stringsToInts = new HashMap();
            arrayList.add(null);
        }

        public int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer numValueOf = this.stringsToInts.get(str);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, numValueOf);
            }
            return numValueOf.intValue();
        }

        public void readFrom(LongUTFDataInputStream longUTFDataInputStream) {
            if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
                throw new IllegalStateException();
            }
            try {
                short s6 = longUTFDataInputStream.readShort();
                XsbDumper.this.emit("String pool (" + ((int) s6) + "):");
                XsbDumper.this.indent();
                for (int i5 = 1; i5 < s6; i5++) {
                    String longUTF = longUTFDataInputStream.readLongUTF();
                    int iCodeForString = codeForString(longUTF);
                    if (iCodeForString != i5) {
                        throw new IllegalStateException();
                    }
                    XsbDumper.this.emit(iCodeForString + " = \"" + longUTF + "\"");
                }
                XsbDumper.this.outdent();
            } catch (IOException e) {
                XsbDumper.this.emit(e.toString());
            }
        }

        public String stringForCode(int i5) {
            if (i5 == 0) {
                return null;
            }
            return this.intsToStrings.get(i5);
        }
    }

    private XsbDumper(InputStream inputStream, String str, PrintStream printStream) {
        this._input = new LongUTFDataInputStream(inputStream);
        this._indent = str;
        this._out = printStream;
    }

    public static String alwaysString(int i5) {
        if (i5 == 0) {
            return "NEVER";
        }
        if (i5 != 1) {
            return i5 != 2 ? androidx.collection.a.i(i5, "Unknown frequency code (", ")") : "CONSISTENTLY";
        }
        return "VARIABLE";
    }

    public static String attruseCodeString(int i5) {
        if (i5 == 1) {
            return "PROHIBITED";
        }
        if (i5 != 2) {
            return i5 != 3 ? androidx.collection.a.i(i5, "Unknown use code (", ")") : "REQUIRED";
        }
        return "OPTIONAL";
    }

    public static String bigIntegerString(BigInteger bigInteger) {
        return bigInteger == null ? "(null)" : bigInteger.toString();
    }

    public static String complexVarietyString(int i5) {
        if (i5 == 1) {
            return "EMPTY_CONTENT";
        }
        if (i5 == 2) {
            return "SIMPLE_CONTENT";
        }
        if (i5 != 3) {
            return i5 != 4 ? androidx.collection.a.i(i5, "Unknown complex variety (", ")") : "MIXED_CONTENT";
        }
        return "ELEMENT_CONTENT";
    }

    public static String containerfieldTypeString(int i5) {
        if (i5 == 0) {
            return "FIELD_NONE";
        }
        if (i5 == 1) {
            return "FIELD_GLOBAL";
        }
        if (i5 != 2) {
            return i5 != 3 ? androidx.collection.a.i(i5, "Unknown container field type (", ")") : "FIELD_LOCALELT";
        }
        return "FIELD_LOCALATTR";
    }

    private static void dump(File file, boolean z6) {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles(new a(1));
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    dump(file2, false);
                }
                return;
            }
            return;
        }
        if (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")) {
            dumpZip(file);
            return;
        }
        if (z6 || file.getName().endsWith(".xsb")) {
            try {
                System.out.println(file.toString());
                dump(new FileInputStream(file), "  ");
                System.out.println();
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void dumpZip(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().endsWith(".xsb")) {
                        System.out.println(zipEntryNextElement.getName());
                        dump(zipFile.getInputStream(zipEntryNextElement), "  ");
                        System.out.println();
                    }
                }
                zipFile.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        zipFile.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static String filetypeString(int i5) {
        switch (i5) {
            case 1:
                return "FILETYPE_SCHEMAINDEX";
            case 2:
                return "FILETYPE_SCHEMATYPE";
            case 3:
                return "FILETYPE_SCHEMAELEMENT";
            case 4:
                return "FILETYPE_SCHEMAATTRIBUTE";
            case 5:
                return "FILETYPE_SCHEMAPOINTER";
            case 6:
                return "FILETYPE_SCHEMAMODELGROUP";
            case 7:
                return "FILETYPE_SCHEMAATTRIBUTEGROUP";
            default:
                return androidx.collection.a.i(i5, "Unknown FILETYPE (", ")");
        }
    }

    public static String hex32String(int i5) {
        return Integer.toHexString(i5);
    }

    public static String jtcString(int i5) {
        switch (i5) {
            case 0:
                return "XML_OBJECT";
            case 1:
                return "JAVA_BOOLEAN";
            case 2:
                return "JAVA_FLOAT";
            case 3:
                return "JAVA_DOUBLE";
            case 4:
                return "JAVA_BYTE";
            case 5:
                return "JAVA_SHORT";
            case 6:
                return "JAVA_INT";
            case 7:
                return "JAVA_LONG";
            case 8:
                return "JAVA_BIG_DECIMAL";
            case 9:
                return "JAVA_BIG_INTEGER";
            case 10:
                return "JAVA_STRING";
            case 11:
                return "JAVA_BYTE_ARRAY";
            case 12:
                return "JAVA_GDATE";
            case 13:
                return "JAVA_GDURATION";
            case 14:
                return "JAVA_DATE";
            case 15:
                return "JAVA_QNAME";
            case 16:
                return "JAVA_LIST";
            case 17:
                return "JAVA_CALENDAR";
            case 18:
                return "JAVA_ENUM";
            case 19:
                return "JAVA_OBJECT";
            default:
                return androidx.collection.a.i(i5, "Unknown java type code (", ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$dump$0(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.isFile() && file.getName().endsWith(".xsb");
    }

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
        } else {
            for (String str : strArr) {
                dump(new File(str), true);
            }
        }
    }

    public static String particleTypeString(int i5) {
        if (i5 == 1) {
            return Rule.ALL;
        }
        if (i5 == 2) {
            return "CHOICE";
        }
        if (i5 == 3) {
            return "SEQUENCE";
        }
        if (i5 != 4) {
            return i5 != 5 ? androidx.collection.a.i(i5, "Unknown particle type (", ")") : "WILDCARD";
        }
        return "ELEMENT";
    }

    public static String particleflagsString(int i5) {
        StringBuilder sb = new StringBuilder();
        if ((i5 & 1) != 0) {
            sb.append("FLAG_PART_SKIPPABLE | ");
        }
        if ((i5 & 4) != 0) {
            sb.append("FLAG_PART_FIXED | ");
        }
        if ((i5 & 8) != 0) {
            sb.append("FLAG_PART_NILLABLE | ");
        }
        if ((i5 & 16) != 0) {
            sb.append("FLAG_PART_BLOCKEXT | ");
        }
        if ((i5 & 32) != 0) {
            sb.append("FLAG_PART_BLOCKREST | ");
        }
        if ((i5 & 64) != 0) {
            sb.append("FLAG_PART_BLOCKSUBST | ");
        }
        if ((i5 & 128) != 0) {
            sb.append("FLAG_PART_ABSTRACT | ");
        }
        if ((i5 & 256) != 0) {
            sb.append("FLAG_PART_FINALEXT | ");
        }
        if ((i5 & 512) != 0) {
            sb.append("FLAG_PART_FINALREST | ");
        }
        if (sb.length() == 0) {
            sb.append("0 | ");
        }
        return sb.substring(0, sb.length() - 3);
    }

    public static void printUsage() {
        System.out.println("Prints the contents of an XSB file in human-readable form.");
        System.out.println("An XSB file contains schema meta information needed to ");
        System.out.println("perform tasks such as binding and validation.");
        System.out.println("Usage: dumpxsb myfile.xsb");
        System.out.println("    myfile.xsb - Path to an XSB file.");
        System.out.println();
    }

    public static String propertyflagsString(int i5) {
        StringBuilder sb = new StringBuilder();
        if ((i5 & 1) != 0) {
            sb.append("FLAG_PROP_ISATTR | ");
        }
        if ((i5 & 2) != 0) {
            sb.append("FLAG_PROP_JAVASINGLETON | ");
        }
        if ((i5 & 4) != 0) {
            sb.append("FLAG_PROP_JAVAOPTIONAL | ");
        }
        if ((i5 & 8) != 0) {
            sb.append("FLAG_PROP_JAVAARRAY | ");
        }
        if (sb.length() == 0) {
            sb.append("0 | ");
        }
        return sb.substring(0, sb.length() - 3);
    }

    public static String qnameSetString(QNameSet qNameSet) {
        return qNameSet.toString();
    }

    public static String qnameString(QName qName) {
        if (qName == null) {
            return "(null)";
        }
        if (qName.getNamespaceURI() == null) {
            return qName.getLocalPart();
        }
        return qName.getLocalPart() + "@" + qName.getNamespaceURI();
    }

    public static String simpleVarietyString(int i5) {
        if (i5 == 1) {
            return "ATOMIC";
        }
        if (i5 != 2) {
            return i5 != 3 ? androidx.collection.a.i(i5, "Unknown simple variety (", ")") : "LIST";
        }
        return "UNION";
    }

    public static String typeflagsString(int i5) {
        StringBuilder sb = new StringBuilder();
        if ((i5 & 1) != 0) {
            sb.append("FLAG_SIMPLE_TYPE | ");
        }
        if ((i5 & 2) != 0) {
            sb.append("FLAG_DOCUMENT_TYPE | ");
        }
        if ((524288 & i5) != 0) {
            sb.append("FLAG_ATTRIBUTE_TYPE | ");
        }
        if ((i5 & 4) != 0) {
            sb.append("FLAG_ORDERED | ");
        }
        if ((i5 & 8) != 0) {
            sb.append("FLAG_BOUNDED | ");
        }
        if ((i5 & 16) != 0) {
            sb.append("FLAG_FINITE | ");
        }
        if ((i5 & 32) != 0) {
            sb.append("FLAG_NUMERIC | ");
        }
        if ((i5 & 64) != 0) {
            sb.append("FLAG_STRINGENUM | ");
        }
        if ((i5 & 128) != 0) {
            sb.append("FLAG_UNION_OF_LISTS | ");
        }
        if ((i5 & 256) != 0) {
            sb.append("FLAG_HAS_PATTERN | ");
        }
        if ((i5 & 1024) != 0) {
            sb.append("FLAG_TOTAL_ORDER | ");
        }
        if ((i5 & 2048) != 0) {
            sb.append("FLAG_COMPILED | ");
        }
        if ((i5 & 4096) != 0) {
            sb.append("FLAG_BLOCK_EXT | ");
        }
        if ((i5 & 8192) != 0) {
            sb.append("FLAG_BLOCK_REST | ");
        }
        if ((i5 & 16384) != 0) {
            sb.append("FLAG_FINAL_EXT | ");
        }
        if ((32768 & i5) != 0) {
            sb.append("FLAG_FINAL_REST | ");
        }
        if ((65536 & i5) != 0) {
            sb.append("FLAG_FINAL_UNION | ");
        }
        if ((131072 & i5) != 0) {
            sb.append("FLAG_FINAL_LIST | ");
        }
        if ((i5 & 262144) != 0) {
            sb.append("FLAG_ABSTRACT | ");
        }
        if (sb.length() == 0) {
            sb.append("0 | ");
        }
        return sb.substring(0, sb.length() - 3);
    }

    public static String wcprocessString(int i5) {
        if (i5 == 0) {
            return "NOT_WILDCARD";
        }
        if (i5 == 1) {
            return "STRICT";
        }
        if (i5 != 2) {
            return i5 != 3 ? androidx.collection.a.i(i5, "Unknown process type (", ")") : "SKIP";
        }
        return "LAX";
    }

    public String SOAPArrayTypeString(SOAPArrayType sOAPArrayType) {
        if (sOAPArrayType == null) {
            return AbstractC1127c.NULL;
        }
        return QNameHelper.pretty(sOAPArrayType.getQName()) + sOAPArrayType.soap11DimensionString();
    }

    public boolean atLeast(int i5, int i6, int i7) {
        int i8 = this._majorver;
        if (i8 > i5) {
            return true;
        }
        if (i8 < i5) {
            return false;
        }
        int i9 = this._minorver;
        if (i9 > i6) {
            return true;
        }
        return i9 >= i6 && this._releaseno >= i7;
    }

    public boolean atMost(int i5, int i6, int i7) {
        int i8 = this._majorver;
        if (i8 > i5) {
            return false;
        }
        if (i8 < i5) {
            return true;
        }
        int i9 = this._minorver;
        if (i9 > i6) {
            return false;
        }
        return i9 < i6 || this._releaseno <= i7;
    }

    public String derivationTypeString(int i5) {
        if (i5 == 0) {
            return "DT_NOT_DERIVED";
        }
        if (i5 != 1) {
            return i5 != 2 ? androidx.collection.a.i(i5, "Unknown derivation code (", ")") : "DT_EXTENSION";
        }
        return "DT_RESTRICTION";
    }

    public void dumpAll() {
        switch (dumpHeader()) {
            case 1:
                dumpIndexData();
                return;
            case 2:
                dumpTypeFileData();
                break;
            case 3:
                dumpParticleData(true);
                break;
            case 4:
                dumpAttributeData(true);
                break;
            case 5:
                dumpPointerData();
                break;
            case 6:
                dumpModelGroupData();
                break;
            case 7:
                dumpAttributeGroupData();
                break;
        }
        readEnd();
    }

    public void dumpAnnotation() {
        int i5;
        boolean z6;
        boolean z7 = false;
        if (atLeast(2, 19, 0) && (i5 = readInt()) != -1) {
            emit("Annotation");
            indent();
            if (i5 > 0) {
                emit("Attributes (" + i5 + "):");
                indent();
                for (int i6 = 0; i6 < i5; i6++) {
                    if (atLeast(2, 24, 0)) {
                        emit("Name: " + qnameString(readQName()) + ", Value: " + readString() + ", ValueURI: " + readString());
                    } else {
                        emit("Name: " + qnameString(readQName()) + ", Value: " + readString());
                    }
                }
                outdent();
                z6 = false;
            } else {
                z6 = true;
            }
            int i7 = readInt();
            if (i7 > 0) {
                emit("Documentation elements (" + i7 + "):");
                indent();
                for (int i8 = 0; i8 < i7; i8++) {
                    emit(readString());
                }
                outdent();
                z6 = false;
            }
            int i9 = readInt();
            if (i9 > 0) {
                emit("Appinfo elements (" + i9 + "):");
                indent();
                for (int i10 = 0; i10 < i9; i10++) {
                    emit(readString());
                }
                outdent();
            } else {
                z7 = z6;
            }
            if (z7) {
                emit("<empty>");
            }
            outdent();
        }
    }

    public void dumpAnnotations() {
        int i5 = readInt();
        if (i5 > 0) {
            emit("Top-level annotations (" + i5 + "):");
            indent();
            for (int i6 = 0; i6 < i5; i6++) {
                dumpAnnotation();
            }
            outdent();
        }
    }

    public void dumpAttributeData(boolean z6) {
        emit("Name: " + qnameString(readQName()));
        emit("Type: " + readType());
        emit("Use: " + attruseCodeString(readShort()));
        emit("Default: " + readString());
        if (atLeast(2, 16, 0)) {
            emit("Default value: " + readXmlValueObject());
        }
        emit("Fixed: " + readShort());
        emit("WsdlArrayType: " + SOAPArrayTypeString(readSOAPArrayType()));
        dumpAnnotation();
        if (z6) {
            emit("Filename: " + readString());
        }
    }

    public void dumpAttributeGroupData() {
        emit("Name: " + qnameString(readQName()));
        emit("Target namespace: " + readString());
        emit("Chameleon: " + readShort());
        if (atLeast(2, 22, 0)) {
            emit("Form default: " + readString());
        }
        if (atLeast(2, 15, 0)) {
            emit("Redefine: " + readShort());
        }
        emit("Attribute Group Xml: ");
        dumpXml();
        dumpAnnotation();
        if (atLeast(2, 21, 0)) {
            emit("Filename: " + readString());
        }
    }

    public void dumpClassnameIndex(String str) {
        int i5 = readShort();
        emit(str + " (" + i5 + "):");
        indent();
        for (int i6 = 0; i6 < i5; i6++) {
            emit(readString() + " = " + readType());
        }
        outdent();
    }

    public int dumpHeader() {
        int i5 = readInt();
        emit("Magic cookie: " + hex32String(i5));
        if (i5 != -629491010) {
            emit("Wrong magic cookie.");
            return 0;
        }
        this._majorver = readShort();
        this._minorver = readShort();
        if (atLeast(2, 18, 0)) {
            this._releaseno = readShort();
        }
        emit("Major version: " + this._majorver);
        emit("Minor version: " + this._minorver);
        emit("Release number: " + this._releaseno);
        if (this._majorver != 2 || this._minorver > 24) {
            emit("Incompatible version.");
            return 0;
        }
        int i6 = readShort();
        emit("Filetype: " + filetypeString(i6));
        StringPool stringPool = new StringPool();
        this._stringPool = stringPool;
        stringPool.readFrom(this._input);
        return i6;
    }

    public void dumpIndexData() {
        int i5 = readShort();
        emit("Handle pool (" + i5 + "):");
        indent();
        for (int i6 = 0; i6 < i5; i6++) {
            String string = readString();
            int i7 = readShort();
            StringBuilder sbX = AbstractC0157z.x(string, " (");
            sbX.append(filetypeString(i7));
            sbX.append(")");
            emit(sbX.toString());
        }
        outdent();
        dumpQNameMap("Global elements");
        dumpQNameMap("Global attributes");
        dumpQNameMap("Model groups");
        dumpQNameMap("Attribute groups");
        dumpQNameMap("Identity constraints");
        dumpQNameMap("Global types");
        dumpQNameMap("Document types");
        dumpQNameMap("Attribute types");
        dumpClassnameIndex("All types by classname");
        dumpStringArray("Defined namespaces");
        if (atLeast(2, 15, 0)) {
            dumpQNameMap("Redefined global types");
            dumpQNameMap("Redfined model groups");
            dumpQNameMap("Redfined attribute groups");
        }
        if (atLeast(2, 19, 0)) {
            dumpAnnotations();
        }
        readEnd();
    }

    public void dumpModelGroupData() {
        emit("Name: " + qnameString(readQName()));
        emit("Target namespace: " + readString());
        emit("Chameleon: " + readShort());
        if (atLeast(2, 22, 0)) {
            emit("Element form default: " + readString());
        }
        if (atLeast(2, 22, 0)) {
            emit("Attribute form default: " + readString());
        }
        if (atLeast(2, 15, 0)) {
            emit("Redefine: " + readShort());
        }
        emit("Model Group Xml: ");
        dumpXml();
        dumpAnnotation();
        if (atLeast(2, 21, 0)) {
            emit("Filename: " + readString());
        }
    }

    public void dumpParticleArray(String str) {
        int i5 = readShort();
        emit(str + "(" + i5 + "):");
        indent();
        for (int i6 = 0; i6 < i5; i6++) {
            dumpParticleData(false);
        }
        outdent();
    }

    public void dumpParticleData(boolean z6) {
        int i5 = readShort();
        emit(particleTypeString(i5) + ParameterizedMessage.ERROR_MSG_SEPARATOR);
        indent();
        emit("Flags: " + particleflagsString(readShort()));
        emit("MinOccurs: " + bigIntegerString(readBigInteger()));
        emit("MaxOccurs: " + bigIntegerString(readBigInteger()));
        emit("Transition: " + qnameSetString(readQNameSet()));
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            dumpParticleArray("Particle children");
        } else if (i5 == 4) {
            emit("Name: " + qnameString(readQName()));
            emit("Type: " + readType());
            emit("Default: " + readString());
            if (atLeast(2, 16, 0)) {
                emit("Default value: " + readXmlValueObject());
            }
            emit("WsdlArrayType: " + SOAPArrayTypeString(readSOAPArrayType()));
            dumpAnnotation();
            if (z6) {
                if (atLeast(2, 17, 0)) {
                    emit("Substitution group ref: " + readHandle());
                }
                int i6 = readShort();
                emit("Substitution group members (" + i6 + ")");
                indent();
                for (int i7 = 0; i7 < i6; i7++) {
                    emit(qnameString(readQName()));
                }
                outdent();
            }
            int i8 = readShort();
            emit("Identity constraints (" + i8 + "):");
            indent();
            for (int i9 = 0; i9 < i8; i9++) {
                emit(readHandle());
            }
            outdent();
            if (z6) {
                emit("Filename: " + readString());
            }
        } else if (i5 != 5) {
            error("Unrecognized schema particle type");
        } else {
            emit("Wildcard set: " + qnameSetString(readQNameSet()));
            emit("Wildcard process: " + wcprocessString(readShort()));
        }
        outdent();
    }

    public void dumpPointerData() {
        emit("Type system: " + readString());
    }

    public void dumpPropertyData() {
        emit("Property");
        indent();
        emit("Name: " + qnameString(readQName()));
        emit("Type: " + readType());
        int i5 = readShort();
        emit("Flags: " + propertyflagsString(i5));
        emit("Container type: " + readType());
        emit("Min occurances: " + bigIntegerString(readBigInteger()));
        emit("Max occurances: " + bigIntegerString(readBigInteger()));
        emit("Nillable: " + alwaysString(readShort()));
        emit("Default: " + alwaysString(readShort()));
        emit("Fixed: " + alwaysString(readShort()));
        emit("Default text: " + readString());
        emit("Java prop name: " + readString());
        emit("Java type code: " + jtcString(readShort()));
        emit("Type for java signature: " + readType());
        if (atMost(2, 19, 0)) {
            emit("Java setter delimiter: " + qnameSetString(readQNameSet()));
        }
        if (atLeast(2, 16, 0)) {
            emit("Default value: " + readXmlValueObject());
        }
        if ((i5 & 1) == 0 && atLeast(2, 17, 0)) {
            int i6 = readShort();
            emit("Accepted substitutions (" + i6 + "):");
            for (int i7 = 0; i7 < i6; i7++) {
                emit("  Accepted name " + readQName());
            }
        }
        outdent();
    }

    public void dumpQNameMap(String str) {
        int i5 = readShort();
        emit(str + " (" + i5 + "):");
        indent();
        for (int i6 = 0; i6 < i5; i6++) {
            emit(qnameString(readQName()) + " = " + readHandle());
        }
        outdent();
    }

    public void dumpStringArray(String str) {
        int i5 = readShort();
        emit(str + " (" + i5 + "):");
        indent();
        for (int i6 = 0; i6 < i5; i6++) {
            emit(readString());
        }
        outdent();
    }

    public void dumpTypeArray(String str) {
        int i5 = readShort();
        emit(str + " (" + i5 + "):");
        indent();
        for (int i6 = 0; i6 < i5; i6++) {
            emit(i6 + " = " + readType());
        }
        outdent();
    }

    public void dumpTypeFileData() {
        int i5;
        emit("Name: " + qnameString(readQName()));
        emit("Outer type: " + readType());
        emit("Depth: " + readShort());
        emit("Base type: " + readType());
        emit("Derivation type: " + derivationTypeString(readShort()));
        dumpAnnotation();
        emit("Container field:");
        indent();
        int i6 = readShort();
        emit("Reftype: " + containerfieldTypeString(i6));
        if (i6 == 1) {
            emit("Handle: " + readHandle());
        } else if (i6 == 2) {
            emit("Index: " + readShort());
        } else if (i6 == 3) {
            emit("Index: " + readShort());
        }
        outdent();
        emit("Java class name: " + readString());
        emit("Java impl class name: " + readString());
        dumpTypeArray("Anonymous types");
        emit("Anonymous union member ordinal: " + readShort());
        int i7 = readInt();
        emit("Flags: " + typeflagsString(i7));
        boolean z6 = (i7 & 1) == 0;
        if (z6) {
            i5 = readShort();
            emit("Complex variety: " + complexVarietyString(i5));
            if (atLeast(2, 23, 0)) {
                emit("Content based on type: " + readType());
            }
            int i8 = readShort();
            emit("Attribute model (" + i8 + "):");
            indent();
            for (int i9 = 0; i9 < i8; i9++) {
                dumpAttributeData(false);
            }
            emit("Wildcard set: " + qnameSetString(readQNameSet()));
            emit("Wildcard process: " + wcprocessString(readShort()));
            outdent();
            int i10 = readShort();
            emit("Attribute properties (" + i10 + "):");
            indent();
            for (int i11 = 0; i11 < i10; i11++) {
                dumpPropertyData();
            }
            outdent();
            if (i5 == 3 || i5 == 4) {
                emit("IsAll: " + readShort());
                dumpParticleArray("Content model");
                int i12 = readShort();
                emit("Element properties (" + i12 + "):");
                indent();
                for (int i13 = 0; i13 < i12; i13++) {
                    dumpPropertyData();
                }
                outdent();
            }
        } else {
            i5 = 0;
        }
        if (!z6 || i5 == 2) {
            int i14 = readShort();
            emit("Simple type variety: " + simpleVarietyString(i14));
            boolean z7 = (i7 & 64) != 0;
            int i15 = readShort();
            emit("Facets (" + i15 + "):");
            indent();
            for (int i16 = 0; i16 < i15; i16++) {
                emit(facetCodeString(readShort()));
                emit("Value: " + readXmlValueObject());
                emit("Fixed: " + readShort());
            }
            outdent();
            emit("Whitespace rule: " + whitespaceCodeString(readShort()));
            int i17 = readShort();
            emit("Patterns (" + i17 + "):");
            indent();
            for (int i18 = 0; i18 < i17; i18++) {
                emit(readString());
            }
            outdent();
            int i19 = readShort();
            emit("Enumeration values (" + i19 + "):");
            indent();
            for (int i20 = 0; i20 < i19; i20++) {
                emit(readXmlValueObject());
            }
            outdent();
            emit("Base enum type: " + readType());
            if (z7) {
                int i21 = readShort();
                emit("String enum entries (" + i21 + "):");
                indent();
                for (int i22 = 0; i22 < i21; i22++) {
                    emit("\"" + readString() + "\" -> " + readShort() + " = " + readString());
                }
                outdent();
            }
            if (i14 == 1) {
                emit("Primitive type: " + readType());
                emit("Decimal size: " + readInt());
            } else if (i14 == 2) {
                dumpTypeArray("Union members");
            } else if (i14 != 3) {
                error("Unknown simple type variety");
            } else {
                emit("List item type: " + readType());
            }
        }
        emit("Filename: " + readString());
    }

    public void dumpXml() {
        String string = readString();
        try {
            emit(XmlObject.Factory.parse(string).xmlText(prettyOptions));
        } catch (XmlException unused) {
            emit("!!!!!! BAD XML !!!!!");
            emit(string);
        }
    }

    public void emit(String str) {
        this._out.println(this._indent + str);
        flush();
    }

    public void error(Exception exc) {
        this._out.println(exc.toString());
        flush();
        throw new IllegalStateException(exc.getMessage(), exc);
    }

    public String facetCodeString(int i5) {
        switch (i5) {
            case 0:
                return "FACET_LENGTH";
            case 1:
                return "FACET_MIN_LENGTH";
            case 2:
                return "FACET_MAX_LENGTH";
            case 3:
                return "FACET_MIN_EXCLUSIVE";
            case 4:
                return "FACET_MIN_INCLUSIVE";
            case 5:
                return "FACET_MAX_INCLUSIVE";
            case 6:
                return "FACET_MAX_EXCLUSIVE";
            case 7:
                return "FACET_TOTAL_DIGITS";
            case 8:
                return "FACET_FRACTION_DIGITS";
            default:
                return androidx.collection.a.i(i5, "Unknown facet code (", ")");
        }
    }

    public void flush() {
        this._out.flush();
    }

    public void indent() {
        this._indent = AbstractC0157z.s(new StringBuilder(), this._indent, "  ");
    }

    public void outdent() {
        this._indent = androidx.collection.a.g(2, 0, this._indent);
    }

    public BigInteger readBigInteger() {
        byte[] byteArray = readByteArray();
        if (byteArray.length == 0) {
            return null;
        }
        if (byteArray.length == 1 && byteArray[0] == 0) {
            return BigInteger.ZERO;
        }
        return (byteArray.length == 1 && byteArray[0] == 1) ? BigInteger.ONE : new BigInteger(byteArray);
    }

    public byte[] readByteArray() {
        try {
            byte[] bArr = new byte[this._input.readShort()];
            this._input.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            error(e);
            return null;
        }
    }

    public double readDouble() {
        try {
            return this._input.readDouble();
        } catch (IOException e) {
            error(e);
            return 0.0d;
        }
    }

    public void readEnd() {
        try {
            this._input.close();
        } catch (IOException unused) {
        }
        this._input = null;
        this._stringPool = null;
    }

    public String readHandle() {
        return readString();
    }

    public int readInt() {
        try {
            return this._input.readInt();
        } catch (IOException e) {
            error(e);
            return 0;
        }
    }

    public QName readQName() {
        String string = readString();
        String string2 = readString();
        if (string2 == null) {
            return null;
        }
        return new QName(string, string2);
    }

    public QNameSet readQNameSet() {
        int i5 = readShort();
        HashSet hashSet = new HashSet();
        int i6 = readShort();
        for (int i7 = 0; i7 < i6; i7++) {
            hashSet.add(readString());
        }
        HashSet hashSet2 = new HashSet();
        int i8 = readShort();
        for (int i9 = 0; i9 < i8; i9++) {
            hashSet2.add(readQName());
        }
        HashSet hashSet3 = new HashSet();
        int i10 = readShort();
        for (int i11 = 0; i11 < i10; i11++) {
            hashSet3.add(readQName());
        }
        return i5 == 1 ? QNameSet.forSets(hashSet, null, hashSet2, hashSet3) : QNameSet.forSets(null, hashSet, hashSet3, hashSet2);
    }

    public SOAPArrayType readSOAPArrayType() {
        QName qName = readQName();
        String string = readString();
        if (qName == null) {
            return null;
        }
        return new SOAPArrayType(qName, string);
    }

    public int readShort() {
        try {
            return this._input.readUnsignedShort();
        } catch (IOException e) {
            error(e);
            return 0;
        }
    }

    public String readString() {
        return this._stringPool.stringForCode(readShort());
    }

    public String readType() {
        return readHandle();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005a  */
    public String readXmlValueObject() {
        String string;
        String type = readType();
        if (type == null) {
            return AbstractC1127c.NULL;
        }
        int i5 = readShort();
        if (i5 != 0) {
            switch (i5) {
                case 2:
                case 3:
                case 6:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    string = readString();
                    break;
                case 4:
                case 5:
                    string = new String(HexBin.encode(readByteArray()), StandardCharsets.ISO_8859_1);
                    if (string.length() > 19) {
                        string = ((Object) string.subSequence(0, 16)) + "...";
                    }
                    break;
                case 7:
                case 8:
                    string = QNameHelper.pretty(readQName());
                    break;
                case 9:
                case 10:
                    string = Double.toString(readDouble());
                    break;
                default:
                    string = "nil";
                    break;
            }
        } else {
            string = "nil";
        }
        return string + " (" + type + ": " + i5 + ")";
    }

    public String whitespaceCodeString(int i5) {
        if (i5 == 0) {
            return "WS_UNSPECIFIED";
        }
        if (i5 == 1) {
            return "WS_PRESERVE";
        }
        if (i5 != 2) {
            return i5 != 3 ? androidx.collection.a.i(i5, "Unknown whitespace code (", ")") : "WS_COLLAPSE";
        }
        return "WS_REPLACE";
    }

    public void error(String str) {
        this._out.println(str);
        flush();
        throw new IllegalStateException(str);
    }

    public static void dump(InputStream inputStream) {
        dump(inputStream, "", System.out);
    }

    public static void dump(InputStream inputStream, String str) {
        dump(inputStream, str, System.out);
    }

    public static void dump(InputStream inputStream, String str, PrintStream printStream) {
        new XsbDumper(inputStream, str, printStream).dumpAll();
    }
}
