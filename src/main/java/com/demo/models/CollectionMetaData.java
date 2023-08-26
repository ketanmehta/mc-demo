package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CollectionMetaData {
    private String name;
    private long size;

    @Override
    public String toString() {
        return String.format("%s, %d", name, size);
    }
}
