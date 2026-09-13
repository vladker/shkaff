package org.apache.poi.sl.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawTableShape extends DrawShape {

    @Internal
    public static final int borderSize = 2;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawTableShape$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge;

        static {
            int[] iArr = new int[TableCell.BorderEdge.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge = iArr;
            try {
                iArr[TableCell.BorderEdge.bottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.top.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DrawTableShape(TableShape<?, ?> tableShape) {
        super(tableShape);
    }

    private static void setEdges(TableCell<?, ?> tableCell, TableCell.BorderEdge[] borderEdgeArr, Object... objArr) {
        if (tableCell == null) {
            return;
        }
        for (TableCell.BorderEdge borderEdge : borderEdgeArr) {
            if (borderEdge != null) {
                if (objArr.length == 0) {
                    tableCell.removeBorder(borderEdge);
                } else {
                    for (Object obj : objArr) {
                        if (obj instanceof Double) {
                            tableCell.setBorderWidth(borderEdge, ((Double) obj).doubleValue());
                        } else if (obj instanceof Color) {
                            tableCell.setBorderColor(borderEdge, (Color) obj);
                        } else if (obj instanceof StrokeStyle.LineDash) {
                            tableCell.setBorderDash(borderEdge, (StrokeStyle.LineDash) obj);
                        } else if (obj instanceof StrokeStyle.LineCompound) {
                            tableCell.setBorderCompound(borderEdge, (StrokeStyle.LineCompound) obj);
                        }
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void applyTransform(Graphics2D graphics2D) {
        Drawable groupShape = getGroupShape(graphics2D);
        if (groupShape != null) {
            groupShape.applyTransform(graphics2D);
        } else {
            super.applyTransform(graphics2D);
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Shape shape;
        Shape shape2;
        Drawable groupShape = getGroupShape(graphics2D);
        if (groupShape != null) {
            groupShape.draw(graphics2D);
            return;
        }
        TableShape<?, ?> shape3 = getShape();
        DrawPaint paint = DrawFactory.getInstance(graphics2D).getPaint(shape3);
        int numberOfRows = shape3.getNumberOfRows();
        int numberOfColumns = shape3.getNumberOfColumns();
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            for (int i6 = 0; i6 < numberOfColumns; i6++) {
                TableCell<S, P> cell = shape3.getCell(i5, i6);
                if (cell != 0 && !cell.isMerged()) {
                    graphics2D.setPaint(paint.getPaint(graphics2D, cell.getFillStyle().getPaint()));
                    Rectangle2D anchor = cell.getAnchor();
                    DrawPaint.fillPaintWorkaround(graphics2D, anchor);
                    for (TableCell.BorderEdge borderEdge : TableCell.BorderEdge.values()) {
                        StrokeStyle borderStyle = cell.getBorderStyle(borderEdge);
                        if (borderStyle != null) {
                            graphics2D.setStroke(DrawShape.getStroke(borderStyle));
                            graphics2D.setPaint(paint.getPaint(graphics2D, borderStyle.getPaint()));
                            double x6 = anchor.getX();
                            double y6 = anchor.getY();
                            double width = anchor.getWidth();
                            double height = anchor.getHeight();
                            int i7 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[borderEdge.ordinal()];
                            if (i7 != 2) {
                                if (i7 == 3) {
                                    double d = x6 + width;
                                    shape2 = new Line2D.Double(d, y6, d, y6 + height + 2.0d);
                                } else if (i7 != 4) {
                                    double d6 = y6 + height;
                                    shape = new Line2D.Double(x6 - 2.0d, d6, x6 + width + 2.0d, d6);
                                } else {
                                    shape2 = new Line2D.Double(x6 - 2.0d, y6, x6 + width + 2.0d, y6);
                                }
                                shape = shape2;
                            } else {
                                shape = new Line2D.Double(x6, y6, x6, y6 + height + 2.0d);
                            }
                            graphics2D.draw(shape);
                        }
                    }
                }
            }
        }
        drawContent(graphics2D);
    }

    @Override // org.apache.poi.sl.draw.DrawShape, org.apache.poi.sl.draw.Drawable
    public void drawContent(Graphics2D graphics2D) {
        Drawable groupShape = getGroupShape(graphics2D);
        if (groupShape != null) {
            groupShape.drawContent(graphics2D);
            return;
        }
        TableShape<?, ?> shape = getShape();
        DrawFactory drawFactory = DrawFactory.getInstance(graphics2D);
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            for (int i6 = 0; i6 < numberOfColumns; i6++) {
                TextShape<?, ?> cell = shape.getCell(i5, i6);
                if (cell != null) {
                    drawFactory.getDrawable(cell).drawContent(graphics2D);
                }
            }
        }
    }

    public Drawable getGroupShape(Graphics2D graphics2D) {
        if (this.shape instanceof GroupShape) {
            return DrawFactory.getInstance(graphics2D).getDrawable((GroupShape<?, ?>) this.shape);
        }
        return null;
    }

    public void setAllBorders(Object... objArr) {
        TableShape<?, ?> shape = getShape();
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        TableCell.BorderEdge[] borderEdgeArr = {TableCell.BorderEdge.top, TableCell.BorderEdge.left, null, null};
        int i5 = 0;
        while (i5 < numberOfRows) {
            int i6 = 0;
            while (i6 < numberOfColumns) {
                borderEdgeArr[2] = i6 == numberOfColumns + (-1) ? TableCell.BorderEdge.right : null;
                borderEdgeArr[3] = i5 == numberOfRows + (-1) ? TableCell.BorderEdge.bottom : null;
                setEdges(shape.getCell(i5, i6), borderEdgeArr, objArr);
                i6++;
            }
            i5++;
        }
    }

    public void setInsideBorders(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        TableShape<?, ?> shape = getShape();
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            int i6 = 0;
            while (i6 < numberOfColumns) {
                TableCell.BorderEdge borderEdge = null;
                TableCell.BorderEdge borderEdge2 = (i6 <= 0 || i6 >= numberOfColumns + (-1)) ? null : TableCell.BorderEdge.right;
                if (i5 > 0 && i5 < numberOfRows - 1) {
                    borderEdge = TableCell.BorderEdge.bottom;
                }
                setEdges(shape.getCell(i5, i6), new TableCell.BorderEdge[]{borderEdge2, borderEdge}, objArr);
                i6++;
            }
        }
    }

    public void setOutsideBorders(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        TableShape<?, ?> shape = getShape();
        int numberOfRows = shape.getNumberOfRows();
        int numberOfColumns = shape.getNumberOfColumns();
        int i5 = 0;
        while (i5 < numberOfRows) {
            int i6 = 0;
            while (i6 < numberOfColumns) {
                TableCell.BorderEdge borderEdge = null;
                TableCell.BorderEdge borderEdge2 = i6 == 0 ? TableCell.BorderEdge.left : null;
                TableCell.BorderEdge borderEdge3 = i6 == numberOfColumns + (-1) ? TableCell.BorderEdge.right : null;
                TableCell.BorderEdge borderEdge4 = i5 == 0 ? TableCell.BorderEdge.top : null;
                if (i5 == numberOfRows - 1) {
                    borderEdge = TableCell.BorderEdge.bottom;
                }
                setEdges(shape.getCell(i5, i6), new TableCell.BorderEdge[]{borderEdge2, borderEdge3, borderEdge4, borderEdge}, objArr);
                i6++;
            }
            i5++;
        }
    }

    @Override // org.apache.poi.sl.draw.DrawShape
    public TableShape<?, ?> getShape() {
        return (TableShape) this.shape;
    }
}
