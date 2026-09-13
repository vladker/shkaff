package org.apache.commons.codec.binary;

import A3.AbstractC0157z;
import androidx.exifinterface.media.a;
import io.flutter.embedding.android.KeyboardMap;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;

    @Deprecated
    protected final byte PAD;
    private final int chunkSeparatorLength;
    private final CodecPolicy decodingPolicy;
    private final int encodedBlockSize;
    protected final int lineLength;
    protected final byte pad;
    private final int unencodedBlockSize;
    protected static final CodecPolicy DECODING_POLICY_DEFAULT = CodecPolicy.LENIENT;
    static final byte[] CHUNK_SEPARATOR = {13, 10};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        public String toString() {
            String simpleName = getClass().getSimpleName();
            String string = Arrays.toString(this.buffer);
            int i5 = this.currentLinePos;
            boolean z6 = this.eof;
            int i6 = this.ibitWorkArea;
            long j6 = this.lbitWorkArea;
            int i7 = this.modulus;
            int i8 = this.pos;
            int i9 = this.readPos;
            StringBuilder sb = new StringBuilder();
            sb.append(simpleName);
            sb.append("[buffer=");
            sb.append(string);
            sb.append(", currentLinePos=");
            sb.append(i5);
            sb.append(", eof=");
            sb.append(z6);
            sb.append(", ibitWorkArea=");
            sb.append(i6);
            sb.append(", lbitWorkArea=");
            sb.append(j6);
            sb.append(", modulus=");
            a.y(sb, i7, ", pos=", i8, ", readPos=");
            return AbstractC0157z.l("]", i9, sb);
        }
    }

    public BaseNCodec(int i5, int i6, int i7, int i8) {
        this(i5, i6, i7, i8, (byte) 61);
    }

    private static int compareUnsigned(int i5, int i6) {
        return Integer.compare(i5 - Integer.MIN_VALUE, i6 - Integer.MIN_VALUE);
    }

    private static int createPositiveCapacity(int i5) {
        if (i5 >= 0) {
            return i5 > MAX_BUFFER_SIZE ? i5 : MAX_BUFFER_SIZE;
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + (((long) i5) & KeyboardMap.kValueMask));
    }

    public static byte[] getChunkSeparator() {
        return (byte[]) CHUNK_SEPARATOR.clone();
    }

    public static boolean isWhiteSpace(byte b) {
        return b == 9 || b == 10 || b == 13 || b == 32;
    }

    private static byte[] resizeBuffer(Context context, int i5) {
        int length = context.buffer.length * 2;
        if (compareUnsigned(length, i5) < 0) {
            length = i5;
        }
        if (compareUnsigned(length, MAX_BUFFER_SIZE) > 0) {
            length = createPositiveCapacity(i5);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = context.buffer;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        context.buffer = bArr;
        return bArr;
    }

    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (this.pad == b || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public abstract void decode(byte[] bArr, int i5, int i6, Context context);

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i5 = context.pos;
        byte[] bArr2 = new byte[i5];
        readResults(bArr2, 0, i5, context);
        return bArr2;
    }

    public abstract void encode(byte[] bArr, int i5, int i6, Context context);

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : encode(bArr, 0, bArr.length);
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public byte[] ensureBufferSize(int i5, Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[Math.max(i5, getDefaultBufferSize())];
            context.pos = 0;
            context.readPos = 0;
        } else {
            int i6 = context.pos;
            if ((i6 + i5) - bArr.length > 0) {
                return resizeBuffer(context, i6 + i5);
            }
        }
        return context.buffer;
    }

    public CodecPolicy getCodecPolicy() {
        return this.decodingPolicy;
    }

    public int getDefaultBufferSize() {
        return 8192;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        int i5 = this.unencodedBlockSize;
        long j6 = ((long) (((length + i5) - 1) / i5)) * ((long) this.encodedBlockSize);
        int i6 = this.lineLength;
        return i6 > 0 ? ((((((long) i6) + j6) - 1) / ((long) i6)) * ((long) this.chunkSeparatorLength)) + j6 : j6;
    }

    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    public abstract boolean isInAlphabet(byte b);

    public boolean isInAlphabet(byte[] bArr, boolean z6) {
        for (byte b : bArr) {
            if (!isInAlphabet(b) && (!z6 || (b != this.pad && !isWhiteSpace(b)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictDecoding() {
        return this.decodingPolicy == CodecPolicy.STRICT;
    }

    public int readResults(byte[] bArr, int i5, int i6, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int iMin = Math.min(available(context), i6);
        System.arraycopy(context.buffer, context.readPos, bArr, i5, iMin);
        int i7 = context.readPos + iMin;
        context.readPos = i7;
        if (i7 >= context.pos) {
            context.buffer = null;
        }
        return iMin;
    }

    public BaseNCodec(int i5, int i6, int i7, int i8, byte b) {
        this(i5, i6, i7, i8, b, DECODING_POLICY_DEFAULT);
    }

    public BaseNCodec(int i5, int i6, int i7, int i8, byte b, CodecPolicy codecPolicy) {
        this.PAD = (byte) 61;
        this.unencodedBlockSize = i5;
        this.encodedBlockSize = i6;
        this.lineLength = (i7 <= 0 || i8 <= 0) ? 0 : (i7 / i6) * i6;
        this.chunkSeparatorLength = i8;
        this.pad = b;
        Objects.requireNonNull(codecPolicy, "codecPolicy");
        this.decodingPolicy = codecPolicy;
    }

    public byte[] encode(byte[] bArr, int i5, int i6) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, i5, i6, context);
        encode(bArr, i5, -1, context);
        int i7 = context.pos - context.readPos;
        byte[] bArr2 = new byte[i7];
        readResults(bArr2, 0, i7, context);
        return bArr2;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }
}
