import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashMap;


public class Shop {
    private final ArrayList<Product> productsInShop = new ArrayList<>();
    private final HashMap<String, Runnable> shopFunctions;
    private final HashMap<String, String> typeOfProductsInShop;
    private int shopProfit = 0;
    private boolean working = true;
    private int dayOfWork = 0;
    public Shop(){

        shopFunctions = new HashMap<>();
        shopFunctions.put("X", this::closeShop);
        shopFunctions.put("x", this::closeShop);
        shopFunctions.put("1", this::showPossibleProductsToAdd);
        shopFunctions.put("2", this::sellProduct);
        shopFunctions.put("3", this::nextDayOfWork);
        shopFunctions.put("4", this::printShopProfit);

        typeOfProductsInShop = new HashMap<>();
        typeOfProductsInShop.put("1", "Fruit");
        typeOfProductsInShop.put("2", "Vegetable");
        typeOfProductsInShop.put("3", "AGD");

    }
    public void openShop() {

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1) Dodaj towar\n" +
                    "2) Sprzedaj towar\n" +
                    "3) Kolejny dzień\n" +
                    "4) Bilans\n" +
                    "X) Koniec programu\n");
            try {
                shopFunctions.get(input.nextLine()).run();
            } catch (NullPointerException e) {
                System.out.println("Wpisales zla komende");
            }
        } while (working);
    }

    private void closeShop(){
        working = false;
    }

    private void showPossibleProductsToAdd() {
        System.out.println("1) dodaj owoc\n" +
                "2) dodaj warzywo\n" +
                "3) dodaj drobne agd\n");

        Scanner inputTypeOfProduct = new Scanner(System.in);
        String chosenOption = inputTypeOfProduct.nextLine();
        String productType = typeOfProductsInShop.get(chosenOption);
        addProduct(productType);
    }

    private void addProduct(String type){
        Scanner inputProduct = new Scanner(System.in);

        System.out.println("Podaj nazwe:");
        String productName = inputProduct.nextLine();

        System.out.println("podaj cene zakupu:");
        int productBuyPrice = inputProduct.nextInt();

        System.out.println("podaj cene sprzedazy:");
        int productSellPrice = inputProduct.nextInt();

        switch (type){
            case "Fruit":
                Fruit fruit = new Fruit(productName, productBuyPrice, productSellPrice, dayOfWork);
                productsInShop.add(fruit);
                break;
            case "Vegetable":
                Vegetable vegetable = new Vegetable(productName, productBuyPrice, productSellPrice, dayOfWork);
                productsInShop.add(vegetable);
                break;
            case "AGD":
                AGD agd = new AGD(productName, productBuyPrice, productSellPrice, dayOfWork);
                productsInShop.add(agd);
                break;
        }
    }

    private void nextDayOfWork() {
        dayOfWork ++;
        for (Iterator<Product> iter = productsInShop.listIterator(); iter.hasNext();){
            Product product = iter.next();
            if(product.isAbleToRoot()){
                if(product.getDaysToRot() == dayOfWork - product.storedDay){
                    shopProfit -= product.getBuyPrice();
                    iter.remove();
                }
            }
        }
    }

    private void printShopProfit() {
        System.out.println("Profit: " + shopProfit);
    }

    private void sellProduct() {
        System.out.println("Products available in shop:");
        int i = 1;
        for(Product product : productsInShop){
            System.out.println(i + ". " + product.getName());
            i++;
        }
        System.out.println("\nWhich product we are selling today?");
        Scanner idProductToSell = new Scanner(System.in);
        int index = idProductToSell.nextInt() - 1;
        int profitFromProduct = productsInShop.get(index).getSellPrice() - productsInShop.get(index).getBuyPrice();
        shopProfit += profitFromProduct;
        productsInShop.remove(index);
    }
}
