package org.apache.poi.sl.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.sl.usermodel.FreeformShape;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.sl.usermodel.TextBox;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.SuppressForbidden;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SLGraphics extends Graphics2D implements Cloneable {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SLGraphics.class);
    private GroupShape<?, ?> _group;
    private AffineTransform _transform = new AffineTransform();
    private Stroke _stroke = new BasicStroke();
    private Paint _paint = Color.black;
    private Font _font = new Font(HSSFFont.FONT_ARIAL, 0, 12);
    private Color _background = Color.black;
    private Color _foreground = Color.white;
    private RenderingHints _hints = new RenderingHints((Map) null);

    public SLGraphics(GroupShape<?, ?> groupShape) {
        this._group = groupShape;
    }

    private void logNotImplemented() {
        LOG.atWarn().log("Not implemented");
    }

    public void addRenderingHints(Map<?, ?> map) {
        this._hints.putAll(map);
    }

    public void applyPaint(SimpleShape<?, ?> simpleShape) {
        Color color = this._paint;
        if (color instanceof Color) {
            simpleShape.setFillColor(color);
        }
    }

    public void applyStroke(SimpleShape<?, ?> simpleShape) {
        BasicStroke basicStroke = this._stroke;
        if (basicStroke instanceof BasicStroke) {
            BasicStroke basicStroke2 = basicStroke;
            simpleShape.setStrokeStyle(Double.valueOf(basicStroke2.getLineWidth()));
            if (basicStroke2.getDashArray() != null) {
                simpleShape.setStrokeStyle(StrokeStyle.LineDash.DASH);
            }
        }
    }

    public void clearRect(int i5, int i6, int i7, int i8) {
        Paint paint = getPaint();
        setColor(getBackground());
        fillRect(i5, i6, i7, i8);
        setPaint(paint);
    }

    @NotImplemented
    public void clip(Shape shape) {
        logNotImplemented();
    }

    public void clipRect(int i5, int i6, int i7, int i8) {
        clip(new Rectangle(i5, i6, i7, i8));
    }

    public Graphics create() {
        try {
            return (Graphics) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Shape shape) {
        Path2D.Double r6 = new Path2D.Double(this._transform.createTransformedShape(shape));
        FreeformShape<?, ?> freeformShapeCreateFreeform = this._group.createFreeform();
        freeformShapeCreateFreeform.setPath(r6);
        freeformShapeCreateFreeform.setFillColor(null);
        applyStroke(freeformShapeCreateFreeform);
        Color color = this._paint;
        if (color instanceof Color) {
            freeformShapeCreateFreeform.setStrokeStyle(color);
        }
    }

    public void drawArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        draw(new Arc2D.Double(i5, i6, i7, i8, i9, i10, 0));
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f6, float f7) {
        fill(glyphVector.getOutline(f6, f7));
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, Color color, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    public void drawLine(int i5, int i6, int i7, int i8) {
        draw(new Line2D.Double(i5, i6, i7, i8));
    }

    public void drawOval(int i5, int i6, int i7, int i8) {
        draw(new Ellipse2D.Double(i5, i6, i7, i8));
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i5) {
        draw(new Polygon(iArr, iArr2, i5));
    }

    public void drawPolyline(int[] iArr, int[] iArr2, int i5) {
        if (i5 > 0) {
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(iArr[0], iArr2[0]);
            for (int i6 = 1; i6 < i5; i6++) {
                generalPath.lineTo(iArr[i6], iArr2[i6]);
            }
            draw(generalPath);
        }
    }

    public void drawRect(int i5, int i6, int i7, int i8) {
        draw(new Rectangle(i5, i6, i7, i8));
    }

    @NotImplemented
    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        logNotImplemented();
    }

    @NotImplemented
    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        logNotImplemented();
    }

    public void drawRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        draw(new RoundRectangle2D.Double(i5, i6, i7, i8, i9, i10));
    }

    public void drawString(String str, float f6, float f7) {
        TextBox<?, ?> textBoxCreateTextBox = this._group.createTextBox();
        TextRun textRun = (TextRun) ((TextParagraph) textBoxCreateTextBox.getTextParagraphs().get(0)).getTextRuns().get(0);
        textRun.setFontSize(Double.valueOf(this._font.getSize()));
        textRun.setFontFamily(this._font.getFamily());
        if (getColor() != null) {
            textRun.setFontColor(DrawPaint.createSolidPaint(getColor()));
        }
        if (this._font.isBold()) {
            textRun.setBold(true);
        }
        if (this._font.isItalic()) {
            textRun.setItalic(true);
        }
        textBoxCreateTextBox.setText(str);
        textBoxCreateTextBox.setInsets(new Insets2D(0.0d, 0.0d, 0.0d, 0.0d));
        textBoxCreateTextBox.setWordWrap(false);
        textBoxCreateTextBox.setHorizontalCentered(Boolean.FALSE);
        textBoxCreateTextBox.setVerticalAlignment(VerticalAlignment.MIDDLE);
        TextLayout textLayout = new TextLayout(str, this._font, getFontRenderContext());
        float ascent = textLayout.getAscent();
        float f8 = ascent * 2.0f;
        textBoxCreateTextBox.setAnchor(new Rectangle((int) f6, (int) (f7 - ((ascent / 2.0f) + (f8 / 2.0f))), (int) Math.floor(textLayout.getAdvance()), (int) f8));
    }

    public void fill(Shape shape) {
        Path2D.Double r6 = new Path2D.Double(this._transform.createTransformedShape(shape));
        FreeformShape<?, ?> freeformShapeCreateFreeform = this._group.createFreeform();
        freeformShapeCreateFreeform.setPath(r6);
        applyPaint(freeformShapeCreateFreeform);
        freeformShapeCreateFreeform.setStrokeStyle(new Object[0]);
    }

    public void fillArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        fill(new Arc2D.Double(i5, i6, i7, i8, i9, i10, 2));
    }

    public void fillOval(int i5, int i6, int i7, int i8) {
        fill(new Ellipse2D.Double(i5, i6, i7, i8));
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i5) {
        fill(new Polygon(iArr, iArr2, i5));
    }

    public void fillRect(int i5, int i6, int i7, int i8) {
        fill(new Rectangle(i5, i6, i7, i8));
    }

    public void fillRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        fill(new RoundRectangle2D.Double(i5, i6, i7, i8, i9, i10));
    }

    public Color getBackground() {
        return this._background;
    }

    @NotImplemented
    public Shape getClip() {
        logNotImplemented();
        return null;
    }

    public Rectangle getClipBounds() {
        logNotImplemented();
        return null;
    }

    public Color getColor() {
        return this._foreground;
    }

    @NotImplemented
    public Composite getComposite() {
        logNotImplemented();
        return null;
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public Font getFont() {
        return this._font;
    }

    @SuppressForbidden
    public FontMetrics getFontMetrics(Font font) {
        return Toolkit.getDefaultToolkit().getFontMetrics(font);
    }

    public FontRenderContext getFontRenderContext() {
        return new FontRenderContext(new AffineTransform(), RenderingHints.VALUE_TEXT_ANTIALIAS_ON.equals(getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING)), RenderingHints.VALUE_FRACTIONALMETRICS_ON.equals(getRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS)));
    }

    public Paint getPaint() {
        return this._paint;
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        return this._hints.get(key);
    }

    public RenderingHints getRenderingHints() {
        return this._hints;
    }

    public GroupShape<?, ?> getShapeGroup() {
        return this._group;
    }

    public Stroke getStroke() {
        return this._stroke;
    }

    public AffineTransform getTransform() {
        return new AffineTransform(this._transform);
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z6) {
        if (z6) {
            shape = getStroke().createStrokedShape(shape);
        }
        return getTransform().createTransformedShape(shape).intersects(rectangle);
    }

    public void rotate(double d) {
        this._transform.rotate(d);
    }

    public void scale(double d, double d6) {
        this._transform.scale(d, d6);
    }

    public void setBackground(Color color) {
        if (color == null) {
            return;
        }
        this._background = color;
    }

    @NotImplemented
    public void setClip(Shape shape) {
        logNotImplemented();
    }

    public void setColor(Color color) {
        setPaint(color);
    }

    @NotImplemented
    public void setComposite(Composite composite) {
        logNotImplemented();
    }

    public void setFont(Font font) {
        this._font = font;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            return;
        }
        this._paint = paint;
        if (paint instanceof Color) {
            this._foreground = (Color) paint;
        }
    }

    @NotImplemented
    public void setPaintMode() {
        logNotImplemented();
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        this._hints.put(key, obj);
    }

    public void setRenderingHints(Map<?, ?> map) {
        RenderingHints renderingHints = new RenderingHints((Map) null);
        this._hints = renderingHints;
        renderingHints.putAll(map);
    }

    public void setStroke(Stroke stroke) {
        this._stroke = stroke;
    }

    public void setTransform(AffineTransform affineTransform) {
        this._transform = new AffineTransform(affineTransform);
    }

    @NotImplemented
    public void setXORMode(Color color) {
        logNotImplemented();
    }

    public void shear(double d, double d6) {
        this._transform.shear(d, d6);
    }

    public void transform(AffineTransform affineTransform) {
        this._transform.concatenate(affineTransform);
    }

    public void translate(int i5, int i6) {
        this._transform.translate(i5, i6);
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    public void rotate(double d, double d6, double d7) {
        this._transform.rotate(d, d6, d7);
    }

    public void setClip(int i5, int i6, int i7, int i8) {
        setClip(new Rectangle(i5, i6, i7, i8));
    }

    public void translate(double d, double d6) {
        this._transform.translate(d, d6);
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Color color, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i5, int i6) {
        drawImage((Image) bufferedImageOp.filter(bufferedImage, (BufferedImage) null), i5, i6, (ImageObserver) null);
    }

    @NotImplemented
    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    @NotImplemented
    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        logNotImplemented();
        return false;
    }

    public void drawString(String str, int i5, int i6) {
        drawString(str, i5, i6);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i5, int i6) {
        drawString(attributedCharacterIterator, i5, i6);
    }

    public void dispose() {
    }

    @NotImplemented
    public void drawString(AttributedCharacterIterator attributedCharacterIterator, float f6, float f7) {
        logNotImplemented();
    }

    public void copyArea(int i5, int i6, int i7, int i8, int i9, int i10) {
    }
}
