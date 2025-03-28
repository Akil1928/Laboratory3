package domain;

public class DivideAndConquer {
    public static ArrayMinMax findMinMax(int[] a, int low, int high){

        //caso base, un solo elemento
        if(low == high){
            return new ArrayMinMax(a[low], a[high]);

        }
        //Caso base 2, solucion con dos elmentos
        if(high == low + 1){
            //new ArrayMinMax(Math.min(a[low], a[high]),Math.max(a[low], a[high]));
            new ArrayMinMax(util.Utility.min(a[low], a[high]),util.Utility.max(a[low], a[high]));
        }

        //Hacer los casos recursivos para que funcione
        return null;//Esto se cambia a lo que corresponde
    }


}