package org.apache.poi.ss.usermodel;

import com.google.common.primitives.UnsignedBytes;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ExtendedColor implements Color {
    private static byte applyTint(int i5, double d) {
        int i6;
        if (d > 0.0d) {
            double d6 = 1.0d - d;
            i6 = (int) ((255.0d - (d6 * 255.0d)) + (((double) i5) * d6));
        } else {
            if (d >= 0.0d) {
                return (byte) i5;
            }
            i6 = (int) ((d + 1.0d) * ((double) i5));
        }
        return (byte) i6;
    }

    public abstract byte[] getARGB();

    public String getARGBHex() {
        byte[] argb = getARGB();
        if (argb == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : argb) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.ROOT);
    }

    public abstract short getIndex();

    public abstract byte[] getIndexedRGB();

    public abstract byte[] getRGB();

    public byte[] getRGBOrARGB() {
        byte[] indexedRGB;
        return (!isIndexed() || getIndex() <= 0 || (indexedRGB = getIndexedRGB()) == null) ? getStoredRBG() : indexedRGB;
    }

    public byte[] getRGBWithTint() {
        byte[] storedRBG = getStoredRBG();
        if (storedRBG != null) {
            if (storedRBG.length == 4) {
                byte[] bArr = new byte[3];
                System.arraycopy(storedRBG, 1, bArr, 0, 3);
                storedRBG = bArr;
            }
            double tint = getTint();
            for (int i5 = 0; i5 < storedRBG.length; i5++) {
                storedRBG[i5] = applyTint(storedRBG[i5] & UnsignedBytes.MAX_VALUE, tint);
            }
        }
        return storedRBG;
    }

    public abstract byte[] getStoredRBG();

    public abstract int getTheme();

    public abstract double getTint();

    public abstract boolean isAuto();

    public abstract boolean isIndexed();

    public abstract boolean isRGB();

    public abstract boolean isThemed();

    public void setARGBHex(String str) {
        if (str.length() != 6 && str.length() != 8) {
            throw new IllegalArgumentException("Must be of the form 112233 or FFEEDDCC");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            bArr[i5] = (byte) Integer.parseInt(str.substring(i5 * 2, i6 * 2), 16);
            i5 = i6;
        }
        setRGB(bArr);
    }

    public void setColor(java.awt.Color color) {
        setRGB(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
    }

    public abstract void setRGB(byte[] bArr);

    public abstract void setTint(double d);
}
