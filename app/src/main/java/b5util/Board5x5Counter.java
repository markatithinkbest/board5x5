package b5util;

import java.util.List;

public class Board5x5Counter implements Board5x5{
	int lineCnt=Board5x5.ERROR_NOT_IN_CATEGORY;
	int[] cells;
	
	
	@Override
	public int getLineCount() {
		return lineCnt;
	}

	@Override
	public void setChecked(int[] checked) {
		if (checked.length>25){
			lineCnt=Board5x5.ERROR_ARRAY_SIZE_TOO_BIG;
			return ;
		}
		for (int i=0;i<checked.length;i++){
			if (checked[i]<0){
				lineCnt=Board5x5.ERROR_ARRAY_VALUE_BELOW_MINUMUN;
						
				return ;
			}
			if (checked[i]>24){
				lineCnt=Board5x5.ERROR_ARRAY_VALUE_ABOVE_MAXINUM;
				
				return ;					
			}
		}
		cells=new int[25];
		for (int i=0;i<cells.length;i++){
		//	cells[i]=-1;
			System.out.print(cells[i]+" ");			
		}		
		System.out.println();		
		
		int tmp;
		for (int i=0;i<checked.length;i++){
			tmp=checked[i];
			cells[tmp]=1;
		//	System.out.print(tmp+" ");			
		}		
		//System.out.println();	
		
		for (int i=0;i<cells.length;i++){
			//	cells[i]=-1;
				System.out.print(cells[i]+" ");			
			}		
			System.out.println();	
		
		
		
		
		// TODO Auto-generated method stub
		lineCnt=0;
		for (int[] oneLine:lines){
			boolean lineResult=true;
			
			for (int oneCell:oneLine){
				System.out.print(oneCell+" ");
				if (cells[oneCell]!=1){
					lineResult=false;
					System.out.print(" --- not line ");
					break;
				}
			
			//	if ()
			}
			if (lineResult){
				lineCnt++;
				System.out.print(" <== Count it one line ");
			}
			System.out.println();
		//	if 
			
		}
		
		
		//return true;
	}

}
