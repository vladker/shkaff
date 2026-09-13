package org.apache.poi.xslf.draw.geom;

import java.awt.geom.Path2D;
import org.apache.poi.sl.draw.geom.ClosePathCommand;
import org.apache.poi.sl.draw.geom.Context;
import org.apache.poi.sl.draw.geom.PathCommand;
import org.apache.poi.sl.draw.geom.PathIf;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFPath implements PathIf {
    private final CTPath2D pathXml;

    /* JADX INFO: renamed from: org.apache.poi.xslf.draw.geom.XSLFPath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier;

        static {
            int[] iArr = new int[PaintStyle.PaintModifier.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier = iArr;
            try {
                iArr[PaintStyle.PaintModifier.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.NORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.LIGHTEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.LIGHTEN_LESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.DARKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.DARKEN_LESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public XSLFPath(CTPath2D cTPath2D) {
        this.pathXml = cTPath2D;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public PaintStyle.PaintModifier getFill() {
        int iIntValue = this.pathXml.getFill().intValue();
        if (iIntValue == 2) {
            return PaintStyle.PaintModifier.NORM;
        }
        if (iIntValue == 3) {
            return PaintStyle.PaintModifier.LIGHTEN;
        }
        if (iIntValue == 4) {
            return PaintStyle.PaintModifier.LIGHTEN_LESS;
        }
        if (iIntValue != 5) {
            return iIntValue != 6 ? PaintStyle.PaintModifier.NONE : PaintStyle.PaintModifier.DARKEN_LESS;
        }
        return PaintStyle.PaintModifier.DARKEN;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public long getH() {
        return this.pathXml.getH();
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public Path2D.Double getPath(Context context) {
        PathCommand closePathCommand;
        Path2D.Double r6 = new Path2D.Double();
        XmlCursor xmlCursorNewCursor = this.pathXml.newCursor();
        try {
            for (boolean firstChild = xmlCursorNewCursor.toFirstChild(); firstChild; firstChild = xmlCursorNewCursor.toNextSibling()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTPath2DArcTo) {
                    closePathCommand = new XSLFArcTo((CTPath2DArcTo) object);
                } else if (object instanceof CTPath2DCubicBezierTo) {
                    closePathCommand = new XSLFCurveTo((CTPath2DCubicBezierTo) object);
                } else if (object instanceof CTPath2DMoveTo) {
                    closePathCommand = new XSLFMoveTo((CTPath2DMoveTo) object);
                } else if (object instanceof CTPath2DLineTo) {
                    closePathCommand = new XSLFLineTo((CTPath2DLineTo) object);
                } else if (object instanceof CTPath2DQuadBezierTo) {
                    closePathCommand = new XSLFQuadTo((CTPath2DQuadBezierTo) object);
                } else {
                    if (object instanceof CTPath2DClose) {
                        closePathCommand = new ClosePathCommand();
                    }
                }
                closePathCommand.execute(r6, context);
            }
            xmlCursorNewCursor.close();
            return r6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public long getW() {
        return this.pathXml.getW();
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public boolean isExtrusionOk() {
        return this.pathXml.getExtrusionOk();
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public boolean isFilled() {
        return this.pathXml.getFill() != STPathFillMode.NONE;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public boolean isStroked() {
        return this.pathXml.getStroke();
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setExtrusionOk(boolean z6) {
        this.pathXml.setExtrusionOk(z6);
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setFill(PaintStyle.PaintModifier paintModifier) {
        STPathFillMode.Enum r6;
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[paintModifier.ordinal()];
        if (i5 == 2) {
            r6 = STPathFillMode.NORM;
        } else if (i5 == 3) {
            r6 = STPathFillMode.LIGHTEN;
        } else if (i5 == 4) {
            r6 = STPathFillMode.LIGHTEN_LESS;
        } else if (i5 != 5) {
            r6 = i5 != 6 ? STPathFillMode.NONE : STPathFillMode.DARKEN_LESS;
        } else {
            r6 = STPathFillMode.DARKEN;
        }
        this.pathXml.setFill(r6);
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setH(long j6) {
        this.pathXml.setH(j6);
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setStroke(boolean z6) {
        this.pathXml.setStroke(z6);
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setW(long j6) {
        this.pathXml.setW(j6);
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void addCommand(PathCommand pathCommand) {
    }
}
