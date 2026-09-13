package org.apache.poi.util;

import A3.AbstractC0157z;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HexRead {
    public static byte[] readData(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            byte[] data = readData(fileInputStream, -1);
            fileInputStream.close();
            return data;
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

    public static byte[] readFromString(String str) {
        try {
            return readData(new ByteArrayInputStream(str.getBytes(StringUtil.UTF8)), -1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readToEOL(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        while (i5 != -1 && i5 != 10 && i5 != 13) {
            i5 = inputStream.read();
        }
    }

    public static byte[] readData(InputStream inputStream, String str) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            int i5 = inputStream.read();
            boolean z6 = false;
            while (i5 != -1) {
                if (i5 == 10 || i5 == 13) {
                    sb = new StringBuilder();
                } else {
                    if (i5 == 91) {
                        z6 = true;
                    } else if (i5 != 93) {
                        if (z6) {
                            sb.append((char) i5);
                        }
                    } else {
                        if (sb.toString().equals(str)) {
                            return readData(inputStream, 91);
                        }
                        sb = new StringBuilder();
                    }
                    i5 = inputStream.read();
                }
                z6 = false;
                i5 = inputStream.read();
            }
            throw new IOException(AbstractC0157z.o("Section '", str, "' not found"));
        } finally {
            inputStream.close();
        }
    }

    public static byte[] readData(String str, String str2) {
        return readData(new FileInputStream(str), str2);
    }

    public static byte[] readData(InputStream inputStream, int i5) throws IOException {
        int i6;
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            int i7 = 0;
            byte b = 0;
            while (true) {
                int i8 = inputStream.read();
                if (48 <= i8 && i8 <= 57) {
                    i6 = i8 - 48;
                } else if (65 <= i8 && i8 <= 70) {
                    i6 = i8 - 55;
                } else if (97 > i8 || i8 > 102) {
                    if (35 == i8) {
                        readToEOL(inputStream);
                    } else if (-1 == i8 || i5 == i8) {
                        break loop0;
                    }
                    i6 = -1;
                } else {
                    i6 = i8 - 87;
                }
                if (i6 != -1) {
                    b = (byte) (((byte) (b << 4)) + ((byte) i6));
                    i7++;
                    if (i7 == 2) {
                        break;
                    }
                }
            }
            arrayList.add(Byte.valueOf(b));
        }
        Byte[] bArr = (Byte[]) arrayList.toArray(new Byte[0]);
        byte[] bArr2 = new byte[bArr.length];
        for (int i9 = 0; i9 < bArr.length; i9++) {
            bArr2[i9] = bArr[i9].byteValue();
        }
        return bArr2;
    }
}
