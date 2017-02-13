package com.travolution.json.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travolution.exception.SequenceException;
import com.travolution.json.model.SequenceId;
import com.travolution.mongo.dao.MongoImpl;

@Service
public class SequenceDao {

	@Autowired
	private MongoImpl mongoImpl;
	
	public long getNextSequenceId(String key) throws SequenceException {
	  //this is the magic happened.
	  SequenceId seqId =
			  mongoImpl.findAndModify(key, SequenceId.class);

	  //if no id, throws SequenceException
          //optional, just a way to tell user when the sequence id is failed to generate.
	  if (seqId == null) {
		throw new SequenceException("Unable to get sequence id for key : " + key);
	  }

	  return seqId.getSeq();

	}
	
}
