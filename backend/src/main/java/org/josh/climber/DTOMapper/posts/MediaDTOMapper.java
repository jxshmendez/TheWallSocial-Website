package org.josh.climber.DTOMapper.posts;

import org.josh.climber.DTO.posts.MediaDTO;
import org.josh.climber.model.posts.MediaModel;

public class MediaDTOMapper {

    public static MediaDTO toDTO(MediaModel media){
        if (media == null) return null;

        return new MediaDTO(
                media.getMediaId(),
                media.getMedia(),
                media.getMediaUrl(),
                media.getThumbnailUrl()
        );
    }
}
