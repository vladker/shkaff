package org.apache.poi.poifs.crypt.dsig;

import java.util.function.Supplier;
import org.apache.poi.poifs.crypt.dsig.facets.KeyInfoSignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.OOXMLSignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.Office2010SignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.XAdESSignatureFacet;
import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7147a;

    public /* synthetic */ b(int i5) {
        this.f7147a = i5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7147a) {
            case 0:
                return new OOXMLSignatureFacet();
            case 1:
                return new KeyInfoSignatureFacet();
            case 2:
                return new XAdESSignatureFacet();
            case 3:
                return new Office2010SignatureFacet();
            case 4:
                return TSPTimeStampService.lambda$timeStamp$2();
            default:
                return FormulaError.REF;
        }
    }
}
