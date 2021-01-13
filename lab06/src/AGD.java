public class AGD extends Product {

    AGD(String name, int buyPrice, int sellPrice, int presentDay){
        super.buyPrice = buyPrice;
        super.sellPrice = sellPrice;
        super.storedDay = presentDay;
        super.isAbleToRoot = false;
        super.name = name;
    }
}
