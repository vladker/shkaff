package org.apache.poi.sl.draw;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class DrawTexturePaint extends TexturePaint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Insets2D INSETS_EMPTY = new Insets2D(0.0d, 0.0d, 0.0d, 0.0d);
    private final PaintStyle.TexturePaint fill;
    private final double flipX;
    private final double flipY;
    private final ImageRenderer imgRdr;
    private final boolean isBitmapSrc;
    private final Shape shape;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTexturePaint$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment;

        static {
            int[] iArr = new int[PaintStyle.TextureAlignment.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment = iArr;
            try {
                iArr[PaintStyle.TextureAlignment.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.BOTTOM_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.BOTTOM_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.TOP_LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment[PaintStyle.TextureAlignment.TOP_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public DrawTexturePaint(ImageRenderer imageRenderer, BufferedImage bufferedImage, Shape shape, PaintStyle.TexturePaint texturePaint, double d, double d6, boolean z6) {
        super(bufferedImage, new Rectangle2D.Double(0.0d, 0.0d, bufferedImage.getWidth(), bufferedImage.getHeight()));
        this.imgRdr = imageRenderer;
        this.fill = texturePaint;
        this.shape = shape;
        this.flipX = d;
        this.flipY = d6;
        this.isBitmapSrc = z6;
    }

    private AffineTransform getTiledInstance(Rectangle2D rectangle2D, AffineTransform affineTransform) {
        double d;
        double d6;
        double d7;
        BufferedImage image = getImage();
        Dimension2D scale = this.fill.getScale();
        double d8 = 0.0d;
        double width = (((double) image.getWidth()) * (scale.getWidth() == 0.0d ? 1.0d : scale.getWidth())) / this.flipX;
        double height = (((double) image.getHeight()) * (scale.getHeight() == 0.0d ? 1.0d : scale.getHeight())) / this.flipY;
        PaintStyle.TextureAlignment alignment = this.fill.getAlignment();
        double width2 = rectangle2D.getWidth();
        double height2 = rectangle2D.getHeight();
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$TextureAlignment;
        if (alignment == null) {
            alignment = PaintStyle.TextureAlignment.TOP_LEFT;
        }
        switch (iArr[alignment.ordinal()]) {
            case 1:
                d8 = (width2 - width) / 2.0d;
                d6 = height2 - height;
                break;
            case 2:
                d = height2 - height;
                d6 = d;
                break;
            case 3:
                d8 = width2 - width;
                d6 = height2 - height;
                break;
            case 4:
                d8 = (width2 - width) / 2.0d;
                d6 = (height2 - height) / 2.0d;
                break;
            case 5:
                d = (height2 - height) / 2.0d;
                d6 = d;
                break;
            case 6:
                d8 = width2 - width;
                d6 = (height2 - height) / 2.0d;
                break;
            case 7:
                d7 = (width2 - width) / 2.0d;
                d6 = 0.0d;
                d8 = d7;
                break;
            case 8:
            default:
                d6 = 0.0d;
                break;
            case 9:
                d7 = width2 - width;
                d6 = 0.0d;
                d8 = d7;
                break;
        }
        affineTransform.translate(d8, d6);
        Point2D offset = this.fill.getOffset();
        if (offset != null) {
            affineTransform.translate(offset.getX(), offset.getY());
        }
        affineTransform.scale(scale.getWidth() / (this.isBitmapSrc ? this.flipX : 1.0d), scale.getHeight() / (this.isBitmapSrc ? this.flipY : 1.0d));
        return affineTransform;
    }

    public PaintContext createContext(ColorModel colorModel, Rectangle rectangle, Rectangle2D rectangle2D, AffineTransform affineTransform, RenderingHints renderingHints) {
        Rectangle2D bounds2D;
        Dimension2DDouble dimension2DDouble = new Dimension2DDouble();
        if (this.fill.isRotatedWithShape() || this.shape == null) {
            bounds2D = rectangle2D;
        } else {
            AffineTransform affineTransform2 = new AffineTransform(affineTransform);
            affineTransform2.preConcatenate(AffineTransform.getTranslateInstance(-affineTransform2.getTranslateX(), -affineTransform2.getTranslateY()));
            Point2D.Double r6 = new Point2D.Double(1.0d, 0.0d);
            Point2D point2DTransform = affineTransform2.transform(r6, r6);
            double dAtan2 = Math.atan2(point2DTransform.getY(), point2DTransform.getX());
            if (dAtan2 != 0.0d) {
                affineTransform.rotate(-dAtan2, rectangle2D.getCenterX(), rectangle2D.getCenterY());
            }
            bounds2D = AffineTransform.getRotateInstance(dAtan2, rectangle2D.getCenterX(), rectangle2D.getCenterY()).createTransformedShape(this.shape).getBounds2D();
        }
        dimension2DDouble.setSize(bounds2D.getWidth(), bounds2D.getHeight());
        affineTransform.translate(bounds2D.getX(), bounds2D.getY());
        BufferedImage image = getImage(bounds2D);
        if (this.fill.getStretch() != null) {
            return new TexturePaint(image, new Rectangle2D.Double(0.0d, 0.0d, image.getWidth(), image.getHeight())).createContext(colorModel, rectangle, bounds2D, affineTransform, renderingHints);
        }
        if (this.fill.getScale() == null) {
            return super.createContext(colorModel, rectangle, rectangle2D, affineTransform, renderingHints);
        }
        return new TexturePaint(image, new Rectangle2D.Double(0.0d, 0.0d, image.getWidth(), image.getHeight())).createContext(colorModel, rectangle, rectangle2D, getTiledInstance(bounds2D, (AffineTransform) affineTransform.clone()), renderingHints);
    }

    public Shape getAwtShape() {
        return this.shape;
    }

    public PaintStyle.TexturePaint getFill() {
        return this.fill;
    }

    public BufferedImage getImage(Rectangle2D rectangle2D) {
        double d;
        BufferedImage image = super.getImage();
        Insets2D insets = this.fill.getInsets();
        Insets2D stretch = this.fill.getStretch();
        if (((insets != null && !INSETS_EMPTY.equals(insets)) || stretch != null) && rectangle2D != null && !rectangle2D.isEmpty()) {
            if (insets == null || INSETS_EMPTY.equals(insets)) {
                d = 100000.0d;
            } else {
                double width = image.getWidth();
                double height = image.getHeight();
                d = 100000.0d;
                BufferedImage subimage = image.getSubimage((int) ((Math.max(insets.left, 0.0d) / 100000.0d) * width), (int) ((Math.max(insets.top, 0.0d) / 100000.0d) * height), (int) ((((100000.0d - Math.max(insets.left, 0.0d)) - Math.max(insets.right, 0.0d)) / 100000.0d) * width), (int) ((((100000.0d - Math.max(insets.top, 0.0d)) - Math.max(insets.bottom, 0.0d)) / 100000.0d) * height));
                int iMax = (int) ((Math.max(-insets.top, 0.0d) / 100000.0d) * height);
                int iMax2 = (int) ((Math.max(-insets.left, 0.0d) / 100000.0d) * width);
                int iMax3 = (int) ((Math.max(-insets.bottom, 0.0d) / 100000.0d) * height);
                int iMax4 = (int) ((Math.max(-insets.right, 0.0d) / 100000.0d) * width);
                if (iMax > 0 || iMax2 > 0 || iMax3 > 0 || iMax4 > 0) {
                    int[] iArr = new int[subimage.getWidth() * subimage.getHeight()];
                    subimage.getRGB(0, 0, subimage.getWidth(), subimage.getHeight(), iArr, 0, subimage.getWidth());
                    BufferedImage bufferedImage = new BufferedImage(subimage.getWidth() + iMax2 + iMax4, subimage.getHeight() + iMax + iMax3, subimage.getType());
                    bufferedImage.setRGB(iMax2, iMax, subimage.getWidth(), subimage.getHeight(), iArr, 0, subimage.getWidth());
                    image = bufferedImage;
                } else {
                    image = subimage;
                }
            }
            if (stretch != null) {
                Rectangle2D.Double r6 = new Rectangle2D.Double(0.0d, 0.0d, image.getWidth(), image.getHeight());
                Rectangle2D.Double r7 = new Rectangle2D.Double((stretch.left / d) * rectangle2D.getWidth(), (stretch.top / d) * rectangle2D.getHeight(), (((d - stretch.left) - stretch.right) / d) * rectangle2D.getWidth(), (((d - stretch.top) - stretch.bottom) / d) * rectangle2D.getHeight());
                BufferedImage bufferedImage2 = new BufferedImage((int) rectangle2D.getWidth(), (int) rectangle2D.getHeight(), 2);
                Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                graphics2DCreateGraphics.setComposite(AlphaComposite.Clear);
                graphics2DCreateGraphics.fillRect(0, 0, bufferedImage2.getWidth(), bufferedImage2.getHeight());
                graphics2DCreateGraphics.setComposite(AlphaComposite.SrcOver);
                AffineTransform affineTransform = new AffineTransform();
                affineTransform.translate(r7.getCenterX(), r7.getCenterY());
                affineTransform.scale(r7.getWidth() / r6.getWidth(), r7.getHeight() / r6.getHeight());
                affineTransform.translate(-r6.getCenterX(), -r6.getCenterY());
                graphics2DCreateGraphics.drawRenderedImage(image, affineTransform);
                graphics2DCreateGraphics.dispose();
                return bufferedImage2;
            }
        }
        return image;
    }

    public ImageRenderer getImageRenderer() {
        return this.imgRdr;
    }
}
