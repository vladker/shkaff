package org.apache.poi.sl.draw;

import A3.AbstractC0157z;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.IllegalPathStateException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class PathGradientPaint implements Paint {
    private final int capStyle;
    private final Color[] colors;
    private final float[] fractions;
    private final int joinStyle;
    private final int transparency;

    public PathGradientPaint(float[] fArr, Color[] colorArr) {
        this(fArr, colorArr, 1, 1);
    }

    public int getTransparency() {
        return this.transparency;
    }

    private PathGradientPaint(float[] fArr, Color[] colorArr, int i5, int i6) {
        this.colors = (Color[]) colorArr.clone();
        this.fractions = (float[]) fArr.clone();
        this.capStyle = i5;
        this.joinStyle = i6;
        boolean z6 = true;
        for (Color color : colorArr) {
            if (color != null) {
                z6 = z6 && color.getAlpha() == 255;
            }
        }
        this.transparency = z6 ? 1 : 3;
    }

    public PathGradientContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) {
        return new PathGradientContext(colorModel, rectangle, rectangle2D, affineTransform, renderingHints);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class PathGradientContext implements PaintContext {
        final Rectangle deviceBounds;
        final int gradientSteps;
        final RenderingHints hints;
        final PaintContext pCtx;
        WritableRaster raster;
        protected final Shape shape;
        final Rectangle2D userBounds;
        protected final AffineTransform xform;

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.awt.geom.IllegalPathStateException */
        public PathGradientContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) throws IllegalPathStateException {
            Shape shape = (Shape) renderingHints.get(Drawable.GRADIENT_SHAPE);
            this.shape = shape;
            if (shape == null) {
                throw new IllegalPathStateException("PathGradientPaint needs a shape to be set via the rendering hint Drawable.GRADIANT_SHAPE.");
            }
            this.deviceBounds = rectangle;
            this.userBounds = rectangle2D;
            this.xform = affineTransform;
            this.hints = renderingHints;
            int gradientSteps = getGradientSteps(shape);
            this.gradientSteps = gradientSteps;
            LinearGradientPaint linearGradientPaint = new LinearGradientPaint(new Point2D.Double(0.0d, 0.0d), new Point2D.Double(gradientSteps, 0.0d), PathGradientPaint.this.fractions, PathGradientPaint.this.colors, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform());
            Rectangle rectangle2 = new Rectangle(0, 0, gradientSteps, 1);
            this.pCtx = linearGradientPaint.createContext(colorModel, rectangle2, rectangle2, new AffineTransform(), renderingHints);
        }

        public WritableRaster createRaster() {
            WritableRaster writableRaster = this.raster;
            if (writableRaster != null) {
                return writableRaster;
            }
            ColorModel colorModel = getColorModel();
            this.raster = colorModel.createCompatibleWritableRaster((int) this.deviceBounds.getWidth(), (int) this.deviceBounds.getHeight());
            Graphics2D graphics2DCreateGraphics = new BufferedImage(colorModel, this.raster, false, (Hashtable) null).createGraphics();
            graphics2DCreateGraphics.setRenderingHints(this.hints);
            graphics2DCreateGraphics.translate(-this.deviceBounds.getX(), -this.deviceBounds.getY());
            graphics2DCreateGraphics.transform(this.xform);
            Raster raster = this.pCtx.getRaster(0, 0, this.gradientSteps, 1);
            int numComponents = colorModel.getNumComponents();
            int[] iArr = new int[numComponents];
            for (int i5 = this.gradientSteps - 1; i5 >= 0; i5--) {
                raster.getPixel((this.gradientSteps - i5) - 1, 0, iArr);
                Color color = new Color(iArr[0], iArr[1], iArr[2]);
                if (numComponents == 4) {
                    graphics2DCreateGraphics.setComposite(AlphaComposite.getInstance(2, iArr[3] / 255.0f));
                }
                graphics2DCreateGraphics.setStroke(new BasicStroke(i5 + 1.0f, PathGradientPaint.this.capStyle, PathGradientPaint.this.joinStyle));
                graphics2DCreateGraphics.setColor(color);
                if (i5 == this.gradientSteps - 1) {
                    graphics2DCreateGraphics.fill(this.shape);
                }
                graphics2DCreateGraphics.draw(this.shape);
            }
            graphics2DCreateGraphics.dispose();
            return this.raster;
        }

        public ColorModel getColorModel() {
            return this.pCtx.getColorModel();
        }

        public int getGradientSteps(Shape shape) {
            Rectangle bounds = shape.getBounds();
            int iMax = (int) (Math.max(bounds.getWidth(), bounds.getHeight()) / 2.0d);
            int i5 = 1;
            while (i5 < iMax - 1) {
                int iB = AbstractC0157z.b(iMax, i5, 2, i5);
                if (new Area(new BasicStroke(iB, PathGradientPaint.this.capStyle, PathGradientPaint.this.joinStyle).createStrokedShape(shape)).isSingular()) {
                    iMax = iB;
                } else {
                    i5 = iB;
                }
            }
            return Math.max(iMax, 1);
        }

        public Raster getRaster(int i5, int i6, int i7, int i8) {
            ColorModel colorModel = getColorModel();
            this.raster = createRaster();
            WritableRaster writableRasterCreateCompatibleWritableRaster = colorModel.createCompatibleWritableRaster(i7, i8);
            Rectangle2D.Double r6 = new Rectangle2D.Double(i5, i6, i7, i8);
            if (!r6.intersects(this.deviceBounds)) {
                return writableRasterCreateCompatibleWritableRaster;
            }
            Rectangle2D.Double r15 = new Rectangle2D.Double();
            Rectangle2D.intersect(r6, this.deviceBounds, r15);
            int x6 = (int) (r15.getX() - this.deviceBounds.getX());
            int y6 = (int) (r15.getY() - this.deviceBounds.getY());
            int width = (int) r15.getWidth();
            int height = (int) r15.getHeight();
            writableRasterCreateCompatibleWritableRaster.setDataElements((int) (r15.getX() - r6.getX()), (int) (r15.getY() - r6.getY()), width, height, this.raster.getDataElements(x6, y6, width, height, (Object) null));
            return writableRasterCreateCompatibleWritableRaster;
        }

        public void dispose() {
        }
    }
}
