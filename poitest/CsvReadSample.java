import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
public class CsvReadSample {
    public  String[] tagmatching(String[] tags) {
        // CSVファイルの読み込み
        ArrayList<String> foodname = new ArrayList<String>();
        ArrayList<String> url = new ArrayList<String>();
        ArrayList<String> imageurl = new ArrayList<String>();
        ArrayList<String> ingredientstags = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
            new FileInputStream("dataset.csv"), Charset.forName("utf-8")))) {
            
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                if (index > 0) {
                    String[] data = line.split(",");
                    foodname.add(data[0]);
                    url.add(data[1]);
                    imageurl.add(data[2]);
                    ingredientstags.add(data[3]);


                }
                index++;
            }


        } catch (IOException e) {
            System.out.println("ファイル読み込みに失敗");
        }

        ArrayList<Integer> index = indexmatch(ingredientstags, tags);
        String[] backvar = new String[index.size()*3];
        for(int i = 0; i < index.size() ; i++){
            backvar[i*3] = foodname.get(i);
            backvar[i*3+1] = url.get(i);
            backvar[i*3+2] = imageurl.get(i);
        }
        return backvar;
    }


    public ArrayList<Integer> indexmatch(ArrayList<String> ingredientstags, String[] tags) {
        ArrayList<Integer> index = new ArrayList<>();
        for(int i = 0; i < ingredientstags.size(); i++){
            String ingredientstag = ingredientstags.get(i);
            for(int j = 0; j < tags.length; j++){
                if (!ingredientstag.contains(tags[j])) break;
                if (j == tags.length-1) {
                    index.add(i);
                }
            }
        }
        return index;
        
    }
}