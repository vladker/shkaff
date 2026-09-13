package org.apache.poi.sl.usermodel;

import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ShapeContainer<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Iterable<S> {
    void addShape(S s6);

    AutoShape<S, P> createAutoShape();

    ConnectorShape<S, P> createConnector();

    FreeformShape<S, P> createFreeform();

    GroupShape<S, P> createGroup();

    ObjectShape<?, ?> createOleShape(PictureData pictureData);

    PictureShape<S, P> createPicture(PictureData pictureData);

    TableShape<S, P> createTable(int i5, int i6);

    TextBox<S, P> createTextBox();

    List<S> getShapes();

    boolean removeShape(S s6);
}
