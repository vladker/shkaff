package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class NioZipEncoding implements ZipEncoding, CharsetAccessor {
    private final Charset charset;
    private final boolean useReplacement;
    private static final byte[] REPLACEMENT_BYTES = {63};
    private static final char REPLACEMENT = '?';
    private static final String REPLACEMENT_STRING = String.valueOf(REPLACEMENT);
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public NioZipEncoding(Charset charset, boolean z6) {
        this.charset = charset;
        this.useReplacement = z6;
    }

    private static ByteBuffer encodeFully(CharsetEncoder charsetEncoder, CharBuffer charBuffer, ByteBuffer byteBuffer) {
        while (charBuffer.hasRemaining()) {
            if (charsetEncoder.encode(charBuffer, byteBuffer, false).isOverflow()) {
                byteBuffer = ZipEncodingHelper.growBufferBy(byteBuffer, estimateIncrementalEncodingSize(charsetEncoder, charBuffer.remaining()));
            }
        }
        return byteBuffer;
    }

    private static CharBuffer encodeSurrogate(CharBuffer charBuffer, char c) {
        charBuffer.position(0).limit(6);
        charBuffer.put('%');
        charBuffer.put('U');
        char[] cArr = HEX_CHARS;
        charBuffer.put(cArr[(c >> '\f') & 15]);
        charBuffer.put(cArr[(c >> '\b') & 15]);
        charBuffer.put(cArr[(c >> 4) & 15]);
        charBuffer.put(cArr[c & 15]);
        charBuffer.flip();
        return charBuffer;
    }

    private static int estimateIncrementalEncodingSize(CharsetEncoder charsetEncoder, int i5) {
        return (int) Math.ceil(charsetEncoder.averageBytesPerChar() * i5);
    }

    private static int estimateInitialBufferSize(CharsetEncoder charsetEncoder, int i5) {
        return (int) Math.ceil((charsetEncoder.averageBytesPerChar() * (i5 - 1)) + charsetEncoder.maxBytesPerChar());
    }

    private CharsetDecoder newDecoder() {
        if (this.useReplacement) {
            CharsetDecoder charsetDecoderNewDecoder = this.charset.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(REPLACEMENT_STRING);
        }
        CharsetDecoder charsetDecoderNewDecoder2 = this.charset.newDecoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return charsetDecoderNewDecoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }

    private CharsetEncoder newEncoder() {
        if (this.useReplacement) {
            CharsetEncoder charsetEncoderNewEncoder = this.charset.newEncoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(REPLACEMENT_BYTES);
        }
        CharsetEncoder charsetEncoderNewEncoder2 = this.charset.newEncoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return charsetEncoderNewEncoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public boolean canEncode(String str) {
        return newEncoder().canEncode(str);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public String decode(byte[] bArr) {
        return newDecoder().decode(ByteBuffer.wrap(bArr)).toString();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
    public ByteBuffer encode(String str) {
        CharsetEncoder charsetEncoderNewEncoder = newEncoder();
        CharBuffer charBufferWrap = CharBuffer.wrap(str);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(estimateInitialBufferSize(charsetEncoderNewEncoder, charBufferWrap.remaining()));
        CharBuffer charBufferAllocate = null;
        while (charBufferWrap.hasRemaining()) {
            CoderResult coderResultEncode = charsetEncoderNewEncoder.encode(charBufferWrap, byteBufferAllocate, false);
            if (!coderResultEncode.isUnmappable() && !coderResultEncode.isMalformed()) {
                if (!coderResultEncode.isOverflow()) {
                    if (coderResultEncode.isUnderflow() || coderResultEncode.isError()) {
                        break;
                    }
                } else {
                    byteBufferAllocate = ZipEncodingHelper.growBufferBy(byteBufferAllocate, estimateIncrementalEncodingSize(charsetEncoderNewEncoder, charBufferWrap.remaining()));
                }
            } else {
                if (estimateIncrementalEncodingSize(charsetEncoderNewEncoder, coderResultEncode.length() * 6) > byteBufferAllocate.remaining()) {
                    int i5 = 0;
                    for (int iPosition = charBufferWrap.position(); iPosition < charBufferWrap.limit(); iPosition++) {
                        i5 += !charsetEncoderNewEncoder.canEncode(charBufferWrap.get(iPosition)) ? 6 : 1;
                    }
                    byteBufferAllocate = ZipEncodingHelper.growBufferBy(byteBufferAllocate, estimateIncrementalEncodingSize(charsetEncoderNewEncoder, i5) - byteBufferAllocate.remaining());
                }
                if (charBufferAllocate == null) {
                    charBufferAllocate = CharBuffer.allocate(6);
                }
                for (int i6 = 0; i6 < coderResultEncode.length(); i6++) {
                    byteBufferAllocate = encodeFully(charsetEncoderNewEncoder, encodeSurrogate(charBufferAllocate, charBufferWrap.get()), byteBufferAllocate);
                }
            }
        }
        charsetEncoderNewEncoder.encode(charBufferWrap, byteBufferAllocate, true);
        byteBufferAllocate.limit(byteBufferAllocate.position());
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    @Override // org.apache.commons.compress.archivers.zip.CharsetAccessor
    public Charset getCharset() {
        return this.charset;
    }
}
