package lesson7.reflection;

@Service(name = "start")
public class NewClass {

    private String str;
    private int i;
    private boolean bool;

    public NewClass() {

    }

    public NewClass(int i, boolean bool) {
        this.i = i;
        this.bool = bool;
    }

    public NewClass(String str) {
        this.str = str;
    }

    public NewClass(Integer i, String str) {
        this.i = i;
        this.str = str;
    }

    public NewClass(int i) {
        this.i = i;
    }


    @initService
    public void BusinessLogic() {

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
