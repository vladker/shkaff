package com.library.base.frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends Fragment {
    protected FrameActivity context;
    protected boolean isInit = false;
    private boolean isRegister = false;
    protected View rootView;

    public FrameActivity getFrameActivity() {
        return (FrameActivity) getActivity();
    }

    public void gotoActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        getActivity().finish();
    }

    public void gotoActivityForResult(int i5, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, i5);
    }

    public void gotoActivityNotClose(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public abstract void initComponent();

    public abstract void initListener();

    public abstract int layoutId();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.isInit) {
            initComponent();
            this.isInit = true;
        }
        if (this.isRegister) {
            S4.d.b().j(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return setContentView(layoutInflater, layoutId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.isRegister) {
            S4.d.b().m(this);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initListener();
        refreshUI();
    }

    public abstract void refreshUI();

    public void registerEventBus() {
        this.isRegister = true;
    }

    public View setContentView(LayoutInflater layoutInflater, int i5) {
        if (this.rootView == null) {
            this.rootView = layoutInflater.inflate(i5, (ViewGroup) null);
        }
        ViewGroup viewGroup = (ViewGroup) this.rootView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.rootView);
        }
        return this.rootView;
    }
}
