package org.apache.poi.ss.usermodel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CreationHelper {
    AreaReference createAreaReference(String str);

    AreaReference createAreaReference(CellReference cellReference, CellReference cellReference2);

    ClientAnchor createClientAnchor();

    DataFormat createDataFormat();

    ExtendedColor createExtendedColor();

    FormulaEvaluator createFormulaEvaluator();

    Hyperlink createHyperlink(HyperlinkType hyperlinkType);

    RichTextString createRichTextString(String str);
}
