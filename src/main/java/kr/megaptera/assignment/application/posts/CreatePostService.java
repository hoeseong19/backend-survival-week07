package kr.megaptera.assignment.application.posts;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.posts.CreatePostDto;
import kr.megaptera.assignment.dtos.posts.PostDto;
import kr.megaptera.assignment.models.posts.Post;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreatePostService {
    private final PostRepository postRepository;

    public CreatePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto createPost(CreatePostDto createPostDto) {
        Post newPost = new Post(
                createPostDto.getTitle(),
                createPostDto.getAuthor(),
                createPostDto.getContent()
        );

        this.postRepository.save(newPost);

        return PostDto.of(newPost);
    }
}
