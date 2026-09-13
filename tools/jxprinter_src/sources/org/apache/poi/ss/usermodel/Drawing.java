package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.usermodel.Shape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Drawing<T extends Shape> extends ShapeContainer<T> {
    ClientAnchor createAnchor(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    Comment createCellComment(ClientAnchor clientAnchor);

    ObjectData createObjectData(ClientAnchor clientAnchor, int i5, int i6);

    Picture createPicture(ClientAnchor clientAnchor, int i5);
}
