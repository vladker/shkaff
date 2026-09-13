package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PDFPrintActivity_ViewBinding implements Unbinder {
    private PDFPrintActivity target;

    @UiThread
    public PDFPrintActivity_ViewBinding(PDFPrintActivity pDFPrintActivity) {
        this(pDFPrintActivity, pDFPrintActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PDFPrintActivity pDFPrintActivity = this.target;
        if (pDFPrintActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        pDFPrintActivity.tvTitle = null;
        pDFPrintActivity.rvPdfPrintData = null;
        pDFPrintActivity.tvPdfPrintDataCount = null;
        pDFPrintActivity.qswPdfPrintPrintCount = null;
        pDFPrintActivity.qswPdfPrintPrintStart = null;
        pDFPrintActivity.qswPdfPrintPrintEnd = null;
        pDFPrintActivity.qswPdfPrintPrintWidth = null;
        pDFPrintActivity.qswPdfPrintPrintHeight = null;
        pDFPrintActivity.rbPicturePrintScaleTypeFitXY = null;
        pDFPrintActivity.rbPicturePrintScaleTypeCenterInside = null;
        pDFPrintActivity.rbPicturePrintRotate0 = null;
        pDFPrintActivity.rbPicturePrintRotate90 = null;
        pDFPrintActivity.rbPicturePrintText = null;
        pDFPrintActivity.rbPicturePrintImageText = null;
        pDFPrintActivity.rbPicturePrintAuto = null;
    }

    @UiThread
    public PDFPrintActivity_ViewBinding(PDFPrintActivity pDFPrintActivity, View view) {
        this.target = pDFPrintActivity;
        pDFPrintActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        pDFPrintActivity.rvPdfPrintData = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_pdf_print_data, "field 'rvPdfPrintData'", RecyclerView.class);
        pDFPrintActivity.tvPdfPrintDataCount = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_pdf_print_data_count, "field 'tvPdfPrintDataCount'", TextView.class);
        pDFPrintActivity.qswPdfPrintPrintCount = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_count, "field 'qswPdfPrintPrintCount'", QuantitySelectorWidget.class);
        pDFPrintActivity.qswPdfPrintPrintStart = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_start, "field 'qswPdfPrintPrintStart'", QuantitySelectorWidget.class);
        pDFPrintActivity.qswPdfPrintPrintEnd = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_end, "field 'qswPdfPrintPrintEnd'", QuantitySelectorWidget.class);
        pDFPrintActivity.qswPdfPrintPrintWidth = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_width, "field 'qswPdfPrintPrintWidth'", QuantitySelectorWidget.class);
        pDFPrintActivity.qswPdfPrintPrintHeight = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_pdf_print_print_height, "field 'qswPdfPrintPrintHeight'", QuantitySelectorWidget.class);
        pDFPrintActivity.rbPicturePrintScaleTypeFitXY = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_scale_type_fitXY, "field 'rbPicturePrintScaleTypeFitXY'", RadioButton.class);
        pDFPrintActivity.rbPicturePrintScaleTypeCenterInside = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_scale_type_centerInside, "field 'rbPicturePrintScaleTypeCenterInside'", RadioButton.class);
        pDFPrintActivity.rbPicturePrintRotate0 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_rotate_0, "field 'rbPicturePrintRotate0'", RadioButton.class);
        pDFPrintActivity.rbPicturePrintRotate90 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_rotate_90, "field 'rbPicturePrintRotate90'", RadioButton.class);
        pDFPrintActivity.rbPicturePrintText = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_text_mode, "field 'rbPicturePrintText'", RadioButton.class);
        pDFPrintActivity.rbPicturePrintImageText = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_image_text_mode, "field 'rbPicturePrintImageText'", RadioButton.class);
        pDFPrintActivity.rbPicturePrintAuto = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_auto_mode, "field 'rbPicturePrintAuto'", RadioButton.class);
    }
}
