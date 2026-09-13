package cn.fly.tools.xcrash;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import cn.fly.commons.a.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f2030a = Pattern.compile("^(.*):\\s'(.*?)'$");
    private static final Pattern b = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern c = Pattern.compile("^pid:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern d = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Pattern e = Pattern.compile("^(\\d{20})_(.*)__(.*)$");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f2031f = new HashSet(Arrays.asList("Tombstone maker", "Crash type", "Start time", "Crash time", "App ID", "App version", "Rooted", "API level", "OS version", "Kernel version", "ABI list", "Manuf", "Brd", ExifInterface.TAG_MODEL, "Build_f", "ABI", "Abort message"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<String> f2032g = new HashSet(Arrays.asList("backtrace", "java stacktrace", "xcrash error", "xcrash error debug"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f2033h = new HashSet(Arrays.asList("foreground"));

    /* JADX INFO: renamed from: cn.fly.tools.xcrash.d$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2034a;

        static {
            int[] iArr = new int[a.values().length];
            f2034a = iArr;
            try {
                iArr[a.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2034a[a.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2034a[a.SECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum a {
        UNKNOWN,
        HEAD,
        SECTION
    }

    private d() {
    }

    public static Map<String, String> a(String str, String str2) throws IOException {
        HashMap map = new HashMap();
        if (str != null) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            a((Map<String, String>) map, bufferedReader, true);
            bufferedReader.close();
        }
        if (str2 != null) {
            BufferedReader bufferedReader2 = new BufferedReader(new StringReader(str2));
            a((Map<String, String>) map, bufferedReader2, false);
            bufferedReader2.close();
        }
        a(map, str);
        if (TextUtils.isEmpty((String) map.get("App version"))) {
            String appVersion = XCrash.getAppVersion();
            if (TextUtils.isEmpty(appVersion)) {
                appVersion = l.a("007IehSf_fi5fSelghVf");
            }
            map.put("App version", appVersion);
        }
        return map;
    }

    private static void a(Map<String, String> map, String str) {
        String strG;
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(map.get("Crash time"))) {
            map.put("Crash time", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date(new File(str).lastModified())));
        }
        String str2 = map.get("Start time");
        String str3 = map.get("App version");
        String str4 = map.get("pname");
        String str5 = map.get("Crash type");
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            String strSubstring = str.substring(str.lastIndexOf(47) + 1);
            if (!strSubstring.isEmpty() && strSubstring.startsWith("tombstone_")) {
                String strSubstring2 = strSubstring.substring(10);
                if (strSubstring2.endsWith(".java.xcrash")) {
                    if (TextUtils.isEmpty(str5)) {
                        map.put("Crash type", "java");
                    }
                    strG = androidx.collection.a.g(12, 0, strSubstring2);
                } else if (strSubstring2.endsWith(".native.xcrash")) {
                    if (TextUtils.isEmpty(str5)) {
                        map.put("Crash type", "native");
                    }
                    strG = androidx.collection.a.g(14, 0, strSubstring2);
                } else {
                    if (!strSubstring2.endsWith(".anr.xcrash")) {
                        return;
                    }
                    if (TextUtils.isEmpty(str5)) {
                        map.put("Crash type", "anr");
                    }
                    strG = androidx.collection.a.g(11, 0, strSubstring2);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                    Matcher matcher = e.matcher(strG);
                    if (matcher.find() && matcher.groupCount() == 3) {
                        if (TextUtils.isEmpty(str2)) {
                            map.put("Start time", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(new Date(Long.parseLong(matcher.group(1), 10) / 1000)));
                        }
                        if (TextUtils.isEmpty(str3)) {
                            map.put("App version", matcher.group(2));
                        }
                        if (TextUtils.isEmpty(str4)) {
                            map.put("pname", matcher.group(3));
                        }
                    }
                }
            }
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        try {
            bufferedReader.mark(2);
            for (int i5 = 0; i5 < 2; i5++) {
                try {
                    int i6 = bufferedReader.read();
                    if (i6 == -1) {
                        bufferedReader.reset();
                        return null;
                    }
                    if (i6 > 0) {
                        bufferedReader.reset();
                        return bufferedReader.readLine();
                    }
                } catch (Exception unused) {
                    bufferedReader.reset();
                    return bufferedReader.readLine();
                }
            }
            bufferedReader.reset();
            return null;
        } catch (Exception unused2) {
            return bufferedReader.readLine();
        }
    }

    private static void a(Map<String, String> map, BufferedReader bufferedReader, boolean z6) {
        int i5;
        StringBuilder sb = new StringBuilder();
        a aVar = a.UNKNOWN;
        String strA = z6 ? a(bufferedReader) : bufferedReader.readLine();
        int i6 = 1;
        int i7 = strA == null ? 1 : 0;
        String strG = null;
        String str = "";
        boolean z7 = false;
        boolean zEquals = false;
        while (i7 == 0) {
            String strA2 = z6 ? a(bufferedReader) : bufferedReader.readLine();
            int i8 = strA2 == null ? i6 : 0;
            int i9 = AnonymousClass1.f2034a[aVar.ordinal()];
            if (i9 != i6) {
                int i10 = i6;
                if (i9 != 2) {
                    if (i9 == 3) {
                        if (!strA.equals(str) && i8 == 0) {
                            if (z7) {
                                if (strG.equals("java stacktrace") && strA.startsWith(" ")) {
                                    strA = strA.trim();
                                } else if (strA.startsWith("    ")) {
                                    strA = strA.substring(4);
                                }
                            }
                            sb.append(strA);
                            sb.append('\n');
                        } else {
                            if (f2033h.contains(strG) && sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            a(map, strG, sb.toString(), zEquals);
                            sb.setLength(0);
                            aVar = a.UNKNOWN;
                        }
                    }
                    i5 = i10;
                } else {
                    if (strA.startsWith("pid: ")) {
                        Matcher matcher = b.matcher(strA);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            a(map, "pname", matcher.group(4));
                        } else {
                            Matcher matcher2 = c.matcher(strA);
                            if (matcher2.find() && matcher2.groupCount() == 2) {
                                a(map, "pname", matcher2.group(2));
                            }
                        }
                    } else if (!strA.startsWith("signal ")) {
                        Matcher matcher3 = f2030a.matcher(strA);
                        if (matcher3.find() && matcher3.groupCount() == 2 && f2031f.contains(matcher3.group(i10))) {
                            a(map, matcher3.group(i10), matcher3.group(2));
                        }
                    }
                    if (strA2 != null && (strA2.startsWith("    r0 ") || strA2.startsWith("    x0 ") || strA2.startsWith("    eax ") || strA2.startsWith("    rax "))) {
                        aVar = a.SECTION;
                        strG = "registers";
                        str = "";
                        z7 = true;
                        zEquals = false;
                    }
                    if (strA2 == null || strA2.isEmpty()) {
                        aVar = a.UNKNOWN;
                    }
                    i5 = 1;
                }
            } else if (strA.equals("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***")) {
                aVar = a.HEAD;
                i5 = 1;
            } else if (strA.equals("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---")) {
                aVar = a.SECTION;
                sb.append(strA);
                sb.append('\n');
                str = "+++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++";
                z7 = false;
                zEquals = false;
                i5 = 1;
            } else {
                i5 = 1;
                if (strA.length() > 1 && strA.endsWith(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
                    aVar = a.SECTION;
                    strG = androidx.collection.a.g(1, 0, strA);
                    if (f2032g.contains(strG)) {
                        z7 = strG.equals("backtrace") || strG.equals("java stacktrace") || strG.equals("xcrash error debug");
                        zEquals = strG.equals("xcrash error");
                    } else {
                        if (!strG.equals("meminfo") && !strG.startsWith("memory near ")) {
                            z7 = false;
                            zEquals = false;
                        }
                        str = "";
                    }
                    str = "";
                }
            }
            strA = strA2;
            i7 = i8;
            i6 = i5;
        }
    }

    private static void a(Map<String, String> map, String str, String str2) {
        a(map, str, str2, false);
    }

    private static void a(Map<String, String> map, String str, String str2, boolean z6) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        String str3 = map.get(str);
        if (z6) {
            if (str3 != null) {
                str2 = str3.concat(str2);
            }
            map.put(str, str2);
        } else if (str3 == null || (str3.isEmpty() && !str2.isEmpty())) {
            map.put(str, str2);
        }
    }
}
