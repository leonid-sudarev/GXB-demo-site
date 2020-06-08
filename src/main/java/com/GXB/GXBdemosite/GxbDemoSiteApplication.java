package com.GXB.GXBdemosite;

import com.GXB.GXBdemosite.dao.Comment;
import com.GXB.GXBdemosite.dao.Post;
import com.GXB.GXBdemosite.dao.Role;
import com.GXB.GXBdemosite.dao.User;
import com.GXB.GXBdemosite.dao.UserDetails;
import com.GXB.GXBdemosite.repository.CommentRepository;
import com.GXB.GXBdemosite.repository.PostRepository;
import com.GXB.GXBdemosite.repository.RoleRepository;
import com.GXB.GXBdemosite.repository.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GxbDemoSiteApplication {
UserRepository userRepository;
PostRepository postRepository;
RoleRepository roleRepository;
CommentRepository commentRepository;

	@Autowired
	public void setCommentRepository(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Autowired
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Autowired
	public GxbDemoSiteApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GxbDemoSiteApplication.class, args);
	}


	@Bean
	public ApplicationRunner init() {
		return args -> {
			System.out.println("Insert roles ...");
			createRoles();
			System.out.println("Insert new user ...");
			userRepository.save(getNewUser());
			System.out.println("Insert new admin ...");
			userRepository.save(getNewAdmin());
			Post post = saveNewPost();
		 	postRepository.save(post);
		 	commentRepository.save(saveNewComment(post));
		};
}

	private Comment saveNewComment(Post post) {
		Comment comment = new Comment();
		comment.setPost(post);
		comment.setBody("New Comment");
		return comment;
	}

	private void createRoles() {
		roleRepository.save(new Role(1L, "ROLE_USER"));
		roleRepository.save(new Role(2L, "ROLE_ADMIN"));
	}

	private Post saveNewPost() {
		Post post = new Post();
		post.setId(1L);
		post.setTitle("High-Performance Java, 1st Edition");
		return post;
	}

	private User getNewUser() {
		User user = new User();
		UserDetails userDetails = new UserDetails();
		user.setEmail("sdgsdg@gmail.com");
		user.setEnabled(true);
		user.setPassword("user_pass");
		user.setUsername("user");
		user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
		return user;
	}

	private User getNewAdmin() {
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setEnabled(true);
		user.setPassword("admin_pass");
		user.setUsername("admin");

		user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
		return user;
	}
}
