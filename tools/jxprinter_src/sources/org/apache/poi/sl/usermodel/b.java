package org.apache.poi.sl.usermodel;

import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements SlideShowFactory.ProviderMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7190a;
    public final /* synthetic */ POIFSViewable b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(POIFSViewable pOIFSViewable, String str, int i5) {
        this.f7190a = i5;
        this.b = pOIFSViewable;
        this.c = str;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShowFactory.ProviderMethod
    public final SlideShow create(SlideShowProvider slideShowProvider) {
        switch (this.f7190a) {
            case 0:
                return SlideShowFactory.lambda$create$0((DirectoryNode) this.b, this.c, slideShowProvider);
            case 1:
                return SlideShowFactory.lambda$create$1((DirectoryNode) this.b, this.c, slideShowProvider);
            default:
                return SlideShowFactory.lambda$create$3((POIFSFileSystem) this.b, this.c, slideShowProvider);
        }
    }
}
