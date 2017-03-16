all: *.java
	javac Pokedex.java PokemonData.java
	jar -cfm Pokedex.jar manifest.mf *.class
	java -jar Pokedex.jar