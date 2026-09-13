package org.apache.poi.hssf.usermodel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.SuppressForbidden;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherGraphics extends Graphics {
    private static final Logger LOG = LogManager.getLogger((Class<?>) EscherGraphics.class);
    private Color background;
    private final HSSFShapeGroup escherGroup;
    private Font font;
    private Color foreground;
    private final float verticalPixelsPerPoint;
    private final float verticalPointsPerPixel;
    private final HSSFWorkbook workbook;

    public EscherGraphics(HSSFShapeGroup hSSFShapeGroup, HSSFWorkbook hSSFWorkbook, Color color, float f6) {
        this.background = Color.white;
        this.escherGroup = hSSFShapeGroup;
        this.workbook = hSSFWorkbook;
        this.verticalPointsPerPixel = f6;
        this.verticalPixelsPerPoint = 1.0f / f6;
        this.font = new Font(HSSFFont.FONT_ARIAL, 0, 10);
        this.foreground = color;
    }

    private int[] addToAll(int[] iArr, int i5) {
        int[] iArr2 = new int[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr2[i6] = iArr[i6] + i5;
        }
        return iArr2;
    }

    private int findBiggest(int[] iArr) {
        int i5 = Integer.MIN_VALUE;
        for (int i6 : iArr) {
            if (i6 > i5) {
                i5 = i6;
            }
        }
        return i5;
    }

    private int findSmallest(int[] iArr) {
        int i5 = Integer.MAX_VALUE;
        for (int i6 : iArr) {
            if (i6 < i5) {
                i5 = i6;
            }
        }
        return i5;
    }

    private HSSFFont matchFont(Font font) {
        HSSFColor hSSFColorFindColor = this.workbook.getCustomPalette().findColor((byte) this.foreground.getRed(), (byte) this.foreground.getGreen(), (byte) this.foreground.getBlue());
        if (hSSFColorFindColor == null) {
            hSSFColorFindColor = this.workbook.getCustomPalette().findSimilarColor((byte) this.foreground.getRed(), (byte) this.foreground.getGreen(), (byte) this.foreground.getBlue());
        }
        boolean z6 = (font.getStyle() & 1) != 0;
        boolean z7 = (font.getStyle() & 2) != 0;
        HSSFFont hSSFFontFindFont = this.workbook.findFont(z6, hSSFColorFindColor.getIndex(), (short) (font.getSize() * 20), font.getName(), z7, false, (short) 0, (byte) 0);
        if (hSSFFontFindFont != null) {
            return hSSFFontFindFont;
        }
        HSSFFont hSSFFontCreateFont = this.workbook.createFont();
        hSSFFontCreateFont.setBold(z6);
        hSSFFontCreateFont.setColor(hSSFColorFindColor.getIndex());
        hSSFFontCreateFont.setFontHeight((short) (font.getSize() * 20));
        hSSFFontCreateFont.setFontName(font.getName());
        hSSFFontCreateFont.setItalic(z7);
        hSSFFontCreateFont.setStrikeout(false);
        hSSFFontCreateFont.setTypeOffset((short) 0);
        hSSFFontCreateFont.setUnderline((byte) 0);
        return hSSFFontCreateFont;
    }

    public void clearRect(int i5, int i6, int i7, int i8) {
        Color color = this.foreground;
        setColor(this.background);
        fillRect(i5, i6, i7, i8);
        setColor(color);
    }

    @NotImplemented
    public void clipRect(int i5, int i6, int i7, int i8) {
        LOG.atWarn().log("clipRect not supported");
    }

    @NotImplemented
    public void copyArea(int i5, int i6, int i7, int i8, int i9, int i10) {
        LOG.atWarn().log("copyArea not supported");
    }

    public Graphics create() {
        return new EscherGraphics(this.escherGroup, this.workbook, this.foreground, this.font, this.verticalPointsPerPixel);
    }

    @NotImplemented
    public void drawArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        LOG.atWarn().log("drawArc not supported");
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Color color, ImageObserver imageObserver) {
        LOG.atWarn().log("drawImage not supported");
        return true;
    }

    public void drawLine(int i5, int i6, int i7, int i8) {
        drawLine(i5, i6, i7, i8, 0);
    }

    public void drawOval(int i5, int i6, int i7, int i8) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i5, i6, i7 + i5, i8 + i6));
        hSSFSimpleShapeCreateShape.setShapeType(3);
        hSSFSimpleShapeCreateShape.setLineWidth(0);
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setNoFill(true);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i5) {
        int iFindBiggest = findBiggest(iArr);
        int iFindBiggest2 = findBiggest(iArr2);
        int iFindSmallest = findSmallest(iArr);
        int iFindSmallest2 = findSmallest(iArr2);
        HSSFPolygon hSSFPolygonCreatePolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(iFindSmallest, iFindSmallest2, iFindBiggest, iFindBiggest2));
        hSSFPolygonCreatePolygon.setPolygonDrawArea(iFindBiggest - iFindSmallest, iFindBiggest2 - iFindSmallest2);
        hSSFPolygonCreatePolygon.setPoints(addToAll(iArr, -iFindSmallest), addToAll(iArr2, -iFindSmallest2));
        hSSFPolygonCreatePolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFPolygonCreatePolygon.setLineWidth(0);
        hSSFPolygonCreatePolygon.setNoFill(true);
    }

    @NotImplemented
    public void drawPolyline(int[] iArr, int[] iArr2, int i5) {
        LOG.atWarn().log("drawPolyline not supported");
    }

    @NotImplemented
    public void drawRect(int i5, int i6, int i7, int i8) {
        LOG.atWarn().log("drawRect not supported");
    }

    @NotImplemented
    public void drawRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        LOG.atWarn().log("drawRoundRect not supported");
    }

    public void drawString(String str, int i5, int i6) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Font font = this.font.getName().equals("SansSerif") ? new Font(HSSFFont.FONT_ARIAL, this.font.getStyle(), (int) (this.font.getSize() / this.verticalPixelsPerPoint)) : new Font(this.font.getName(), this.font.getStyle(), (int) (this.font.getSize() / this.verticalPixelsPerPoint));
        int stringWidth = (StaticFontMetrics.getFontDetails(font).getStringWidth(str) * 8) + 12;
        int size = ((int) ((this.font.getSize() / this.verticalPixelsPerPoint) + 6.0f)) * 2;
        float size2 = this.font.getSize();
        float f6 = this.verticalPixelsPerPoint;
        int i7 = (int) (i6 - ((f6 * 2.0f) + (size2 / f6)));
        HSSFTextbox hSSFTextboxCreateTextbox = this.escherGroup.createTextbox(new HSSFChildAnchor(i5, i7, stringWidth + i5, size + i7));
        hSSFTextboxCreateTextbox.setNoFill(true);
        hSSFTextboxCreateTextbox.setLineStyle(-1);
        HSSFRichTextString hSSFRichTextString = new HSSFRichTextString(str);
        hSSFRichTextString.applyFont(matchFont(font));
        hSSFTextboxCreateTextbox.setString(hSSFRichTextString);
    }

    public void fillArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        LOG.atWarn().log("fillArc not supported");
    }

    public void fillOval(int i5, int i6, int i7, int i8) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i5, i6, i7 + i5, i8 + i6));
        hSSFSimpleShapeCreateShape.setShapeType(3);
        hSSFSimpleShapeCreateShape.setLineStyle(-1);
        hSSFSimpleShapeCreateShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setNoFill(false);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i5) {
        int iFindBiggest = findBiggest(iArr);
        int iFindBiggest2 = findBiggest(iArr2);
        int iFindSmallest = findSmallest(iArr);
        int iFindSmallest2 = findSmallest(iArr2);
        HSSFPolygon hSSFPolygonCreatePolygon = this.escherGroup.createPolygon(new HSSFChildAnchor(iFindSmallest, iFindSmallest2, iFindBiggest, iFindBiggest2));
        hSSFPolygonCreatePolygon.setPolygonDrawArea(iFindBiggest - iFindSmallest, iFindBiggest2 - iFindSmallest2);
        hSSFPolygonCreatePolygon.setPoints(addToAll(iArr, -iFindSmallest), addToAll(iArr2, -iFindSmallest2));
        hSSFPolygonCreatePolygon.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFPolygonCreatePolygon.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    public void fillRect(int i5, int i6, int i7, int i8) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i5, i6, i7 + i5, i8 + i6));
        hSSFSimpleShapeCreateShape.setShapeType(1);
        hSSFSimpleShapeCreateShape.setLineStyle(-1);
        hSSFSimpleShapeCreateShape.setFillColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    public void fillRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        LOG.atWarn().log("fillRoundRect not supported");
    }

    public Color getBackground() {
        return this.background;
    }

    public Shape getClip() {
        return getClipBounds();
    }

    public Rectangle getClipBounds() {
        return null;
    }

    public Color getColor() {
        return this.foreground;
    }

    public HSSFShapeGroup getEscherGraphics() {
        return this.escherGroup;
    }

    public Font getFont() {
        return this.font;
    }

    @SuppressForbidden
    public FontMetrics getFontMetrics(Font font) {
        return Toolkit.getDefaultToolkit().getFontMetrics(font);
    }

    public void setBackground(Color color) {
        this.background = color;
    }

    public void setClip(int i5, int i6, int i7, int i8) {
        setClip(new Rectangle(i5, i6, i7, i8));
    }

    public void setColor(Color color) {
        this.foreground = color;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    @NotImplemented
    public void setPaintMode() {
        LOG.atWarn().log("setPaintMode not supported");
    }

    @NotImplemented
    public void setXORMode(Color color) {
        LOG.atWarn().log("setXORMode not supported");
    }

    @NotImplemented
    public void translate(int i5, int i6) {
        LOG.atWarn().log("translate not supported");
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, ImageObserver imageObserver) {
        LOG.atWarn().log("drawImage not supported");
        return true;
    }

    public void drawLine(int i5, int i6, int i7, int i8, int i9) {
        HSSFSimpleShape hSSFSimpleShapeCreateShape = this.escherGroup.createShape(new HSSFChildAnchor(i5, i6, i7, i8));
        hSSFSimpleShapeCreateShape.setShapeType(20);
        hSSFSimpleShapeCreateShape.setLineWidth(i9);
        hSSFSimpleShapeCreateShape.setLineStyleColor(this.foreground.getRed(), this.foreground.getGreen(), this.foreground.getBlue());
    }

    @NotImplemented
    public void setClip(Shape shape) {
        LOG.atWarn().log("setClip not supported");
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, i5 + i7, i6 + i8, 0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, i5 + i7, i6 + i8, 0, 0, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, Color color, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public EscherGraphics(HSSFShapeGroup hSSFShapeGroup, HSSFWorkbook hSSFWorkbook, Color color, Font font, float f6) {
        this.background = Color.white;
        this.escherGroup = hSSFShapeGroup;
        this.workbook = hSSFWorkbook;
        this.foreground = color;
        this.font = font;
        this.verticalPointsPerPixel = f6;
        this.verticalPixelsPerPoint = 1.0f / f6;
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i5, int i6) {
        LOG.atWarn().log("drawString not supported");
    }

    public void dispose() {
    }
}
