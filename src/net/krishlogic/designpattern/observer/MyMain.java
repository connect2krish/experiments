package net.krishlogic.designpattern.observer;

public class MyMain {

    public static void main(String argsp[]) {

        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver();
        HexObserver hexObserver = new HexObserver();
        hexObserver.attach(subject);
        binaryObserver.attach(subject);
        subject.setNumber(10);
    }
}
