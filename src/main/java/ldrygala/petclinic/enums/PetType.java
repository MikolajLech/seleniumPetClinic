package ldrygala.petclinic.enums;

public enum PetType {
	BIRD("bird"),
	CAT("cat"),
	DOG("dog"),
	HAMSTER("hamster"),
	LIZARD("lizard"),
	SNAKE("snake");
	
	private String key;
	private PetType(String key) {
		this.key=key;
	}
	
	public String getKey() {
		return key;
	}
	
	public static PetType getPetType(String in) {
		for (PetType type : PetType.values()) {
			if(type.getKey().equals(in)) {
				return type;
			}
		}
		throw new IllegalArgumentException();
	}
}
