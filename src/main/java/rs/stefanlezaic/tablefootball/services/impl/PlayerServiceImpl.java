package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.plusplusnt.fullcircle.lib.services.BaseEntityService;
import rs.stefanlezaic.tablefootball.model.dto.Player;
import rs.stefanlezaic.tablefootball.repository.PlayerRepository;

import java.util.Optional;

@Service
@Transactional
@Primary
public class PlayerServiceImpl implements BaseEntityService<Player> {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<Player> findByUuid(String s) {
        return Optional.empty();
    }

    @Override
    public Player add(Player player) {
        return null;
    }

    @Override
    public Optional<Player> update(Player player) {
        return Optional.empty();
    }

    @Override
    public Optional<Player> removeByUuid(String s) {
        return Optional.empty();
    }
}
