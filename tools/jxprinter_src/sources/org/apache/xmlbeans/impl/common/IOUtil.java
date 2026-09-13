package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class IOUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Path tmpdir = Paths.get(System.getProperty(TempFile.JAVA_IO_TMPDIR), new String[0]);

    public static void copyCompletely(InputStream inputStream, OutputStream outputStream) throws IOException {
        if ((outputStream instanceof FileOutputStream) && (inputStream instanceof FileInputStream)) {
            try {
                FileChannel channel = ((FileOutputStream) outputStream).getChannel();
                FileChannel channel2 = ((FileInputStream) inputStream).getChannel();
                channel2.transferTo(0L, 2147483647L, channel);
                channel2.close();
                channel.close();
                return;
            } catch (Exception unused) {
            }
        }
        byte[] bArr = new byte[8192];
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 < 0) {
                try {
                    break;
                } catch (IOException unused2) {
                }
            } else {
                outputStream.write(bArr, 0, i5);
            }
        }
        inputStream.close();
        try {
            outputStream.close();
        } catch (IOException unused3) {
        }
    }

    public static File createDir(File file, String str) {
        if (str != null) {
            file = new File(file, str);
        }
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }

    public static Path getTempDir() {
        return tmpdir;
    }

    private static InputStream urlToStream(URI uri) {
        try {
            File file = new File(uri);
            if (file.exists()) {
                return new FileInputStream(file);
            }
        } catch (Exception unused) {
        }
        return uri.toURL().openStream();
    }

    public static void copyCompletely(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[8192];
        while (true) {
            int i5 = reader.read(cArr);
            if (i5 < 0) {
                try {
                    break;
                } catch (IOException unused) {
                }
            } else {
                writer.write(cArr, 0, i5);
            }
        }
        reader.close();
        try {
            writer.close();
        } catch (IOException unused2) {
        }
    }

    public static void copyCompletely(URI uri, URI uri2) throws IOException {
        File file = new File(uri2);
        file.getParentFile().mkdirs();
        try {
            InputStream inputStreamUrlToStream = urlToStream(uri);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    copyCompletely(inputStreamUrlToStream, fileOutputStream);
                    fileOutputStream.close();
                    if (inputStreamUrlToStream != null) {
                        inputStreamUrlToStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
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
                    if (inputStreamUrlToStream != null) {
                        try {
                            inputStreamUrlToStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (IllegalArgumentException unused) {
            throw new IOException("Cannot copy to " + uri2);
        }
    }
}
