package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FileHelper {
    public static void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                FileChannel channel = fileInputStream.getChannel();
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        channel.transferTo(0L, channel.size(), channel2);
                        if (channel2 != null) {
                            channel2.close();
                        }
                        channel.close();
                        fileOutputStream.close();
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (channel2 == null) {
                                throw th2;
                            }
                            try {
                                channel2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                try {
                                    fileOutputStream.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        if (channel == null) {
                            throw th7;
                        }
                        try {
                            channel.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th6.addSuppressed(th8);
                            throw th7;
                        }
                        try {
                            throw th;
                        } catch (Throwable th9) {
                            try {
                                fileInputStream.close();
                                throw th9;
                            } catch (Throwable th10) {
                                th.addSuppressed(th10);
                                throw th9;
                            }
                        }
                    }
                }
            } catch (Throwable th11) {
                throw th11;
            }
        } catch (Throwable th12) {
            throw th12;
        }
    }

    public static File getDirectory(File file) {
        if (file == null) {
            return null;
        }
        String path = file.getPath();
        int length = path.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
        } while (path.charAt(length) != File.separatorChar);
        return new File(path.substring(0, length));
    }

    public static String getFilename(File file) {
        if (file == null) {
            return "";
        }
        String path = file.getPath();
        int length = path.length();
        int i5 = length;
        while (true) {
            int i6 = i5 - 1;
            if (i6 < 0) {
                return "";
            }
            if (path.charAt(i6) == File.separatorChar) {
                return path.substring(i5, length);
            }
            i5 = i6;
        }
    }
}
