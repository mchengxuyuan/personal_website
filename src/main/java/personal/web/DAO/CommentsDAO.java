package personal.web.DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import personal.web.model.Comments;

@Repository
@Transactional
public class CommentsDAO 
{
	private static final String loadAllSQL="from Comments";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Comments> loadAllComments()
	{
		Query query= entityManager.createQuery(loadAllSQL);
		return query.getResultList();
	}
	
	public Comments loadCommentsById(Integer commentsId)
	{
		return entityManager.find(Comments.class, commentsId);
	}
	
	public void updateComments(Comments comments)
	{
		entityManager.merge(comments);
	}
	public void insertComments(Comments comments)
	{
		entityManager.persist(comments);
	}
	
}
