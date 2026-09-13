package org.apache.poi.xslf.usermodel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSLFPropertiesDelegate {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFPropertiesDelegate.class);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BackgroundDelegate implements XSLFFillProperties, XSLFEffectProperties {
        final CTBackgroundProperties props;

        public BackgroundDelegate(CTBackgroundProperties cTBackgroundProperties) {
            this.props = cTBackgroundProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer addNewEffectDag() {
            return this.props.addNewEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList addNewEffectLst() {
            return this.props.addNewEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer getEffectDag() {
            return this.props.getEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList getEffectLst() {
            return this.props.getEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectDag() {
            return this.props.isSetEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectLst() {
            return this.props.isSetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectDag(CTEffectContainer cTEffectContainer) {
            this.props.setEffectDag(cTEffectContainer);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectLst(CTEffectList cTEffectList) {
            this.props.setEffectLst(cTEffectList);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectDag() {
            this.props.unsetEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectLst() {
            this.props.unsetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FillDelegate implements XSLFFillProperties {
        final CTFillProperties props;

        public FillDelegate(CTFillProperties cTFillProperties) {
            this.props = cTFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ShapeDelegate implements XSLFFillProperties, XSLFGeometryProperties, XSLFEffectProperties {
        final CTShapeProperties props;

        public ShapeDelegate(CTShapeProperties cTShapeProperties) {
            this.props = cTShapeProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTCustomGeometry2D addNewCustGeom() {
            return this.props.addNewCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer addNewEffectDag() {
            return this.props.addNewEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList addNewEffectLst() {
            return this.props.addNewEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTPresetGeometry2D addNewPrstGeom() {
            return this.props.addNewPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTCustomGeometry2D getCustGeom() {
            return this.props.getCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectContainer getEffectDag() {
            return this.props.getEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public CTEffectList getEffectLst() {
            return this.props.getEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public CTPresetGeometry2D getPrstGeom() {
            return this.props.getPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public boolean isSetCustGeom() {
            return this.props.isSetCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectDag() {
            return this.props.isSetEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public boolean isSetEffectLst() {
            return this.props.isSetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public boolean isSetPrstGeom() {
            return this.props.isSetPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void setCustGeom(CTCustomGeometry2D cTCustomGeometry2D) {
            this.props.setCustGeom(cTCustomGeometry2D);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectDag(CTEffectContainer cTEffectContainer) {
            this.props.setEffectDag(cTEffectContainer);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void setEffectLst(CTEffectList cTEffectList) {
            this.props.setEffectLst(cTEffectList);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void setPrstGeom(CTPresetGeometry2D cTPresetGeometry2D) {
            this.props.setPrstGeom(cTPresetGeometry2D);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void unsetCustGeom() {
            this.props.unsetCustGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectDag() {
            this.props.unsetEffectDag();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFEffectProperties
        public void unsetEffectLst() {
            this.props.unsetEffectLst();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFGeometryProperties
        public void unsetPrstGeom() {
            this.props.unsetPrstGeom();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TableCellDelegate implements XSLFFillProperties {
        final CTTableCellProperties props;

        public TableCellDelegate(CTTableCellProperties cTTableCellProperties) {
            this.props = cTTableCellProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TextCharDelegate implements XSLFFillProperties {
        final CTTextCharacterProperties props;

        public TextCharDelegate(CTTextCharacterProperties cTTextCharacterProperties) {
            this.props = cTTextCharacterProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return this.props.addNewBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return this.props.addNewGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return this.props.getBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return this.props.getGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props.isSetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props.isSetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
            this.props.setBlipFill(cTBlipFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
            this.props.setGrpFill(cTGroupFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
            this.props.unsetBlipFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
            this.props.unsetGrpFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface XSLFEffectProperties {
        CTEffectContainer addNewEffectDag();

        CTEffectList addNewEffectLst();

        CTEffectContainer getEffectDag();

        CTEffectList getEffectLst();

        boolean isSetEffectDag();

        boolean isSetEffectLst();

        void setEffectDag(CTEffectContainer cTEffectContainer);

        void setEffectLst(CTEffectList cTEffectList);

        void unsetEffectDag();

        void unsetEffectLst();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface XSLFFillProperties {
        CTBlipFillProperties addNewBlipFill();

        CTGradientFillProperties addNewGradFill();

        CTGroupFillProperties addNewGrpFill();

        CTNoFillProperties addNewNoFill();

        CTPatternFillProperties addNewPattFill();

        CTSolidColorFillProperties addNewSolidFill();

        CTBlipFillProperties getBlipFill();

        CTGradientFillProperties getGradFill();

        CTGroupFillProperties getGrpFill();

        CTStyleMatrixReference getMatrixStyle();

        CTNoFillProperties getNoFill();

        CTPatternFillProperties getPattFill();

        CTSolidColorFillProperties getSolidFill();

        boolean isLineStyle();

        boolean isSetBlipFill();

        boolean isSetGradFill();

        boolean isSetGrpFill();

        boolean isSetMatrixStyle();

        boolean isSetNoFill();

        boolean isSetPattFill();

        boolean isSetSolidFill();

        void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

        void setGradFill(CTGradientFillProperties cTGradientFillProperties);

        void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

        void setNoFill(CTNoFillProperties cTNoFillProperties);

        void setPattFill(CTPatternFillProperties cTPatternFillProperties);

        void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

        void unsetBlipFill();

        void unsetGradFill();

        void unsetGrpFill();

        void unsetNoFill();

        void unsetPattFill();

        void unsetSolidFill();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface XSLFGeometryProperties {
        CTCustomGeometry2D addNewCustGeom();

        CTPresetGeometry2D addNewPrstGeom();

        CTCustomGeometry2D getCustGeom();

        CTPresetGeometry2D getPrstGeom();

        boolean isSetCustGeom();

        boolean isSetPrstGeom();

        void setCustGeom(CTCustomGeometry2D cTCustomGeometry2D);

        void setPrstGeom(CTPresetGeometry2D cTPresetGeometry2D);

        void unsetCustGeom();

        void unsetPrstGeom();
    }

    private static <T> T getDelegate(Class<T> cls, XmlObject xmlObject) {
        T t6;
        if (xmlObject == null) {
            return null;
        }
        if (xmlObject instanceof CTShapeProperties) {
            t6 = (T) new ShapeDelegate((CTShapeProperties) xmlObject);
        } else if (xmlObject instanceof CTBackgroundProperties) {
            t6 = (T) new BackgroundDelegate((CTBackgroundProperties) xmlObject);
        } else if (xmlObject instanceof CTStyleMatrixReference) {
            t6 = (T) new StyleMatrixDelegate((CTStyleMatrixReference) xmlObject);
        } else if (xmlObject instanceof CTTableCellProperties) {
            t6 = (T) new TableCellDelegate((CTTableCellProperties) xmlObject);
        } else if ((xmlObject instanceof CTNoFillProperties) || (xmlObject instanceof CTSolidColorFillProperties) || (xmlObject instanceof CTGradientFillProperties) || (xmlObject instanceof CTBlipFillProperties) || (xmlObject instanceof CTPatternFillProperties) || (xmlObject instanceof CTGroupFillProperties)) {
            t6 = (T) new FillPartDelegate(xmlObject);
        } else if (xmlObject instanceof CTFillProperties) {
            t6 = (T) new FillDelegate((CTFillProperties) xmlObject);
        } else if (xmlObject instanceof CTLineProperties) {
            t6 = (T) new LineStyleDelegate((CTLineProperties) xmlObject);
        } else {
            if (!(xmlObject instanceof CTTextCharacterProperties)) {
                LOG.atError().log("{} is an unknown properties type", xmlObject.getClass());
                return null;
            }
            t6 = (T) new TextCharDelegate((CTTextCharacterProperties) xmlObject);
        }
        if (cls.isInstance(t6)) {
            return t6;
        }
        LOG.atWarn().log("{} doesn't implement {}", t6.getClass(), cls);
        return null;
    }

    public static XSLFEffectProperties getEffectDelegate(XmlObject xmlObject) {
        return (XSLFEffectProperties) getDelegate(XSLFEffectProperties.class, xmlObject);
    }

    public static XSLFFillProperties getFillDelegate(XmlObject xmlObject) {
        return (XSLFFillProperties) getDelegate(XSLFFillProperties.class, xmlObject);
    }

    public static XSLFGeometryProperties getGeometryDelegate(XmlObject xmlObject) {
        return (XSLFGeometryProperties) getDelegate(XSLFGeometryProperties.class, xmlObject);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FillPartDelegate implements XSLFFillProperties {
        final XmlObject props;

        public FillPartDelegate(XmlObject xmlObject) {
            this.props = xmlObject;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            if (isSetBlipFill()) {
                return (CTBlipFillProperties) this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            if (isSetGradFill()) {
                return (CTGradientFillProperties) this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            if (isSetGrpFill()) {
                return (CTGroupFillProperties) this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            if (isSetNoFill()) {
                return (CTNoFillProperties) this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            if (isSetPattFill()) {
                return (CTPatternFillProperties) this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            if (isSetSolidFill()) {
                return (CTSolidColorFillProperties) this.props;
            }
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return this.props instanceof CTBlipFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props instanceof CTGradientFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return this.props instanceof CTGroupFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props instanceof CTNoFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props instanceof CTPatternFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props instanceof CTSolidColorFillProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LineStyleDelegate implements XSLFFillProperties {
        final CTLineProperties props;

        public LineStyleDelegate(CTLineProperties cTLineProperties) {
            this.props = cTLineProperties;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return this.props.addNewGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return this.props.addNewNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return this.props.addNewPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return this.props.addNewSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return this.props.getGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return this.props.getNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return this.props.getPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return this.props.getSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            return true;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return this.props.isSetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return this.props.isSetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return this.props.isSetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return this.props.isSetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
            this.props.setGradFill(cTGradientFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
            this.props.setNoFill(cTNoFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
            this.props.setPattFill(cTPatternFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
            this.props.setSolidFill(cTSolidColorFillProperties);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
            this.props.unsetGradFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
            this.props.unsetNoFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
            this.props.unsetPattFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
            this.props.unsetSolidFill();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StyleMatrixDelegate implements XSLFFillProperties {
        final CTStyleMatrixReference props;

        public StyleMatrixDelegate(CTStyleMatrixReference cTStyleMatrixReference) {
            this.props = cTStyleMatrixReference;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties addNewBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties addNewGradFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties addNewGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties addNewNoFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties addNewPattFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties addNewSolidFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTBlipFillProperties getBlipFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGradientFillProperties getGradFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTGroupFillProperties getGrpFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTStyleMatrixReference getMatrixStyle() {
            return this.props;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTNoFillProperties getNoFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTPatternFillProperties getPattFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public CTSolidColorFillProperties getSolidFill() {
            return null;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isLineStyle() {
            XmlCursor xmlCursorNewCursor = this.props.newCursor();
            try {
                boolean zEquals = "lnRef".equals(xmlCursorNewCursor.getName().getLocalPart());
                xmlCursorNewCursor.close();
                return zEquals;
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

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetBlipFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGradFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetGrpFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetMatrixStyle() {
            return true;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetNoFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetPattFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public boolean isSetSolidFill() {
            return false;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetBlipFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGradFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetGrpFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetNoFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetPattFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void unsetSolidFill() {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate.XSLFFillProperties
        public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        }
    }
}
