package com.mycompany.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.web.dto.Ch06Board;

@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession sess) {
		String loginResult = "";
		if(mid.equals("admin")) {
			if(mpassword.equals("iot12345")) {
				loginResult = "success";
			} else {
				loginResult = "wrongMpassword";
			}
		} else {
			loginResult = "wrongMid";
		}
		
		sess.setAttribute("loginResult", loginResult);
		return "redirect:/ch06/content";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sess) {
		sess.removeAttribute("loginResult");
		return "redirect:/ch06/content";
	}
	
	@RequestMapping("/fileDownload")
	public void fileDownload(String fname, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		logger.debug(fname);
		
		//Response Header에 추가
		
		ServletContext application = req.getServletContext();
		String mimeType = application.getMimeType(fname);

		// resp.setHeader("Content-Type", mimeType);
		resp.setContentType(mimeType);
		logger.debug("###"+mimeType);
		String userAgent = req.getHeader("User-Agent");	//브라우저의 종류
		String downloadName;
		logger.debug(userAgent);
		if(userAgent.contains("Trident/7.0") || userAgent.contains("MSIE")) {	//IE11 미만에서는 MSIE가 들어있고, 이상에서는 Trident/7.0 이 들어있다. 
			downloadName = URLEncoder.encode(fname, "UTF-8");	//IE11 이하 버전의 IE의 헤더에서는 이렇게 사용해야함
		} else {
			downloadName = new String(fname.getBytes("UTF-8"), "ISO-8859-1");	//WebKit 기반 브라우저(Chrome, Safari, FireFox, Opera, Edge)의 헤더에는 아스키코드(ISO-8859-1)만이 들어갈 수 있기 때문에 한글을 사용하고 싶으면 아스키코드로 변환 
		}
		logger.debug(downloadName);
		resp.setHeader("Content-Disposition", "attachment; filename=\""+downloadName+"\"");	//attachment: 렌더링 하지 말고 다운로드만 해라 , 저장시 파일명 설정
		String realPath = application.getRealPath("/resources/img/"+fname);	//web application(context)의 경로 + war 파일 내의 상대경로 = 파일의 실제 절대경로
		File file = new File(realPath);
		resp.setHeader("Content-Length", file.length()+"");	//미리 파일의 용량을 알게 해준다.
		
		//파일 다운로드시에는 위의 Content-Type, Content-Disposition, Content-Length 세개는 설정하는것이 좋다.
		
		//Response Body에 Data 추가
		OutputStream os =resp.getOutputStream();
		
		logger.debug(realPath);
		
		InputStream is = new FileInputStream(realPath);
		
		byte[] buffer = new byte[1024];
		while(true) {
			int readByte = is.read(buffer);
			if(readByte==-1) break;
			os.write(buffer, 0, readByte);
		}
		os.flush();
		os.close();
		is.close();
	}
	@RequestMapping("/jsonDownload1")
	public String jsonDownload1(Model model) {
		Ch06Board board = new Ch06Board();
		board.setBno(100);
		board.setBtitle("복습 언제 다하냐구");
		board.setBcontent("짜증남");
		board.setWriter("김상엽");
		board.setDate(new Date());
		board.setHitcount(1);
		
		model.addAttribute("board", board);
		
		return "ch06/jsonDownload1";
	}
	
	@RequestMapping("/jsonDownload2")
	public void jsonDownload2(HttpServletResponse resp) throws Exception {
		
		Ch06Board board = new Ch06Board();
		board.setBno(300);
		board.setBtitle("내 양옆엔 오타쟁이가 산다");
		board.setBcontent("나는 인간 컴파일러");
		board.setWriter("김상엽");
		board.setDate(new Date());
		board.setHitcount(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("bno", board.getBno());
		jsonObject.put("btitle", board.getBtitle());
		jsonObject.put("writer", board.getWriter());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		jsonObject.put("date", sdf.format(board.getDate()));
		jsonObject.put("hitcount", board.getHitcount());
		String json = jsonObject.toString();
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
}
