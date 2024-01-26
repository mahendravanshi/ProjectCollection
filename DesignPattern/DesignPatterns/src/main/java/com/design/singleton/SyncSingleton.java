package com.design.singleton;

public class SyncSingleton {

        private static SyncSingleton syncSingleton;

        private SyncSingleton(){

        }

        private static synchronized SyncSingleton getInstance(){

             if(syncSingleton==null){
                 return syncSingleton = new SyncSingleton();
             }

            return syncSingleton;
        }



}
