package org.apache.poi.ss.usermodel;

import org.apache.poi.poifs.filesystem.DirectoryNode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements WorkbookFactory.ProviderMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7234a;
    public final /* synthetic */ DirectoryNode b;
    public final /* synthetic */ String c;

    public /* synthetic */ f(DirectoryNode directoryNode, String str, int i5) {
        this.f7234a = i5;
        this.b = directoryNode;
        this.c = str;
    }

    @Override // org.apache.poi.ss.usermodel.WorkbookFactory.ProviderMethod
    public final Workbook create(WorkbookProvider workbookProvider) {
        switch (this.f7234a) {
            case 0:
                return WorkbookFactory.lambda$create$0(this.b, this.c, workbookProvider);
            case 1:
                return WorkbookFactory.lambda$create$1(this.b, this.c, workbookProvider);
            default:
                return WorkbookFactory.lambda$create$3(this.b, this.c, workbookProvider);
        }
    }
}
