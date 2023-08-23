/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProjectUrsinusFoodReview;

import java.util.ArrayList;
import java.util.Scanner;
import edu.princeton.cs.algs4.*;
import java.util.HashMap;

/**
 *
 * @author ianut
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static double getAverage(ArrayList<ArrayList<Integer>> starCount, int reviewCounter) {
        double average = 0;
        
        for (int i = 0 ; i < starCount.size() ; i++) { // obtains every array list in the array list
            for (int j = 0 ; j < starCount.get(i).size(); j++) { // obtains every star count in each array list
                average = average + starCount.get(i).get(j);
            }
            
        }
        average = ((double)average / reviewCounter);
        return average;
    }
    
    public static void getDistrubtion(ArrayList<ArrayList<Integer>> starCount, int reviewCounter) {
        
        StdDraw.rectangle(0.5, 0.1, 0.495, 0.05);
        StdDraw.rectangle(0.5, 0.3, 0.495, 0.05);
        StdDraw.rectangle(0.5, 0.5, 0.495, 0.05);
        StdDraw.rectangle(0.5, 0.7, 0.495, 0.05);
        StdDraw.rectangle(0.5, 0.9, 0.495, 0.05);
        StdDraw.text(0.07, 0.17, "One Star");
        StdDraw.text(0.08, 0.37, "Two Stars");
        StdDraw.text(0.09, 0.57, "Three Stars");
        StdDraw.text(0.08, 0.77, "Four Stars");
        StdDraw.text(0.08, 0.97, "Five Stars");
        
        
        for (int i = 0 ; i < starCount.size() ; i++) {
            double distrubtion = 0;
            distrubtion = ((double) starCount.get(i).size() / reviewCounter);
            distrubtion = distrubtion * 100;
            StdDraw.filledRectangle(0.0, (0.2*i)+0.1 , distrubtion/100 , 0.05);
            String distrubtionName = "" + distrubtion + "% of the reviews rated this food item " + (i+1) + " star";
            if (i > 0) {
                distrubtionName = distrubtionName + "s";
            }
            System.out.println(distrubtionName);
        }
    }
    public static void main(String[] args) {
        //declare hashmaps
	HashMap<String, ArrayList<String>> Grill = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> Restaurant= new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> Hometown = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> Simple= new HashMap<String, ArrayList<String>>();


        //build arraylists for all menu items
        //might change to a text file later if we have time

        ArrayList<String> GrillList = new ArrayList();
        GrillList.add("Chicken and Cheese Quesadilla"); 
        GrillList.add("Cheese Quesadilla"); 
        GrillList.add("Hamburger"); 
        GrillList.add("French Fries"); 
        GrillList.add("Grilled Cheese Sandwich"); 
        GrillList.add("Chicken Patty Sandwich"); 
        GrillList.add("Bistro Turkey Burger");

        ArrayList<String> RestaurantList = new ArrayList();
        RestaurantList.add("Buffalo Ranch Fries"); 
        RestaurantList.add("Cajun Style Chicken Wings");
        RestaurantList.add("Honey Chicken Wings");

        ArrayList<String> HometownList = new ArrayList();
        HometownList.add("Home-Style Meatloaf"); 
        HometownList.add("Mashed Potatoes"); 
        HometownList.add("Roasted Brussel Sprouts");

        ArrayList<String> SimpleList = new ArrayList();
        SimpleList.add("Adobe Roasted Turkey Breast"); 
        SimpleList.add("Gluten Free Fusili Pasta"); 
        SimpleList.add("Red Onion Polenta"); 
        SimpleList.add("Roasted Plum Tomatoes"); 
        SimpleList.add("Honey Balsamic Pork Chop");


        Grill.put("Grill",GrillList);
        Restaurant.put("Restaurant",RestaurantList);
        Hometown.put("Hometown",HometownList);
        Simple.put("Simple Servings",SimpleList);

        System.out.println("Today's Menu:");
        System.out.println("");
        System.out.println(Grill);
        System.out.println(Restaurant);
        System.out.println(Hometown);
        System.out.println(Simple);
        System.out.println("");



        //build list of backup menu items if reviews on a current one are poor

        int reviewCounter = 0;
        Scanner scanner = new Scanner(System.in);
        String answerToExit = "";
        ArrayList<Integer> oneStar = new ArrayList<Integer>();
            ArrayList<Integer> twoStar = new ArrayList<Integer>();
            ArrayList<Integer> threeStar = new ArrayList<Integer>();
            ArrayList<Integer> fourStar = new ArrayList<Integer>();
            ArrayList<Integer> fiveStar = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> totalStars = new ArrayList<ArrayList<Integer>>();
            
            totalStars.add(oneStar);
            totalStars.add(twoStar);
            totalStars.add(threeStar);
            totalStars.add(fourStar);
            totalStars.add(fiveStar);
            
        do {
            System.out.println("Please rate your food item on a scale of 1-5");
            String starCount = scanner.nextLine();
            while (Double.parseDouble(starCount) > 5 || Double.parseDouble(starCount) < 1) {
                System.out.println("I'm sorry the value you selected is not on the scale of 1-5");
                System.out.println("Please rate your food item on a scale of 1-5");
                starCount = scanner.nextLine();
            }
            reviewCounter = reviewCounter + 1;

            if (Integer.parseInt(starCount) == 1) {
                oneStar.add(Integer.parseInt(starCount));
            } else if (Integer.parseInt(starCount) == 2) {
                twoStar.add(Integer.parseInt(starCount));
            } else if (Integer.parseInt(starCount) == 3) {
                threeStar.add(Integer.parseInt(starCount));
            } else if (Integer.parseInt(starCount) == 4) {
                fourStar.add(Integer.parseInt(starCount));
            } else if (Integer.parseInt(starCount) == 5) {
                fiveStar.add(Integer.parseInt(starCount));
            }
            
            

            getAverage(totalStars, reviewCounter);
            System.out.println(reviewCounter);
            

            System.out.println("Would you like to quit? Type Y for yes or N for no");
            answerToExit = scanner.nextLine();
            while (!answerToExit.equals("Y") && !answerToExit.equals("N")) {
                System.out.println("I'm sorry the character you typed does not match");
                System.out.println("Would you like to quit? Type Y for yes or N for no");
                answerToExit = scanner.nextLine();
            } 
        } while (answerToExit.equals("N")); 
        
        System.out.println(getAverage(totalStars, reviewCounter));
        getDistrubtion(totalStars,reviewCounter);
        
    }
}
