package org.apache.poi.hssf.usermodel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Hashtable;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherGraphics2d extends Graphics2D {
    private static final Logger LOG = LogManager.getLogger((Class<?>) EscherGraphics2d.class);
    private Shape _deviceclip;
    private final EscherGraphics _escherGraphics;
    private BufferedImage _img;
    private Paint _paint;
    private Stroke _stroke;
    private AffineTransform _trans;

    public EscherGraphics2d(EscherGraphics escherGraphics) {
        this._escherGraphics = escherGraphics;
        setImg(new BufferedImage(1, 1, 2));
        setColor(Color.black);
    }

    private Shape getDeviceclip() {
        return this._deviceclip;
    }

    private EscherGraphics getEscherGraphics() {
        return this._escherGraphics;
    }

    private Graphics2D getG2D() {
        return this._img.getGraphics();
    }

    private BufferedImage getImg() {
        return this._img;
    }

    private AffineTransform getTrans() {
        return this._trans;
    }

    private void setDeviceclip(Shape shape) {
        this._deviceclip = shape;
    }

    private void setImg(BufferedImage bufferedImage) {
        this._img = bufferedImage;
    }

    private void setTrans(AffineTransform affineTransform) {
        this._trans = affineTransform;
    }

    public void addRenderingHints(Map<?, ?> map) {
        getG2D().addRenderingHints(map);
    }

    public void clearRect(int i5, int i6, int i7, int i8) {
        Paint paint = getPaint();
        setColor(getBackground());
        fillRect(i5, i6, i7, i8);
        setPaint(paint);
    }

    public void clip(Shape shape) {
        if (getDeviceclip() != null) {
            Shape area = new Area(getClip());
            if (shape != null) {
                area.intersect(new Area(shape));
            }
            shape = area;
        }
        setClip(shape);
    }

    public void clipRect(int i5, int i6, int i7, int i8) {
        clip(new Rectangle(i5, i6, i7, i8));
    }

    public void copyArea(int i5, int i6, int i7, int i8, int i9, int i10) {
        getG2D().copyArea(i5, i6, i7, i8, i9, i10);
    }

    public Graphics create() {
        return new EscherGraphics2d(this._escherGraphics);
    }

    public void dispose() {
        getEscherGraphics().dispose();
        getG2D().dispose();
        getImg().flush();
    }

    public void draw(Shape shape) {
        if (!(shape instanceof Line2D)) {
            LOG.atWarn().log("draw not fully supported");
            return;
        }
        Line2D line2D = (Line2D) shape;
        BasicStroke basicStroke = this._stroke;
        drawLine((int) line2D.getX1(), (int) line2D.getY1(), (int) line2D.getX2(), (int) line2D.getY2(), (basicStroke == null || !(basicStroke instanceof BasicStroke)) ? 0 : ((int) basicStroke.getLineWidth()) * 12700);
    }

    public void drawArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        draw(new Arc2D.Float(i5, i6, i7, i8, i9, i10, 0));
    }

    public void drawGlyphVector(GlyphVector glyphVector, float f6, float f7) {
        fill(glyphVector.getOutline(f6, f7));
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, Color color, ImageObserver imageObserver) {
        LOG.atWarn().log("drawImage() not supported");
        return true;
    }

    public void drawLine(int i5, int i6, int i7, int i8, int i9) {
        getEscherGraphics().drawLine(i5, i6, i7, i8, i9);
    }

    public void drawOval(int i5, int i6, int i7, int i8) {
        getEscherGraphics().drawOval(i5, i6, i7, i8);
    }

    public void drawPolygon(int[] iArr, int[] iArr2, int i5) {
        getEscherGraphics().drawPolygon(iArr, iArr2, i5);
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
        this._escherGraphics.drawRect(i5, i6, i7, i8);
    }

    public void drawRenderableImage(RenderableImage renderableImage, AffineTransform affineTransform) {
        drawRenderedImage(renderableImage.createDefaultRendering(), affineTransform);
    }

    public void drawRenderedImage(RenderedImage renderedImage, AffineTransform affineTransform) {
        BufferedImage bufferedImage = new BufferedImage(renderedImage.getColorModel(), renderedImage.getData().createCompatibleWritableRaster(), false, (Hashtable) null);
        bufferedImage.setData(renderedImage.getData());
        drawImage(bufferedImage, affineTransform, null);
    }

    public void drawRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        draw(new RoundRectangle2D.Float(i5, i6, i7, i8, i9, i10));
    }

    public void drawString(String str, float f6, float f7) {
        getEscherGraphics().drawString(str, (int) f6, (int) f7);
    }

    public void fill(Shape shape) {
        LOG.atWarn().log("fill(Shape) not supported");
    }

    public void fillArc(int i5, int i6, int i7, int i8, int i9, int i10) {
        fill(new Arc2D.Float(i5, i6, i7, i8, i9, i10, 2));
    }

    public void fillOval(int i5, int i6, int i7, int i8) {
        this._escherGraphics.fillOval(i5, i6, i7, i8);
    }

    public void fillPolygon(int[] iArr, int[] iArr2, int i5) {
        this._escherGraphics.fillPolygon(iArr, iArr2, i5);
    }

    public void fillRect(int i5, int i6, int i7, int i8) {
        getEscherGraphics().fillRect(i5, i6, i7, i8);
    }

    public void fillRoundRect(int i5, int i6, int i7, int i8, int i9, int i10) {
        fill(new RoundRectangle2D.Float(i5, i6, i7, i8, i9, i10));
    }

    public Color getBackground() {
        return getEscherGraphics().getBackground();
    }

    public Shape getClip() {
        try {
            return getTrans().createInverse().createTransformedShape(getDeviceclip());
        } catch (Exception unused) {
            return null;
        }
    }

    public Rectangle getClipBounds() {
        Shape clip;
        if (getDeviceclip() == null || (clip = getClip()) == null) {
            return null;
        }
        return clip.getBounds();
    }

    public Color getColor() {
        return this._escherGraphics.getColor();
    }

    public Composite getComposite() {
        return getG2D().getComposite();
    }

    public GraphicsConfiguration getDeviceConfiguration() {
        return getG2D().getDeviceConfiguration();
    }

    public Font getFont() {
        return getEscherGraphics().getFont();
    }

    public FontMetrics getFontMetrics(Font font) {
        return getEscherGraphics().getFontMetrics(font);
    }

    public FontRenderContext getFontRenderContext() {
        getG2D().setTransform(getTrans());
        return getG2D().getFontRenderContext();
    }

    public Paint getPaint() {
        return this._paint;
    }

    public Object getRenderingHint(RenderingHints.Key key) {
        return getG2D().getRenderingHint(key);
    }

    public RenderingHints getRenderingHints() {
        return getG2D().getRenderingHints();
    }

    public Stroke getStroke() {
        return this._stroke;
    }

    public AffineTransform getTransform() {
        return (AffineTransform) getTrans().clone();
    }

    public boolean hit(Rectangle rectangle, Shape shape, boolean z6) {
        getG2D().setTransform(getTrans());
        getG2D().setStroke(getStroke());
        getG2D().setClip(getClip());
        return getG2D().hit(rectangle, shape, z6);
    }

    public void rotate(double d) {
        getTrans().rotate(d);
    }

    public void scale(double d, double d6) {
        getTrans().scale(d, d6);
    }

    public void setBackground(Color color) {
        getEscherGraphics().setBackground(color);
    }

    public void setClip(int i5, int i6, int i7, int i8) {
        setClip(new Rectangle(i5, i6, i7, i8));
    }

    public void setColor(Color color) {
        this._escherGraphics.setColor(color);
    }

    public void setComposite(Composite composite) {
        getG2D().setComposite(composite);
    }

    public void setFont(Font font) {
        getEscherGraphics().setFont(font);
    }

    public void setPaint(Paint paint) {
        if (paint != null) {
            this._paint = paint;
            if (paint instanceof Color) {
                setColor((Color) paint);
            }
        }
    }

    public void setPaintMode() {
        getEscherGraphics().setPaintMode();
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        getG2D().setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map<?, ?> map) {
        getG2D().setRenderingHints(map);
    }

    public void setStroke(Stroke stroke) {
        this._stroke = stroke;
    }

    public void setTransform(AffineTransform affineTransform) {
        setTrans((AffineTransform) affineTransform.clone());
    }

    public void setXORMode(Color color) {
        getEscherGraphics().setXORMode(color);
    }

    public void shear(double d, double d6) {
        getTrans().shear(d, d6);
    }

    public void transform(AffineTransform affineTransform) {
        getTrans().concatenate(affineTransform);
    }

    public void translate(double d, double d6) {
        getTrans().translate(d, d6);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, ImageObserver imageObserver) {
        LOG.atWarn().log("drawImage() not supported");
        return drawImage(image, i5, i6, i7, i8, i9, i10, i11, i12, null, imageObserver);
    }

    public void drawLine(int i5, int i6, int i7, int i8) {
        BasicStroke basicStroke = this._stroke;
        getEscherGraphics().drawLine(i5, i6, i7, i8, (basicStroke == null || !(basicStroke instanceof BasicStroke)) ? 0 : ((int) basicStroke.getLineWidth()) * 12700);
    }

    public void drawString(String str, int i5, int i6) {
        getEscherGraphics().drawString(str, i5, i6);
    }

    public void rotate(double d, double d6, double d7) {
        getTrans().rotate(d, d6, d7);
    }

    public void setClip(Shape shape) {
        setDeviceclip(getTrans().createTransformedShape(shape));
    }

    public void translate(int i5, int i6) {
        getTrans().translate(i5, i6);
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, float f6, float f7) {
        TextLayout textLayout = new TextLayout(attributedCharacterIterator, getFontRenderContext());
        Paint paint = getPaint();
        setColor(getColor());
        fill(textLayout.getOutline(AffineTransform.getTranslateInstance(f6, f7)));
        setPaint(paint);
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, Color color, ImageObserver imageObserver) {
        LOG.atWarn().log("drawImage() not supported");
        return true;
    }

    public boolean drawImage(Image image, int i5, int i6, int i7, int i8, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, i7, i8, null, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, Color color, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, image.getWidth(imageObserver), image.getHeight(imageObserver), color, imageObserver);
    }

    public boolean drawImage(Image image, int i5, int i6, ImageObserver imageObserver) {
        return drawImage(image, i5, i6, image.getWidth(imageObserver), image.getHeight(imageObserver), imageObserver);
    }

    public boolean drawImage(Image image, AffineTransform affineTransform, ImageObserver imageObserver) {
        AffineTransform affineTransform2 = (AffineTransform) getTrans().clone();
        getTrans().concatenate(affineTransform);
        drawImage(image, 0, 0, imageObserver);
        setTrans(affineTransform2);
        return true;
    }

    public void drawString(AttributedCharacterIterator attributedCharacterIterator, int i5, int i6) {
        getEscherGraphics().drawString(attributedCharacterIterator, i5, i6);
    }

    public void drawImage(BufferedImage bufferedImage, BufferedImageOp bufferedImageOp, int i5, int i6) {
        drawImage(bufferedImageOp.filter(bufferedImage, (BufferedImage) null), new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, i5, i6), null);
    }
}
