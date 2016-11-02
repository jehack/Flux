package org.jehack.flux.example;

import org.jehack.flux.action.FluxActionsCreator;

import org.jehack.flux.example.main.action.MainActionsCreator;

import java.util.HashMap;
import java.util.Map;

public class ExampleFluxActions {

    private Map<String, FluxActionsCreator> actionsCreatorMap = new HashMap<>();

    private FluxActionsCreator getActionsCreator(String type) {
        FluxActionsCreator actionsCreator = actionsCreatorMap.get(type);
        if (actionsCreator != null) {
            return actionsCreator;
        }

        switch (type) {

            case ExampleFluxType.MAIN:
                actionsCreator = new MainActionsCreator();
                break;
        }

        actionsCreatorMap.put(type, actionsCreator);
        return actionsCreator;
    }

    public MainActionsCreator getMain() {
        return (MainActionsCreator) getActionsCreator(ExampleFluxType.MAIN);
    }
}
