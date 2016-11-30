package service.Client.ProvidedService;

public class Vip {

	private int grade[] = {
			1000,2000,4000,7000,10000
	};
	
	/**
	 * @param point 客户的信用点
	 * @return 返回客户的vip等级
	 * */
	public int getGrade(double point){
		
		int result =0;
		for(int i=0;i<grade.length;i++){
			if(point>=grade[i]){
				result++;
			}else{
				break;
			}
		}
		return result;
	}
	
	
}
