package movieTheme;

public class Title {

	String title = "drawtext";
	String fontt = "=fontfile=/Windows/Fonts/";
	String font = "gulim.ttc";
	String textt = ":text=";
	String text = "input a text";
	String fontcolort = ":fontfolor=";
	String fontcolor = "white";
	String fontsizet = ":fontsize=";
	String fontsize = "50";
	String boxt = ":box=";
	String box = "1";
	String boxcolort = ":boxcolor=";
	String boxcolor = "black";
	String boxborderwt = ":boxborderw=";
	String boxborderw = "5";
	String xt = ":x=";
	String x = "(w-text_w)/2";
	String yt = ":y=";
	String y = "(h-text_h)/2";
	
	public Title() {	}

	public Title(String title, String fontt, String textt, String fontcolort, String fontsizet, String boxt,
			String boxcolort, String boxborderwt, String xt, String yt) {
		super();
		this.title = title;
		this.fontt = fontt;
		this.textt = textt;
		this.fontcolort = fontcolort;
		this.fontsizet = fontsizet;
		this.boxt = boxt;
		this.boxcolort = boxcolort;
		this.boxborderwt = boxborderwt;
		this.xt = xt;
		this.yt = yt;
	}

	public Title(String title, String fontt, String font, String textt, String text, String fontcolort,
			String fontcolor, String fontsizet, String fontsize, String boxt, String box, String boxcolort,
			String boxcolor, String boxborderwt, String boxborderw, String xt, String x, String yt, String y) {
		super();
		this.title = title;
		this.fontt = fontt;
		this.font = font;
		this.textt = textt;
		this.text = text;
		this.fontcolort = fontcolort;
		this.fontcolor = fontcolor;
		this.fontsizet = fontsizet;
		this.fontsize = fontsize;
		this.boxt = boxt;
		this.box = box;
		this.boxcolort = boxcolort;
		this.boxcolor = boxcolor;
		this.boxborderwt = boxborderwt;
		this.boxborderw = boxborderw;
		this.xt = xt;
		this.x = x;
		this.yt = yt;
		this.y = y;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFontcolor() {
		return fontcolor;
	}

	public void setFontcolor(String fontcolor) {
		this.fontcolor = fontcolor;
	}

	public String getFontsize() {
		return fontsize;
	}

	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	public String getBoxcolor() {
		return boxcolor;
	}

	public void setBoxcolor(String boxcolor) {
		this.boxcolor = boxcolor;
	}

	public String getBoxborderw() {
		return boxborderw;
	}

	public void setBoxborderw(String boxborderw) {
		this.boxborderw = boxborderw;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Title [title=" + title + ", fontt=" + fontt + ", font=" + font + ", textt=" + textt + ", text=" + text
				+ ", fontcolort=" + fontcolort + ", fontcolor=" + fontcolor + ", fontsizet=" + fontsizet + ", fontsize="
				+ fontsize + ", boxt=" + boxt + ", box=" + box + ", boxcolort=" + boxcolort + ", boxcolor=" + boxcolor
				+ ", boxborderwt=" + boxborderwt + ", boxborderw=" + boxborderw + ", xt=" + xt + ", x=" + x + ", yt="
				+ yt + ", y=" + y + "]";
	}
	
	
	
}
