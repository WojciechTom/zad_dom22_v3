public enum Opcje {
    OP1("SHOW_ALL"), OP2("BIGGER_THAN"), OP3("ONLY_COMP_GAMES"), OP4("EXIT");

    private String opcja;
    Opcje(String opcja) {
        this.opcja = opcja;
    }

    public String getOpcja() {
        return opcja;
    }



    public void setOpcja(String opcja) {
        this.opcja = opcja;
    }
}
