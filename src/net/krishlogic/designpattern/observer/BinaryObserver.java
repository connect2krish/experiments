package net.krishlogic.designpattern.observer;

public class BinaryObserver extends Observer{

    public void attach(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary objserver:  " + Integer.toBinaryString(this.subject.getNumber()));
    }
}
