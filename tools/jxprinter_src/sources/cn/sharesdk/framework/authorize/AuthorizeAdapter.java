package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.TitleLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AuthorizeAdapter {
    private Activity activity;
    private boolean noTitle;
    private String platform;
    private boolean popUpAnimationDisable;
    private RelativeLayout rlBody;
    private TitleLayout title;
    private WebView webview;

    public void disablePopUpAnimation() {
        this.popUpAnimationDisable = true;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public RelativeLayout getBodyView() {
        return this.rlBody;
    }

    public String getPlatformName() {
        return this.platform;
    }

    public TitleLayout getTitleLayout() {
        return this.title;
    }

    public WebView getWebBody() {
        return this.webview;
    }

    public void hideShareSDKLogo() {
        getTitleLayout().getChildAt(getTitleLayout().getChildCount() - 1).setVisibility(8);
    }

    public boolean isNotitle() {
        return this.noTitle;
    }

    public boolean isPopUpAnimationDisable() {
        return this.popUpAnimationDisable;
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i5, KeyEvent keyEvent) {
        return false;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setBodyView(RelativeLayout relativeLayout) {
        this.rlBody = relativeLayout;
    }

    public void setNotitle(boolean z6) {
        this.noTitle = z6;
    }

    public void setPlatformName(String str) {
        this.platform = str;
    }

    public void setTitleView(TitleLayout titleLayout) {
        this.title = titleLayout;
    }

    public void setWebView(WebView webView) {
        this.webview = webView;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onResize(int i5, int i6, int i7, int i8) {
    }
}
