package net.shinc.orm.mybatis.bean.edu;

import javax.validation.constraints.NotNull;

public class Book {
	private Integer id;

	private Integer parterId;
	
	@NotNull(message = "{book.name.not.empty}")
	private String name;

	private String status;
	
	private String numReservation;
	
	private String problemNum;
	
	//视频数量
	private String videoNum;
	
	//拥有视频的二维码数量
	private String countHasVideo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideoNum() {
		return videoNum;
	}

	public void setVideoNum(String videoNum) {
		this.videoNum = videoNum;
	}

	public Integer getParterId() {
		return parterId;
	}

	public void setParterId(Integer parterId) {
		this.parterId = parterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getNumReservation() {
		return numReservation;
	}

	public void setNumReservation(String numReservation) {
		this.numReservation = numReservation == null ? null : numReservation.trim();
	}

	public String getProblemNum() {
		return problemNum;
	}

	public void setProblemNum(String problemNum) {
		this.problemNum = problemNum;
	}

	public String getCountHasVideo() {
		return countHasVideo;
	}

	public void setCountHasVideo(String countHasVideo) {
		this.countHasVideo = countHasVideo;
	}
	
}