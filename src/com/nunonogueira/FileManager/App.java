package com.nunonogueira.FileManager;

public class App implements UIEventHandler {
    FileManager fm;

    public App() {
        this.fm = new FileManager();
    }

    public static void main(String[] args) {
        UserInterface ui = new TextBasedInterface();
        ui.subscribe(new App());

        ui.start();
    }

    @Override
    public void onList(String path) {
        this.fm.listFiles(path);
    }

    @Override
    public void onCreate(String path) {
        this.fm.createDirectory(path);
    }

    @Override
    public void onDelete(String path) {
        this.fm.deleteFileOrDirectory(path);
    }
}
