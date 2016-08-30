package lesson6.observer;

public class ConcreteObserver implements Observer {
	
	@Override
	public void update() {
		System.out.println(this.toString() + " notified.");
	}
	
}
