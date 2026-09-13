package org.apache.poi.xslf.usermodel;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.ColorStyle;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTileInfoProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSLFTexturePaint implements PaintStyle.TexturePaint {
    private final CTBlip blip;
    private final CTBlipFillProperties blipFill;
    private final PackagePart parentPart;
    private final CTSchemeColor phClr;
    private final XSLFShape shape;
    private final XSLFSheet sheet;
    private final XSLFTheme theme;

    public XSLFTexturePaint(XSLFShape xSLFShape, CTBlipFillProperties cTBlipFillProperties, PackagePart packagePart, CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme, XSLFSheet xSLFSheet) {
        this.shape = xSLFShape;
        this.blipFill = cTBlipFillProperties;
        this.parentPart = packagePart;
        this.blip = cTBlipFillProperties.getBlip();
        this.phClr = cTSchemeColor;
        this.theme = xSLFTheme;
        this.sheet = xSLFSheet;
    }

    private PackagePart getPart() {
        POIXMLDocumentPart relationById;
        String embed = this.blip.getEmbed();
        return (this.shape.getParent() == null || !(this.shape.getParent() instanceof XSLFDiagram.XSLFDiagramGroupShape) || (relationById = ((XSLFDiagram.XSLFDiagramGroupShape) this.shape.getParent()).getRelationById(embed)) == null) ? this.parentPart.getRelatedPart(this.parentPart.getRelationship(embed)) : relationById.getPackagePart();
    }

    private static Insets2D getRectVal(final CTRelativeRect cTRelativeRect) {
        if (cTRelativeRect == null) {
            return null;
        }
        final int i5 = 0;
        final int i6 = 1;
        final int i7 = 2;
        final int i8 = 3;
        final int i9 = 4;
        final int i10 = 5;
        final int i11 = 6;
        final int i12 = 7;
        return new Insets2D(getRectVal(new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }, new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }), getRectVal(new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }, new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }), getRectVal(new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }, new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }), getRectVal(new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }, new Supplier() { // from class: org.apache.poi.xslf.usermodel.l
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Boolean.valueOf(cTRelativeRect.isSetT());
                    case 1:
                        return cTRelativeRect.xgetT();
                    case 2:
                        return Boolean.valueOf(cTRelativeRect.isSetL());
                    case 3:
                        return cTRelativeRect.xgetL();
                    case 4:
                        return Boolean.valueOf(cTRelativeRect.isSetB());
                    case 5:
                        return cTRelativeRect.xgetB();
                    case 6:
                        return Boolean.valueOf(cTRelativeRect.isSetR());
                    default:
                        return cTRelativeRect.xgetR();
                }
            }
        }));
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public PaintStyle.TextureAlignment getAlignment() {
        CTTileInfoProperties tile = this.blipFill.getTile();
        if (tile == null || !tile.isSetAlgn()) {
            return null;
        }
        return PaintStyle.TextureAlignment.fromOoxmlId(tile.getAlgn().toString());
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public int getAlpha() {
        return this.blip.sizeOfAlphaModFixArray() > 0 ? POIXMLUnits.parsePercent(this.blip.getAlphaModFixArray(0).xgetAmt()) : BZip2Constants.BASEBLOCKSIZE;
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public String getContentType() {
        CTBlip cTBlip = this.blip;
        if (cTBlip == null || !cTBlip.isSetEmbed() || this.blip.getEmbed().isEmpty()) {
            return null;
        }
        try {
            return getPart().getContentType();
        } catch (InvalidFormatException e) {
            throw new RuntimeException("Failed to read package part", e);
        }
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public List<ColorStyle> getDuoTone() {
        if (this.blip.sizeOfDuotoneArray() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CTSchemeColor cTSchemeColor : this.blip.getDuotoneArray(0).getSchemeClrArray()) {
            arrayList.add(new XSLFColor(cTSchemeColor, this.theme, this.phClr, this.sheet).getColorStyle());
        }
        return arrayList;
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public PaintStyle.FlipMode getFlipMode() {
        CTTileInfoProperties tile = this.blipFill.getTile();
        int iIntValue = (tile == null || tile.getFlip() == null) ? 1 : tile.getFlip().intValue();
        if (iIntValue == 2) {
            return PaintStyle.FlipMode.X;
        }
        if (iIntValue != 3) {
            return iIntValue != 4 ? PaintStyle.FlipMode.NONE : PaintStyle.FlipMode.XY;
        }
        return PaintStyle.FlipMode.Y;
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public InputStream getImageData() {
        try {
            return getPart().getInputStream();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read image data", e);
        }
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public Insets2D getInsets() {
        return getRectVal(this.blipFill.getSrcRect());
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public Point2D getOffset() {
        CTTileInfoProperties tile = this.blipFill.getTile();
        if (tile == null) {
            return null;
        }
        return new Point2D.Double(tile.isSetTx() ? Units.toPoints(POIXMLUnits.parseLength(tile.xgetTx())) : 0.0d, tile.isSetTy() ? Units.toPoints(POIXMLUnits.parseLength(tile.xgetTy())) : 0.0d);
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public Dimension2D getScale() {
        CTTileInfoProperties tile = this.blipFill.getTile();
        if (tile == null) {
            return null;
        }
        return new Dimension2DDouble(tile.isSetSx() ? ((double) POIXMLUnits.parsePercent(tile.xgetSx())) / 100000.0d : 1.0d, tile.isSetSy() ? ((double) POIXMLUnits.parsePercent(tile.xgetSy())) / 100000.0d : 1.0d);
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public Insets2D getStretch() {
        return getRectVal(this.blipFill.isSetStretch() ? this.blipFill.getStretch().getFillRect() : null);
    }

    @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
    public boolean isRotatedWithShape() {
        return !this.blipFill.isSetRotWithShape() || this.blipFill.getRotWithShape();
    }

    private static int getRectVal(Supplier<Boolean> supplier, Supplier<STPercentage> supplier2) {
        if (supplier.get().booleanValue()) {
            return POIXMLUnits.parsePercent(supplier2.get());
        }
        return 0;
    }
}
