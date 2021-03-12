package Design_patterns.Chain_Of_Responsibility;

class Numbers_Subtract implements Chain_Responsibility{

    Chain_Responsibility nextChain;
    Numbers_Subtract(){

    }

    // instead of having individual args, use Numbers class
    // simulation of Request obj

    @Override
    public void setNextHandler(Chain_Responsibility handler, Request req) {
        this.nextChain = handler;
    }

    @Override
    public int calculate(Request req) {
        if(req.type.equals("subtract")) return req.num1 + req.num2;
        return nextChain.calculate(req);
    }

}