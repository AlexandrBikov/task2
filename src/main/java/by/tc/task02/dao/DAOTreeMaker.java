package by.tc.task02.dao;

import by.tc.task02.entity.Cell;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DAOTreeMaker {
    private DAOReader reader = new DAOReader();

    private String openTag = "<([^/]\\w*)(\\s+(\\w+)\\s*=\\s*['\"](\\w+)['\"]\\s*)*>";

    private Pattern searchOpenTag = Pattern.compile(openTag);

    public Cell makeTree() throws DAOReaderException, DAOTreeMakerException {

        String line = reader.readFile().trim();

        Cell rootCell;
        if(!line.isEmpty()) {
            rootCell = parser(line, 0, null);
        } else{
            throw new DAOTreeMakerException();
        }
        return rootCell;
    }

    private Cell parser(String line, int layer, Cell rootCell) {
        String name;
        String elementInsides;
        String closeTag;
        String attributeName;
        String attribute;

        int startPoint = 0;

        Pattern searchCloseTag;
        ArrayList<Cell> cellList = new ArrayList<>();
        Matcher closeTagMatcher;
        Matcher openTagMatcher = searchOpenTag.matcher(line);
        Cell currentCell = null;

        while (openTagMatcher.find(startPoint)) {
            name = openTagMatcher.group(1);
            currentCell = new Cell(name, layer);
            attribute = openTagMatcher.group(4);
            attributeName = openTagMatcher.group(3);
            if (attributeName != null) {
                currentCell.setAttribute(attribute, attributeName);
            }
            closeTag = "</" + name + ">";
            searchCloseTag = Pattern.compile(closeTag);
            closeTagMatcher = searchCloseTag.matcher(line);
            closeTagMatcher.find();
            startPoint = closeTagMatcher.end() - 1;
            elementInsides = line.substring(openTagMatcher.end(), closeTagMatcher.start()).trim();
            cellList.add(currentCell);
            if (elementInsides.startsWith("<")) {
                parser(elementInsides, layer + 1, currentCell);
            } else if (rootCell!=null) {
                currentCell.setData(elementInsides);
            }
        }
        if (rootCell!=null) {
            rootCell.setSubCells(cellList);
        }
        return currentCell;
    }
}



