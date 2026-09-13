package org.apache.poi.hssf.usermodel;

import java.util.List;
import org.apache.poi.ss.usermodel.ShapeContainer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface HSSFShapeContainer extends ShapeContainer<HSSFShape> {
    void addShape(HSSFShape hSSFShape);

    void clear();

    List<HSSFShape> getChildren();

    int getX1();

    int getX2();

    int getY1();

    int getY2();

    boolean removeShape(HSSFShape hSSFShape);

    void setCoordinates(int i5, int i6, int i7, int i8);
}
