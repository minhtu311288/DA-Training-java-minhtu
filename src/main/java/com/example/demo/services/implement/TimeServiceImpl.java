package com.example.demo.services.implement;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.TimeDTO;
import com.example.demo.model.QTimes;
import com.example.demo.model.Times;
import com.example.demo.respo.timelist;
import com.example.demo.services.TimeService;
import com.example.demo.utils.LogUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class TimeServiceImpl implements TimeService {
	
	@Autowired
	private timelist timeList;
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Times> findAll() {
		
		List<Times> Times = (List<Times>) timeList.findAll();
		
		return Times;
	}
	
	@Override
    public TimeDTO findById(UUID UUID) {
    	
    	Times times = timeList.findById(UUID).get();
    	
    	ModelMapper modelMapper = new ModelMapper();
    	
    	TimeDTO timeDto = modelMapper.map(times, TimeDTO.class);
		
		LogUtil.debug(this.getClass(),"show time inpocess");
    	
    	if (times == null) { 
    		return null;
    	}
    	
		return timeDto;
    }
    @Override
	public String save(){
    	
		UUID uuid = UUID.randomUUID();
		
        Date date = new Date();
        
		Times time = new Times(uuid,1988, 12, 12, date, date);
		
		timeList.save(time);
		
		return uuid.toString();
	}
    
    @Override
    public TimeDTO getTimeByID(UUID UUID) {
    	
    	QTimes qTime = QTimes.times;
		
		JPAQueryFactory factory = new JPAQueryFactory(em);
		
		Times times = factory.selectFrom(qTime).where(qTime.time_id.eq(UUID)).fetchOne();
		
		ModelMapper modelMapper = new ModelMapper();
    	
		TimeDTO timeDto = modelMapper.map(times, TimeDTO.class);
		
		return timeDto;
	}

	@Override
	public List<Times> getTimes() {
		
		QTimes qTime = QTimes.times;
		
		JPAQueryFactory factory = new JPAQueryFactory(em);
		
		List<Times> times = factory.selectFrom(qTime).fetch();
		
		return times;
	}
	
	
}
