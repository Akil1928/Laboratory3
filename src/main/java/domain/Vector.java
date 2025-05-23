package domain;

public class Vector implements VectorInterface{
    private int n; //tamaño máximo del vector
     private int [] data ; //array de elementos tipo enteros
  private int counter; //cantidad de elementos agregados

    //CONSTRUTOR
    public Vector(int n){
        this.n =n;
        this.data = new int [n];
        this.counter =0;//Significa que tenemos cero elementos agregados
    }

    public int [] getData() {
        return data;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.data = new int [n];
        this.counter =0;
    }

    @Override
    public boolean isEmpty() {
        return counter ==0;
    }

    @Override
    public boolean contains(Object element) {//tiene que ordenar el arreglo con busqueda binaria
        int target = (int)element;
        int left = 0;
        int right = counter - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return true;
            }
            if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    @Override
    public void add(Object element) {
        if(counter< this.data.length)
        this.data[counter++] = (int)element;

    }

    @Override
    public void add(int index, Object element) {

        if(index<data.length) {
            data[index] = (int) element;
            if(counter<= index)
                counter = index+1;//Contador queda en la siguiente pos a agregar

        }
    }

    @Override
    public boolean remove(Object element) {

        for (int i = 0; i < counter; i++) {
            if (data[i] == (int)element) {
                // Mover elementos a la izquierda para llenar el espacio
                for (int j = i; j < counter - 1; j++) {
                    data[j] = data[j + 1];
                }
                counter--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(int index) {//Removerlo con la busqueda binaria que indica la posicion y se suprime con lo que esta a la derecha y todos se van moviendo asi hasta el final

        if (index < 0 || index >= counter) {
            return null;
        }

        // Guardar elemento a eliminar
        int removedElement = data[index];

        // Mover elementos a la izquierda
        for (int i = index; i < counter - 1; i++) {
            data[i] = data[i + 1];
        }

        counter--;
        return removedElement;
    }

    @Override
    public void sort() {
bubbleSort(this.data, counter);
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < counter; i++) {
            if (data[i] == (int)element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= counter) {
            return null;
        }
        return data[index];
    }
    public void fill() {
        util.Utility.fill(this.data);
        counter = n;
    }
    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    @Override
    public String toString() {
        // Mostrar contenido del vector
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            sb.append(data[i]).append(" ");
        }
        return sb.toString().trim();
    }

}
