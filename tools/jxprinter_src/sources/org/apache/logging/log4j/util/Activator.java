package org.apache.logging.log4j.util;

import java.net.URL;
import java.security.Permission;
import java.util.Iterator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.status.StatusLogger;
import org.osgi.framework.AdaptPermission;
import org.osgi.framework.AdminPermission;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.SynchronousBundleListener;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleWiring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Activator implements BundleActivator, SynchronousBundleListener {
    private boolean lockingProviderUtil;
    private static final SecurityManager SECURITY_MANAGER = System.getSecurityManager();
    private static final Logger LOGGER = StatusLogger.getLogger();

    private static void checkPermission(Permission permission) {
        SecurityManager securityManager = SECURITY_MANAGER;
        if (securityManager != null) {
            securityManager.checkPermission(permission);
        }
    }

    private void loadProvider(Bundle bundle) {
        if (bundle.getState() == 1) {
            return;
        }
        try {
            checkPermission(new AdminPermission(bundle, "resource"));
            checkPermission(new AdaptPermission(BundleWiring.class.getName(), bundle, "adapt"));
            BundleContext bundleContext = bundle.getBundleContext();
            if (bundleContext == null) {
                LOGGER.debug("Bundle {} has no context (state={}), skipping loading provider", bundle.getSymbolicName(), toStateString(bundle.getState()));
            } else {
                loadProvider(bundleContext, (BundleWiring) bundle.adapt(BundleWiring.class));
            }
        } catch (SecurityException e) {
            LOGGER.debug("Cannot access bundle [{}] contents. Ignoring.", bundle.getSymbolicName(), e);
        } catch (Exception e6) {
            LOGGER.warn("Problem checking bundle {} for Log4j 2 provider.", bundle.getSymbolicName(), e6);
        }
    }

    private String toStateString(int i5) {
        if (i5 == 1) {
            return "UNINSTALLED";
        }
        if (i5 == 2) {
            return "INSTALLED";
        }
        if (i5 == 4) {
            return "RESOLVED";
        }
        if (i5 == 8) {
            return "STARTING";
        }
        if (i5 != 16) {
            return i5 != 32 ? Integer.toString(i5) : "ACTIVE";
        }
        return "STOPPING";
    }

    private void unlockIfReady() {
        if (!this.lockingProviderUtil || ProviderUtil.PROVIDERS.isEmpty()) {
            return;
        }
        ProviderUtil.STARTUP_LOCK.unlock();
        this.lockingProviderUtil = false;
    }

    public void bundleChanged(BundleEvent bundleEvent) {
        if (bundleEvent.getType() != 2) {
            return;
        }
        loadProvider(bundleEvent.getBundle());
        unlockIfReady();
    }

    public void start(BundleContext bundleContext) {
        ProviderUtil.STARTUP_LOCK.lock();
        this.lockingProviderUtil = true;
        Iterator it = ((BundleWiring) bundleContext.getBundle().adapt(BundleWiring.class)).getRequiredWires(LoggerContextFactory.class.getName()).iterator();
        while (it.hasNext()) {
            loadProvider(bundleContext, ((BundleWire) it.next()).getProviderWiring());
        }
        bundleContext.addBundleListener(this);
        for (Bundle bundle : bundleContext.getBundles()) {
            loadProvider(bundle);
        }
        unlockIfReady();
    }

    public void stop(BundleContext bundleContext) {
        bundleContext.removeBundleListener(this);
        unlockIfReady();
    }

    private void loadProvider(BundleContext bundleContext, BundleWiring bundleWiring) {
        try {
            Iterator it = bundleContext.getServiceReferences(Provider.class, "(APIVersion>=2.6.0)").iterator();
            Provider provider = null;
            while (it.hasNext()) {
                Provider provider2 = (Provider) bundleContext.getService((ServiceReference) it.next());
                if (provider == null || provider2.getPriority().intValue() > provider.getPriority().intValue()) {
                    provider = provider2;
                }
            }
            if (provider != null) {
                ProviderUtil.addProvider(provider);
            }
        } catch (InvalidSyntaxException e) {
            LOGGER.error("Invalid service filter: (APIVersion>=2.6.0)", e);
        }
        Iterator it2 = bundleWiring.findEntries("META-INF", "log4j-provider.properties", 0).iterator();
        while (it2.hasNext()) {
            ProviderUtil.loadProvider((URL) it2.next(), bundleWiring.getClassLoader());
        }
    }
}
