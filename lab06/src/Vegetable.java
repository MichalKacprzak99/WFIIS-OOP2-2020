public class Vegetable extends Product {

    Vegetable(String name, int buyPrice, int sellPrice, int storedDay){
        super.name = name;
        super.buyPrice = buyPrice;
        super.sellPrice = sellPrice;
        super.storedDay = storedDay;
        super.isAbleToRoot = true;

    }

    @Override
    public int getDaysToRot() {
        return 2;
    }
}
