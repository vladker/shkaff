package cn.sharesdk.framework;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CustomPlatform extends Platform {
    @Override // cn.sharesdk.framework.Platform
    public abstract boolean checkAuthorize(int i5, Object obj);

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i5, HashMap<String, Object> map) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public final cn.sharesdk.framework.a.b.j.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i5, int i6, String str) {
        return null;
    }

    public int getCustomPlatformId() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i5, int i6, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i5, int i6, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public abstract String getName();

    @Override // cn.sharesdk.framework.Platform
    public final int getPlatformId() {
        return -Math.abs(getCustomPlatformId());
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 0;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    @Override // cn.sharesdk.framework.Platform
    public final void setNetworkDevinfo() {
    }

    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
    }

    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
    }

    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
    }

    @Override // cn.sharesdk.framework.Platform
    public final void initDevInfo(String str) {
    }

    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
    }

    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i5, int i6, String str) {
    }

    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i5, int i6, String str) {
    }

    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i5, HashMap<String, Object> map, HashMap<String, String> map2) {
    }
}
