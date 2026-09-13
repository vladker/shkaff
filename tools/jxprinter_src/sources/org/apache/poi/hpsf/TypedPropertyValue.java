package org.apache.poi.hpsf;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class TypedPropertyValue {
    private static final Logger LOG = LogManager.getLogger((Class<?>) TypedPropertyValue.class);
    private int _type;
    private Object _value;

    public TypedPropertyValue(int i5, Object obj) {
        this._type = i5;
        this._value = obj;
    }

    public static void skipPadding(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) throws IOException {
        int readIndex = (4 - (littleEndianByteArrayInputStream.getReadIndex() & 3)) & 3;
        for (int i5 = 0; i5 < readIndex; i5++) {
            littleEndianByteArrayInputStream.mark(1);
            if (littleEndianByteArrayInputStream.read() != 0) {
                littleEndianByteArrayInputStream.reset();
                return;
            }
        }
    }

    public Object getValue() {
        return this._value;
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) throws IOException {
        this._type = littleEndianByteArrayInputStream.readShort();
        short s6 = littleEndianByteArrayInputStream.readShort();
        if (s6 != 0) {
            LOG.atWarn().log("TypedPropertyValue padding at offset {} MUST be 0, but it's value is {}", Unbox.box(littleEndianByteArrayInputStream.getReadIndex()), Unbox.box(s6));
        }
        readValue(littleEndianByteArrayInputStream);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x00f7 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:79:0x013d  */
    public void readValue(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) throws IOException {
        int i5 = this._type;
        if (i5 != 10) {
            if (i5 == 11) {
                VariantBool variantBool = new VariantBool();
                variantBool.read(littleEndianByteArrayInputStream);
                this._value = variantBool;
                return;
            }
            if (i5 != 30) {
                if (i5 == 31) {
                    UnicodeString unicodeString = new UnicodeString();
                    unicodeString.read(littleEndianByteArrayInputStream);
                    this._value = unicodeString;
                    return;
                }
                if (i5 != 4126 && i5 != 4127 && i5 != 4167 && i5 != 4168) {
                    switch (i5) {
                        case 0:
                        case 1:
                            this._value = null;
                            return;
                        case 2:
                            this._value = Short.valueOf(littleEndianByteArrayInputStream.readShort());
                            return;
                        case 3:
                            this._value = Integer.valueOf(littleEndianByteArrayInputStream.readInt());
                            return;
                        case 4:
                            this._value = Float.valueOf(Float.intBitsToFloat(littleEndianByteArrayInputStream.readInt()));
                            return;
                        case 5:
                            this._value = Double.valueOf(littleEndianByteArrayInputStream.readDouble());
                            return;
                        case 6:
                            Currency currency = new Currency();
                            currency.read(littleEndianByteArrayInputStream);
                            this._value = currency;
                            return;
                        case 7:
                            Date date = new Date();
                            date.read(littleEndianByteArrayInputStream);
                            this._value = date;
                            return;
                        case 8:
                            break;
                        default:
                            if (i5 == 14) {
                                Decimal decimal = new Decimal();
                                decimal.read(littleEndianByteArrayInputStream);
                                this._value = decimal;
                                return;
                            }
                            if (i5 != 4160) {
                                if (i5 != 8206 && i5 != 8214 && i5 != 8215) {
                                    switch (i5) {
                                        case 64:
                                            Filetime filetime = new Filetime();
                                            filetime.read(littleEndianByteArrayInputStream);
                                            this._value = filetime;
                                            return;
                                        case 65:
                                        case 70:
                                            Blob blob = new Blob();
                                            blob.read(littleEndianByteArrayInputStream);
                                            this._value = blob;
                                            return;
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                            IndirectPropertyName indirectPropertyName = new IndirectPropertyName();
                                            indirectPropertyName.read(littleEndianByteArrayInputStream);
                                            this._value = indirectPropertyName;
                                            return;
                                        case 71:
                                            ClipboardData clipboardData = new ClipboardData();
                                            clipboardData.read(littleEndianByteArrayInputStream);
                                            this._value = clipboardData;
                                            return;
                                        case 72:
                                            new GUID().read(littleEndianByteArrayInputStream);
                                            this._value = littleEndianByteArrayInputStream;
                                            return;
                                        case 73:
                                            VersionedStream versionedStream = new VersionedStream();
                                            versionedStream.read(littleEndianByteArrayInputStream);
                                            this._value = versionedStream;
                                            return;
                                        default:
                                            switch (i5) {
                                                default:
                                                    switch (i5) {
                                                        default:
                                                            switch (i5) {
                                                                case 8208:
                                                                case 8209:
                                                                case 8210:
                                                                case 8211:
                                                                    break;
                                                                default:
                                                                    switch (i5) {
                                                                        case 16:
                                                                            this._value = Byte.valueOf(littleEndianByteArrayInputStream.readByte());
                                                                            return;
                                                                        case 17:
                                                                            this._value = Integer.valueOf(littleEndianByteArrayInputStream.readUByte());
                                                                            return;
                                                                        case 18:
                                                                            this._value = Integer.valueOf(littleEndianByteArrayInputStream.readUShort());
                                                                            return;
                                                                        case 19:
                                                                        case 23:
                                                                            break;
                                                                        case 20:
                                                                            this._value = Long.valueOf(littleEndianByteArrayInputStream.readLong());
                                                                            return;
                                                                        case 21:
                                                                            byte[] bArr = new byte[8];
                                                                            littleEndianByteArrayInputStream.readFully(bArr);
                                                                            byte[] bArr2 = new byte[9];
                                                                            int i6 = 8;
                                                                            for (int i7 = 0; i7 < 8; i7++) {
                                                                                byte b = bArr[i7];
                                                                                if (i6 <= 8) {
                                                                                    bArr2[i6] = b;
                                                                                }
                                                                                i6--;
                                                                            }
                                                                            this._value = new BigInteger(bArr2);
                                                                            return;
                                                                        case 22:
                                                                            this._value = Integer.valueOf(littleEndianByteArrayInputStream.readInt());
                                                                            return;
                                                                        default:
                                                                            switch (i5) {
                                                                                case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                                                                                case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                                                                                case FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN /* 4100 */:
                                                                                case 4101:
                                                                                case 4102:
                                                                                case 4103:
                                                                                case 4104:
                                                                                    break;
                                                                                default:
                                                                                    switch (i5) {
                                                                                        case 4106:
                                                                                        case 4107:
                                                                                        case 4108:
                                                                                            break;
                                                                                        default:
                                                                                            switch (i5) {
                                                                                                case 4112:
                                                                                                case 4113:
                                                                                                case 4114:
                                                                                                case 4115:
                                                                                                case 4116:
                                                                                                case 4117:
                                                                                                    break;
                                                                                                default:
                                                                                                    throw new UnsupportedOperationException("Unknown (possibly, incorrect) TypedPropertyValue type: " + this._type);
                                                                                            }
                                                                                            break;
                                                                                    }
                                                                                    break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                        case 8202:
                                                        case 8203:
                                                        case 8204:
                                                            Array array = new Array();
                                                            array.read(littleEndianByteArrayInputStream);
                                                            this._value = array;
                                                            return;
                                                    }
                                                case 8194:
                                                case 8195:
                                                case 8196:
                                                case FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE /* 8197 */:
                                                case 8198:
                                                case 8199:
                                                case 8200:
                                                    Array array2 = new Array();
                                                    array2.read(littleEndianByteArrayInputStream);
                                                    this._value = array2;
                                                    return;
                                            }
                                            break;
                                    }
                                }
                                Array array3 = new Array();
                                array3.read(littleEndianByteArrayInputStream);
                                this._value = array3;
                                return;
                            }
                            break;
                    }
                }
                Vector vector = new Vector((short) (i5 & 4095));
                vector.read(littleEndianByteArrayInputStream);
                this._value = vector;
                return;
            }
            CodePageString codePageString = new CodePageString();
            codePageString.read(littleEndianByteArrayInputStream);
            this._value = codePageString;
            return;
        }
        this._value = Long.valueOf(littleEndianByteArrayInputStream.readUInt());
    }
}
