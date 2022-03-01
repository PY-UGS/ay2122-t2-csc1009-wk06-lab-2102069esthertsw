package com.esther.wk06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Q4Hashmap {

    public void addAndSort(HashMap<Integer, Integer> hash, int val) {
        if ((int) hash.get(hash.size() - 1) < val) { //without this if, cannot add to last element
            hash.put(hash.size(), val);
        } else {
            int i = 0;
            while ((int) hash.get(i) < val) {
                i++;
            }
            int num = (int) hash.size();
            for (int a = i + 1; a < hash.size(); a++) {
                int oldnum = (int) hash.get(num - 1);
                hash.put(num, (int) oldnum);
                num -= 1;

            }
            hash.put(i, val);
        }
        for (int i=0; i<hash.size(); i++){
            System.out.print(hash.get(i) + " ");
        }
        System.out.println("\n");
//        int size = map.size();
//
//        for (int i=size; i>=1; i--){
//            if ((int)map.get(i) > value){
//                map.put(i+1, (int)map.get(i));          //Find another way, bc map.put doesn't create a new entry, just replaces
//            }
//            else{
//                map.put(i+1, value);
//                break;
//            }
//        }
//        System.out.print("Contents after addition: ");
//        for (int i=0; i<size+1; i++){
//            System.out.print(map.get(i) + " ");
//        }
//        System.out.println("\n");
//    }
    }

    public int getSize(HashMap<Integer, Integer> map){
        return map.size();
    }
    public int swapValues(HashMap<Integer, Integer> map, int a, int b){
        if (a == b){
            return -1;
        }
        int size = map.size();
        if (a > size-1 || b> size-1){
            return -1;
        }
        int temp = map.get(a);
        map.put(a, map.get(b));
        map.put(b, temp);

        System.out.print("Contents after swap: ");
        for (int i=0; i<size; i++){
            System.out.print(map.get(i) + " ");
        }
        System.out.println("\n");
        return 0;
    }

    public int findValue(HashMap<Integer, Integer> map, int searchVal){
        for (int i = 0; i<500; i++){
            if (map.get(i) == searchVal){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Q4Hashmap myMap = new Q4Hashmap();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        hashMap.put(1, 3);
        hashMap.put(2, 5);
        hashMap.put(3, 7);
        hashMap.put(4, 9);
        hashMap.put(5, 11);
//        System.out.println("Enter value to add: ");
        System.out.println("Contents initial: ");

        for (int i=0; i<myMap.getSize(hashMap); i++){
            System.out.print(hashMap.get(i) + " ");
        }
        System.out.println("\n");
        System.out.println("Add value: 4");
        myMap.addAndSort(hashMap, 4);

        System.out.println("/t*** Q5: Swap Values ***");
        System.out.println("Enter index of values to swap: ");
        myMap.swapValues(hashMap, input.nextInt(), input.nextInt());

        System.out.println("/t*** Q6: Random HashMap Search ***");
        HashMap<Integer, Integer> randomMap = new HashMap<Integer,Integer>();
        Random numbers = new Random();
        for (int i = 0; i<500; i++){
            randomMap.put(i, numbers.nextInt((9999-1000) + 1000));
        }
        int randomVal = numbers.nextInt((9999-1000) + 1000);
        System.out.println("Does map contain random value " + randomVal + "?");
        int randomResult = myMap.findValue(randomMap, randomVal);
        if(randomResult == -1){
            System.out.println("No.");
            return;
        }
        System.out.println("Yes! At index " + randomResult);
    }
}
