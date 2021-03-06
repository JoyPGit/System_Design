public class Payment {
    
    // used facade and strategy
    // facade -> different     
}

interface Card{
    void payWithCard(String cardNumber, int cvv);
}

interface UPI{
    void payWithUPI(String upi_ID);
}

interface NetBanking{
    void payWithNetBanking();
}

interface Wallet{
    void payWithWallet(String id);
}

class AmazonPay implements Wallet{
    // contains amazon's exposed apis
    void makePayment(){}

    @Override
    public void payWithWallet(String id) {
        // TODO Auto-generated method stub
        System.out.println("amazon wallet");
    }
    
}

class GooglePay{
    // contains google's exposed apis
    void makePayment(){}
}

class Paytm implements UPI, Wallet{
    void makePayment(){}

    @Override
    public void payWithUPI(String upi_ID) {
        // TODO Auto-generated method stub
        System.out.println("paytm wallet");
    }

    @Override
    public void payWithWallet(String id) {
        // TODO Auto-generated method stub

    }
}

class HDFC implements Card, NetBanking{

    @Override
    public void payWithCard(String cardNumber, int cvv) {
        // TODO Auto-generated method stub

    }

    @Override
    public void payWithNetBanking() {
        // TODO Auto-generated method stub

    }
    
}

class FacadeDemo{
    Wallet wallet;        
    Card card;
    NetBanking netBanking;

    FacadeDemo(){}
    
    void payWithCard(String cardProvider, String cardNumber, int cvv){
        if(cardProvider.compareTo("HDFC")==0) this.card = new HDFC();
        this.card.payWithCard(cardNumber, cvv);
    }

    void payWithWallet(String walletProvider, String id){
        if(walletProvider.compareTo("PAYTM")==0) this.wallet = new Paytm();
        this.wallet.payWithWallet(id);
    }

    void payWithNetBanking(String bank){
        if(bank.equals("HDFC")) this.netBanking = new HDFC();
        this.netBanking.payWithNetBanking();
    }
}



// when working is hidden, facade pattern
// when multiple interfaces -> strategy 

/** 
 * If i use facade only then i will call payWithHDFCCard and pass HDFC and othe parameters
 * but with Strategy, i will call only payWithCard and pass HDFC and pass params.
 * No specific method for each bank.
 * 
 * 
 * factory(class, single method) + facade(interface, specific) = Strategy (class, interface, single method)
 * 
*/