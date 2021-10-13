
import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.ArrayList;

public class CSV {
  public AppData load(String filename) {
   final String space_extractor = ";";
     AppData data = new AppData();
      String[] header = new String[0];
      ArrayList<int[]> ints = new ArrayList<int[]>();
      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          String line;
          line = br.readLine();
          header = line.split(space_extractor);
      int length = header.length;
      while ((line = br.readLine()) != null) {
      String integers[] = line.split(space_extractor);
      int[] mas = new int[length];
      for (int i = 0; i < length; ++i) {
     mas[i] = Integer.parseInt(integers[i]);
}
        ints.add(mas);
  }
       } catch (IOException e) {
          e.printStackTrace();
 }
       int[][] intData = new int[ints.size()][];
            int k = 0;
            for (int[] mas : ints) {
                 intData[k++] = mas;
 }
            data.setData(header, intData);
            return data;
  }

  public void save(AppData data, String filename) {
           String[] header = data.getHeader();
           FileWriter toFile = null;
          try {
         toFile = new FileWriter(filename);
          int headerSize = header.length;
          for (int i = 0; i < headerSize - 1; ++i) {
               toFile.write(header[i]+";");
  }
       toFile.write(header[headerSize - 1]+"\n");


       for (int[] mas : data.getData()) {
           int length = mas.length;
           for (int i = 0; i < length - 1; i++) {
                 toFile.write(mas[i]+";");
  }
           toFile.write(mas[length - 1]+"\n");
  }
}
       catch (IOException er) {
       System.err.println("Error while writing file: " + er.getLocalizedMessage());
   }
        finally {
           if (null != toFile) {
             try {
                 toFile.close();
         }
            catch (IOException er) {
                er.printStackTrace(System.err);
          }
               }
           }
     }
}
