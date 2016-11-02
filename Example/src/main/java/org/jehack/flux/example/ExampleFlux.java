package org.jehack.flux.example;

public class ExampleFlux {

    private static ExampleFluxActions actions = new ExampleFluxActions();

    private static ExampleFluxStore store = new ExampleFluxStore();

    public static ExampleFluxActions getActions() {
        return actions;
    }

    public static ExampleFluxStore getStore() {
        return store;
    }

}
