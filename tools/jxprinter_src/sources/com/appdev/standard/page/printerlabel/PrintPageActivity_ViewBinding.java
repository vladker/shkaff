package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrintPageActivity_ViewBinding implements Unbinder {
    private PrintPageActivity target;

    @UiThread
    public PrintPageActivity_ViewBinding(PrintPageActivity printPageActivity) {
        this(printPageActivity, printPageActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PrintPageActivity printPageActivity = this.target;
        if (printPageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        printPageActivity.tvTemplateEditLabelName = null;
        printPageActivity.tvTemplateEditLabelSpecifications = null;
        printPageActivity.tpvPrintPageView = null;
        printPageActivity.rbPrintPageDirection0 = null;
        printPageActivity.rbPrintPageDirection90 = null;
        printPageActivity.rbPrintPageDirection180 = null;
        printPageActivity.sqlPrintPageCount = null;
        printPageActivity.tvPrintPagePrint = null;
        printPageActivity.rbPicturePrintNoMirror = null;
        printPageActivity.rbPicturePrintMirror = null;
        printPageActivity.ivPicPrintNoMirror = null;
        printPageActivity.ivPicPrintMirror = null;
    }

    @UiThread
    public PrintPageActivity_ViewBinding(PrintPageActivity printPageActivity, View view) {
        this.target = printPageActivity;
        printPageActivity.tvTemplateEditLabelName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_template_edit_label_name, "field 'tvTemplateEditLabelName'", TextView.class);
        printPageActivity.tvTemplateEditLabelSpecifications = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_template_edit_label_specifications, "field 'tvTemplateEditLabelSpecifications'", TextView.class);
        printPageActivity.tpvPrintPageView = (TemplatePageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tpv_print_page_view, "field 'tpvPrintPageView'", TemplatePageView.class);
        printPageActivity.rbPrintPageDirection0 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_print_page_direction_0, "field 'rbPrintPageDirection0'", RadioButton.class);
        printPageActivity.rbPrintPageDirection90 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_print_page_direction_90, "field 'rbPrintPageDirection90'", RadioButton.class);
        printPageActivity.rbPrintPageDirection180 = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_print_page_direction_180, "field 'rbPrintPageDirection180'", RadioButton.class);
        printPageActivity.sqlPrintPageCount = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.sql_print_page_count, "field 'sqlPrintPageCount'", QuantitySelectorWidget.class);
        printPageActivity.tvPrintPagePrint = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_print_page_print, "field 'tvPrintPagePrint'", TextView.class);
        printPageActivity.rbPicturePrintNoMirror = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_no_mirror, "field 'rbPicturePrintNoMirror'", RadioButton.class);
        printPageActivity.rbPicturePrintMirror = (RadioButton) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rb_picture_print_mirror, "field 'rbPicturePrintMirror'", RadioButton.class);
        printPageActivity.ivPicPrintNoMirror = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_pic_print_no_mirror, "field 'ivPicPrintNoMirror'", ImageView.class);
        printPageActivity.ivPicPrintMirror = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_pic_print_mirror, "field 'ivPicPrintMirror'", ImageView.class);
    }
}
