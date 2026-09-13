package X1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f834a;
    public int b;
    public byte[] c;

    public a(InputStream inputStream) throws IOException {
        init(inputStream);
    }

    private void init(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.c = byteArray;
                this.f834a = byteArray.length;
                this.b = 0;
                return;
            }
            byteArrayOutputStream.write(bArr, 0, i5);
        }
    }

    private byte read() throws EOFException {
        int i5 = this.b;
        if (i5 < this.f834a) {
            byte[] bArr = this.c;
            this.b = i5 + 1;
            return bArr[i5];
        }
        throw new EOFException("Reached EOF, file size=" + this.f834a);
    }

    public byte readTTFByte() {
        return read();
    }

    public int readTTFLong() {
        return (int) ((((((((long) readTTFUByte()) << 8) + ((long) readTTFUByte())) << 8) + ((long) readTTFUByte())) << 8) + ((long) readTTFUByte()));
    }

    public String readTTFString(int i5) throws EOFException {
        int i6 = this.b;
        if (i5 + i6 > this.f834a) {
            throw new EOFException("Reached EOF, file size=" + this.f834a);
        }
        byte[] bArr = new byte[i5];
        System.arraycopy(this.c, i6, bArr, 0, i5);
        this.b += i5;
        return new String(bArr, (i5 <= 0 || bArr[0] != 0) ? "ISO-8859-1" : "UTF-16BE");
    }

    public int readTTFUByte() throws EOFException {
        byte b = read();
        return b < 0 ? b + 256 : b;
    }

    public long readTTFULong() {
        return (((((((long) readTTFUByte()) << 8) + ((long) readTTFUByte())) << 8) + ((long) readTTFUByte())) << 8) + ((long) readTTFUByte());
    }

    public int readTTFUShort() {
        return readTTFUByte() + (readTTFUByte() << 8);
    }

    public void seekSet(long j6) throws EOFException {
        if (j6 <= this.f834a && j6 >= 0) {
            this.b = (int) j6;
            return;
        }
        throw new EOFException("Reached EOF, file size=" + this.f834a + " offset=" + j6);
    }

    public void skip(long j6) throws EOFException {
        seekSet(((long) this.b) + j6);
    }

    public a(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            init(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }

    public String readTTFString(int i5, int i6) throws EOFException {
        int i7 = this.b;
        if (i5 + i7 <= this.f834a) {
            byte[] bArr = new byte[i5];
            System.arraycopy(this.c, i7, bArr, 0, i5);
            this.b += i5;
            return new String(bArr, "UTF-16BE");
        }
        throw new EOFException("Reached EOF, file size=" + this.f834a);
    }
}
