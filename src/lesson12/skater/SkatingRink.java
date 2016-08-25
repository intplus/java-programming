package lesson12.skater;


public interface SkatingRink {

    public Skates getSkates(Skater skater);

    public void returnSkates(Skates skates, Skater skater);
}
