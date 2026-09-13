package org.apache.poi.sl.draw;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawTextShape extends DrawSimpleShape {

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTextShape$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment;

        static {
            int[] iArr = new int[VerticalAlignment.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment = iArr;
            try {
                iArr[VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment[VerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment[VerticalAlignment.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DrawTextShape(TextShape<?, ?> textShape) {
        super(textShape);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00da  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        double height;
        double d;
        TextShape.TextDirection textDirection;
        TextShape.TextDirection textDirection2;
        double d6;
        TextShape<?, ? extends TextParagraph<?, ?, ? extends TextRun>> shape = getShape();
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, shape);
        if (anchor == null) {
            return;
        }
        Insets2D insets = shape.getInsets();
        double x6 = anchor.getX() + insets.left;
        double y6 = anchor.getY();
        AffineTransform transform = graphics2D.getTransform();
        boolean flipVertical = shape.getFlipVertical();
        boolean flipHorizontal = shape.getFlipHorizontal();
        ShapeContainer<?, ? extends TextParagraph<?, ?, ? extends TextRun>> parent = shape.getParent();
        while (parent instanceof PlaceableShape) {
            PlaceableShape placeableShape = (PlaceableShape) parent;
            flipVertical ^= placeableShape.getFlipVertical();
            flipHorizontal ^= placeableShape.getFlipHorizontal();
            parent = placeableShape.getParent();
        }
        if (flipVertical ^ flipHorizontal) {
            double x7 = anchor.getX();
            double y7 = anchor.getY();
            graphics2D.translate(anchor.getWidth() + x7, y7);
            graphics2D.scale(-1.0d, 1.0d);
            graphics2D.translate(-x7, -y7);
        }
        Double textRotation = shape.getTextRotation();
        if (textRotation != null && textRotation.doubleValue() != 0.0d) {
            double centerX = anchor.getCenterX();
            double centerY = anchor.getCenterY();
            graphics2D.translate(centerX, centerY);
            graphics2D.rotate(Math.toRadians(textRotation.doubleValue()));
            graphics2D.translate(-centerX, -centerY);
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$VerticalAlignment[shape.getVerticalAlignment().ordinal()];
        if (i5 != 2) {
            if (i5 != 3) {
                d = y6 + insets.top;
            } else {
                double height2 = anchor.getHeight() - getTextHeight(graphics2D);
                double d7 = insets.top;
                height = (((height2 - d7) - insets.bottom) / 2.0d) + d7;
            }
            double d8 = d;
            textDirection = shape.getTextDirection();
            textDirection2 = TextShape.TextDirection.VERTICAL;
            if (textDirection != textDirection2 || textDirection == TextShape.TextDirection.VERTICAL_270) {
                if (textDirection == textDirection2) {
                    d6 = 90.0d;
                } else {
                    d6 = 270.0d;
                }
                double centerX2 = anchor.getCenterX();
                double centerY2 = anchor.getCenterY();
                graphics2D.translate(centerX2, centerY2);
                graphics2D.rotate(Math.toRadians(d6));
                graphics2D.translate(-centerX2, -centerY2);
                double width = (anchor.getWidth() - anchor.getHeight()) / 2.0d;
                graphics2D.translate(width, -width);
            }
            drawParagraphs(graphics2D, x6, d8);
            graphics2D.setTransform(transform);
        }
        height = (anchor.getHeight() - getTextHeight(graphics2D)) - insets.bottom;
        d = y6 + height;
        double d9 = d;
        textDirection = shape.getTextDirection();
        textDirection2 = TextShape.TextDirection.VERTICAL;
        if (textDirection != textDirection2) {
            if (textDirection == textDirection2) {
                d6 = 90.0d;
            } else {
                d6 = 270.0d;
            }
            double centerX3 = anchor.getCenterX();
            double centerY3 = anchor.getCenterY();
            graphics2D.translate(centerX3, centerY3);
            graphics2D.rotate(Math.toRadians(d6));
            graphics2D.translate(-centerX3, -centerY3);
            double width2 = (anchor.getWidth() - anchor.getHeight()) / 2.0d;
            graphics2D.translate(width2, -width2);
        } else {
            if (textDirection == textDirection2) {
                d6 = 90.0d;
            } else {
                d6 = 270.0d;
            }
            double centerX4 = anchor.getCenterX();
            double centerY4 = anchor.getCenterY();
            graphics2D.translate(centerX4, centerY4);
            graphics2D.rotate(Math.toRadians(d6));
            graphics2D.translate(-centerX4, -centerY4);
            double width3 = (anchor.getWidth() - anchor.getHeight()) / 2.0d;
            graphics2D.translate(width3, -width3);
        }
        drawParagraphs(graphics2D, x6, d9);
        graphics2D.setTransform(transform);
    }

    public double drawParagraphs(Graphics2D graphics2D, double d, double d6) {
        double d7;
        double dDoubleValue;
        double d8 = 0.0d;
        Double dValueOf = Double.valueOf(0.0d);
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        Iterator<? extends TextParagraph<?, ?, ? extends TextRun>> it = getShape().iterator();
        int i5 = 1;
        double dDoubleValue2 = d6;
        boolean z6 = true;
        int iIntValue = 0;
        while (it.hasNext()) {
            TextParagraph<?, ?, ? extends TextRun> next = it.next();
            DrawTextParagraph drawable = drawFactory.getDrawable(next);
            TextParagraph.BulletStyle bulletStyle = next.getBulletStyle();
            if (bulletStyle == null || bulletStyle.getAutoNumberingScheme() == null) {
                iIntValue = -1;
            } else {
                Integer autoNumberingStartAt = bulletStyle.getAutoNumberingStartAt();
                if (autoNumberingStartAt == null) {
                    autoNumberingStartAt = Integer.valueOf(i5);
                }
                if (autoNumberingStartAt.intValue() > iIntValue) {
                    iIntValue = autoNumberingStartAt.intValue();
                }
            }
            drawable.setAutoNumberingIdx(iIntValue);
            drawable.breakText(graphics2D);
            if (z6) {
                d7 = d8;
                dDoubleValue = dDoubleValue2 + ((double) drawable.getFirstLineLeading());
            } else {
                d7 = d8;
                Double spaceBefore = next.getSpaceBefore();
                if (spaceBefore == null) {
                    spaceBefore = dValueOf;
                }
                if (spaceBefore.doubleValue() > d7) {
                    dDoubleValue = (spaceBefore.doubleValue() * 0.01d * ((double) drawable.getFirstLineHeight())) + dDoubleValue2;
                } else {
                    dDoubleValue = dDoubleValue2 + (-spaceBefore.doubleValue());
                }
            }
            drawable.setPosition(d, dDoubleValue);
            drawable.setFirstParagraph(z6);
            drawable.draw(graphics2D);
            double y6 = drawable.getY() + dDoubleValue;
            if (it.hasNext()) {
                Double spaceAfter = next.getSpaceAfter();
                if (spaceAfter == null) {
                    spaceAfter = dValueOf;
                }
                if (spaceAfter.doubleValue() > d7) {
                    dDoubleValue2 = (spaceAfter.doubleValue() * 0.01d * ((double) drawable.getLastLineHeight())) + y6;
                } else {
                    y6 += -spaceAfter.doubleValue();
                    dDoubleValue2 = y6;
                }
            } else {
                dDoubleValue2 = y6;
            }
            iIntValue++;
            d8 = d7;
            i5 = 1;
            z6 = false;
        }
        return dDoubleValue2 - d6;
    }

    public double getTextHeight() {
        return getTextHeight(null);
    }

    public double getTextHeight(Graphics2D graphics2D) {
        Graphics2D graphics2DCreateGraphics = new BufferedImage(1, 1, 1).createGraphics();
        if (graphics2D != null) {
            graphics2DCreateGraphics.addRenderingHints(graphics2D.getRenderingHints());
            graphics2DCreateGraphics.setTransform(graphics2D.getTransform());
        }
        return drawParagraphs(graphics2DCreateGraphics, 0.0d, 0.0d);
    }

    @Override // org.apache.poi.sl.draw.DrawSimpleShape, org.apache.poi.sl.draw.DrawShape
    public TextShape<?, ? extends TextParagraph<?, ?, ? extends TextRun>> getShape() {
        return (TextShape) this.shape;
    }
}
