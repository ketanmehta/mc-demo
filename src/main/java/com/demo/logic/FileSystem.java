package com.demo.logic;

import com.demo.models.CollectionMetaData;
import com.demo.models.FileMetaData;
import com.demo.models.FileSystemMetaData;
import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class FileSystem {

    private static Map<String, FileMetaData> fileSystemMap = new ConcurrentHashMap<>();


    private static Map<String, CollectionMetaData> collectionMetaMap = new ConcurrentHashMap<>();

    private static FileSystemMetaData fileSystemMetaData = FileSystemMetaData.builder().build();

/*    public static void storeFile(@NonNull String fileName, long fileSize, @NonNull String collectionName) {
        FileMetaData existingFile = fileSystemMap.get(fileName);

        // case where file is present, we need to overwrite file object
        // also we need to reduce file size from old collection and update to new collection
        if (existingFile != null) {
            String existingFileCollectionName = existingFile.getCollectionList();
            CollectionMetaData existingCollection = collectionMetaMap.get(existingFileCollectionName);
            existingCollection.setSize(existingCollection.getSize() - existingFile.getSize());
            fileSystemMetaData.setSize(fileSystemMetaData.getSize() - existingFile.getSize());
        }

        FileMetaData newFile = FileMetaData.builder().name(fileName).size(fileSize).collectionList(collectionName).build();
        fileSystemMetaData.setSize(fileSystemMetaData.getSize() + fileSize);
        fileSystemMap.put(fileName, newFile);

        CollectionMetaData collectionMetaData = collectionMetaMap.get(collectionName);
        if (collectionMetaData == null) {
            collectionMetaMap.put(collectionName, CollectionMetaData.builder().name(collectionName).size(fileSize).build());
        } else {
            collectionMetaData.setSize(collectionMetaData.getSize() + fileSize);
        }
    }*/

    public static void storeFileV2(@NonNull String fileName, long fileSize, List<String> collectionList) {
        FileMetaData existingFile = fileSystemMap.get(fileName);


        // case where file is present, we need to overwrite file object
        // also we need to reduce file size from old collection and update to new collection
        if (existingFile != null) {
            List<String> existingFileCollectionList = existingFile.getCollectionList();
            for (String existingFileCollectionName : existingFileCollectionList) {
                CollectionMetaData existingCollection = collectionMetaMap.get(existingFileCollectionName);
                existingCollection.setSize(existingCollection.getSize() - existingFile.getSize());
            }
            fileSystemMetaData.setSize(fileSystemMetaData.getSize() - existingFile.getSize());
        }

        FileMetaData newFile = FileMetaData.builder().name(fileName).size(fileSize).collectionList(collectionList).build();
        fileSystemMetaData.setSize(fileSystemMetaData.getSize() + fileSize);
        fileSystemMap.put(fileName, newFile);

        for (String collectionName : collectionList) {
            CollectionMetaData collectionMetaData = collectionMetaMap.get(collectionName);
            if (collectionMetaData == null) {
                collectionMetaMap.put(collectionName, CollectionMetaData.builder().name(collectionName).size(fileSize).build());
            } else {
                collectionMetaData.setSize(collectionMetaData.getSize() + fileSize);
            }
        }
    }

    public static void printTopN(int n) {
        PriorityQueue<CollectionMetaData> topNCollections = new PriorityQueue<>(Comparator.comparingLong(CollectionMetaData::getSize));
        collectionMetaMap.values().forEach(collectionMetaData -> {
            topNCollections.offer(collectionMetaData);
            if(topNCollections.size() > n){
                topNCollections.remove();
            }
        });



        // max heap size n,5

        // 50,45,40,30,20,10 ->  45
        // 10,20,30,40,45,50 -> 45
    }

    public static void printSystemMetaData() {
        System.out.println(fileSystemMetaData);
    }
}
