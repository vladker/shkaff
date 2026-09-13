package org.apache.xmlbeans.impl.tool;

import W2.b;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.attribute.FileAttribute;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.impl.common.IOUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CodeGenUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DEFAULT_COMPILER = "javac";
    public static final String DEFAULT_MEM_MAX = "256m";
    public static final String DEFAULT_MEM_START = "8m";

    public static void addAllJavaFiles(List<File> list, List<String> list2) {
        for (File file : list) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles(new a(0));
                if (fileArrListFiles != null) {
                    addAllJavaFiles(Arrays.asList(fileArrListFiles), list2);
                }
            } else {
                list2.add(quoteAndEscapeFilename(file.getAbsolutePath()));
            }
        }
    }

    private static Thread copy(InputStream inputStream, StringBuilder sb) {
        Thread thread = new Thread(new b(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)), sb, 27));
        thread.start();
        return thread;
    }

    public static boolean externalCompile(List<File> list, File file, File[] fileArr, boolean z6) {
        return externalCompile(list, file, fileArr, z6, DEFAULT_COMPILER, null, DEFAULT_MEM_START, DEFAULT_MEM_MAX, false, false);
    }

    private static File findJavaTool(String str) {
        File file = new File(str);
        if (!file.isFile()) {
            File file2 = new File(androidx.collection.a.n(str, ".exe"));
            if (file2.isFile()) {
                return file2;
            }
            String property = SystemProperties.getProperty("java.home");
            String str2 = File.separator;
            File file3 = new File(property + str2 + ".." + str2 + "bin", str);
            if (file3.isFile()) {
                return file3;
            }
            File file4 = new File(file3.getPath() + ".exe");
            if (file4.isFile()) {
                return file4;
            }
            File file5 = new File(androidx.collection.a.o(property, str2, "bin"), str);
            if (file5.isFile()) {
                return file5;
            }
            File file6 = new File(file5.getPath() + ".exe");
            if (file6.isFile()) {
                return file6;
            }
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addAllJavaFiles$0(File file) {
        return (file.isFile() && file.getName().endsWith(".java")) || file.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$copy$2(BufferedReader bufferedReader, StringBuilder sb) {
        bufferedReader.lines().forEach(new com.idlefish.flutterboost.containers.a(sb, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$1(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("\n");
    }

    private static String quoteAndEscapeFilename(String str) {
        if (!str.contains(" ")) {
            return str;
        }
        return "\"" + str.replaceAll("\\\\", "\\\\\\\\") + "\"";
    }

    public static URI resolve(URI uri, URI uri2) {
        URI uriResolve = uri.resolve(uri2);
        if (Constants.FILE.equals(uriResolve.getScheme()) && !uri2.equals(uriResolve) && uri.getPath().startsWith("//") && !uriResolve.getPath().startsWith("//")) {
            try {
                return new URI(Constants.FILE, null, "///".concat(uriResolve.getPath()), uriResolve.getQuery(), uriResolve.getFragment());
            } catch (URISyntaxException unused) {
            }
        }
        return uriResolve;
    }

    public static File[] systemClasspath() {
        ArrayList arrayList = new ArrayList();
        CodeSource codeSource = CodeGenUtil.class.getProtectionDomain().getCodeSource();
        if (codeSource != null) {
            arrayList.add(new File(codeSource.getLocation().getPath()));
        } else {
            System.err.println("Can't determine path of xmlbeans-*.jar - specify classpath explicitly!");
        }
        String property = SystemProperties.getProperty("java.class.path");
        if (property != null) {
            for (String str : property.split(File.pathSeparator)) {
                arrayList.add(new File(str));
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static boolean externalCompile(List<File> list, File file, File[] fileArr, boolean z6, String str, String str2, String str3, boolean z7, boolean z8) {
        return externalCompile(list, file, fileArr, z6, str, null, str2, str3, z7, z8);
    }

    public static boolean externalCompile(List<File> list, File file, File[] fileArr, boolean z6, String str, String str2, String str3, String str4, boolean z7, boolean z8) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = DEFAULT_COMPILER;
        }
        arrayList.add(findJavaTool(str).getAbsolutePath());
        if (file == null) {
            file = new File(Consts.DOT);
        } else {
            arrayList.add("-d");
            arrayList.add(quoteAndEscapeFilename(file.getAbsolutePath()));
        }
        if (fileArr == null) {
            fileArr = systemClasspath();
        }
        if (fileArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.getAbsolutePath());
            for (File file2 : fileArr) {
                sb.append(File.pathSeparator);
                sb.append(file2.getAbsolutePath());
            }
            arrayList.add("-classpath");
            arrayList.add(quoteAndEscapeFilename(sb.toString()));
        }
        if (str2 == null) {
            str2 = "1.8";
        }
        arrayList.add("-source");
        arrayList.add(str2);
        arrayList.add("-target");
        arrayList.add(str2);
        arrayList.add(z6 ? "-g" : "-g:none");
        if (z8) {
            arrayList.add("-verbose");
        }
        addAllJavaFiles(list, arrayList);
        File file3 = null;
        try {
            file3 = Files.createTempFile(IOUtil.getTempDir(), DEFAULT_COMPILER, ".tmp", new FileAttribute[0]).toFile();
            BufferedWriter bufferedWriterNewBufferedWriter = Files.newBufferedWriter(file3.toPath(), StandardCharsets.ISO_8859_1, new OpenOption[0]);
            try {
                Iterator it = arrayList.iterator();
                it.next();
                while (it.hasNext()) {
                    bufferedWriterNewBufferedWriter.write((String) it.next());
                    bufferedWriterNewBufferedWriter.write(10);
                }
                if (bufferedWriterNewBufferedWriter != null) {
                    bufferedWriterNewBufferedWriter.close();
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(arrayList.get(0));
                if (str3 != null && str3.length() != 0) {
                    arrayList2.add("-J-Xms" + str3);
                }
                if (str4 != null && str4.length() != 0) {
                    arrayList2.add("-J-Xmx" + str4);
                }
                arrayList2.add("@" + file3.getAbsolutePath());
                arrayList = arrayList2;
                try {
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    if (z8) {
                        System.out.print("compile command:");
                        for (String str5 : strArr) {
                            System.out.print(" " + str5);
                        }
                        System.out.println();
                    }
                    Process processExec = Runtime.getRuntime().exec(strArr);
                    StringBuilder sb2 = new StringBuilder();
                    StringBuilder sb3 = new StringBuilder();
                    copy(processExec.getInputStream(), sb3);
                    copy(processExec.getErrorStream(), sb2);
                    processExec.waitFor();
                    if (z8 || processExec.exitValue() != 0) {
                        if (sb3.length() > 0) {
                            System.out.println(sb3.toString());
                            System.out.flush();
                        }
                        if (sb2.length() > 0) {
                            System.err.println(sb2.toString());
                            System.err.flush();
                        }
                        if (processExec.exitValue() != 0) {
                            return false;
                        }
                    }
                    if (file3 == null) {
                        return true;
                    }
                    file3.delete();
                    return true;
                } catch (Throwable th) {
                    System.err.println(th.toString());
                    System.err.println(th.getCause());
                    th.printStackTrace(System.err);
                    return false;
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (bufferedWriterNewBufferedWriter != null) {
                        try {
                            bufferedWriterNewBufferedWriter.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        } catch (Exception unused) {
            System.err.println("Could not create command-line file for javac");
        }
    }
}
