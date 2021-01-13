public class Fruit extends Product {

    Fruit(String name, int buyPrice, int sellPrice, int presentDay){
        super.buyPrice = buyPrice;
        super.sellPrice = sellPrice;
        super.storedDay = presentDay;
        super.isAbleToRoot = true;
        super.name = name;
    }

    @Override
    public int getDaysToRot() {
        return 1;
    }
}
