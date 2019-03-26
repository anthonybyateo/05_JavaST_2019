package by.training.taskinfohandling.entity;


public class Сharacter implements TextComponent {

    private char ch;

    public Сharacter(final char aChar) {
        this.ch = aChar;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    @Override
    public String getValue() {

        return String.valueOf(ch);
    }
}
