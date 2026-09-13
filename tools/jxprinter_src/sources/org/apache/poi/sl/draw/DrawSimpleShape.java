package org.apache.poi.sl.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.poi.sl.draw.geom.Context;
import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.draw.geom.Outline;
import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.sl.draw.geom.PathIf;
import org.apache.poi.sl.usermodel.LineDecoration;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.Shadow;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.util.Units;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawSimpleShape extends DrawShape {
    private static final double DECO_SIZE_POW = 1.5d;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawSimpleShape$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape;

        static {
            int[] iArr = new int[LineDecoration.DecorationShape.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape = iArr;
            try {
                iArr[LineDecoration.DecorationShape.OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[LineDecoration.DecorationShape.STEALTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[LineDecoration.DecorationShape.ARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[LineDecoration.DecorationShape.TRIANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DrawSimpleShape(SimpleShape<?, ?> simpleShape) {
        super(simpleShape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: fillArea, reason: merged with bridge method [inline-methods] */
    public void lambda$draw$0(Graphics2D graphics2D, PaintStyle.PaintModifier paintModifier, Path2D path2D) {
        SimpleShape<?, ?> shape = getShape();
        Paint paint = DrawFactory.getInstance(graphics2D).getPaint(shape).getPaint(graphics2D, shape.getFillStyle().getPaint(), paintModifier);
        if (paint != null) {
            graphics2D.setPaint(paint);
            DrawPaint.fillPaintWorkaround(graphics2D, path2D);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006a  */
    /* JADX WARN: Code duplicated, block: B:23:0x007a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0083  */
    public Collection<Outline> computeOutlines(Graphics2D graphics2D) {
        Rectangle2D anchor;
        double width;
        double d;
        double d6;
        SimpleShape<?, ?> shape = getShape();
        ArrayList arrayList = new ArrayList();
        CustomGeometry geometry = shape.getGeometry();
        if (geometry != null && (anchor = DrawShape.getAnchor(graphics2D, shape)) != null) {
            for (PathIf pathIf : geometry) {
                double w6 = pathIf.getW();
                double h6 = pathIf.getH();
                double height = 1.0d;
                if (w6 == -1.0d) {
                    w6 = Units.toEMU(anchor.getWidth());
                    width = Units.toPoints(1L);
                } else {
                    if (anchor.getWidth() == 0.0d) {
                        d = w6;
                        d6 = 1.0d;
                    } else {
                        width = anchor.getWidth() / w6;
                    }
                    if (h6 == -1.0d) {
                        h6 = Units.toEMU(anchor.getHeight());
                        height = Units.toPoints(1L);
                    } else if (anchor.getHeight() != 0.0d) {
                        height = anchor.getHeight() / h6;
                    }
                    Path2D.Double path = pathIf.getPath(new Context(geometry, new Rectangle2D.Double(0.0d, 0.0d, d, h6), shape));
                    AffineTransform affineTransform = new AffineTransform();
                    Rectangle2D rectangle2D = anchor;
                    affineTransform.translate(anchor.getX(), rectangle2D.getY());
                    affineTransform.scale(d6, height);
                    arrayList.add(new Outline(affineTransform.createTransformedShape(path), pathIf));
                    anchor = rectangle2D;
                    geometry = geometry;
                }
                d = w6;
                d6 = width;
                if (h6 == -1.0d) {
                    h6 = Units.toEMU(anchor.getHeight());
                    height = Units.toPoints(1L);
                } else if (anchor.getHeight() != 0.0d) {
                    height = anchor.getHeight() / h6;
                }
                Path2D.Double path2 = pathIf.getPath(new Context(geometry, new Rectangle2D.Double(0.0d, 0.0d, d, h6), shape));
                AffineTransform affineTransform2 = new AffineTransform();
                Rectangle2D rectangle2D2 = anchor;
                affineTransform2.translate(anchor.getX(), rectangle2D2.getY());
                affineTransform2.scale(d6, height);
                arrayList.add(new Outline(affineTransform2.createTransformedShape(path2), pathIf));
                anchor = rectangle2D2;
                geometry = geometry;
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        if (DrawShape.getAnchor(graphics2D, getShape()) == null) {
            return;
        }
        Paint paint = graphics2D.getPaint();
        Stroke stroke = graphics2D.getStroke();
        Color color = graphics2D.getColor();
        Paint fillPaint = getFillPaint(graphics2D);
        Paint linePaint = getLinePaint(graphics2D);
        BasicStroke stroke2 = getStroke();
        graphics2D.setStroke(stroke2);
        Collection<Outline> collectionComputeOutlines = computeOutlines(graphics2D);
        drawShadow(graphics2D, collectionComputeOutlines, fillPaint, linePaint);
        if (fillPaint != null) {
            Path2D.Double r6 = new Path2D.Double();
            graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, r6);
            PaintStyle.PaintModifier paintModifier = null;
            for (Outline outline : collectionComputeOutlines) {
                PathIf path = outline.getPath();
                if (path.isFilled()) {
                    PaintStyle.PaintModifier fill = path.getFill();
                    if (paintModifier == null || paintModifier == fill) {
                        r6.append(outline.getOutline(), false);
                    } else {
                        lambda$draw$0(graphics2D, r6, paintModifier);
                        r6.reset();
                    }
                    paintModifier = fill;
                }
            }
            if (r6.getCurrentPoint() != null) {
                lambda$draw$0(graphics2D, r6, paintModifier);
            }
        }
        drawContent(graphics2D);
        if (linePaint != null) {
            graphics2D.setPaint(linePaint);
            graphics2D.setStroke(stroke2);
            for (Outline outline2 : collectionComputeOutlines) {
                if (outline2.getPath().isStroked()) {
                    Shape outline3 = outline2.getOutline();
                    graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline3);
                    graphics2D.draw(outline3);
                }
            }
        }
        drawDecoration(graphics2D, linePaint, stroke2);
        graphics2D.setColor(color);
        graphics2D.setPaint(paint);
        graphics2D.setStroke(stroke);
    }

    public void drawDecoration(Graphics2D graphics2D, Paint paint, BasicStroke basicStroke) {
        if (paint == null) {
            return;
        }
        graphics2D.setPaint(paint);
        ArrayList arrayList = new ArrayList();
        LineDecoration lineDecoration = getShape().getLineDecoration();
        Outline headDecoration = getHeadDecoration(graphics2D, lineDecoration, basicStroke);
        if (headDecoration != null) {
            arrayList.add(headDecoration);
        }
        Outline tailDecoration = getTailDecoration(graphics2D, lineDecoration, basicStroke);
        if (tailDecoration != null) {
            arrayList.add(tailDecoration);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            Outline outline = (Outline) obj;
            Shape outline2 = outline.getOutline();
            PathIf path = outline.getPath();
            graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
            if (path.isFilled()) {
                graphics2D.fill(outline2);
            }
            if (path.isStroked()) {
                graphics2D.draw(outline2);
            }
        }
    }

    public void drawShadow(Graphics2D graphics2D, Collection<Outline> collection, Paint paint, Paint paint2) {
        Shadow<S, P> shadow = getShape().getShadow();
        if (shadow != 0) {
            if (paint == null && paint2 == null) {
                return;
            }
            Color colorApplyColorTransform = DrawPaint.applyColorTransform(shadow.getFillStyle().getSolidColor());
            double rotation = getShape().getRotation();
            if (getShape().getFlipVertical()) {
                rotation += 180.0d;
            }
            double angle = shadow.getAngle() - rotation;
            double distance = shadow.getDistance();
            double dCos = Math.cos(Math.toRadians(angle)) * distance;
            double dSin = Math.sin(Math.toRadians(angle)) * distance;
            graphics2D.translate(dCos, dSin);
            for (Outline outline : collection) {
                Shape outline2 = outline.getOutline();
                PathIf path = outline.getPath();
                graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
                graphics2D.setPaint(colorApplyColorTransform);
                if (paint != null && path.isFilled()) {
                    DrawPaint.fillPaintWorkaround(graphics2D, outline2);
                } else if (paint2 != null && path.isStroked()) {
                    graphics2D.draw(outline2);
                }
            }
            graphics2D.translate(-dCos, -dSin);
        }
    }

    public Paint getFillPaint(Graphics2D graphics2D) {
        return DrawFactory.getInstance(graphics2D).getPaint(getShape()).getPaint(graphics2D, getShape().getFillStyle().getPaint());
    }

    public Outline getHeadDecoration(Graphics2D graphics2D, LineDecoration lineDecoration, BasicStroke basicStroke) {
        double x6;
        double y6;
        double dAtan;
        Path path;
        Shape shapeCreateTransformedShape;
        if (lineDecoration == null || basicStroke == null) {
            return null;
        }
        LineDecoration.DecorationSize headLength = lineDecoration.getHeadLength();
        if (headLength == null) {
            headLength = LineDecoration.DecorationSize.MEDIUM;
        }
        LineDecoration.DecorationSize headWidth = lineDecoration.getHeadWidth();
        if (headWidth == null) {
            headWidth = LineDecoration.DecorationSize.MEDIUM;
        }
        double dMax = Math.max(2.5d, basicStroke.getLineWidth());
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, getShape());
        if (anchor != null) {
            x6 = anchor.getX();
            y6 = anchor.getY();
            dAtan = Math.atan(anchor.getHeight() / anchor.getWidth());
        } else {
            x6 = 0.0d;
            y6 = 0.0d;
            dAtan = 0.0d;
        }
        AffineTransform affineTransform = new AffineTransform();
        double dPow = Math.pow(DECO_SIZE_POW, ((double) headWidth.ordinal()) + 1.0d);
        double dPow2 = Math.pow(DECO_SIZE_POW, ((double) headLength.ordinal()) + 1.0d);
        LineDecoration.DecorationShape headShape = lineDecoration.getHeadShape();
        if (headShape == null) {
            return null;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[headShape.ordinal()];
        if (i5 == 1) {
            path = new Path();
            Shape shape = new Ellipse2D.Double(0.0d, 0.0d, dMax * dPow2, dMax * dPow);
            Rectangle2D bounds2D = shape.getBounds2D();
            affineTransform.translate(x6 - (bounds2D.getWidth() / 2.0d), y6 - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(dAtan, (bounds2D.getWidth() / 2.0d) + bounds2D.getX(), (bounds2D.getHeight() / 2.0d) + bounds2D.getY());
            shapeCreateTransformedShape = shape;
        } else if (i5 == 2 || i5 == 3) {
            path = new Path();
            path.setFill(PaintStyle.PaintModifier.NONE);
            path.setStroke(true);
            shapeCreateTransformedShape = new Path2D.Double();
            double d = dPow2 * dMax;
            shapeCreateTransformedShape.moveTo(d, ((-dMax) * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d, (dMax * dPow) / 2.0d);
            affineTransform.translate(x6, y6);
            affineTransform.rotate(dAtan);
        } else if (i5 != 4) {
            path = null;
            shapeCreateTransformedShape = null;
        } else {
            path = new Path();
            shapeCreateTransformedShape = new Path2D.Double();
            double d6 = dPow2 * dMax;
            shapeCreateTransformedShape.moveTo(d6, ((-dMax) * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d6, (dMax * dPow) / 2.0d);
            shapeCreateTransformedShape.closePath();
            affineTransform.translate(x6, y6);
            affineTransform.rotate(dAtan);
        }
        if (shapeCreateTransformedShape != null) {
            shapeCreateTransformedShape = affineTransform.createTransformedShape(shapeCreateTransformedShape);
        }
        if (shapeCreateTransformedShape == null) {
            return null;
        }
        return new Outline(shapeCreateTransformedShape, path);
    }

    public Paint getLinePaint(Graphics2D graphics2D) {
        return DrawFactory.getInstance(graphics2D).getPaint(getShape()).getPaint(graphics2D, getShape().getStrokeStyle().getPaint());
    }

    public BasicStroke getStroke() {
        return DrawShape.getStroke(getShape().getStrokeStyle());
    }

    public Outline getTailDecoration(Graphics2D graphics2D, LineDecoration lineDecoration, BasicStroke basicStroke) {
        double x6;
        double y6;
        double dAtan;
        Path path;
        Shape shapeCreateTransformedShape;
        if (lineDecoration == null || basicStroke == null) {
            return null;
        }
        LineDecoration.DecorationSize tailLength = lineDecoration.getTailLength();
        if (tailLength == null) {
            tailLength = LineDecoration.DecorationSize.MEDIUM;
        }
        LineDecoration.DecorationSize tailWidth = lineDecoration.getTailWidth();
        if (tailWidth == null) {
            tailWidth = LineDecoration.DecorationSize.MEDIUM;
        }
        double dMax = Math.max(2.5d, basicStroke.getLineWidth());
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, getShape());
        if (anchor != null) {
            x6 = anchor.getX() + anchor.getWidth();
            y6 = anchor.getY() + anchor.getHeight();
            dAtan = Math.atan(anchor.getHeight() / anchor.getWidth());
        } else {
            x6 = 0.0d;
            y6 = 0.0d;
            dAtan = 0.0d;
        }
        AffineTransform affineTransform = new AffineTransform();
        double dPow = Math.pow(DECO_SIZE_POW, ((double) tailWidth.ordinal()) + 1.0d);
        double dPow2 = Math.pow(DECO_SIZE_POW, ((double) tailLength.ordinal()) + 1.0d);
        LineDecoration.DecorationShape tailShape = lineDecoration.getTailShape();
        if (tailShape == null) {
            return null;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape[tailShape.ordinal()];
        if (i5 == 1) {
            path = new Path();
            Shape shape = new Ellipse2D.Double(0.0d, 0.0d, dMax * dPow2, dMax * dPow);
            Rectangle2D bounds2D = shape.getBounds2D();
            affineTransform.translate(x6 - (bounds2D.getWidth() / 2.0d), y6 - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(dAtan, (bounds2D.getWidth() / 2.0d) + bounds2D.getX(), (bounds2D.getHeight() / 2.0d) + bounds2D.getY());
            shapeCreateTransformedShape = shape;
        } else if (i5 == 2 || i5 == 3) {
            path = new Path();
            path.setFill(PaintStyle.PaintModifier.NONE);
            path.setStroke(true);
            shapeCreateTransformedShape = new Path2D.Double();
            double d = -dMax;
            double d6 = dPow2 * d;
            shapeCreateTransformedShape.moveTo(d6, (d * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d6, (dMax * dPow) / 2.0d);
            affineTransform.translate(x6, y6);
            affineTransform.rotate(dAtan);
        } else if (i5 != 4) {
            path = null;
            shapeCreateTransformedShape = null;
        } else {
            path = new Path();
            shapeCreateTransformedShape = new Path2D.Double();
            double d7 = -dMax;
            double d8 = dPow2 * d7;
            shapeCreateTransformedShape.moveTo(d8, (d7 * dPow) / 2.0d);
            shapeCreateTransformedShape.lineTo(0.0d, 0.0d);
            shapeCreateTransformedShape.lineTo(d8, (dMax * dPow) / 2.0d);
            shapeCreateTransformedShape.closePath();
            affineTransform.translate(x6, y6);
            affineTransform.rotate(dAtan);
        }
        if (shapeCreateTransformedShape != null) {
            shapeCreateTransformedShape = affineTransform.createTransformedShape(shapeCreateTransformedShape);
        }
        if (shapeCreateTransformedShape == null) {
            return null;
        }
        return new Outline(shapeCreateTransformedShape, path);
    }

    @Override // org.apache.poi.sl.draw.DrawShape
    public SimpleShape<?, ?> getShape() {
        return (SimpleShape) this.shape;
    }
}
