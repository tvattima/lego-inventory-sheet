package com.vattima.lego.sheet.meta;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegerCellDescriptorTest {

    @Test
    void setAsValidInteger_returnsInteger() {
        IntegerCellDescriptor integerCellDescriptor = new IntegerCellDescriptor();

        integerCellDescriptor.setValue(123);
        Optional<Integer> actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isTrue();
        Assertions.assertThat(actualValue.get()).isEqualTo(123);

        integerCellDescriptor.setValue(123678);
        actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isTrue();
        Assertions.assertThat(actualValue.get()).isEqualTo(123678);
    }

    @Test
    void setAsValidIntegerString_returnsInteger() {
        IntegerCellDescriptor integerCellDescriptor = new IntegerCellDescriptor();

        integerCellDescriptor.setValue("123");
        Optional<Integer> actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isTrue();
        Assertions.assertThat(actualValue.get()).isEqualTo(123);

        integerCellDescriptor.setValue(" 1   ");
        actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isTrue();
        Assertions.assertThat(actualValue.get()).isEqualTo(1);

        integerCellDescriptor.setValue(" 567   ");
        actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isTrue();
        Assertions.assertThat(actualValue.get()).isEqualTo(567);

        integerCellDescriptor.setValue("123678");
        actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isTrue();
        Assertions.assertThat(actualValue.get()).isEqualTo(123678);
    }

    @Test
    void setAsNull_returnsNull() {
        IntegerCellDescriptor integerCellDescriptor = new IntegerCellDescriptor();

        Integer expectedValue = null;
        integerCellDescriptor.setValue(expectedValue);
        Optional<Integer> actualValue = integerCellDescriptor.getValue();
        Assertions.assertThat(actualValue).isNotNull().isInstanceOf(Optional.class);
        Assertions.assertThat(actualValue.isPresent()).isFalse();
        Assertions.assertThatThrownBy(actualValue::get).isInstanceOf(NoSuchElementException.class);
    }
}