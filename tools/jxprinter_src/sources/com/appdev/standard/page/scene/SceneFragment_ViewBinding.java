package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SceneFragment_ViewBinding implements Unbinder {
    private SceneFragment target;
    private View view1578;
    private View view1579;
    private View view157a;
    private View view157b;

    @UiThread
    public SceneFragment_ViewBinding(final SceneFragment sceneFragment, View view) {
        this.target = sceneFragment;
        sceneFragment.rvSceneType = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_scene_type, "field 'rvSceneType'", RecyclerView.class);
        sceneFragment.flSceneView = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_scene_view, "field 'flSceneView'", FrameLayout.class);
        int i5 = p113u.d.ll_scene_add;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'llSceneAdd' and method 'onSceneAddClick'");
        sceneFragment.llSceneAdd = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'llSceneAdd'", LinearLayout.class);
        this.view1578 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.SceneFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                sceneFragment.onSceneAddClick(view2);
            }
        });
        int i6 = p113u.d.ll_scene_select;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'llSceneSelect' and method 'onSceneSelectClick'");
        sceneFragment.llSceneSelect = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'llSceneSelect'", LinearLayout.class);
        this.view157a = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.SceneFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                sceneFragment.onSceneSelectClick(view2);
            }
        });
        sceneFragment.tvManageButton = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_manage_button, "field 'tvManageButton'", TextView.class);
        int i7 = p113u.d.ll_scene_team_members_add;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'llSceneTeamMembersAdd' and method 'onSceneTeamMembersAddClick'");
        sceneFragment.llSceneTeamMembersAdd = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'llSceneTeamMembersAdd'", LinearLayout.class);
        this.view157b = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.SceneFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                sceneFragment.onSceneTeamMembersAddClick(view2);
            }
        });
        int i8 = p113u.d.ll_scene_log_out_team;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'llSceneLogOutTeam' and method 'onSceneLogOutTeamClick'");
        sceneFragment.llSceneLogOutTeam = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'llSceneLogOutTeam'", LinearLayout.class);
        this.view1579 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.scene.SceneFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                sceneFragment.onSceneLogOutTeamClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SceneFragment sceneFragment = this.target;
        if (sceneFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        sceneFragment.rvSceneType = null;
        sceneFragment.flSceneView = null;
        sceneFragment.llSceneAdd = null;
        sceneFragment.llSceneSelect = null;
        sceneFragment.tvManageButton = null;
        sceneFragment.llSceneTeamMembersAdd = null;
        sceneFragment.llSceneLogOutTeam = null;
        this.view1578.setOnClickListener(null);
        this.view1578 = null;
        this.view157a.setOnClickListener(null);
        this.view157a = null;
        this.view157b.setOnClickListener(null);
        this.view157b = null;
        this.view1579.setOnClickListener(null);
        this.view1579 = null;
    }
}
