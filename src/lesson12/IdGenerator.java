package lesson12;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong a = new AtomicLong(0);

    public long getNextId(){
        return a.incrementAndGet();
    }

}
