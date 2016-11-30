package service.Order.EvaluateOrder;

public interface EvaluateOrderService {
	
	/**
	 * @param 评论内容,对设施的评分,对服务的评分,对周围环境的评分
	 * @return 增加评论信息
	 * */
	public boolean addComment(String comment,int point_facilities,int point_service,int surroundings);
	
	/**
	 * @param 评论内容
	 * @return 追加评论内容
	 * */
	public boolean addExtraComment(String comment);
}
