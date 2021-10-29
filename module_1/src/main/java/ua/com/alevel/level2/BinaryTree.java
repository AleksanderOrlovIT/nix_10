package ua.com.alevel.level2;

import java.util.Scanner;

public class BinaryTree {
    public static void BinaryTreeMain(){
        int restart_number;
        do {
            int insert_number;
            Scanner sc = new Scanner(System.in);
            BinaryTreeAlgorythms tree = new BinaryTreeAlgorythms();
            System.out.println("How many inserts do you want?");
            insert_number = sc.nextInt();
            for (int i = 0; i < insert_number; i++) {
                tree.insert((int) (Math.random() * 100));
            }
            System.out.println("Depth of tree: " + tree.depth());
            tree.print();
            System.out.println("Please press 1 if you want to restart BinaryTree application");
            while(!sc.hasNextInt()){
                sc.next();
            }
            restart_number = sc.nextInt();
        }while(restart_number == 1);
    }
}
