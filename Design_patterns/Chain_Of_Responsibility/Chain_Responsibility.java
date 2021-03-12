package Design_patterns.Chain_Of_Responsibility;

public interface Chain_Responsibility{

    void setNextHandler(Chain_Responsibility sub, Request num) throws Exception;
    int calculate(Request req);
}