package org.apache.poi.ss.usermodel;

import java.awt.Dimension;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Picture extends Shape {
    ClientAnchor getClientAnchor();

    Dimension getImageDimension();

    PictureData getPictureData();

    ClientAnchor getPreferredSize();

    ClientAnchor getPreferredSize(double d, double d6);

    Sheet getSheet();

    void resize();

    void resize(double d);

    void resize(double d, double d6);
}
