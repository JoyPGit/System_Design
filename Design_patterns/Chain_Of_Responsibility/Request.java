package Design_patterns.Chain_Of_Responsibility;

class Request {
    int num1, num2;
    String type;

    Request(int a, int b, String str) {
        this.num1 = a; this.num2 = b;
        this.type = str;
    }

    public static void main(String[] args) throws Exception {
        Request req = new Request(2, 3, "multiply");
        Chain_Responsibility add = new Numbers_Add();
        Chain_Responsibility sub = new Numbers_Subtract();

        try{
            add.setNextHandler(sub, req);
            add.calculate(req);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new Exception(e);
        }
    
    }


}