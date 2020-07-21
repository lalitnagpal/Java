package com.java.examples;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		String version;
		Computer computer = new Computer();
		SoundCard soundCard = null;
		USB usb = null;
		
//		The below code for null checks won't be required now with the use of Optional		
//		if (computer != null) {
//			soundCard = computer.getSoundCard();
//			if (soundCard != null) {
//				usb = soundCard.getUsb();
//				if (usb != null ) {
//					version = usb.getVersion();
//				}
//			}
//		}
		
		// Creating a optional of a given value. Value is wrapped in a Optional now
		String name = "lalit";
		Optional<String> value = Optional.of(name);
		
		// To create a empty Optional
		Optional<Integer> emptyOptional = Optional.empty();
		
		// To create a nullable optional value
		Optional<String> nullable = Optional.ofNullable( name );
		Optional<String> emptyValue = Optional.ofNullable( null );
		
		// Getting back the value from a Optional
		String name2 = value.get();
		System.out.println(name2);
		
		// Never use a get method on a Optional - results in a java.util.NoSuchElementException
		Optional<String> emptyOptionalValue = Optional.empty();
		try {
			System.out.println( emptyOptionalValue.get() );
		} catch (NoSuchElementException e) {
			System.out.println(e.getClass().getName() + ": " +e.getMessage());
		}
		
		if (emptyOptionalValue.isPresent()) {
			System.out.println(emptyOptionalValue);
		}
		
		// orElse - invoke this on a variable containing a value and it prints the value
		String aValue = value.orElse("Got Nothing");
		System.out.println( aValue );
		
		// Invoke this on a empty optional and it prints "Got Nothing"
		String bValue = emptyOptionalValue.orElse("Got Nothing");
		System.out.println( bValue );
		
		// orElseGet method also gets a default value when value not present
		// but, it takes a Supplier
		Integer orElseGetValue = emptyOptional.orElseGet( () -> 100 );
		System.out.println( orElseGetValue );
		
		try {
			// Supply a exception to this one, if you want a exception in case of empty value
			emptyOptionalValue.orElseThrow( () -> new IllegalArgumentException("No arguments"));
		} catch (IllegalArgumentException iAE) {
			System.out.println(iAE.getClass().getName() + ": "  + iAE.getMessage());
		}
		
		try {
			// Overloaded with a orElseThrow in Java 10 that takes nothing and throws a NoSuchElementException
			emptyOptionalValue.orElseThrow();
		} catch (NoSuchElementException e) {
			System.out.println(e.getClass().getName() + ": " +e.getMessage());
		}
	}

}

class Computer {
	private Optional<SoundCard> soundCard;
	public Optional<SoundCard> getSoundCard() {
		return soundCard;
	}
}

class SoundCard {
	private Optional<USB> usb;
	public Optional<USB> getUsb() {
		return usb;
	}
}

class USB {
	private String version;
	public String getVersion() {
		return version;
	}
}