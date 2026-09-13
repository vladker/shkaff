package C1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {
    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j6 = 0;
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 == -1) {
                outputStream.flush();
                return j6;
            }
            outputStream.write(bArr, 0, i5);
            j6 += (long) i5;
        }
    }

    private a findAPKWithLibrary(Context context, String[] strArr, String str, i iVar) {
        String[] strArrSourceDirectories = sourceDirectories(context);
        int length = strArrSourceDirectories.length;
        int i5 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i5 >= length) {
                return null;
            }
            String str2 = strArrSourceDirectories[i5];
            int i6 = 0;
            while (true) {
                int i7 = i6 + 1;
                if (i6 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i6 = i7;
                }
            }
            if (zipFile != null) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i8 >= 5) {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                            break;
                        }
                    }
                    for (String str3 : strArr) {
                        StringBuilder sb = new StringBuilder("lib");
                        char c = File.separatorChar;
                        sb.append(c);
                        sb.append(str3);
                        sb.append(c);
                        sb.append(str);
                        String string = sb.toString();
                        iVar.log("Looking for %s in APK %s...", string, str2);
                        ZipEntry entry = zipFile.getEntry(string);
                        if (entry != null) {
                            return new a(zipFile, entry);
                        }
                    }
                    i8 = i9;
                }
            }
            i5++;
        }
    }

    private String[] getSupportedABIs(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c = File.separatorChar;
        sb.append(c);
        sb.append("([^\\");
        sb.append(c);
        sb.append("]*)");
        sb.append(c);
        sb.append(str);
        Pattern patternCompile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : sourceDirectories(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private String[] sourceDirectories(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // C1.d
    @SuppressLint({"SetWorldReadable"})
    public void installLibrary(Context context, String[] strArr, String str, File file, i iVar) throws Throwable {
        String[] supportedABIs;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        a aVar = null;
        Closeable closeable = null;
        try {
            a aVarFindAPKWithLibrary = findAPKWithLibrary(context, strArr, str, iVar);
            try {
                if (aVarFindAPKWithLibrary == null) {
                    try {
                        supportedABIs = getSupportedABIs(context, str);
                    } catch (Exception e) {
                        supportedABIs = new String[]{e.toString()};
                    }
                    throw new c(str, strArr, supportedABIs);
                }
                ZipFile zipFile = aVarFindAPKWithLibrary.f123a;
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 >= 5) {
                        iVar.log("FATAL! Couldn't extract the library from the APK!");
                        if (zipFile != null) {
                            break;
                        } else {
                            return;
                        }
                    }
                    iVar.log("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = zipFile.getInputStream(aVarFindAPKWithLibrary.b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        long jCopy = copy(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                        if (jCopy == file.length()) {
                                            closeSilently(inputStream);
                                            closeSilently(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            if (zipFile != null) {
                                                break;
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (FileNotFoundException | IOException unused) {
                                    } catch (Throwable th) {
                                        th = th;
                                        closeable = inputStream;
                                        closeSilently(closeable);
                                        closeSilently(fileOutputStream);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused2) {
                                    fileOutputStream = null;
                                } catch (IOException unused3) {
                                    fileOutputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = null;
                                }
                            } catch (FileNotFoundException unused4) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused5) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                            closeSilently(inputStream);
                            closeSilently(fileOutputStream);
                        }
                    } catch (IOException unused6) {
                    }
                    i5 = i6;
                }
                try {
                    zipFile.close();
                } catch (IOException unused7) {
                }
            } catch (Throwable th4) {
                th = th4;
                aVar = aVarFindAPKWithLibrary;
                if (aVar != null) {
                    try {
                        ZipFile zipFile2 = aVar.f123a;
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                    } catch (IOException unused8) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
