package com.appdev.standard.page.bluetooth;

import S4.k;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.appdev.constant.DefaultRouteConstant;
import org.greenrobot.eventbus.ThreadMode;
import p134x2.E;
import p137y.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CurrentPrinterFragment extends com.library.base.frame.f {

    @BindView(6247)
    TextView tvPrintPrintName;

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        if (E.n()) {
            this.tvPrintPrintName.setText(p051j0.f.getPrintDeviceName());
        } else {
            this.tvPrintPrintName.setText(getString(p113u.g.text_49));
        }
        this.tvPrintPrintName.setOnClickListener(new b(this, 1));
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_current_printer;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(i iVar) {
        int i5 = iVar.f9014a;
        if (i5 == 1) {
            this.tvPrintPrintName.setText(p051j0.f.getPrintDeviceName());
        } else if (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) {
            this.tvPrintPrintName.setText(getString(p113u.g.text_49));
        }
    }

    public void onPrintInfoClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
