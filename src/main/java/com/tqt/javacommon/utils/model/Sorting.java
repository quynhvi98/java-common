package com.tqt.javacommon.utils.model;

import javax.validation.constraints.Pattern;

public class Sorting {
    private boolean ascending = true;

    @Pattern(regexp = "name|city", message = "Field must have value 'name' or 'city'.")
    private String field = "name";

    private String getDirection() {
        return ascending ? "ASC" : "DESC";
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(final boolean ascending) {
        this.ascending = ascending;
    }

    public String getField() {
        return field;
    }

    public void setField(final String field) {
        this.field = field;
    }
}
