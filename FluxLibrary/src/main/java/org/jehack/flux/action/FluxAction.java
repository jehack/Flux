package org.jehack.flux.action;

import java.util.List;

public final class FluxAction {

    private final String type;

    private final List<?> data;

    private FluxAction(Builder builder) {
        type = builder.type;
        data = builder.data;
    }

    public String getType() {
        return type;
    }

    public List<?> getData() {
        return data;
    }

    public static final class Builder {
        private String type;
        private List<?> data;

        public Builder() {
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder data(List<?> val) {
            data = val;
            return this;
        }

        public FluxAction build() {
            return new FluxAction(this);
        }
    }
}
