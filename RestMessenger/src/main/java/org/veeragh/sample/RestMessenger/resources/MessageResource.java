package org.veeragh.sample.RestMessenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.veeragh.sample.RestMessenger.model.Message;
import org.veeragh.sample.RestMessenger.service.MessageService;


@Path("/messages")
public class MessageResource {
	
	
	MessageService messageService = new MessageService();
	
 /*   @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
    	return messageService.getAllMessages();
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
    	return messageService.getAllMessages();
    }
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message msg){
    	return messageService.addMessage(msg);
    }
    
    
    @GET
    @Path("/{messagdId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messagdId") long msgId){
    	return messageService.getMessage(msgId);
    }
    
    @PUT
    @Path("/{messagdId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messagdId") long msgId, Message msg){
    	msg.setId(msgId);
    	return messageService.updateMessage(msg);
    }
    
    @DELETE
    @Path("/{messagdId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messagdId") long msgId){
    	    	return messageService.removeMessage(msgId);
    }
    
  
    
}
