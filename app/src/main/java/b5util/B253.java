package b5util;

/**
 * Created by u1 on 2015/5/19.
 */
public class B253 {
    int val[];

    public B253() {
        val=new int[25];
        for (int i=0;i<25;i++){
            val[i]=1+i;
        }
    }
    @Override
    public String toString(){
         StringBuilder sb=new StringBuilder();
        for (int i=0;i<25;i++){
            String str=String.format("%2d",val[i]);
            sb.append(" "+str);

            if (((1+i) % 5)==0){
                sb.append("\n");

            }
        }
        return sb.toString();
    }
}
