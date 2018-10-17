import java.util.ArrayList;
import java.util.List;

public class ShipSunkProblems {
    public String solution(int N, String S, String T){
        if(S.length()==0) return "0,0";
        if(T.length()==0) return "0,0";
        int hit = 0, sunk = 0;
        String [] shipList = S.split(",");
        for(String ship : shipList){
            int n[][] = new int[N][N];
            int cellCount = 0;
            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            String [] axis = ship.split(" ");
            for(String xy : axis){
                String x = new String() , y = new String();
                for(char c : xy.toCharArray()){
                    if(!Character.isLetter(c)){
                        x = x + c;
                    }else{
                        y = y + ((c - 65)+1);
                    }
                }
                xList.add(Integer.parseInt(x));
                yList.add(Integer.parseInt(y));
            }
            for(int i = xList.get(0)-1; i < xList.get(1); i++){
                for(int j = yList.get(0)-1; j < yList.get(1); j++){
                    if(n[i][j]==0){
                        n[i][j] = 1;
                        cellCount++;
                    }
                }
            }
            List<Integer> boXList = new ArrayList<>();
            List<Integer> boYList = new ArrayList<>();
            for(String bo : T.split(" ")){
                String x = new String() , y = new String();
                for(char c : bo.toCharArray()){
                    if(!Character.isLetter(c)){
                        x = x + c;
                    }else{
                        y = y + ((c - 65)+1);
                    }
                }
                boXList.add(Integer.parseInt(x));
                boYList.add(Integer.parseInt(y));
            }
            int hitCount = 0;
            for(int i = 0; i < boXList.size(); i++){
                if(n[boXList.get(i)-1][boYList.get(i)-1] == 1){
                    n[boXList.get(i)-1][boYList.get(i)-1] = 0;
                    hitCount++;
                }

            }
            if(hitCount > 0 && cellCount == hitCount){
                sunk++;
            }else if (hitCount > 0){
                hit++;
            }
        }
        String res = ""+sunk+","+hit;
        return res;
    }
    public  static void main(String args[]){
        int N = 12;
//        String s = "1A 2A,12A 12A";
//        String t = "12A";
        String s = "1B 2C,2D 4D";
        String t = "2B 2D 3D 4D 4A";
        ShipSunkProblems e = new ShipSunkProblems();
        System.out.println(e.solution(N,s,t));
    }
}
