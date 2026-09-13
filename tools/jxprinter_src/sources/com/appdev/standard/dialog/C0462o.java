package com.appdev.standard.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.ListenerRemover;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.appdev.standard.dialog.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0462o extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2650a;
    public Map b;
    public final InterfaceC0461n c;
    public ListenerRemover d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2651f = true;

    public C0462o(String str, int i5, Map map, InterfaceC0461n interfaceC0461n) {
        this.f2650a = str;
        this.b = map;
        this.c = interfaceC0461n;
        this.e = i5;
    }

    public static void b(C0462o c0462o, Map map) {
        super.dismiss();
        InterfaceC0461n interfaceC0461n = c0462o.c;
        if (interfaceC0461n == null || map.get("action") == null || !(map.get("action") instanceof String)) {
            return;
        }
        if (map.get("data") == null || !(map.get("data") instanceof Map)) {
            interfaceC0461n.onClick((String) map.get("action"), null);
        } else {
            interfaceC0461n.onClick((String) map.get("action"), (Map) map.get("data"));
        }
    }

    public static void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if ((fragment instanceof FlutterBoostFragment) && fragment.isVisible()) {
                ((FlutterBoostFragment) fragment).onHiddenChanged(false);
            }
            c(fragment.getChildFragmentManager().getFragments());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.d = FlutterBoost.instance().addEventListener("onDialogClick", new C0458k(this, 0));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(p113u.e.dialog_flutter_container, (ViewGroup) null);
        FlutterBoostFragment.CachedEngineFragmentBuilder cachedEngineFragmentBuilderUrl = new FlutterBoostFragment.CachedEngineFragmentBuilder(FlutterBoostFragment.class).shouldAttachEngineToActivity(false).url(this.f2650a);
        Map<String, Object> map = this.b;
        if (map != null) {
            cachedEngineFragmentBuilderUrl.urlParams(map);
        }
        getChildFragmentManager().beginTransaction().add(p113u.d.fl_flutter, cachedEngineFragmentBuilderUrl.build()).commit();
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        ListenerRemover listenerRemover = this.d;
        if (listenerRemover != null) {
            listenerRemover.remove();
        }
        c(getParentFragmentManager().getFragments());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!this.f2651f) {
            getDialog().setOnShowListener(new DialogInterfaceOnShowListenerC0459l());
        }
        View viewFindViewById = getDialog().findViewById(p113u.d.flutter_bottom_sheet);
        viewFindViewById.getLayoutParams().height = Math.round(this.e * getActivity().getResources().getDisplayMetrics().density);
        viewFindViewById.requestLayout();
    }
}
