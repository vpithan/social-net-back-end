package br.unisc.socialnet.facade;

import br.unisc.socialnet.model.User;
import br.unisc.socialnet.repository.UserRepository;

public class UserFacade {
    
    UserRepository userRepository = new UserRepository();
    
    public Long create(User user) {
        userRepository.create(user);
        return user.getId();
    }
    
}
