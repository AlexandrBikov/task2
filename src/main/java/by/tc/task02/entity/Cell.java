package by.tc.task02.entity;


import java.util.ArrayList;

/**
 *      Data cell. Contains info about itself
 * and array of subCells
 *
 * */
public class Cell {
    private String name;
    private String attributeName;
    private String attribute;
    private String data;
    private Cell[] subCells = new Cell[0];
    private int layer;

    public Cell(String name, int layer) {
        this.layer = layer;
        this.name = name;
    }

    public void setSubCells(ArrayList<Cell> subCells) {
        this.subCells = subCells.toArray(this.subCells);
    }

    public void setAttribute(String attribute, String attributeName) {
        this.attribute = attribute.trim();
        this.attributeName = attributeName.trim();
    }

    public void setData(String data) {
        this.data = data.trim();
    }

    public Cell[] getSubCells() {
        return subCells;
    }

    public int getLayer() {
        return layer;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getName() {
        return name;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getData() {
        return data;
    }

}
