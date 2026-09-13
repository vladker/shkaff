package com.appdev.standard.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.ListenerRemover;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import java.util.Map;

/* JADX INFO: renamed from: com.appdev.standard.dialog.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0463p extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2652a;
    public final Map b;
    public final androidx.activity.result.a c;
    public ListenerRemover d;

    public C0463p(String str, Map map, androidx.activity.result.a aVar) {
        this.f2652a = str;
        this.b = map;
        this.c = aVar;
    }

    public static void b(C0463p c0463p, Map map) {
        super.dismiss();
        androidx.activity.result.a aVar = c0463p.c;
        if (aVar == null || map.get("action") == null || !(map.get("action") instanceof String)) {
            return;
        }
        if (map.get("data") == null || !(map.get("data") instanceof Map)) {
            aVar.onClick((String) map.get("action"), null);
        } else {
            aVar.onClick((String) map.get("action"), (Map) map.get("data"));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        setStyle(0, p113u.h.FullScreenDialog);
        this.d = FlutterBoost.instance().addEventListener("onDialogClick", new C0458k(this, 1));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(p113u.e.dialog_flutter, (ViewGroup) null);
        FlutterBoostFragment.CachedEngineFragmentBuilder cachedEngineFragmentBuilderUrl = new FlutterBoostFragment.CachedEngineFragmentBuilder(FlutterBoostFragment.class).shouldAttachEngineToActivity(false).url(this.f2652a);
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
        for (Fragment fragment : getParentFragmentManager().getFragments()) {
            if (fragment instanceof FlutterBoostFragment) {
                ((FlutterBoostFragment) fragment).onHiddenChanged(false);
            }
        }
    }
}
