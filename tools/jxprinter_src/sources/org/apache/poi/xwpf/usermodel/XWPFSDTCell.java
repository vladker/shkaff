package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFSDTCell extends XWPFAbstractSDT implements ICell {
    private final XWPFSDTContentCell cellContent;

    public XWPFSDTCell(CTSdtCell cTSdtCell, XWPFTableRow xWPFTableRow, IBody iBody) {
        super(cTSdtCell.getSdtPr(), iBody);
        this.cellContent = new XWPFSDTContentCell(cTSdtCell.getSdtContent(), xWPFTableRow, iBody);
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFAbstractSDT
    public ISDTContent getContent() {
        return this.cellContent;
    }
}
