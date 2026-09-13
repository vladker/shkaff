package org.apache.poi.openxml4j.opc;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PackagePartName implements Comparable<PackagePartName> {
    private static final String RFC3986_PCHAR_AUTHORIZED_SUP = ":@";
    private static final String RFC3986_PCHAR_SUB_DELIMS = "!$&'()*+,;=";
    private static final String RFC3986_PCHAR_UNRESERVED_SUP = "-._~";
    private final boolean isRelationship;
    private final URI partNameURI;

    public PackagePartName(URI uri, boolean z6) throws InvalidFormatException {
        if (z6) {
            throwExceptionIfInvalidPartUri(uri);
        } else if (!PackagingURIHelper.PACKAGE_ROOT_URI.equals(uri)) {
            throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
        }
        this.partNameURI = uri;
        this.isRelationship = isRelationshipPartURI(uri);
    }

    private static void checkPCharCompliance(String str) throws InvalidFormatException {
        int length = str.length();
        int i5 = 0;
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            if (!isDigitOrLetter(cCharAt) && RFC3986_PCHAR_UNRESERVED_SUP.indexOf(cCharAt) <= -1 && RFC3986_PCHAR_AUTHORIZED_SUP.indexOf(cCharAt) <= -1 && RFC3986_PCHAR_SUB_DELIMS.indexOf(cCharAt) <= -1) {
                if (cCharAt != '%') {
                    throw new InvalidFormatException("A segment shall not hold any characters other than pchar characters. [M1.6]");
                }
                if (length - i5 >= 2) {
                    int i6 = i5 + 1;
                    if (isHexDigit(str.charAt(i6))) {
                        int i7 = i5 + 2;
                        if (isHexDigit(str.charAt(i7))) {
                            char c = (char) Integer.parseInt(str.substring(i6, i5 + 3), 16);
                            if (c == '/' || c == '\\') {
                                throw new InvalidFormatException("A segment shall not contain percent-encoded forward slash ('/'), or backward slash ('\\') characters. [M1.7]");
                            }
                            if (isDigitOrLetter(c) || RFC3986_PCHAR_UNRESERVED_SUP.indexOf(c) > -1) {
                                throw new InvalidFormatException("A segment shall not contain percent-encoded unreserved characters. [M1.8]");
                            }
                            i5 = i7;
                        }
                    }
                }
                throw new InvalidFormatException(AbstractC0157z.o("The segment ", str, " contain invalid encoded character !"));
            }
            i5++;
        }
    }

    public static int compare(PackagePartName packagePartName, PackagePartName packagePartName2) {
        return compare(packagePartName == null ? null : packagePartName.getName(), packagePartName2 != null ? packagePartName2.getName() : null);
    }

    private static boolean isDigitOrLetter(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    private static boolean isHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'F') {
            return c >= 'a' && c <= 'f';
        }
        return true;
    }

    private boolean isRelationshipPartURI(URI uri) {
        if (uri != null) {
            return uri.getPath().matches("^.*/_rels/.*\\.rels$");
        }
        throw new IllegalArgumentException("partUri");
    }

    private static void throwExceptionIfAbsoluteUri(URI uri) throws InvalidFormatException {
        if (uri.isAbsolute()) {
            throw new InvalidFormatException("Absolute URI forbidden: " + uri);
        }
    }

    private static void throwExceptionIfEmptyURI(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partURI");
        }
        String path = uri.getPath();
        if (path.length() == 0 || (path.length() == 1 && path.charAt(0) == '/')) {
            throw new InvalidFormatException("A part name shall not be empty [M1.1]: " + uri.getPath());
        }
    }

    private static void throwExceptionIfInvalidPartUri(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        throwExceptionIfEmptyURI(uri);
        throwExceptionIfAbsoluteUri(uri);
        throwExceptionIfPartNameNotStartsWithForwardSlashChar(uri);
        throwExceptionIfPartNameEndsWithForwardSlashChar(uri);
        throwExceptionIfPartNameHaveInvalidSegments(uri);
    }

    private static void throwExceptionIfPartNameEndsWithForwardSlashChar(URI uri) throws InvalidFormatException {
        String path = uri.getPath();
        if (path.length() <= 0 || path.charAt(path.length() - 1) != '/') {
            return;
        }
        throw new InvalidFormatException("A part name shall not have a forward slash as the last character [M1.5]: " + uri.getPath());
    }

    private static void throwExceptionIfPartNameHaveInvalidSegments(URI uri) throws InvalidFormatException {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        String[] strArrSplit = uri.toASCIIString().replaceFirst("^/", "").split(PackagingURIHelper.FORWARD_SLASH_STRING);
        if (strArrSplit.length < 1) {
            throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + uri.getPath());
        }
        for (String str : strArrSplit) {
            if (str == null || str.isEmpty()) {
                throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + uri.getPath());
            }
            if (str.endsWith(Consts.DOT)) {
                throw new InvalidFormatException("A segment shall not end with a dot ('.') character [M1.9]: " + uri.getPath());
            }
            if (str.replaceAll("\\\\.", "").isEmpty()) {
                throw new InvalidFormatException("A segment shall include at least one non-dot character. [M1.10]: " + uri.getPath());
            }
            checkPCharCompliance(str);
        }
    }

    private static void throwExceptionIfPartNameNotStartsWithForwardSlashChar(URI uri) throws InvalidFormatException {
        String path = uri.getPath();
        if (path.length() <= 0 || path.charAt(0) == '/') {
            return;
        }
        throw new InvalidFormatException("A part name shall start with a forward slash ('/') character [M1.4]: " + uri.getPath());
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackagePartName) && compare(getName(), ((PackagePartName) obj).getName()) == 0;
    }

    public String getExtension() {
        int iLastIndexOf;
        String path = this.partNameURI.getPath();
        return (path.length() <= 0 || (iLastIndexOf = path.lastIndexOf(46)) <= -1) ? "" : path.substring(iLastIndexOf + 1);
    }

    public String getName() {
        return getURI().toASCIIString();
    }

    public URI getURI() {
        return this.partNameURI;
    }

    public int hashCode() {
        return getName().toLowerCase(Locale.ROOT).hashCode();
    }

    public String toString() {
        return getName();
    }

    @Override // java.lang.Comparable
    public int compareTo(PackagePartName packagePartName) {
        return compare(this, packagePartName);
    }

    public boolean isRelationshipPartURI() {
        return this.isRelationship;
    }

    public static int compare(String str, String str2) {
        int i5 = 0;
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        if (str.equalsIgnoreCase(str2)) {
            return 0;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        String lowerCase2 = str2.toLowerCase(locale);
        int length = lowerCase.length();
        int length2 = lowerCase2.length();
        int i6 = 0;
        while (i5 < length && i6 < length2) {
            int i7 = i5 + 1;
            char cCharAt = lowerCase.charAt(i5);
            int i8 = i6 + 1;
            char cCharAt2 = lowerCase2.charAt(i6);
            if (Character.isDigit(cCharAt) && Character.isDigit(cCharAt2)) {
                while (i7 < length && Character.isDigit(lowerCase.charAt(i7))) {
                    i7++;
                }
                while (i8 < length2 && Character.isDigit(lowerCase2.charAt(i8))) {
                    i8++;
                }
                int iCompareTo = new BigInteger(lowerCase.substring(i5, i7)).compareTo(new BigInteger(lowerCase2.substring(i6, i8)));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            } else if (cCharAt != cCharAt2) {
                return cCharAt - cCharAt2;
            }
            i5 = i7;
            i6 = i8;
        }
        return length - length2;
    }

    public PackagePartName(String str, boolean z6) throws InvalidFormatException {
        try {
            URI uri = new URI(str);
            if (z6) {
                throwExceptionIfInvalidPartUri(uri);
            } else if (!PackagingURIHelper.PACKAGE_ROOT_URI.equals(uri)) {
                throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
            }
            this.partNameURI = uri;
            this.isRelationship = isRelationshipPartURI(uri);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("partName argmument is not a valid OPC part name !");
        }
    }
}
