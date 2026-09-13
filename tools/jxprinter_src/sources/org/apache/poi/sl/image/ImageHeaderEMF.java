package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ImageHeaderEMF {
    private static final String EMF_SIGNATURE = " EMF";
    private static final Logger LOG = LogManager.getLogger((Class<?>) ImageHeaderEMF.class);
    private final Rectangle deviceBounds;

    public ImageHeaderEMF(byte[] bArr, int i5) {
        if (((int) LittleEndian.getUInt(bArr, i5)) != 1) {
            LOG.atWarn().log("Invalid EMF picture - invalid type");
            this.deviceBounds = new Rectangle(0, 0, 200, 200);
            return;
        }
        int i6 = LittleEndian.getInt(bArr, i5 + 8);
        int i7 = LittleEndian.getInt(bArr, i5 + 12);
        int i8 = LittleEndian.getInt(bArr, i5 + 16);
        int i9 = i8 - i6;
        int i10 = LittleEndian.getInt(bArr, i5 + 20) - i7;
        this.deviceBounds = new Rectangle(i6, i7, i9 == -1 ? 0 : i9, i10 != -1 ? i10 : 0);
        if (EMF_SIGNATURE.equals(new String(bArr, i5 + 40, 4, LocaleUtil.CHARSET_1252))) {
            return;
        }
        LOG.atWarn().log("Invalid EMF picture - invalid signature");
    }

    public Rectangle getBounds() {
        return this.deviceBounds;
    }

    public Dimension getSize() {
        return this.deviceBounds.getSize();
    }
}
