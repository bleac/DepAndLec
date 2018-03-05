package com.base.app;

import com.base.dbworker.DataBaseWorker;

public class Application {

    private static final DataBaseWorker WORKER = new DataBaseWorker();

    public static void main(String[] args) {

        WORKER.getHeadOfDepartment("soem");

    }
}
