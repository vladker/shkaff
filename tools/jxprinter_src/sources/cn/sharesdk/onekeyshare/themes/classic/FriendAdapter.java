package cn.sharesdk.onekeyshare.themes.classic;

import A3.AbstractC0157z;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class FriendAdapter extends PullToRequestListAdapter implements PlatformActionListener {
    private FriendListPage activity;
    private int curPage;
    private ArrayList<Following> follows;
    private boolean hasNext;
    private PRTHeader llHeader;
    private HashMap<String, Boolean> map;
    private final int pageCount;
    private Platform platform;
    private float ratio;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FollowersResult {
        public boolean hasNextPage;
        public ArrayList<Following> list;

        private FollowersResult() {
            this.hasNextPage = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Following {
        public String atName;
        public boolean checked;
        public String description;
        public String icon;
        public String screenName;
        public String uid;
    }

    public FriendAdapter(FriendListPage friendListPage, PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.pageCount = 15;
        this.activity = friendListPage;
        this.curPage = -1;
        this.hasNext = true;
        this.map = new HashMap<>();
        this.follows = new ArrayList<>();
        getListView().setDivider(new ColorDrawable(-1381654));
    }

    private void next() {
        if (this.hasNext) {
            this.platform.listFriend(15, this.curPage + 1, null);
        }
    }

    private FollowersResult parseFollowers(String str, HashMap<String, Object> map, HashMap<String, Boolean> map2) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        ArrayList<Following> arrayList = new ArrayList<>();
        boolean z6 = true;
        boolean zContainsKey = false;
        int i5 = 0;
        int i6 = 0;
        zContainsKey = false;
        if (!"SinaWeibo".equals(str)) {
            if ("TencentWeibo".equals(str)) {
                z6 = ((Integer) map.get("hasnext")).intValue() == 0;
                ArrayList arrayList2 = (ArrayList) map.get("info");
                int size = arrayList2.size();
                while (i5 < size) {
                    Object obj = arrayList2.get(i5);
                    i5++;
                    HashMap map3 = (HashMap) obj;
                    String strValueOf = String.valueOf(map3.get("name"));
                    if (!map2.containsKey(strValueOf)) {
                        Following following = new Following();
                        following.screenName = String.valueOf(map3.get("nick"));
                        following.uid = strValueOf;
                        following.atName = strValueOf;
                        Iterator it = ((ArrayList) map3.get("tweet")).iterator();
                        if (it.hasNext()) {
                            following.description = String.valueOf(((HashMap) it.next()).get("text"));
                        }
                        following.icon = String.valueOf(map3.get("head")).concat("/100");
                        map2.put(following.uid, Boolean.TRUE);
                        arrayList.add(following);
                    }
                }
            } else if ("Facebook".equals(str)) {
                ArrayList arrayList3 = (ArrayList) map.get("data");
                int size2 = arrayList3.size();
                while (i6 < size2) {
                    Object obj2 = arrayList3.get(i6);
                    i6++;
                    HashMap map4 = (HashMap) obj2;
                    String strValueOf2 = String.valueOf(map4.get("id"));
                    if (!map2.containsKey(strValueOf2)) {
                        Following following2 = new Following();
                        following2.uid = strValueOf2;
                        following2.atName = AbstractC0157z.o("[", strValueOf2, "]");
                        following2.screenName = String.valueOf(map4.get("name"));
                        HashMap map5 = (HashMap) map4.get("picture");
                        if (map5 != null) {
                            following2.icon = String.valueOf(((HashMap) map5.get("data")).get("url"));
                        }
                        map2.put(following2.uid, Boolean.TRUE);
                        arrayList.add(following2);
                    }
                }
                zContainsKey = ((HashMap) map.get("paging")).containsKey("next");
            } else if ("Twitter".equals(str)) {
                ArrayList arrayList4 = (ArrayList) map.get("users");
                int size3 = arrayList4.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj3 = arrayList4.get(i7);
                    i7++;
                    HashMap map6 = (HashMap) obj3;
                    String strValueOf3 = String.valueOf(map6.get(FirebaseAnalytics.Param.SCREEN_NAME));
                    if (!map2.containsKey(strValueOf3)) {
                        Following following3 = new Following();
                        following3.uid = strValueOf3;
                        following3.atName = strValueOf3;
                        following3.screenName = String.valueOf(map6.get("name"));
                        following3.description = String.valueOf(map6.get("description"));
                        following3.icon = String.valueOf(map6.get("profile_image_url"));
                        map2.put(following3.uid, Boolean.TRUE);
                        arrayList.add(following3);
                    }
                }
            }
            FollowersResult followersResult = new FollowersResult();
            followersResult.list = arrayList;
            followersResult.hasNextPage = zContainsKey;
            return followersResult;
        }
        ArrayList arrayList5 = (ArrayList) map.get("users");
        int size4 = arrayList5.size();
        int i8 = 0;
        while (i8 < size4) {
            Object obj4 = arrayList5.get(i8);
            i8++;
            HashMap map7 = (HashMap) obj4;
            String strValueOf4 = String.valueOf(map7.get("id"));
            if (!map2.containsKey(strValueOf4)) {
                Following following4 = new Following();
                following4.uid = strValueOf4;
                following4.screenName = String.valueOf(map7.get("name"));
                following4.description = String.valueOf(map7.get("description"));
                following4.icon = String.valueOf(map7.get("profile_image_url"));
                following4.atName = following4.screenName;
                map2.put(following4.uid, Boolean.TRUE);
                arrayList.add(following4);
            }
        }
        if (((Integer) map.get("total_number")).intValue() <= map2.size()) {
            z6 = false;
        }
        zContainsKey = z6;
        FollowersResult followersResult2 = new FollowersResult();
        followersResult2.list = arrayList;
        followersResult2.hasNextPage = zContainsKey;
        return followersResult2;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public int getCount() {
        ArrayList<Following> arrayList = this.follows;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getFooterView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(10);
        return linearLayout;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getHeaderView() {
        if (this.llHeader == null) {
            this.llHeader = new PRTHeader(getContext());
        }
        return this.llHeader;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public long getItemId(int i5) {
        return i5;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FriendListItem(viewGroup.getContext(), this.ratio);
        }
        ((FriendListItem) view).update(getItem(i5), isFling());
        if (i5 == getCount() - 1) {
            next();
        }
        return view;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i5) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                FriendAdapter.this.activity.finish();
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i5, HashMap<String, Object> map) {
        final FollowersResult followers = parseFollowers(this.platform.getName(), map, this.map);
        if (followers == null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FriendAdapter.this.notifyDataSetChanged();
                    return false;
                }
            });
            return;
        }
        this.hasNext = followers.hasNextPage;
        ArrayList<Following> arrayList = followers.list;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.curPage++;
        Message message = new Message();
        message.what = 1;
        message.obj = followers.list;
        UIHandler.sendMessage(message, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message2) {
                if (FriendAdapter.this.curPage <= 0) {
                    FriendAdapter.this.follows.clear();
                }
                FriendAdapter.this.follows.addAll(followers.list);
                FriendAdapter.this.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i5, Throwable th) {
        th.printStackTrace();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onPullDown(int i5) {
        this.llHeader.onPullDown(i5);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onRefresh() {
        this.llHeader.onRequest();
        this.curPage = -1;
        this.hasNext = true;
        this.map.clear();
        next();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onReversed() {
        this.llHeader.reverse();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        getListView().setOnItemClickListener(onItemClickListener);
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
        platform.setPlatformActionListener(this);
    }

    public void setRatio(float f6) {
        this.ratio = f6;
        ListView listView = getListView();
        if (f6 < 1.0f) {
            f6 = 1.0f;
        }
        listView.setDividerHeight((int) f6);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public Following getItem(int i5) {
        return this.follows.get(i5);
    }
}
