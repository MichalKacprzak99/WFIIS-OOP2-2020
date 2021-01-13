public class Add {
    public void add(int... x){
        int suma = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0; i< x.length; i++){
            suma += x[i];
            if(i != x.length - 1){
                result.append(x[i]).append("+");
            }
            else {
                result.append(x[i]).append("=").append(suma);
            }

        }
        System.out.println(result);
    }
}
