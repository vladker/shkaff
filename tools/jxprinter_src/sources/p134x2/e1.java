package p134x2;

import com.sandu.printer.ZLibHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 {
    public static final e1 INSTANCE = new e1();

    public final byte[] compress(byte[] data) {
        E.f(data, "data");
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length);
        try {
            try {
                byte[] bArr = new byte[1024];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                E.e(byteArray, "toByteArray(...)");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data = byteArray;
            } catch (Exception e6) {
                e6.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            deflater.end();
            return data;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            throw th;
        }
    }

    public final byte[] decompress(byte[] data) {
        E.f(data, "data");
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length);
        try {
            try {
                byte[] bArr = new byte[1024];
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr, 0, inflater.inflate(bArr));
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                E.e(byteArray, "toByteArray(...)");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data = byteArray;
            } catch (Exception e6) {
                e6.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            inflater.end();
            return data;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            throw th;
        }
    }

    public final byte[] decompress(InputStream inputStream) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
        int i5 = 1024;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                i5 = inflaterInputStream.read(bArr, 0, i5);
                if (i5 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i5);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        E.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final byte[] compress(byte[] bArr, int i5) {
        return new ZLibHelper().compress(bArr, i5);
    }

    public final void compress(byte[] data, OutputStream outputStream) {
        E.f(data, "data");
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        try {
            deflaterOutputStream.write(data, 0, data.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
