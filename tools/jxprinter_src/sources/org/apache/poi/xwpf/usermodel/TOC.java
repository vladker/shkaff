package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.nio.charset.Charset;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TOC {
    CTSdtBlock block;

    public TOC() {
        this(CTSdtBlock.Factory.newInstance());
    }

    public void addRow(int i5, String str, int i6, String str2) {
        CTP ctpAddNewP = this.block.getSdtContent().addNewP();
        Charset charset = LocaleUtil.CHARSET_1252;
        ctpAddNewP.setRsidR("00EF7E24".getBytes(charset));
        ctpAddNewP.setRsidRDefault("00EF7E24".getBytes(charset));
        CTPPr cTPPrAddNewPPr = ctpAddNewP.addNewPPr();
        cTPPrAddNewPPr.addNewPStyle().setVal("TOC" + i5);
        CTTabStop cTTabStopAddNewTab = cTPPrAddNewPPr.addNewTabs().addNewTab();
        cTTabStopAddNewTab.setVal(STTabJc.RIGHT);
        cTTabStopAddNewTab.setLeader(STTabTlc.DOT);
        cTTabStopAddNewTab.setPos(BigInteger.valueOf(8290L));
        cTPPrAddNewPPr.addNewRPr().addNewNoProof();
        CTR ctrAddNewR = ctpAddNewP.addNewR();
        ctrAddNewR.addNewRPr().addNewNoProof();
        ctrAddNewR.addNewT().setStringValue(str);
        CTR ctrAddNewR2 = ctpAddNewP.addNewR();
        ctrAddNewR2.addNewRPr().addNewNoProof();
        ctrAddNewR2.addNewTab();
        CTR ctrAddNewR3 = ctpAddNewP.addNewR();
        ctrAddNewR3.addNewRPr().addNewNoProof();
        ctrAddNewR3.addNewFldChar().setFldCharType(STFldCharType.BEGIN);
        CTR ctrAddNewR4 = ctpAddNewP.addNewR();
        ctrAddNewR4.addNewRPr().addNewNoProof();
        CTText cTTextAddNewInstrText = ctrAddNewR4.addNewInstrText();
        cTTextAddNewInstrText.setSpace(SpaceAttribute.Space.PRESERVE);
        cTTextAddNewInstrText.setStringValue(" PAGEREF _Toc" + str2 + " \\h ");
        ctpAddNewP.addNewR().addNewRPr().addNewNoProof();
        CTR ctrAddNewR5 = ctpAddNewP.addNewR();
        ctrAddNewR5.addNewRPr().addNewNoProof();
        ctrAddNewR5.addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
        CTR ctrAddNewR6 = ctpAddNewP.addNewR();
        ctrAddNewR6.addNewRPr().addNewNoProof();
        ctrAddNewR6.addNewT().setStringValue(Integer.toString(i6));
        CTR ctrAddNewR7 = ctpAddNewP.addNewR();
        ctrAddNewR7.addNewRPr().addNewNoProof();
        ctrAddNewR7.addNewFldChar().setFldCharType(STFldCharType.END);
    }

    @Internal
    public CTSdtBlock getBlock() {
        return this.block;
    }

    public TOC(CTSdtBlock cTSdtBlock) {
        this.block = cTSdtBlock;
        CTSdtPr cTSdtPrAddNewSdtPr = cTSdtBlock.addNewSdtPr();
        cTSdtPrAddNewSdtPr.addNewId().setVal(BigInteger.valueOf(4844945L));
        cTSdtPrAddNewSdtPr.addNewDocPartObj().addNewDocPartGallery().setVal("Table of contents");
        CTRPr cTRPrAddNewRPr = cTSdtBlock.addNewSdtEndPr().addNewRPr();
        CTFonts cTFontsAddNewRFonts = cTRPrAddNewRPr.addNewRFonts();
        STTheme.Enum r6 = STTheme.MINOR_H_ANSI;
        cTFontsAddNewRFonts.setAsciiTheme(r6);
        cTFontsAddNewRFonts.setEastAsiaTheme(r6);
        cTFontsAddNewRFonts.setHAnsiTheme(r6);
        cTFontsAddNewRFonts.setCstheme(STTheme.MINOR_BIDI);
        CTOnOff cTOnOffAddNewB = cTRPrAddNewRPr.addNewB();
        STOnOff1.Enum r7 = STOnOff1.OFF;
        cTOnOffAddNewB.setVal(r7);
        cTRPrAddNewRPr.addNewBCs().setVal(r7);
        cTRPrAddNewRPr.addNewColor().setVal("auto");
        cTRPrAddNewRPr.addNewSz().setVal(BigInteger.valueOf(24L));
        cTRPrAddNewRPr.addNewSzCs().setVal(BigInteger.valueOf(24L));
        CTP ctpAddNewP = cTSdtBlock.addNewSdtContent().addNewP();
        Charset charset = LocaleUtil.CHARSET_1252;
        ctpAddNewP.setRsidR("00EF7E24".getBytes(charset));
        ctpAddNewP.setRsidRDefault("00EF7E24".getBytes(charset));
        ctpAddNewP.addNewPPr().addNewPStyle().setVal("TOCHeading");
        ctpAddNewP.addNewR().addNewT().setStringValue("Table of Contents");
    }
}
