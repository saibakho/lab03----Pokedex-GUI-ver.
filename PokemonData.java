import javax.swing.ImageIcon;

public class PokemonData
{
	public PokemonData(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
		//this.pic = new ImageIcon("pic/" + name + ".png");
		//this.picPath = "pic/" + name + ".png" ;
	}
	public String id;
	public String name;
	public String type;
	//public ImageIcon pic;
	//public String picPath;
}