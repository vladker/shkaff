package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AbstractAuthorizeActivity extends FakeActivity {
    protected AuthorizeHelper helper;

    public AuthorizeHelper getHelper() {
        return this.helper;
    }

    public void show(AuthorizeHelper authorizeHelper) {
        this.helper = authorizeHelper;
        super.show(MobSDK.getContext(), null);
    }

    @Override // com.mob.tools.FakeActivity
    public void show(Context context, Intent intent) {
        throw new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
    }
}
