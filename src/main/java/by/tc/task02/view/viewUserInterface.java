package by.tc.task02.view;

import by.tc.task02.entity.Cell;

public class viewUserInterface {

    /**
     *      Shows message about wrong file name and
     * asks to enter it again.
     *
     * */
    public void wrongFileName(){
        System.out.println("File not found.");
    }

    public void printAllCells(Cell rootCell){
        printTab(rootCell.getLayer());
        if(rootCell.getAttribute()!=null) {
            System.out.println(rootCell.getAttributeName() + " = " + rootCell.getAttribute());
            printTab(rootCell.getLayer());
        }
        System.out.print(rootCell.getName());
        if(rootCell.getData()!=null){
            System.out.println(":\t" + rootCell.getData());
        } else {System.out.println();}
        for (Cell c: rootCell.getSubCells()){
            printAllCells(c);
        }
    }

    private void printTab(int count){
        for (int i = 0; i<count; i++){
            System.out.print("\t");
        }
    }

    public void emptyFile(){
        System.out.println("File is Empty");
    }
}
