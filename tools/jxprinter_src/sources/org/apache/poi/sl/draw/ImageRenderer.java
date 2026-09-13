package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.Dimension2DDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ImageRenderer {
    boolean canRender(String str);

    boolean drawImage(Graphics2D graphics2D, Rectangle2D rectangle2D);

    boolean drawImage(Graphics2D graphics2D, Rectangle2D rectangle2D, Insets insets);

    Rectangle2D getBounds();

    default String getCachedContentType() {
        return null;
    }

    default byte[] getCachedImage() {
        return null;
    }

    default Dimension2D getDimension() {
        Rectangle2D bounds = getBounds();
        return new Dimension2DDouble(Math.abs(bounds.getWidth()), Math.abs(bounds.getHeight()));
    }

    default GenericRecord getGenericRecord() {
        return null;
    }

    BufferedImage getImage();

    BufferedImage getImage(Dimension2D dimension2D);

    Rectangle2D getNativeBounds();

    void loadImage(InputStream inputStream, String str);

    void loadImage(byte[] bArr, String str);

    void setAlpha(double d);

    default void setCacheInput(boolean z6) {
    }

    default void setDefaultCharset(Charset charset) {
    }
}
