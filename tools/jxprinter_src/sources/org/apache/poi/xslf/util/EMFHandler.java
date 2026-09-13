package org.apache.poi.xslf.util;

import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.sl.draw.BitmapImageRenderer;
import org.apache.poi.sl.draw.DrawPictureShape;
import org.apache.poi.sl.draw.EmbeddedExtractor;
import org.apache.poi.sl.draw.ImageRenderer;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class EMFHandler extends MFProxy {
    private ImageRenderer imgr = null;
    private InputStream is;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.is;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.is = null;
            }
        }
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void draw(Graphics2D graphics2D) {
        Dimension2D size = getSize();
        this.imgr.drawImage(graphics2D, new Rectangle2D.Double(0.0d, 0.0d, size.getWidth(), size.getHeight()));
    }

    public String getContentType() {
        return PictureData.PictureType.EMF.contentType;
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public Iterable<EmbeddedExtractor.EmbeddedPart> getEmbeddings(int i5) {
        ImageRenderer imageRenderer = this.imgr;
        return imageRenderer instanceof EmbeddedExtractor ? ((EmbeddedExtractor) imageRenderer).getEmbeddings() : Collections.EMPTY_LIST;
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public GenericRecord getRoot() {
        return this.imgr.getGenericRecord();
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public Dimension2D getSize() {
        return this.imgr.getDimension();
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public String getTitle() {
        return "";
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void parse(File file) throws IOException {
        InputStream inputStreamOpenStream = file.toURI().toURL().openStream();
        this.is = inputStreamOpenStream;
        parse(inputStreamOpenStream);
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void setDefaultCharset(Charset charset) {
        this.imgr.setDefaultCharset(charset);
    }

    @Override // org.apache.poi.xslf.util.MFProxy
    public void parse(InputStream inputStream) throws PPTX2PNG.NoScratchpadException {
        ImageRenderer imageRenderer = DrawPictureShape.getImageRenderer(null, getContentType());
        this.imgr = imageRenderer;
        if (!(imageRenderer instanceof BitmapImageRenderer)) {
            imageRenderer.loadImage(inputStream, getContentType());
            if (this.ignoreParse) {
                try {
                    this.imgr.getDimension();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        throw new PPTX2PNG.NoScratchpadException();
    }
}
