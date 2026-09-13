package com.google.zxing.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class EdifactEncoder implements Encoder {
    private static void encodeChar(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i5) {
        int length = charSequence.length() - i5;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i5) << 18) + ((length >= 2 ? charSequence.charAt(i5 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i5 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i5 + 3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c6 = (char) ((iCharAt >> 8) & 255);
        char c7 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c6);
        }
        if (length >= 3) {
            sb.append(c7);
        }
        return sb.toString();
    }

    private static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                encoderContext.signalEncoderChange(0);
                return;
            }
            boolean z6 = true;
            if (length == 1) {
                encoderContext.updateSymbolInfo();
                int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                if (encoderContext.getRemainingCharacters() == 0 && dataCapacity <= 2) {
                    encoderContext.signalEncoderChange(0);
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i5 = length - 1;
            String strEncodeToCodewords = encodeToCodewords(charSequence, 0);
            if (encoderContext.hasMoreCharacters() || i5 > 2) {
                z6 = false;
            }
            if (i5 <= 2) {
                encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i5);
                if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + strEncodeToCodewords.length());
                    z6 = false;
                }
            }
            if (z6) {
                encoderContext.resetSymbolInfo();
                encoderContext.pos -= i5;
            } else {
                encoderContext.writeCodewords(strEncodeToCodewords);
            }
            encoderContext.signalEncoderChange(0);
        } catch (Throwable th) {
            encoderContext.signalEncoderChange(0);
            throw th;
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        handleEOD(encoderContext, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }
}
