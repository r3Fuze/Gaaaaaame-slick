package fuze.game.objects.item;

import fuze.game.gfx.Col;
import fuze.game.gfx.Fonts;
import fuze.game.gfx.SimpleFont;

public enum ItemRarity {

    // -f
	COMMON(0, "Common", Col.white),
	UNCOMMON(1, "Uncommon", Col.gray),
	MAGIC(2, "Magic", Col.royalBlue),
	RARE(3, "Rare", Col.yellow),
	UNIQUE(4, "Unique", Col.brown),
	DIVINE(5, "Divine", Col.green),
	MYTHICAL(6, "Mythical", Col.red),

	QUEST(10, "Quest", Col.cyan, Fonts.basicItalic),
	CURRENCY(11, "Currency", Col.red),

	DEBUG(32, "Debug", Col.red); // +f

    public int        id;
    public String     name;
    public Col        color = Col.white;

    public SimpleFont font;

    private ItemRarity(int id, String name, Col color, SimpleFont font) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.font = font;
    }

    private ItemRarity(int id, String name, Col color) {
        this(id, name, color, Fonts.basic);
    }

    private ItemRarity(int id, String name) {
        this(id, name, Col.white);
    }

}
