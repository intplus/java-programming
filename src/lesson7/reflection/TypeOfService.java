package lesson7.reflection;

/**
 * Created by alpo123 on 22.05.16.
 */
public class TypeOfService {

    private String str;
    private int i;
    private boolean bool;

    public TypeOfService(String str) {
        this.str = str;

    }

    public TypeOfService(int i) {
        this.i = i;
    }

    public TypeOfService(boolean bool) {
        this.bool = bool;
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
