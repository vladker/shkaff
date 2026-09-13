package org.apache.poi.hpsf;

import androidx.collection.a;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Property {
    public static final int DEFAULT_CODEPAGE = 1252;
    private static final Logger LOG = LogManager.getLogger((Class<?>) Property.class);
    private long id;
    private long type;
    private Object value;

    public Property() {
    }

    private String decodeValueFromID() {
        try {
            int id = (int) getID();
            if (id == Integer.MIN_VALUE) {
                return LocaleUtil.getLocaleFromLCID(((Number) this.value).intValue());
            }
            if (id != 1) {
                return null;
            }
            return CodePageUtil.codepageToEncoding(((Number) this.value).intValue());
        } catch (Exception unused) {
            LOG.atWarn().log("Can't decode id {}", Unbox.box(getID()));
            return null;
        }
    }

    private String getVariantName() {
        return getID() == 0 ? "dictionary" : Variant.getVariantName(getType());
    }

    private boolean typesAreEqual(long j6, long j7) {
        if (j6 == j7) {
            return true;
        }
        if (j6 == 30 && j7 == 31) {
            return true;
        }
        return j7 == 30 && j6 == 31;
    }

    private static int unpaddedLength(byte[] bArr) {
        int length = bArr.length - ((bArr.length + 3) % 4);
        for (int length2 = bArr.length; length2 > length; length2--) {
            if (bArr[length2 - 1] != 0) {
                return length2;
            }
        }
        return length;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Property)) {
            return false;
        }
        Property property = (Property) obj;
        Object value = property.getValue();
        long id = property.getID();
        long j6 = this.id;
        if (j6 == id && (j6 == 0 || typesAreEqual(this.type, property.getType()))) {
            Object obj2 = this.value;
            if (obj2 == null && value == null) {
                return true;
            }
            if (obj2 != null && value != null) {
                Class<?> cls = obj2.getClass();
                Class<?> cls2 = value.getClass();
                if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                    return false;
                }
                Object obj3 = this.value;
                if (!(obj3 instanceof byte[])) {
                    return obj3.equals(value);
                }
                byte[] bArr = (byte[]) obj3;
                byte[] bArr2 = (byte[]) value;
                int iUnpaddedLength = unpaddedLength(bArr);
                if (iUnpaddedLength != unpaddedLength(bArr2)) {
                    return false;
                }
                for (int i5 = 0; i5 < iUnpaddedLength; i5++) {
                    if (bArr[i5] != bArr2[i5]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public long getID() {
        return this.id;
    }

    public int getSize(int i5) throws WritingNotSupportedException {
        int variantLength = Variant.getVariantLength(this.type);
        if (variantLength < 0) {
            long j6 = this.type;
            if (j6 != 0) {
                if (variantLength == -2) {
                    throw new WritingNotSupportedException(this.type, null);
                }
                if (j6 != 30 && j6 != 31) {
                    throw new WritingNotSupportedException(this.type, this.value);
                }
                try {
                    int iWrite = write(new UnsynchronizedByteArrayOutputStream(), i5) - 8;
                    return iWrite + ((4 - (iWrite & 3)) & 3);
                } catch (IOException unused) {
                    throw new WritingNotSupportedException(this.type, this.value);
                }
            }
        }
        return variantLength;
    }

    public long getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), Long.valueOf(this.type), this.value);
    }

    public void setID(long j6) {
        this.id = j6;
    }

    public void setType(long j6) {
        this.type = j6;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        return toString(1252, null);
    }

    public int write(OutputStream outputStream, int i5) throws IOException {
        long type = getType();
        if (type == 30 && i5 != 1200) {
            if (!Charset.forName(CodePageUtil.codepageToEncoding(i5 > 0 ? i5 : 1252)).newEncoder().canEncode((String) this.value)) {
                type = 31;
            }
        }
        LittleEndian.putUInt(type, outputStream);
        return VariantSupport.write(outputStream, type, getValue(), i5) + 4;
    }

    public Property(Property property) {
        this(property.id, property.type, property.value);
    }

    public String toString(int i5, PropertyIDMap propertyIDMap) {
        StringBuilder sb = new StringBuilder("Property[id: ");
        sb.append(this.id);
        String str = propertyIDMap == null ? null : propertyIDMap.get((Object) Long.valueOf(this.id));
        if (str == null) {
            str = PropertyIDMap.getFallbackProperties().get((Object) Long.valueOf(this.id));
        }
        if (str != null) {
            a.x(sb, " (", str, ")");
        }
        sb.append(", type: ");
        sb.append(getType());
        sb.append(" (");
        sb.append(getVariantName());
        sb.append(") , value: ");
        Object value = getValue();
        if (value instanceof String) {
            sb.append((String) value);
            sb.append("\n");
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                write(unsynchronizedByteArrayOutputStream, i5);
            } catch (Exception e) {
                LOG.atWarn().withThrowable(e).log("can't serialize string");
            }
            if (unsynchronizedByteArrayOutputStream.size() > 8) {
                sb.append(HexDump.dump(unsynchronizedByteArrayOutputStream.toByteArray(), -8L, 8));
            }
        } else if (value instanceof byte[]) {
            sb.append("\n");
            byte[] bArr = (byte[]) value;
            if (bArr.length > 0) {
                sb.append(HexDump.dump(bArr, 0L, 0));
            }
        } else if (value instanceof java.util.Date) {
            java.util.Date date = (java.util.Date) value;
            long jDateToFileTime = Filetime.dateToFileTime(date);
            if (Filetime.isUndefined(date)) {
                sb.append("<undefined>");
            } else if ((jDateToFileTime >>> 32) == 0) {
                long j6 = jDateToFileTime * 100;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long hours = timeUnit.toHours(j6);
                long nanos = j6 - TimeUnit.HOURS.toNanos(hours);
                long minutes = timeUnit.toMinutes(nanos);
                long nanos2 = nanos - TimeUnit.MINUTES.toNanos(minutes);
                long seconds = timeUnit.toSeconds(nanos2);
                sb.append(String.format(Locale.ROOT, "%02d:%02d:%02d.%03d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(timeUnit.toMillis(nanos2 - TimeUnit.SECONDS.toNanos(seconds)))));
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SignatureConfig.SIGNATURE_TIME_FORMAT, Locale.ROOT);
                simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
                sb.append(simpleDateFormat.format(date));
            }
        } else {
            long j7 = this.type;
            if (j7 == 0 || j7 == 1 || value == null) {
                sb.append(AbstractC1127c.NULL);
            } else {
                sb.append(value);
                String strDecodeValueFromID = decodeValueFromID();
                if (strDecodeValueFromID != null) {
                    a.x(sb, " (", strDecodeValueFromID, ")");
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public Property(long j6, long j7, Object obj) {
        this.id = j6;
        this.type = j7;
        this.value = obj;
    }

    public Property(long j6, byte[] bArr, long j7, int i5, int i6) throws UnsupportedEncodingException {
        this.id = j6;
        if (j6 != 0) {
            int i7 = (int) j7;
            long uInt = LittleEndian.getUInt(bArr, i7);
            this.type = uInt;
            try {
                this.value = VariantSupport.read(bArr, i7 + 4, i5, (int) uInt, i6);
                return;
            } catch (UnsupportedVariantTypeException e) {
                VariantSupport.writeUnsupportedTypeMessage(e);
                this.value = e.getValue();
                return;
            }
        }
        throw new UnsupportedEncodingException("Dictionary not allowed here");
    }

    public Property(long j6, LittleEndianByteArrayInputStream littleEndianByteArrayInputStream, int i5, int i6) throws UnsupportedEncodingException {
        this.id = j6;
        if (j6 != 0) {
            long uInt = littleEndianByteArrayInputStream.readUInt();
            this.type = uInt;
            try {
                this.value = VariantSupport.read(littleEndianByteArrayInputStream, i5, (int) uInt, i6);
                return;
            } catch (UnsupportedVariantTypeException e) {
                VariantSupport.writeUnsupportedTypeMessage(e);
                this.value = e.getValue();
                return;
            }
        }
        throw new UnsupportedEncodingException("Dictionary not allowed here");
    }
}
