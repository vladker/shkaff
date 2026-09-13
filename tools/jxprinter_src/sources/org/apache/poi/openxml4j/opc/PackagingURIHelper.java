package org.apache.poi.openxml4j.opc;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PackagingURIHelper {
    public static final PackagePartName CORE_PROPERTIES_PART_NAME;
    public static final URI CORE_PROPERTIES_URI;
    public static final char FORWARD_SLASH_CHAR = '/';
    public static final String FORWARD_SLASH_STRING = "/";
    private static final Logger LOG = LogManager.getLogger((Class<?>) PackagingURIHelper.class);
    public static final String PACKAGE_CORE_PROPERTIES_NAME = "core.xml";
    public static final String PACKAGE_PROPERTIES_SEGMENT_NAME = "docProps";
    public static final PackagePartName PACKAGE_RELATIONSHIPS_ROOT_PART_NAME;
    public static final URI PACKAGE_RELATIONSHIPS_ROOT_URI;
    public static final PackagePartName PACKAGE_ROOT_PART_NAME;
    public static final URI PACKAGE_ROOT_URI;
    public static final String RELATIONSHIP_PART_EXTENSION_NAME = ".rels";
    public static final String RELATIONSHIP_PART_SEGMENT_NAME = "_rels";
    private static final char[] hexDigits;
    private static final Pattern missingAuthPattern;
    private static URI packageRootUri;

    static {
        URI uri;
        URI uri2;
        URI uri3;
        PackagePartName packagePartNameCreatePartName;
        PackagePartName packagePartNameCreatePartName2;
        PackagePartName packagePartName = null;
        try {
            uri = new URI(FORWARD_SLASH_STRING);
            try {
                uri2 = new URI("/_rels/.rels");
                try {
                    packageRootUri = new URI(FORWARD_SLASH_STRING);
                    uri3 = new URI("/docProps/core.xml");
                } catch (URISyntaxException unused) {
                    uri3 = null;
                }
            } catch (URISyntaxException unused2) {
                uri2 = null;
            }
        } catch (URISyntaxException unused3) {
            uri = null;
            uri2 = null;
        }
        PACKAGE_ROOT_URI = uri;
        PACKAGE_RELATIONSHIPS_ROOT_URI = uri2;
        CORE_PROPERTIES_URI = uri3;
        try {
            packagePartNameCreatePartName2 = createPartName(uri2);
            try {
                packagePartNameCreatePartName = createPartName(uri3);
                try {
                    packagePartName = new PackagePartName(uri, false);
                } catch (InvalidFormatException unused4) {
                }
            } catch (InvalidFormatException unused5) {
                packagePartNameCreatePartName = null;
            }
        } catch (InvalidFormatException unused6) {
            packagePartNameCreatePartName = null;
            packagePartNameCreatePartName2 = null;
        }
        PACKAGE_RELATIONSHIPS_ROOT_PART_NAME = packagePartNameCreatePartName2;
        CORE_PROPERTIES_PART_NAME = packagePartNameCreatePartName;
        PACKAGE_ROOT_PART_NAME = packagePartName;
        missingAuthPattern = Pattern.compile("\\w+://");
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static URI combine(URI uri, URI uri2) {
        try {
            return new URI(combine(uri.getPath(), uri2.getPath()));
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Prefix and suffix can't be combine !");
        }
    }

    public static PackagePartName createPartName(URI uri) {
        if (uri != null) {
            return new PackagePartName(uri, true);
        }
        throw new IllegalArgumentException("partName");
    }

    public static String decodeURI(URI uri) {
        StringBuilder sb = new StringBuilder(64);
        String aSCIIString = uri.toASCIIString();
        int length = aSCIIString.length();
        int i5 = 0;
        while (i5 < length) {
            char cCharAt = aSCIIString.charAt(i5);
            if (cCharAt != '%') {
                sb.append(cCharAt);
            } else {
                if (length - i5 < 2) {
                    throw new IllegalArgumentException(AbstractC0157z.o("The uri ", aSCIIString, " contain invalid encoded character !"));
                }
                sb.append((char) Integer.parseInt(aSCIIString.substring(i5 + 1, i5 + 3), 16));
                i5 += 2;
            }
            i5++;
        }
        return sb.toString();
    }

    public static String encode(String str) {
        if (str.length() == 0) {
            return str;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        while (byteBufferWrap.hasRemaining()) {
            byte b = byteBufferWrap.get();
            int i5 = b & UnsignedBytes.MAX_VALUE;
            if (isUnsafe(i5)) {
                sb.append('%');
                char[] cArr = hexDigits;
                sb.append(cArr[(i5 >> 4) & 15]);
                sb.append(cArr[b & 15]);
            } else {
                sb.append((char) i5);
            }
        }
        return sb.toString();
    }

    public static String getFilename(URI uri) {
        if (uri == null) {
            return "";
        }
        String path = uri.getPath();
        int length = path.length();
        int i5 = length;
        while (true) {
            int i6 = i5 - 1;
            if (i6 < 0) {
                return "";
            }
            if (path.charAt(i6) == '/') {
                return path.substring(i5, length);
            }
            i5 = i6;
        }
    }

    public static String getFilenameWithoutExtension(URI uri) {
        String filename = getFilename(uri);
        int iLastIndexOf = filename.lastIndexOf(46);
        return iLastIndexOf == -1 ? filename : filename.substring(0, iLastIndexOf);
    }

    public static URI getPackageRootUri() {
        return packageRootUri;
    }

    public static URI getPath(URI uri) {
        if (uri != null) {
            String path = uri.getPath();
            int length = path.length();
            do {
                length--;
                if (length >= 0) {
                }
            } while (path.charAt(length) != '/');
            return new URI(path.substring(0, length));
        }
        return null;
    }

    public static PackagePartName getRelationshipPartName(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        if (PACKAGE_ROOT_URI.getPath().equals(packagePartName.getURI().getPath())) {
            return PACKAGE_RELATIONSHIPS_ROOT_PART_NAME;
        }
        if (packagePartName.isRelationshipPartURI()) {
            throw new InvalidOperationException("Can't be a relationship part");
        }
        String path = packagePartName.getURI().getPath();
        String filename = getFilename(packagePartName.getURI());
        try {
            return createPartName(androidx.collection.a.n(combine(combine(path.substring(0, path.length() - filename.length()), RELATIONSHIP_PART_SEGMENT_NAME), filename), RELATIONSHIP_PART_EXTENSION_NAME));
        } catch (InvalidFormatException unused) {
            return null;
        }
    }

    public static URI getSourcePartUriFromRelationshipPartUri(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Must not be null");
        }
        if (!isRelationshipPartURI(uri)) {
            throw new IllegalArgumentException("Must be a relationship part");
        }
        if (uri.compareTo(PACKAGE_RELATIONSHIPS_ROOT_URI) == 0) {
            return PACKAGE_ROOT_URI;
        }
        String path = uri.getPath();
        String filenameWithoutExtension = getFilenameWithoutExtension(uri);
        String strSubstring = path.substring(0, (path.length() - filenameWithoutExtension.length()) - 5);
        return getURIFromPath(combine(strSubstring.substring(0, strSubstring.length() - 6), filenameWithoutExtension));
    }

    public static URI getURIFromPath(String str) {
        try {
            return toURI(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("path");
        }
    }

    public static boolean isRelationshipPartURI(URI uri) {
        if (uri != null) {
            return uri.getPath().matches(".*_rels.*.rels$");
        }
        throw new IllegalArgumentException("partUri");
    }

    private static boolean isUnsafe(int i5) {
        return i5 >= 128 || i5 == 124 || Character.isWhitespace(i5);
    }

    public static boolean isValidPartName(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        try {
            createPartName(uri);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static URI relativizeURI(URI uri, URI uri2, boolean z6) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = uri.getPath().split(FORWARD_SLASH_STRING, -1);
        String[] strArrSplit2 = uri2.getPath().split(FORWARD_SLASH_STRING, -1);
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("Can't relativize an empty source URI !");
        }
        if (strArrSplit2.length == 0) {
            throw new IllegalArgumentException("Can't relativize an empty target URI !");
        }
        if (uri.toString().equals(FORWARD_SLASH_STRING)) {
            String path = uri2.getPath();
            if (!z6 || path.length() <= 0 || path.charAt(0) != '/') {
                return uri2;
            }
            try {
                return new URI(path.substring(1));
            } catch (Exception e) {
                LOG.atWarn().withThrowable(e).log("Failed to relativize");
                return null;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < strArrSplit.length && i6 < strArrSplit2.length && strArrSplit[i6].equals(strArrSplit2[i6]); i6++) {
            i5++;
        }
        if ((i5 == 0 || i5 == 1) && strArrSplit[0].isEmpty() && strArrSplit2[0].isEmpty()) {
            for (int i7 = 0; i7 < strArrSplit.length - 2; i7++) {
                sb.append("../");
            }
            for (int i8 = 0; i8 < strArrSplit2.length; i8++) {
                if (!strArrSplit2[i8].isEmpty()) {
                    sb.append(strArrSplit2[i8]);
                    if (i8 != strArrSplit2.length - 1) {
                        sb.append(FORWARD_SLASH_STRING);
                    }
                }
            }
            try {
                return new URI(sb.toString());
            } catch (Exception e6) {
                LOG.atWarn().withThrowable(e6).log("Failed to relativize");
                return null;
            }
        }
        if (i5 != strArrSplit.length || i5 != strArrSplit2.length) {
            if (i5 == 1) {
                sb.append(FORWARD_SLASH_STRING);
            } else {
                for (int i9 = i5; i9 < strArrSplit.length - 1; i9++) {
                    sb.append("../");
                }
            }
            while (i5 < strArrSplit2.length) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '/') {
                    sb.append(FORWARD_SLASH_STRING);
                }
                sb.append(strArrSplit2[i5]);
                i5++;
            }
        } else if (uri.equals(uri2)) {
            sb.append(strArrSplit[strArrSplit.length - 1]);
        }
        String rawFragment = uri2.getRawFragment();
        if (rawFragment != null) {
            sb.append("#");
            sb.append(rawFragment);
        }
        try {
            return new URI(sb.toString());
        } catch (Exception e7) {
            LOG.atWarn().withThrowable(e7).log("Failed to relativize");
            return null;
        }
    }

    public static URI resolvePartUri(URI uri, URI uri2) {
        if (uri == null || uri.isAbsolute()) {
            throw new IllegalArgumentException("sourcePartUri invalid - " + uri);
        }
        if (uri2 != null && !uri2.isAbsolute()) {
            return uri.resolve(uri2);
        }
        throw new IllegalArgumentException("targetUri invalid - " + uri2);
    }

    public static URI toURI(String str) {
        if (str.contains("\\")) {
            str = str.replace(IOUtils.DIR_SEPARATOR_WINDOWS, '/');
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            StringBuilder sbX = AbstractC0157z.x(strSubstring, "#");
            sbX.append(encode(strSubstring2));
            str = sbX.toString();
        }
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            while (length >= 0) {
                char cCharAt = str.charAt(length);
                if (!Character.isWhitespace(cCharAt) && cCharAt != 160) {
                    break;
                }
                sb.append(cCharAt);
                length--;
            }
            if (sb.length() > 0) {
                str = str.substring(0, length + 1) + encode(sb.reverse().toString());
            }
        }
        if (missingAuthPattern.matcher(str).matches()) {
            str = androidx.collection.a.n(str, FORWARD_SLASH_STRING);
        }
        return new URI(str);
    }

    public static String combine(String str, String str2) {
        if (!str.endsWith(FORWARD_SLASH_STRING) && !str2.startsWith(FORWARD_SLASH_STRING)) {
            return str + '/' + str2;
        }
        if (str2.startsWith(FORWARD_SLASH_STRING) ^ str.endsWith(FORWARD_SLASH_STRING)) {
            return str.concat(str2);
        }
        return "";
    }

    public static PackagePartName createPartName(String str) {
        try {
            return createPartName(toURI(str));
        } catch (URISyntaxException e) {
            throw new InvalidFormatException(e.getMessage());
        }
    }

    public static PackagePartName createPartName(String str, PackagePart packagePart) throws InvalidFormatException {
        try {
            return createPartName(resolvePartUri(packagePart.getPartName().getURI(), new URI(str)));
        } catch (URISyntaxException e) {
            throw new InvalidFormatException(e.getMessage());
        }
    }

    public static PackagePartName createPartName(URI uri, PackagePart packagePart) {
        return createPartName(resolvePartUri(packagePart.getPartName().getURI(), uri));
    }

    public static URI relativizeURI(URI uri, URI uri2) {
        return relativizeURI(uri, uri2, false);
    }
}
