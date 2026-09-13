package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    private final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        public Value(int i5, int i6, int i7, long j6) {
            this.key = i5;
            this.type = i6;
            this.minBitWidth = i7;
            this.iValue = j6;
            this.dValue = Double.MIN_VALUE;
        }

        public static Value blob(int i5, int i6, int i7, int i8) {
            return new Value(i5, i7, i8, i6);
        }

        public static Value bool(int i5, boolean z6) {
            return new Value(i5, 26, 0, z6 ? 1L : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int elemWidth(int i5, int i6) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i5, i6);
        }

        public static Value float32(int i5, float f6) {
            return new Value(i5, 3, 2, f6);
        }

        public static Value float64(int i5, double d) {
            return new Value(i5, 3, 3, d);
        }

        public static Value int16(int i5, int i6) {
            return new Value(i5, 1, 1, i6);
        }

        public static Value int32(int i5, int i6) {
            return new Value(i5, 1, 2, i6);
        }

        public static Value int64(int i5, long j6) {
            return new Value(i5, 1, 3, j6);
        }

        public static Value int8(int i5, int i6) {
            return new Value(i5, 1, 0, i6);
        }

        private static byte packedType(int i5, int i6) {
            return (byte) (i5 | (i6 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int paddingBytes(int i5, int i6) {
            return ((~i5) + 1) & (i6 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int i5) {
            return FlexBuffers.isTypeInline(this.type) ? Math.max(this.minBitWidth, i5) : this.minBitWidth;
        }

        public static Value uInt16(int i5, int i6) {
            return new Value(i5, 2, 1, i6);
        }

        public static Value uInt32(int i5, int i6) {
            return new Value(i5, 2, 2, i6);
        }

        public static Value uInt64(int i5, long j6) {
            return new Value(i5, 2, 3, j6);
        }

        public static Value uInt8(int i5, int i6) {
            return new Value(i5, 2, 0, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int elemWidth(int i5, int i6, long j6, int i7, int i8) {
            if (FlexBuffers.isTypeInline(i5)) {
                return i6;
            }
            for (int i9 = 1; i9 <= 32; i9 *= 2) {
                int iWidthUInBits = FlexBuffersBuilder.widthUInBits((int) (((long) ((i8 * i9) + (paddingBytes(i7, i9) + i7))) - j6));
                if ((1 << iWidthUInBits) == i9) {
                    return iWidthUInBits;
                }
            }
            return 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType(int i5) {
            return packedType(storedWidth(i5), this.type);
        }

        public Value(int i5, int i6, int i7, double d) {
            this.key = i5;
            this.type = i6;
            this.minBitWidth = i7;
            this.dValue = d;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i5) {
        this(new ArrayReadWriteBuf(i5), 1);
    }

    private int align(int i5) {
        int i6 = 1 << i5;
        int iPaddingBytes = Value.paddingBytes(this.bb.writePosition(), i6);
        while (true) {
            int i7 = iPaddingBytes - 1;
            if (iPaddingBytes == 0) {
                return i6;
            }
            this.bb.put((byte) 0);
            iPaddingBytes = i7;
        }
    }

    private Value createKeyVector(int i5, int i6) {
        long j6 = i6;
        int iMax = Math.max(0, widthUInBits(j6));
        int i7 = i5;
        while (i7 < this.stack.size()) {
            int i8 = i7 + 1;
            iMax = Math.max(iMax, Value.elemWidth(4, 0, this.stack.get(i7).key, this.bb.writePosition(), i8));
            i7 = i8;
        }
        int iAlign = align(iMax);
        writeInt(j6, iAlign);
        int iWritePosition = this.bb.writePosition();
        while (i5 < this.stack.size()) {
            int i9 = this.stack.get(i5).key;
            writeOffset(this.stack.get(i5).key, iAlign);
            i5++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), iMax, iWritePosition);
    }

    private Value createVector(int i5, int i6, int i7, boolean z6, boolean z7, Value value) {
        int i8;
        int typedVector;
        int i9 = i7;
        long j6 = i9;
        int iMax = Math.max(0, widthUInBits(j6));
        if (value != null) {
            iMax = Math.max(iMax, value.elemWidth(this.bb.writePosition(), 0));
            i8 = 3;
        } else {
            i8 = 1;
        }
        int i10 = 4;
        int iMax2 = iMax;
        for (int i11 = i6; i11 < this.stack.size(); i11++) {
            iMax2 = Math.max(iMax2, this.stack.get(i11).elemWidth(this.bb.writePosition(), i11 + i8));
            if (z6 && i11 == i6) {
                i10 = this.stack.get(i11).type;
                if (!FlexBuffers.isTypedVectorElementType(i10)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i12 = i6;
        int iAlign = align(iMax2);
        if (value != null) {
            writeOffset(value.iValue, iAlign);
            writeInt(1 << value.minBitWidth, iAlign);
        }
        if (!z7) {
            writeInt(j6, iAlign);
        }
        int iWritePosition = this.bb.writePosition();
        for (int i13 = i12; i13 < this.stack.size(); i13++) {
            writeAny(this.stack.get(i13), iAlign);
        }
        if (!z6) {
            while (i12 < this.stack.size()) {
                this.bb.put(this.stack.get(i12).storedPackedType(iMax2));
                i12++;
            }
        }
        if (value != null) {
            typedVector = 9;
        } else if (z6) {
            if (!z7) {
                i9 = 0;
            }
            typedVector = FlexBuffers.toTypedVector(i10, i9);
        } else {
            typedVector = 10;
        }
        return new Value(i5, typedVector, iMax2, iWritePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int iWritePosition = this.bb.writePosition();
        if ((this.flags & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, 0, bytes.length);
            this.bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(iWritePosition));
            return iWritePosition;
        }
        Integer num = this.keyPool.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(iWritePosition));
        return iWritePosition;
    }

    public static int widthUInBits(long j6) {
        if (j6 <= FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) {
            return 0;
        }
        if (j6 <= FlexBuffers.Unsigned.shortToUnsignedInt((short) -1)) {
            return 1;
        }
        return j6 <= FlexBuffers.Unsigned.intToUnsignedLong(-1) ? 2 : 3;
    }

    private void writeAny(Value value, int i5) {
        int i6 = value.type;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                writeDouble(value.dValue, i5);
                return;
            } else if (i6 != 26) {
                writeOffset(value.iValue, i5);
                return;
            }
        }
        writeInt(value.iValue, i5);
    }

    private Value writeBlob(int i5, byte[] bArr, int i6, boolean z6) {
        int iWidthUInBits = widthUInBits(bArr.length);
        writeInt(bArr.length, align(iWidthUInBits));
        int iWritePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z6) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i5, iWritePosition, i6, iWidthUInBits);
    }

    private void writeDouble(double d, int i5) {
        if (i5 == 4) {
            this.bb.putFloat((float) d);
        } else if (i5 == 8) {
            this.bb.putDouble(d);
        }
    }

    private void writeInt(long j6, int i5) {
        if (i5 == 1) {
            this.bb.put((byte) j6);
            return;
        }
        if (i5 == 2) {
            this.bb.putShort((short) j6);
        } else if (i5 == 4) {
            this.bb.putInt((int) j6);
        } else {
            if (i5 != 8) {
                return;
            }
            this.bb.putLong(j6);
        }
    }

    private void writeOffset(long j6, int i5) {
        writeInt((int) (((long) this.bb.writePosition()) - j6), i5);
    }

    private Value writeString(int i5, String str) {
        return writeBlob(i5, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i5) {
        int iPutKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i5, arrayList.size()), this.keyComparator);
        Value valueCreateVector = createVector(iPutKey, i5, this.stack.size() - i5, false, false, createKeyVector(i5, this.stack.size() - i5));
        while (this.stack.size() > i5) {
            ArrayList<Value> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public int endVector(String str, int i5, boolean z6, boolean z7) {
        Value valueCreateVector = createVector(putKey(str), i5, this.stack.size() - i5, z6, z7, null);
        while (this.stack.size() > i5) {
            ArrayList<Value> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public ByteBuffer finish() {
        int iAlign = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), iAlign);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) iAlign);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public void putBoolean(boolean z6) {
        putBoolean(null, z6);
    }

    public void putFloat(float f6) {
        putFloat((String) null, f6);
    }

    public void putInt(int i5) {
        putInt((String) null, i5);
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public void putUInt(int i5) {
        putUInt(null, i5);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64(null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j6) {
        this.stack.add(Value.uInt64(putKey(str), j6));
    }

    public int putBlob(String str, byte[] bArr) {
        Value valueWriteBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(valueWriteBlob);
        return (int) valueWriteBlob.iValue;
    }

    public void putBoolean(String str, boolean z6) {
        this.stack.add(Value.bool(putKey(str), z6));
    }

    public void putFloat(String str, float f6) {
        this.stack.add(Value.float32(putKey(str), f6));
    }

    public void putInt(String str, int i5) {
        putInt(str, i5);
    }

    public int putString(String str, String str2) {
        int iPutKey = putKey(str);
        if ((this.flags & 2) == 0) {
            Value valueWriteString = writeString(iPutKey, str2);
            this.stack.add(valueWriteString);
            return (int) valueWriteString.iValue;
        }
        Integer num = this.stringPool.get(str2);
        if (num != null) {
            this.stack.add(Value.blob(iPutKey, num.intValue(), 5, widthUInBits(str2.length())));
            return num.intValue();
        }
        Value valueWriteString2 = writeString(iPutKey, str2);
        this.stringPool.put(str2, Integer.valueOf((int) valueWriteString2.iValue));
        this.stack.add(valueWriteString2);
        return (int) valueWriteString2.iValue;
    }

    public void putUInt(long j6) {
        putUInt(null, j6);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i5) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i5);
    }

    private void putUInt(String str, long j6) {
        Value valueUInt64;
        int iPutKey = putKey(str);
        int iWidthUInBits = widthUInBits(j6);
        if (iWidthUInBits == 0) {
            valueUInt64 = Value.uInt8(iPutKey, (int) j6);
        } else if (iWidthUInBits == 1) {
            valueUInt64 = Value.uInt16(iPutKey, (int) j6);
        } else if (iWidthUInBits == 2) {
            valueUInt64 = Value.uInt32(iPutKey, (int) j6);
        } else {
            valueUInt64 = Value.uInt64(iPutKey, j6);
        }
        this.stack.add(valueUInt64);
    }

    public void putFloat(double d) {
        putFloat((String) null, d);
    }

    public void putInt(String str, long j6) {
        int iPutKey = putKey(str);
        if (-128 <= j6 && j6 <= 127) {
            this.stack.add(Value.int8(iPutKey, (int) j6));
            return;
        }
        if (-32768 <= j6 && j6 <= 32767) {
            this.stack.add(Value.int16(iPutKey, (int) j6));
        } else if (-2147483648L <= j6 && j6 <= 2147483647L) {
            this.stack.add(Value.int32(iPutKey, (int) j6));
        } else {
            this.stack.add(Value.int64(iPutKey, j6));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i5) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b;
                byte b6;
                int i6 = value.key;
                int i7 = value2.key;
                do {
                    b = FlexBuffersBuilder.this.bb.get(i6);
                    b6 = FlexBuffersBuilder.this.bb.get(i7);
                    if (b == 0) {
                        return b - b6;
                    }
                    i6++;
                    i7++;
                } while (b == b6);
                return b - b6;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i5;
    }

    public void putFloat(String str, double d) {
        this.stack.add(Value.float64(putKey(str), d));
    }

    public void putInt(long j6) {
        putInt((String) null, j6);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
