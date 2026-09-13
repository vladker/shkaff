package cn.sharesdk.facebook;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.mob.tools.FakeActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class FacebookOfficialShareWebPage extends FakeActivity implements FacebookCallback<Sharer.Result> {
    private PlatformActionListener actionListener;
    private CallbackManager callbackManager;
    private Platform platform;
    private ShareDialog shareDialog;

    public FacebookOfficialShareWebPage(Platform platform, PlatformActionListener platformActionListener) {
        try {
            this.platform = platform;
            this.actionListener = platformActionListener;
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("FacebookOfficialShare catch ", th), new Object[0]);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i5, int i6, Intent intent) {
        this.callbackManager.onActivityResult(i5, i6, intent);
        super.onActivityResult(i5, i6, intent);
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this.platform, 9);
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e) {
            SSDKLog.b().a(e);
        }
        SSDKLog.b().a("FacebookOfficialHelper onCreate");
        this.callbackManager = CallbackManager.Factory.create();
        ShareDialog shareDialog = new ShareDialog(this.activity);
        this.shareDialog = shareDialog;
        shareDialog.registerCallback(this.callbackManager, this);
        Intent intent = this.activity.getIntent();
        String stringExtra = intent.getStringExtra(Facebook.PARAMS_LINKURL);
        String stringExtra2 = intent.getStringExtra(Facebook.PARAMS_HASHTAG);
        String stringExtra3 = intent.getStringExtra(Facebook.PARAMS_QUOTE);
        SSDKLog sSDKLogB = SSDKLog.b();
        StringBuilder sbU = androidx.collection.a.u("Share params url is: ", stringExtra, " hashtag: ", stringExtra2, " quote: ");
        sbU.append(stringExtra3);
        sSDKLogB.a(sbU.toString());
        shareLinkOfficial(stringExtra, stringExtra2, stringExtra3);
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().a("FacebookOfficialShareWebPage onDestroy");
    }

    public void onError(FacebookException facebookException) {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onError(this.platform, 9, facebookException);
        }
        finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().a("FacebookOfficialShareWebPage onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().a("FacebookOfficialShareWebPage onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().a("FacebookOfficialShareWebPage onStop");
    }

    public void shareLinkOfficial(String str, String str2, String str3) {
        ShareLinkContent shareLinkContentBuild;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    shareLinkContentBuild = new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setShareHashtag(new ShareHashtag.Builder().setHashtag(str2).build()).setQuote(str3).build();
                } else if (TextUtils.isEmpty(str2)) {
                    shareLinkContentBuild = !TextUtils.isEmpty(str3) ? new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setQuote(str3).build() : new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).build();
                } else {
                    shareLinkContentBuild = new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setShareHashtag(new ShareHashtag.Builder().setHashtag(str2).build()).build();
                }
                if (!ShareDialog.canShow(ShareLinkContent.class)) {
                    PlatformActionListener platformActionListener = this.actionListener;
                    if (platformActionListener != null) {
                        platformActionListener.onError(this.platform, 9, new Throwable("ShareDialog.canShow(ShareLinkContent.class) is false, are you login first?"));
                        finish();
                        return;
                    }
                    return;
                }
                ShareDialog shareDialog = this.shareDialog;
                if (shareDialog != null) {
                    shareDialog.show(shareLinkContentBuild);
                    return;
                }
                PlatformActionListener platformActionListener2 = this.actionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this.platform, 9, new Throwable("shareDialog is null"));
                    finish();
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                PlatformActionListener platformActionListener3 = this.actionListener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onError(this.platform, 9, new Throwable("share link params is null"));
                    finish();
                    return;
                }
                return;
            }
            if (!ShareDialog.canShow(ShareLinkContent.class)) {
                PlatformActionListener platformActionListener4 = this.actionListener;
                if (platformActionListener4 != null) {
                    platformActionListener4.onError(this.platform, 9, new Throwable("ShareDialog.canShow(ShareLinkContent.class) is false, are you login first?"));
                    finish();
                    return;
                }
                return;
            }
            ShareLinkContent shareLinkContentBuild2 = new ShareLinkContent.Builder().setContentUrl(Uri.parse(str)).setShareHashtag(new ShareHashtag.Builder().setHashtag(str2).build()).build();
            ShareDialog shareDialog2 = this.shareDialog;
            if (shareDialog2 != null) {
                shareDialog2.show(shareLinkContentBuild2);
                return;
            }
            PlatformActionListener platformActionListener5 = this.actionListener;
            if (platformActionListener5 != null) {
                platformActionListener5.onError(this.platform, 9, new Throwable("shareDialog is null"));
                finish();
            }
        } catch (Throwable th) {
            SSDKLog.b().a("shareLinkOfficial catch ");
            PlatformActionListener platformActionListener6 = this.actionListener;
            if (platformActionListener6 != null) {
                platformActionListener6.onError(this.platform, 9, th);
            }
            finish();
        }
    }

    public void onSuccess(Sharer.Result result) {
        PlatformActionListener platformActionListener = this.actionListener;
        if (platformActionListener != null) {
            platformActionListener.onComplete(this.platform, 9, null);
        }
        finish();
    }
}
