package org.apache.poi.extractor;

import org.apache.poi.poifs.filesystem.DirectoryNode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements ExtractorFactory.ProviderMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6979a;
    public final /* synthetic */ DirectoryNode b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(DirectoryNode directoryNode, String str, int i5) {
        this.f6979a = i5;
        this.b = directoryNode;
        this.c = str;
    }

    @Override // org.apache.poi.extractor.ExtractorFactory.ProviderMethod
    public final POITextExtractor create(ExtractorProvider extractorProvider) {
        switch (this.f6979a) {
            case 0:
                return ExtractorFactory.lambda$createExtractor$2(this.b, this.c, extractorProvider);
            case 1:
                return ExtractorFactory.lambda$createExtractor$5(this.b, this.c, extractorProvider);
            case 2:
                return ExtractorFactory.lambda$createExtractor$6(this.b, this.c, extractorProvider);
            default:
                return ExtractorFactory.lambda$createExtractor$4(this.b, this.c, extractorProvider);
        }
    }
}
