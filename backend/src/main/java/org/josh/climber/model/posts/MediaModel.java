package org.josh.climber.model.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MediaType media;
    @Column(columnDefinition = "TEXT")
    private String mediaUrl;
    @Column(columnDefinition = "TEXT")
    private String thumbnailUrl;

    /* FK */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonBackReference("post-media")
    private PostsModel post;

}
