package personal.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import personal.web.DAO.CommentsDAO;
import personal.web.model.Comments;

@Controller
public class CommentsController 
{
	private static final String UNDERSCORE = "_";
	private static final String SINGLE_SPACE = " ";
	
	
	@Autowired
	private CommentsDAO commentsDAO;
	
	@RequestMapping(value="/getAllComments")
	@ResponseBody
	public List<Comments> getAllComments()
	{
		List<Comments> comments = null;
		try
		{
			comments= getCommentsDAO().loadAllComments();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return comments;
	}
	
	@RequestMapping(value = "/getCommentsById")
	@ResponseBody
	public Comments getCommentsById(String userId) {
		

		Comments comment = null;
		try {
			comment = getCommentsDAO().loadCommentsById(Integer.parseInt(userId));	

		} catch (Exception ex) {
			
		}

		return comment;
	}
	
	
	
	@RequestMapping(value = "/updateComment", method = RequestMethod.POST)
	@ResponseBody
	public Boolean updateComment(@RequestBody Comments comment) {
		

		try {
			Comments existingComment = comment;
							
			getCommentsDAO().updateComments(existingComment);
			

		} catch (Exception ex) {
			
			return false;
		}

		
		return true;
	}
	
	@RequestMapping(value = "/addComments", method = RequestMethod.POST)
	@ResponseBody
	public Boolean addComments(@RequestBody Comments comment) {
	

		try {

			//comment.setTIME(new java.sql.Timestamp(System.currentTimeMillis()));
			getCommentsDAO().insertComments(comment);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	
	public CommentsDAO getCommentsDAO()
	{
		return commentsDAO;
	}
}
