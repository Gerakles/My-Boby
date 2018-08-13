package JavaRush.example;

public class BubleSort {
    public static void main(String[] args) {
        int[] massif = {13, 3, 8, 1, 15, 2, 3, 7, 4, 3, 1, 4, 1, 5, 9, 2, 6, 5};
        System.out.print( "Массив до сортировки: " );
        for (int aMassif : massif) System.out.print( aMassif + " " );
        System.out.println();
        massif = sort( massif );
        System.out.print( "Массив после сортировки: " );
        for (int aMassif : massif) {
            System.out.print( aMassif + " " );
        }
    }

    private static int[] sort(int x[]) {
        if (x.length == 1) //Рекурсия идет до тех пор, пока массив делится
            return x;
        else {
            int half = (int) Math.floor( x.length / 2 ); //Разбиваем массив на 2 части
            int halfFirst[] = new int[half]; //1 часть, пустой массив
            int halfSecond[] = new int[x.length - half]; //2 часть, пустой массив
            for (int i = 0; i < x.length; i++) { //Заполняем новосозданные массивы значениями
                if (i < half)
                    halfFirst[i] = x[i];
                else
                    halfSecond[i - half] = x[i];
            }
            halfFirst = sort( halfFirst ); //Рекурсия
            halfSecond = sort( halfSecond ); //Рекурсия
            x = sortNext( halfFirst, halfSecond ); //Отправляем заполненные значениями массивы в следующий метод
            return x;
        }
    }

    private static int[] sortNext(int x[], int y[]) {
        int c[] = new int[x.length + y.length]; //Создаем результирующий массив из суммы длин массивов из аргументов метода
        int a = 0, b = 0;
        for (int i = 0; i < x.length + y.length; i++) { //Сравниваем массивы, меняем местами элементы, заполняем новосозданный массив
            if (a == x.length) {
                c[i] = y[b];
                b++;
            } else if (b == y.length) {
                c[i] = x[a];
                a++;
            } else if (x[a] > y[b]) {
                c[i] = y[b];
                b++;
            } else {
                c[i] = x[a];
                a++;
            }
        }
        return c;
    }
}