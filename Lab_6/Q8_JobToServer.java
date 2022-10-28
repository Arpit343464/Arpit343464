package com.Lab.Lab_6;
import java.util.*;
class jobToServer{

    int M;
    int[] keys;

    public jobToServer(int M, int[] keys){
        this.M = M;
        this.keys = keys;
    }
    public hash2DArray jobToServerWithAllServer(){
        hash2DArray newHash = new hash2DArray(M, keys);
        return newHash;
    }
    public void printWithAllServer(hash2DArray newHash){
        System.out.println(Arrays.deepToString(newHash.getHashArray()));
    }
    public hash2D jobToServerWithoutCrashServer(int crashValue){
        hash2D new2DHash = new hash2D(M, crashValue, keys);
        return new2DHash;
    }

    public void printWithoutCrashServer(hash2D new2DHash){
        System.out.print("[");
        int i = 0;
        while(i < M){
            if(new2DHash.hash2DArray.get(i).size() == 0){
                new2DHash.hash2DArray.get(i).add(0);
            }
            if(i != 0){
                System.out.println();
            }
            System.out.print("[");
            for (int j = 0; j < new2DHash.hash2DArray.get(i).size(); j++) {
                if(j == new2DHash.hash2DArray.get(i).size() - 1){
                    if(i == new2DHash.hash2DArray.size() - 1){
                        System.out.print(new2DHash.hash2DArray.get(i).get(j) + "]");
                    }
                    else{
                        System.out.print(new2DHash.hash2DArray.get(i).get(j) + "], ");
                    }
                }
                else{
                    System.out.print(new2DHash.hash2DArray.get(i).get(j) + ", ");
                }
            }
            i++;
        }
        System.out.print("]");
    }
}

public class Q8_JobToServer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] keys = new int[126];
        for (int i = 0; i < 126; i++) {
            keys[i] = i + 1;
        }
        jobToServer M = new jobToServer(17, keys);
        M.printWithAllServer(M.jobToServerWithAllServer());
        System.out.print("Number of crash Server: ");
        int crashValue = sc.nextInt();
        M.printWithoutCrashServer((M.jobToServerWithoutCrashServer(crashValue)));
    }
}
