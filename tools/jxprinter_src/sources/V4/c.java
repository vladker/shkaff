package V4;

import U4.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.jsoup.nodes.i;
import org.jsoup.nodes.m;
import org.jsoup.nodes.s;
import org.jsoup.nodes.v;
import org.jsoup.parser.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f766a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
    public static final Charset b;
    public static final String c;
    public static final char[] d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        b = charsetForName;
        c = charsetForName.name();
        d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static void crossStreams(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i5);
            }
        }
    }

    private static b detectCharsetFromBom(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b6 = bArr[0];
        if ((b6 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b6 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new b("UTF-32", false);
        }
        if ((b6 == -2 && bArr[1] == -1) || (b6 == -1 && bArr[1] == -2)) {
            return new b("UTF-16", false);
        }
        if (b6 == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new b("UTF-8", true);
        }
        return null;
    }

    public static String getCharsetFromContentType(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f766a.matcher(str);
        if (matcher.find()) {
            return validateCharset(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static i load(File file, String str, String str2) {
        return load(file, str, str2, E.a());
    }

    /* JADX WARN: Code duplicated, block: B:100:0x018f A[Catch: all -> 0x0171, TRY_LEAVE, TryCatch #1 {all -> 0x0171, blocks: (B:83:0x015d, B:85:0x0161, B:89:0x016d, B:93:0x0173, B:94:0x0179, B:98:0x0185, B:100:0x018f, B:97:0x0181, B:104:0x0197, B:105:0x019d), top: B:113:0x015d, outer: #2, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x014b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x014d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0161 A[Catch: all -> 0x0171, TryCatch #1 {all -> 0x0171, blocks: (B:83:0x015d, B:85:0x0161, B:89:0x016d, B:93:0x0173, B:94:0x0179, B:98:0x0185, B:100:0x018f, B:97:0x0181, B:104:0x0197, B:105:0x019d), top: B:113:0x015d, outer: #2, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x016b  */
    /* JADX WARN: Code duplicated, block: B:88:0x016c  */
    /* JADX WARN: Code duplicated, block: B:96:0x017f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0181 A[Catch: all -> 0x0171, TryCatch #1 {all -> 0x0171, blocks: (B:83:0x015d, B:85:0x0161, B:89:0x016d, B:93:0x0173, B:94:0x0179, B:98:0x0185, B:100:0x018f, B:97:0x0181, B:104:0x0197, B:105:0x019d), top: B:113:0x015d, outer: #2, inners: #3 }] */
    public static i parseInputStream(InputStream inputStream, String str, String str2, E e) throws IOException {
        W4.a aVar;
        i iVar;
        boolean z6;
        boolean z7;
        v vVarAsXmlDeclaration;
        BufferedReader bufferedReader;
        Charset charsetForName;
        if (inputStream == null) {
            return new i(str2);
        }
        if (inputStream instanceof W4.a) {
            int i5 = W4.a.f827g;
            aVar = (W4.a) inputStream;
        } else {
            aVar = new W4.a(inputStream, 0);
        }
        try {
            aVar.mark(32768);
            ByteBuffer toByteBuffer = readToByteBuffer(aVar, 5119);
            boolean z8 = aVar.read() == -1;
            aVar.reset();
            b bVarDetectCharsetFromBom = detectCharsetFromBom(toByteBuffer);
            String strReplaceAll = bVarDetectCharsetFromBom != null ? bVarDetectCharsetFromBom.f765a : str;
            String str3 = c;
            Charset charset = b;
            if (strReplaceAll == null) {
                try {
                    CharBuffer charBufferDecode = charset.decode(toByteBuffer);
                    if (charBufferDecode.hasArray()) {
                        iVar = e.f7544a.parse(new CharArrayReader(charBufferDecode.array(), charBufferDecode.arrayOffset(), charBufferDecode.limit()), str2, e);
                    } else {
                        iVar = e.f7544a.parse(new StringReader(charBufferDecode.toString()), str2, e);
                    }
                    Y4.f fVarQ = iVar.Q("meta[http-equiv=content-type], meta[charset]");
                    int size = fVarQ.size();
                    int i6 = 0;
                    String strF = null;
                    while (i6 < size) {
                        Object obj = fVarQ.get(i6);
                        i6++;
                        m mVar = (m) obj;
                        if (mVar.o("http-equiv")) {
                            strF = getCharsetFromContentType(mVar.f(FirebaseAnalytics.Param.CONTENT));
                        }
                        if (strF == null && mVar.o("charset")) {
                            strF = mVar.f("charset");
                        }
                        if (strF != null) {
                            break;
                        }
                    }
                    if (strF != null || iVar.d.size() <= 0) {
                        z6 = false;
                        z7 = true;
                    } else {
                        z6 = false;
                        s sVar = (s) iVar.n().get(0);
                        if (sVar instanceof v) {
                            vVarAsXmlDeclaration = (v) sVar;
                            z7 = true;
                        } else {
                            if (sVar instanceof org.jsoup.nodes.e) {
                                org.jsoup.nodes.e eVar = (org.jsoup.nodes.e) sVar;
                                String strZ = eVar.z();
                                z7 = true;
                                if (strZ.length() > 1 && (strZ.startsWith("!") || strZ.startsWith("?"))) {
                                    vVarAsXmlDeclaration = eVar.asXmlDeclaration();
                                }
                            } else {
                                z7 = true;
                            }
                            vVarAsXmlDeclaration = null;
                        }
                        if (vVarAsXmlDeclaration != null && vVarAsXmlDeclaration.z().equalsIgnoreCase("xml")) {
                            strF = vVarAsXmlDeclaration.f("encoding");
                        }
                    }
                    String strValidateCharset = validateCharset(strF);
                    if (strValidateCharset == null || strValidateCharset.equalsIgnoreCase(str3)) {
                        if (z8) {
                            if (iVar == null) {
                                if (strReplaceAll == null) {
                                    strReplaceAll = str3;
                                }
                                bufferedReader = new BufferedReader(new InputStreamReader(aVar, strReplaceAll), 32768);
                                if (bVarDetectCharsetFromBom != null) {
                                    try {
                                        if (bVarDetectCharsetFromBom.b) {
                                            if (bufferedReader.skip(1L) == 1) {
                                                z7 = z6;
                                            }
                                            h.b(z7);
                                        }
                                    } catch (Throwable th) {
                                        bufferedReader.close();
                                        throw th;
                                    }
                                }
                                try {
                                    iVar = e.f7544a.parse(bufferedReader, str2, e);
                                    if (strReplaceAll.equals(str3)) {
                                        charsetForName = charset;
                                    } else {
                                        charsetForName = Charset.forName(strReplaceAll);
                                    }
                                    iVar.f7471g.b = charsetForName;
                                    if (!charsetForName.canEncode()) {
                                        iVar.U(charset);
                                    }
                                    bufferedReader.close();
                                } catch (j e6) {
                                    throw ((IOException) e6.getCause());
                                }
                            }
                            aVar.close();
                            return iVar;
                        }
                        aVar.close();
                        throw th;
                    }
                    strReplaceAll = strValidateCharset.trim().replaceAll("[\"']", "");
                } catch (j e7) {
                    throw ((IOException) e7.getCause());
                }
            } else {
                z6 = false;
                z7 = true;
                h.notEmpty(strReplaceAll, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            }
            iVar = null;
            if (iVar == null) {
                if (strReplaceAll == null) {
                    strReplaceAll = str3;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(aVar, strReplaceAll), 32768);
                if (bVarDetectCharsetFromBom != null) {
                    if (bVarDetectCharsetFromBom.b) {
                        if (bufferedReader.skip(1L) == 1) {
                            z7 = z6;
                        }
                        h.b(z7);
                    }
                }
                iVar = e.f7544a.parse(bufferedReader, str2, e);
                if (strReplaceAll.equals(str3)) {
                    charsetForName = charset;
                } else {
                    charsetForName = Charset.forName(strReplaceAll);
                }
                iVar.f7471g.b = charsetForName;
                if (!charsetForName.canEncode()) {
                    iVar.U(charset);
                }
                bufferedReader.close();
            }
            aVar.close();
            return iVar;
        } catch (Throwable th2) {
            aVar.close();
            throw th2;
        }
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i5) {
        W4.a aVar;
        h.a("maxSize must be 0 (unlimited) or larger", i5 >= 0);
        if (inputStream instanceof W4.a) {
            int i6 = W4.a.f827g;
            aVar = (W4.a) inputStream;
        } else {
            aVar = new W4.a(inputStream, i5);
        }
        return aVar.readToByteBuffer(i5);
    }

    private static String validateCharset(String str) {
        if (str != null && str.length() != 0) {
            String strReplaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(strReplaceAll)) {
                    return strReplaceAll;
                }
                String upperCase = strReplaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    public static i load(File file, String str, String str2, E e) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        String strI = p051j0.i.i(file.getName());
        if (strI.endsWith(".gz") || strI.endsWith(".z")) {
            try {
                boolean z6 = fileInputStream.read() == 31 && fileInputStream.read() == 139;
                fileInputStream.close();
                fileInputStream = z6 ? new GZIPInputStream(new FileInputStream(file)) : new FileInputStream(file);
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        }
        return parseInputStream(fileInputStream, str, str2, e);
    }

    public static i load(InputStream inputStream, String str, String str2) {
        return parseInputStream(inputStream, str, str2, E.a());
    }

    public static i load(InputStream inputStream, String str, String str2, E e) {
        return parseInputStream(inputStream, str, str2, e);
    }
}
