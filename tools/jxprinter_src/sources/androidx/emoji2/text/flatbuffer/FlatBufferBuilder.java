package androidx.emoji2.text.flatbuffer;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() {
            try {
                return this.buf.get() & UnsignedBytes.MAX_VALUE;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i5) {
            return ByteBuffer.allocate(i5).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i5, ByteBufferFactory byteBufferFactory) {
        this(i5, byteBufferFactory, null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i5 = iCapacity == 0 ? 1 : iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferNewByteBuffer = byteBufferFactory.newByteBuffer(i5);
        byteBufferNewByteBuffer.position(byteBufferNewByteBuffer.clear().capacity() - iCapacity);
        byteBufferNewByteBuffer.put(byteBuffer);
        return byteBufferNewByteBuffer;
    }

    public static boolean isFieldPresent(Table table, int i5) {
        return table.__offset(i5) != 0;
    }

    public void Nested(int i5) {
        if (i5 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z6) {
        prep(1, 0);
        putBoolean(z6);
    }

    public void addByte(byte b) {
        prep(1, 0);
        putByte(b);
    }

    public void addDouble(double d) {
        prep(8, 0);
        putDouble(d);
    }

    public void addFloat(float f6) {
        prep(4, 0);
        putFloat(f6);
    }

    public void addInt(int i5) {
        prep(4, 0);
        putInt(i5);
    }

    public void addLong(long j6) {
        prep(8, 0);
        putLong(j6);
    }

    public void addOffset(int i5) {
        prep(4, 0);
        putInt((offset() - i5) + 4);
    }

    public void addShort(short s6) {
        prep(2, 0);
        putShort(s6);
    }

    public void addStruct(int i5, int i6, int i7) {
        if (i6 != i7) {
            Nested(i6);
            slot(i5);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (true) {
            int i5 = this.vtable_in_use;
            if (i5 <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i6 = i5 - 1;
            this.vtable_in_use = i6;
            iArr[i6] = 0;
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - length;
        this.space = i5;
        byteBuffer.position(i5);
        this.bb.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t6, int[] iArr) {
        t6.sortTables(iArr, this.bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int iEncodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, iEncodedLength, 1);
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - iEncodedLength;
        this.space = i5;
        byteBuffer.position(i5);
        this.utf8.encodeUtf8(charSequence, this.bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i5, int i6, int i7) {
        int i8 = i5 * i6;
        startVector(i5, i6, i7);
        ByteBuffer byteBuffer = this.bb;
        int i9 = this.space - i8;
        this.space = i9;
        byteBuffer.position(i9);
        ByteBuffer byteBufferOrder = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i8);
        return byteBufferOrder;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public int endTable() {
        int i5;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int iOffset = offset();
        int i6 = this.vtable_in_use - 1;
        while (i6 >= 0 && this.vtable[i6] == 0) {
            i6--;
        }
        for (int i7 = i6; i7 >= 0; i7--) {
            int i8 = this.vtable[i7];
            addShort((short) (i8 != 0 ? iOffset - i8 : 0));
        }
        addShort((short) (iOffset - this.object_start));
        addShort((short) ((i6 + 3) * 2));
        int i9 = 0;
        loop2: while (true) {
            if (i9 >= this.num_vtables) {
                i5 = 0;
                break;
            }
            int iCapacity = this.bb.capacity() - this.vtables[i9];
            int i10 = this.space;
            short s6 = this.bb.getShort(iCapacity);
            if (s6 == this.bb.getShort(i10)) {
                int i11 = 2;
                while (true) {
                    if (i11 >= s6) {
                        i5 = this.vtables[i9];
                        break loop2;
                    }
                    if (this.bb.getShort(iCapacity + i11) != this.bb.getShort(i10 + i11)) {
                        break;
                    }
                    i11 += 2;
                }
            }
            i9++;
        }
        if (i5 != 0) {
            int iCapacity2 = this.bb.capacity() - iOffset;
            this.space = iCapacity2;
            this.bb.putInt(iCapacity2, i5 - iOffset);
        } else {
            int i12 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i12 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i12 * 2);
            }
            int[] iArr2 = this.vtables;
            int i13 = this.num_vtables;
            this.num_vtables = i13 + 1;
            iArr2[i13] = offset();
            ByteBuffer byteBuffer = this.bb;
            byteBuffer.putInt(byteBuffer.capacity() - iOffset, offset() - iOffset);
        }
        this.nested = false;
        return iOffset;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finish(int i5, boolean z6) {
        prep(this.minalign, (z6 ? 4 : 0) + 4);
        addOffset(i5);
        if (z6) {
            addInt(this.bb.capacity() - this.space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i5) {
        finish(i5, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z6) {
        this.force_defaults = z6;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        byteBuffer.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            ByteBuffer byteBuffer = this.bb;
            int i7 = this.space - 1;
            this.space = i7;
            byteBuffer.put(i7, (byte) 0);
        }
    }

    public void prep(int i5, int i6) {
        if (i5 > this.minalign) {
            this.minalign = i5;
        }
        int i7 = ((~((this.bb.capacity() - this.space) + i6)) + 1) & (i5 - 1);
        while (this.space < i7 + i5 + i6) {
            int iCapacity = this.bb.capacity();
            ByteBuffer byteBuffer = this.bb;
            ByteBuffer byteBufferGrowByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.bb = byteBufferGrowByteBuffer;
            if (byteBuffer != byteBufferGrowByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space = (this.bb.capacity() - iCapacity) + this.space;
        }
        pad(i7);
    }

    public void putBoolean(boolean z6) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 1;
        this.space = i5;
        byteBuffer.put(i5, z6 ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 1;
        this.space = i5;
        byteBuffer.put(i5, b);
    }

    public void putDouble(double d) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 8;
        this.space = i5;
        byteBuffer.putDouble(i5, d);
    }

    public void putFloat(float f6) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 4;
        this.space = i5;
        byteBuffer.putFloat(i5, f6);
    }

    public void putInt(int i5) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 4;
        this.space = i6;
        byteBuffer.putInt(i6, i5);
    }

    public void putLong(long j6) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 8;
        this.space = i5;
        byteBuffer.putLong(i5, j6);
    }

    public void putShort(short s6) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 2;
        this.space = i5;
        byteBuffer.putShort(i5, s6);
    }

    public void required(int i5, int i6) {
        int iCapacity = this.bb.capacity() - i5;
        if (this.bb.getShort((iCapacity - this.bb.getInt(iCapacity)) + i6) == 0) {
            throw new AssertionError(androidx.collection.a.i(i6, "FlatBuffers: field ", " must be set"));
        }
    }

    public byte[] sizedByteArray(int i5, int i6) {
        finished();
        byte[] bArr = new byte[i6];
        this.bb.position(i5);
        this.bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer byteBufferDuplicate = this.bb.duplicate();
        byteBufferDuplicate.position(this.space);
        byteBufferDuplicate.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(byteBufferDuplicate);
    }

    public void slot(int i5) {
        this.vtable[i5] = offset();
    }

    public void startTable(int i5) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i5) {
            this.vtable = new int[i5];
        }
        this.vtable_in_use = i5;
        Arrays.fill(this.vtable, 0, i5, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i5, int i6, int i7) {
        notNested();
        this.vector_num_elems = i6;
        int i8 = i5 * i6;
        prep(4, i8);
        prep(i7, i8);
        this.nested = true;
    }

    public FlatBufferBuilder(int i5, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i5 = i5 <= 0 ? 1 : i5;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.bb = byteBuffer;
            byteBuffer.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = byteBufferFactory.newByteBuffer(i5);
        }
        this.utf8 = utf8;
        this.space = this.bb.capacity();
    }

    public void addBoolean(int i5, boolean z6, boolean z7) {
        if (this.force_defaults || z6 != z7) {
            addBoolean(z6);
            slot(i5);
        }
    }

    public void addByte(int i5, byte b, int i6) {
        if (this.force_defaults || b != i6) {
            addByte(b);
            slot(i5);
        }
    }

    public void addDouble(int i5, double d, double d6) {
        if (this.force_defaults || d != d6) {
            addDouble(d);
            slot(i5);
        }
    }

    public void addFloat(int i5, float f6, double d) {
        if (this.force_defaults || f6 != d) {
            addFloat(f6);
            slot(i5);
        }
    }

    public void addInt(int i5, int i6, int i7) {
        if (this.force_defaults || i6 != i7) {
            addInt(i6);
            slot(i5);
        }
    }

    public void addLong(int i5, long j6, long j7) {
        if (this.force_defaults || j6 != j7) {
            addLong(j6);
            slot(i5);
        }
    }

    public void addShort(int i5, short s6, int i6) {
        if (this.force_defaults || s6 != i6) {
            addShort(s6);
            slot(i5);
        }
    }

    public void finishSizePrefixed(int i5, String str) {
        finish(i5, str, true);
    }

    public void addOffset(int i5, int i6, int i7) {
        if (this.force_defaults || i6 != i7) {
            addOffset(i6);
            slot(i5);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i5, int i6) {
        startVector(1, i6, 1);
        ByteBuffer byteBuffer = this.bb;
        int i7 = this.space - i6;
        this.space = i7;
        byteBuffer.position(i7);
        this.bb.put(bArr, i5, i6);
        return endVector();
    }

    public void finish(int i5) {
        finish(i5, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i5 = this.space - iRemaining;
        this.space = i5;
        byteBuffer2.position(i5);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i5, String str, boolean z6) {
        prep(this.minalign, (z6 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i6 = 3; i6 >= 0; i6--) {
                addByte((byte) str.charAt(i6));
            }
            finish(i5, z6);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i5 = this.space - iRemaining;
        this.space = i5;
        byteBuffer2.position(i5);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i5, String str) {
        finish(i5, str, false);
    }

    public FlatBufferBuilder(int i5) {
        this(i5, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i5);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }
}
