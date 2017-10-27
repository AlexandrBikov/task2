package by.tc.task02.service;

import by.tc.task02.dao.DAOReaderException;
import by.tc.task02.dao.DAOTreeMaker;
import by.tc.task02.dao.DAOTreeMakerException;
import by.tc.task02.entity.Cell;

public class serviceTreeMaker  {
    public Cell makeTree() throws DAOReaderException, DAOTreeMakerException{
        DAOTreeMaker treeMaker = new DAOTreeMaker();
        return treeMaker.makeTree();
    }
}
