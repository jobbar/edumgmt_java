package net.shinc.controller.edu.video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.Course;
import net.shinc.orm.mybatis.bean.Keyword;
import net.shinc.orm.mybatis.bean.KnowledgePoint;
import net.shinc.orm.mybatis.bean.VideoBase;
import net.shinc.orm.mybatis.bean.VideoDetail;
import net.shinc.orm.mybatis.bean.VideoPastpaper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class VideoPastpaperControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private ResultHandler handler;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		handler = MockMvcResultHandlers.print();
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void getVideoPastpaperAndRelevantInfoList() {
		List list = new ArrayList();
		VideoPastpaper videoPastpaper = new VideoPastpaper();
		Keyword keyword = new Keyword();
		VideoBase videoBase = new VideoBase();
		keyword.setName("关键字1");
		list.add(keyword);
		keyword = new Keyword();
		keyword.setName("222");
		list.add(keyword);
		videoBase.setKeywordList(list);
		videoPastpaper.setVideoBase(videoBase);
		videoPastpaper.setVideoBaseId(2);
		Gson g = new Gson();
		String str = g.toJson(videoPastpaper);
		System.out.println(str);
		RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoPastpaper/getVideoPastpaperAndRelevantInfoList").header("Content-Type", MediaType.APPLICATION_JSON.toString())
				.content(str);// 设置请求体

		try {
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@WithMockUser(username = "admin", password = "admin", authorities = { "adminUserList" })
	public void testaddVideoPastpaper() {
		try {
			VideoPastpaper videoPastpaper = new VideoPastpaper();
			VideoBase videoBase = new VideoBase();
			
			// 视频详情
			List list = new ArrayList();
			VideoDetail VideoDetail = new VideoDetail();
			VideoDetail.setUrl("urla");
			VideoDetail.setType("1");
			list.add(VideoDetail);
			videoBase.setVideoDetailList(list);
			VideoDetail = new VideoDetail();
			VideoDetail.setUrl("urlb");
			VideoDetail.setType("2");
			list.add(VideoDetail);
			videoBase.setVideoDetailList(list);
			
			// 知识点
			list = new ArrayList();
			KnowledgePoint knowledgePoint = new KnowledgePoint();
			knowledgePoint.setId(1);
			list.add(knowledgePoint);
			knowledgePoint.setId(3);
			list.add(knowledgePoint);
			videoBase.setKeywordList(list);
			
			// 关键字
			list = new ArrayList();
			Keyword keyword = new Keyword();
			keyword.setId(3);
			list.add(keyword);
			keyword.setId(4);
			list.add(keyword);
			videoBase.setKeywordList(list);

			Course course = new Course();
			course.setId(1);
			videoBase.setCourse(course);

			videoBase.setAdminUserId(2);
			videoBase.setDifficulty("1");
			videoBase.setCourseId(2);
			videoBase.setLectureId(2);
			videoBase.setTitle("title");
			videoBase.setDesc("desc");
			videoBase.setProfile("profile");
			videoBase.setQuestionId("12313354");
			videoBase.setQuestionNumber("66");

			videoPastpaper.setVideoBase(videoBase);
			videoPastpaper.setQuestionbankId(1);
			videoPastpaper.setQuestionbankYearId(1);
			videoPastpaper.setQuestionTypeId(1);
			videoPastpaper.setQuestionbankTypeId(1);

			Gson g = new Gson();
			String str = g.toJson(videoPastpaper);
			System.out.println(str);
			RequestBuilder reqbuild = MockMvcRequestBuilders.post("/videoPastpaper/addVideoPastpaper").header("Content-Type", MediaType.APPLICATION_JSON.toString()).content(str);// 设置请求体
			mockMvc.perform(reqbuild).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}