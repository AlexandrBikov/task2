package by.tc.task02.dao;

        import java.io.File;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.FileNotFoundException;
        import java.io.IOException;

public class DAOReader {

    private String FilePath = this.getClass().getResource("/task02.xml").getFile() ;

    /**
     *      Reads information from xml file
     *
     * @return String line with text from file
     * */
     public String readFile() throws DAOReaderException {

        String lines = "";
        String line;
        FilePath = FilePath.replaceAll("%20", " ");
        try{
            File xmlFile = new File(FilePath);
            BufferedReader fin = new BufferedReader(new FileReader(xmlFile));
            while ((line = fin.readLine())!= null){
                lines += line;
            }
        } catch (FileNotFoundException e) {
            throw new DAOReaderException();
        } catch(IOException e) {
            System.out.println("IOException");
        }

        return lines;
    }

}

