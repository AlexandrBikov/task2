package by.tc.task02.controller;


import by.tc.task02.dao.DAOReaderException;
import by.tc.task02.dao.DAOTreeMakerException;
import by.tc.task02.entity.Cell;
import by.tc.task02.view.viewUserInterface;
import by.tc.task02.service.serviceTreeMaker;

public class Main {
    public static void main(String args[]) {
        Cell rootCell;
        serviceTreeMaker treeMaker = new serviceTreeMaker();
        viewUserInterface UI = new viewUserInterface();
        try {
            rootCell = treeMaker.makeTree();
            UI.printAllCells(rootCell);
        } catch (DAOReaderException e) {
            UI.wrongFileName();
        } catch (DAOTreeMakerException e) {
            UI.emptyFile();
        }
    }
}
