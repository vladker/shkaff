package com.appdev.standard.page.mine;

import android.os.AsyncTask;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.github.barteksc.pdfviewer.PDFView;
import com.library.base.frame.MvpActivity;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.jvm.internal.Y;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PDF_VIEW)
public class PDFViewActivity extends MvpActivity {

    @BindView(5687)
    PDFView pdfvMain;

    @Autowired(name = "title")
    String title;

    @BindView(6274)
    TextView tvTitle;

    @Autowired(name = "url")
    String url;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class RetrievePdfStream extends AsyncTask<String, Void, InputStream> {
        public RetrievePdfStream() {
        }

        @Override // android.os.AsyncTask
        public InputStream doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                if (httpURLConnection.getResponseCode() == 200) {
                    return new BufferedInputStream(httpURLConnection.getInputStream());
                }
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(InputStream inputStream) {
            w.c();
            PDFView pDFView = PDFViewActivity.this.pdfvMain;
            pDFView.getClass();
            J1.c cVar = new J1.c();
            cVar.f351a = inputStream;
            new PDFView.a(pDFView, cVar, 0).a();
        }
    }

    private void displayFromUrl(String str) {
        new RetrievePdfStream().execute(str);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_231));
        if (Y.f(this.url)) {
            finish();
        } else {
            w.e();
            displayFromUrl(this.url);
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_pdfview;
    }
}
