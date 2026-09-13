package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Header extends HeaderFooter {
    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getCenter();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getLeft();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    String getRight();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setCenter(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setLeft(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    void setRight(String str);
}
