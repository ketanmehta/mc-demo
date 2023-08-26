package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class FileMetaData {
    private String name;
    private long size;
    @Builder.Default
    private List<String> collectionList = new ArrayList<>();
}
