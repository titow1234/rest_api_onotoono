package com.one.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.onetoone.model.User;
import com.one.onetoone.model.Address;
import com.one.onetoone.repository.UserRepository;

/**
 * Este es la entidad principal o entidad propietaria de la relacion,
 * es llamada asi por ser quien se mapea a una tabla que tiene
 * la columna que referencia al id de la tabla "address". En otras
 * palabras es quien tiene la clave foranea. Esto se puede ver ademas
 * porque asi lo dice la anotacion @JoinColumn(name= .....) que es el 
 * atributo "name" donde se especifica el nombre da la columna de la
 * clave foranea. Por lo tanto la tabla "address" es la talba de referencia
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        User user = userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("El user con id " + id +" no se encueentra."));
        
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user) {
        Address address = user.getAddress();
        User otherUser = userRepository.findById(id)
                                       .orElseThrow(() -> new RuntimeException("El usuario con " + id + " que se intenta actualizar no existe"));
        Address otherAddress =otherUser.getAddress();
        
        otherAddress.setStreet(address.getStreet());
        otherAddress.setCity(address.getCity());

        otherUser.setUserName(user.getUserName());
        otherUser.setAddress(otherAddress);
        
        return userRepository.save(otherUser);
    }

    public void deletUser(Long id) {
        boolean existUser = userRepository.existsById(id);

        if (!existUser) {
            throw new RuntimeException("El usuario con id " + id + "que intentas borrar, no existe");
        }
        
        userRepository.deleteById(id);
    }
}
