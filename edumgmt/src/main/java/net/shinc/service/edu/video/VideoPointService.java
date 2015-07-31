package net.shinc.service.edu.video;

import java.util.List;

import net.shinc.orm.mybatis.bean.VideoPoint;
/**
  * @ClassName: VideoPointService
  * @Description: 知识点服务接口
  * @author hushichong
  * @date 2015年7月31日 下午5:21:13
 */
public interface VideoPointService {
    
    public void deleteVideoPointById(Integer id);

	public Integer insertVideoPoint(VideoPoint videoPoint);

	public void updateVideoPoint(VideoPoint videoPoint);

	public VideoPoint getByVideoPointById(Integer id);

	public List<VideoPoint> getVideoPointList(VideoPoint videoPoint);

	public Integer getVideoPointListCount(VideoPoint videoPoint);
	
	/**
	 * @Title: getVideoPoint
	 * @Description: 根据对象参数得到单个实例
	 * @param videoPoint
	 * @return videoPoint
	 */
	public VideoPoint getVideoPoint(VideoPoint videoPoint);
}