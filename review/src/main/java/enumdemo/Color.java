package enumdemo;

public enum Color {
    RED(0),GREEN(1),BLUE(2);
    private int code;

    Color(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
