package com.esther.wk06;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Q1LinkedList {
    public void addAndSort(LinkedList<Integer> list, int value){
        int size = list.size();
        for (int i = 0; i<size; i++){
            if ((int)list.get(i) >= value){
                list.add(i, value);
                break;
            }
        }
        System.out.println("Contents after addition: " + list);

    }
    public int swapByIndex(LinkedList<Integer> list, int a, int b){
        if(a == b){
            return -1;
        }
        int temp = (int)list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
        System.out.println("Contents after swap: " + list);
        return 0;
    }

    public int traverseRandomList(int value){
        LinkedList<Integer> randomList = new LinkedList<Integer>(); //Why can't add int size limit?
        Random numbers = new Random();
        for (int i = 0; i<500; i++){
            randomList.add(numbers.nextInt((9999-1000) + 1000));
        }
        for (int i = 0; i<500; i++){
            if (randomList.get(i) == value){
                return i;
            }
        }
        return -1;


    }

    public static void main(String[] args){
        LinkedList<Integer> myList = new LinkedList<Integer>();
        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(7);
        myList.add(9);
        myList.add(11);
        System.out.println("\t*** Q1: Add and Sort ***");
        System.out.println("Contents: " + myList);
        System.out.println("Enter the value you want to add: ");
        Scanner input = new Scanner(System.in);
        Q1LinkedList Q1List = new Q1LinkedList();
        Q1List.addAndSort(myList, input.nextInt());

//        Q2: Swap Position
        System.out.println("\t*** Q2: Swap Position ***");
        System.out.println("Enter 2 indexes to swap: ");
        Q1List.swapByIndex(myList, input.nextInt(), input.nextInt());

//        Q3, Random linked list
        System.out.println("\t*** Q3: Random List Traverse ***");
        Random num = new Random();
        int randomNum = num.nextInt((9999-1000)+1000);
        System.out.println("Does the random list contain random value " + randomNum + "?");
        int traverseResult = Q1List.traverseRandomList(randomNum);
        if(traverseResult ==-1){
            System.out.println("No.");
        }
        else{
            System.out.println("Yes, at index " + traverseResult);
        }

    }
}
