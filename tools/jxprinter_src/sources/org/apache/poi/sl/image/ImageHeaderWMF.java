package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ImageHeaderWMF {
    public static final int APMHEADER_KEY = -1698247209;
    private static final Logger LOG = LogManager.getLogger((Class<?>) ImageHeaderWMF.class);
    private final int bottom;
    private int checksum;
    private final int handle;
    private final int inch;
    private final int left;
    private final int reserved;
    private final int right;
    private final int top;

    public ImageHeaderWMF(Rectangle rectangle) {
        this.handle = 0;
        this.left = rectangle.x;
        this.top = rectangle.y;
        this.right = rectangle.x + rectangle.width;
        this.bottom = rectangle.y + rectangle.height;
        this.inch = 72;
        this.reserved = 0;
    }

    public Rectangle getBounds() {
        int i5 = this.left;
        int i6 = this.top;
        return new Rectangle(i5, i6, this.right - i5, this.bottom - i6);
    }

    public int getChecksum() {
        return (((((-43247) ^ this.left) ^ this.top) ^ this.right) ^ this.bottom) ^ this.inch;
    }

    public int getLength() {
        return 22;
    }

    public Dimension getSize() {
        double d = 72.0d / ((double) this.inch);
        return new Dimension((int) Math.round(((double) (this.right - this.left)) * d), (int) Math.round(((double) (this.bottom - this.top)) * d));
    }

    public void write(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[22];
        LittleEndian.putInt(bArr, 0, APMHEADER_KEY);
        LittleEndian.putUShort(bArr, 4, 0);
        LittleEndian.putUShort(bArr, 6, this.left);
        LittleEndian.putUShort(bArr, 8, this.top);
        LittleEndian.putUShort(bArr, 10, this.right);
        LittleEndian.putUShort(bArr, 12, this.bottom);
        LittleEndian.putUShort(bArr, 14, this.inch);
        LittleEndian.putInt(bArr, 16, 0);
        int checksum = getChecksum();
        this.checksum = checksum;
        LittleEndian.putUShort(bArr, 20, checksum);
        outputStream.write(bArr);
    }

    public ImageHeaderWMF(byte[] bArr, int i5) {
        int i6 = i5 + 4;
        if (LittleEndian.getInt(bArr, i5) != -1698247209) {
            LOG.atWarn().log("WMF file doesn't contain a placeable header - ignore parsing");
            this.handle = 0;
            this.left = 0;
            this.top = 0;
            this.right = 200;
            this.bottom = 200;
            this.inch = 72;
            this.reserved = 0;
            return;
        }
        this.handle = LittleEndian.getUShort(bArr, i6);
        this.left = LittleEndian.getShort(bArr, i5 + 6);
        this.top = LittleEndian.getShort(bArr, i5 + 8);
        this.right = LittleEndian.getShort(bArr, i5 + 10);
        this.bottom = LittleEndian.getShort(bArr, i5 + 12);
        this.inch = LittleEndian.getUShort(bArr, i5 + 14);
        this.reserved = LittleEndian.getInt(bArr, i5 + 16);
        short s6 = LittleEndian.getShort(bArr, i5 + 20);
        this.checksum = s6;
        if (s6 != getChecksum()) {
            LOG.atWarn().log("WMF checksum does not match the header data");
        }
    }
}
