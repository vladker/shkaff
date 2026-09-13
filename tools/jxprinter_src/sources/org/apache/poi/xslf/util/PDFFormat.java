package org.apache.poi.xslf.util;

import de.rototor.pdfbox.graphics2d.PdfBoxGraphics2D;
import de.rototor.pdfbox.graphics2d.PdfBoxGraphics2DFontTextDrawer;
import java.awt.Graphics2D;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class PDFFormat implements OutputFormat {
    private PDPageContentStream contentStream;
    private final PDDocument document;
    private PdfBoxGraphics2DFontTextDrawer fontTextDrawer;
    private PdfBoxGraphics2D pdfBoxGraphics2D;

    public PDFFormat(boolean z6, String str, String str2) {
        if (!z6) {
            this.fontTextDrawer = new PDFFontMapper(str, str2);
        }
        this.document = new PDDocument();
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public Graphics2D addSlide(double d, double d6) {
        float f6 = (float) d;
        float f7 = (float) d6;
        PDPage pDPage = new PDPage(new PDRectangle(f6, f7));
        this.document.addPage(pDPage);
        this.contentStream = new PDPageContentStream(this.document, pDPage);
        PdfBoxGraphics2D pdfBoxGraphics2D = new PdfBoxGraphics2D(this.document, f6, f7);
        this.pdfBoxGraphics2D = pdfBoxGraphics2D;
        PdfBoxGraphics2DFontTextDrawer pdfBoxGraphics2DFontTextDrawer = this.fontTextDrawer;
        if (pdfBoxGraphics2DFontTextDrawer != null) {
            pdfBoxGraphics2D.setFontTextDrawer(pdfBoxGraphics2DFontTextDrawer);
        }
        return this.pdfBoxGraphics2D;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.document.close();
        } finally {
            PdfBoxGraphics2DFontTextDrawer pdfBoxGraphics2DFontTextDrawer = this.fontTextDrawer;
            if (pdfBoxGraphics2DFontTextDrawer != null) {
                pdfBoxGraphics2DFontTextDrawer.close();
            }
        }
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public void writeDocument(MFProxy mFProxy, File file) {
        this.document.save(new File(file.getCanonicalPath()));
    }

    @Override // org.apache.poi.xslf.util.OutputFormat
    public void writeSlide(MFProxy mFProxy, File file) {
        try {
            this.pdfBoxGraphics2D.dispose();
            this.contentStream.drawForm(this.pdfBoxGraphics2D.getXFormObject());
        } finally {
            this.contentStream.close();
        }
    }
}
