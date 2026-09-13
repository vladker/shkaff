package org.apache.poi.xssf.usermodel;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7344a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(int i5, int i6) {
        this.f7344a = i6;
        this.b = i5;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        XSSFComment xSSFComment = (XSSFComment) obj;
        XSSFComment xSSFComment2 = (XSSFComment) obj2;
        switch (this.f7344a) {
            case 0:
                return XSSFSheet.lambda$shiftCommentsForColumns$1(this.b, xSSFComment, xSSFComment2);
            default:
                return XSSFSheet.lambda$shiftCommentsAndRows$0(this.b, xSSFComment, xSSFComment2);
        }
    }
}
