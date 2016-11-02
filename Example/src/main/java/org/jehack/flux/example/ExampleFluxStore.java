package org.jehack.flux.example;

import org.jehack.flux.store.FluxStore;

import org.jehack.flux.example.main.stroe.MainStore;

import java.util.HashMap;
import java.util.Map;

public class ExampleFluxStore {

    private Map<String, FluxStore> fluxStoreMap = new HashMap<>();

    private FluxStore getStore(String type) {
        FluxStore fluxStore = fluxStoreMap.get(type);
        if (fluxStore != null) {
            return fluxStore;
        }

        switch (type) {

            case ExampleFluxType.MAIN:
                fluxStore = new MainStore();
                break;
        }

        fluxStoreMap.put(type, fluxStore);
        return fluxStore;
    }

    public MainStore getMain() {
        return (MainStore) getStore(ExampleFluxType.MAIN);
    }
}
