package fuze.game.gfx;

import java.nio.FloatBuffer;

import org.newdawn.slick.Color;

public class Col {

	public static final Col	transparent	= new Col(0.0f, 0.0f, 0.0f, 0.0f);
	public static final Col	white		= new Col(1.0f, 1.0f, 1.0f, 1.0f);
	public static final Col	yellow		= new Col(1.0f, 1.0f, 0, 1.0f);
	public static final Col	red			= new Col(1.0f, 0, 0, 1.0f);
	public static final Col	blue		= new Col(0, 0, 1.0f, 1.0f);
	public static final Col	green		= new Col(0, 1.0f, 0, 1.0f);
	public static final Col	black		= new Col(0, 0, 0, 1.0f);
	public static final Col	gray		= new Col(0.5f, 0.5f, 0.5f, 1.0f);
	public static final Col	cyan		= new Col(0, 1.0f, 1.0f, 1.0f);
	public static final Col	darkGray	= new Col(0.3f, 0.3f, 0.3f, 1.0f);
	public static final Col	lightGray	= new Col(0.7f, 0.7f, 0.7f, 1.0f);
	public static final Col	pink		= new Col(255, 175, 175, 255);
	public static final Col	orange		= new Col(255, 200, 0, 255);
	public static final Col	magenta		= new Col(255, 0, 255, 255);

	public static final Col	brown		= new Col(150, 75, 0);
	public static final Col	royalBlue	= new Col(0x4169E1);
	public static final Col	darkGreen	= new Col(0x008000);

	public float			r, g, b, a = 1.0f;

	public Col(Color color) {
		r = color.r;
		g = color.g;
		b = color.b;
		a = color.a;
	}

	public Col(java.awt.Color color) {
		r = color.getRed();
		g = color.getGreen();
		b = color.getBlue();
		a = color.getAlpha();
	}

	public Col(FloatBuffer buffer) {
		this.r = buffer.get();
		this.g = buffer.get();
		this.b = buffer.get();
		this.a = buffer.get();
	}

	public Col(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1;
	}

	public Col(float r, float g, float b, float a) {
		this.r = Math.min(r, 1);
		this.g = Math.min(g, 1);
		this.b = Math.min(b, 1);
		this.a = Math.min(a, 1);
	}

	public Col(int r, int g, int b) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = 1;
	}

	public Col(int r, int g, int b, int a) {
		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = a / 255.0f;
	}

	public Col(int value) {
		int r = (value & 0x00FF0000) >> 16;
		int g = (value & 0x0000FF00) >> 8;
		int b = (value & 0x000000FF);
		int a = (value & 0xFF000000) >> 24;

		if (a < 0) a += 256;

		if (a == 0) a = 255;

		this.r = r / 255.0f;
		this.g = g / 255.0f;
		this.b = b / 255.0f;
		this.a = a / 255.0f;
	}

	public Col setAlpha(float a) {
		this.a = a;
		return this;
	}

	public org.newdawn.slick.Color toSlick() {
		return new org.newdawn.slick.Color(r, g, b, a);
	}

	public java.awt.Color toAWT() {
		return new java.awt.Color(r, g, b, a);
	}

}
