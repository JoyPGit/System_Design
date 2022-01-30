class Swiggy{
    List<Restaurant> restaurantList;
}

class Restaurant{
    List<Table> availableTables;
    List<Table> reservedTables;

    boolean getTable(){
        if(availableTables.size()>0){
            reservedTables.add(availableTables.remove(0));
        }
    }
}

class Payment{
    // async via kafka
    makePayment(long restaurantId, long amount, String type){
        // call third party service
        // store in db
    }
}
