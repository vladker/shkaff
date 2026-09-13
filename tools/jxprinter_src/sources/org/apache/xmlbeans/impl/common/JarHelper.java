package org.apache.xmlbeans.impl.common;

import androidx.collection.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JarHelper {
    private static final int BUFFER_SIZE = 2156;
    private static final char SEP = '/';
    private final byte[] mBuffer = new byte[BUFFER_SIZE];
    private boolean mVerbose = false;
    private String mDestJarName = "";

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 2) {
            System.err.println("Usage: JarHelper jarname.jar directory");
            return;
        }
        JarHelper jarHelper = new JarHelper();
        jarHelper.mVerbose = true;
        jarHelper.jarDir(new File(strArr[1]), new File(strArr[0]));
    }

    public void jarDir(File file, File file2) throws IOException {
        if (file == null || file2 == null) {
            throw new IllegalArgumentException();
        }
        this.mDestJarName = file2.getCanonicalPath();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            JarOutputStream jarOutputStream = new JarOutputStream(fileOutputStream);
            try {
                jarDir(file, jarOutputStream, null);
                jarOutputStream.close();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    public void setVerbose(boolean z6) {
        this.mVerbose = z6;
    }

    public void unjar(InputStream inputStream, File file) throws IOException {
        JarInputStream jarInputStream = new JarInputStream(inputStream);
        while (true) {
            try {
                JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
                if (nextJarEntry == null) {
                    jarInputStream.close();
                    return;
                }
                if (nextJarEntry.isDirectory()) {
                    File file2 = new File(file, nextJarEntry.getName());
                    if (!file2.getCanonicalFile().toPath().startsWith(file.getCanonicalFile().toPath())) {
                        throw new IOException("Entry is outside of the target directory " + nextJarEntry.getName());
                    }
                    file2.mkdir();
                    if (nextJarEntry.getTime() != -1) {
                        file2.setLastModified(nextJarEntry.getTime());
                    }
                } else {
                    byte[] bArr = new byte[BUFFER_SIZE];
                    File file3 = new File(file, nextJarEntry.getName());
                    if (!file3.getCanonicalFile().toPath().startsWith(file.getCanonicalFile().toPath())) {
                        throw new IOException("Entry is outside of the target directory: " + nextJarEntry.getName());
                    }
                    if (this.mVerbose) {
                        System.out.println("unjarring " + file3 + " from " + nextJarEntry.getName());
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BUFFER_SIZE);
                        while (true) {
                            try {
                                int i5 = jarInputStream.read(bArr, 0, BUFFER_SIZE);
                                if (i5 == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, i5);
                                }
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        if (nextJarEntry.getTime() != -1) {
                            file3.setLastModified(nextJarEntry.getTime());
                        }
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                            throw th5;
                        }
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    try {
                        jarInputStream.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        }
    }

    public void unjarDir(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            unjar(fileInputStream, file2);
            fileInputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void jarDir(File file, JarOutputStream jarOutputStream, String str) throws IOException {
        String string;
        if (this.mVerbose) {
            System.out.println("checking " + file);
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (str == null) {
                string = "";
            } else {
                StringBuilder sbR = a.r(str);
                sbR.append(file.getName());
                sbR.append('/');
                string = sbR.toString();
            }
            if (str != null) {
                JarEntry jarEntry = new JarEntry(string);
                jarEntry.setTime(file.lastModified());
                jarOutputStream.putNextEntry(jarEntry);
                jarOutputStream.flush();
                jarOutputStream.closeEntry();
            }
            if (list != null) {
                for (String str2 : list) {
                    jarDir(new File(file, str2), jarOutputStream, string);
                }
                return;
            }
            return;
        }
        if (file.getCanonicalPath().equals(this.mDestJarName)) {
            if (this.mVerbose) {
                System.out.println("skipping " + file.getPath());
                return;
            }
            return;
        }
        if (this.mVerbose) {
            System.out.println("adding " + file.getPath());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            JarEntry jarEntry2 = new JarEntry(str + file.getName());
            jarEntry2.setTime(file.lastModified());
            jarOutputStream.putNextEntry(jarEntry2);
            while (true) {
                int i5 = fileInputStream.read(this.mBuffer);
                if (i5 != -1) {
                    jarOutputStream.write(this.mBuffer, 0, i5);
                    if (this.mVerbose) {
                        System.out.println("wrote " + i5 + " bytes");
                    }
                } else {
                    jarOutputStream.flush();
                    jarOutputStream.closeEntry();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
