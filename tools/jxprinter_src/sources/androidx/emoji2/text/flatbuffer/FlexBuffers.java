package androidx.emoji2.text.flatbuffer;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        public Blob(ReadBuf readBuf, int i5, int i6) {
            super(readBuf, i5, i6);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.bb.data());
            byteBufferWrap.position(this.end);
            byteBufferWrap.limit(size() + this.end);
            return byteBufferWrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i5) {
            return this.bb.get(this.end + i5);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i5 = 0; i5 < size; i5++) {
                bArr[i5] = this.bb.get(this.end + i5);
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append(Chars.DQUOTE);
            sb.append(this.bb.getString(this.end, size()));
            sb.append(Chars.DQUOTE);
            return sb;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Key extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        public Key(ReadBuf readBuf, int i5, int i6) {
            super(readBuf, i5, i6);
        }

        public static Key empty() {
            return EMPTY;
        }

        public int compareTo(byte[] bArr) {
            byte b;
            byte b6;
            int i5 = this.end;
            int i6 = 0;
            do {
                b = this.bb.get(i5);
                b6 = bArr[i6];
                if (b == 0) {
                    return b - b6;
                }
                i5++;
                i6++;
                if (i6 == bArr.length) {
                    return b - b6;
                }
            } while (b == b6);
            return b - b6;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.end == this.end && key.byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append(toString());
            return sb;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i5 = this.end;
            while (this.bb.get(i5) != 0) {
                i5++;
            }
            int i6 = this.end;
            return this.bb.getString(i6, i5 - i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class KeyVector {
        private final TypedVector vec;

        public KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i5) {
            if (i5 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            int i6 = (i5 * typedVector.byteWidth) + typedVector.end;
            TypedVector typedVector2 = this.vec;
            ReadBuf readBuf = typedVector2.bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, i6, typedVector2.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i5 = 0; i5 < this.vec.size(); i5++) {
                this.vec.get(i5).toString(sb);
                if (i5 != this.vec.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);

        public Map(ReadBuf readBuf, int i5, int i6) {
            super(readBuf, i5, i6);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i5 = 0;
            while (i5 <= size) {
                int i6 = (i5 + size) >>> 1;
                int iCompareTo = keyVector.get(i6).compareTo(bArr);
                if (iCompareTo < 0) {
                    i5 = i6 + 1;
                } else {
                    if (iCompareTo <= 0) {
                        return i6;
                    }
                    size = i6 - 1;
                }
            }
            return -(i5 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int i5 = this.end - (this.byteWidth * 3);
            ReadBuf readBuf = this.bb;
            int iIndirect = FlexBuffers.indirect(readBuf, i5, this.byteWidth);
            ReadBuf readBuf2 = this.bb;
            int i6 = this.byteWidth;
            return new KeyVector(new TypedVector(readBuf, iIndirect, FlexBuffers.readInt(readBuf2, i5 + i6, i6), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keyVectorKeys = keys();
            int size = size();
            Vector vectorValues = values();
            for (int i5 = 0; i5 < size; i5++) {
                sb.append(Chars.DQUOTE);
                sb.append(keyVectorKeys.get(i5).toString());
                sb.append("\" : ");
                sb.append(vectorValues.get(i5).toString());
                if (i5 != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }

        public Reference get(byte[] bArr) {
            KeyVector keyVectorKeys = keys();
            int size = keyVectorKeys.size();
            int iBinarySearch = binarySearch(keyVectorKeys, bArr);
            return (iBinarySearch < 0 || iBinarySearch >= size) ? Reference.NULL_REFERENCE : get(iBinarySearch);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        public Object(ReadBuf readBuf, int i5, int i6) {
            this.bb = readBuf;
            this.end = i5;
            this.byteWidth = i6;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        public Reference(ReadBuf readBuf, int i5, int i6, int i7) {
            this(readBuf, i5, i6, 1 << (i7 & 3), i7 >> 2);
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                return this.bb.get(this.end) != 0;
            }
            return asUInt() != 0;
        }

        public double asFloat() {
            int i5 = this.type;
            if (i5 == 3) {
                return FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i5 != 2) {
                if (i5 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i5 == 6) {
                    ReadBuf readBuf = this.bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i5 == 7) {
                    ReadBuf readBuf2 = this.bb;
                    return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                }
                if (i5 == 8) {
                    ReadBuf readBuf3 = this.bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                }
                if (i5 == 10) {
                    return asVector().size();
                }
                if (i5 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int i5 = this.type;
            if (i5 == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 2) {
                return (int) FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 3) {
                return (int) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 5) {
                return Integer.parseInt(asString());
            }
            if (i5 == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i5 == 7) {
                ReadBuf readBuf2 = this.bb;
                return (int) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i5 == 8) {
                ReadBuf readBuf3 = this.bb;
                return (int) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i5 == 10) {
                return asVector().size();
            }
            if (i5 != 26) {
                return 0;
            }
            return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public long asLong() {
            int i5 = this.type;
            if (i5 == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 3) {
                return (long) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i5 == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i5 == 7) {
                ReadBuf readBuf2 = this.bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i5 == 8) {
                ReadBuf readBuf3 = this.bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i5 == 10) {
                return asVector().size();
            }
            if (i5 != 26) {
                return 0L;
            }
            return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int iIndirect = FlexBuffers.indirect(this.bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.bb;
                int i5 = this.byteWidth;
                return this.bb.getString(iIndirect, (int) FlexBuffers.readUInt(readBuf, iIndirect - i5, i5));
            }
            if (!isKey()) {
                return "";
            }
            int iIndirect2 = FlexBuffers.indirect(this.bb, this.end, this.byteWidth);
            int i6 = iIndirect2;
            while (this.bb.get(i6) != 0) {
                i6++;
            }
            return this.bb.getString(iIndirect2, i6 - iIndirect2);
        }

        public long asUInt() {
            int i5 = this.type;
            if (i5 == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 3) {
                return (long) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 10) {
                return asVector().size();
            }
            if (i5 == 26) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i5 == 5) {
                return Long.parseLong(asString());
            }
            if (i5 == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i5 == 7) {
                ReadBuf readBuf2 = this.bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            }
            if (i5 != 8) {
                return 0L;
            }
            ReadBuf readBuf3 = this.bb;
            return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i5 = this.type;
            if (i5 == 15) {
                ReadBuf readBuf2 = this.bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (!FlexBuffers.isTypedVector(i5)) {
                return Vector.empty();
            }
            ReadBuf readBuf3 = this.bb;
            return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            int i5 = this.type;
            return i5 == 3 || i5 == 8;
        }

        public boolean isInt() {
            int i5 = this.type;
            return i5 == 1 || i5 == 6;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i5 = this.type;
            return i5 == 2 || i5 == 7;
        }

        public boolean isVector() {
            int i5 = this.type;
            return i5 == 10 || i5 == 9;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf readBuf, int i5, int i6, int i7, int i8) {
            this.bb = readBuf;
            this.end = i5;
            this.parentWidth = i6;
            this.byteWidth = i7;
            this.type = i8;
        }

        public StringBuilder toString(StringBuilder sb) {
            int i5 = this.type;
            if (i5 != 36) {
                switch (i5) {
                    case 0:
                        sb.append(AbstractC1127c.NULL);
                        return sb;
                    case 1:
                    case 6:
                        sb.append(asLong());
                        return sb;
                    case 2:
                    case 7:
                        sb.append(asUInt());
                        return sb;
                    case 3:
                    case 8:
                        sb.append(asFloat());
                        return sb;
                    case 4:
                        Key keyAsKey = asKey();
                        sb.append(Chars.DQUOTE);
                        StringBuilder string = keyAsKey.toString(sb);
                        string.append(Chars.DQUOTE);
                        return string;
                    case 5:
                        sb.append(Chars.DQUOTE);
                        sb.append(asString());
                        sb.append(Chars.DQUOTE);
                        return sb;
                    case 9:
                        return asMap().toString(sb);
                    case 10:
                        return asVector().toString(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb);
                    case 26:
                        sb.append(asBoolean());
                        return sb;
                    default:
                        return sb;
                }
            }
            sb.append(asVector());
            return sb;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Sized extends Object {
        protected final int size;

        public Sized(ReadBuf readBuf, int i5, int i6) {
            super(readBuf, i5, i6);
            this.size = FlexBuffers.readInt(this.bb, i5 - i6, i6);
        }

        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        public TypedVector(ReadBuf readBuf, int i5, int i6, int i7) {
            super(readBuf, i5, i6);
            this.elemType = i7;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i5) {
            if (i5 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.bb, (i5 * this.byteWidth) + this.end, this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Unsigned {
        public static int byteToUnsignedInt(byte b) {
            return b & UnsignedBytes.MAX_VALUE;
        }

        public static long intToUnsignedLong(int i5) {
            return ((long) i5) & KeyboardMap.kValueMask;
        }

        public static int shortToUnsignedInt(short s6) {
            return s6 & 65535;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        public Vector(ReadBuf readBuf, int i5, int i6) {
            super(readBuf, i5, i6);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i5) {
            long size = size();
            long j6 = i5;
            if (j6 >= size) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.bb, (i5 * this.byteWidth) + this.end, this.byteWidth, Unsigned.byteToUnsignedInt(this.bb.get((int) ((size * ((long) this.byteWidth)) + ((long) this.end) + j6))));
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            for (int i5 = 0; i5 < size; i5++) {
                get(i5).toString(sb);
                if (i5 != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indirect(ReadBuf readBuf, int i5, int i6) {
        return (int) (((long) i5) - readUInt(readBuf, i5, i6));
    }

    public static boolean isTypeInline(int i5) {
        return i5 <= 3 || i5 == 26;
    }

    public static boolean isTypedVector(int i5) {
        return (i5 >= 11 && i5 <= 15) || i5 == 36;
    }

    public static boolean isTypedVectorElementType(int i5) {
        return (i5 >= 1 && i5 <= 4) || i5 == 26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double readDouble(ReadBuf readBuf, int i5, int i6) {
        if (i6 == 4) {
            return readBuf.getFloat(i5);
        }
        if (i6 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readInt(ReadBuf readBuf, int i5, int i6) {
        return (int) readLong(readBuf, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readLong(ReadBuf readBuf, int i5, int i6) {
        int i7;
        if (i6 == 1) {
            i7 = readBuf.get(i5);
        } else if (i6 == 2) {
            i7 = readBuf.getShort(i5);
        } else {
            if (i6 != 4) {
                if (i6 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i5);
            }
            i7 = readBuf.getInt(i5);
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readUInt(ReadBuf readBuf, int i5, int i6) {
        if (i6 == 1) {
            return Unsigned.byteToUnsignedInt(readBuf.get(i5));
        }
        if (i6 == 2) {
            return Unsigned.shortToUnsignedInt(readBuf.getShort(i5));
        }
        if (i6 == 4) {
            return Unsigned.intToUnsignedLong(readBuf.getInt(i5));
        }
        if (i6 != 8) {
            return -1L;
        }
        return readBuf.getLong(i5);
    }

    public static int toTypedVector(int i5, int i6) {
        if (i6 == 0) {
            return i5 + 10;
        }
        if (i6 == 2) {
            return i5 + 15;
        }
        if (i6 == 3) {
            return i5 + 18;
        }
        if (i6 != 4) {
            return 0;
        }
        return i5 + 21;
    }

    public static int toTypedVectorElementType(int i5) {
        return i5 - 10;
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int iLimit = readBuf.limit();
        byte b = readBuf.get(iLimit - 1);
        int i5 = iLimit - 2;
        return new Reference(readBuf, i5 - b, b, Unsigned.byteToUnsignedInt(readBuf.get(i5)));
    }
}
