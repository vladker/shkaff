package com.appdev.standard.page.webprint;

import A3.AbstractC0157z;
import W2.c;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import p068m0.b;
import p113u.d;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = "/app/web_print")
public class WebViewActivity extends AppCompatActivity {
    private ImageView backButton;
    private ImageView printButton;
    private EditText searchInput;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$captureWebViewAndSave$2() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.webView.getWidth(), this.webView.getHeight(), Bitmap.Config.ARGB_8888);
        this.webView.draw(new Canvas(bitmapCreateBitmap));
        saveBitmapToFile(bitmapCreateBitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        showPrintOptionsDialog();
    }

    private void saveBitmapToFile(Bitmap bitmap) {
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), AbstractC0157z.o("webview_screenshot_", String.valueOf(System.currentTimeMillis()), ".png"));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PICTURE_PRINT).withString("path", file.getAbsolutePath()).withBoolean("rotate", false).navigation();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save image", 0).show();
        }
    }

    private void showPrintOptionsDialog() {
        new b().show(getSupportFragmentManager(), "PrintDialog");
    }

    public void captureLongScreenshotAndSave() {
        Picture pictureCapturePicture = this.webView.capturePicture();
        if (pictureCapturePicture.getWidth() == 0 || pictureCapturePicture.getHeight() == 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
        pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
        saveBitmapToFile(bitmapCreateBitmap);
    }

    public void captureWebViewAndSave() {
        this.webView.postDelayed(new c(this, 9), 500L);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.webView;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.webView.goBack();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView.enableSlowWholeDocumentDraw();
        setContentView(e.activity_webview_print);
        this.webView = (WebView) findViewById(d.webview);
        this.backButton = (ImageView) findViewById(d.back_button);
        this.printButton = (ImageView) findViewById(d.print_button);
        this.searchInput = (EditText) findViewById(d.search_input);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.appdev.standard.page.webprint.WebViewActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return (str.startsWith("http://") || str.startsWith("https://")) ? false : true;
            }
        });
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: com.appdev.standard.page.webprint.WebViewActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i5) {
                super.onProgressChanged(webView, i5);
                S4.d dVar = S4.d.f672q;
                p051j0.a.c("EventBus", "onProgressChanged: 加载进度 = " + i5);
            }
        });
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra != null) {
            this.webView.loadUrl(stringExtra);
            this.searchInput.setText(stringExtra);
        } else {
            this.webView.loadUrl("https://www.baidu.com");
            this.searchInput.setText("https://www.baidu.com");
        }
        final int i5 = 0;
        this.backButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.webprint.a
            public final /* synthetic */ WebViewActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        this.b.lambda$onCreate$0(view);
                        break;
                    default:
                        this.b.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        final int i6 = 1;
        this.printButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.webprint.a
            public final /* synthetic */ WebViewActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        this.b.lambda$onCreate$0(view);
                        break;
                    default:
                        this.b.lambda$onCreate$1(view);
                        break;
                }
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.webView.clearHistory();
            ((ViewGroup) this.webView.getParent()).removeView(this.webView);
            this.webView.destroy();
            this.webView = null;
        }
        super.onDestroy();
    }
}
