package com.solvd.deliveryservice.utils;

@FunctionalInterface
public interface UniversalFunction<T> {

    T doOperation(T element);

}
