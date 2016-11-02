package org.jehack.flux.dispatcher;

import org.jehack.flux.action.FluxAction;
import org.jehack.flux.store.FluxStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FluxDispatcher {

    private static final FluxDispatcher INSTANCE = new FluxDispatcher();

    private static final Map<String, Object> REGISTERED_STORES = new ConcurrentHashMap<>();

    private static boolean isDispatching = false;

    public static FluxDispatcher getInstance() {
        return INSTANCE;
    }

    public void register(final Object cls) {
        REGISTERED_STORES.put(cls.getClass().getName(), cls);
    }

    public void unRegister(final Object cls) {
        REGISTERED_STORES.remove(cls.getClass().getName());
    }

    public void waitFor(String type, Object... data) {

    }

    public void dispatch(final FluxAction fluxAction) {
        isDispatching = true;
        for (Object cls : REGISTERED_STORES.values()) {
            ((FluxStore) cls).onFluxActionHandling(fluxAction);
        }
        isDispatching = false;
    }

    public boolean isDispatching() {
        return isDispatching;
    }
}
