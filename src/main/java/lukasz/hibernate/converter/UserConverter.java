package lukasz.hibernate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import lukasz.hibernate.entity.User;
import lukasz.hibernate.repository.UserRepository;


public class UserConverter implements Converter<String, User> {
	@Autowired
	private UserRepository userRepo;

	@Override
	public User convert(String source) {
		long longId = Long.parseLong(source);
		User user = userRepo.findOne(longId);
		return user;
	}
}