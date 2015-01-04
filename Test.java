/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Test {
    public static void main(String [] args){
        binarySearchTree myTree = new binarySearchTree();
        int [] arr = {2,5,1,9,0,-3,7};
        for(Integer x: arr){
            myTree.insert(x);
        }
        myTree.inOrder();
        myTree.convert2ChildSum();
        myTree.inOrder();
        myTree.getDiameter();
    }
    
}
