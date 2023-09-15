package com.houarizegai.immutables.dto;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Book {
    public abstract String title();
    public abstract String author();
}
