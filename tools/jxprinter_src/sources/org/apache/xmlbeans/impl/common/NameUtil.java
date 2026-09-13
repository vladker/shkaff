package org.apache.xmlbeans.impl.common;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.xml.namespace.QName;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class NameUtil {
    public static final char AYAH = 1757;
    public static final char COLON = ':';
    private static final int DIGIT = 2;
    public static final char DOT = 183;
    public static final char ELHIZB = 1758;
    public static final char HYPHEN = '-';
    private static final String JAVA_NS_PREFIX = "java:";
    private static final int LOWER = 5;
    private static final int MARK = 3;
    private static final int NOCASE = 6;
    public static final char PERIOD = '.';
    private static final int PUNCT = 1;
    private static final int START = 0;
    public static final char TELEIA = 903;
    private static final int UPPER = 4;
    public static final char USCORE = '_';
    private static final Set<String> javaWords = new HashSet(Arrays.asList("assert", "abstract", "boolean", "break", "byte", "case", "catch", "char", Constants.CLASS, "const", "continue", "default", "do", XmlErrorCodes.DOUBLE, "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", XmlErrorCodes.INT, "interface", XmlErrorCodes.LONG, "native", "new", AbstractC1127c.NULL, "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "threadsafe", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"));
    private static final Set<String> extraWords = new HashSet(Arrays.asList(Complex.DEFAULT_SUFFIX, TypedValues.AttributesType.S_TARGET, "org", "com"));
    private static final Set<String> javaNames = new HashSet(Arrays.asList("CharSequence", "Cloneable", "Comparable", "Runnable", "Boolean", "Byte", "Character", "Class", "ClassLoader", "Compiler", "Double", "Float", "InheritableThreadLocal", "Integer", "Long", "Math", "Number", "Object", ExtractorFactory.OOXML_PACKAGE, "Process", "Runtime", "RuntimePermission", "SecurityManager", "Short", "StackTraceElement", "StrictMath", "String", "StringBuffer", "System", "Thread", "ThreadGroup", "ThreadLocal", "Throwable", "Void", "ArithmeticException", "ArrayIndexOutOfBoundsException", "ArrayStoreException", "ClassCastException", "ClassNotFoundException", "CloneNotSupportedException", "Exception", "IllegalAccessException", "IllegalArgumentException", "IllegalMonitorStateException", "IllegalStateException", "IllegalThreadStateException", "IndexOutOfBoundsException", "InstantiationException", "InterruptedException", "NegativeArraySizeException", "NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException", "RuntimeException", "SecurityException", "StringIndexOutOfBoundsException", "UnsupportedOperationException", "AbstractMethodError", "AssertionError", "ClassCircularityError", "ClassFormatError", "Error", "ExceptionInInitializerError", "IllegalAccessError", "IncompatibleClassChangeError", "InstantiationError", "InternalError", "LinkageError", "NoClassDefFoundError", "NoSuchFieldError", "NoSuchMethodError", "OutOfMemoryError", "StackOverflowError", "ThreadDeath", "UnknownError", "UnsatisfiedLinkError", "UnsupportedClassVersionError", "VerifyError", "VirtualMachineError", "BigInteger", "BigDecimal", "Enum", HttpHeaders.DATE, "GDate", "GDuration", XmlErrorCodes.QNAME, "List", "XmlObject", "XmlCursor", "XmlBeans", "SchemaType"));

    private static void addCapped(List<String> list, String str) {
        if (str.length() > 0) {
            list.add(upperCaseFirstLetter(str));
        }
    }

    private static int findSchemeColon(String str) {
        int length = str.length();
        if (length == 0 || !isUriAlphaChar(str.charAt(0))) {
            return -1;
        }
        int i5 = 1;
        while (i5 < length && isUriSchemeChar(str.charAt(i5))) {
            i5++;
        }
        if (i5 == length || str.charAt(i5) != ':') {
            return -1;
        }
        while (i5 < length && str.charAt(i5) == ':') {
            i5++;
        }
        return i5 - 1;
    }

    public static int getCharClass(char c, boolean z6) {
        if (isPunctuation(c, z6)) {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        if (Character.isUpperCase(c)) {
            return 4;
        }
        if (Character.isLowerCase(c)) {
            return 5;
        }
        if (Character.isLetter(c)) {
            return 6;
        }
        return Character.isJavaIdentifierPart(c) ? 3 : 1;
    }

    public static String getClassNameFromQName(QName qName) {
        return getClassNameFromQName(qName, false);
    }

    public static String getNamespaceFromPackage(Class<?> cls) {
        for (Class<?> componentType = cls; componentType.isArray(); componentType = componentType.getComponentType()) {
        }
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return AbstractC0157z.n(JAVA_NS_PREFIX, iLastIndexOf < 0 ? "" : name.substring(0, iLastIndexOf));
    }

    public static String getPackageFromNamespace(String str) {
        return getPackageFromNamespace(str, false);
    }

    private static boolean isExtraReservedWord(String str) {
        return extraWords.contains(str.toLowerCase(Locale.ROOT));
    }

    public static boolean isJavaCommonClassName(String str) {
        return javaNames.contains(str);
    }

    private static boolean isJavaReservedWord(String str) {
        return javaWords.contains(str.toLowerCase(Locale.ROOT));
    }

    private static boolean isLetter(int i5) {
        return i5 == 4 || i5 == 5 || i5 == 6;
    }

    public static boolean isPunctuation(char c, boolean z6) {
        if (c == '-' || c == '.' || c == ':' || c == 183) {
            return true;
        }
        return (c == '_' && !z6) || c == 903 || c == 1757 || c == 1758;
    }

    private static boolean isUriAlphaChar(char c) {
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    private static boolean isUriSchemeChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c < 'A' || c > 'Z') {
            return (c >= '0' && c <= '9') || c == '-' || c == '.' || c == '+';
        }
        return true;
    }

    public static boolean isValidJavaIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        int length = str.length();
        if (length == 0 || javaWords.contains(str) || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i5 = 1; i5 < length; i5++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    private static String jls77String(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (!Character.isJavaIdentifierPart(sb.charAt(i5)) || '$' == sb.charAt(i5)) {
                sb.setCharAt(i5, USCORE);
            }
        }
        if (sb.length() == 0 || !Character.isJavaIdentifierStart(sb.charAt(0))) {
            sb.insert(0, USCORE);
        }
        if (isJavaReservedWord(str)) {
            sb.append(USCORE);
        }
        return sb.toString();
    }

    public static String lowerCamelCase(String str) {
        return lowerCamelCase(str, false, true);
    }

    public static void main(String[] strArr) {
        for (String str : strArr) {
            System.out.println(upperCaseUnderbar(str));
        }
    }

    public static String nonExtraKeyword(String str) {
        return isExtraReservedWord(str) ? a.n(str, "Value") : str;
    }

    public static String nonJavaCommonClassName(String str) {
        return isJavaCommonClassName(str) ? AbstractC0157z.n("X", str) : str;
    }

    public static String nonJavaKeyword(String str) {
        return isJavaReservedWord(str) ? AbstractC0157z.n("x", str) : str;
    }

    private static String processFilename(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            return (iLastIndexOf + 3 == str.length() || iLastIndexOf + 4 == str.length() || "html".equals(str.substring(iLastIndexOf + 1).toLowerCase(Locale.ROOT))) ? str.substring(0, iLastIndexOf) : str;
        }
        return str;
    }

    private static List<String> splitDNS(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        for (int iLastIndexOf = str.lastIndexOf(46); iLastIndexOf != -1; iLastIndexOf--) {
            if (str.charAt(iLastIndexOf) == '.') {
                arrayList.add(jls77String(str.substring(iLastIndexOf + 1, length)));
                length = iLastIndexOf;
            }
        }
        arrayList.add(jls77String(str.substring(0, length)));
        if (arrayList.size() >= 3 && ((String) a.e(arrayList, 1)).toLowerCase(Locale.ROOT).equals("www")) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public static List<String> splitWords(String str, boolean z6) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int charClass = getCharClass(str.charAt(i5), z6);
            if (i7 != 1 && charClass == 1) {
                addCapped(arrayList, str.substring(i6, i5));
                do {
                    int charClass2 = getCharClass(str.charAt(i5), z6);
                    if (charClass2 == 1) {
                        i5++;
                    } else {
                        i7 = charClass2;
                        i6 = i5;
                    }
                } while (i5 < length);
                return arrayList;
            }
            if ((i7 == 2) != (charClass == 2) || ((i7 == 5 && charClass != 5) || isLetter(i7) != isLetter(charClass))) {
                addCapped(arrayList, str.substring(i6, i5));
                i6 = i5;
            } else if (i7 == 4 && charClass == 5 && i5 > i6 + 1) {
                int i8 = i5 - 1;
                addCapped(arrayList, str.substring(i6, i8));
                i6 = i8;
            }
            i7 = charClass;
            i5++;
        }
        addCapped(arrayList, str.substring(i6));
        return arrayList;
    }

    public static String upperCamelCase(String str) {
        return upperCamelCase(str, false);
    }

    public static String upperCaseFirstLetter(String str) {
        if (str.isEmpty() || Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }

    public static String upperCaseUnderbar(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> listSplitWords = splitWords(str, false);
        int size = listSplitWords.size() - 1;
        if (size >= 0 && !Character.isJavaIdentifierStart(listSplitWords.get(0).charAt(0))) {
            sb.append("X_");
        }
        for (int i5 = 0; i5 < size; i5++) {
            sb.append(listSplitWords.get(i5));
            sb.append(USCORE);
        }
        if (size >= 0) {
            sb.append(listSplitWords.get(size));
        }
        return sb.toString().toUpperCase(Locale.ROOT);
    }

    public static String getClassNameFromQName(QName qName, boolean z6) {
        String strUpperCamelCase = upperCamelCase(qName.getLocalPart(), z6);
        String packageFromNamespace = getPackageFromNamespace(qName.getNamespaceURI(), z6);
        return packageFromNamespace != null ? a.o(packageFromNamespace, Consts.DOT, strUpperCamelCase) : strUpperCamelCase;
    }

    public static String getPackageFromNamespace(String str, boolean z6) {
        List listAsList;
        if (str == null || str.length() == 0) {
            return "noNamespace";
        }
        int length = str.length();
        int iFindSchemeColon = findSchemeColon(str);
        if (iFindSchemeColon == length - 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str.substring(0, iFindSchemeColon));
            listAsList = arrayList;
        } else if (iFindSchemeColon < 0 || !str.substring(0, iFindSchemeColon).equals("java")) {
            ArrayList arrayList2 = new ArrayList();
            int i5 = iFindSchemeColon + 1;
            loop1: while (i5 < length) {
                while (str.charAt(i5) == '/') {
                    i5++;
                    if (i5 >= length) {
                        break loop1;
                    }
                }
                int i6 = i5;
                while (str.charAt(i6) != '/' && (i6 = i6 + 1) < length) {
                }
                arrayList2.add(str.substring(i5, i6));
                i5 = i6;
            }
            if (arrayList2.size() > 1) {
                arrayList2.set(arrayList2.size() - 1, processFilename((String) a.e(arrayList2, 1)));
            }
            if (arrayList2.size() > 0) {
                List<String> listSplitDNS = splitDNS((String) arrayList2.get(0));
                arrayList2.remove(0);
                arrayList2.addAll(0, listSplitDNS);
            }
            listAsList = arrayList2;
        } else {
            listAsList = Arrays.asList(str.substring(iFindSchemeColon + 1).split("\\."));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            String strNonJavaKeyword = nonJavaKeyword(lowerCamelCase((String) it.next(), z6, true));
            if (strNonJavaKeyword.length() > 0) {
                sb.append(strNonJavaKeyword);
                sb.append('.');
            }
        }
        if (sb.length() == 0) {
            return "noNamespace";
        }
        return z6 ? sb.substring(0, sb.length() - 1).toLowerCase(Locale.ROOT) : sb.substring(0, sb.length() - 1);
    }

    public static String lowerCamelCase(String str, boolean z6, boolean z7) {
        StringBuilder sb = new StringBuilder();
        List<String> listSplitWords = splitWords(str, z6);
        if (listSplitWords.size() > 0) {
            String lowerCase = listSplitWords.get(0).toLowerCase(Locale.ROOT);
            if (!Character.isJavaIdentifierStart(lowerCase.charAt(0)) && z7) {
                sb.append("x");
            }
            sb.append(lowerCase);
            Iterator<String> it = listSplitWords.iterator();
            it.next();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        return sb.toString();
    }

    public static String upperCamelCase(String str, boolean z6) {
        StringBuilder sb = new StringBuilder();
        List<String> listSplitWords = splitWords(str, z6);
        if (listSplitWords.size() > 0) {
            if (!Character.isJavaIdentifierStart(listSplitWords.get(0).charAt(0))) {
                sb.append("X");
            }
            Iterator<String> it = listSplitWords.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        return sb.toString();
    }
}
