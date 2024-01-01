package com.vattima.lego.sheet.meta;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BooleanCellDescriptorTest {

    @Test
    void withTrueValues_areTrue() {
        BooleanCellDescriptor booleanCellDescriptor = new BooleanCellDescriptor();
        Object o = "x";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isTrue();
        o = "  x  ";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isTrue();
        o = "X";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isTrue();
        o = "y";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isTrue();
        o = "Y";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isTrue();
        o = "  Y   ";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isTrue();
    }

    @Test
    void withNoTrueValues_areFalse() {
        BooleanCellDescriptor booleanCellDescriptor = new BooleanCellDescriptor();
        Object o = null;
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isFalse();
        o = "yes";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isFalse();
        o = "";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isFalse();
        o = "    ";
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isFalse();
        o = true;
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isFalse();
        o = false;
        booleanCellDescriptor.setValue(o);
        assertThat(booleanCellDescriptor.getValue()).isFalse();
    }
}