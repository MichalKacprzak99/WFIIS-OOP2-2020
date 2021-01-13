import java.util.*;

/**
 * lab04string class
 *
 * @author Michał Kacprzak
 * @version 1.0
 */
public class lab04string {
    /**
     * Zwraca dlugość danego parametru 'str'
     * @param str string, ktorego długość chcemy poznać
     * @return [int] dlugosc danego str
     */
    static int dlugosc(String str){
        return str.length();
    }

    /**
     * Zwraca ilość wystąpien danego znaku 'c'(dany jako parametr) w 'str'(dany jako parametr)
     * @param str Badany string
     * @param c Szukamy liczby wystąpień tego znaku w 'str'
     * @return int - ilosc wystapien znaku 'c' w 'str'
     */
    static int ile_razy_literka_wystepuje(String str,char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * Porównuje czy dwa dane Stringi są takie same
     * @param s1 porównywany string
     * @param s2 porównywany string
     * @return true jeśli dane stringi są takie same, w przeciwnym wypadku false
     */
    static boolean czy_takie_same(String s1,String s2){
        return Objects.equals(s1, s2);
    }

    /**
     * Przekształca stringa wspak
     * @param str string, którego reprezentacje wspak chcemy poznać
     * @return dany string wspak
     */
    static String wspak(String str){
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Sprawdza czy dany string jest palindromem
     * @param str sprhawdzany String
     * @return true jeśli dany string jest palindromem, w przeciwnym wypadku false
     */
    static boolean czy_plaindrom(String str){
        return czy_takie_same(str, wspak(str));
    }

    /**
     * Sprawdza czy dany String jest abecadlowy
     * @param str sprzawdzany String
     * @return true jeśli dany string jest abecadlowy, w przeciwnym wypadku false
     */
    static boolean czy_abecadlowe(String str){
        for (int i = 1; i < str.length()-1; i++) {
            if ((int)str.charAt(i) < (int)str.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Koduje stringa zgodnie z odpowiednim algorytmem opisanym w klasie lab04
     * @param str string przeznaczony do zakodowania
     * @return string po zakodowaniu parametru 'str' poprzez algorytm rot13
     */
    static String rot13 (String str){
        StringBuilder code_str = new StringBuilder();
        for (int i = 0; i < dlugosc(str); i++) {
            char tmp = str.charAt(i);
            if('a' <= tmp && tmp <= 'z'){
                if(tmp <= 'm'){
                    tmp += 13;
                }
                else{
                    tmp -= 13;
                }
            }
            else if('A' <= tmp && tmp <= 'Z'){
                if(tmp <= 'M'){
                    tmp += 13;
                }
                else{
                    tmp -= 13;
                }
            }
            code_str.append(tmp);
        }
        return code_str.toString();
    }
}
