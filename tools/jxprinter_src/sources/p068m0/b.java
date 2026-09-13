package p068m0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appdev.standard.page.document.a;
import com.appdev.standard.page.webprint.WebViewActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import p113u.d;
import p113u.e;
import p113u.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class b extends BottomSheetDialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return h.CustomBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        final WebViewActivity webViewActivity = (WebViewActivity) getActivity();
        View viewInflate = layoutInflater.inflate(e.dialog_print_options, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(d.print_current_page);
        TextView textView2 = (TextView) viewInflate.findViewById(d.print_all_pages);
        TextView textView3 = (TextView) viewInflate.findViewById(d.cancel_print);
        final int i5 = 0;
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: m0.a
            public final /* synthetic */ b b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        b bVar = this.b;
                        WebViewActivity webViewActivity2 = webViewActivity;
                        if (webViewActivity2 != null) {
                            bVar.getClass();
                            webViewActivity2.captureWebViewAndSave();
                        }
                        bVar.dismiss();
                        break;
                    default:
                        b bVar2 = this.b;
                        WebViewActivity webViewActivity3 = webViewActivity;
                        if (webViewActivity3 != null) {
                            bVar2.getClass();
                            webViewActivity3.captureLongScreenshotAndSave();
                        }
                        bVar2.dismiss();
                        break;
                }
            }
        });
        final int i6 = 1;
        textView2.setOnClickListener(new View.OnClickListener(this) { // from class: m0.a
            public final /* synthetic */ b b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        b bVar = this.b;
                        WebViewActivity webViewActivity2 = webViewActivity;
                        if (webViewActivity2 != null) {
                            bVar.getClass();
                            webViewActivity2.captureWebViewAndSave();
                        }
                        bVar.dismiss();
                        break;
                    default:
                        b bVar2 = this.b;
                        WebViewActivity webViewActivity3 = webViewActivity;
                        if (webViewActivity3 != null) {
                            bVar2.getClass();
                            webViewActivity3.captureLongScreenshotAndSave();
                        }
                        bVar2.dismiss();
                        break;
                }
            }
        });
        textView3.setOnClickListener(new a(this, 3));
        return viewInflate;
    }
}
