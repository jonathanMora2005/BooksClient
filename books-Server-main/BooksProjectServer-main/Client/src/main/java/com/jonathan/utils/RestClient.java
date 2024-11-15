package com.jonathan.utils;


public interface RestClient {
    <T> T get(String path, Class<T> returnType) throws Exception;

    <T> T[] getAll(String path, Class<T[]> returnType) throws Exception;

    void post(String path, String body) throws Exception;

    void put(String path, String body) throws Exception;

    void delete(String path, String body) throws Exception;
}
