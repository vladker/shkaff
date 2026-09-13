package com.google.common.net;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class InetAddresses {
    private static final char IPV4_DELIMITER = '.';
    private static final int IPV4_PART_COUNT = 4;
    private static final char IPV6_DELIMITER = ':';
    private static final int IPV6_PART_COUNT = 8;
    private static final CharMatcher IPV4_DELIMITER_MATCHER = CharMatcher.is('.');
    private static final CharMatcher IPV6_DELIMITER_MATCHER = CharMatcher.is(':');
    private static final Inet4Address LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
    private static final Inet4Address ANY4 = (Inet4Address) forString("0.0.0.0");

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(Inet4Address inet4Address, Inet4Address inet4Address2, int i5, int i6) {
            boolean z6 = false;
            Preconditions.checkArgument(i5 >= 0 && i5 <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i5);
            if (i6 >= 0 && i6 <= 65535) {
                z6 = true;
            }
            Preconditions.checkArgument(z6, "flags '%s' is out of range (0 <= flags <= 0xffff)", i6);
            this.server = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = i5;
            this.flags = i6;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getPort() {
            return this.port;
        }

        public Inet4Address getServer() {
            return this.server;
        }
    }

    private InetAddresses() {
    }

    private static InetAddress bytesToInetAddress(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    private static void compressLongestRunOfZeroes(int[] iArr) {
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < iArr.length + 1; i8++) {
            if (i8 >= iArr.length || iArr[i8] != 0) {
                if (i7 >= 0) {
                    int i9 = i8 - i7;
                    if (i9 > i5) {
                        i6 = i7;
                        i5 = i9;
                    }
                    i7 = -1;
                }
            } else if (i7 < 0) {
                i7 = i8;
            }
        }
        if (i5 >= 2) {
            Arrays.fill(iArr, i6, i5 + i6, -1);
        }
    }

    private static String convertDottedQuadToHex(String str) {
        int iLastIndexOf = str.lastIndexOf(58) + 1;
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrTextToNumericFormatV4 = textToNumericFormatV4(str.substring(iLastIndexOf));
        if (bArrTextToNumericFormatV4 == null) {
            return null;
        }
        String hexString = Integer.toHexString(((bArrTextToNumericFormatV4[0] & UnsignedBytes.MAX_VALUE) << 8) | (bArrTextToNumericFormatV4[1] & UnsignedBytes.MAX_VALUE));
        String hexString2 = Integer.toHexString((bArrTextToNumericFormatV4[3] & UnsignedBytes.MAX_VALUE) | ((bArrTextToNumericFormatV4[2] & UnsignedBytes.MAX_VALUE) << 8));
        return a.j(androidx.exifinterface.media.a.b(androidx.exifinterface.media.a.b(androidx.exifinterface.media.a.b(1, strSubstring), hexString), hexString2), strSubstring, hexString, ParameterizedMessage.ERROR_MSG_SEPARATOR, hexString2);
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        Preconditions.checkArgument(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return bytesToInetAddress(address);
    }

    @CanIgnoreReturnValue
    public static InetAddress forString(String str) {
        byte[] bArrIpStringToBytes = ipStringToBytes(str);
        if (bArrIpStringToBytes != null) {
            return bytesToInetAddress(bArrIpStringToBytes);
        }
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress inetAddressForUriStringNoThrow = forUriStringNoThrow(str);
        if (inetAddressForUriStringNoThrow != null) {
            return inetAddressForUriStringNoThrow;
        }
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", str);
    }

    private static InetAddress forUriStringNoThrow(String str) {
        int i5;
        Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = androidx.collection.a.g(1, 1, str);
            i5 = 16;
        } else {
            i5 = 4;
        }
        byte[] bArrIpStringToBytes = ipStringToBytes(str);
        if (bArrIpStringToBytes == null || bArrIpStringToBytes.length != i5) {
            return null;
        }
        return bytesToInetAddress(bArrIpStringToBytes);
    }

    private static IllegalArgumentException formatIllegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    private static InetAddress fromBigInteger(BigInteger bigInteger, boolean z6) {
        Preconditions.checkArgument(bigInteger.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i5 = z6 ? 16 : 4;
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i5];
        int iMax = Math.max(0, byteArray.length - i5);
        int length = byteArray.length - iMax;
        int i6 = i5 - length;
        for (int i7 = 0; i7 < iMax; i7++) {
            if (byteArray[i7] != 0) {
                throw formatIllegalArgumentException("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i5), bigInteger);
            }
        }
        System.arraycopy(byteArray, iMax, bArr, i6, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address) fromBigInteger(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address) fromBigInteger(bigInteger, true);
    }

    public static Inet4Address fromInteger(int i5) {
        return getInet4Address(Ints.toByteArray(i5));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr2[i5] = bArr[(bArr.length - i5) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z6;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i5 = 0;
        while (true) {
            if (i5 >= 15) {
                z6 = true;
                break;
            }
            if (address[i5] != 0) {
                z6 = false;
                break;
            }
            i5++;
        }
        if (z6 && address[15] == 1) {
            return LOOPBACK4;
        }
        if (z6 && address[15] == 0) {
            return ANY4;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int iAsInt = Hashing.murmur3_32_fixed().hashLong(hasEmbeddedIPv4ClientAddress(inet6Address) ? getEmbeddedIPv4ClientAddress(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).asInt() | Videoio.CAP_OPENNI_GENERATORS_MASK;
        if (iAsInt == -1) {
            iAsInt = -2;
        }
        return getInet4Address(Ints.toByteArray(iAsInt));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    private static Inet4Address getInet4Address(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) bytesToInetAddress(bArr);
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        int i5 = ByteStreams.newDataInput(address, 8).readShort() & 65535;
        int i6 = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] bArrCopyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i7 = 0; i7 < bArrCopyOfRange.length; i7++) {
            bArrCopyOfRange[i7] = (byte) (~bArrCopyOfRange[i7]);
        }
        return new TeredoInfo(inet4Address, getInet4Address(bArrCopyOfRange), i6, i5);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    private static String hextetsToIPv6String(int[] iArr) {
        StringBuilder sb = new StringBuilder(39);
        int i5 = 0;
        boolean z6 = false;
        while (i5 < iArr.length) {
            boolean z7 = iArr[i5] >= 0;
            if (z7) {
                if (z6) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i5]));
            } else if (i5 == 0 || z6) {
                sb.append("::");
            }
            i5++;
            z6 = z7;
        }
        return sb.toString();
    }

    public static InetAddress increment(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        Preconditions.checkArgument(length >= 0, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return bytesToInetAddress(address);
    }

    private static byte[] ipStringToBytes(String str) {
        int i5 = 0;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (i5 >= str.length()) {
                i5 = -1;
                break;
            }
            char cCharAt = str.charAt(i5);
            if (cCharAt == '.') {
                z6 = true;
            } else if (cCharAt == ':') {
                if (z6) {
                    return null;
                }
                z7 = true;
            } else {
                if (cCharAt == '%') {
                    break;
                }
                if (Character.digit(cCharAt, 16) == -1) {
                    return null;
                }
            }
            i5++;
        }
        if (!z7) {
            if (z6 && i5 == -1) {
                return textToNumericFormatV4(str);
            }
            return null;
        }
        if (z6 && (str = convertDottedQuadToHex(str)) == null) {
            return null;
        }
        if (i5 != -1) {
            str = str.substring(0, i5);
        }
        return textToNumericFormatV6(str);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        byte b;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b = address[15]) == 0 || b == 1)) ? false : true;
    }

    public static boolean isInetAddress(String str) {
        return ipStringToBytes(str) != null;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] bArrIpStringToBytes = ipStringToBytes(str);
        if (bArrIpStringToBytes == null || bArrIpStringToBytes.length != 16) {
            return false;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= 10) {
                for (int i6 = 10; i6 < 12; i6++) {
                    if (bArrIpStringToBytes[i6] != -1) {
                        return false;
                    }
                }
                return true;
            }
            if (bArrIpStringToBytes[i5] != 0) {
                return false;
            }
            i5++;
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        for (byte b : inetAddress.getAddress()) {
            if (b != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean isUriInetAddress(String str) {
        return forUriStringNoThrow(str) != null;
    }

    private static short parseHextet(String str, int i5, int i6) {
        int i7 = i6 - i5;
        if (i7 <= 0 || i7 > 4) {
            throw new NumberFormatException();
        }
        int iDigit = 0;
        while (i5 < i6) {
            iDigit = (iDigit << 4) | Character.digit(str.charAt(i5), 16);
            i5++;
        }
        return (short) iDigit;
    }

    private static byte parseOctet(String str, int i5, int i6) {
        int i7 = i6 - i5;
        if (i7 <= 0 || i7 > 3) {
            throw new NumberFormatException();
        }
        if (i7 > 1 && str.charAt(i5) == '0') {
            throw new NumberFormatException();
        }
        int i8 = 0;
        while (i5 < i6) {
            int i9 = i8 * 10;
            int iDigit = Character.digit(str.charAt(i5), 10);
            if (iDigit < 0) {
                throw new NumberFormatException();
            }
            i8 = i9 + iDigit;
            i5++;
        }
        if (i8 <= 255) {
            return (byte) i8;
        }
        throw new NumberFormatException();
    }

    private static byte[] textToNumericFormatV4(String str) {
        if (IPV4_DELIMITER_MATCHER.countIn(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            int iIndexOf = str.indexOf(46, i5);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            try {
                bArr[i6] = parseOctet(str, i5, iIndexOf);
                i5 = iIndexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    private static byte[] textToNumericFormatV6(String str) {
        int iCountIn = IPV6_DELIMITER_MATCHER.countIn(str);
        if (iCountIn >= 2 && iCountIn <= 8) {
            int i5 = 1;
            int i6 = iCountIn + 1;
            int i7 = 8 - i6;
            boolean z6 = false;
            for (int i8 = 0; i8 < str.length() - 1; i8++) {
                if (str.charAt(i8) == ':' && str.charAt(i8 + 1) == ':') {
                    if (z6) {
                        return null;
                    }
                    int i9 = i7 + 1;
                    if (i8 == 0) {
                        i9 = i7 + 2;
                    }
                    if (i8 == str.length() - 2) {
                        i9++;
                    }
                    i7 = i9;
                    z6 = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z6 && i7 <= 0) {
                return null;
            }
            if (!z6 && i6 != 8) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i5 = 0;
                }
                while (i5 < str.length()) {
                    int iIndexOf = str.indexOf(58, i5);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    if (str.charAt(i5) == ':') {
                        for (int i10 = 0; i10 < i7; i10++) {
                            byteBufferAllocate.putShort((short) 0);
                        }
                    } else {
                        byteBufferAllocate.putShort(parseHextet(str, i5, iIndexOf));
                    }
                    i5 = iIndexOf + 1;
                }
                return byteBufferAllocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = i5 * 2;
            iArr[i5] = Ints.fromBytes((byte) 0, (byte) 0, address[i6], address[i6 + 1]);
        }
        compressLongestRunOfZeroes(iArr);
        return hextetsToIPv6String(iArr);
    }

    public static BigInteger toBigInteger(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String toUriString(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return toAddrString(inetAddress);
        }
        String addrString = toAddrString(inetAddress);
        return androidx.exifinterface.media.a.e(androidx.exifinterface.media.a.b(2, addrString), "[", addrString, "]");
    }
}
