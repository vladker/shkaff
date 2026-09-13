package com.microsoft.schemas.office.excel.impl;

import androidx.webkit.Profile;
import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.excel.STCF;
import com.microsoft.schemas.office.excel.STObjectType;
import java.math.BigInteger;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.xwpf.usermodel.c;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;
import p099r2.a;
import p099r2.b;
import p099r2.d;
import p099r2.e;
import p099r2.f;
import p099r2.g;
import p099r2.h;
import p099r2.i;
import p099r2.j;
import p099r2.k;
import p099r2.l;
import p099r2.m;
import p099r2.n;
import p099r2.o;
import p099r2.p;
import p099r2.q;
import p099r2.r;
import p099r2.s;
import p099r2.t;
import p099r2.u;
import p099r2.v;
import p099r2.w;
import p099r2.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTClientDataImpl extends XmlComplexContentImpl implements CTClientData {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:office:excel", "MoveWithCells"), new QName("urn:schemas-microsoft-com:office:excel", "SizeWithCells"), new QName("urn:schemas-microsoft-com:office:excel", "Anchor"), new QName("urn:schemas-microsoft-com:office:excel", "Locked"), new QName("urn:schemas-microsoft-com:office:excel", "DefaultSize"), new QName("urn:schemas-microsoft-com:office:excel", "PrintObject"), new QName("urn:schemas-microsoft-com:office:excel", "Disabled"), new QName("urn:schemas-microsoft-com:office:excel", "AutoFill"), new QName("urn:schemas-microsoft-com:office:excel", "AutoLine"), new QName("urn:schemas-microsoft-com:office:excel", "AutoPict"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaMacro"), new QName("urn:schemas-microsoft-com:office:excel", "TextHAlign"), new QName("urn:schemas-microsoft-com:office:excel", "TextVAlign"), new QName("urn:schemas-microsoft-com:office:excel", "LockText"), new QName("urn:schemas-microsoft-com:office:excel", "JustLastX"), new QName("urn:schemas-microsoft-com:office:excel", "SecretEdit"), new QName("urn:schemas-microsoft-com:office:excel", Profile.DEFAULT_PROFILE_NAME), new QName("urn:schemas-microsoft-com:office:excel", "Help"), new QName("urn:schemas-microsoft-com:office:excel", "Cancel"), new QName("urn:schemas-microsoft-com:office:excel", "Dismiss"), new QName("urn:schemas-microsoft-com:office:excel", "Accel"), new QName("urn:schemas-microsoft-com:office:excel", "Accel2"), new QName("urn:schemas-microsoft-com:office:excel", "Row"), new QName("urn:schemas-microsoft-com:office:excel", "Column"), new QName("urn:schemas-microsoft-com:office:excel", "Visible"), new QName("urn:schemas-microsoft-com:office:excel", "RowHidden"), new QName("urn:schemas-microsoft-com:office:excel", "ColHidden"), new QName("urn:schemas-microsoft-com:office:excel", "VTEdit"), new QName("urn:schemas-microsoft-com:office:excel", "MultiLine"), new QName("urn:schemas-microsoft-com:office:excel", "VScroll"), new QName("urn:schemas-microsoft-com:office:excel", "ValidIds"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaRange"), new QName("urn:schemas-microsoft-com:office:excel", "WidthMin"), new QName("urn:schemas-microsoft-com:office:excel", "Sel"), new QName("urn:schemas-microsoft-com:office:excel", "NoThreeD2"), new QName("urn:schemas-microsoft-com:office:excel", "SelType"), new QName("urn:schemas-microsoft-com:office:excel", "MultiSel"), new QName("urn:schemas-microsoft-com:office:excel", "LCT"), new QName("urn:schemas-microsoft-com:office:excel", "ListItem"), new QName("urn:schemas-microsoft-com:office:excel", "DropStyle"), new QName("urn:schemas-microsoft-com:office:excel", "Colored"), new QName("urn:schemas-microsoft-com:office:excel", "DropLines"), new QName("urn:schemas-microsoft-com:office:excel", "Checked"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaLink"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaPict"), new QName("urn:schemas-microsoft-com:office:excel", "NoThreeD"), new QName("urn:schemas-microsoft-com:office:excel", "FirstButton"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaGroup"), new QName("urn:schemas-microsoft-com:office:excel", "Val"), new QName("urn:schemas-microsoft-com:office:excel", "Min"), new QName("urn:schemas-microsoft-com:office:excel", "Max"), new QName("urn:schemas-microsoft-com:office:excel", "Inc"), new QName("urn:schemas-microsoft-com:office:excel", "Page"), new QName("urn:schemas-microsoft-com:office:excel", "Horiz"), new QName("urn:schemas-microsoft-com:office:excel", "Dx"), new QName("urn:schemas-microsoft-com:office:excel", "MapOCX"), new QName("urn:schemas-microsoft-com:office:excel", "CF"), new QName("urn:schemas-microsoft-com:office:excel", "Camera"), new QName("urn:schemas-microsoft-com:office:excel", "RecalcAlways"), new QName("urn:schemas-microsoft-com:office:excel", "AutoScale"), new QName("urn:schemas-microsoft-com:office:excel", "DDE"), new QName("urn:schemas-microsoft-com:office:excel", "UIObj"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptText"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptExtended"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptLanguage"), new QName("urn:schemas-microsoft-com:office:excel", "ScriptLocation"), new QName("urn:schemas-microsoft-com:office:excel", "FmlaTxbx"), new QName("", "ObjectType")};
    private static final long serialVersionUID = 1;

    public CTClientDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getAccel2Array$42(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getAccelArray$40(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getAnchorArray$4(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoFillArray$14(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoLineArray$16(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoPictArray$18(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getAutoScaleArray$118(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getCFArray$112(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getCameraArray$114(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getCancelArray$36(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getCheckedArray$84(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getColHiddenArray$52(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getColoredArray$80(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getColumnArray$46(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDDEArray$120(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDefaultArray$32(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDefaultSizeArray$8(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDisabledArray$12(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getDismissArray$38(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getDropLinesArray$82(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getDropStyleArray$78(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getDxArray$108(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getFirstButtonArray$92(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getFmlaGroupArray$94(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getFmlaLinkArray$86(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getFmlaMacroArray$20(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getFmlaPictArray$88(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getFmlaRangeArray$62(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getFmlaTxbxArray$132(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getHelpArray$34(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getHorizArray$106(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getIncArray$102(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getJustLastXArray$28(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getLCTArray$74(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getListItemArray$76(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getLockTextArray$26(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getLockedArray$6(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getMapOCXArray$110(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getMaxArray$100(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getMinArray$98(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getMoveWithCellsArray$0(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getMultiLineArray$56(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getMultiSelArray$72(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getNoThreeD2Array$68(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getNoThreeDArray$90(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getPageArray$104(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getPrintObjectArray$10(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getRecalcAlwaysArray$116(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getRowArray$44(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getRowHiddenArray$50(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getScriptExtendedArray$126(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getScriptLanguageArray$128(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getScriptLocationArray$130(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getScriptTextArray$124(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getSecretEditArray$30(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getSelArray$66(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getSelTypeArray$70(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getSizeWithCellsArray$2(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getTextHAlignArray$22(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getTextVAlignArray$24(int i5) {
        return new String[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getUIObjArray$122(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getVScrollArray$58(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getVTEditArray$54(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getValArray$96(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getValidIdsArray$60(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank.Enum[] lambda$getVisibleArray$48(int i5) {
        return new STTrueFalseBlank.Enum[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigInteger[] lambda$getWidthMinArray$64(int i5) {
        return new BigInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetAccel2Array$43(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetAccelArray$41(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetAnchorArray$5(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoFillArray$15(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoLineArray$17(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoPictArray$19(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetAutoScaleArray$119(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STCF[] lambda$xgetCFArray$113(int i5) {
        return new STCF[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetCameraArray$115(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetCancelArray$37(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetCheckedArray$85(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetColHiddenArray$53(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetColoredArray$81(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetColumnArray$47(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetDDEArray$121(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetDefaultArray$33(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetDefaultSizeArray$9(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetDisabledArray$13(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetDismissArray$39(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetDropLinesArray$83(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetDropStyleArray$79(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetDxArray$109(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetFirstButtonArray$93(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetFmlaGroupArray$95(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetFmlaLinkArray$87(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetFmlaMacroArray$21(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetFmlaPictArray$89(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetFmlaRangeArray$63(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetFmlaTxbxArray$133(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetHelpArray$35(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetHorizArray$107(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetIncArray$103(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetJustLastXArray$29(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetLCTArray$75(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetListItemArray$77(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetLockTextArray$27(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetLockedArray$7(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetMapOCXArray$111(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetMaxArray$101(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetMinArray$99(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetMoveWithCellsArray$1(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetMultiLineArray$57(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetMultiSelArray$73(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetNoThreeD2Array$69(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetNoThreeDArray$91(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetPageArray$105(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetPrintObjectArray$11(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetRecalcAlwaysArray$117(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetRowArray$45(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetRowHiddenArray$51(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetScriptExtendedArray$127(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlNonNegativeInteger[] lambda$xgetScriptLanguageArray$129(int i5) {
        return new XmlNonNegativeInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlNonNegativeInteger[] lambda$xgetScriptLocationArray$131(int i5) {
        return new XmlNonNegativeInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetScriptTextArray$125(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetSecretEditArray$31(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetSelArray$67(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetSelTypeArray$71(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetSizeWithCellsArray$3(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetTextHAlignArray$23(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlString[] lambda$xgetTextVAlignArray$25(int i5) {
        return new XmlString[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetUIObjArray$123(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetVScrollArray$59(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetVTEditArray$55(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetValArray$97(int i5) {
        return new XmlInteger[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetValidIdsArray$61(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ STTrueFalseBlank[] lambda$xgetVisibleArray$49(int i5) {
        return new STTrueFalseBlank[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XmlInteger[] lambda$xgetWidthMinArray$65(int i5) {
        return new XmlInteger[i5];
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAccel(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[20])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAccel2(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[21])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAnchor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[2])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAutoFill(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[7])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAutoLine(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[8])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAutoPict(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[9])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addAutoScale(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[59])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addCF(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[56])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addCamera(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[57])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addCancel(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[18])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addChecked(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[42])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addColHidden(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[26])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addColored(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[40])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addColumn(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[23])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDDE(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[60])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDefault(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[16])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDefaultSize(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[4])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDisabled(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[6])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDismiss(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[19])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDropLines(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[41])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDropStyle(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[39])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addDx(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[54])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFirstButton(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[46])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFmlaGroup(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[47])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFmlaLink(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[43])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFmlaMacro(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[10])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFmlaPict(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[44])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFmlaRange(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[31])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addFmlaTxbx(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[66])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addHelp(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[17])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addHoriz(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[53])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addInc(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[51])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addJustLastX(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[14])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addLCT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[37])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addListItem(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[38])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addLockText(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[13])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addLocked(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[3])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addMapOCX(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[55])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addMax(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[50])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addMin(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[49])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addMoveWithCells(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[0])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addMultiLine(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[28])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addMultiSel(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[36])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewAccel() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewAccel2() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewAnchor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewAutoFill() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewAutoLine() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewAutoPict() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewAutoScale() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[59]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STCF addNewCF() {
        STCF stcf;
        synchronized (monitor()) {
            check_orphaned();
            stcf = (STCF) get_store().add_element_user(PROPERTY_QNAME[56]);
        }
        return stcf;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewCamera() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[57]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewCancel() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewChecked() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[42]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewColHidden() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewColored() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[40]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewColumn() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewDDE() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[60]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewDefault() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewDefaultSize() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewDisabled() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewDismiss() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewDropLines() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[41]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewDropStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[39]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewDx() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[54]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewFirstButton() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[46]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewFmlaGroup() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[47]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewFmlaLink() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[43]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewFmlaMacro() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewFmlaPict() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[44]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewFmlaRange() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewFmlaTxbx() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[66]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewHelp() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewHoriz() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[53]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewInc() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[51]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewJustLastX() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewLCT() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[37]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewListItem() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[38]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewLockText() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewLocked() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewMapOCX() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[55]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewMax() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[50]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewMin() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[49]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewMoveWithCells() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewMultiLine() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewMultiSel() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[36]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewNoThreeD() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[45]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewNoThreeD2() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewPage() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[52]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewPrintObject() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewRecalcAlways() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[58]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewRow() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewRowHidden() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewScriptExtended() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[63]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger addNewScriptLanguage() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().add_element_user(PROPERTY_QNAME[64]);
        }
        return xmlNonNegativeInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger addNewScriptLocation() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().add_element_user(PROPERTY_QNAME[65]);
        }
        return xmlNonNegativeInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewScriptText() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[62]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewSecretEdit() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewSel() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewSelType() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewSizeWithCells() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewTextHAlign() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString addNewTextVAlign() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewUIObj() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[61]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewVScroll() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewVTEdit() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewVal() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[48]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewValidIds() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank addNewVisible() {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger addNewWidthMin() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addNoThreeD(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[45])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addNoThreeD2(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[34])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addPage(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[52])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addPrintObject(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[5])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addRecalcAlways(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[58])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addRow(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[22])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addRowHidden(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[25])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addScriptExtended(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[63])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addScriptLanguage(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[64])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addScriptLocation(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[65])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addScriptText(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[62])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addSecretEdit(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[15])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addSel(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[33])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addSelType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[35])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addSizeWithCells(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[1])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addTextHAlign(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[11])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addTextVAlign(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[12])).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addUIObj(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[61])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addVScroll(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[29])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addVTEdit(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[27])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addVal(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[48])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addValidIds(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[30])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addVisible(STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[24])).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void addWidthMin(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[32])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getAccel2Array() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[21], new c(15), new l(16));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getAccel2List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 7), new o(this, 11), new o(this, 12), new j(this, 21), new k(this, 19));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getAccelArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[20], new c(15), new q(14));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getAccelList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new a(this, 28), new b(this, 18), new b(this, 19), new p099r2.c(this, 14), new d(this, 14));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getAnchorArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[2], new c(14), new t(5));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getAnchorList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 8), new b(this, 25), new b(this, 26), new p099r2.c(this, 15), new d(this, 15));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoFillArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[7], new t(8));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoFillList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 7), new b(this, 27), new g(this, 2), new p099r2.c(this, 19), new d(this, 20));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoLineArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[8], new f(24));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoLineList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 9), new b(this, 28), new b(this, 29), new p099r2.c(this, 5), new d(this, 5));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoPictArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[9], new f(14));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoPictList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new v(this, 8), new u(this, 8), new u(this, 9), new p099r2.c(this, 9), new d(this, 9));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getAutoScaleArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[59], new l(27));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getAutoScaleList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 23), new m(this, 29), new o(this, 0), new p099r2.c(this, 17), new d(this, 17));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getCFArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[56], new c(14), new q(2));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getCFList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 19), new g(this, 16), new g(this, 17), new p099r2.c(this, 22), new d(this, 22));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getCameraArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[57], new f(11));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getCameraList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 8), new m(this, 16), new m(this, 17), new j(this, 20), new k(this, 20));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getCancelArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[18], new q(4));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getCancelList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new v(this, 18), new u(this, 18), new u(this, 19), new w(this, 5), new x(this, 4));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getCheckedArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[42], new c(15), new q(6));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getCheckedList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 5), new h(this, 16), new h(this, 17), new j(this, 3), new k(this, 3));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getColHiddenArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[26], new l(14));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getColHiddenList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 7), new h(this, 21), new h(this, 24), new j(this, 7), new k(this, 9));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getColoredArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[40], new o5.i(8));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getColoredList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 21), new g(this, 20), new g(this, 21), new p099r2.c(this, 24), new d(this, 24));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getColumnArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[23], new c(15), new l(0));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getColumnList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 11), new m(this, 19), new m(this, 20), new j(this, 18), new k(this, 17));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getDDEArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[60], new f(20));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getDDEList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 17), new o(this, 22), new o(this, 23), new w(this, 6), new x(this, 5));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getDefaultArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[16], new f(0));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getDefaultList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 18), new o(this, 26), new r(this, 0), new w(this, 4), new x(this, 6));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getDefaultSizeArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[4], new t(15));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getDefaultSizeList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 2), new h(this, 10), new h(this, 11), new j(this, 1), new k(this, 0));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getDisabledArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[6], new o5.i(27));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getDisabledList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 25), new o(this, 28), new o(this, 29), new p099r2.c(this, 6), new d(this, 7));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getDismissArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[19], new t(13));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getDismissList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 23), new r(this, 26), new r(this, 27), new j(this, 24), new k(this, 24));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getDropLinesArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[41], new c(15), new l(28));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getDropLinesList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 12), new r(this, 16), new r(this, 17), new j(this, 25), new k(this, 25));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getDropStyleArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[39], new c(14), new o5.i(24));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getDropStyleList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 3), new h(this, 12), new h(this, 13), new j(this, 29), new k(this, 29));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getDxArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[54], new c(15), new f(21));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getDxList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 28), new r(this, 2), new r(this, 3), new j(this, 26), new k(this, 26));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getFirstButtonArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[46], new o5.i(12));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getFirstButtonList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 24), new o(this, 2), new o(this, 3), new j(this, 13), new k(this, 12));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getFmlaGroupArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[47], new c(14), new f(28));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getFmlaGroupList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 1), new h(this, 8), new h(this, 9), new p099r2.c(this, 25), new d(this, 25));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getFmlaLinkArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[43], new c(14), new q(17));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getFmlaLinkList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 17), new m(this, 25), new m(this, 26), new p099r2.c(this, 1), new d(this, 1));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getFmlaMacroArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[10], new c(14), new f(27));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getFmlaMacroList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 2), new m(this, 8), new m(this, 10), new p099r2.c(this, 11), new d(this, 11));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getFmlaPictArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[44], new c(14), new q(18));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getFmlaPictList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 11), new o(this, 16), new o(this, 17), new j(this, 23), new k(this, 23));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getFmlaRangeArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[31], new c(14), new f(13));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getFmlaRangeList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 9), new r(this, 14), new r(this, 15), new j(this, 28), new k(this, 28));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getFmlaTxbxArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[66], new c(14), new q(28));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getFmlaTxbxList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 8), new r(this, 12), new r(this, 13), new j(this, 27), new k(this, 27));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getHelpArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[17], new l(22));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getHelpList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 16), new o(this, 20), new o(this, 21), new j(this, 6), new k(this, 6));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getHorizArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[53], new t(7));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getHorizList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 27), new o(this, 5), new o(this, 6), new j(this, 4), new k(this, 4));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getIncArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[51], new c(15), new l(3));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getIncList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 24), new g(this, 23), new g(this, 24), new p099r2.c(this, 26), new d(this, 26));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getJustLastXArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[14], new l(21));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getJustLastXList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 4), new m(this, 13), new m(this, 14), new j(this, 8), new k(this, 7));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getLCTArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[37], new c(14), new l(1));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getLCTList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 27), new g(this, 27), new g(this, 28), new p099r2.c(this, 27), new d(this, 27));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getListItemArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[38], new c(14), new l(13));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getListItemList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new a(this, 8), new b(this, 4), new b(this, 5), new p099r2.c(this, 3), new d(this, 3));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getLockTextArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[13], new o5.i(18));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getLockTextList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new a(this, 22), new b(this, 12), new b(this, 13), new p099r2.c(this, 10), new d(this, 10));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getLockedArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[3], new t(21));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getLockedList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 12), new g(this, 5), new g(this, 6), new w(this, 0), new x(this, 0));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getMapOCXArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[55], new l(29));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getMapOCXList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new a(this, 27), new b(this, 16), new b(this, 17), new p099r2.c(this, 13), new d(this, 13));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getMaxArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[50], new c(15), new o5.i(22));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getMaxList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 20), new g(this, 18), new g(this, 19), new p099r2.c(this, 23), new d(this, 23));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getMinArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[49], new c(15), new l(4));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getMinList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 18), new g(this, 14), new g(this, 15), new p099r2.c(this, 8), new d(this, 8));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getMoveWithCellsArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[0], new f(1));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getMoveWithCellsList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 25), new g(this, 29), new h(this, 5), new j(this, 0), new k(this, 1));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getMultiLineArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[28], new t(10));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getMultiLineList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 14), new h(this, 25), new h(this, 26), new p099r2.c(this, 18), new d(this, 18));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getMultiSelArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[36], new c(14), new f(29));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getMultiSelList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 26), new g(this, 25), new g(this, 26), new p099r2.c(this, 12), new d(this, 12));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getNoThreeD2Array() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[34], new l(19));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getNoThreeD2List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 15), new g(this, 8), new g(this, 9), new p099r2.c(this, 16), new d(this, 16));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getNoThreeDArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[45], new f(8));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getNoThreeDList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 9), new h(this, 19), new h(this, 20), new p099r2.c(this, 7), new d(this, 6));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STObjectType.Enum getObjectType() {
        STObjectType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[67]);
            r6 = simpleValue == null ? null : (STObjectType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getPageArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[52], new c(15), new o5.i(19));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getPageList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 1), new r(this, 5), new r(this, 6), new j(this, 15), new k(this, 14));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getPrintObjectArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[5], new q(25));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getPrintObjectList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 10), new g(this, 0), new g(this, 1), new p099r2.c(this, 2), new d(this, 2));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getRecalcAlwaysArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[58], new l(2));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getRecalcAlwaysList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new v(this, 15), new u(this, 14), new u(this, 15), new w(this, 2), new x(this, 2));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getRowArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[22], new c(15), new f(2));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getRowHiddenArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[25], new t(0));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getRowHiddenList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 16), new r(this, 21), new r(this, 22), new j(this, 5), new k(this, 5));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getRowList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new v(this, 4), new u(this, 3), new u(this, 4), new j(this, 17), new k(this, 15));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getScriptExtendedArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[63], new c(14), new q(19));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getScriptExtendedList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 17), new g(this, 12), new g(this, 13), new p099r2.c(this, 20), new d(this, 19));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getScriptLanguageArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[64], new c(15), new t(11));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getScriptLanguageList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 28), new h(this, 1), new h(this, 2), new p099r2.c(this, 28), new d(this, 28));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getScriptLocationArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[65], new c(15), new o5.i(13));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getScriptLocationList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new v(this, 17), new u(this, 16), new u(this, 17), new w(this, 3), new x(this, 3));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getScriptTextArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[62], new c(14), new q(12));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getScriptTextList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 5), new r(this, 8), new r(this, 9), new p099r2.c(this, 4), new d(this, 4));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getSecretEditArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[15], new q(1));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getSecretEditList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 26), new m(this, 4), new m(this, 5), new j(this, 11), new k(this, 11));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getSelArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[33], new c(15), new f(22));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getSelList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new a(this, 0), new b(this, 22), new h(this, 0), new j(this, 12), new k(this, 21));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getSelTypeArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[35], new c(14), new q(10));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getSelTypeList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new v(this, 7), new u(this, 6), new u(this, 7), new j(this, 19), new k(this, 18));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getSizeWithCellsArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[1], new t(17));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getSizeWithCellsList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 4), new h(this, 14), new h(this, 15), new j(this, 2), new k(this, 2));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getTextHAlignArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[11], new c(14), new t(9));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getTextHAlignList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 3), new m(this, 11), new m(this, 12), new j(this, 14), new k(this, 13));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String[] getTextVAlignArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[12], new c(14), new q(8));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<String> getTextVAlignList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 0), new h(this, 6), new h(this, 7), new p099r2.c(this, 0), new d(this, 0));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getUIObjArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[61], new f(12));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getUIObjList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 29), new h(this, 3), new h(this, 4), new p099r2.c(this, 29), new d(this, 29));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getVScrollArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[29], new q(29));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getVScrollList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new s(this, 13), new r(this, 18), new r(this, 19), new w(this, 1), new x(this, 1));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getVTEditArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[27], new c(15), new q(27));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getVTEditList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new n(this, 16), new m(this, 23), new m(this, 24), new j(this, 9), new k(this, 8));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getValArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[48], new c(15), new t(20));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getValList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new p(this, 8), new o(this, 13), new o(this, 14), new j(this, 22), new k(this, 22));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getValidIdsArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[30], new t(6));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getValidIdsList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new i(this, 23), new m(this, 1), new m(this, 2), new j(this, 10), new k(this, 10));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum[] getVisibleArray() {
        return (STTrueFalseBlank.Enum[]) getEnumArray(PROPERTY_QNAME[24], new o5.i(9));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank.Enum> getVisibleList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 16), new g(this, 10), new g(this, 11), new p099r2.c(this, 21), new d(this, 21));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger[] getWidthMinArray() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[32], new c(15), new l(20));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<BigInteger> getWidthMinList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new e(this, 11), new g(this, 3), new g(this, 4), new j(this, 16), new k(this, 16));
        }
        return javaListObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAccel(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[20], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAccel2(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[21], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAnchor(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[2], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAutoFill(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[7], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAutoLine(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[8], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAutoPict(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[9], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertAutoScale(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[59], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertCF(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[56], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertCamera(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[57], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertCancel(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[18], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertChecked(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[42], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertColHidden(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[26], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertColored(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[40], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertColumn(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[23], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDDE(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[60], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDefault(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[16], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDefaultSize(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[4], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDisabled(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[6], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDismiss(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[19], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDropLines(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[41], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDropStyle(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[39], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertDx(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[54], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFirstButton(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[46], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFmlaGroup(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[47], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFmlaLink(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[43], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFmlaMacro(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[10], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFmlaPict(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[44], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFmlaRange(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[31], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertFmlaTxbx(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[66], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertHelp(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[17], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertHoriz(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[53], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertInc(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[51], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertJustLastX(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[14], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertLCT(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[37], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertListItem(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[38], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertLockText(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[13], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertLocked(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[3], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertMapOCX(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[55], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertMax(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[50], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertMin(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[49], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertMoveWithCells(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[0], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertMultiLine(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[28], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertMultiSel(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[36], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewAccel(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[20], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewAccel2(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[21], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewAnchor(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewAutoFill(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewAutoLine(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewAutoPict(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewAutoScale(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[59], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STCF insertNewCF(int i5) {
        STCF stcf;
        synchronized (monitor()) {
            check_orphaned();
            stcf = (STCF) get_store().insert_element_user(PROPERTY_QNAME[56], i5);
        }
        return stcf;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewCamera(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[57], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewCancel(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[18], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewChecked(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[42], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewColHidden(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[26], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewColored(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[40], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewColumn(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[23], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewDDE(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[60], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewDefault(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[16], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewDefaultSize(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewDisabled(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewDismiss(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[19], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewDropLines(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[41], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewDropStyle(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[39], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewDx(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[54], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewFirstButton(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[46], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewFmlaGroup(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[47], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewFmlaLink(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[43], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewFmlaMacro(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewFmlaPict(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[44], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewFmlaRange(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[31], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewFmlaTxbx(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[66], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewHelp(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[17], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewHoriz(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[53], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewInc(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[51], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewJustLastX(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[14], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewLCT(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[37], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewListItem(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[38], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewLockText(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[13], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewLocked(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewMapOCX(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[55], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewMax(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[50], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewMin(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[49], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewMoveWithCells(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewMultiLine(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[28], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewMultiSel(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[36], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewNoThreeD(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[45], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewNoThreeD2(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[34], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewPage(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[52], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewPrintObject(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewRecalcAlways(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[58], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewRow(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[22], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewRowHidden(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[25], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewScriptExtended(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[63], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger insertNewScriptLanguage(int i5) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().insert_element_user(PROPERTY_QNAME[64], i5);
        }
        return xmlNonNegativeInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger insertNewScriptLocation(int i5) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().insert_element_user(PROPERTY_QNAME[65], i5);
        }
        return xmlNonNegativeInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewScriptText(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[62], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewSecretEdit(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[15], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewSel(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[33], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewSelType(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[35], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewSizeWithCells(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewTextHAlign(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString insertNewTextVAlign(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[12], i5);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewUIObj(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[61], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewVScroll(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[29], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewVTEdit(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[27], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewVal(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[48], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewValidIds(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[30], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank insertNewVisible(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseBlank = (STTrueFalseBlank) get_store().insert_element_user(PROPERTY_QNAME[24], i5);
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger insertNewWidthMin(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().insert_element_user(PROPERTY_QNAME[32], i5);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertNoThreeD(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[45], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertNoThreeD2(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[34], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertPage(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[52], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertPrintObject(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[5], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertRecalcAlways(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[58], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertRow(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[22], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertRowHidden(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[25], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertScriptExtended(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[63], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertScriptLanguage(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[64], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertScriptLocation(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[65], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertScriptText(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[62], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertSecretEdit(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[15], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertSel(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[33], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertSelType(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[35], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertSizeWithCells(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[1], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertTextHAlign(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[11], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertTextVAlign(int i5, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[12], i5)).setStringValue(str);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertUIObj(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[61], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertVScroll(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[29], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertVTEdit(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[27], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertVal(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[48], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertValidIds(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[30], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertVisible(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[24], i5)).setEnumValue(r6);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void insertWidthMin(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[32], i5)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAccel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAccel2(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAnchor(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAutoFill(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAutoLine(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAutoPict(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeAutoScale(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[59], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeCF(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[56], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeCamera(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[57], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeCancel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeChecked(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[42], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeColHidden(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeColored(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[40], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeColumn(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDDE(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[60], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDefault(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDefaultSize(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDisabled(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDismiss(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDropLines(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[41], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDropStyle(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[39], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeDx(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[54], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFirstButton(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[46], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFmlaGroup(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[47], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFmlaLink(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[43], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFmlaMacro(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFmlaPict(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[44], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFmlaRange(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeFmlaTxbx(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[66], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeHelp(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeHoriz(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[53], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeInc(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[51], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeJustLastX(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeLCT(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[37], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeListItem(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[38], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeLockText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeLocked(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeMapOCX(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[55], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeMax(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[50], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeMin(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[49], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeMoveWithCells(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeMultiLine(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeMultiSel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[36], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeNoThreeD(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[45], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeNoThreeD2(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removePage(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[52], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removePrintObject(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeRecalcAlways(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[58], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeRow(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeRowHidden(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeScriptExtended(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[63], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeScriptLanguage(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[64], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeScriptLocation(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[65], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeScriptText(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[62], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeSecretEdit(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeSel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeSelType(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeSizeWithCells(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeTextHAlign(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeTextVAlign(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeUIObj(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[61], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeVScroll(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeVTEdit(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeVal(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[48], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeValidIds(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeVisible(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void removeWidthMin(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i5);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAccel2Array(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[21]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAccelArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[20]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAnchorArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[2]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoFillArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[7]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoLineArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[8]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoPictArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[9]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoScaleArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[59]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCFArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[56]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCameraArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[57]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCancelArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[18]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCheckedArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[42]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setColHiddenArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[26]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setColoredArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[40]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setColumnArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[23]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDDEArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[60]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDefaultArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[16]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDefaultSizeArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[4]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDisabledArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[6]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDismissArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[19]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDropLinesArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[41]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDropStyleArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[39]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDxArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[54]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFirstButtonArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[46]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaGroupArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[47]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaLinkArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[43]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaMacroArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[10]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaPictArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[44]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaRangeArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[31]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaTxbxArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[66]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setHelpArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[17]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setHorizArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[53]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setIncArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[51]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setJustLastXArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[14]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setLCTArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[37]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setListItemArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[38]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setLockTextArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[13]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setLockedArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[3]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMapOCXArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[55]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMaxArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[50]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMinArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[49]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMoveWithCellsArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[0]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMultiLineArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[28]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMultiSelArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[36]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setNoThreeD2Array(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[34]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setNoThreeDArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[45]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setObjectType(STObjectType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[67]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[67]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setPageArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[52]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setPrintObjectArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[5]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setRecalcAlwaysArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[58]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setRowArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[22]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setRowHiddenArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[25]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptExtendedArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[63]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptLanguageArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[64]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptLocationArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[65]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptTextArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[62]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSecretEditArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[15]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSelArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[33]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSelTypeArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[35]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSizeWithCellsArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[1]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setTextHAlignArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[11]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setTextVAlignArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[12]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setUIObjArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[61]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setVScrollArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[29]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setVTEditArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[27]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setValArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[48]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setValidIdsArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[30]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setVisibleArray(STTrueFalseBlank.Enum[] enumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(enumArr, PROPERTY_QNAME[24]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setWidthMinArray(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[32]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAccel2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAccelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAutoFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAutoLineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAutoPictArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfAutoScaleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[59]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfCFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[56]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfCameraArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[57]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfCancelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfCheckedArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[42]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfColHiddenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfColoredArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[40]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfColumnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDDEArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[60]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDefaultArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDefaultSizeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDisabledArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDismissArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDropLinesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[41]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDropStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[39]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfDxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[54]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFirstButtonArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[46]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFmlaGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[47]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFmlaLinkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[43]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFmlaMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFmlaPictArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[44]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFmlaRangeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfFmlaTxbxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[66]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfHelpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfHorizArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[53]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfIncArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[51]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfJustLastXArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfLCTArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[37]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfListItemArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[38]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfLockTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfLockedArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfMapOCXArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[55]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfMaxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[50]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfMinArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[49]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfMoveWithCellsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfMultiLineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfMultiSelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[36]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfNoThreeD2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfNoThreeDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[45]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfPageArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[52]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfPrintObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfRecalcAlwaysArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[58]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfRowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfRowHiddenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfScriptExtendedArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[63]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfScriptLanguageArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[64]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfScriptLocationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[65]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfScriptTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[62]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfSecretEditArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfSelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfSelTypeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[35]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfSizeWithCellsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfTextHAlignArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfTextVAlignArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfUIObjArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[61]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfVScrollArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfVTEditArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfValArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[48]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfValidIdsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfVisibleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public int sizeOfWidthMinArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetAccel2Array() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[21], new l(24));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetAccel2List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 9), new o(this, 15), new p(this, 10), new j(this, 21), new k(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetAccelArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[20], new f(17));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetAccelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 3), new o(this, 9), new p(this, 4), new p099r2.c(this, 14), new d(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetAnchorArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[2], new q(16));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetAnchorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 29), new b(this, 20), new e(this, 0), new p099r2.c(this, 15), new d(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetAutoFillArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[7], new f(16));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetAutoFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 29), new r(this, 4), new s(this, 0), new p099r2.c(this, 19), new d(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetAutoLineArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[8], new l(11));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetAutoLineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 12), new b(this, 7), new a(this, 13), new p099r2.c(this, 5), new d(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetAutoPictArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[9], new o5.i(20));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetAutoPictList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 20), new b(this, 11), new a(this, 21), new p099r2.c(this, 9), new d(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetAutoScaleArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[59], new f(4));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetAutoScaleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new e(this, 3), new b(this, 23), new e(this, 4), new p099r2.c(this, 17), new d(this, 17));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STCF[] xgetCFArray() {
        return (STCF[]) xgetArray(PROPERTY_QNAME[56], new t(12));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STCF> xgetCFList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 14), new r(this, 20), new s(this, 15), new p099r2.c(this, 22), new d(this, 22));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetCameraArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[57], new l(5));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetCameraList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 19), new o(this, 1), new n(this, 29), new j(this, 20), new k(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetCancelArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[18], new f(5));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetCancelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 0), new u(this, 1), new v(this, 1), new w(this, 5), new x(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetCheckedArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[42], new l(10));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetCheckedList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 6), new r(this, 10), new s(this, 7), new j(this, 3), new k(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetColHiddenArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[26], new t(2));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetColHiddenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 12), new m(this, 21), new n(this, 13), new j(this, 7), new k(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetColoredArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[40], new t(19));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetColoredList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 21), new m(this, 28), new n(this, 22), new p099r2.c(this, 24), new d(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetColumnArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[23], new f(7));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetColumnList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 5), new o(this, 10), new p(this, 6), new j(this, 18), new k(this, 17));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetDDEArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[60], new q(24));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetDDEList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 19), new u(this, 20), new v(this, 20), new w(this, 6), new x(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetDefaultArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[16], new t(14));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetDefaultList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 11), new u(this, 12), new v(this, 16), new w(this, 4), new x(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetDefaultSizeArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[4], new l(18));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetDefaultSizeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 0), new m(this, 7), new n(this, 1), new j(this, 1), new k(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetDisabledArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[6], new l(9));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetDisabledList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 5), new b(this, 3), new a(this, 11), new p099r2.c(this, 6), new d(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetDismissArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[19], new o5.i(11));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetDismissList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 19), new o(this, 24), new p(this, 20), new j(this, 24), new k(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetDropLinesArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[41], new l(12));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetDropLinesList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 23), new o(this, 27), new p(this, 24), new j(this, 25), new k(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetDropStyleArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[39], new q(7));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetDropStyleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 4), new r(this, 11), new s(this, 10), new j(this, 29), new k(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetDxArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[54], new f(18));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetDxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 26), new r(this, 1), new p(this, 27), new j(this, 26), new k(this, 26));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetFirstButtonArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[46], new f(6));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetFirstButtonList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 28), new m(this, 6), new i(this, 29), new j(this, 13), new k(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetFmlaGroupArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[47], new q(0));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetFmlaGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new e(this, 22), new g(this, 22), new e(this, 23), new p099r2.c(this, 25), new d(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetFmlaLinkArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[43], new q(5));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetFmlaLinkList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 3), new b(this, 1), new a(this, 4), new p099r2.c(this, 1), new d(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetFmlaMacroArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[10], new t(1));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetFmlaMacroList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 23), new b(this, 14), new a(this, 24), new p099r2.c(this, 11), new d(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetFmlaPictArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[44], new q(13));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetFmlaPictList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 24), new r(this, 28), new s(this, 25), new j(this, 23), new k(this, 23));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetFmlaRangeArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[31], new f(15));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetFmlaRangeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 26), new r(this, 29), new s(this, 27), new j(this, 28), new k(this, 28));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetFmlaTxbxArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[66], new q(11));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetFmlaTxbxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 9), new u(this, 10), new v(this, 10), new j(this, 27), new k(this, 27));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetHelpArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[17], new f(19));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetHelpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 12), new h(this, 23), new i(this, 13), new j(this, 6), new k(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetHorizArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[53], new f(23));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetHorizList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 6), new h(this, 18), new i(this, 8), new j(this, 4), new k(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetIncArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[51], new o5.i(21));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetIncList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 15), new h(this, 27), new i(this, 16), new p099r2.c(this, 26), new d(this, 26));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetJustLastXArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[14], new f(3));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetJustLastXList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 17), new h(this, 28), new i(this, 18), new j(this, 8), new k(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetLCTArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[37], new o5.i(16));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetLCTList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 14), new m(this, 22), new n(this, 15), new p099r2.c(this, 27), new d(this, 27));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetListItemArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[38], new f(9));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetListItemList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 16), new b(this, 9), new a(this, 17), new p099r2.c(this, 3), new d(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetLockTextArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[13], new t(18));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetLockTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 2), new r(this, 7), new s(this, 3), new p099r2.c(this, 10), new d(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetLockedArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[3], new f(10));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetLockedList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 11), new u(this, 11), new v(this, 12), new w(this, 0), new x(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetMapOCXArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[55], new q(21));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetMapOCXList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 24), new m(this, 3), new i(this, 25), new p099r2.c(this, 13), new d(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetMaxArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[50], new o5.i(26));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetMaxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 17), new r(this, 23), new s(this, 18), new p099r2.c(this, 23), new d(this, 23));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetMinArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[49], new l(6));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetMinList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 18), new b(this, 10), new a(this, 19), new p099r2.c(this, 8), new d(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetMoveWithCellsArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[0], new l(17));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetMoveWithCellsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 19), new r(this, 24), new s(this, 20), new j(this, 0), new k(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetMultiLineArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[28], new l(7));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetMultiLineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new e(this, 5), new b(this, 24), new e(this, 6), new p099r2.c(this, 18), new d(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetMultiSelArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[36], new q(20));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetMultiSelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 25), new b(this, 15), new a(this, 26), new p099r2.c(this, 12), new d(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetNoThreeD2Array() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[34], new o5.i(23));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetNoThreeD2List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new e(this, 1), new b(this, 21), new e(this, 2), new p099r2.c(this, 16), new d(this, 16));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetNoThreeDArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[45], new f(26));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetNoThreeDList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 14), new b(this, 8), new a(this, 15), new p099r2.c(this, 7), new d(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STObjectType xgetObjectType() {
        STObjectType sTObjectType;
        synchronized (monitor()) {
            check_orphaned();
            sTObjectType = (STObjectType) get_store().find_attribute_user(PROPERTY_QNAME[67]);
        }
        return sTObjectType;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetPageArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[52], new q(22));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetPageList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 6), new m(this, 15), new n(this, 7), new j(this, 15), new k(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetPrintObjectArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[5], new t(16));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetPrintObjectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 6), new b(this, 2), new a(this, 7), new p099r2.c(this, 2), new d(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetRecalcAlwaysArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[58], new o5.i(25));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetRecalcAlwaysList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 21), new m(this, 0), new i(this, 22), new w(this, 2), new x(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetRowArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[22], new q(15));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetRowHiddenArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[25], new q(3));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetRowHiddenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 10), new h(this, 22), new i(this, 11), new j(this, 5), new k(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetRowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 9), new m(this, 18), new n(this, 10), new j(this, 17), new k(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetScriptExtendedArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[63], new o5.i(10));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetScriptExtendedList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new e(this, 13), new g(this, 7), new e(this, 14), new p099r2.c(this, 20), new d(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger[] xgetScriptLanguageArray() {
        return (XmlNonNegativeInteger[]) xgetArray(PROPERTY_QNAME[64], new o5.i(14));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlNonNegativeInteger> xgetScriptLanguageList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 14), new o(this, 19), new p(this, 15), new p099r2.c(this, 28), new d(this, 28));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger[] xgetScriptLocationArray() {
        return (XmlNonNegativeInteger[]) xgetArray(PROPERTY_QNAME[65], new o5.i(29));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlNonNegativeInteger> xgetScriptLocationList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 2), new u(this, 2), new v(this, 3), new w(this, 3), new x(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetScriptTextArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[62], new q(23));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetScriptTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 9), new b(this, 6), new a(this, 10), new p099r2.c(this, 4), new d(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetSecretEditArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[15], new l(25));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetSecretEditList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 25), new o(this, 4), new n(this, 26), new j(this, 11), new k(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetSelArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[33], new q(26));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetSelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 28), new o(this, 7), new p(this, 0), new j(this, 12), new k(this, 21));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetSelTypeArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[35], new l(8));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetSelTypeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 1), new o(this, 8), new p(this, 2), new j(this, 19), new k(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetSizeWithCellsArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[1], new l(26));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetSizeWithCellsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 12), new o(this, 18), new p(this, 13), new j(this, 2), new k(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetTextHAlignArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[11], new o5.i(28));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetTextHAlignList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 21), new r(this, 25), new s(this, 22), new j(this, 14), new k(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString[] xgetTextVAlignArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[12], new t(4));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlString> xgetTextVAlignList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new a(this, 1), new b(this, 0), new a(this, 2), new p099r2.c(this, 0), new d(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetUIObjArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[61], new l(15));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetUIObjList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new n(this, 18), new m(this, 27), new n(this, 20), new p099r2.c(this, 29), new d(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetVScrollArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[29], new q(9));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetVScrollList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 13), new u(this, 13), new v(this, 14), new w(this, 1), new x(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetVTEditArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[27], new t(3));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetVTEditList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 19), new h(this, 29), new i(this, 20), new j(this, 9), new k(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetValArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[48], new o5.i(15));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetValList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p(this, 21), new o(this, 25), new p(this, 22), new j(this, 22), new k(this, 22));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetValidIdsArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[30], new o5.i(17));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetValidIdsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new s(this, 28), new u(this, 0), new s(this, 29), new j(this, 10), new k(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank[] xgetVisibleArray() {
        return (STTrueFalseBlank[]) xgetArray(PROPERTY_QNAME[24], new f(25));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<STTrueFalseBlank> xgetVisibleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new v(this, 5), new u(this, 5), new v(this, 6), new p099r2.c(this, 21), new d(this, 21));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger[] xgetWidthMinArray() {
        return (XmlInteger[]) xgetArray(PROPERTY_QNAME[32], new l(23));
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public List<XmlInteger> xgetWidthMinList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new i(this, 27), new m(this, 9), new n(this, 5), new j(this, 16), new k(this, 16));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAccel2Array(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[21]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAccelArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[20]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAnchorArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[2]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoFillArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[7]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoLineArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[8]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoPictArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[9]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoScaleArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[59]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCFArray(STCF[] stcfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(stcfArr, PROPERTY_QNAME[56]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCameraArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[57]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCancelArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[18]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCheckedArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[42]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetColHiddenArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[26]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetColoredArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[40]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetColumnArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[23]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDDEArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[60]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDefaultArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[16]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDefaultSizeArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[4]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDisabledArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[6]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDismissArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[19]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDropLinesArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[41]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDropStyleArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[39]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDxArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[54]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFirstButtonArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[46]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaGroupArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[47]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaLinkArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[43]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaMacroArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[10]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaPictArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[44]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaRangeArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[31]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaTxbxArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[66]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetHelpArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[17]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetHorizArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[53]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetIncArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[51]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetJustLastXArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[14]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetLCTArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[37]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetListItemArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[38]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetLockTextArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[13]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetLockedArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[3]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMapOCXArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[55]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMaxArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[50]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMinArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[49]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMoveWithCellsArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[0]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMultiLineArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[28]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMultiSelArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[36]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetNoThreeD2Array(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[34]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetNoThreeDArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[45]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetObjectType(STObjectType sTObjectType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STObjectType sTObjectType2 = (STObjectType) typeStore.find_attribute_user(qNameArr[67]);
                if (sTObjectType2 == null) {
                    sTObjectType2 = (STObjectType) get_store().add_attribute_user(qNameArr[67]);
                }
                sTObjectType2.set(sTObjectType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetPageArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[52]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetPrintObjectArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[5]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetRecalcAlwaysArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[58]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetRowArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[22]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetRowHiddenArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[25]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptExtendedArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[63]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptLanguageArray(XmlNonNegativeInteger[] xmlNonNegativeIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlNonNegativeIntegerArr, PROPERTY_QNAME[64]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptLocationArray(XmlNonNegativeInteger[] xmlNonNegativeIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlNonNegativeIntegerArr, PROPERTY_QNAME[65]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptTextArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[62]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSecretEditArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[15]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSelArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[33]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSelTypeArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[35]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSizeWithCellsArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[1]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetTextHAlignArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[11]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetTextVAlignArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[12]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetUIObjArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[61]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetVScrollArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[29]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetVTEditArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[27]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetValArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[48]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetValidIdsArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[30]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetVisibleArray(STTrueFalseBlank[] sTTrueFalseBlankArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTTrueFalseBlankArr, PROPERTY_QNAME[24]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetWidthMinArray(XmlInteger[] xmlIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntegerArr, PROPERTY_QNAME[32]);
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getAccel2Array(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getAccelArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getAnchorArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getAutoFillArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getAutoLineArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getAutoPictArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getAutoScaleArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[59], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getCFArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[56], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getCameraArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[57], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getCancelArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getCheckedArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[42], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getColHiddenArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getColoredArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[40], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getColumnArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getDDEArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[60], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getDefaultArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getDefaultSizeArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getDisabledArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getDismissArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getDropLinesArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[41], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getDropStyleArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[39], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getDxArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[54], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getFirstButtonArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[46], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getFmlaGroupArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[47], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getFmlaLinkArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[43], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getFmlaMacroArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getFmlaPictArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[44], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getFmlaRangeArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[31], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getFmlaTxbxArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[66], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getHelpArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getHorizArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[53], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getIncArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[51], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getJustLastXArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getLCTArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[37], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getListItemArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[38], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getLockTextArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getLockedArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getMapOCXArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[55], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getMaxArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[50], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getMinArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[49], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getMoveWithCellsArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getMultiLineArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getMultiSelArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[36], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getNoThreeD2Array(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[34], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getNoThreeDArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[45], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getPageArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[52], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getPrintObjectArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getRecalcAlwaysArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[58], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getRowArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getRowHiddenArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getScriptExtendedArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[63], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getScriptLanguageArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[64], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getScriptLocationArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[65], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getScriptTextArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[62], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getSecretEditArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getSelArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[33], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getSelTypeArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[35], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getSizeWithCellsArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getTextHAlignArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public String getTextVAlignArray(int i5) {
        String stringValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                stringValue = simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getUIObjArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[61], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getVScrollArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getVTEditArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getValArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[48], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getValidIdsArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[30], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank.Enum getVisibleArray(int i5) {
        STTrueFalseBlank.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                r6 = (STTrueFalseBlank.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public BigInteger getWidthMinArray(int i5) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[32], i5);
                if (simpleValue == null) {
                    throw new IndexOutOfBoundsException();
                }
                bigIntegerValue = simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetAccel2Array(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetAccelArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetAnchorArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetAutoFillArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetAutoLineArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetAutoPictArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetAutoScaleArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[59], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STCF xgetCFArray(int i5) {
        STCF stcf;
        synchronized (monitor()) {
            try {
                check_orphaned();
                stcf = (STCF) get_store().find_element_user(PROPERTY_QNAME[56], i5);
                if (stcf == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stcf;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetCameraArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[57], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetCancelArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetCheckedArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[42], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetColHiddenArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetColoredArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[40], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetColumnArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetDDEArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[60], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetDefaultArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetDefaultSizeArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetDisabledArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetDismissArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetDropLinesArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[41], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetDropStyleArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[39], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetDxArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[54], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetFirstButtonArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[46], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetFmlaGroupArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[47], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetFmlaLinkArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[43], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetFmlaMacroArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetFmlaPictArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[44], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetFmlaRangeArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[31], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetFmlaTxbxArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[66], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetHelpArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetHorizArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[53], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetIncArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[51], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetJustLastXArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetLCTArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[37], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetListItemArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[38], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetLockTextArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetLockedArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetMapOCXArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[55], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetMaxArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[50], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetMinArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[49], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetMoveWithCellsArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetMultiLineArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetMultiSelArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[36], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetNoThreeD2Array(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[34], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetNoThreeDArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[45], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetPageArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[52], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetPrintObjectArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetRecalcAlwaysArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[58], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetRowArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetRowHiddenArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetScriptExtendedArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[63], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger xgetScriptLanguageArray(int i5) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().find_element_user(PROPERTY_QNAME[64], i5);
                if (xmlNonNegativeInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlNonNegativeInteger xgetScriptLocationArray(int i5) {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlNonNegativeInteger = (XmlNonNegativeInteger) get_store().find_element_user(PROPERTY_QNAME[65], i5);
                if (xmlNonNegativeInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetScriptTextArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[62], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetSecretEditArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetSelArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[33], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetSelTypeArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[35], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetSizeWithCellsArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetTextHAlignArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlString xgetTextVAlignArray(int i5) {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (xmlString == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetUIObjArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[61], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetVScrollArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetVTEditArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetValArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[48], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetValidIdsArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[30], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public STTrueFalseBlank xgetVisibleArray(int i5) {
        STTrueFalseBlank sTTrueFalseBlank;
        synchronized (monitor()) {
            try {
                check_orphaned();
                sTTrueFalseBlank = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (sTTrueFalseBlank == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTrueFalseBlank;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public XmlInteger xgetWidthMinArray(int i5) {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            try {
                check_orphaned();
                xmlInteger = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[32], i5);
                if (xmlInteger == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAccel2Array(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAccelArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAnchorArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoFillArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoLineArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoPictArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setAutoScaleArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[59], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCFArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[56], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCameraArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[57], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCancelArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setCheckedArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[42], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setColHiddenArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setColoredArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[40], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setColumnArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDDEArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[60], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDefaultArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDefaultSizeArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDisabledArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDismissArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDropLinesArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[41], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDropStyleArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[39], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setDxArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[54], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFirstButtonArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[46], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaGroupArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[47], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaLinkArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[43], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaMacroArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaPictArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[44], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaRangeArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[31], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setFmlaTxbxArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[66], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setHelpArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setHorizArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[53], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setIncArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[51], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setJustLastXArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setLCTArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[37], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setListItemArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[38], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setLockTextArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setLockedArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMapOCXArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[55], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMaxArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[50], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMinArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[49], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMoveWithCellsArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMultiLineArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setMultiSelArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[36], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setNoThreeD2Array(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[34], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setNoThreeDArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[45], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setPageArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[52], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setPrintObjectArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setRecalcAlwaysArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[58], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setRowArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setRowHiddenArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptExtendedArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[63], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptLanguageArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[64], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptLocationArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[65], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setScriptTextArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[62], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSecretEditArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSelArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[33], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSelTypeArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[35], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setSizeWithCellsArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setTextHAlignArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setTextVAlignArray(int i5, String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (simpleValue != null) {
                    simpleValue.setStringValue(str);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setUIObjArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[61], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setVScrollArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setVTEditArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setValArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[48], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setValidIdsArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[30], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setVisibleArray(int i5, STTrueFalseBlank.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (simpleValue != null) {
                    simpleValue.setEnumValue(r6);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void setWidthMinArray(int i5, BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[32], i5);
                if (simpleValue != null) {
                    simpleValue.setBigIntegerValue(bigInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAccel2Array(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAccelArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAnchorArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoFillArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoLineArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoPictArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetAutoScaleArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[59], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCFArray(int i5, STCF stcf) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STCF stcf2 = (STCF) get_store().find_element_user(PROPERTY_QNAME[56], i5);
                if (stcf2 != null) {
                    stcf2.set(stcf);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCameraArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[57], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCancelArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetCheckedArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[42], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetColHiddenArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetColoredArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[40], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetColumnArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDDEArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[60], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDefaultArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDefaultSizeArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDisabledArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDismissArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDropLinesArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[41], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDropStyleArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[39], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetDxArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[54], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFirstButtonArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[46], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaGroupArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[47], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaLinkArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[43], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaMacroArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaPictArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[44], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaRangeArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[31], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetFmlaTxbxArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[66], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetHelpArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetHorizArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[53], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetIncArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[51], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetJustLastXArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetLCTArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[37], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetListItemArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[38], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetLockTextArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetLockedArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMapOCXArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[55], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMaxArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[50], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMinArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[49], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMoveWithCellsArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMultiLineArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetMultiSelArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[36], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetNoThreeD2Array(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[34], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetNoThreeDArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[45], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetPageArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[52], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetPrintObjectArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetRecalcAlwaysArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[58], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetRowArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetRowHiddenArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptExtendedArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[63], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptLanguageArray(int i5, XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().find_element_user(PROPERTY_QNAME[64], i5);
                if (xmlNonNegativeInteger2 != null) {
                    xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptLocationArray(int i5, XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().find_element_user(PROPERTY_QNAME[65], i5);
                if (xmlNonNegativeInteger2 != null) {
                    xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetScriptTextArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[62], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSecretEditArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSelArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[33], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSelTypeArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[35], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetSizeWithCellsArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetTextHAlignArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetTextVAlignArray(int i5, XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (xmlString2 != null) {
                    xmlString2.set(xmlString);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetUIObjArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[61], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetVScrollArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetVTEditArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetValArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[48], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetValidIdsArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[30], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetVisibleArray(int i5, STTrueFalseBlank sTTrueFalseBlank) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                STTrueFalseBlank sTTrueFalseBlank2 = (STTrueFalseBlank) get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (sTTrueFalseBlank2 != null) {
                    sTTrueFalseBlank2.set(sTTrueFalseBlank);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.excel.CTClientData
    public void xsetWidthMinArray(int i5, XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                XmlInteger xmlInteger2 = (XmlInteger) get_store().find_element_user(PROPERTY_QNAME[32], i5);
                if (xmlInteger2 != null) {
                    xmlInteger2.set(xmlInteger);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
