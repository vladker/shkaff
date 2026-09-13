package p102s;

import O3.l;
import S2.q;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelQrCodeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p108t.InterfaceC1786s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements InterfaceC1786s {
    public static final j Companion = new j();
    private static final String TAG = "AndroidFlutterExcelUtils";
    private static BaseControlView curView;

    public static final void setCurrentView(BaseControlView baseControlView) {
        Companion.setCurrentView(baseControlView);
    }

    @Override // p108t.InterfaceC1786s
    public void readExcelInfo(String url, l callback) {
        E.f(url, "url");
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new q(url, callback, null));
    }

    @Override // p108t.InterfaceC1786s
    public void setCurrentElementExcelInfo(final String showContent, final String fileName, final String fileUrl, final boolean z6, final long j6) {
        E.f(showContent, "showContent");
        E.f(fileName, "fileName");
        E.f(fileUrl, "fileUrl");
        BaseControlView baseControlView = curView;
        if (baseControlView == null) {
            return;
        }
        if (baseControlView.elementType() == 5) {
            BaseControlView baseControlView2 = curView;
            E.c(baseControlView2);
            final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView2;
            final int i5 = 0;
            printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: s.i
                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                public final void run() {
                    switch (i5) {
                        case 0:
                            PrinterLabelTextView printerLabelTextView2 = (PrinterLabelTextView) printerLabelTextView;
                            printerLabelTextView2.setControlViewContent(showContent);
                            printerLabelTextView2.setExcelName(fileName);
                            printerLabelTextView2.setExcelUrl(fileUrl);
                            printerLabelTextView2.setShowTableHeader(z6);
                            printerLabelTextView2.setColumnIndex((int) j6);
                            break;
                        case 1:
                            PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) printerLabelTextView;
                            printerLabelBarCodeView.setControlViewContent(showContent);
                            printerLabelBarCodeView.setExcelName(fileName);
                            printerLabelBarCodeView.setExcelUrl(fileUrl);
                            printerLabelBarCodeView.setShowTableHeader(z6);
                            printerLabelBarCodeView.setColumnIndex((int) j6);
                            break;
                        default:
                            PrinterLabelQrCodeView printerLabelQrCodeView = (PrinterLabelQrCodeView) printerLabelTextView;
                            printerLabelQrCodeView.setControlViewContent(showContent);
                            printerLabelQrCodeView.setExcelName(fileName);
                            printerLabelQrCodeView.setExcelUrl(fileUrl);
                            printerLabelQrCodeView.setShowTableHeader(z6);
                            printerLabelQrCodeView.setColumnIndex((int) j6);
                            break;
                    }
                }
            });
            return;
        }
        BaseControlView baseControlView3 = curView;
        E.c(baseControlView3);
        if (baseControlView3.elementType() == 7) {
            BaseControlView baseControlView4 = curView;
            E.c(baseControlView4);
            final PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView4;
            final int i6 = 1;
            printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: s.i
                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                public final void run() {
                    switch (i6) {
                        case 0:
                            PrinterLabelTextView printerLabelTextView2 = (PrinterLabelTextView) printerLabelBarCodeView;
                            printerLabelTextView2.setControlViewContent(showContent);
                            printerLabelTextView2.setExcelName(fileName);
                            printerLabelTextView2.setExcelUrl(fileUrl);
                            printerLabelTextView2.setShowTableHeader(z6);
                            printerLabelTextView2.setColumnIndex((int) j6);
                            break;
                        case 1:
                            PrinterLabelBarCodeView printerLabelBarCodeView2 = (PrinterLabelBarCodeView) printerLabelBarCodeView;
                            printerLabelBarCodeView2.setControlViewContent(showContent);
                            printerLabelBarCodeView2.setExcelName(fileName);
                            printerLabelBarCodeView2.setExcelUrl(fileUrl);
                            printerLabelBarCodeView2.setShowTableHeader(z6);
                            printerLabelBarCodeView2.setColumnIndex((int) j6);
                            break;
                        default:
                            PrinterLabelQrCodeView printerLabelQrCodeView = (PrinterLabelQrCodeView) printerLabelBarCodeView;
                            printerLabelQrCodeView.setControlViewContent(showContent);
                            printerLabelQrCodeView.setExcelName(fileName);
                            printerLabelQrCodeView.setExcelUrl(fileUrl);
                            printerLabelQrCodeView.setShowTableHeader(z6);
                            printerLabelQrCodeView.setColumnIndex((int) j6);
                            break;
                    }
                }
            });
            return;
        }
        BaseControlView baseControlView5 = curView;
        E.c(baseControlView5);
        if (baseControlView5.elementType() == 8) {
            BaseControlView baseControlView6 = curView;
            E.c(baseControlView6);
            final PrinterLabelQrCodeView printerLabelQrCodeView = (PrinterLabelQrCodeView) baseControlView6;
            final int i7 = 2;
            printerLabelQrCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: s.i
                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                public final void run() {
                    switch (i7) {
                        case 0:
                            PrinterLabelTextView printerLabelTextView2 = (PrinterLabelTextView) printerLabelQrCodeView;
                            printerLabelTextView2.setControlViewContent(showContent);
                            printerLabelTextView2.setExcelName(fileName);
                            printerLabelTextView2.setExcelUrl(fileUrl);
                            printerLabelTextView2.setShowTableHeader(z6);
                            printerLabelTextView2.setColumnIndex((int) j6);
                            break;
                        case 1:
                            PrinterLabelBarCodeView printerLabelBarCodeView2 = (PrinterLabelBarCodeView) printerLabelQrCodeView;
                            printerLabelBarCodeView2.setControlViewContent(showContent);
                            printerLabelBarCodeView2.setExcelName(fileName);
                            printerLabelBarCodeView2.setExcelUrl(fileUrl);
                            printerLabelBarCodeView2.setShowTableHeader(z6);
                            printerLabelBarCodeView2.setColumnIndex((int) j6);
                            break;
                        default:
                            PrinterLabelQrCodeView printerLabelQrCodeView2 = (PrinterLabelQrCodeView) printerLabelQrCodeView;
                            printerLabelQrCodeView2.setControlViewContent(showContent);
                            printerLabelQrCodeView2.setExcelName(fileName);
                            printerLabelQrCodeView2.setExcelUrl(fileUrl);
                            printerLabelQrCodeView2.setShowTableHeader(z6);
                            printerLabelQrCodeView2.setColumnIndex((int) j6);
                            break;
                    }
                }
            });
        }
    }
}
