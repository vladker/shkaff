package org.apache.commons.compress.harmony.unpack200;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Archive {
    private boolean deflateHint;
    private String inputFileName;
    private InputStream inputStream;
    private FileOutputStream logFile;
    private int logLevel = 1;
    private String outputFileName;
    private final JarOutputStream outputStream;
    private boolean overrideDeflateHint;
    private boolean removePackFile;

    public Archive(String str, String str2) {
        this.inputFileName = str;
        this.outputFileName = str2;
        this.inputStream = new FileInputStream(str);
        this.outputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
    }

    private boolean available(InputStream inputStream) throws IOException {
        inputStream.mark(1);
        int i5 = inputStream.read();
        inputStream.reset();
        return i5 != -1;
    }

    public void setDeflateHint(boolean z6) {
        this.overrideDeflateHint = true;
        this.deflateHint = z6;
    }

    public void setLogFile(String str) {
        this.logFile = new FileOutputStream(str);
    }

    public void setQuiet(boolean z6) {
        if (z6) {
            this.logLevel = 0;
        } else if (this.logLevel == 0) {
            this.logLevel = 0;
        }
    }

    public void setRemovePackFile(boolean z6) {
        this.removePackFile = z6;
    }

    public void setVerbose(boolean z6) {
        if (z6) {
            this.logLevel = 2;
        } else if (this.logLevel == 2) {
            this.logLevel = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0159  */
    /* JADX WARN: Code duplicated, block: B:62:0x015d  */
    /* JADX WARN: Code duplicated, block: B:65:0x016b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0173 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void unpack() throws Pack200Exception {
        FileOutputStream fileOutputStream;
        this.outputStream.setComment("PACK200");
        try {
            if (!this.inputStream.markSupported()) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream);
                this.inputStream = bufferedInputStream;
                if (!bufferedInputStream.markSupported()) {
                    throw new IllegalStateException();
                }
            }
            this.inputStream.mark(2);
            if (((this.inputStream.read() & 255) | ((this.inputStream.read() & 255) << 8)) == 35615) {
                this.inputStream.reset();
                this.inputStream = new BufferedInputStream(new GZIPInputStream(this.inputStream));
            } else {
                this.inputStream.reset();
            }
            this.inputStream.mark(4);
            int[] iArr = {202, 254, 208, 13};
            int[] iArr2 = new int[4];
            for (int i5 = 0; i5 < 4; i5++) {
                iArr2[i5] = this.inputStream.read();
            }
            boolean z6 = false;
            for (int i6 = 0; i6 < 4; i6++) {
                if (iArr2[i6] != iArr[i6]) {
                    z6 = true;
                }
            }
            this.inputStream.reset();
            try {
                try {
                    if (z6) {
                        JarInputStream jarInputStream = new JarInputStream(this.inputStream);
                        while (true) {
                            JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
                            if (nextJarEntry == null) {
                                break;
                            }
                            this.outputStream.putNextEntry(nextJarEntry);
                            byte[] bArr = new byte[16384];
                            for (int i7 = jarInputStream.read(bArr); i7 != -1; i7 = jarInputStream.read(bArr)) {
                                this.outputStream.write(bArr, 0, i7);
                            }
                            this.outputStream.closeEntry();
                        }
                        this.inputStream.close();
                        this.outputStream.close();
                        fileOutputStream = this.logFile;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (this.removePackFile) {
                            if (this.inputFileName != null ? new File(this.inputFileName).delete() : false) {
                                throw new Pack200Exception("Failed to delete the input file.");
                            }
                        }
                    }
                    int i8 = 0;
                    while (available(this.inputStream)) {
                        i8++;
                        Segment segment = new Segment();
                        segment.setLogLevel(this.logLevel);
                        OutputStream outputStream = this.logFile;
                        if (outputStream == null) {
                            outputStream = System.out;
                        }
                        segment.setLogStream(outputStream);
                        segment.setPreRead(false);
                        if (i8 == 1) {
                            segment.log(2, "Unpacking from " + this.inputFileName + " to " + this.outputFileName);
                        }
                        segment.log(2, "Reading segment " + i8);
                        if (this.overrideDeflateHint) {
                            segment.overrideDeflateHint(this.deflateHint);
                        }
                        segment.unpack(this.inputStream, this.outputStream);
                        this.outputStream.flush();
                        InputStream inputStream = this.inputStream;
                        if (inputStream instanceof FileInputStream) {
                            this.inputFileName = ((FileInputStream) inputStream).getFD().toString();
                        }
                    }
                    this.inputStream.close();
                } catch (Exception unused2) {
                }
                this.outputStream.close();
            } catch (Exception unused3) {
            }
            fileOutputStream = this.logFile;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (this.removePackFile) {
                if (this.inputFileName != null ? new File(this.inputFileName).delete() : false) {
                    throw new Pack200Exception("Failed to delete the input file.");
                }
            }
        } catch (Throwable th) {
            try {
                this.inputStream.close();
            } catch (Exception unused4) {
            }
            try {
                this.outputStream.close();
            } catch (Exception unused5) {
            }
            FileOutputStream fileOutputStream2 = this.logFile;
            if (fileOutputStream2 == null) {
                throw th;
            }
            try {
                fileOutputStream2.close();
                throw th;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    public void setLogFile(String str, boolean z6) {
        this.logFile = new FileOutputStream(str, z6);
    }

    public Archive(InputStream inputStream, JarOutputStream jarOutputStream) {
        this.inputStream = inputStream;
        this.outputStream = jarOutputStream;
    }
}
