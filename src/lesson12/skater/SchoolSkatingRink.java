package lesson12.skater;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class SchoolSkatingRink implements SkatingRink{

    @Override
    public Skates getSkates(Skater skater) {
        System.out.println(skater.getName()+" got skates");
        return new Skates();
    }

    @Override
    public void returnSkates(Skates skates, Skater skater) {
        System.out.println(skater.getName()+" return skates");
    }
}
