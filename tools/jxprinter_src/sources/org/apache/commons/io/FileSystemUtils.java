package org.apache.commons.io;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class FileSystemUtils {
    private static final String DF;
    private static final int INIT_PROBLEM = -1;
    private static final FileSystemUtils INSTANCE = new FileSystemUtils();
    private static final int OS;
    private static final int OTHER = 0;
    private static final int POSIX_UNIX = 3;
    private static final int UNIX = 2;
    private static final int WINDOWS = 1;

    static {
        int i5;
        String str = "df";
        try {
            String property = System.getProperty("os.name");
            if (property == null) {
                throw new IOException("os.name not found");
            }
            String lowerCase = property.toLowerCase(Locale.ENGLISH);
            if (lowerCase.contains("windows")) {
                i5 = 1;
            } else if (lowerCase.contains("linux") || lowerCase.contains("mpe/ix") || lowerCase.contains("freebsd") || lowerCase.contains("openbsd") || lowerCase.contains("irix") || lowerCase.contains("digital unix") || lowerCase.contains("unix") || lowerCase.contains("mac os x")) {
                i5 = 2;
            } else {
                if (lowerCase.contains("sun os") || lowerCase.contains("sunos") || lowerCase.contains("solaris")) {
                    str = "/usr/xpg4/bin/df";
                } else if (!lowerCase.contains("hp-ux") && !lowerCase.contains("aix")) {
                    i5 = 0;
                }
                i5 = 3;
            }
            OS = i5;
            DF = str;
        } catch (Exception unused) {
            i5 = -1;
        }
    }

    @Deprecated
    public static long freeSpace(String str) {
        return INSTANCE.freeSpaceOS(str, OS, false, Duration.ofMillis(-1L));
    }

    @Deprecated
    public static long freeSpaceKb(String str) {
        return freeSpaceKb(str, -1L);
    }

    public long freeSpaceOS(String str, int i5, boolean z6, Duration duration) throws Throwable {
        if (str == null) {
            throw new IllegalArgumentException("Path must not be null");
        }
        if (i5 == 0) {
            throw new IllegalStateException("Unsupported operating system");
        }
        if (i5 == 1) {
            long jFreeSpaceWindows = freeSpaceWindows(str, duration);
            return z6 ? jFreeSpaceWindows / 1024 : jFreeSpaceWindows;
        }
        if (i5 == 2) {
            return freeSpaceUnix(str, z6, false, duration);
        }
        if (i5 == 3) {
            return freeSpaceUnix(str, z6, true, duration);
        }
        throw new IllegalStateException("Exception caught when determining operating system");
    }

    public long freeSpaceUnix(String str, boolean z6, boolean z7, Duration duration) throws Throwable {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        String strN = z6 ? "-k" : ProcessIdUtil.DEFAULT_PROCESSID;
        if (z7) {
            strN = a.n(strN, "P");
        }
        List<String> listPerformCommand = performCommand(strN.length() > 1 ? new String[]{DF, strN, str} : new String[]{DF, str}, 3, duration);
        if (listPerformCommand.size() < 2) {
            StringBuilder sb = new StringBuilder("Command line '");
            a.y(sb, DF, "' did not return info as expected for path '", str, "'- response was ");
            sb.append(listPerformCommand);
            throw new IOException(sb.toString());
        }
        StringTokenizer stringTokenizer = new StringTokenizer(listPerformCommand.get(1), " ");
        if (stringTokenizer.countTokens() >= 4) {
            stringTokenizer.nextToken();
        } else {
            if (stringTokenizer.countTokens() != 1 || listPerformCommand.size() < 3) {
                throw new IOException(androidx.exifinterface.media.a.s(new StringBuilder("Command line '"), DF, "' did not return data as expected for path '", str, "'- check path is valid"));
            }
            stringTokenizer = new StringTokenizer(listPerformCommand.get(2), " ");
        }
        stringTokenizer.nextToken();
        stringTokenizer.nextToken();
        return parseBytes(stringTokenizer.nextToken(), str);
    }

    public long freeSpaceWindows(String str, Duration duration) throws Throwable {
        String strNormalize = FilenameUtils.normalize(str, false);
        if (strNormalize == null) {
            throw new IllegalArgumentException(str);
        }
        if (!strNormalize.isEmpty() && strNormalize.charAt(0) != '\"') {
            strNormalize = AbstractC0157z.o("\"", strNormalize, "\"");
        }
        List<String> listPerformCommand = performCommand(new String[]{"cmd.exe", "/C", AbstractC0157z.n("dir /a /-c ", strNormalize)}, Integer.MAX_VALUE, duration);
        for (int size = listPerformCommand.size() - 1; size >= 0; size--) {
            String str2 = listPerformCommand.get(size);
            if (!str2.isEmpty()) {
                return parseDir(str2, strNormalize);
            }
        }
        throw new IOException(AbstractC0157z.o("Command line 'dir /-c' did not return any info for path '", strNormalize, "'"));
    }

    public Process openProcess(String[] strArr) {
        return Runtime.getRuntime().exec(strArr);
    }

    public long parseBytes(String str, String str2) throws IOException {
        try {
            long j6 = Long.parseLong(str);
            if (j6 >= 0) {
                return j6;
            }
            throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + str2 + "'- check path is valid");
        } catch (NumberFormatException e) {
            throw new IOException(androidx.exifinterface.media.a.s(new StringBuilder("Command line '"), DF, "' did not return numeric data as expected for path '", str2, "'- check path is valid"), e);
        }
    }

    public long parseDir(String str, String str2) throws IOException {
        int i5;
        int i6;
        int i7;
        int length = str.length();
        while (true) {
            length--;
            i5 = 0;
            if (length < 0) {
                i6 = 0;
                break;
            }
            if (Character.isDigit(str.charAt(length))) {
                i6 = length + 1;
                break;
            }
        }
        while (true) {
            if (length < 0) {
                i7 = 0;
                break;
            }
            char cCharAt = str.charAt(length);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != '.') {
                i7 = length + 1;
                break;
            }
            length--;
        }
        if (length < 0) {
            throw new IOException(AbstractC0157z.o("Command line 'dir /-c' did not return valid info for path '", str2, "'"));
        }
        StringBuilder sb = new StringBuilder(str.substring(i7, i6));
        while (i5 < sb.length()) {
            if (sb.charAt(i5) == ',' || sb.charAt(i5) == '.') {
                sb.deleteCharAt(i5);
                i5--;
            }
            i5++;
        }
        return parseBytes(sb.toString(), str2);
    }

    /* JADX WARN: Code duplicated, block: B:68:0x012e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public List<String> performCommand(String[] strArr, int i5, Duration duration) throws Throwable {
        Process processOpenProcess;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream errorStream;
        ?? bufferedReader;
        ?? r7;
        ArrayList arrayList = new ArrayList(20);
        InputStream inputStream2 = null;
        try {
            Thread threadStart = ThreadMonitor.start(duration);
            processOpenProcess = openProcess(strArr);
            try {
                inputStream = processOpenProcess.getInputStream();
                try {
                    outputStream = processOpenProcess.getOutputStream();
                    try {
                        errorStream = processOpenProcess.getErrorStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
                            try {
                                for (String line = bufferedReader.readLine(); line != null && arrayList.size() < i5; line = bufferedReader.readLine()) {
                                    arrayList.add(line.toLowerCase(Locale.ENGLISH).trim());
                                }
                                processOpenProcess.waitFor();
                                ThreadMonitor.stop(threadStart);
                                if (processOpenProcess.exitValue() != 0) {
                                    throw new IOException("Command line returned OS error code '" + processOpenProcess.exitValue() + "' for command " + Arrays.asList(strArr));
                                }
                                if (arrayList.isEmpty()) {
                                    throw new IOException("Command line did not return any info for command " + Arrays.asList(strArr));
                                }
                                bufferedReader.close();
                                inputStream.close();
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                        outputStream = null;
                                    } catch (InterruptedException e) {
                                        e = e;
                                        inputStream = null;
                                        bufferedReader = 0;
                                    } catch (Throwable th) {
                                        th = th;
                                        r7 = 0;
                                        IOUtils.closeQuietly(inputStream2);
                                        IOUtils.closeQuietly(outputStream);
                                        IOUtils.closeQuietly(errorStream);
                                        IOUtils.closeQuietly((Reader) r7);
                                        if (processOpenProcess != null) {
                                            processOpenProcess.destroy();
                                        }
                                        throw th;
                                    }
                                }
                                if (errorStream != null) {
                                    errorStream.close();
                                    errorStream = null;
                                }
                                IOUtils.closeQuietly((InputStream) null);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(errorStream);
                                IOUtils.closeQuietly((Reader) null);
                                processOpenProcess.destroy();
                                return arrayList;
                            } catch (InterruptedException e6) {
                                e = e6;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                r7 = bufferedReader;
                                IOUtils.closeQuietly(inputStream2);
                                IOUtils.closeQuietly(outputStream);
                                IOUtils.closeQuietly(errorStream);
                                IOUtils.closeQuietly((Reader) r7);
                                if (processOpenProcess != null) {
                                    processOpenProcess.destroy();
                                }
                                throw th;
                            }
                        } catch (InterruptedException e7) {
                            e = e7;
                            bufferedReader = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                        }
                    } catch (InterruptedException e8) {
                        e = e8;
                        errorStream = null;
                        bufferedReader = errorStream;
                    } catch (Throwable th4) {
                        th = th4;
                        errorStream = null;
                        bufferedReader = errorStream;
                        inputStream2 = inputStream;
                        r7 = bufferedReader;
                        IOUtils.closeQuietly(inputStream2);
                        IOUtils.closeQuietly(outputStream);
                        IOUtils.closeQuietly(errorStream);
                        IOUtils.closeQuietly((Reader) r7);
                        if (processOpenProcess != null) {
                            processOpenProcess.destroy();
                        }
                        throw th;
                    }
                } catch (InterruptedException e9) {
                    e = e9;
                    outputStream = null;
                    errorStream = outputStream;
                    bufferedReader = errorStream;
                    inputStream2 = processOpenProcess;
                    bufferedReader = bufferedReader;
                    throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + duration, e);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    errorStream = null;
                }
            } catch (InterruptedException e10) {
                e = e10;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                errorStream = outputStream;
                r7 = errorStream;
                IOUtils.closeQuietly(inputStream2);
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(errorStream);
                IOUtils.closeQuietly((Reader) r7);
                if (processOpenProcess != null) {
                    processOpenProcess.destroy();
                }
                throw th;
            }
            inputStream2 = processOpenProcess;
            bufferedReader = bufferedReader;
        } catch (InterruptedException e11) {
            e = e11;
            inputStream = null;
            outputStream = null;
            errorStream = null;
            bufferedReader = 0;
        } catch (Throwable th7) {
            th = th7;
            processOpenProcess = null;
            outputStream = null;
        }
        try {
            throw new IOException("Command line threw an InterruptedException for command " + Arrays.asList(strArr) + " timeout=" + duration, e);
        } catch (Throwable th8) {
            th = th8;
            processOpenProcess = inputStream2;
            inputStream2 = inputStream;
            r7 = bufferedReader;
            IOUtils.closeQuietly(inputStream2);
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(errorStream);
            IOUtils.closeQuietly((Reader) r7);
            if (processOpenProcess != null) {
                processOpenProcess.destroy();
            }
            throw th;
        }
    }

    @Deprecated
    public static long freeSpaceKb(String str, long j6) {
        return INSTANCE.freeSpaceOS(str, OS, true, Duration.ofMillis(j6));
    }

    @Deprecated
    public static long freeSpaceKb() {
        return freeSpaceKb(-1L);
    }

    @Deprecated
    public static long freeSpaceKb(long j6) {
        return freeSpaceKb(new File(Consts.DOT).getAbsolutePath(), j6);
    }
}
