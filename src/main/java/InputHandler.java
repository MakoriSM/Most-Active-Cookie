public class InputHandler {
    private String[] m_args;
    final private String INPUTFORMAT = "java -jar most_active_cookie cookie_log.csv 2018-12-09";

    public InputHandler(String[] args) {
        try{

        }
        catch(){
            System.out.println("Too many inputs given. Please run program with the format:");
            System.out.println(INPUTFORMAT);
        }
        this.m_args = args;
    }
}
