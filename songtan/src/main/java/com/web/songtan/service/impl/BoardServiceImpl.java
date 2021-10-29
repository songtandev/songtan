package com.web.songtan.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.security.cert.CollectionCertStoreParameters;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.songtan.dao.BoardDAO;
import com.web.songtan.domain.BoardVO;
import com.web.songtan.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public List<BoardVO> selectList() 
	{
		System.out.println("Service");
		return boardDao.selectList();
	}

	@Override
	public boolean exportFile(BoardVO boardVO) throws Exception 
	{
		boolean flag = false;
		// Header 입력할 내용
		String[] columns = {"번호", "ID", "PW", "이름", "전화번호", "삭제여부", "생성일", "수정일"};
		List<BoardVO> userList = boardDao.selectList();
		
		// 파일 저장될 위치
		String path = "C:\\Users\\apple\\OneDrive\\바탕 화면";
		try 
		{	
			// 파일 이름 및 파일 out 객체 생성
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = sf.format(cal.getTime());
			File file = new File(path + "user_info_"+ date +".xlsx");
			FileOutputStream out = new FileOutputStream(file);
			
			// poi 라이브러리 excel 파일 생성
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet();
			
			// 최상단 Header 세팅
			int header = 0;
			Cell headerCell = null;
			XSSFRow headerRow = sheet.createRow(header);
			for(int i=0; i<columns.length; i++) 
			{
				headerCell = headerRow.createCell(i);
				headerCell.setCellValue(columns[i]);
			}
			
			// data row 세팅
			for(BoardVO user : userList) 
			{
				// 날짜 데이터 포맷
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				XSSFRow row = sheet.createRow(++header);
				int cellCnt = 0;
				Cell dataCell = null;
			
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(user.getNo());
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(user.getId());
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(user.getPw());
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(user.getName());
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(user.getTel_no());
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(user.getDelete_yn());
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(sdf.format(user.getCreate_date()));
				dataCell = row.createCell(cellCnt++);
				dataCell.setCellValue(sdf.format(user.getUpdate_date()));
			}
			workbook.write(out);
			out.close();
			flag = true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}

}
