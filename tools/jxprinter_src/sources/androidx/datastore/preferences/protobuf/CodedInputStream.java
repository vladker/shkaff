package androidx.datastore.preferences.protobuf;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i5 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i5;
            int i6 = i5 - this.startPos;
            int i7 = this.currentLimit;
            if (i6 <= i7) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i8 = i6 - i7;
            this.bufferSizeAfterLimit = i8;
            this.limit = i5 - i8;
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.buffer;
                int i6 = this.pos;
                this.pos = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(int i5) throws InvalidProtocolBufferException {
            if (this.lastTag != i5) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
            this.enableAliasing = z6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i5 = this.currentLimit;
            if (i5 == Integer.MAX_VALUE) {
                return -1;
            }
            return i5 - getTotalBytesRead();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(int i5) {
            this.currentLimit = i5;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i5 + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i6 = this.currentLimit;
            if (totalBytesRead > i6) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (rawVarint32 <= i5 - i6) {
                    ByteBuffer byteBufferWrap = (this.immutable || !this.enableAliasing) ? ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i6, i6 + rawVarint32)) : ByteBuffer.wrap(this.buffer, i6, rawVarint32).slice();
                    this.pos += rawVarint32;
                    return byteBufferWrap;
                }
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (rawVarint32 <= i5 - i6) {
                    ByteString byteStringWrap = (this.immutable && this.enableAliasing) ? ByteString.wrap(this.buffer, i6, rawVarint32) : ByteString.copyFrom(this.buffer, i6, rawVarint32);
                    this.pos += rawVarint32;
                    return byteStringWrap;
                }
            }
            return rawVarint32 == 0 ? ByteString.EMPTY : ByteString.wrap(readRawBytes(rawVarint32));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(int i5, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            int i5 = this.pos;
            if (i5 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 1;
            return bArr[i5];
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(int i5) throws InvalidProtocolBufferException {
            if (i5 > 0) {
                int i6 = this.limit;
                int i7 = this.pos;
                if (i5 <= i6 - i7) {
                    int i8 = i5 + i7;
                    this.pos = i8;
                    return Arrays.copyOfRange(this.buffer, i7, i8);
                }
            }
            if (i5 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i5 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i5 = this.pos;
            if (this.limit - i5 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 4;
            return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i5] & UnsignedBytes.MAX_VALUE) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i5 = this.pos;
            if (this.limit - i5 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 8;
            return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i5;
            int i6 = this.pos;
            int i7 = this.limit;
            if (i7 != i6) {
                byte[] bArr = this.buffer;
                int i8 = i6 + 1;
                byte b = bArr[i6];
                if (b >= 0) {
                    this.pos = i8;
                    return b;
                }
                if (i7 - i8 >= 9) {
                    int i9 = i6 + 2;
                    int i10 = (bArr[i8] << 7) ^ b;
                    if (i10 < 0) {
                        i5 = i10 ^ (-128);
                    } else {
                        int i11 = i6 + 3;
                        int i12 = (bArr[i9] << 14) ^ i10;
                        if (i12 >= 0) {
                            i5 = i12 ^ 16256;
                        } else {
                            int i13 = i6 + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i5 = (-2080896) ^ i14;
                            } else {
                                i11 = i6 + 5;
                                byte b6 = bArr[i13];
                                int i15 = (i14 ^ (b6 << Ascii.FS)) ^ 266354560;
                                if (b6 < 0) {
                                    i13 = i6 + 6;
                                    if (bArr[i11] < 0) {
                                        i11 = i6 + 7;
                                        if (bArr[i13] < 0) {
                                            i13 = i6 + 8;
                                            if (bArr[i11] < 0) {
                                                i11 = i6 + 9;
                                                if (bArr[i13] < 0) {
                                                    int i16 = i6 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i9 = i16;
                                                        i5 = i15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i15;
                                }
                                i5 = i15;
                            }
                            i9 = i13;
                        }
                        i9 = i11;
                    }
                    this.pos = i9;
                    return i5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            int i5 = this.pos;
            int i6 = this.limit;
            if (i6 != i5) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b = bArr[i5];
                if (b >= 0) {
                    this.pos = i7;
                    return b;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b;
                    if (i9 < 0) {
                        j6 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            j6 = i11 ^ 16256;
                            i8 = i10;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                long j9 = (-2080896) ^ i13;
                                i8 = i12;
                                j6 = j9;
                            } else {
                                long j10 = i13;
                                i8 = i5 + 5;
                                long j11 = j10 ^ (((long) bArr[i12]) << 28);
                                if (j11 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    int i14 = i5 + 6;
                                    long j12 = j11 ^ (((long) bArr[i8]) << 35);
                                    if (j12 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        i8 = i5 + 7;
                                        j11 = j12 ^ (((long) bArr[i14]) << 42);
                                        if (j11 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            i14 = i5 + 8;
                                            j12 = j11 ^ (((long) bArr[i8]) << 49);
                                            if (j12 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j13 = (j12 ^ (((long) bArr[i14]) << 56)) ^ 71499008037633920L;
                                                if (j13 < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i15;
                                                    }
                                                }
                                                j6 = j13;
                                            }
                                        }
                                    }
                                    j6 = j12 ^ j7;
                                    i8 = i14;
                                }
                                j6 = j11 ^ j8;
                            }
                        }
                    }
                    this.pos = i8;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & Ascii.DEL)) << i5;
                if ((rawByte & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (rawVarint32 <= i5 - i6) {
                    String str = new String(this.buffer, i6, rawVarint32, Internal.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (rawVarint32 <= i5 - i6) {
                    String strDecodeUtf8 = Utf8.decodeUtf8(this.buffer, i6, rawVarint32);
                    this.pos += rawVarint32;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i5, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i5, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(int i5) throws InvalidProtocolBufferException {
            if (i5 >= 0) {
                int i6 = this.limit;
                int i7 = this.pos;
                if (i5 <= i6 - i7) {
                    this.pos = i7 + i5;
                    return;
                }
            }
            if (i5 >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private ArrayDecoder(byte[] bArr, int i5, int i6, boolean z6) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i6 + i5;
            this.pos = i5;
            this.startPos = i5;
            this.immutable = z6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i5, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i5);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeUInt32NoTag(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void readRawBytesTo(byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            if (i6 < 0 || i6 > remaining()) {
                if (i6 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i6 != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i7 = i6;
            while (i7 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(i7, (int) currentRemaining());
                long j6 = iMin;
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (i6 - i7) + i5, j6);
                i7 -= iMin;
                this.currentByteBufferPos += j6;
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i5 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i5;
            int i6 = i5 - this.startOffset;
            int i7 = this.currentLimit;
            if (i6 <= i7) {
                this.bufferSizeAfterCurrentLimit = 0;
                return;
            }
            int i8 = i6 - i7;
            this.bufferSizeAfterCurrentLimit = i8;
            this.totalBufferSize = i5 - i8;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(int i5, int i6) {
            int iPosition = this.currentByteBuffer.position();
            int iLimit = this.currentByteBuffer.limit();
            ByteBuffer byteBuffer = this.currentByteBuffer;
            try {
                try {
                    byteBuffer.position(i5);
                    byteBuffer.limit(i6);
                    ByteBuffer byteBufferSlice = this.currentByteBuffer.slice();
                    byteBuffer.position(iPosition);
                    byteBuffer.limit(iLimit);
                    return byteBufferSlice;
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } catch (Throwable th) {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
                throw th;
            }
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long jPosition = next.position();
            this.currentByteBufferPos = jPosition;
            this.currentByteBufferStartPos = jPosition;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long jAddressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = jAddressOffset;
            this.currentByteBufferPos += jAddressOffset;
            this.currentByteBufferStartPos += jAddressOffset;
            this.currentByteBufferLimit += jAddressOffset;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(int i5) throws InvalidProtocolBufferException {
            if (this.lastTag != i5) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
            this.enableAliasing = z6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i5 = this.currentLimit;
            if (i5 == Integer.MAX_VALUE) {
                return -1;
            }
            return i5 - getTotalBytesRead();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(int i5) {
            this.currentLimit = i5;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i5 + getTotalBytesRead();
            int i6 = this.currentLimit;
            if (totalBytesRead > i6) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                if (j6 <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[rawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j6);
                        this.currentByteBufferPos += j6;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j7 = this.currentByteBufferPos + j6;
                    this.currentByteBufferPos = j7;
                    long j8 = this.currentAddress;
                    return slice((int) ((j7 - j8) - j6), (int) (j7 - j8));
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return ByteBuffer.wrap(bArr2);
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                long j7 = this.currentByteBufferLimit;
                long j8 = this.currentByteBufferPos;
                if (j6 <= j7 - j8) {
                    if (this.immutable && this.enableAliasing) {
                        int i5 = (int) (j8 - this.currentAddress);
                        ByteString byteStringWrap = ByteString.wrap(slice(i5, rawVarint32 + i5));
                        this.currentByteBufferPos += j6;
                        return byteStringWrap;
                    }
                    byte[] bArr = new byte[rawVarint32];
                    UnsafeUtil.copyMemory(j8, bArr, 0L, j6);
                    this.currentByteBufferPos += j6;
                    return ByteString.wrap(bArr);
                }
            }
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.immutable || !this.enableAliasing) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return ByteString.wrap(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (rawVarint32 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(rawVarint32, (int) currentRemaining());
                int i6 = (int) (this.currentByteBufferPos - this.currentAddress);
                arrayList.add(ByteString.wrap(slice(i6, i6 + iMin)));
                rawVarint32 -= iMin;
                this.currentByteBufferPos += (long) iMin;
            }
            return ByteString.copyFrom(arrayList);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(int i5, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j6 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j6;
            return UnsafeUtil.getByte(j6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(int i5) throws InvalidProtocolBufferException {
            if (i5 >= 0) {
                long j6 = i5;
                if (j6 <= currentRemaining()) {
                    byte[] bArr = new byte[i5];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j6);
                    this.currentByteBufferPos += j6;
                    return bArr;
                }
            }
            if (i5 >= 0 && i5 <= remaining()) {
                byte[] bArr2 = new byte[i5];
                readRawBytesTo(bArr2, 0, i5);
                return bArr2;
            }
            if (i5 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i5 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            if (currentRemaining() < 4) {
                return (readRawByte() & UnsignedBytes.MAX_VALUE) | ((readRawByte() & UnsignedBytes.MAX_VALUE) << 8) | ((readRawByte() & UnsignedBytes.MAX_VALUE) << 16) | ((readRawByte() & UnsignedBytes.MAX_VALUE) << 24);
            }
            long j6 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j6;
            return ((UnsafeUtil.getByte(j6 + 3) & UnsignedBytes.MAX_VALUE) << 24) | (UnsafeUtil.getByte(j6) & UnsignedBytes.MAX_VALUE) | ((UnsafeUtil.getByte(1 + j6) & UnsignedBytes.MAX_VALUE) << 8) | ((UnsafeUtil.getByte(2 + j6) & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            char c;
            long rawByte;
            byte rawByte2;
            if (currentRemaining() >= 8) {
                long j6 = this.currentByteBufferPos;
                this.currentByteBufferPos = 8 + j6;
                c = '8';
                rawByte = (((long) UnsafeUtil.getByte(j6)) & 255) | ((((long) UnsafeUtil.getByte(1 + j6)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j6)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j6)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j6)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j6)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j6)) & 255) << 48);
                rawByte2 = UnsafeUtil.getByte(j6 + 7);
            } else {
                c = '8';
                rawByte = (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48);
                rawByte2 = readRawByte();
            }
            return rawByte | ((((long) rawByte2) & 255) << c);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i5;
            long j6 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j6) {
                long j7 = j6 + 1;
                byte b = UnsafeUtil.getByte(j6);
                if (b >= 0) {
                    this.currentByteBufferPos++;
                    return b;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j8 = 2 + j6;
                    int i6 = (UnsafeUtil.getByte(j7) << 7) ^ b;
                    if (i6 < 0) {
                        i5 = i6 ^ (-128);
                    } else {
                        long j9 = 3 + j6;
                        int i7 = (UnsafeUtil.getByte(j8) << 14) ^ i6;
                        if (i7 >= 0) {
                            i5 = i7 ^ 16256;
                        } else {
                            long j10 = 4 + j6;
                            int i8 = i7 ^ (UnsafeUtil.getByte(j9) << 21);
                            if (i8 < 0) {
                                i5 = (-2080896) ^ i8;
                            } else {
                                j9 = 5 + j6;
                                byte b6 = UnsafeUtil.getByte(j10);
                                int i9 = (i8 ^ (b6 << Ascii.FS)) ^ 266354560;
                                if (b6 < 0) {
                                    j10 = 6 + j6;
                                    if (UnsafeUtil.getByte(j9) < 0) {
                                        j9 = 7 + j6;
                                        if (UnsafeUtil.getByte(j10) < 0) {
                                            j10 = 8 + j6;
                                            if (UnsafeUtil.getByte(j9) < 0) {
                                                j9 = 9 + j6;
                                                if (UnsafeUtil.getByte(j10) < 0) {
                                                    long j11 = j6 + 10;
                                                    if (UnsafeUtil.getByte(j9) >= 0) {
                                                        i5 = i9;
                                                        j8 = j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i9;
                                }
                                i5 = i9;
                            }
                            j8 = j10;
                        }
                        j8 = j9;
                    }
                    this.currentByteBufferPos = j8;
                    return i5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            long j9 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j9) {
                long j10 = j9 + 1;
                byte b = UnsafeUtil.getByte(j9);
                if (b >= 0) {
                    this.currentByteBufferPos++;
                    return b;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j11 = 2 + j9;
                    int i5 = (UnsafeUtil.getByte(j10) << 7) ^ b;
                    if (i5 < 0) {
                        j6 = i5 ^ (-128);
                    } else {
                        long j12 = 3 + j9;
                        int i6 = (UnsafeUtil.getByte(j11) << 14) ^ i5;
                        if (i6 >= 0) {
                            j6 = i6 ^ 16256;
                            j11 = j12;
                        } else {
                            long j13 = 4 + j9;
                            int i7 = i6 ^ (UnsafeUtil.getByte(j12) << 21);
                            if (i7 < 0) {
                                j6 = (-2080896) ^ i7;
                                j11 = j13;
                            } else {
                                long j14 = 5 + j9;
                                long j15 = (((long) UnsafeUtil.getByte(j13)) << 28) ^ ((long) i7);
                                if (j15 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    long j16 = 6 + j9;
                                    long j17 = j15 ^ (((long) UnsafeUtil.getByte(j14)) << 35);
                                    if (j17 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        j14 = 7 + j9;
                                        j15 = j17 ^ (((long) UnsafeUtil.getByte(j16)) << 42);
                                        if (j15 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            j16 = 8 + j9;
                                            j17 = j15 ^ (((long) UnsafeUtil.getByte(j14)) << 49);
                                            if (j17 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                j14 = 9 + j9;
                                                long j18 = (j17 ^ (((long) UnsafeUtil.getByte(j16)) << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    long j19 = j9 + 10;
                                                    if (UnsafeUtil.getByte(j14) >= 0) {
                                                        j11 = j19;
                                                        j6 = j18;
                                                    }
                                                } else {
                                                    j6 = j18;
                                                    j11 = j14;
                                                }
                                            }
                                        }
                                    }
                                    j6 = j7 ^ j17;
                                    j11 = j16;
                                }
                                j6 = j8 ^ j15;
                                j11 = j14;
                            }
                        }
                    }
                    this.currentByteBufferPos = j11;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & Ascii.DEL)) << i5;
                if ((rawByte & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                long j7 = this.currentByteBufferLimit;
                long j8 = this.currentByteBufferPos;
                if (j6 <= j7 - j8) {
                    byte[] bArr = new byte[rawVarint32];
                    UnsafeUtil.copyMemory(j8, bArr, 0L, j6);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j6;
                    return str;
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return new String(bArr2, Internal.UTF_8);
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j6 = rawVarint32;
                long j7 = this.currentByteBufferLimit;
                long j8 = this.currentByteBufferPos;
                if (j6 <= j7 - j8) {
                    String strDecodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j8 - this.currentByteBufferStartPos), rawVarint32);
                    this.currentByteBufferPos += j6;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 >= 0 && rawVarint32 <= remaining()) {
                byte[] bArr = new byte[rawVarint32];
                readRawBytesTo(bArr, 0, rawVarint32);
                return Utf8.decodeUtf8(bArr, 0, rawVarint32);
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i5, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i5, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0 || i5 > (((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (i5 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i5 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(i5, (int) currentRemaining());
                i5 -= iMin;
                this.currentByteBufferPos += (long) iMin;
            }
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i5, boolean z6) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i5;
            this.input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z6;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i5 != 0) {
                tryGetNextByteBuffer();
                return;
            }
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0L;
            this.currentByteBufferStartPos = 0L;
            this.currentByteBufferLimit = 0L;
            this.currentAddress = 0L;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i5, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i5);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeUInt32NoTag(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface RefillCallback {
            void onRefill();
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }

            @Override // androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }
        }

        private static int available(InputStream inputStream) throws InvalidProtocolBufferException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private static int read(InputStream inputStream, byte[] bArr, int i5, int i6) throws InvalidProtocolBufferException {
            try {
                return inputStream.read(bArr, i5, i6);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private ByteString readBytesSlowPath(int i5) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i5);
            if (rawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(rawBytesSlowPathOneChunk);
            }
            int i6 = this.pos;
            int i7 = this.bufferSize;
            int length = i7 - i6;
            this.totalBytesRetired += i7;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i5 - length);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.buffer, i6, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i5, boolean z6) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i5);
            if (rawBytesSlowPathOneChunk != null) {
                return z6 ? (byte[]) rawBytesSlowPathOneChunk.clone() : rawBytesSlowPathOneChunk;
            }
            int i6 = this.pos;
            int i7 = this.bufferSize;
            int length = i7 - i6;
            this.totalBytesRetired += i7;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i5 - length);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.buffer, i6, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i5) throws InvalidProtocolBufferException {
            if (i5 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i6 = this.totalBytesRetired;
            int i7 = this.pos;
            int i8 = i6 + i7 + i5;
            if (i8 - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i9 = this.currentLimit;
            if (i8 > i9) {
                skipRawBytes((i9 - i6) - i7);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i10 = this.bufferSize - i7;
            int i11 = i5 - i10;
            if (i11 >= 4096 && i11 > available(this.input)) {
                return null;
            }
            byte[] bArr = new byte[i5];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i10);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i10 < i5) {
                int i12 = read(this.input, bArr, i10, i5 - i10);
                if (i12 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += i12;
                i10 += i12;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i5) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i5 > 0) {
                int iMin = Math.min(i5, 4096);
                byte[] bArr = new byte[iMin];
                int i6 = 0;
                while (i6 < iMin) {
                    int i7 = this.input.read(bArr, i6, iMin - i6);
                    if (i7 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += i7;
                    i6 += i7;
                }
                i5 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i5 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i5;
            int i6 = this.totalBytesRetired + i5;
            int i7 = this.currentLimit;
            if (i6 <= i7) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i8 = i6 - i7;
            this.bufferSizeAfterLimit = i8;
            this.bufferSize = i5 - i8;
        }

        private void refillBuffer(int i5) throws InvalidProtocolBufferException {
            if (tryRefillBuffer(i5)) {
                return;
            }
            if (i5 <= (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        private static long skip(InputStream inputStream, long j6) throws InvalidProtocolBufferException {
            try {
                return inputStream.skip(j6);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private void skipRawBytesSlowPath(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i6 = this.totalBytesRetired;
            int i7 = this.pos;
            int i8 = i6 + i7 + i5;
            int i9 = this.currentLimit;
            if (i8 > i9) {
                skipRawBytes((i9 - i6) - i7);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i10 = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i6 + i7;
                int i11 = this.bufferSize - i7;
                this.bufferSize = 0;
                this.pos = 0;
                i10 = i11;
                while (i10 < i5) {
                    try {
                        long j6 = i5 - i10;
                        long jSkip = skip(this.input, j6);
                        if (jSkip < 0 || jSkip > j6) {
                            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i10 += (int) jSkip;
                        }
                    } finally {
                        this.totalBytesRetired += i10;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (i10 >= i5) {
                return;
            }
            int i12 = this.bufferSize;
            int i13 = i12 - this.pos;
            this.pos = i12;
            refillBuffer(1);
            while (true) {
                int i14 = i5 - i13;
                int i15 = this.bufferSize;
                if (i14 <= i15) {
                    this.pos = i14;
                    return;
                } else {
                    i13 += i15;
                    this.pos = i15;
                    refillBuffer(1);
                }
            }
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.buffer;
                int i6 = this.pos;
                this.pos = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i5) throws InvalidProtocolBufferException {
            int i6 = this.pos;
            if (i6 + i5 <= this.bufferSize) {
                throw new IllegalStateException(a.i(i5, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
            int i7 = this.sizeLimit;
            int i8 = this.totalBytesRetired;
            if (i5 > (i7 - i8) - i6 || i8 + i6 + i5 > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int i9 = this.pos;
            if (i9 > 0) {
                int i10 = this.bufferSize;
                if (i10 > i9) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i9, bArr, 0, i10 - i9);
                }
                this.totalBytesRetired += i9;
                this.bufferSize -= i9;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i11 = this.bufferSize;
            int i12 = read(inputStream, bArr2, i11, Math.min(bArr2.length - i11, (this.sizeLimit - this.totalBytesRetired) - i11));
            if (i12 == 0 || i12 < -1 || i12 > this.buffer.length) {
                throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + i12 + "\nThe InputStream implementation is buggy.");
            }
            if (i12 <= 0) {
                return false;
            }
            this.bufferSize += i12;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i5) {
                return true;
            }
            return tryRefillBuffer(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(int i5) throws InvalidProtocolBufferException {
            if (this.lastTag != i5) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i5 = this.currentLimit;
            if (i5 == Integer.MAX_VALUE) {
                return -1;
            }
            return i5 - (this.totalBytesRetired + this.pos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(int i5) {
            this.currentLimit = i5;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i6 = this.totalBytesRetired + this.pos + i5;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i7 = this.currentLimit;
            if (i6 > i7) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i6;
            recomputeBufferSizeAfterLimit();
            return i7;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            int i5 = this.bufferSize;
            int i6 = this.pos;
            if (rawVarint32 > i5 - i6 || rawVarint32 <= 0) {
                if (rawVarint32 >= 0) {
                    return readRawBytesSlowPath(rawVarint32, false);
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(this.buffer, i6, i6 + rawVarint32);
            this.pos += rawVarint32;
            return bArrCopyOfRange;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            int i5 = this.bufferSize;
            int i6 = this.pos;
            if (rawVarint32 <= i5 - i6 && rawVarint32 > 0) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i6, i6 + rawVarint32));
                this.pos += rawVarint32;
                return byteBufferWrap;
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 >= 0) {
                return ByteBuffer.wrap(readRawBytesSlowPath(rawVarint32, true));
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            int i5 = this.bufferSize;
            int i6 = this.pos;
            if (rawVarint32 <= i5 - i6 && rawVarint32 > 0) {
                ByteString byteStringCopyFrom = ByteString.copyFrom(this.buffer, i6, rawVarint32);
                this.pos += rawVarint32;
                return byteStringCopyFrom;
            }
            if (rawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (rawVarint32 >= 0) {
                return readBytesSlowPath(rawVarint32);
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(int i5, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            this.pos = i5 + 1;
            return bArr[i5];
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(int i5) {
            int i6 = this.pos;
            if (i5 > this.bufferSize - i6 || i5 <= 0) {
                return readRawBytesSlowPath(i5, false);
            }
            int i7 = i5 + i6;
            this.pos = i7;
            return Arrays.copyOfRange(this.buffer, i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i5 = this.pos;
            if (this.bufferSize - i5 < 4) {
                refillBuffer(4);
                i5 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 4;
            return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i5] & UnsignedBytes.MAX_VALUE) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i5 = this.pos;
            if (this.bufferSize - i5 < 8) {
                refillBuffer(8);
                i5 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 8;
            return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i5;
            int i6 = this.pos;
            int i7 = this.bufferSize;
            if (i7 != i6) {
                byte[] bArr = this.buffer;
                int i8 = i6 + 1;
                byte b = bArr[i6];
                if (b >= 0) {
                    this.pos = i8;
                    return b;
                }
                if (i7 - i8 >= 9) {
                    int i9 = i6 + 2;
                    int i10 = (bArr[i8] << 7) ^ b;
                    if (i10 < 0) {
                        i5 = i10 ^ (-128);
                    } else {
                        int i11 = i6 + 3;
                        int i12 = (bArr[i9] << 14) ^ i10;
                        if (i12 >= 0) {
                            i5 = i12 ^ 16256;
                        } else {
                            int i13 = i6 + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i5 = (-2080896) ^ i14;
                            } else {
                                i11 = i6 + 5;
                                byte b6 = bArr[i13];
                                int i15 = (i14 ^ (b6 << Ascii.FS)) ^ 266354560;
                                if (b6 < 0) {
                                    i13 = i6 + 6;
                                    if (bArr[i11] < 0) {
                                        i11 = i6 + 7;
                                        if (bArr[i13] < 0) {
                                            i13 = i6 + 8;
                                            if (bArr[i11] < 0) {
                                                i11 = i6 + 9;
                                                if (bArr[i13] < 0) {
                                                    int i16 = i6 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i9 = i16;
                                                        i5 = i15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i15;
                                }
                                i5 = i15;
                            }
                            i9 = i13;
                        }
                        i9 = i11;
                    }
                    this.pos = i9;
                    return i5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            int i5 = this.pos;
            int i6 = this.bufferSize;
            if (i6 != i5) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b = bArr[i5];
                if (b >= 0) {
                    this.pos = i7;
                    return b;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b;
                    if (i9 < 0) {
                        j6 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            j6 = i11 ^ 16256;
                            i8 = i10;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                long j9 = (-2080896) ^ i13;
                                i8 = i12;
                                j6 = j9;
                            } else {
                                long j10 = i13;
                                i8 = i5 + 5;
                                long j11 = j10 ^ (((long) bArr[i12]) << 28);
                                if (j11 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    int i14 = i5 + 6;
                                    long j12 = j11 ^ (((long) bArr[i8]) << 35);
                                    if (j12 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        i8 = i5 + 7;
                                        j11 = j12 ^ (((long) bArr[i14]) << 42);
                                        if (j11 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            i14 = i5 + 8;
                                            j12 = j11 ^ (((long) bArr[i8]) << 49);
                                            if (j12 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j13 = (j12 ^ (((long) bArr[i14]) << 56)) ^ 71499008037633920L;
                                                if (j13 < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i15;
                                                    }
                                                }
                                                j6 = j13;
                                            }
                                        }
                                    }
                                    j6 = j12 ^ j7;
                                    i8 = i14;
                                }
                                j6 = j11 ^ j8;
                            }
                        }
                    }
                    this.pos = i8;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & Ascii.DEL)) << i5;
                if ((rawByte & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i5 = this.bufferSize;
                int i6 = this.pos;
                if (rawVarint32 <= i5 - i6) {
                    String str = new String(this.buffer, i6, rawVarint32, Internal.UTF_8);
                    this.pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (rawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(rawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(rawVarint32);
            String str2 = new String(this.buffer, this.pos, rawVarint32, Internal.UTF_8);
            this.pos += rawVarint32;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] rawBytesSlowPath;
            int rawVarint32 = readRawVarint32();
            int i5 = this.pos;
            int i6 = this.bufferSize;
            if (rawVarint32 <= i6 - i5 && rawVarint32 > 0) {
                rawBytesSlowPath = this.buffer;
                this.pos = i5 + rawVarint32;
            } else {
                if (rawVarint32 == 0) {
                    return "";
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                i5 = 0;
                if (rawVarint32 <= i6) {
                    refillBuffer(rawVarint32);
                    rawBytesSlowPath = this.buffer;
                    this.pos = rawVarint32;
                } else {
                    rawBytesSlowPath = readRawBytesSlowPath(rawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(rawBytesSlowPath, i5, rawVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i5, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i5, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(int i5) throws InvalidProtocolBufferException {
            int i6 = this.bufferSize;
            int i7 = this.pos;
            if (i5 > i6 - i7 || i5 < 0) {
                skipRawBytesSlowPath(i5);
            } else {
                this.pos = i7 + i5;
            }
        }

        private StreamDecoder(InputStream inputStream, int i5) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i5];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i5, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i5);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeUInt32NoTag(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private int bufferPos(long j6) {
            return (int) (j6 - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j6 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = j6;
            int i5 = (int) (j6 - this.startPos);
            int i6 = this.currentLimit;
            if (i5 <= i6) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i7 = i5 - i6;
            this.bufferSizeAfterLimit = i7;
            this.limit = j6 - ((long) i7);
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                long j6 = this.pos;
                this.pos = 1 + j6;
                if (UnsafeUtil.getByte(j6) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i5 = 0; i5 < 10; i5++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long j6, long j7) {
            int iPosition = this.buffer.position();
            int iLimit = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            try {
                try {
                    byteBuffer.position(bufferPos(j6));
                    byteBuffer.limit(bufferPos(j7));
                    ByteBuffer byteBufferSlice = this.buffer.slice();
                    byteBuffer.position(iPosition);
                    byteBuffer.limit(iLimit);
                    return byteBufferSlice;
                } catch (IllegalArgumentException e) {
                    InvalidProtocolBufferException invalidProtocolBufferExceptionTruncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                    invalidProtocolBufferExceptionTruncatedMessage.initCause(e);
                    throw invalidProtocolBufferExceptionTruncatedMessage;
                }
            } catch (Throwable th) {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
                throw th;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(int i5) throws InvalidProtocolBufferException {
            if (this.lastTag != i5) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void enableAliasing(boolean z6) {
            this.enableAliasing = z6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i5 = this.currentLimit;
            if (i5 == Integer.MAX_VALUE) {
                return -1;
            }
            return i5 - getTotalBytesRead();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(int i5) {
            this.currentLimit = i5;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i5 + getTotalBytesRead();
            int i6 = this.currentLimit;
            if (totalBytesRead > i6) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[rawVarint32];
                long j6 = rawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0L, j6);
                this.pos += j6;
                return ByteBuffer.wrap(bArr);
            }
            long j7 = this.pos;
            long j8 = rawVarint32;
            ByteBuffer byteBufferSlice = slice(j7, j7 + j8);
            this.pos += j8;
            return byteBufferSlice;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j6 = this.pos;
                long j7 = rawVarint32;
                ByteBuffer byteBufferSlice = slice(j6, j6 + j7);
                this.pos += j7;
                return ByteString.wrap(byteBufferSlice);
            }
            byte[] bArr = new byte[rawVarint32];
            long j8 = rawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j8);
            this.pos += j8;
            return ByteString.wrap(bArr);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readGroup(int i5, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            long j6 = this.pos;
            if (j6 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j6;
            return UnsafeUtil.getByte(j6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public byte[] readRawBytes(int i5) throws InvalidProtocolBufferException {
            if (i5 < 0 || i5 > remaining()) {
                if (i5 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i5 == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[i5];
            long j6 = this.pos;
            long j7 = i5;
            slice(j6, j6 + j7).get(bArr);
            this.pos += j7;
            return bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            long j6 = this.pos;
            if (this.limit - j6 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + j6;
            return ((UnsafeUtil.getByte(j6 + 3) & UnsignedBytes.MAX_VALUE) << 24) | (UnsafeUtil.getByte(j6) & UnsignedBytes.MAX_VALUE) | ((UnsafeUtil.getByte(1 + j6) & UnsignedBytes.MAX_VALUE) << 8) | ((UnsafeUtil.getByte(2 + j6) & UnsignedBytes.MAX_VALUE) << 16);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            long j6 = this.pos;
            if (this.limit - j6 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + j6;
            return ((((long) UnsafeUtil.getByte(j6 + 7)) & 255) << 56) | (((long) UnsafeUtil.getByte(j6)) & 255) | ((((long) UnsafeUtil.getByte(1 + j6)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j6)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j6)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j6)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j6)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j6)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3) < 0) goto L34;
         */
        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readRawVarint32() {
            /*
                r9 = this;
                long r0 = r9.pos
                long r2 = r9.limit
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0)
                if (r4 < 0) goto L16
                r9.pos = r2
                return r4
            L16:
                long r5 = r9.limit
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.pos = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j6;
            long j7;
            long j8;
            int i5;
            long j9 = this.pos;
            if (this.limit != j9) {
                long j10 = 1 + j9;
                byte b = UnsafeUtil.getByte(j9);
                if (b >= 0) {
                    this.pos = j10;
                    return b;
                }
                if (this.limit - j10 >= 9) {
                    long j11 = 2 + j9;
                    int i6 = (UnsafeUtil.getByte(j10) << 7) ^ b;
                    if (i6 >= 0) {
                        long j12 = 3 + j9;
                        int i7 = i6 ^ (UnsafeUtil.getByte(j11) << 14);
                        if (i7 >= 0) {
                            j6 = i7 ^ 16256;
                            j11 = j12;
                        } else {
                            j11 = 4 + j9;
                            int i8 = i7 ^ (UnsafeUtil.getByte(j12) << 21);
                            if (i8 < 0) {
                                i5 = (-2080896) ^ i8;
                            } else {
                                long j13 = 5 + j9;
                                long j14 = ((long) i8) ^ (((long) UnsafeUtil.getByte(j11)) << 28);
                                if (j14 >= 0) {
                                    j8 = 266354560;
                                } else {
                                    long j15 = 6 + j9;
                                    long j16 = j14 ^ (((long) UnsafeUtil.getByte(j13)) << 35);
                                    if (j16 < 0) {
                                        j7 = -34093383808L;
                                    } else {
                                        j13 = 7 + j9;
                                        j14 = j16 ^ (((long) UnsafeUtil.getByte(j15)) << 42);
                                        if (j14 >= 0) {
                                            j8 = 4363953127296L;
                                        } else {
                                            j15 = 8 + j9;
                                            j16 = j14 ^ (((long) UnsafeUtil.getByte(j13)) << 49);
                                            if (j16 < 0) {
                                                j7 = -558586000294016L;
                                            } else {
                                                long j17 = j9 + 9;
                                                long j18 = (j16 ^ (((long) UnsafeUtil.getByte(j15)) << 56)) ^ 71499008037633920L;
                                                if (j18 < 0) {
                                                    long j19 = j9 + 10;
                                                    if (UnsafeUtil.getByte(j17) >= 0) {
                                                        j11 = j19;
                                                        j6 = j18;
                                                    }
                                                } else {
                                                    j6 = j18;
                                                    j11 = j17;
                                                }
                                            }
                                        }
                                    }
                                    j6 = j7 ^ j16;
                                    j11 = j15;
                                }
                                j6 = j8 ^ j14;
                                j11 = j13;
                            }
                        }
                        this.pos = j11;
                        return j6;
                    }
                    i5 = i6 ^ (-128);
                    j6 = i5;
                    this.pos = j11;
                    return j6;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j6 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte rawByte = readRawByte();
                j6 |= ((long) (rawByte & Ascii.DEL)) << i5;
                if ((rawByte & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    return j6;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return "";
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[rawVarint32];
            long j6 = rawVarint32;
            UnsafeUtil.copyMemory(this.pos, bArr, 0L, j6);
            String str = new String(bArr, Internal.UTF_8);
            this.pos += j6;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                String strDecodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), rawVarint32);
                this.pos += (long) rawVarint32;
                return strDecodeUtf8;
            }
            if (rawVarint32 == 0) {
                return "";
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() throws InvalidProtocolBufferException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i5, MessageLite.Builder builder) throws InvalidProtocolBufferException {
            readGroup(i5, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void skipRawBytes(int i5) throws InvalidProtocolBufferException {
            if (i5 >= 0 && i5 <= remaining()) {
                this.pos += (long) i5;
            } else {
                if (i5 >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z6) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = jAddressOffset;
            this.limit = ((long) byteBuffer.limit()) + jAddressOffset;
            long jPosition = jAddressOffset + ((long) byteBuffer.position());
            this.pos = jPosition;
            this.startPos = jPosition;
            this.immutable = z6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i5, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i5, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i5);
                skipMessage(codedOutputStream);
                int iMakeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4);
                checkLastTagWas(iMakeTag);
                codedOutputStream.writeUInt32NoTag(iMakeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i5);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static int decodeZigZag32(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public static long decodeZigZag64(long j6) {
        return (-(j6 & 1)) ^ (j6 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i5, InputStream inputStream) throws IOException {
        if ((i5 & 128) == 0) {
            return i5;
        }
        int i6 = i5 & 127;
        int i7 = 7;
        while (i7 < 32) {
            int i8 = inputStream.read();
            if (i8 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i6 |= (i8 & 127) << i7;
            if ((i8 & 128) == 0) {
                return i6;
            }
            i7 += 7;
        }
        while (i7 < 64) {
            int i9 = inputStream.read();
            if (i9 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i9 & 128) == 0) {
                return i6;
            }
            i7 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int i5);

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z6);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int i5);

    public abstract int pushLimit(int i5);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int i5, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readGroup(int i5, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int i5);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    public abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int i5, MessageLite.Builder builder);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Recursion limit cannot be negative: "));
        }
        int i6 = this.recursionLimit;
        this.recursionLimit = i5;
        return i6;
    }

    public final int setSizeLimit(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Size limit cannot be negative: "));
        }
        int i6 = this.sizeLimit;
        this.sizeLimit = i5;
        return i6;
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i5);

    @Deprecated
    public abstract boolean skipField(int i5, CodedOutputStream codedOutputStream);

    public void skipMessage() throws InvalidProtocolBufferException {
        boolean zSkipField;
        do {
            int tag = readTag();
            if (tag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            zSkipField = skipField(tag);
            this.recursionDepth--;
        } while (zSkipField);
    }

    public abstract void skipRawBytes(int i5);

    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i5) {
        if (i5 > 0) {
            return inputStream == null ? newInstance(Internal.EMPTY_BYTE_ARRAY) : new StreamDecoder(inputStream, i5);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    public static int readRawVarint32(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        if (i5 != -1) {
            return readRawVarint32(i5, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
        boolean zSkipField;
        do {
            int tag = readTag();
            if (tag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            zSkipField = skipField(tag, codedOutputStream);
            this.recursionDepth--;
        } while (zSkipField);
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z6) {
        int i5 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : iterable) {
            iRemaining += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                i5 |= 1;
            } else {
                i5 = byteBuffer.isDirect() ? i5 | 2 : i5 | 4;
            }
        }
        if (i5 == 2) {
            return new IterableDirectByteBufferDecoder(iterable, iRemaining, z6);
        }
        return newInstance(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i5, int i6) {
        return newInstance(bArr, i5, i6, false);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i5, int i6, boolean z6) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i5, i6, z6);
        try {
            arrayDecoder.pushLimit(i6);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z6) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), z6);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z6);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, iRemaining, true);
    }
}
