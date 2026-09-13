package org.apache.poi.sl.usermodel;

import java.awt.geom.Point2D;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Comment {
    String getAuthor();

    String getAuthorInitials();

    Date getDate();

    Point2D getOffset();

    String getText();

    void setAuthor(String str);

    void setAuthorInitials(String str);

    void setDate(Date date);

    void setOffset(Point2D point2D);

    void setText(String str);
}
