import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of items:");
        int n = scan.nextInt();
        int[] weights = new int[n];
        int[] profits = new int[n];
        System.out.println("Enter the weights");
        for (int i = 0; i < n; i++)
            weights[i] = scan.nextInt();
        System.out.println("Enter corresponding profits:");
        for(int i = 0; i < n; i++)
            profits[i]= scan.nextInt();
        System.out.println("Enter the maximum weight:");
        int maxWeight = scan.nextInt();
        System.out.println("Enter the minimum profit:");
        int minProfit = scan.nextInt();
        if(decision(weights,profits,maxWeight+1,minProfit,n) == true)
            System.out.println("Yes");
        else
            System.out.println("NO");
    }
    static boolean decision(int[] weights, int[] profits,int maxWeight, int minProfit, int n){
        int grid[][] = new int [n + 1][maxWeight+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= maxWeight; j++){
                if(i == 0 || j == 0)
                    grid[i][j]  = 0;
                else if(weights[i-1] < j){
                    grid[i][j]= isBigger(profits[i-1] + grid[i-1][j-weights[i-1]] , grid[i-1][j]);
                    if(grid[i][j] > minProfit || grid[i][j] == minProfit) {
                        return true;
                    }
                }
                else
                    grid[i][j] = grid[i-1][j];
            }
        }
        return false;
    }

     static int isBigger(int a,int b){
        if(a > b)
            return a;
        else
            return b;
    }
}

