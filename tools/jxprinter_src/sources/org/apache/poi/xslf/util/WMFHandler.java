package org.apache.poi.xslf.util;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class WMFHandler extends EMFHandler {
    @Override // org.apache.poi.xslf.util.EMFHandler
    public String getContentType() {
        return PictureData.PictureType.WMF.contentType;
    }
}
