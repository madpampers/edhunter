package ru.edhunter.dz1.bubble;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int size = 10; //Устанавливаем размер массива
        int myArray[] = createRandomArray(size); //Создаем массив методом, передавая параметр размера (size)
        printMinAndMax(myArray); //вызываем метод вывода в консоль минимума и максимума массива
        myArray = sortArraywithBubbles(myArray); //сортируем наш массив методом sortArraywithBubbles, передаем методу наш массив как параметр
        printArrayInfo(myArray); //методом выводим в консоль наш массив и его длину
    }

    private static void printArrayInfo(int[] myArray) { //метод 4
        System.out.println("BubbleSort: ");
        for (int i = 0; i < myArray.length; i++) {//обьявлять переменные можно в объявлении цикла, необязательно их объявлять до самого массива
            System.out.print(myArray[i]+" ");
        }
        System.out.println();

        System.out.println("Array Length: "+myArray.length);
    }

    private static int[] sortArraywithBubbles(int[] myArray) { //метод 3
        for (int i = 0; i < myArray.length; i++) {//здесь тоже обьявляем переменные внутри объявления массива (int i = 0)
            for (int j = i+1; j < myArray.length; j++) {
                if(myArray[i]>myArray[j]) {
                    int temp = myArray[i];//так же переменные можно объявлять внутри ифов, циклов, методов, это удобно, потому что их зона действия меньше и названия можно снова исользовать выйдя из цикла
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }

        }
        return myArray;
    }

    private static void printMinAndMax(int[] myArray) { //метод 2
        int max;
        int min = max = myArray[0];
        for (int i = 1; i < myArray.length; i++) {
            if (min > myArray[i]) {
                min = myArray[i];
            }
            if (max < myArray[i]) {
                max = myArray[i];
            }
        }
        System.out.println("Min element: " + min);
        System.out.println("Max element:" + max);
    }

    private static int[] createRandomArray(int size) { //метод 1
        final Random random = new Random();
        int myArray[] = new int[size];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(10);
        }
        System.out.println("Random array: ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        return myArray;
    }
}
