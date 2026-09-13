package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFSDT extends XWPFAbstractSDT implements IBodyElement, IRunBody, ISDTContents, IRunElement {
    private final ISDTContent content;

    public XWPFSDT(CTSdtRun cTSdtRun, IBody iBody) {
        super(cTSdtRun.getSdtPr(), iBody);
        this.content = new XWPFSDTContent(cTSdtRun.getSdtContent(), iBody, this);
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFAbstractSDT
    public ISDTContent getContent() {
        return this.content;
    }

    public XWPFSDT(CTSdtBlock cTSdtBlock, IBody iBody) {
        super(cTSdtBlock.getSdtPr(), iBody);
        this.content = new XWPFSDTContent(cTSdtBlock.getSdtContent(), iBody, this);
    }
}
