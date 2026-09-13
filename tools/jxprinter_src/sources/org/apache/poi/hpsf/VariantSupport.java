package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class VariantSupport extends Variant {
    private static boolean logUnsupportedTypes;
    private static List<Long> unsupportedMessage;
    public static final int[] SUPPORTED_TYPES = {0, 2, 3, 20, 5, 64, 30, 31, 71, 11};
    private static final Logger LOG = LogManager.getLogger((Class<?>) VariantSupport.class);
    private static final byte[] paddingBytes = new byte[3];

    public static boolean isLogUnsupportedTypes() {
        return logUnsupportedTypes;
    }

    public static Object read(byte[] bArr, int i5, int i6, long j6, int i7) {
        return read(new LittleEndianByteArrayInputStream(bArr, i5), i6, j6, i7);
    }

    public static void setLogUnsupportedTypes(boolean z6) {
        logUnsupportedTypes = z6;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x014d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0151  */
    /* JADX WARN: Code duplicated, block: B:88:0x0161  */
    public static int write(OutputStream outputStream, long j6, Object obj, int i5) throws IOException, WritingNotSupportedException {
        int length;
        int i6 = (int) j6;
        if (i6 != 0) {
            length = 2;
            if (i6 != 11) {
                if (i6 == 64) {
                    length = (obj instanceof java.util.Date ? new Filetime((java.util.Date) obj) : new Filetime()).write(outputStream);
                } else if (i6 != 71) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            if (i6 != 4) {
                                if (i6 != 5) {
                                    if (i6 != 30) {
                                        if (i6 != 31) {
                                            switch (i6) {
                                                case 18:
                                                    if (obj instanceof Number) {
                                                        LittleEndian.putUShort(((Number) obj).intValue(), outputStream);
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                case 19:
                                                    if (obj instanceof Number) {
                                                        LittleEndian.putUInt(((Number) obj).longValue(), outputStream);
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                case 20:
                                                    if (obj instanceof Number) {
                                                        LittleEndian.putLong(((Number) obj).longValue(), outputStream);
                                                        length = 8;
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                case 21:
                                                    if (obj instanceof Number) {
                                                        BigInteger bigIntegerValueOf = obj instanceof BigInteger ? (BigInteger) obj : BigInteger.valueOf(((Number) obj).longValue());
                                                        if (bigIntegerValueOf.bitLength() > 64) {
                                                            throw new WritingNotSupportedException(j6, obj);
                                                        }
                                                        byte[] byteArray = bigIntegerValueOf.toByteArray();
                                                        byte[] bArr = new byte[8];
                                                        int length2 = byteArray.length;
                                                        for (byte b : byteArray) {
                                                            if (length2 <= 8) {
                                                                bArr[length2 - 1] = b;
                                                            }
                                                            length2--;
                                                        }
                                                        outputStream.write(bArr);
                                                        length = 8;
                                                    } else {
                                                        length = -1;
                                                    }
                                                    break;
                                                default:
                                                    length = -1;
                                                    break;
                                            }
                                        } else if (obj instanceof String) {
                                            UnicodeString unicodeString = new UnicodeString();
                                            unicodeString.setJavaValue((String) obj);
                                            length = unicodeString.write(outputStream);
                                        } else {
                                            length = -1;
                                        }
                                    } else if (obj instanceof String) {
                                        CodePageString codePageString = new CodePageString();
                                        codePageString.setJavaValue((String) obj, i5);
                                        length = codePageString.write(outputStream);
                                    } else {
                                        length = -1;
                                    }
                                } else if (obj instanceof Number) {
                                    LittleEndian.putDouble(((Number) obj).doubleValue(), outputStream);
                                    length = 8;
                                } else {
                                    length = -1;
                                }
                            } else if (obj instanceof Number) {
                                LittleEndian.putInt(Float.floatToIntBits(((Number) obj).floatValue()), outputStream);
                            } else {
                                length = -1;
                            }
                        } else if (obj instanceof Number) {
                            LittleEndian.putInt(((Number) obj).intValue(), outputStream);
                        } else {
                            length = -1;
                        }
                    } else if (obj instanceof Number) {
                        LittleEndian.putShort(outputStream, ((Number) obj).shortValue());
                    } else {
                        length = -1;
                    }
                } else if (obj instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj;
                    outputStream.write(bArr2);
                    length = bArr2.length;
                } else {
                    length = -1;
                }
            } else if (obj instanceof Boolean) {
                int i7 = ((Boolean) obj).booleanValue() ? 255 : 0;
                outputStream.write(i7);
                outputStream.write(i7);
            } else {
                length = -1;
            }
            if (length == -1) {
                if (obj instanceof byte[]) {
                    throw new WritingNotSupportedException(j6, obj);
                }
                byte[] bArr3 = (byte[]) obj;
                outputStream.write(bArr3);
                length = bArr3.length;
                writeUnsupportedTypeMessage(new WritingNotSupportedException(j6, obj));
            }
            int i8 = (4 - (length & 3)) & 3;
            outputStream.write(paddingBytes, 0, i8);
            return length + i8;
        }
        LittleEndian.putUInt(0L, outputStream);
        length = 4;
        if (length == -1) {
            if (obj instanceof byte[]) {
                throw new WritingNotSupportedException(j6, obj);
            }
            byte[] bArr4 = (byte[]) obj;
            outputStream.write(bArr4);
            length = bArr4.length;
            writeUnsupportedTypeMessage(new WritingNotSupportedException(j6, obj));
        }
        int i9 = (4 - (length & 3)) & 3;
        outputStream.write(paddingBytes, 0, i9);
        return length + i9;
    }

    public static void writeUnsupportedTypeMessage(UnsupportedVariantTypeException unsupportedVariantTypeException) {
        if (isLogUnsupportedTypes()) {
            if (unsupportedMessage == null) {
                unsupportedMessage = new LinkedList();
            }
            Long lValueOf = Long.valueOf(unsupportedVariantTypeException.getVariantType());
            if (unsupportedMessage.contains(lValueOf)) {
                return;
            }
            LOG.atError().withThrowable(unsupportedVariantTypeException).log("Unsupported type");
            unsupportedMessage.add(lValueOf);
        }
    }

    public boolean isSupportedType(int i5) {
        for (int i6 : SUPPORTED_TYPES) {
            if (i5 == i6) {
                return true;
            }
        }
        return false;
    }

    public static Object read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i5, long j6, int i6) throws IOException, ReadingNotSupportedException {
        int readIndex = littleEndianByteArrayInputStream.getReadIndex();
        int i7 = (int) j6;
        TypedPropertyValue typedPropertyValue = new TypedPropertyValue(i7, null);
        try {
            try {
                typedPropertyValue.readValue(littleEndianByteArrayInputStream);
                if (i7 != 0) {
                    if (i7 == 11) {
                        return Boolean.valueOf(((VariantBool) typedPropertyValue.getValue()).getValue());
                    }
                    if (i7 == 64) {
                        return ((Filetime) typedPropertyValue.getValue()).getJavaValue();
                    }
                    if (i7 == 71) {
                        return ((ClipboardData) typedPropertyValue.getValue()).toByteArray();
                    }
                    if (i7 == 2) {
                        return Integer.valueOf(((Short) typedPropertyValue.getValue()).intValue());
                    }
                    if (i7 != 3 && i7 != 4 && i7 != 5) {
                        if (i7 == 30) {
                            return ((CodePageString) typedPropertyValue.getValue()).getJavaValue(i6);
                        }
                        if (i7 != 31) {
                            switch (i7) {
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                    break;
                                default:
                                    int readIndex2 = littleEndianByteArrayInputStream.getReadIndex() - readIndex;
                                    littleEndianByteArrayInputStream.setReadIndex(readIndex);
                                    byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(readIndex2, CodePageString.getMaxRecordLength());
                                    littleEndianByteArrayInputStream.readFully(bArrSafelyAllocate, 0, readIndex2);
                                    throw new ReadingNotSupportedException(j6, bArrSafelyAllocate);
                            }
                        } else {
                            return ((UnicodeString) typedPropertyValue.getValue()).toJavaString();
                        }
                    }
                }
                return typedPropertyValue.getValue();
            } catch (UnsupportedOperationException unused) {
                throw new ReadingNotSupportedException(j6, IOUtils.toByteArray(littleEndianByteArrayInputStream, i5, CodePageString.getMaxRecordLength()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
