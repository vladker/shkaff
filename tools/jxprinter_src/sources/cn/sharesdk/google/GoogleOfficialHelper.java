package cn.sharesdk.google;

import android.content.Intent;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class GoogleOfficialHelper extends FakeActivity {
    private static final int RC_SIGN_IN = 17;
    private PlatformActionListener actionListener;
    private GoogleSignInClient mGoogleSignInClient;
    private Platform platform;

    public GoogleOfficialHelper(PlatformActionListener platformActionListener, Platform platform) {
        try {
            platform.getDevinfo("ClientID");
            this.mGoogleSignInClient = GoogleSignIn.getClient(MobSDK.getContext(), new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestProfile().requestId().build());
            this.actionListener = platformActionListener;
            this.platform = platform;
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("Googleplus GoogleOfficialHelper catch: ", th), new Object[0]);
            finish();
        }
    }

    private void handleSignInResult(final Task<GoogleSignInAccount> task) {
        new Thread() { // from class: cn.sharesdk.google.GoogleOfficialHelper.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) task.getResult(ApiException.class);
                    String idToken = googleSignInAccount.getIdToken();
                    String displayName = googleSignInAccount.getDisplayName();
                    String email = googleSignInAccount.getEmail();
                    String familyName = googleSignInAccount.getFamilyName();
                    String givenName = googleSignInAccount.getGivenName();
                    String id = googleSignInAccount.getId();
                    String strValueOf = String.valueOf(googleSignInAccount.getPhotoUrl());
                    String strValueOf2 = String.valueOf(googleSignInAccount.getRequestedScopes());
                    if (GoogleOfficialHelper.this.platform.getDb() == null) {
                        SSDKLog.b().a(" handleSignInResult platform.getDb() is null");
                        return;
                    }
                    GoogleOfficialHelper.this.platform.getDb().put("nickname", displayName);
                    GoogleOfficialHelper.this.platform.getDb().put("email", email);
                    GoogleOfficialHelper.this.platform.getDb().put("family_name", familyName);
                    GoogleOfficialHelper.this.platform.getDb().put("given_name", givenName);
                    GoogleOfficialHelper.this.platform.getDb().put("requestedScopes", strValueOf2);
                    GoogleOfficialHelper.this.platform.getDb().put("picture", strValueOf);
                    GoogleOfficialHelper.this.platform.getDb().putUserId(id);
                    GoogleOfficialHelper.this.platform.getDb().put("isSigin", "true");
                    GoogleOfficialHelper.this.platform.getDb().putToken(idToken);
                    GoogleOfficialHelper.this.platform.getDb().put("idToken", idToken);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("nickname", displayName);
                    map.put("email", email);
                    map.put("family_name", familyName);
                    map.put("given_name", givenName);
                    map.put("requestedScopes", strValueOf2);
                    map.put("picture", strValueOf);
                    map.put("id", id);
                    map.put("token", idToken);
                    if (GoogleOfficialHelper.this.actionListener != null) {
                        GoogleOfficialHelper.this.actionListener.onComplete(GoogleOfficialHelper.this.platform, 8, map);
                    }
                } catch (Throwable th) {
                    if (GoogleOfficialHelper.this.actionListener != null) {
                        GoogleOfficialHelper.this.actionListener.onError(GoogleOfficialHelper.this.platform, 8, th);
                    }
                    SSDKLog.b().a(androidx.exifinterface.media.a.n("Googleplus GoogleOfficialHelper handleSignInResult catch: ", th), new Object[0]);
                }
            }
        }.start();
    }

    private void signIn() {
        try {
            startActivityForResult(this.mGoogleSignInClient.getSignInIntent(), 17);
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("Googleplus GoogleOfficialHelper signIn catch: ", th), new Object[0]);
            finish();
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i5, int i6, Intent intent) {
        finish();
        SSDKLog.b().a("GoogleOfficialHelper onActivityResult");
        super.onActivityResult(i5, i6, intent);
        try {
            if (i5 == 17) {
                handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
            } else {
                SSDKLog.b().a("Googleplus GoogleOfficialHelper onActivityResult else");
            }
        } catch (Throwable th) {
            SSDKLog.b().a(androidx.exifinterface.media.a.n("Googleplus GoogleOfficialHelper onActivityResult catch: ", th), new Object[0]);
            PlatformActionListener platformActionListener = this.actionListener;
            if (platformActionListener != null) {
                platformActionListener.onError(this.platform, 8, th);
            }
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        SSDKLog.b().a("Googleplus onCreate");
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e) {
            SSDKLog.b().a("Googleplus GoogleOfficialHelper onCreate catch: " + e, new Object[0]);
        }
        signIn();
    }

    @Override // com.mob.tools.FakeActivity
    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().a("Googleplus onDestroy");
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SSDKLog.b().a("Googleplus onNewIntent");
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        super.onPause();
        SSDKLog.b().a("Googleplus onPause");
    }

    @Override // com.mob.tools.FakeActivity
    public void onRestart() {
        super.onRestart();
        SSDKLog.b().a("Googleplus onRestart");
    }

    @Override // com.mob.tools.FakeActivity
    public void onResume() {
        super.onResume();
        SSDKLog.b().a("Googleplus onResume");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStart() {
        super.onStart();
        SSDKLog.b().a("Googleplus onStart");
    }

    @Override // com.mob.tools.FakeActivity
    public void onStop() {
        super.onStop();
        SSDKLog.b().a("Googleplus onStop");
    }
}
