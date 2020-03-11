package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.HotelDTO;



public class HotelReportPdfView extends AbstractPdfView {

	

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<HotelDTO> listDTO=null;
		Paragraph ph=null;
		Table table=null;
		// get Model Attribute
		listDTO=(List<HotelDTO>) map.get("hotelsDTO");
		//add heading as paragrah
		ph=new Paragraph("Hotels Report",new Font(Font.BOLD));
		doc.add(ph);
		//add table having report content
		table=new Table(6,listDTO.size());
		for(HotelDTO dto:listDTO){
			table.addCell(String.valueOf(dto.getHotelId()));
			table.addCell(dto.getHotelName());
			table.addCell(dto.getHotelType());
			table.addCell(dto.getLocation());
			table.addCell(dto.getPriceRange());
			table.addCell(String.valueOf(dto.getSize()));
		}
		doc.add(table);
	}//method
}//class
