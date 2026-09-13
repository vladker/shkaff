package org.apache.poi.xslf.usermodel;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.ShapeContainer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface XSLFShapeContainer extends ShapeContainer<XSLFShape, XSLFTextParagraph> {
    void clear();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFAutoShape createAutoShape();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFConnectorShape createConnector();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFFreeformShape createFreeform();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFGroupShape createGroup();

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFPictureShape createPicture(PictureData pictureData);

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    XSLFTextBox createTextBox();
}
