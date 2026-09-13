package io.flutter.plugin.platform;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewsControllerDelegator implements PlatformViewsAccessibilityDelegate, PlatformViewsChannel.PlatformViewsHandler {
    PlatformViewsController platformViewsController;
    PlatformViewsController2 platformViewsController2;

    public PlatformViewsControllerDelegator(PlatformViewsController platformViewsController, PlatformViewsController2 platformViewsController2) {
        this.platformViewsController = platformViewsController;
        this.platformViewsController2 = platformViewsController2;
    }

    public void attach(@Nullable Context context, @NonNull TextureRegistry textureRegistry, @NonNull DartExecutor dartExecutor) {
        this.platformViewsController.attach(context, textureRegistry, dartExecutor);
        this.platformViewsController2.attach(context, dartExecutor);
        this.platformViewsController.getPlatformViewsChannel().setPlatformViewsHandler(this);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(@NonNull AccessibilityBridge accessibilityBridge) {
        this.platformViewsController.attachAccessibilityBridge(accessibilityBridge);
        this.platformViewsController2.attachAccessibilityBridge(accessibilityBridge);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void clearFocus(int i5) {
        if (this.platformViewsController2.getPlatformViewById(i5) != null) {
            this.platformViewsController2.channelHandler.clearFocus(i5);
        } else {
            this.platformViewsController.channelHandler.clearFocus(i5);
        }
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void createForPlatformViewLayer(@NonNull PlatformViewCreationRequest platformViewCreationRequest) {
        this.platformViewsController.channelHandler.createForPlatformViewLayer(platformViewCreationRequest);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public long createForTextureLayer(@NonNull PlatformViewCreationRequest platformViewCreationRequest) {
        return this.platformViewsController.channelHandler.createForTextureLayer(platformViewCreationRequest);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void createPlatformViewHcpp(@NonNull PlatformViewCreationRequest platformViewCreationRequest) {
        this.platformViewsController2.channelHandler.createPlatformView(platformViewCreationRequest);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibilityBridge() {
        this.platformViewsController.detachAccessibilityBridge();
        this.platformViewsController2.detachAccessibilityBridge();
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void dispose(int i5) {
        if (this.platformViewsController2.getPlatformViewById(i5) != null) {
            this.platformViewsController2.channelHandler.dispose(i5);
        } else {
            this.platformViewsController.channelHandler.dispose(i5);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    @Nullable
    public View getPlatformViewById(int i5) {
        return this.platformViewsController2.getPlatformViewById(i5) != null ? this.platformViewsController2.getPlatformViewById(i5) : this.platformViewsController.getPlatformViewById(i5);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public boolean isHcppEnabled() {
        return this.platformViewsController2.isHcppEnabled();
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void offset(int i5, double d, double d6) {
        if (this.platformViewsController2.getPlatformViewById(i5) != null) {
            return;
        }
        this.platformViewsController.channelHandler.offset(i5, d, d6);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void onTouch(@NonNull PlatformViewTouch platformViewTouch) {
        if (this.platformViewsController2.getPlatformViewById(platformViewTouch.viewId) != null) {
            this.platformViewsController2.channelHandler.onTouch(platformViewTouch);
        } else {
            this.platformViewsController.channelHandler.onTouch(platformViewTouch);
        }
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void resize(@NonNull PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, @NonNull PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
        if (this.platformViewsController2.getPlatformViewById(platformViewResizeRequest.viewId) != null) {
            return;
        }
        this.platformViewsController.channelHandler.resize(platformViewResizeRequest, platformViewBufferResized);
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void setDirection(int i5, int i6) {
        if (this.platformViewsController2.getPlatformViewById(i5) != null) {
            this.platformViewsController2.channelHandler.setDirection(i5, i6);
        } else {
            this.platformViewsController.channelHandler.setDirection(i5, i6);
        }
    }

    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
    public void synchronizeToNativeViewHierarchy(boolean z6) {
        this.platformViewsController.channelHandler.synchronizeToNativeViewHierarchy(z6);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(int i5) {
        return this.platformViewsController2.getPlatformViewById(i5) != null ? this.platformViewsController2.usesVirtualDisplay(i5) : this.platformViewsController.usesVirtualDisplay(i5);
    }
}
