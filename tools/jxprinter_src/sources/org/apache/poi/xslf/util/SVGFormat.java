package org.apache.poi.xslf.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.poi.sl.draw.Drawable;
import org.apache.poi.util.Internal;
import org.apache.poi.xslf.draw.SVGPOIGraphics2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class SVGFormat implements OutputFormat {
    static final String svgNS = "http://www.w3.org/2000/svg";
    private SVGGraphics2D svgGenerator;
    private final boolean textAsShapes;

    public SVGFormat(boolean z6) {
        this.textAsShapes = z6;
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public Graphics2D addSlide(double d, double d6) {
        SVGPOIGraphics2D sVGPOIGraphics2D = new SVGPOIGraphics2D(GenericDOMImplementation.getDOMImplementation().createDocument(svgNS, "svg", null), this.textAsShapes);
        this.svgGenerator = sVGPOIGraphics2D;
        sVGPOIGraphics2D.setSVGCanvasSize(new Dimension((int) d, (int) d6));
        this.svgGenerator.setRenderingHint(Drawable.CACHE_IMAGE_SOURCE, Boolean.TRUE);
        return this.svgGenerator;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.svgGenerator.dispose();
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public void writeSlide(MFProxy mFProxy, File file) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file.getCanonicalPath()), StandardCharsets.UTF_8);
        try {
            this.svgGenerator.stream(outputStreamWriter, true);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
