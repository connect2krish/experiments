package net.krishlogic.designpattern.observer;

public class HexObserver extends Observer {
    public void attach(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex objserver:  " + Integer.toHexString(this.subject.getNumber()));
    }}
