public class Tester {
    public static void main(String[] args){
        CsvReadSample temp = new CsvReadSample();
        String[] tags = new String[2];
        tags[0] = "しょうゆ";
        tags[1] = "みりん";
        String[] ans = temp.tagmatching(tags);

        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
