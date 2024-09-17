package com.shaunwassell.filemanager;

public class TextBasedInterface implements UserInterface {
    private UIEventHandler handler = null;

    @Override
    public void start() {

    }

    @Override
    public void subscribe(UIEventHandler handler) {
        if (this.handler == null) {
            this.handler = handler;
        }
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
