package org.apache.xmlbeans.impl.util;

import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.impl.repackage.Repackager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FilerImpl implements Filer {
    private static final Charset CHARSET;
    private final File classdir;
    private final boolean incrSrcGen;
    private final Repackager repackager;
    private Set<String> seenTypes;
    private final List<File> sourceFiles = new ArrayList();
    private final File srcdir;
    private final boolean verbose;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IncrFileWriter extends StringWriter {
        private final File _file;
        private final Repackager _repackager;

        public IncrFileWriter(File file, Repackager repackager) {
            this._file = file;
            this._repackager = repackager;
        }

        @Override // java.io.StringWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Repackager repackager = this._repackager;
            String string = (repackager != null ? repackager.repackage(getBuffer()) : getBuffer()).toString();
            ArrayList arrayList = new ArrayList();
            StringReader stringReader = new StringReader(string);
            try {
                BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(this._file.toPath(), StandardCharsets.ISO_8859_1);
                try {
                    Diff.readersAsText(stringReader, "<generated>", bufferedReaderNewBufferedReader, this._file.getName(), arrayList);
                    if (bufferedReaderNewBufferedReader != null) {
                        bufferedReaderNewBufferedReader.close();
                    }
                    stringReader.close();
                    if (arrayList.size() > 0) {
                        Writer writerWriterForFile = FilerImpl.writerForFile(this._file);
                        try {
                            writerWriterForFile.write(string);
                            writerWriterForFile.close();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (writerWriterForFile != null) {
                                    try {
                                        writerWriterForFile.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        if (bufferedReaderNewBufferedReader != null) {
                            try {
                                bufferedReaderNewBufferedReader.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    try {
                        stringReader.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RepackagingWriter extends StringWriter {
        private final File _file;
        private final Repackager _repackager;

        public RepackagingWriter(File file, Repackager repackager) {
            this._file = file;
            this._repackager = repackager;
        }

        @Override // java.io.StringWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Writer writerWriterForFile = FilerImpl.writerForFile(this._file);
            try {
                writerWriterForFile.write(this._repackager.repackage(getBuffer()).toString());
                writerWriterForFile.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (writerWriterForFile != null) {
                        try {
                            writerWriterForFile.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    static {
        Charset charsetForName;
        try {
            charsetForName = Charset.forName(System.getProperty("file.encoding"));
        } catch (Exception unused) {
            charsetForName = null;
        }
        CHARSET = charsetForName;
    }

    public FilerImpl(File file, File file2, Repackager repackager, boolean z6, boolean z7) {
        this.classdir = file;
        this.srcdir = file2;
        this.repackager = repackager;
        this.verbose = z6;
        this.incrSrcGen = z7;
        if (z7) {
            this.seenTypes = new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Writer writerForFile(File file) {
        Charset charset = CHARSET;
        if (charset == null) {
            return Files.newBufferedWriter(file.toPath(), StandardCharsets.ISO_8859_1, new OpenOption[0]);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        charsetEncoderNewEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return new OutputStreamWriter(fileOutputStream, charsetEncoderNewEncoder);
    }

    @Override // org.apache.xmlbeans.Filer
    public OutputStream createBinaryFile(String str) {
        if (this.verbose) {
            System.err.println("created binary: " + str);
        }
        File file = new File(this.classdir, str);
        file.getParentFile().mkdirs();
        return new FileOutputStream(file);
    }

    @Override // org.apache.xmlbeans.Filer
    public Writer createSourceFile(String str) {
        if (this.incrSrcGen) {
            this.seenTypes.add(str);
        }
        if (str.indexOf(36) > 0) {
            str = str.substring(0, str.lastIndexOf(46)) + Consts.DOT + str.substring(str.indexOf(36) + 1);
        }
        File file = new File(this.srcdir, str.replace('.', File.separatorChar) + ".java");
        file.getParentFile().mkdirs();
        if (this.verbose) {
            System.err.println("created source: " + file.getAbsolutePath());
        }
        this.sourceFiles.add(file);
        if (this.incrSrcGen && file.exists()) {
            return new IncrFileWriter(file, this.repackager);
        }
        return this.repackager == null ? writerForFile(file) : new RepackagingWriter(file, this.repackager);
    }

    public Repackager getRepackager() {
        return this.repackager;
    }

    public List<File> getSourceFiles() {
        return new ArrayList(this.sourceFiles);
    }
}
