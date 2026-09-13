package org.apache.poi.xslf.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.ref.WeakReference;
import javax.imageio.ImageIO;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.sl.draw.Drawable;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class BitmapFormat implements OutputFormat {
    private final String format;
    private Graphics2D graphics;
    private BufferedImage img;

    public BitmapFormat(String str) {
        this.format = str;
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public Graphics2D addSlide(double d, double d6) {
        String str = this.format;
        str.getClass();
        BufferedImage bufferedImage = new BufferedImage((int) d, (int) d6, (str.equals(ContentTypes.EXTENSION_GIF) || str.equals(ContentTypes.EXTENSION_PNG)) ? 2 : 1);
        this.img = bufferedImage;
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        this.graphics = graphics2DCreateGraphics;
        graphics2DCreateGraphics.setRenderingHint(Drawable.BUFFERED_IMAGE, new WeakReference(this.img));
        return this.graphics;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Graphics2D graphics2D = this.graphics;
        if (graphics2D != null) {
            graphics2D.dispose();
            this.img.flush();
        }
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public void writeSlide(MFProxy mFProxy, File file) {
        if (AbstractC1127c.NULL.equals(this.format)) {
            return;
        }
        ImageIO.write(this.img, this.format, file);
    }
}
