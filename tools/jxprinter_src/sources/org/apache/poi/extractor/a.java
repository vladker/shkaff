package org.apache.poi.extractor;

import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements ExtractorFactory.ProviderMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6978a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i5, String str, Object obj) {
        this.f6978a = i5;
        this.c = obj;
        this.b = str;
    }

    @Override // org.apache.poi.extractor.ExtractorFactory.ProviderMethod
    public final POITextExtractor create(ExtractorProvider extractorProvider) {
        switch (this.f6978a) {
            case 0:
                return ExtractorFactory.lambda$createExtractor$1((InputStream) this.c, this.b, extractorProvider);
            default:
                return ExtractorFactory.lambda$createExtractor$3((File) this.c, this.b, extractorProvider);
        }
    }
}
