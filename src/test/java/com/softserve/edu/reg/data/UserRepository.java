package com.softserve.edu.reg.data;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getAdmin() {
		return User.get()
				.setFirstname("Administrator")
				.setLastname("Administrator")
				.setEmail("admin@admin.com")
				.setLogin("admin")
				.setPassword("admin")
				.setCommunity("Manage")
				.build();
	}

	public static User getRegistrator() {
		return User.get()
				.setFirstname("registrator")
				.setLastname("registrator")
				.setEmail("harasym@mail.ua")
				.setLogin("registrator")
				.setPassword("registrator")
				.setCommunity("Registrator")
				.build(); 
	}

	public static User getNewUser() {
		return  User.get()
				.setFirstname("registrator1")
				.setLastname("registrator1")
				.setEmail("harasym@mail.ua")
				.setLogin("registrator1")
				.setPassword("registrator1")
				.setCommunity("������")
				.build();
	}



	// public static User getFromDB() {
	// MyDBManager dbm = new MyDBManager();
	// return dbm.getUser();
	// }

}
