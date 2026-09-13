package p134x2;

import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import kotlin.jvm.internal.E;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8862a;
    public final int b;
    public final int c;
    private String cmdMode;
    private String codeType;
    private String codepage;
    private String currentLev;
    public final int d;
    private String devType;
    private String deviceAddress;
    private String deviceName;
    private String dpiType;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8863f;
    private String factoryName;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8866i;
    private String isGZDev;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f8868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f8871n;
    private String nfcEnable;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f8872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f8873p;
    private String paperType;
    private String powerLev;
    private String ptStatus;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f8875r;
    private String remain;
    private String remain2;
    private String speedLev;
    private String uid;
    private String zipEnable;

    public P0(byte[] data) {
        E.f(data, "data");
        C1845a c1845a = C1845a.INSTANCE;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(data, 0, 4);
        E.e(bArrCopyOfRange, "copyOfRange(...)");
        this.f8862a = c1845a.unsignedLong(bArrCopyOfRange);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(data, 4, 6);
        E.e(bArrCopyOfRange2, "copyOfRange(...)");
        this.b = c1845a.unsignedShort(bArrCopyOfRange2);
        byte[] bArrCopyOfRange3 = Arrays.copyOfRange(data, 6, 8);
        E.e(bArrCopyOfRange3, "copyOfRange(...)");
        this.c = c1845a.unsignedShort(bArrCopyOfRange3);
        byte[] bArrCopyOfRange4 = Arrays.copyOfRange(data, 8, 10);
        E.e(bArrCopyOfRange4, "copyOfRange(...)");
        this.d = c1845a.unsignedShort(bArrCopyOfRange4);
        this.dpiType = c1845a.byteToHex(data[10]);
        this.cmdMode = c1845a.byteToHex(data[11]);
        this.codepage = c1845a.byteToHex(data[12]);
        this.codeType = c1845a.byteToHex(data[13]);
        this.speedLev = c1845a.byteToHex(data[14]);
        byte b = data[15];
        c1845a.getClass();
        this.e = b & UnsignedBytes.MAX_VALUE;
        this.currentLev = c1845a.byteToHex(data[16]);
        this.paperType = c1845a.byteToHex(data[17]);
        this.powerLev = c1845a.byteToHex(data[18]);
        this.isGZDev = c1845a.byteToHex(data[19]);
        this.devType = c1845a.byteToHex(data[20]);
        this.ptStatus = c1845a.byteToHex(data[21]);
        this.zipEnable = c1845a.byteToHex(data[22]);
        this.nfcEnable = c1845a.byteToHex(data[23]);
        byte[] bArrCopyOfRange5 = Arrays.copyOfRange(data, 24, 26);
        E.e(bArrCopyOfRange5, "copyOfRange(...)");
        this.f8863f = c1845a.unsignedShort(bArrCopyOfRange5);
        byte[] bArrCopyOfRange6 = Arrays.copyOfRange(data, 26, 28);
        E.e(bArrCopyOfRange6, "copyOfRange(...)");
        this.f8864g = c1845a.unsignedShort(bArrCopyOfRange6);
        byte[] bArrCopyOfRange7 = Arrays.copyOfRange(data, 28, 30);
        E.e(bArrCopyOfRange7, "copyOfRange(...)");
        this.f8865h = c1845a.unsignedShort(bArrCopyOfRange7);
        byte b6 = data[30];
        c1845a.getClass();
        this.f8866i = b6 & UnsignedBytes.MAX_VALUE;
        byte b7 = data[31];
        c1845a.getClass();
        this.f8867j = b7 & UnsignedBytes.MAX_VALUE;
        byte[] bArrCopyOfRange8 = Arrays.copyOfRange(data, 32, 64);
        E.e(bArrCopyOfRange8, "copyOfRange(...)");
        this.factoryName = c1845a.byteToString(bArrCopyOfRange8);
        byte[] bArrCopyOfRange9 = Arrays.copyOfRange(data, 64, 80);
        E.e(bArrCopyOfRange9, "copyOfRange(...)");
        this.deviceName = c1845a.byteToString(bArrCopyOfRange9);
        byte b8 = data[80];
        c1845a.getClass();
        this.f8868k = b8 & UnsignedBytes.MAX_VALUE;
        byte b9 = data[81];
        c1845a.getClass();
        this.f8869l = b9 & UnsignedBytes.MAX_VALUE;
        byte[] bArrCopyOfRange10 = Arrays.copyOfRange(data, 82, 84);
        E.e(bArrCopyOfRange10, "copyOfRange(...)");
        this.f8870m = c1845a.unsignedShort(bArrCopyOfRange10);
        byte[] bArrCopyOfRange11 = Arrays.copyOfRange(data, 84, 86);
        E.e(bArrCopyOfRange11, "copyOfRange(...)");
        this.f8871n = c1845a.unsignedShort(bArrCopyOfRange11);
        byte[] bArrCopyOfRange12 = Arrays.copyOfRange(data, 86, 88);
        E.e(bArrCopyOfRange12, "copyOfRange(...)");
        this.f8872o = c1845a.unsignedShort(bArrCopyOfRange12);
        byte b10 = data[88];
        c1845a.getClass();
        this.f8873p = b10 & UnsignedBytes.MAX_VALUE;
        byte b11 = data[89];
        c1845a.getClass();
        this.f8874q = b11 & UnsignedBytes.MAX_VALUE;
        byte b12 = data[90];
        c1845a.getClass();
        this.f8875r = b12 & UnsignedBytes.MAX_VALUE;
        byte[] bArrCopyOfRange13 = Arrays.copyOfRange(data, 91, 92);
        E.e(bArrCopyOfRange13, "copyOfRange(...)");
        this.remain = c1845a.byteToString(bArrCopyOfRange13);
        if (data.length == 116) {
            this.uid = c1845a.bytesToHexString(Arrays.copyOfRange(data, 92, 104));
            byte[] bArrCopyOfRange14 = Arrays.copyOfRange(data, 104, 116);
            E.e(bArrCopyOfRange14, "copyOfRange(...)");
            this.remain2 = c1845a.byteToString(bArrCopyOfRange14);
        }
    }

    public final String getCmdMode() {
        return this.cmdMode;
    }

    public final String getCodeType() {
        return this.codeType;
    }

    public final String getCodepage() {
        return this.codepage;
    }

    public final String getCurrentLev() {
        return this.currentLev;
    }

    public final String getDevType() {
        return this.devType;
    }

    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDpiStr() {
        if (TarConstants.VERSION_POSIX.equals(this.dpiType)) {
            return "200";
        }
        if ("01".equals(this.dpiType)) {
            return "300";
        }
        return "02".equals(this.dpiType) ? "600" : "200";
    }

    public final String getDpiType() {
        return this.dpiType;
    }

    public final String getFactoryName() {
        return this.factoryName;
    }

    public final String getIsGZDev() {
        return this.isGZDev;
    }

    public final String getNfcEnable() {
        return this.nfcEnable;
    }

    public final String getPaperType() {
        return this.paperType;
    }

    public final String getPowerLev() {
        return this.powerLev;
    }

    public final String getPtStatus() {
        return this.ptStatus;
    }

    public final String getRemain() {
        return this.remain;
    }

    public final byte[] getSettingData() {
        byte[] bArr = this.remain2 == null ? new byte[84] : new byte[116];
        C1845a c1845a = C1845a.INSTANCE;
        System.arraycopy(c1845a.unsignedShort(this.b), 0, bArr, 4, 2);
        System.arraycopy(c1845a.unsignedShort(this.c), 0, bArr, 6, 2);
        System.arraycopy(c1845a.unsignedShort(this.d), 0, bArr, 8, 2);
        String str = this.dpiType;
        E.c(str);
        bArr[10] = c1845a.byteToHex(str);
        String str2 = this.cmdMode;
        E.c(str2);
        bArr[11] = c1845a.byteToHex(str2);
        String str3 = this.codepage;
        E.c(str3);
        bArr[12] = c1845a.byteToHex(str3);
        String str4 = this.codeType;
        E.c(str4);
        bArr[13] = c1845a.byteToHex(str4);
        String str5 = this.speedLev;
        E.c(str5);
        bArr[14] = c1845a.byteToHex(str5);
        int i5 = this.e;
        c1845a.getClass();
        bArr[15] = (byte) i5;
        String str6 = this.currentLev;
        E.c(str6);
        bArr[16] = c1845a.byteToHex(str6);
        String str7 = this.paperType;
        E.c(str7);
        bArr[17] = c1845a.byteToHex(str7);
        String str8 = this.powerLev;
        E.c(str8);
        bArr[18] = c1845a.byteToHex(str8);
        String str9 = this.isGZDev;
        E.c(str9);
        bArr[19] = c1845a.byteToHex(str9);
        String str10 = this.devType;
        E.c(str10);
        bArr[20] = c1845a.byteToHex(str10);
        String str11 = this.ptStatus;
        E.c(str11);
        bArr[21] = c1845a.byteToHex(str11);
        String str12 = this.zipEnable;
        E.c(str12);
        bArr[22] = c1845a.byteToHex(str12);
        String str13 = this.nfcEnable;
        E.c(str13);
        bArr[23] = c1845a.byteToHex(str13);
        System.arraycopy(c1845a.unsignedShort(this.f8863f), 0, bArr, 24, 2);
        System.arraycopy(c1845a.unsignedShort(this.f8864g), 0, bArr, 26, 2);
        System.arraycopy(c1845a.unsignedShort(this.f8865h), 0, bArr, 28, 2);
        c1845a.getClass();
        bArr[30] = (byte) this.f8866i;
        int i6 = this.f8867j;
        c1845a.getClass();
        bArr[31] = (byte) i6;
        String str14 = this.factoryName;
        E.c(str14);
        System.arraycopy(c1845a.byteToString(str14, 32), 0, bArr, 32, 32);
        String str15 = this.deviceName;
        E.c(str15);
        System.arraycopy(c1845a.byteToString(str15, 16), 0, bArr, 64, 16);
        c1845a.getClass();
        bArr[80] = (byte) this.f8868k;
        c1845a.getClass();
        bArr[81] = (byte) this.f8869l;
        System.arraycopy(c1845a.unsignedShort(this.f8870m), 0, bArr, 82, 2);
        if (this.remain2 != null) {
            System.arraycopy(c1845a.unsignedShort(this.f8871n), 0, bArr, 84, 2);
            System.arraycopy(c1845a.unsignedShort(this.f8872o), 0, bArr, 86, 2);
            c1845a.getClass();
            bArr[88] = (byte) this.f8873p;
            int i7 = this.f8874q;
            c1845a.getClass();
            bArr[89] = (byte) i7;
            c1845a.getClass();
            bArr[90] = (byte) this.f8875r;
            String str16 = this.remain;
            E.c(str16);
            System.arraycopy(c1845a.byteToString(str16, 1), 0, bArr, 91, 1);
            String str17 = this.remain2;
            E.c(str17);
            System.arraycopy(c1845a.byteToString(str17, 32), 0, bArr, 92, 24);
        }
        this.f8862a = 0L;
        int length = bArr.length;
        for (int i8 = 4; i8 < length; i8++) {
            long j6 = this.f8862a;
            C1845a c1845a2 = C1845a.INSTANCE;
            byte b = bArr[i8];
            c1845a2.getClass();
            this.f8862a = j6 + ((long) (b & UnsignedBytes.MAX_VALUE));
        }
        System.arraycopy(C1845a.INSTANCE.unsignedLong(this.f8862a), 0, bArr, 0, 4);
        return bArr;
    }

    public final String getSpeedLev() {
        return this.speedLev;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getZipEnable() {
        return this.zipEnable;
    }

    public final void setCmdMode(String str) {
        this.cmdMode = str;
    }

    public final void setCodeType(String str) {
        this.codeType = str;
    }

    public final void setCodepage(String str) {
        this.codepage = str;
    }

    public final void setCurrentLev(String str) {
        this.currentLev = str;
    }

    public final void setDevType(String str) {
        this.devType = str;
    }

    public final void setDeviceAddress(String str) {
        this.deviceAddress = str;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final void setDpiType(String str) {
        this.dpiType = str;
    }

    public final void setFactoryName(String str) {
        this.factoryName = str;
    }

    public final void setIsGZDev(String str) {
        this.isGZDev = str;
    }

    public final void setNfcEnable(String str) {
        this.nfcEnable = str;
    }

    public final void setPaperType(String str) {
        this.paperType = str;
    }

    public final void setPowerLev(String str) {
        this.powerLev = str;
    }

    public final void setPtStatus(String str) {
        this.ptStatus = str;
    }

    public final void setRemain(String str) {
        this.remain = str;
    }

    public final void setSpeedLev(String str) {
        this.speedLev = str;
    }

    public final void setZipEnable(String str) {
        this.zipEnable = str;
    }

    public String toString() {
        long j6 = this.f8862a;
        String str = this.dpiType;
        String str2 = this.cmdMode;
        String str3 = this.codepage;
        String str4 = this.codeType;
        String str5 = this.speedLev;
        int i5 = this.e;
        String str6 = this.currentLev;
        String str7 = this.paperType;
        String str8 = this.powerLev;
        String str9 = this.isGZDev;
        String str10 = this.devType;
        String str11 = this.ptStatus;
        String str12 = this.factoryName;
        String str13 = this.deviceName;
        int i6 = this.f8870m;
        int i7 = this.f8874q;
        String str14 = this.uid;
        String str15 = this.remain;
        StringBuilder sb = new StringBuilder("PrinterInfo{checkSum=");
        sb.append(j6);
        sb.append(", packLen=");
        sb.append(this.b);
        sb.append(", version=");
        sb.append(this.c);
        sb.append(", maxDotLine=");
        sb.append(this.d);
        a.y(sb, ", dpiType='", str, "', cmdMode='", str2);
        a.y(sb, "', codepage='", str3, "', codeType='", str4);
        sb.append("', speedLev='");
        sb.append(str5);
        sb.append("', depthLev=");
        sb.append(i5);
        a.y(sb, ", currentLev='", str6, "', paperType='", str7);
        a.y(sb, "', powerLev='", str8, "', isGZDev='", str9);
        a.y(sb, "', devType='", str10, "', ptStatus='", str11);
        a.y(sb, "', factoryName='", str12, "', deviceName='", str13);
        sb.append("', ptTemp=");
        sb.append(this.f8868k);
        sb.append(", isRTC=");
        sb.append(this.f8869l);
        sb.append(", pt2tearLen=");
        sb.append(i6);
        sb.append(", endFeedLen=");
        sb.append(this.f8871n);
        sb.append(", sleepTime=");
        sb.append(this.f8872o);
        sb.append(", colourType=");
        sb.append(this.f8873p);
        sb.append(", align=");
        sb.append(i7);
        sb.append(", reprint=");
        sb.append(this.f8875r);
        a.y(sb, ", uid='", str14, "', remain='", str15);
        sb.append("'}");
        return sb.toString();
    }
}
