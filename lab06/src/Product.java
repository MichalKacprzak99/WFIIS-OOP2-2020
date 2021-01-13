public class Product implements AbleToStorage, AbleToRot {
    protected int buyPrice;
    protected String name;
    protected int sellPrice;
    protected boolean isAbleToRoot;
    protected int storedDay;

    @Override
    public boolean isAbleToRoot() {
        return isAbleToRoot;
    }

    @Override
    public int getDaysToRot() {
        return 0;
    }

    @Override
    public int getBuyPrice() {
        return buyPrice;
    }

    @Override
    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public String getName() {
        return name;
    }
}
