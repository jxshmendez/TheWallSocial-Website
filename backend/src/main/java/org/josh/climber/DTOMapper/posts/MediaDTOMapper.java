package org.josh.climber.DTOMapper.posts;

import org.josh.climber.DTO.posts.response.MediaDTO;
import org.josh.climber.model.posts.MediaModel;
import org.springframework.stereotype.Component;

@Component
public class MediaDTOMapper {

    public MediaDTO toDTO(MediaModel media){
        if (media == null) return null;

        return new MediaDTO(
                media.getMediaId(),
                media.getMedia(),
                media.getMediaUrl(),
                media.getThumbnailUrl()
        );
    }
}
