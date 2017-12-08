package org.veeragh.sample.RestMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.veeragh.sample.RestMessenger.database.DatabaseClass;
import org.veeragh.sample.RestMessenger.model.Message;

public class MessageService {
	
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello World", "Veeragh Goudar"));
		messages.put(2L, new Message(1, "Hello Jerssy", "Veeragh Goudar"));
		messages.put(3L, new Message(1, "Hello JAX rx", "Veeragh Goudar"));
	}
	
	public List<Message> getAllMessages(){
				return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message msg){
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){	
		if(msg.getId() <=0){
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	public Message removeMessage(long id){
		return messages.remove(id);		
	}
	
	/*public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L, "Hello World", "Veeragh Goudar");
		Message m2 = new Message(2L, "Hello JAX rx", "Veeragh Goudar");
		Message m3 = new Message(3L, "Hello Jerssy", "Veeragh Goudar");
		
		List<Message> list = new ArrayList<>();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		return list;
		
	}*/
	

}
