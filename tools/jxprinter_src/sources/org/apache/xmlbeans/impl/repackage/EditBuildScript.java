package org.apache.xmlbeans.impl.repackage;

import A3.AbstractC0157z;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class EditBuildScript {
    public static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int i5 = reader.read(cArr, 0, 16384);
            if (i5 < 0) {
                return;
            } else {
                writer.write(cArr, 0, i5);
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        strArr[0] = strArr[0].replace('/', File.separatorChar);
        File file = new File(strArr[0]);
        StringBuffer file2 = readFile(file);
        String strS = AbstractC0157z.s(new StringBuilder("<property name=\""), strArr[1], "\" value=\"");
        int iIndexOf = file2.indexOf(strS);
        if (iIndexOf < 0) {
            throw new IllegalArgumentException(AbstractC0157z.n("Can't find token: ", strS));
        }
        int length = strS.length() + iIndexOf;
        while (file2.charAt(length) != '\"') {
            length++;
        }
        file2.replace(strS.length() + iIndexOf, length, strArr[2]);
        writeFile(file, file2);
    }

    public static StringBuffer readFile(File file) throws IOException {
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(file.toPath(), StandardCharsets.ISO_8859_1);
        try {
            StringWriter stringWriter = new StringWriter();
            try {
                copy(bufferedReaderNewBufferedReader, stringWriter);
                StringBuffer buffer = stringWriter.getBuffer();
                stringWriter.close();
                if (bufferedReaderNewBufferedReader != null) {
                    bufferedReaderNewBufferedReader.close();
                }
                return buffer;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        stringWriter.close();
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
    }

    public static void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        BufferedWriter bufferedWriterNewBufferedWriter = Files.newBufferedWriter(file.toPath(), StandardCharsets.ISO_8859_1, new OpenOption[0]);
        try {
            StringReader stringReader = new StringReader(stringBuffer.toString());
            try {
                copy(stringReader, bufferedWriterNewBufferedWriter);
                stringReader.close();
                if (bufferedWriterNewBufferedWriter != null) {
                    bufferedWriterNewBufferedWriter.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        stringReader.close();
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
                if (bufferedWriterNewBufferedWriter != null) {
                    try {
                        bufferedWriterNewBufferedWriter.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }
}
