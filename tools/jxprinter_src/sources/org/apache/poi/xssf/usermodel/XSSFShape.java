package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Shape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XSSFShape implements Shape {
    protected XSSFAnchor anchor;
    protected XSSFDrawing drawing;
    protected XSSFShapeGroup parent;

    public XSSFDrawing getDrawing() {
        return this.drawing;
    }

    public abstract CTShapeProperties getShapeProperties();

    @Override // org.apache.poi.ss.usermodel.Shape
    public boolean isNoFill() {
        return getShapeProperties().isSetNoFill();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setFillColor(int i5, int i6, int i7) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTSolidColorFillProperties solidFill = shapeProperties.isSetSolidFill() ? shapeProperties.getSolidFill() : shapeProperties.addNewSolidFill();
        CTSRgbColor cTSRgbColorNewInstance = CTSRgbColor.Factory.newInstance();
        cTSRgbColorNewInstance.setVal(new byte[]{(byte) i5, (byte) i6, (byte) i7});
        solidFill.setSrgbClr(cTSRgbColorNewInstance);
    }

    public void setLineStyle(int i5) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTLineProperties ln = shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn();
        CTPresetLineDashProperties cTPresetLineDashPropertiesNewInstance = CTPresetLineDashProperties.Factory.newInstance();
        cTPresetLineDashPropertiesNewInstance.setVal(STPresetLineDashVal.Enum.forInt(i5 + 1));
        ln.setPrstDash(cTPresetLineDashPropertiesNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setLineStyleColor(int i5, int i6, int i7) {
        CTShapeProperties shapeProperties = getShapeProperties();
        CTLineProperties ln = shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn();
        CTSolidColorFillProperties solidFill = ln.isSetSolidFill() ? ln.getSolidFill() : ln.addNewSolidFill();
        CTSRgbColor cTSRgbColorNewInstance = CTSRgbColor.Factory.newInstance();
        cTSRgbColorNewInstance.setVal(new byte[]{(byte) i5, (byte) i6, (byte) i7});
        solidFill.setSrgbClr(cTSRgbColorNewInstance);
    }

    public void setLineWidth(double d) {
        CTShapeProperties shapeProperties = getShapeProperties();
        (shapeProperties.isSetLn() ? shapeProperties.getLn() : shapeProperties.addNewLn()).setW((int) (d * 12700.0d));
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setNoFill(boolean z6) {
        CTShapeProperties shapeProperties = getShapeProperties();
        if (shapeProperties.isSetPattFill()) {
            shapeProperties.unsetPattFill();
        }
        if (shapeProperties.isSetSolidFill()) {
            shapeProperties.unsetSolidFill();
        }
        shapeProperties.setNoFill(CTNoFillProperties.Factory.newInstance());
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public XSSFAnchor getAnchor() {
        return this.anchor;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public XSSFShapeGroup getParent() {
        return this.parent;
    }
}
