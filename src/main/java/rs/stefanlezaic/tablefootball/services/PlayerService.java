package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.plusplusnt.fullcircle.lib.services.BaseEntityService;
import rs.stefanlezaic.tablefootball.model.dto.Player;

import java.util.List;

@Service
public interface PlayerService extends BaseEntityService<Player> {
    List<Player> findAll();
}
