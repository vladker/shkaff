package cn.sharesdk.twitter;

import android.util.Base64;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MappedFileReader {
    private byte[] array;
    private int arraySize;
    private FileInputStream fileIn;
    private long fileLength;
    private MappedByteBuffer mappedBuf;

    public MappedFileReader(String str, int i5) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.fileIn = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        long size = channel.size();
        this.fileLength = size;
        this.mappedBuf = channel.map(FileChannel.MapMode.READ_ONLY, 0L, size);
        this.arraySize = i5;
    }

    public static String byteToBase64(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    public void close() throws IOException {
        this.fileIn.close();
    }

    public byte[] getArray() {
        return this.array;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public int read() {
        int iLimit = this.mappedBuf.limit();
        int iPosition = this.mappedBuf.position();
        if (iPosition == iLimit) {
            return -1;
        }
        int i5 = iLimit - iPosition;
        int i6 = this.arraySize;
        if (i5 > i6) {
            byte[] bArr = new byte[i6];
            this.array = bArr;
            this.mappedBuf.get(bArr);
            return this.arraySize;
        }
        byte[] bArr2 = new byte[i5];
        this.array = bArr2;
        this.mappedBuf.get(bArr2);
        return i5;
    }
}
