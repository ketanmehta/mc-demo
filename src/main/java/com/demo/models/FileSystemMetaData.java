package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FileSystemMetaData {

    private long size;

    @Override
    public String toString() {
        return String.format("Space Occupied : %d", size);
    }
}
